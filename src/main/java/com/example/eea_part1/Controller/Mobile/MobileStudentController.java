package com.example.eea_part1.Controller.Mobile;

import com.example.eea_part1.DTO.*;
import com.example.eea_part1.Model.*;
import com.example.eea_part1.Model.Module;
import com.example.eea_part1.Service.ModuleService;
import com.example.eea_part1.Service.TimetableService;
import com.example.eea_part1.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/student")
@RestController
public class MobileStudentController {

    @Autowired
    public TimetableService timetableService;

    @Autowired
    public UserService userService;

    @Autowired
    public ModuleService moduleService;

    @GetMapping("/todayStudentLectures")
    public ResponseEntity<?> viewTodayStudentLectures(Authentication authentication) {

        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);

        List<Timetable> timetables = timetableService.getTodayTimetableStudent(userService.getUserByUserId(authentication.getName()).getBatchId(), date);

        List<TimetableDTO> list = new ArrayList<>();
        for (Timetable timetable : timetables) {
            TimetableDTO timetableDTO = new TimetableDTO();
            ClassroomDTO classroomDTO = new ClassroomDTO();
            ModuleDTO moduleDTO = new ModuleDTO();

            timetableDTO.setTimetableDate(timetable.getDate().toString());
            timetableDTO.setStartTime(timetable.getStartTime().toString());
            timetableDTO.setEndTime(timetable.getEndTime().toString());
            classroomDTO.setClassroomId(timetable.getClassroom().getClassroomID());
            timetableDTO.setClassroom(timetable.getClassroom().getClassroomID());
            moduleDTO.setModuleName(timetable.getModule().getModuleName());
            timetableDTO.setModule(timetable.getModule().getModuleName());
            moduleDTO.setLecturer(timetable.getModule().getLecturerEmail().getLastName());
            list.add(timetableDTO);

        }

        return ResponseEntity.ok(list);
    }

    @GetMapping("/ViewAllStudentLectures")
    public ResponseEntity<?> viewAllStudentLectures(Authentication authentication) {

        List<Timetable> timetables = timetableService.getStudentTimetable(userService.getUserByUserId(authentication.getName()).getBatchId());

        List<TimetableDTO> list = new ArrayList<>();
        for (Timetable timetable : timetables) {
            TimetableDTO timetableDTO = new TimetableDTO();
            ClassroomDTO classroomDTO = new ClassroomDTO();
            ModuleDTO moduleDTO = new ModuleDTO();

            timetableDTO.setTimetableDate(timetable.getDate().toString());
            timetableDTO.setStartTime(timetable.getStartTime().toString());
            timetableDTO.setEndTime(timetable.getEndTime().toString());
            classroomDTO.setClassroomId(timetable.getClassroom().getClassroomID());
            timetableDTO.setClassroom(timetable.getClassroom().getClassroomID());
            moduleDTO.setModuleName(timetable.getModule().getModuleName());
            timetableDTO.setModule(timetable.getModule().getModuleName());
            moduleDTO.setLecturer(timetable.getModule().getLecturerEmail().getLastName());
            list.add(timetableDTO);

        }

        return ResponseEntity.ok(list);
    }

    @GetMapping("/viewStudentMyModules")
    public ResponseEntity<?> viewMyModulesStudent(Authentication authentication) {

        List<Module> allModules = moduleService.getStudentModules(userService.getUserByUserId(authentication.getName()).getBatchId());

        List<MobileModuleDTO> list = new ArrayList<>();

        for (Module module : allModules) {

            MobileModuleDTO moduleDTO = new MobileModuleDTO();
            String[] batchList;
            List<BatchDTO> batchDTOList = new ArrayList<>();

            moduleDTO.setModuleName(module.getModuleName());
            moduleDTO.setLecturer(module.getLecturerEmail().getEmail());
            for (Batch batch : module.getBatchList()) {
                BatchDTO batch1 = new BatchDTO();
                batch1.setBatchName(batch.getBatchName());
                batchDTOList.add(batch1);

            }
            moduleDTO.setBatchList(batchDTOList);

            list.add(moduleDTO);
        }
        return ResponseEntity.ok(list);
    }

    @GetMapping("/myAccount")
    public ResponseEntity<?> getMyAccount(@RequestBody String email){
        User user = userService.getUserByUserId(email);
        return ResponseEntity.ok(user);
    }
}

