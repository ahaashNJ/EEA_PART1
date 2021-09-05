package com.example.eea_part1.Controller;

import com.example.eea_part1.DTO.UserDTO;
import com.example.eea_part1.Model.Timetable;
import com.example.eea_part1.Model.User;
import com.example.eea_part1.Service.TimetableService;
import com.example.eea_part1.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public class StudentController {

    @Autowired
    private final TimetableService timetableService;

    public StudentController(TimetableService timetableService) {
        this.timetableService = timetableService;
    }

    @Autowired
    public UserService userservice;

    @GetMapping("/StudentHome")
    public String getStudentHome(Model model, Authentication authentication){
        List<Timetable> timetables = timetableService.getStudentTimetable(userservice.getUserByUserId(authentication.getName()).getBatchId());
        model.addAttribute("timetables", timetables);
        return "LecturerHome";
    }

    @GetMapping("/getStudentHome/")
    public String getStudentAccount(Model model, Authentication authentication){
        User user = userservice.getUserByUserId(authentication.getName());
        model.addAttribute("studentUpdate", user);
        model.addAttribute("getUser",user);
        return "studentAccount";
    }

    @PostMapping("/StudentUpdateUser")
    public String updateStudent(@ModelAttribute("studentUpdate") UserDTO userdto, Model model) {
        try{
            userservice.updateUser(userdto);
            model.addAttribute("success", "Successfully Updated Your Account");
        }catch(Exception e){
            model.addAttribute("error", "Failed To Update Your Account");
        }

        return "/studentAccount";
    }
}
