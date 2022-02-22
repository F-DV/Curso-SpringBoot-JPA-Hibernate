package com.taller.ProyectoJPAHibernate.controller;

import com.taller.ProyectoJPAHibernate.model.Role;
import com.taller.ProyectoJPAHibernate.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    /**
     * Guarda rol
     * @param role : guarda rol que ingresa
     * @return : devuelve el mismo rol que ingresa
     */
    @PostMapping()
    public Role guardarRol(@RequestBody Role role){
        return this.roleService.guardarRol(role);
    }

    /**
     * Metodo que devuelve una lista de los roles existentes en base de datos en servidor
     * @return : Retornamos una lista con los roles exitentes
     */
    @GetMapping
    public ArrayList<Role> traeRoles(){
        return roleService.obtieneRoles();
    }
}
