package com.taller.ProyectoJPAHibernate.service;

import com.taller.ProyectoJPAHibernate.model.Employee;
import com.taller.ProyectoJPAHibernate.repository.IEmployeeJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    IEmployeeJpaRepository iEmployeeJpaRepository;


    public Optional<Employee> obtenerEmpleadoPorId( Long id){

        return iEmployeeJpaRepository.findById(id);
    }

    /**
     * Guarda empleado en base de datos
     * @param employee :  recibe empleado a guardar con todos sus datos
     * @return : retorna empleado guardado
     */
    public Employee guardarEmpleado(Employee employee){

        iEmployeeJpaRepository.save(employee);
        return employee;
    }


}
