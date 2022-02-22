package com.taller.ProyectoJPAHibernate.model;

import javax.persistence.*;

@Entity
public class Role {

    /**
     * En esta entidad configuramos el id que se auto genera y el nombre del role
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 15,nullable = false,unique = true)
    private String name;

    /**
     * Constructor Vacio
     */
    public Role() {
    }

    /**
     * Constructor con el nombre del role
     * @param name : Strin nombre del Role
     */
    public Role(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", firstName='" + name + '\'' +
                '}';
    }
}
