package com.taller.ProyectoJPAHibernate.service;

import com.taller.ProyectoJPAHibernate.model.Role;
import com.taller.ProyectoJPAHibernate.repository.IroleJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    IroleJpaRepository iroleJpaRepository;

    /**
     * Guarda rol usando el metodo de la interface JpaRepository
     * @param role : ingresa rol a guardar
     * @return : retorna el mismo rol iungresado
     */
    public Role guardarRol(Role role) {
        return iroleJpaRepository.save(role);
    }

    /**
     * Declaramos metodo que busca todos los roles en la base de datos,
     * los guara en un arrayList y los devuelve
     * @return :  Array de roles
     */
    public ArrayList<Role> obtieneRoles(){
        return (ArrayList<Role>) iroleJpaRepository.findAll();
    }

    /**
     * Obtener role por id
     * Return : retorna role que encuentra por id
     */
    public Optional<Role> obtenerPorId(Long id){
        return iroleJpaRepository.findById(id);
    }

    /**
     *
     * @param id :  del rol a eliminar
     * @return Retorna verdadero si elimina y falso si no elimina el Rol
     */
    public boolean eliminarRol(long id){
        try{
            iroleJpaRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

}
