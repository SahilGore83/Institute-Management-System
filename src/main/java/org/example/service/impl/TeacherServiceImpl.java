package org.example.service.impl;

import org.example.model.Student;

import java.util.List;

public interface TeacherServiceImpl {
    void insertSingleStudent(Student student);
    void insertMultipleStudent(List<Student> studentsList);
    Student selectSingleStudent(int rollNo);
    List<Student> selectMultipleStudent(List<Integer> rollNos);

    Student updateSingleStudent(Student student);

    List<Student> updateMultipleStudent(List<Student> studentList);

    List<Student> selectAllStudent();

    Boolean deleteSingleStudent(int rollNo);

    Boolean deleteMultipleStudent( List<Integer> rollNos);

    Boolean deleteAllStudent();

}