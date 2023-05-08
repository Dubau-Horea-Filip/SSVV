package org.example;
import domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.testng.Assert;
import repository.NotaXMLRepository;
import repository.StudentXMLRepository;
import repository.TemaXMLRepository;
import service.Service;
import validation.*;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import domain.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class IncrementalIntegrationTests {
    @Mock
    private StudentXMLRepository studentXMLRepo;

    @Mock
    private StudentValidator studentValidator;

    @Mock
    private TemaXMLRepository temaXMLRepo;

    @Mock
    private TemaValidator temaValidator;

    @Mock
    private NotaXMLRepository notaXMLRepo;

    @Mock
    private NotaValidator notaValidator;

    @InjectMocks
    private Service service;



    @Test
    public void studentGiven_addStudent_studentAdded() {
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
    public void saveAssignment() {
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
    public void saveGrade() {
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
