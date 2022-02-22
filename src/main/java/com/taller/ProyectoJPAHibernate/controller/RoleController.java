package com.taller.ProyectoJPAHibernate.controller;

import com.taller.ProyectoJPAHibernate.model.Role;
import com.taller.ProyectoJPAHibernate.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

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
    public Role crearRol(@RequestBody Role role){
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

    /**
     * Buscar el rol por id
     * return : retorna el role tipo Role
     */
    @GetMapping(path = "/{id}")
    public Optional<Role> buscarPorId(@PathVariable("id") Long id){
        return this.roleService.obtenerPorId(id);
    }

    /**
     * Eliminar rol
     * @param id : id del rol a eliminar
     * @return : retorna mensaje para confirmar eliminacion del rol
     */
    @DeleteMapping(path = "/{id}")
    public String eliminarRolPorId(@PathVariable("id") Long id){
        boolean eliminado = this.roleService.eliminarRol(id);

        if(eliminado){
            return "Rol eliminado correctamente" ;
        }else

            return "El Rol no se elimino";
    }


}
