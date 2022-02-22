package com.taller.ProyectoJPAHibernate.controller;

import com.taller.ProyectoJPAHibernate.model.Employee;
import com.taller.ProyectoJPAHibernate.model.Role;
import com.taller.ProyectoJPAHibernate.service.EmployeeService;
import com.taller.ProyectoJPAHibernate.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/empleados")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    /**
     * Crea y actualiza empleado en base de datos , especificando el id
     * @param empleado: recibe datos de empleado crear o actualizar
     * @return : retorna empleado creado o actualizado
     */
    @PostMapping()
    public Employee actualizaEmpleado(@RequestBody Employee empleado){
        return this.employeeService.guardarEmpleado(empleado);
    }

    /**
     * Obtener a todos los empleados de de la base de datos
     * @return : ArrayList de todos los empleados
     */
    @GetMapping("/traeEmpleados")
    public ArrayList<Employee> obtenerTodos(){
        return employeeService.traeTodos();
    }

    /**
     * Busca usuario ingresandole el id, en el servicio
     * @param id : id del usuario a buscar
     * @return: el empleado que corresponde a ese id ingresado
     */
    @GetMapping(path = "/{id}")
    public Optional<Employee> obtenerPorId(@PathVariable("id") Long id){
        return this.employeeService.obtenerEmpleadoPorId(id);
    }

    /**
     * Metodo para eliminar empleado por id
     * @param id : el id del empleado a eliminar
     * @return: retorna mensae de confirmacion o negacion de eliminacion
     */
    @DeleteMapping(path = "/{id}")
    public String eliminarEmpleadopPorId(@PathVariable("id") Long id){
       boolean eliminado = this.employeeService.eliminarEmpleado(id);

       if(eliminado){
           return "Empleado eliminado correctamente" ;
       }else

            return "El empleado no se elimino";
    }





}
