package org.example;

import domain.Student;
import domain.Tema;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import repository.StudentXMLRepository;
import repository.TemaXMLRepository;
import service.Service;
import validation.StudentValidator;
import validation.TemaValidator;
import validation.ValidationException;
import validation.Validator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TemaTests {



    private Validator<Tema> temaValidator = new TemaValidator();
    private TemaXMLRepository temaRepository = new TemaXMLRepository(temaValidator, "teme.xml");
    private Service service = new Service(null, temaRepository, null);

    @Test
    public void ValidTema() {
        int response = service.saveTema("99", "test", 12, 6);
        assertEquals(0, response);
    }

    @Test
    public void InvalidTemaDeadline() {
        int response = service.saveTema("99", "test", 20, 6);
        assertEquals(1, response);
    }

    @Test
    public void AddAssignmentIdNull() {
        int response = service.saveTema(null, "Descrption1", 8, 6);
        assertEquals(1, response);
    }

    @Test
    public void AddAssignmentDescriptionNull() {
        int response = service.saveTema("A1", null, 15, 5);
        assertEquals(1, response);
    }

    @Test
    public void AddAssignmentDescriptionEmpty() {
        int response = service.saveTema("A1", "", 7, 5);
        assertEquals(1, response);
    }

    @Test
    public void AddAssignmentDeadline15() {


        int response = service.saveTema("A1", "Descrption1", 15, 5);
        assertEquals(1, response);

    }

    @Test
    public void AddAssignmentReceivingWeek0() {

        int response = service.saveTema("A1", "Descrption1", 7, 0);
        assertEquals(1, response);

    }
}
