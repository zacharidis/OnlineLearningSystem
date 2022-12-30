package com.zacharidis.onlinelearningsystem.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import javax.annotation.processing.Generated;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="course_id",nullable = false)
    private Long courseId;
    // non-nullable

    @Basic
    @Column(name = "course_name",nullable = false ,length = 45)
    private String courseName;

    @Basic
    @Column (name = "course_duration",nullable = false,length = 45)
    private String courseDuration;
    @Basic
    @Column (name = "course_description",nullable = false,length = 64)
    private String courseDescription;

    // can be taught by 1 instructor
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_id",referencedColumnName = "instructor_id",nullable = false)
    private Instructor instructor;

    @ManyToMany(fetch = FetchType.LAZY )
    @JoinTable(name="enrolled_in",
    joinColumns = {@JoinColumn(name = "course_id")}, inverseJoinColumns = {@JoinColumn(name="student_id")})
    private Set<Student> students = new HashSet<>();


    public Course() {
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseDuration='" + courseDuration + '\'' +
                ", courseDescription='" + courseDescription + '\'' +
                '}';
    }

    public Course(String courseName, String courseDuration, String courseDescription, Instructor instructor) {
        this.courseName = courseName;
        this.courseDuration = courseDuration;
        this.courseDescription = courseDescription;
        this.instructor = instructor;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(courseId, course.courseId) && Objects.equals(courseName, course.courseName) && Objects.equals(courseDuration, course.courseDuration) && Objects.equals(courseDescription, course.courseDescription);
    }


    // helper method
    public void assignStudentToCourse(Student student) {
        this.students.add(student);
        student.getCourses().add(this);

    }

    public  void removeStudentFromCourse(Student student){
        this.students.remove(student);
        student.getCourses().remove(this);
    }



    @Override
    public int hashCode() {
        return Objects.hash(courseId, courseName, courseDuration, courseDescription);
    }
}
