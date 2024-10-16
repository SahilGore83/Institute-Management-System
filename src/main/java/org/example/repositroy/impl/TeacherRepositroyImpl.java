package org.example.repositroy.impl;

import org.example.model.Student;

import java.util.List;

public interface TeacherRepositroyImpl {
    void insertSingleStudent(Student student);
    Student selectSingleStudent(int rollNo);

    Student updateSingleStudent(Student student);

    List<Student> selectAllStudent();

    Boolean deleteSingleStudent(int rollNo);

    Boolean deleteAllStudent();
}
