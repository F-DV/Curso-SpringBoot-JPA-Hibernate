package com.taller.ProyectoJPAHibernate.controller;

import com.taller.ProyectoJPAHibernate.model.Employee;
import com.taller.ProyectoJPAHibernate.model.Role;
import com.taller.ProyectoJPAHibernate.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empleados")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    /**
     * Guarda empleado en base de datos
     * @param empleado : recibe empleado a guardar
     * @return : retorna empleado guardado
     */
    @PostMapping(path = "/{role}")
    public Employee guardarEmpleado(@RequestBody Employee empleado,@PathVariable("role") Role role){

        return this.employeeService.guardarEmpleado(empleado);
    }


}
