package com.example.eea_part1.Controller;

import com.example.eea_part1.DTO.*;
import com.example.eea_part1.Model.*;
import com.example.eea_part1.Model.Module;
import com.example.eea_part1.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AdminController {

    private final UserService userservice; //create UserService Object

    private final BatchService batchservice; //create Batch Service object

    private final ModuleService moduleservice; //create ModuleService object

    private final TimetableService timetableService; //create TimetableService object

    private final ClassroomService classroomService; //create classroomService object


    @Autowired
    public AdminController(UserService userservice, BatchService batchservice, ModuleService moduleservice, TimetableService timetableService, ClassroomService classroomService) {
        this.userservice = userservice;
        this.batchservice = batchservice;
        this.moduleservice = moduleservice;
        this.timetableService = timetableService;
        //Constructor for the variables
        this.classroomService = classroomService;
    }

//=========================User Functions===========================

    //-------------------------View All The Users-------------------------

    @GetMapping(path = "/ViewUsers")
    public String getViewUsers(Model m) {
        List<User> allUsers = userservice.getAllUsers();
        //Calling the list of users
        m.addAttribute("user", allUsers);
        //Binding list and send the data to the JSP
        return "ViewUsers";
    }

    //-------------------------Directing to the Add User Page-------------------------

    @GetMapping("/createUser")
    public String RegisterUser(Model model) {
        model.addAttribute("AddUsers", new UserDTO());
        //Binding the form fields of JSP to Object
        return "/AddUser";
    }

    //-------------------------Add User to the System-------------------------
    @PostMapping("/AddUser")
    public String addUser(@ModelAttribute("AddUsers") UserDTO userdto, Model model) {
        try{
            User user = userservice.createUser(userdto);
            //Takes in the bound data from the JSP
            if(user == null){
                model.addAttribute("error","Email exists in the System");
                //Binding error message
            }
            else{
            model.addAttribute("success","User Added Successfully");
            //Binding success message
                }
        }catch (Exception e){
            model.addAttribute("error","Failed To Add User");
            //Binding error message for exceptions
        }
        return "AddUser";
    }

    //-------------------------Directing to the Update User Page-------------------------

    @GetMapping("/updateUser/{UserEmail}")
    public String UpdateUser(@PathVariable(value = "UserEmail") String UserEmail, Model user) {
        User userInfo = userservice.GetUserEmail(UserEmail);
        //Getting the email of the clicked record
        List<BatchDTO> batchdto = moduleservice.getBatchList();
        //Calling the list of batches
        user.addAttribute("listBatch", batchdto);
        //Binds the list to JSP
        user.addAttribute("UserDetails", userInfo);
        //Binds the values of the clicked record to JSP
        user.addAttribute("UpdateUser", new UserDTO());
        //Binding the form fields of JSP to the Object
        return "UpdateUser";
    }

    //-------------------------Updating the User-------------------------

    @PostMapping("/AdminUpdateUser")
    public String updateUser(@ModelAttribute("UpdateUser") UserDTO userdto, Model model) {
        try{
            userservice.updateUser(userdto);
            //Takes the bound data from the JSP
            model.addAttribute("success", "Successfully Updated The User");
            //Binds the success message
        }catch(Exception e){
            model.addAttribute("error", "Failed To Update The User");
            //Binds the error message for exceptions
        }

        return "/UpdateUser";
    }

    //-------------------------Delete the User from the System-------------------------

    @RequestMapping("/deleteUser/{UserID}")
    public String deleteBatch(@PathVariable(name = "UserID") User userID, Model model) {
        try{
            userservice.deleteUser(userID);
            //Sends in the request to delete the record of the given user ID
            model.addAttribute("success","User Was Successfully Deleted");
            //Binds success message
        }catch(Exception e){
            model.addAttribute("error","Failed To Delete The User");
            //Binds error message
        }
        return "redirect:/ViewBatches";
    }

//=========================Module Functions=========================

    //-------------------------View Modules-------------------------

    @GetMapping(path = "/ViewModules")
    public String getViewModules(Model m) {
        List<Module> allModules = moduleservice.getAllModules();
        //Calling the list of Modules
        m.addAttribute("module", allModules);
        //Binds the list to the JSP
        return "ViewModules";
    }

    //-------------------------Directing to Add Module Page-------------------------

    @GetMapping("/createModule")
    public String RegisterModule(Model model) {
        List<BatchDTO> batchdto = moduleservice.getBatchList();
        //Calling the list of batches
        List<UserDTO> userdto = userservice.getAllLecturersToList();
        //Calling the list of lecturers
        model.addAttribute("listLecturer", userdto);
        model.addAttribute("listBatch", batchdto);
        //Binds the lists to JSP
        model.addAttribute("AddModules", new ModuleDTO());
        //Binds the form fields of JSP to the Object
        return "AddModule";
    }

    //-------------------------Add Module to the System-------------------------

    @PostMapping("/AddModule")
    public String addModule(@ModelAttribute("AddModules") ModuleDTO moduledto, Model model) {
        try{
            moduleservice.createModule(moduledto);
            //Takes in the Bound Values
            model.addAttribute("success", "Module Created Successfully");
            //Binds success message
        }catch(Exception e){
            model.addAttribute("error", "Something Went Wrong, Please Try Again");
            //Binds error message
        }

        return "AddModule";
    }

    //-------------------------Directing To the Update Module Page-------------------------

    @GetMapping("/updateModule/{ModuleID}")
    public String UpdateModule(@PathVariable(value = "ModuleID") String ModuleID, Model module, Model model) {
        Module moduleInfo = moduleservice.GetModuleID(ModuleID);
        //Getting the Module ID of the clicked record
        List<BatchDTO> batchdto = moduleservice.getBatchList();
        //Calling the list of Batches
        List<UserDTO> userdto = userservice.getAllLecturersToList();
        //Calling the list of lecturers
        model.addAttribute("listLecturer", userdto);
        model.addAttribute("listBatch", batchdto);
        //Bind the lists to the JSP
        module.addAttribute("ModuleDetails", moduleInfo);
        //Binding the values of the clicked module record to the JSP
        module.addAttribute("UpdateModule", new ModuleDTO());
        //Binds the fields of the JSP to the Object
        return "/UpdateModule";
    }

    //-------------------------Update Module-------------------------

    @PostMapping("/AdminUpdateModule")
    public String updateModule(@ModelAttribute("UpdateModule")ModuleDTO moduledto, Model model){
        try{
            moduleservice.updateModule(moduledto);
            //Takes the bound values from JSP
            model.addAttribute("success", "Successfully Updated The Module");
            //Bind success message
        }catch(Exception e){
            model.addAttribute("error", "Failed To Update The Module");
            //Bind error message for exceptions
        }

        return "/UpdateModule";
    }

    //-------------------------Delete Module from the System-------------------------

    @RequestMapping("/deleteModule/{ModuleID}")
    public String deleteModule(@PathVariable(name = "ModuleID") Module ModuleID, Model model) {
        try{
            moduleservice.deleteModule(ModuleID);
            //Sends the request to delete the record of the clicked module ID
            model.addAttribute("success", "Module Was Successfully Deleted");
            //Binds the success message
        }catch(Exception e){
            model.addAttribute("error", "Failed to Delete Module");
            //Binds the error message for exceptions
        }
        return "redirect:/ViewModules";
    }


//=========================Batch Functions==========================

    //-------------------------View All Batches-------------------------

    @GetMapping(path = "/ViewBatches")
    public String getViewBatches(Model m) {
        List<Batch> allBatches = batchservice.getAllBatches();
        //Calling list of Batches
        m.addAttribute("batch", allBatches);
        //Binds the list to JSP
        return "ViewBatches";
    }

    //-------------------------Directing To the Add Batch Page-------------------------

    @GetMapping("/createBatch")
    public String RegisterBatch(Model model) {
        model.addAttribute("AddBatches", new BatchDTO());
        //Binds the form fields to the JSP
        return "AddBatch";
    }

    //-------------------------Add Batch to the System-------------------------

    @PostMapping("/AdminAddBatch")
    public String addBatch(@ModelAttribute("AddBatches") BatchDTO batchdto, Model model) {
        try{
            batchservice.createBatch(batchdto);
            //Takes in the data from the Bound fields
            model.addAttribute("success", "Batch Created Successfully");
            //Bind success message
        }catch (Exception e){
            model.addAttribute("error", "Couldn't Add Batch");
            //Bind error message for exceptions
        }

        return "AddBatch";
    }

    //-------------------------Directing To Update Batch Page-------------------------

    @GetMapping("/updateBatch/{BatchId}")
    public String UpdateBatch(@PathVariable(value = "BatchId") int batchId, Model batch) {
        BatchDTO batchInfo = batchservice.GetBatchID(batchId);
        //Getting the Batch ID of the clicked record
        batch.addAttribute("BatchDetails", batchInfo);
        //Binding the values of the clicked record to the JSP
        batch.addAttribute("UpdateBatch", new BatchDTO());
        //Binds the form fields of JSP to the Object
        return "/UpdateBatch";
    }

    //-------------------------Updating the Batch-------------------------

    @PostMapping("/AdminUpdateBatch")
    public String updateBatch(@ModelAttribute("UpdateBatch") BatchDTO batchdto, Model model) {
        try{
            batchservice.updateBatch(batchdto);
            //Takes in the data from the bound fields
            model.addAttribute("success", "Successfully Updated The Batch");
            //Bind success message
        }
        catch(Exception e){
            model.addAttribute("error", "Failed To Update The Batch");
            //Bind error message
        }

        return "/UpdateBatch";
    }

    //-------------------------Delete Batch from the System-------------------------

    @RequestMapping("/deleteBatch/{BatchID}")
    public String deleteBatch(@PathVariable(name = "BatchID") Batch batchID, Model model) {
        try{
            batchservice.deleteBatch(batchID);
            //Sends request to delete the record of the clicked batch ID
            model.addAttribute("success","Batch Was Successfully Deleted");
            //Bind success message
        }catch(Exception e){
            model.addAttribute("error","Failed To Delete The Batch");
            //Bind error message
        }
        return "redirect:/ViewBatches";
    }

//=========================Lecture Functions========================

    //-------------------------View Modules To Schedule Lecture-------------------------

    @GetMapping(path = "/ViewBatchesForSchedule")
    public String getViewModulesForSchedule(Model m) {
        List<Module> allModules = moduleservice.getAllModules();
        //Calling the list of Modules
        m.addAttribute("module", allModules);
        //Binds the list to JSP
        return "ViewBatchForSchedule";
    }

    //-------------------------Directing To Schedule Lecture-------------------------

    @GetMapping("/ScheduleClass/{ModuleID}")
    public String ScheduleClass(@PathVariable(value = "ModuleID") String ModuleId, Model timetable) {
        Module moduleInfo = moduleservice.GetModuleID(ModuleId);
        //Getting the module ID of the clicked record
        List<BatchDTO> batchdto = moduleservice.getBatchList();
        //Calling the list of batches
        List<ModuleDTO>moduleDto = timetableService.getModuleList();
        List<ClassroomDTO>classroomDTO = timetableService.getClassroomList();
        //Calling the list of Classrooms
        timetable.addAttribute("ModuleDetails", moduleInfo);
        //Binds the module details of clicked record to the JSP
        timetable.addAttribute("listBatch", batchdto);
        timetable.addAttribute("listModule", moduleDto);
        timetable.addAttribute("listClassroom", classroomDTO);
        //Binds the lists to JSP
        timetable.addAttribute("AddTimetables", new TimetableDTO());
        //Binds the form fields of JSP to object
        return "ScheduleClass";
    }

    //-------------------------Scheduling a Lecture-------------------------

    @PostMapping("/AdminScheduleClass")
    public String Schedule(@ModelAttribute("AddTimetables") TimetableDTO timetableDTO, Model model) {
       try{
           timetableService.scheduleAClass(timetableDTO);
           //Takes in the data from the bound fields
           model.addAttribute("success", "Lecture Scheduled Successfully");
           //Bind success message
       }catch(Exception e){
           model.addAttribute("error", "Failed To Schedule Lecture");
           //Bind error message
       }

        return "ScheduleClass";
    }

    //-------------------------View Time Table-------------------------

    @GetMapping(path = "/viewTimeTable")
    public String getViewTimeTable(Model model) {
        List<Timetable> allTimetables = timetableService.getAllTimetables();
        //Calling the list of lectures
        model.addAttribute("timetable", allTimetables);
        //Binds the list to JSP
        return "viewTimeTable";
    }

    //-------------------------Directing To Reschedule Lecture Page-------------------------

    @GetMapping("/RescheduleClass/{TimetableID}")
    public String Reschedule(@PathVariable(value = "TimetableID") String TimetableID, Model timetable) {
        Timetable timetableInfo = timetableService.GetTimetableID(TimetableID);
        //Getting the timetable ID from the clicked record
        List<ClassroomDTO>classroomDTO = timetableService.getClassroomList();
        //Calling the list of Classrooms
        timetable.addAttribute("listClassroom", classroomDTO);
        timetable.addAttribute("TimetableDetails", timetableInfo);
        //Binds lists to the JSP
        timetable.addAttribute("RescheduleClass", new TimetableDTO());
        //Binds the form fields of JSP to the Object
        return "/RescheduleClass";
    }

    //-------------------------Reschedule Lecture-------------------------

    @PostMapping("/AdminReschedule")
    public String Reschedule(@ModelAttribute("RescheduleClass") TimetableDTO timetableDTO, Model model) {
        try{
            timetableService.updateTimetable(timetableDTO);
            //Takes in the data from the bound fields
            model.addAttribute("success", "Lecture Rescheduled Successfully");
            //Binds the success message
        }catch(Exception e){
            model.addAttribute("error", "Failed To Reschedule Lecture");
            //Binds the error message for exceptions
        }

        return "RescheduleClass";
    }

    //-------------------------Delete lecture-------------------------

    @RequestMapping("/deleteLecture/{TimetableID}")
    public String cancelSchedule(@PathVariable(name = "TimetableID") Timetable timetableID, Model model) {
        try{
            timetableService.cancelLecture(timetableID);
            //Sends the request to delete the record of the clicked timetable ID
            model.addAttribute("success","Lecture Was Cancelled Successfully");
            //Binds the success message
        }catch(Exception e){
            model.addAttribute("error","Failed To Cancel Lecture");
            //Binds the error message
        }
        return "redirect:/viewTimeTable";
    }


//=========================Classroom Functions========================

    //-------------------------Direct to Add Classroom Page-------------------------

    @GetMapping("/createClassroom")
    public String RegisterClassroom(Model model) {
        model.addAttribute("AddClassrooms", new ClassroomDTO());
        //Binds the form fields to the JSP
        return "AddClassroom";
    }

    //-------------------------Add Classroom-------------------------

    @PostMapping("/AdminAddClassroom")
    public String addClassroom(@ModelAttribute("AddClassrooms") ClassroomDTO classroomDTO, Model model) {
        try{

            Classroom classroom = classroomService.createClassroom(classroomDTO);
            if(classroom == null) {
                model.addAttribute("errors", "Classroom exists in the System");
            }
            else {
                //Takes in the data from the Bound fields
                model.addAttribute("success", "Classroom Created Successfully");
                //Bind success message
            }
        }catch (Exception e){
            model.addAttribute("error", "Failed to Add Classroom");
            //Bind error message for exceptions
        }

        return "AddClassroom";
    }

    //-------------------------Directing to View All Classrooms-------------------------

    @GetMapping(path = "/ViewClassrooms")
    public String getViewClassrooms(Model model) {
        List<Classroom> allClassrooms = classroomService.getAllClassrooms();
        //Calling list of Classrooms
        model.addAttribute("classrooms", allClassrooms);
        //Binds the list to JSP
        return "ViewClassrooms";
    }

    //-------------------------Directing to Update Classroom Page-------------------------

    @GetMapping("/updateClassroom/{ClassroomId}")
    public String UpdateClassroom(@PathVariable(value = "ClassroomId") String classroomId, Model model) {
        ClassroomDTO classroomInfo = classroomService.GetClassroomID(classroomId);
        //Getting the Batch ID of the clicked record
        model.addAttribute("ClassroomDetails", classroomInfo);
        //Binding the values of the clicked record to the JSP
        model.addAttribute("UpdateClassroom", new ClassroomDTO());
        //Binds the form fields of JSP to the Object
        return "/UpdateClassroom";
    }

    //-------------------------Updating the Classroom-------------------------

    @PostMapping("/AdminUpdateClassroom")
    public String updateBatch(@ModelAttribute("UpdateClassroom") ClassroomDTO classroomDTO, Model model) {
        try{
            classroomService.updateClassroom(classroomDTO);
            //Takes in the data from the bound fields
            model.addAttribute("success", "Successfully Updated The Classroom");
            //Bind success message
        }
        catch(Exception e){
            model.addAttribute("error", "Failed To Update The Classroom");
            //Bind error message
        }

        return "/UpdateClassroom";
    }

    //-------------------------Delete Classroom from the System-------------------------

    @RequestMapping("/deleteClassroom/{ClassroomId}")
    public String deleteClassroom(@PathVariable(name = "ClassroomId")Classroom classroomId, Model model) {
        try{
            classroomService.deleteClassroom(classroomId);
            //Sends request to delete the record of the clicked batch ID
            model.addAttribute("success","Batch Was Successfully Deleted");
            //Bind success message
        }catch(Exception e){
            model.addAttribute("error","Failed To Delete The Batch");
            //Bind error message
        }
        return "redirect:/ViewClassrooms";
    }

    //-------------------------Admin Account-------------------------

    @GetMapping("/getAdminAccount/")
    public String getAdminAccount(Model model, Authentication authentication){
        User user = userservice.getUserByUserId(authentication.getName());
        //Get the user Id of the logged in user
        model.addAttribute("adminUpdate", user);
        //Binding the values of the user's details to the JSP
        model.addAttribute("getUser",user);
        //Binding the form fields of JSP to Object
        return "AdminMyAccount";
    }

    //-------------------------Updating Lecturer Account----------------------------

    @PostMapping("/AdminUpdateAdmin")
    public String updateLecturer(@ModelAttribute("AdminUpdate") UserDTO userdto, Model model) {
        try{
            userservice.updateUser(userdto);
            //Takes the bound data from the JSP
            model.addAttribute("success", "Successfully Updated Your Account");
            //Binding success message
        }catch(Exception e){
            model.addAttribute("error", "Failed To Update Your Account");
            //Binding error message for exceptions
        }
        return "/AdminHome";
    }

    //-------------------------Directing To Today Lectures-------------------------


    @GetMapping("/ViewTodayTimetable")
    public String getTodayLecturesAdmin(Model model, Authentication authentication){
        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);

        List<Timetable> timetables = timetableService.getTodayTimetable(date);
        //Making a list by selecting all the lectures that has the user's email
        model.addAttribute("timetables", timetables);
        //Binding the list to JSP
        return "TodayTimetable";
    }

    //-------------------------User Search----------------------------

    @GetMapping("/SearchUserName")
    public String getUserSearchRequest(HttpServletRequest request, Model model){
        String name = request.getParameter("searchName");
        List<User> allUsers = userservice.getAllUserSearch(name);

        model.addAttribute("user", allUsers);
        return "ViewUsers";
    }

    //-------------------------User Search----------------------------

    @GetMapping("/SearchBatchName")
    public String getBatchSearchRequest(HttpServletRequest request, Model model){
        String searchItem = request.getParameter("searchItem");
        List<Batch> allBatches = batchservice.getBatchSearch(searchItem);

        model.addAttribute("batch", allBatches);
        return "ViewBatches";
    }

//    @GetMapping("/ViewUsers")
//    public String getSearchUsers(String name, Model model, User user){
////        List<User> allUsers = userservice.getAllUserSearch(user);
//        //Calling the list of users
//        model.addAttribute("user", allUsers);
//        //Binding list and send the data to the JSP
//
//        return"ViewUsers";
//    }

}
