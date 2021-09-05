package com.example.eea_part1.Controller;

import com.example.eea_part1.DTO.UserDTO;
import com.example.eea_part1.Model.Batch;
import com.example.eea_part1.Model.Module;
import com.example.eea_part1.Model.Timetable;
import com.example.eea_part1.Model.User;
import com.example.eea_part1.Service.ModuleService;
import com.example.eea_part1.Service.TimetableService;
import com.example.eea_part1.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Calendar;
import java.util.List;

@Controller
public class AuthenticationController {

    @Autowired
    private final TimetableService timetableService; //Creating Timetable Object

    public AuthenticationController(TimetableService timetableService) {
        this.timetableService = timetableService; //Constructor for Timetable
    }

    @GetMapping("/Home")
    public String getLogin() {
        return "Home";
    } //Login page

    @GetMapping("/AdminHome")
    public String getAdminHome(){return "AdminHome";} //Admin page

    @Autowired
    public UserService userservice; //Creating userService object

    @Autowired
    public ModuleService moduleService; //Creating modulesService object


//-------------------------Role Based Login---------------------------
    @GetMapping("/SuccessLogin")
    public String successLogin(Authentication auth){
        User usertype = userservice.directUserType(auth.getName());
        //Take the user type of the logged in user

        if(usertype.getUserType().equals("Student")){
            return "redirect:/StudentHome";
            //Directs to the student home page if the user is student
        }
        if(usertype.getUserType().equals("Lecturer")){
            return "redirect:/LecturerHome";
            //Directs to the lecturer home page if the user is lecturer
        }
        if(usertype.getUserType().equals("Admin")){
            return "redirect:/AdminHome";
            //Directs to the admin home page if the user is admin
        }
        return "/viewTimeTable";
    }

//=========================Lecturer Functions==========================

    //-------------------------Directing To Lecturer Home-------------------------

    @GetMapping("/LecturerHome")
    public String getLecturerHome(Model model, Authentication authentication){
        List<Timetable> timetables = timetableService.getLectureTimetable(userservice.getUserByUserId(authentication.getName()).getEmail());
        //Making a list by selecting all the lectures that has the user's email
        model.addAttribute("timetables", timetables);
        //Binding the list to JSP
        return "LecturerHome";
    }

    //-------------------------Directing To Lecturer Account-------------------------

    @GetMapping("/getLecturerHome/")
    public String getLecturerAccount(Model model, Authentication authentication){
        User user = userservice.getUserByUserId(authentication.getName());
        //Get the user Id of the logged in user
        model.addAttribute("lecturerUpdate", user);
        //Binding the values of the user's details to the JSP
        model.addAttribute("getUser",user);
        //Binding the form fields of JSP to Object
        return "lecturerAccount";
    }

    //-------------------------Updating Lecturer Account----------------------------

    @PostMapping("")
    public String updateLecturer(@ModelAttribute("lecturerUpdate") UserDTO userdto, Model model) {
        try{
            userservice.updateUser(userdto);
            //Takes the bound data from the JSP
            model.addAttribute("success", "Successfully Updated Your Account");
            //Binding success message
        }catch(Exception e){
            model.addAttribute("error", "Failed To Update Your Account");
            //Binding error message for exceptions
        }
        return "/lecturerAccount";
    }

    //-------------------------View Lecturer's Modules----------------------------

    @GetMapping("/LecturerModules")
    public String getLecturerModules(Model model, Authentication authentication){
        List<Module> modules = moduleService.getLectureModules(userservice.getUserByUserId(authentication.getName()).getEmail());
        //Making a list by selecting all the lectures that has the user's email
        model.addAttribute("modules", modules);
        //Binding the list to JSP
        return "LecturerModules";
    }

//=========================Student Functions==========================

    //-------------------------Directing To Student Home-------------------------
    @GetMapping("/StudentHome")
    public String getStudentHome(Model model, Authentication authentication){
        List<Timetable> timetables = timetableService.getStudentTimetable(userservice.getUserByUserId(authentication.getName()).getBatchId());
        //Makes a list by select all the lectures that has the user's batch ID
        model.addAttribute("timetables", timetables);
        //Binding the list to JSP
        return "StudentHome";
    }

    //-------------------------Directing to Student Account----------------------------

    @GetMapping("/getStudentHome/")
    public String getStudentAccount(Model model, Authentication authentication){
        User user = userservice.getUserByUserId(authentication.getName());
        //Get the user Id of the logged in user
        model.addAttribute("studentUpdate", user);
        //Binding the values of the user's details to the JSP
        model.addAttribute("getUser",user);
        //Binding the form fields of JSP to Object
        return "studentAccount";
    }

    //-------------------------Updating Student Account----------------------------

    @PostMapping("/StudentUpdateUser")
    public String updateStudent(@ModelAttribute("studentUpdate") UserDTO userdto, Model model) {
        try{
            userservice.updateUser(userdto);
            //Takes the bound data from the JSP
            model.addAttribute("success", "Successfully Updated Your Account");
            //Binding success message
        }catch(Exception e){
            model.addAttribute("error", "Failed To Update Your Account");
            //Binding error message for exceptions
        }

        return "/studentAccount";
    }

    //-------------------------View Student's Modules----------------------------

    @GetMapping("/StudentModules")
    public String getStudentModules(Model model, Authentication authentication){
        List<Module> modules = moduleService.getStudentModules(userservice.getUserByUserId(authentication.getName()).getBatchId());
        //Makes a list by select all the lectures that has the user's batch ID
        model.addAttribute("modules", modules);
        //Binding the list to JSP
        return "StudentModules";
    }

    //-------------------------View Student's Today Lectures----------------------------

//    @GetMapping("/LecturerHome")
//    public String getTodayLectures(Model model, Authentication authentication){
//        long millis=System.currentTimeMillis();
//        java.sql.Date date=new java.sql.Date(millis);
//        List<Timetable> timetables = timetableService.getTodayTimetable(date);
//        //Making a list by selecting all the lectures that has the user's email
//        model.addAttribute("timetables", timetables);
//        //Binding the list to JSP
//        return "LecturerHome";
//    }

    //-------------------------View Lecturer's Today Lectures----------------------------

    @GetMapping("/ViewTodayLecturerLectures")
    public String getTodayLecturesForLecturer(Model model, Authentication authentication, String email){
        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);

        User user = userservice.getUserByUserId(authentication.getName());
        //List<Timetable> timetables = timetableService.getStudentTimetable(userservice.getUserByUserId(authentication.getName()).getBatchId());

        List<Timetable> timetables = timetableService.getTodayTimetableLecturer(user, date);
        model.addAttribute("timetables", timetables);
        //Binding the list to JSP
        return "LecturerViewTodayLectures";
    }

    @GetMapping("/ViewTodayLecturesToStudent")
    public String getTodayLecturesToStudent(Model model, Authentication authentication, Batch batch){
        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);

        List<Timetable> timetables = timetableService.getTodayTimetableStudent(userservice.getUserByUserId(authentication.getName()).getBatchId(), date);
        model.addAttribute("timetables", timetables);
        return "StudentHome";
    }

}
