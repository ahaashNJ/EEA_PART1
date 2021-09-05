package com.example.eea_part1.Controller.Mobile;


import com.example.eea_part1.DTO.ClassroomDTO;
import com.example.eea_part1.DTO.ModuleDTO;
import com.example.eea_part1.DTO.TimetableDTO;
import com.example.eea_part1.Model.Module;
import com.example.eea_part1.Model.Timetable;
import com.example.eea_part1.Model.User;
import com.example.eea_part1.Service.ModuleService;
import com.example.eea_part1.Service.TimetableService;
import com.example.eea_part1.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/lecturer")
@RestController
public class MobileLecturerController {

    @Autowired
    public UserService userService;

    @Autowired
    public TimetableService timetableService;

    @Autowired
    public ModuleService moduleService;

    @GetMapping("/getAllLecturerTimetable")
    public ResponseEntity<?> getAllLecturerTimetable(Authentication authentication){

        List<Timetable> timetables = timetableService.getLectureTimetable(userService.getUserByUserId(authentication.getName()).getEmail());

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

    @GetMapping("/getTodayTimetableLecturer")
    public ResponseEntity<?> getTodayTimetableLecturer(Authentication authentication){

        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);

        User user = userService.getUserByUserId(authentication.getName());
        List<Timetable> timetables = timetableService.getTodayTimetableLecturer(user, date);

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

    @GetMapping("/viewMyModulesLecturer")
    public ResponseEntity<?> viewMyModulesLecturer(Authentication authentication){

        List<Module> allModules = moduleService.getLectureModules(userService.getUserByUserId(authentication.getName()).getEmail());

        List<ModuleDTO> list = new ArrayList<>();

        for (Module module : allModules) {

            ModuleDTO moduleDTO = new ModuleDTO();

            moduleDTO.setModuleId(module.getModuleID());
            moduleDTO.setModuleName(module.getModuleName());
            moduleDTO.setLecturer(module.getLecturerEmail().getEmail());

            list.add(moduleDTO);
        }
        return ResponseEntity.ok(list);
    }

}
