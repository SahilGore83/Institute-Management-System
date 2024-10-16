package org.example.service;

import org.example.model.Student;
import org.example.repositroy.impl.TeacherRepositroyImpl;
import org.example.service.impl.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService implements TeacherServiceImpl {
        @Autowired
        private TeacherRepositroyImpl repositroy;
    @Override
    public void insertSingleStudent(Student student) {
            repositroy.insertSingleStudent(student);
    }

    @Override
    public void insertMultipleStudent(List<Student> studentList){
            for (int i=0; i<studentList.size();i++) {
                repositroy.insertSingleStudent(studentList.get(i));
            }
    }

    @Override
    public Student selectSingleStudent(int rollNo){
       return repositroy.selectSingleStudent(rollNo);
    }

    @Override
    public List<Student> selectMultipleStudent(List<Integer> rollNos) {
        List<Student> studentList = new ArrayList<>();
        for (int i=0; i<rollNos.size(); i++){
           studentList.add(repositroy.selectSingleStudent(rollNos.get(i)));
        }
        return studentList;
    }


    @Override
    public Student updateSingleStudent(Student student){
            return repositroy.updateSingleStudent(student);
    }

    @Override
    public List<Student> updateMultipleStudent(List<Student> studentList){
        List<Student> studentList1 = new ArrayList<>();
        for (int i=0;i<studentList.size();i++){
            studentList1.add(repositroy.updateSingleStudent(studentList.get(i)));
        }
        return studentList1;
    }

        @Override
        public List<Student> selectAllStudent() {
            return repositroy.selectAllStudent();
        }

    @Override
    public Boolean deleteSingleStudent(int rollNo) {
        return repositroy.deleteSingleStudent(rollNo);
    }

    @Override
    public Boolean deleteMultipleStudent(List<Integer> rollNos) {
        List<Boolean> resultList = new ArrayList<>();
        Boolean result = false;
        for(int i=0; i<rollNos.size();i++){

           resultList.add(repositroy.deleteSingleStudent(rollNos.get(i)));
        }
        if ( resultList.contains(true) ){
            result=true;
        }
       return result;
    }

    @Override
    public Boolean deleteAllStudent() {
       return repositroy.deleteAllStudent();
    }

}
