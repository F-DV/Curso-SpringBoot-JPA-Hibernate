package com.taller.ProyectoJPAHibernate.controller;

import com.taller.ProyectoJPAHibernate.model.Project;
import com.taller.ProyectoJPAHibernate.model.Role;
import com.taller.ProyectoJPAHibernate.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/proyecto")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    /**
     * Crea proyecto
     * @param project : guarda project que ingresa
     * @return : devuelve el mismo project que ingresa
     */
    @PostMapping()
    public Project crearProyecto(@RequestBody Project project){
        return this.projectService.creaProyecto(project);
    }

    /**
     * Metodo que devuelve una lista de los proyectos  existentes en base de datos
     * @return : Retornamos una lista con los proyectos exitentes
     */
    @GetMapping
    public ArrayList<Project> traeProyectos() {
        return projectService.listaProyectos();
    }
    /**
     * Eliminar Proyecto
     * @param id : id del proyecto a eliminar
     * @return : retorna mensaje para confirmar eliminacion del proyecto
     */
    @DeleteMapping(path = "/{id}")
    public String eliminarProyectoPorId(@PathVariable("id") Long id){
        boolean eliminado = this.projectService.eliminarProyecto(id);

        if(eliminado){
            return "Proyecto eliminado correctamente" ;
        }else

            return "El Proyecto no se elimino";
    }
}
