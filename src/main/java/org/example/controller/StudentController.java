package org.example.controller;

import org.example.model.Student;
import org.example.service.impl.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {
    @Autowired
    private TeacherServiceImpl service;

    @RequestMapping("/update-self-student")
    @ResponseBody
    Student updateSingleStudent(@RequestBody Student student){
        return service.updateSingleStudent(student);
    }

}
