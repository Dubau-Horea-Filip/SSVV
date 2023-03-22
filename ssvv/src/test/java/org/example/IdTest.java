package org.example;

import domain.Student;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Assert;
import org.junit.Test;
import repository.StudentXMLRepository;
import service.Service;
import validation.StudentValidator;
import validation.Validator;



public class IdTest {
    Validator<Student> studentValidator = new StudentValidator();
    StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
    Service service = new Service(fileRepository1, null, null);

    @Test
    public void ValidIdTest( )
    {
        String id = "68";
        int response =service.saveStudent(id,"Jana",888);
        Assert.assertEquals(0, response);

    }

    @Test
    public void InValidIdTest( )
    {
        String id = "-65";
        int response =service.saveStudent(id,"ana",768);
        Assert.assertEquals(1, response);

    }


}
