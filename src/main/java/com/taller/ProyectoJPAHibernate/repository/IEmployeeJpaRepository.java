package com.taller.ProyectoJPAHibernate.repository;

import com.taller.ProyectoJPAHibernate.model.Employee;
import com.taller.ProyectoJPAHibernate.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeJpaRepository extends JpaRepository<Employee, Long> {

    /**
     * Select fiels from employee where employee Id = "[param]"
     * Hibernate Implement the interface
     * @param employee
     * @return : Type Employee
     */
    Employee findByEmployeeId(String employee);

    /**
     * Pretende buscar por apellido ingresado
     * @param lastName : String de apellifo
     * @return Lista con apellidos
     */
    List<Employee> findbyeLastName(String lastName);

    /**
     *
     * @param role : recibe objeto de tipo Role a buscar
     * @return : Retorna lista que concuerda con ese rol ingresado
     */
    List<Employee> findByRole(Role role);
}
