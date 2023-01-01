package com.zacharidis.onlinelearningsystem.dao;

import com.zacharidis.onlinelearningsystem.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long> {


    Role findRoleByName(String name);



}
