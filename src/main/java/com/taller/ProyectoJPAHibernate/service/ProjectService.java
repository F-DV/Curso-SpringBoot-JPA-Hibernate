package com.taller.ProyectoJPAHibernate.service;

import com.taller.ProyectoJPAHibernate.model.Project;
import com.taller.ProyectoJPAHibernate.model.Role;
import com.taller.ProyectoJPAHibernate.repository.IProjectJpaRepository;
import com.taller.ProyectoJPAHibernate.repository.IroleJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    IProjectJpaRepository iProjectJpaRepository;

    /**
     * Guarda rol usando el metodo de la interface JpaRepository
     * @param project: ingresa rol a guardar
     * @return : retorna el mismo rol iungresado
     */
    public Project creaProyecto(Project project) {
        return iProjectJpaRepository.save(project);
    }

    /**
     * Declaramos metodo que busca todos los proyectos en la base de datos,
     * los guara en un arrayList y los devuelve
     * @return :  Array de proyectos en base de datos
     */
    public ArrayList<Project> listaProyectos(){
        return (ArrayList<Project>) iProjectJpaRepository.findAll();
    }

    /**
     *
     * @param id :  del proyecto a eliminar
     * @return Retorna verdadero si elimina y falso si no elimina el proyecto
     */
    public boolean eliminarProyecto(long id){
        try{
            iProjectJpaRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
