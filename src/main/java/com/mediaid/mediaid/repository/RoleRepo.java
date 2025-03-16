package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {
    Role findByRoleId(int id);
}
