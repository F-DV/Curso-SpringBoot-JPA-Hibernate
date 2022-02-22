package com.taller.ProyectoJPAHibernate.repository;

import com.taller.ProyectoJPAHibernate.controller.EmployeeController;
import com.taller.ProyectoJPAHibernate.model.Employee;
import com.taller.ProyectoJPAHibernate.model.Project;
import com.taller.ProyectoJPAHibernate.model.Role;
import com.taller.ProyectoJPAHibernate.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;

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
    private IEmployeeJpaRepository repoEmpl;



    private IroleJpaRepository repoRole;

    @Autowired
    private IProjectJpaRepository repoProj;


    @Test
    public void saveEmployee(){

        Role admin = new Role("ROLE_ADMIN");
        Role dev = new Role("ROLE_DEV");


        admin = repoRole.save(admin);
        dev = repoRole.save(dev);

        Project proj1 = new Project("proj1");
        Project proj2 = new Project("proj2");
        Project proj3 = new Project("proj3");

        proj1 = repoProj.save(proj1);
        proj2 = repoProj.save(proj2);
        proj3 = repoProj.save(proj3);


        Employee john = new Employee("John", "Smith", "empl123",admin);
        Employee claire = new Employee("Claire", "Simpson", "empl124",dev);



        john.getProjects().add(proj1);
        john.getProjects().add(proj2);

        claire.getProjects().add(proj1);
        claire.getProjects().add(proj2);
        claire.getProjects().add(proj3);

        repoEmpl.save(john);
        repoEmpl.save(claire);

        repoEmpl.flush();

        Employee empl124 = repoEmpl.findByEmployeeId("empl124");

        assertEquals("Claire",empl124.getFirstName());
        assertEquals(2,repoEmpl.findAll().size());
        assertEquals(dev,empl124.getRole());


    }


}