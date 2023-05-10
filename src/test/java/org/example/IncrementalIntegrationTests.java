package org.example;
import domain.*;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import repository.NotaXMLRepository;
import repository.StudentXMLRepository;
import repository.TemaXMLRepository;
import service.Service;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import domain.Student;
import org.junit.jupiter.api.Test;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class IncrementalIntegrationTests {
    //org.example.IncrementalIntegrationTests
    @Mock
    private TemaXMLRepository temaXMLRepo;

    @Mock
    private StudentXMLRepository studentXMLRepo;

    @Mock
    private StudentValidator studentValidator;

    @Mock
    private TemaValidator temaValidator;

    @Mock
    private NotaXMLRepository notaXMLRepo;

    @Mock
    private NotaValidator notaValidator;

    private Service service;

 @BeforeEach
 public void setuo()
 {
     MockitoAnnotations.initMocks(this);
     service = new Service(studentXMLRepo,temaXMLRepo,notaXMLRepo);
 }


    @Test
    public void saveStudentTest() {
        //org.example.IncrementalIntegrationTests.saveStudentTest
        // given
        Student student = new Student("1", "Filip", 933);
        when(studentXMLRepo.save(ArgumentMatchers.any(Student.class))).thenReturn(null);

        // when
        int studentAdded = service.saveStudent("1", "Filip", 933);

        // then
        Assert.assertEquals(1, studentAdded);
        verify(studentXMLRepo).save(ArgumentMatchers.any(Student.class));
    }



    @Test
    public void saveAssignmentTest() {
        Student student = new Student("2", "Anda", 933);
        when(studentXMLRepo.save(ArgumentMatchers.any(Student.class))).thenReturn(null);

        Tema tema = new Tema("2", "assignment1", 2, 1);
        when(temaXMLRepo.save(ArgumentMatchers.any(Tema.class))).thenReturn(null);

        // when
        int studentAdded = service.saveStudent("2", "Anda", 933);
        int temaAdded = service.saveTema("2", "assignment1", 2, 1);

        // then
        Assert.assertEquals(1, studentAdded);
        verify(studentXMLRepo).save(ArgumentMatchers.any(Student.class));
        Assert.assertEquals(1, temaAdded);
        verify(temaXMLRepo).save(ArgumentMatchers.any(Tema.class));
    }

    @Test
    public void saveGradeTest() {
        Student student = new Student("2", "Anda", 933);
        when(studentXMLRepo.save(ArgumentMatchers.any(Student.class))).thenReturn(null);

        Tema tema = new Tema("2", "assignment1", 2, 1);
        when(temaXMLRepo.save(ArgumentMatchers.any(Tema.class))).thenReturn(null);

        Nota nota = new Nota(new Pair<>(student.getID(),tema.getID()) ,7, 5,"good");
        when(notaXMLRepo.save(ArgumentMatchers.any(Nota.class))).thenReturn(null);

        when(studentXMLRepo.findOne(student.getID())).thenReturn(student);
        when(temaXMLRepo.findOne(tema.getID())).thenReturn(tema);


        // when
        int studentAdded = service.saveStudent("2", "Anda", 933);
        int temaAdded = service.saveTema("2", "assignment1", 2, 1);
        int notaAdded = service.saveNota(student.getID(),tema.getID() ,7, 5,"good");

        // then
        Assert.assertEquals(1, studentAdded);
        Assert.assertEquals(1, temaAdded);
        Assert.assertEquals(1, notaAdded);

        verify(studentXMLRepo).save(ArgumentMatchers.any(Student.class));
        verify(temaXMLRepo).save(ArgumentMatchers.any(Tema.class));
        verify(notaXMLRepo).save(ArgumentMatchers.any(Nota.class));
    }


}
