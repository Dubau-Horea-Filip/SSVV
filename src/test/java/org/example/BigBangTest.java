package org.example;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.testng.Assert;
import repository.NotaXMLRepository;
import repository.StudentXMLRepository;
import repository.TemaXMLRepository;
import service.Service;
import validation.*;

public class BigBangTest {
    StudentValidator studentValidator = new StudentValidator();
    TemaValidator temaValidator = new TemaValidator();

    StudentXMLRepository studentRepo = new StudentXMLRepository(studentValidator, "studenti.xml");
    TemaXMLRepository temaRepo = new TemaXMLRepository(temaValidator, "teme.xml");

    NotaValidator notaValidator = new NotaValidator();
    NotaXMLRepository noteRepo = new NotaXMLRepository(notaValidator,"Note.xml");

    Service service = new Service(studentRepo, temaRepo, noteRepo);

    @Test
    public void saveStudent( )
    {
        int response =service.saveStudent("13","ValidNameTest",933);
        Assert.assertEquals(0, response);
    }

    @Test
    public void saveAssignment() {

        int response =service.saveTema("A5","Description",6,4);
        Assert.assertEquals(0, response);

        //Assertions.assertNull(service.saveTema("A5", "Description", 6, 4));

        //Assertions.assertNotNull(service.deleteTema("A5"));
    }

    @Test
    public void saveGrade() {

        int response = service.saveNota("N1", "632", 2, 7, "Good");
        Assert.assertEquals(-1, response); //-1 means bad

//
//        Assertions.assertThrows(ValidationException.class, () -> {
//            service.saveNota("N1", "632", 2, 7, "Good");

  //      });
    }

    @Test
    public void saveAll() {

        int response =service.saveStudent("13","ValidNameTest",933);
        Assert.assertEquals(0, response);

         response =service.saveTema("try1","Description",6,4);
        Assert.assertEquals(0, response);

         response = service.saveNota("1", "try1", 2, 7, "Good");
        Assert.assertEquals(0, response); //-1 means bad


  }
}