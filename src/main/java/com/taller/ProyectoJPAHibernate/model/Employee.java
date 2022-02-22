package com.taller.ProyectoJPAHibernate.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Empleado")
public class Employee {

    /**
     * @GeneratedValue(strategy = GenerationType.AUTO) : Autoincremente cada que se crea un id
     * nullable = false : indica campo no null
     * unique = true : Indica campo unico
     * @ManyToOne(optional = false) : Indica que esta tabla instanciad a ssera uno a muchos
     *@JoinColumn(name = "id_role" : especifica la foreing key de la tabla Role
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 25,nullable = false)
    private String firstName;

    @Column(length = 25,nullable = false)
    private String lastName;

    @Column(length = 10,nullable = false, unique = true)
    private String employeeId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_role")
    private Role role;

    /**
     * Tabla intermedia de muchos a muchos, la cual tendra las dos foreing key de
     * employee y project
     */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_project",
            joinColumns = { @JoinColumn(name = "employee_id") },
            inverseJoinColumns = { @JoinColumn(name = "project_id")})
    private List<Project> projects = new ArrayList<Project>();


    public Employee() {
    }

    public Employee(String firstName, String lastName, String employeeId,Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeId = employeeId;
        this.role = role;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id.equals(employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", employeeId='" + employeeId + '\'' +
                '}';
    }
}
