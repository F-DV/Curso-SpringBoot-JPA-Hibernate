package com.taller.ProyectoJPAHibernate.repository;

import com.taller.ProyectoJPAHibernate.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class IEmployeeJpaRepositoryTest {
/**
 * @DataJpaTest :  le indico que solo realizer test para Jpa
 * AutoConfigureTestDatabase :
 * private IEmployeeJpaRepository repo;  :Inyectamos implementacion de repository
 *  repo.flush(); : inserta los empleados de inmediato
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