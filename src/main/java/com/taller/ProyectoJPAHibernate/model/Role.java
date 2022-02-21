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
    private String firstName;

    /**
     * Constructor Vacio
     */
    public Role() {
    }

    /**
     * Constructor con el nombre del role
     * @param firstName : Strin nombre del Role
     */
    public Role(String firstName) {
        this.firstName = firstName;
    }

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
        return "Role{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
