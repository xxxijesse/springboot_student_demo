package com.qf.controller;

import com.qf.entity.Student;
import com.qf.service.IStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 这是第一个分支
 */
@Controller
@RequestMapping("/stu")
public class StuController {

    @Autowired
    private IStuService stuService;

    @RequestMapping("/list")
    public String list(Model model){
        List<Student> list = stuService.list();
        model.addAttribute("stus",list);
        return "stulist";
    }

    @RequestMapping("/delete")
    public String delete(Student student){
        stuService.removeById(student.getId());
        return "redirect:/stu/list";
    }

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "add";
    }

    @RequestMapping("/add")
    public String add(Student student){
        stuService.save(student);
        return "index";
    }

    @RequestMapping("/toUpdate")
    public String toUpdate(Student student,Model model){
        Student student1=stuService.getById(student.getId());
        model.addAttribute("student",student1);
        return "update";
    }

    @RequestMapping("update")
    public String update(Student student){
        stuService.updateById(student);
        return "redirect:/stu/list";
    }
}
