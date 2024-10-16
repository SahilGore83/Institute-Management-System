package org.example.controller;
import org.example.model.Admin;
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
public class AdminController {
    @Autowired
    private AdminServiceImpl service;

    @Autowired
    private ManagementServiceImpl mservice;

    @Autowired
    private TeacherServiceImpl tservice;

    @RequestMapping("/insert-single-management")
    @ResponseBody
    void insertSingleManagement(@RequestBody Management management){
        service.insertSingleManagement(management);
    }

    @RequestMapping("/insert-multiple-management")
    @ResponseBody
    void insertMultipleManagement(@RequestBody List<Management> managementsList) {
        service.insertMultipleManagement(managementsList);
    }

    @RequestMapping("/select-single-management")
    @ResponseBody
    Management selectSingleManagement(@RequestParam int id)  {
        return service.selectSingleManagement(id);
    }

    @RequestMapping("/select-multiple-management")
    @ResponseBody
    List<Management> selectMultipleManagement(@RequestParam List<Integer> ids) {
        return service.selectMultipleManagement(ids);
    }


    @RequestMapping("/update-single-management")
    @ResponseBody
    Management updateSingleManagement(@RequestBody Management management){
        return service.updateSingleManagement(management);
    }

    @RequestMapping("/update-multiple-management")
    @ResponseBody
    List<Management> updateMultipleManagement(@RequestBody List<Management> managementList){
        return service.updateMultipleManagement(managementList);
    }

    @RequestMapping("/select-all-management")
    @ResponseBody
    List<Management> selectAllManagement(){
        return service.selectAllManagement();
    }
    @RequestMapping("/delete-single-management")
    @ResponseBody
    Boolean deleteSingleManagement(@RequestParam int id){
        return service.deleteSingleManagement(id);
    }

    @RequestMapping("/delete-multiple-management")
    @ResponseBody
    Boolean deleteMultipleManagement(@RequestParam List<Integer> ids){
        return service.deleteMultipleManagement(ids);
    }
    @RequestMapping("/delete-all-management")
    @ResponseBody
    Boolean deleteAllManagement(){
        return service.deleteAllManagement();
    }



    @RequestMapping("/insert-single-admin")
    @ResponseBody
    void insertSingleAdmin(@RequestBody Admin admin) {
        service.insertSingleAdmin(admin);
    }

    @RequestMapping("/insert-multiple-admin")
    @ResponseBody
    void insertMultipleAdmin(@RequestBody List<Admin> adminsList) {
        service.insertMultipleAdmin(adminsList);
    }

    @RequestMapping("/select-single-admin")
    @ResponseBody
    Admin selectSingleAdmin(@RequestParam int id)  {
        return service.selectSingleAdmin(id);
    }

    @RequestMapping("/select-multiple-admin")
    @ResponseBody
    List<Admin> selectMultipleAdmin(@RequestParam List<Integer> ids) {
        return service.selectMultipleAdmin(ids);
    }


    @RequestMapping("/update-single-admin")
    @ResponseBody
    Admin updateSingleAdmin(@RequestBody Admin admin){
        return service.updateSingleAdmin(admin);
    }

    @RequestMapping("/update-multiple-admin")
    @ResponseBody
    List<Admin> updateMultipleAdmin(@RequestBody List<Admin> adminList){
        return service.updateMultipleAdmin(adminList);
    }

    @RequestMapping("/select-all-admin")
    @ResponseBody
    List<Admin> selectAllAdmin(){
        return service.selectAllAdmin();
    }
    @RequestMapping("/delete-single-admin")
    @ResponseBody
    Boolean deleteSingleAdmin(@RequestParam int id){
        return service.deleteSingleAdmin(id);
    }

    @RequestMapping("/delete-multiple-admin")
    @ResponseBody
    Boolean deleteMultipleAdmin(@RequestParam List<Integer> ids){
        return service.deleteMultipleAdmin(ids);
    }
    @RequestMapping("/delete-all-admin")
    @ResponseBody
    Boolean deleteAllAdmin(){
        return service.deleteAllAdmin();
    }

    @RequestMapping("/insert-single-teacher_admin")
    @ResponseBody
    void insertSingleTeacher(@RequestBody Teacher teacher) {
        mservice.insertSingleTeacher(teacher);
    }

    @RequestMapping("/insert-multiple-teacher_admin")
    @ResponseBody
    void insertMultipleTeacher(@RequestBody List<Teacher> teachersList) {
        mservice.insertMultipleTeacher(teachersList);
    }

    @RequestMapping("/select-single-teacher_admin")
    @ResponseBody
    Teacher selectSingleteacher(@RequestParam int id)  {
        return mservice.selectSingleTeacher(id);
    }

    @RequestMapping("/select-multiple-teacher_admin")
    @ResponseBody
    List<Teacher> selectMultipleTeacher(@RequestParam List<Integer> ids) {
        return mservice.selectMultipleTeacher(ids);
    }


    @RequestMapping("/update-single-teacher_admin")
    @ResponseBody
    Teacher updateSingleteacher(@RequestBody Teacher teacher){
        return mservice.updateSingleTeacher(teacher);
    }

    @RequestMapping("/update-multiple-teacher_admin")
    @ResponseBody
    List<Teacher> updateMultipleTeacher(@RequestBody List<Teacher> teacherList){
        return mservice.updateMultipleTeacher(teacherList);
    }

    @RequestMapping("/select-all-teacher_admin")
    @ResponseBody
    List<Teacher> selectAllTeacher(){
        return mservice.selectAllTeacher();
    }
    @RequestMapping("/delete-single-teacher_admin")
    @ResponseBody
    Boolean deleteSingleTeacher(@RequestParam int id){
        return mservice.deleteSingleTeacher(id);
    }

    @RequestMapping("/delete-multiple-teacher_admin")
    @ResponseBody
    Boolean deleteMultipleTeacher(@RequestParam List<Integer> ids){
        return mservice.deleteMultipleTeacher(ids);
    }
    @RequestMapping("/delete-all-teacher_admin")
    @ResponseBody
    Boolean deleteAllTeacher(){
        return mservice.deleteAllTeacher();
    }


    @RequestMapping("/insert-single-student_admin")
    @ResponseBody
    void insertSingleStudent(@RequestBody Student student) {
        tservice.insertSingleStudent(student);
    }

    @RequestMapping("/insert-multiple-student_admin")
    @ResponseBody
    void insertMultipleStudent(@RequestBody List<Student> studentsList) {
        tservice.insertMultipleStudent(studentsList);
    }

    @RequestMapping("/select-single-student_admin")
    @ResponseBody
    Student selectSingleStudent(@RequestParam int rollNo)  {
        return tservice.selectSingleStudent(rollNo);
    }

    @RequestMapping("/select-multiple-student_admin")
    @ResponseBody
    List<Student> selectMultipleStudent(@RequestParam List<Integer> rollNos) {
        return tservice.selectMultipleStudent(rollNos);
    }


    @RequestMapping("/update-single-student_admin")
    @ResponseBody
    Student updateSingleStudent(@RequestBody Student student){
        return tservice.updateSingleStudent(student);
    }

    @RequestMapping("/update-multiple-student_admin")
    @ResponseBody
    List<Student> updateMultipleStudent(@RequestBody List<Student> studentList){
        return tservice.updateMultipleStudent(studentList);
    }

    @RequestMapping("/select-all-student_admin")
    @ResponseBody
    List<Student> selectAllStudent() {
        return tservice.selectAllStudent();
    }
    @RequestMapping("/delete-single-student_admin")
    @ResponseBody
    Boolean deleteSingleStudent(@RequestParam int rollNo){
        return tservice.deleteSingleStudent(rollNo);
    }

    @RequestMapping("/delete-multiple-student_admin")
    @ResponseBody
    Boolean deleteMultipleStudent(@RequestParam List<Integer> rollNos){
        return tservice.deleteMultipleStudent(rollNos);
    }
    @RequestMapping("/delete-all-student_admin")
    @ResponseBody
    Boolean deleteAllStudent(){
        return tservice.deleteAllStudent();
    }
}
