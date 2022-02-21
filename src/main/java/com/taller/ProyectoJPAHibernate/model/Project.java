package com.taller.ProyectoJPAHibernate.model;

import javax.persistence.*;

@Entity
public class Project {
    /**
     * En esta entidad configuramos el id que se auto genera y el nombre del project
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 15,nullable = false,unique = true)
    private String firstName;

    /**
     * Constructor vacio
     */
    public Project() {
    }

    /**
     * Constructor que pide inicializar el nombre del project
     */
    public Project(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Generamos Getter and setters de los atributos de la entidad
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
