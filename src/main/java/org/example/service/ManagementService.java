package org.example.service;

import org.example.model.Teacher;
import org.example.repositroy.ManagementRepositroy;
import org.example.repositroy.impl.MangementRepositroyImpl;
import org.example.repositroy.impl.TeacherRepositroyImpl;
import org.example.service.impl.ManagementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

@Service
public class ManagementService implements ManagementServiceImpl {
    @Autowired
    private MangementRepositroyImpl repositroy;
    @Override
    public void insertSingleTeacher(Teacher teacher) {
        repositroy.insertSingleTeacher(teacher);
    }

    @Override
    public void insertMultipleTeacher(List<Teacher> teacherList){
        for (int i=0; i<teacherList.size();i++) {
            repositroy.insertSingleTeacher(teacherList.get(i));
        }
    }

    @Override
    public Teacher selectSingleTeacher(int id){
        return repositroy.selectSingleTeacher(id);
    }

    @Override
    public List<Teacher> selectMultipleTeacher(List<Integer> ids) {
        List<Teacher> teacherList = new ArrayList<>();
        for (int i=0; i<ids.size(); i++){
            teacherList.add(repositroy.selectSingleTeacher(ids.get(i)));
        }
        return teacherList;
    }


    @Override
    public Teacher updateSingleTeacher(Teacher teacher){
        return repositroy.updateSingleTeacher(teacher);
    }

    @Override
    public List<Teacher> updateMultipleTeacher(List<Teacher> teacherList){
        List<Teacher> teacherList1 = new ArrayList<>();
        for (int i=0;i<teacherList.size();i++){
            teacherList1.add(repositroy.updateSingleTeacher(teacherList.get(i)));
        }
        return teacherList1;
    }

    @Override
    public List<Teacher> selectAllTeacher() {
        return repositroy.selectAllTeacher();
    }

    @Override
    public Boolean deleteSingleTeacher(int id) {
        return repositroy.deleteSingleTeacher(id);
    }

    @Override
    public Boolean deleteMultipleTeacher(List<Integer> ids) {
        List<Boolean> resultList = new ArrayList<>();
        Boolean result = false;
        for(int i=0; i<ids.size();i++){

            resultList.add(repositroy.deleteSingleTeacher(ids.get(i)));
        }
        if ( resultList.contains(true) ){
            result=true;
        }
        return result;
    }

    @Override
    public Boolean deleteAllTeacher() {
        return repositroy.deleteAllTeacher();
    }

}
