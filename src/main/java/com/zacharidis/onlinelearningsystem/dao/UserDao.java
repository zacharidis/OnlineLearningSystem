package com.zacharidis.onlinelearningsystem.dao;

import com.zacharidis.onlinelearningsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
