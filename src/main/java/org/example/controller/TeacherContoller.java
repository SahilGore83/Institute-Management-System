package org.example.controller;

import org.example.model.Student;
import org.example.model.Teacher;
import org.example.service.impl.ManagementServiceImpl;
import org.example.service.impl.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TeacherContoller {
    @Autowired
    private TeacherServiceImpl service; //object decleration

    @Autowired
    private ManagementServiceImpl mservice;

    @RequestMapping("/insert-single-student")
    @ResponseBody
    void insertSingleStudent(@RequestBody Student student) {
        service.insertSingleStudent(student);
    }

    @RequestMapping("/insert-multiple-student")
    @ResponseBody
    void insertMultipleStudent(@RequestBody List<Student> studentsList) {
        service.insertMultipleStudent(studentsList);
    }

    @RequestMapping("/select-single-student")
    @ResponseBody
    Student selectSingleStudent(@RequestParam int rollNo)  {
        return service.selectSingleStudent(rollNo);
    }

    @RequestMapping("/select-multiple-student")
    @ResponseBody
   List<Student> selectMultipleStudent(@RequestParam List<Integer> rollNos) {
        return service.selectMultipleStudent(rollNos);
    }


    @RequestMapping("/update-single-student")
    @ResponseBody
    Student updateSingleStudent(@RequestBody Student student){
        return service.updateSingleStudent(student);
    }

    @RequestMapping("/update-multiple-student")
    @ResponseBody
    List<Student> updateMultipleStudent(@RequestBody List<Student> studentList){
        return service.updateMultipleStudent(studentList);
    }

    @RequestMapping("/select-all-student")
    @ResponseBody
    List<Student> selectAllStudent(){
       return service.selectAllStudent();
    }
    @RequestMapping("/delete-single-student")
    @ResponseBody
    Boolean deleteSingleStudent(@RequestParam int rollNo){
        return service.deleteSingleStudent(rollNo);
    }

    @RequestMapping("/delete-multiple-student")
    @ResponseBody
    Boolean deleteMultipleStudent(@RequestParam List<Integer> rollNos){
            return service.deleteMultipleStudent(rollNos);
    }
    @RequestMapping("/delete-all-student")
    @ResponseBody
    Boolean deleteAllStudent(){
        return service.deleteAllStudent();
    }

    @RequestMapping("/update-self-teacher")
    @ResponseBody
    Teacher updateSingleTeacher(@RequestBody Teacher teacher) {
        return mservice.updateSingleTeacher(teacher);
    }
}