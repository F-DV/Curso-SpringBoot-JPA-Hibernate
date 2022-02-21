package com.taller.ProyectoJPAHibernate.repository;

import com.taller.ProyectoJPAHibernate.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeJpaRepository extends JpaRepository<Employee, Long> {

    /**
     * Select fiels from employee where employee Id = "[param]"
     * Hibernate Implement the interface
     * @param employee
     * @return : Type Employee
     */
    Employee findByEmployeeId(String employee);
}
