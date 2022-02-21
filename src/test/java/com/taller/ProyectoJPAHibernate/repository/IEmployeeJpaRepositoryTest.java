package com.taller.ProyectoJPAHibernate.repository;

import com.taller.ProyectoJPAHibernate.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
//@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@AutoConfigureTestDatabase (replace = AutoConfigureTestDatabase.Replace.NONE)
class IEmployeeJpaRepositoryTest {
/**
 * @DataJpaTest :  le indico que solo realizer test para Jpa
 * AutoConfigureTestDatabase (replace = AutoConfigureTestDatabase.Replace.NONE) : Utiliza la base de datos mysql para hacer los test
 * @AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)  : utiliza la base de datos embebida para los test
 * private IEmployeeJpaRepository repo;  :Inyectamos implementacion de repository
 * repo.flush(); : inserta los empleados de inmediato
 *
 */
    @Autowired
    private IEmployeeJpaRepository repo;

    @Test
    public void saveEmployee(){
        Employee john = new Employee("John", "Smith", "empl123");
        Employee claire = new Employee("Claire", "Simpson", "empl124");

        repo.save(john);
        repo.save(claire);

        repo.flush();

        assertEquals(2,repo.findAll().size());

    }
}