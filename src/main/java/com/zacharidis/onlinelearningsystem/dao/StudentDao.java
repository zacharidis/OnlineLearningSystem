package com.zacharidis.onlinelearningsystem.dao;

import com.zacharidis.onlinelearningsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentDao extends JpaRepository<Student, Long > {


    @Query(value="select s from Student  as s where s.firstName like %:name% or s.lastName like %:name%")
    List<Student> findStudentsByName(@Param("name") String name);

    @Query(value="select s from Student  as s where s.user.email  =: email")
    List<Student> findStudentByEmail(@Param("email")String email);






}
