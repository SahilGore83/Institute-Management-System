package org.example.service.impl;

import org.example.model.Management;
import org.example.model.Student;
import org.example.model.Teacher;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.text.StyledEditorKit;
import java.util.List;

public interface ManagementServiceImpl {
        void insertSingleTeacher(Teacher teacher);

        void insertMultipleTeacher( List<Teacher> teachersList);

        Teacher selectSingleTeacher(int id);

        List<Teacher> selectMultipleTeacher(List<Integer> ids);

        Teacher updateSingleTeacher(Teacher teacher);

        List<Teacher> updateMultipleTeacher( List<Teacher> teacherList);

        List<Teacher> selectAllTeacher();

        Boolean deleteSingleTeacher( int id);

        Boolean deleteMultipleTeacher( List<Integer> ids);

        Boolean deleteAllTeacher();

}
