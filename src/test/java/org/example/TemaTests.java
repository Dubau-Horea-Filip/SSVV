package org.example;

import domain.Student;
import domain.Tema;
import org.testng.annotations.Test;
import repository.StudentXMLRepository;
import repository.TemaXMLRepository;
import service.Service;
import validation.StudentValidator;
import validation.TemaValidator;
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
}
