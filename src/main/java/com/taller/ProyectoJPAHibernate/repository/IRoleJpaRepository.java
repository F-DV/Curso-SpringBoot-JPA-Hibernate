package com.taller.ProyectoJPAHibernate.repository;

import com.taller.ProyectoJPAHibernate.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleJpaRepository extends JpaRepository<Role,Long> {
}
