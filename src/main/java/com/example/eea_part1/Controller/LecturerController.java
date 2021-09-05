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

public class LecturerController {

    @Autowired
    private final TimetableService timetableService;

    @Autowired
    public UserService userservice;

    public LecturerController(TimetableService timetableService) {
        this.timetableService = timetableService;
    }

    @GetMapping("/LecturerHome")
    public String getLecturerHome(Model model, Authentication authentication){
        List<Timetable> timetables = timetableService.getLectureTimetable(userservice.getUserByUserId(authentication.getName()).getEmail());
        model.addAttribute("timetables", timetables);
        return "LecturerHome";
    }

    @GetMapping("/getLecturerHome/")
    public String getLecturerAccount(Model model, Authentication authentication){
        User user = userservice.getUserByUserId(authentication.getName());
        model.addAttribute("lecturerUpdate", user);
        model.addAttribute("getUser",user);
        return "lecturerAccount";
    }

    @PostMapping("/LecturerUpdateUser")
    public String updateLecturer(@ModelAttribute("lecturerUpdate") UserDTO userdto, Model model) {
        try{
            userservice.updateUser(userdto);
            model.addAttribute("success", "Successfully Updated Your Account");
        }catch(Exception e){
            model.addAttribute("error", "Failed To Update Your Account");
        }

        return "/lecturerAccount";
    }
}
