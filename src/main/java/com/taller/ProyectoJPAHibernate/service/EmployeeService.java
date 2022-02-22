package com.taller.ProyectoJPAHibernate.service;

import com.taller.ProyectoJPAHibernate.model.Employee;
import com.taller.ProyectoJPAHibernate.model.Role;
import com.taller.ProyectoJPAHibernate.repository.IEmployeeJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    IEmployeeJpaRepository iEmployeeJpaRepository;


    public Optional<Employee> obtenerEmpleadoPorId( Long id){

        return iEmployeeJpaRepository.findById(id);
    }

    /**
     * Crea empleado en base de datos
     * @param employee :  recibe empleado a gcrear con todos sus datos
     * @return : retorna empleado creado
     */
    public Employee guardarEmpleado(Employee employee){

        iEmployeeJpaRepository.save(employee);
        return employee;
    }

    /**
     * Obtiene a todos los empleados de de la base de datos
     * @return : ArrayList de todos los empleados
     */
    public ArrayList<Employee> traeTodos(){
        return (ArrayList<Employee>) iEmployeeJpaRepository.findAll();
    }

    /**
     * Busca usuario ingresandole el id en el repositorio
     * @param id : id del usuario a buscar
     * @return: el empleado que corresponde a ese id ingresado
     */
    public Optional<Employee> obtenerEmpleadoPorId(long id){
        return iEmployeeJpaRepository.findById(id);
    }

    /**
     * Eliminacion de usuario en el repositorio por id
     * @param id  : del empleado a eliminar en el repositorio
     * @return . retorna verdadero o falso si fue eliminado o no el empleado
     */
    public boolean eliminarEmpleado(long id){
        try{
            iEmployeeJpaRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }




}
