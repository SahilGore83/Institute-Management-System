package org.example.controller;

import org.example.model.Management;
import org.example.model.Student;
import org.example.model.Teacher;
import org.example.service.impl.AdminServiceImpl;
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
public class ManagementController {
    @Autowired
    private ManagementServiceImpl service; //object decleration

    @Autowired
    private TeacherServiceImpl tservice;

    @Autowired
    private AdminServiceImpl aservice;

    @RequestMapping("/insert-single-teacher")
    @ResponseBody
    void insertSingleTeacher(@RequestBody Teacher teacher) {
        service.insertSingleTeacher(teacher);
    }

    @RequestMapping("/insert-multiple-teacher")
    @ResponseBody
    void insertMultipleTeacher(@RequestBody List<Teacher> teachersList) {
        service.insertMultipleTeacher(teachersList);
    }

    @RequestMapping("/select-single-teacher")
    @ResponseBody
    Teacher selectSingleteacher(@RequestParam int id)  {
        return service.selectSingleTeacher(id);
    }

    @RequestMapping("/select-multiple-teacher")
    @ResponseBody
    List<Teacher> selectMultipleTeacher(@RequestParam List<Integer> ids) {
        return service.selectMultipleTeacher(ids);
    }


    @RequestMapping("/update-single-teacher")
    @ResponseBody
    Teacher updateSingleteacher(@RequestBody Teacher teacher){
        return service.updateSingleTeacher(teacher);
    }

    @RequestMapping("/update-multiple-teacher")
    @ResponseBody
    List<Teacher> updateMultipleTeacher(@RequestBody List<Teacher> teacherList){
        return service.updateMultipleTeacher(teacherList);
    }

    @RequestMapping("/select-all-teacher")
    @ResponseBody
    List<Teacher> selectAllTeacher(){
        return service.selectAllTeacher();
    }
    @RequestMapping("/delete-single-teacher")
    @ResponseBody
    Boolean deleteSingleTeacher(@RequestParam int id){
        return service.deleteSingleTeacher(id);
    }

    @RequestMapping("/delete-multiple-teacher")
    @ResponseBody
    Boolean deleteMultipleTeacher(@RequestParam List<Integer> ids){
        return service.deleteMultipleTeacher(ids);
    }
    @RequestMapping("/delete-all-teacher")
    @ResponseBody
    Boolean deleteAllTeacher(){
        return service.deleteAllTeacher();
    }

    @RequestMapping("/insert-single-student_management")
    @ResponseBody
    void insertSingleStudent(@RequestBody Student student) {
        tservice.insertSingleStudent(student);
    }

    @RequestMapping("/insert-multiple-student_management")
    @ResponseBody
    void insertMultipleStudent(@RequestBody List<Student> studentsList) {
        tservice.insertMultipleStudent(studentsList);
    }

    @RequestMapping("/select-single-student_management")
    @ResponseBody
    Student selectSingleStudent(@RequestParam int rollNo)  {
        return tservice.selectSingleStudent(rollNo);
    }

    @RequestMapping("/select-multiple-student_management")
    @ResponseBody
    List<Student> selectMultipleStudent(@RequestParam List<Integer> rollNos) {
        return tservice.selectMultipleStudent(rollNos);
    }


    @RequestMapping("/update-single-student_management")
    @ResponseBody
    Student updateSingleStudent(@RequestBody Student student){
        return tservice.updateSingleStudent(student);
    }

    @RequestMapping("/update-multiple-student_management")
    @ResponseBody
    List<Student> updateMultipleStudent(@RequestBody List<Student> studentList){
        return tservice.updateMultipleStudent(studentList);
    }

    @RequestMapping("/select-all-student_management")
    @ResponseBody
    List<Student> selectAllStudent(){
        return tservice.selectAllStudent();
    }
    @RequestMapping("/delete-single-student_management")
    @ResponseBody
    Boolean deleteSingleStudent(@RequestParam int rollNo){
        return tservice.deleteSingleStudent(rollNo);
    }

    @RequestMapping("/delete-multiple-student_management")
    @ResponseBody
    Boolean deleteMultipleStudent(@RequestParam List<Integer> rollNos){
        return tservice.deleteMultipleStudent(rollNos);
    }
    @RequestMapping("/delete-all-student_management")
    @ResponseBody
    Boolean deleteAllStudent(){
        return tservice.deleteAllStudent();
    }

    @RequestMapping("/update-self-management")
    @ResponseBody
    Management updateSingleManagement(@RequestBody Management management) {
        return aservice.updateSingleManagement(management);
    }
}
