package com.taller.ProyectoJPAHibernate.repository;

import com.taller.ProyectoJPAHibernate.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProjectJpaRepository extends JpaRepository<Project , Long> {
}
