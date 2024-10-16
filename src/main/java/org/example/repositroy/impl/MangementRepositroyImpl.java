package org.example.repositroy.impl;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.example.model.Teacher;

import java.util.List;

public interface MangementRepositroyImpl {

    void insertSingleTeacher(Teacher teacher);

    Teacher selectSingleTeacher(int id);

    Teacher updateSingleTeacher(Teacher teacher);

    List<Teacher> selectAllTeacher();

    Boolean  deleteSingleTeacher(int id);

    Boolean deleteAllTeacher();
}
