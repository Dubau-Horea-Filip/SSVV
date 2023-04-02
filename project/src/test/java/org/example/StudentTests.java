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



public class StudentTests {
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

    @Test
    public void ValidGroupTest( )
    {
        int group = 933;
        int response =service.saveStudent("11","Jana",group);
        Assert.assertEquals(0, response);

    }

    @Test
    public void InValidGroupTest( )
    {
        int group = -65;
        int response =service.saveStudent("12","ana",group);
        Assert.assertEquals(1, response);

    }

    @Test
    public void InValidNameTest( )
    {
        String name = "";
        int response =service.saveStudent("10",name,768);
        Assert.assertEquals(1, response);

    }

    @Test
    public void ValidNameTest( )
    {
        String name = "Anda";
        int response =service.saveStudent("11",name,768);
        Assert.assertEquals(1, response);

    }


}
