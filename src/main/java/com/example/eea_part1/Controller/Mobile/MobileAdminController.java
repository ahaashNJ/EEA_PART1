package com.example.eea_part1.Controller.Mobile;

import com.example.eea_part1.DTO.*;
import com.example.eea_part1.Model.*;
import com.example.eea_part1.Model.Module;
import com.example.eea_part1.Service.*;
//import com.sun.org.apache.xpath.internal.operations.Mod;
import org.eclipse.jdt.internal.compiler.ast.ModuleDeclaration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/admin")
@RestController
public class MobileAdminController {

    @Autowired
    public UserService userService;

    @Autowired
    public TimetableService timetableService;

    @Autowired
    public BatchService batchService;

    @Autowired
    public ModuleService moduleService;

    @Autowired
    public ClassroomService classroomService;

    @GetMapping(path = "/ViewStudentsMobile")
    public ResponseEntity<?> viewAllStudents(Authentication authentication) {

        List<User> allUsers = userService.getAllStudents();

        List<UserDTO> list = new ArrayList<>();
        for (User user : allUsers) {

            UserDTO userDTO = new UserDTO();
            BatchDTO batchDTO = new BatchDTO();


            userDTO.setFirstName(user.getFirstName());
            userDTO.setLastName(user.getLastName());
            userDTO.setContactNumber(user.getContactNumber());
            userDTO.setEmail(user.getEmail());
            userDTO.setUserType(user.getUserType());
            userDTO.setBatchId(user.getBatchId().getBatchName());
//            batchDTO.setBatchName(userDTO.getBatchId().toString());
//            userDTO.setBatchId(batchDTO);
            list.add(userDTO);
        }

        return ResponseEntity.ok(list);
    }

    @GetMapping(path = "/ViewLecturersMobile")
    public ResponseEntity<?> viewAllLecturers(Authentication authentication) {

        List<User> allUsers = userService.getAllLecturers();

        List<UserDTO> list = new ArrayList<>();
        for (User user : allUsers) {

            UserDTO userDTO = new UserDTO();
            BatchDTO batchDTO = new BatchDTO();


            userDTO.setFirstName(user.getFirstName());
            userDTO.setLastName(user.getLastName());
            userDTO.setContactNumber(user.getContactNumber());
            userDTO.setEmail(user.getEmail());
            userDTO.setUserType(user.getUserType());
//            batchDTO.setBatchName(userDTO.getBatchId().toString());
//            userDTO.setBatchId(batchDTO);
            list.add(userDTO);
        }

        return ResponseEntity.ok(list);
    }

    @GetMapping("/viewBatchesMobile")
    public ResponseEntity<?> viewAllBatches(Authentication authentication) {

        List<Batch> allBatches = batchService.getAllBatches();

        List<BatchDTO> list = new ArrayList<>();

        for (Batch batch : allBatches) {

            BatchDTO batchDTO = new BatchDTO();

            batchDTO.setBatchName(batch.getBatchName());
            batchDTO.setStartDate(batch.getStartDate().toString());
            batchDTO.setEndDate(batch.getEndDate().toString());

            list.add(batchDTO);
        }

        return ResponseEntity.ok(list);
    }

    @GetMapping("/viewModulesMobile")
    public ResponseEntity<?> viewAllModules(Authentication authentication) {
        List<Module> allModules = moduleService.getAllModules();

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

    @GetMapping("/viewClassroomMobile")
    public ResponseEntity<?> viewAllClassrooms(Authentication authentication) {
        List<Classroom> allClassrooms = classroomService.getAllClassrooms();

        List<ClassroomDTO> list = new ArrayList<>();

        for (Classroom classroom : allClassrooms) {

            ClassroomDTO classroomDTO = new ClassroomDTO();

            classroomDTO.setClassroomId(classroom.getClassroomID());
            classroomDTO.setFloor(classroom.getFloorNum());
            classroomDTO.setNoOfSeats(classroom.getNumOfSeats());

            list.add(classroomDTO);
        }

        return ResponseEntity.ok(list);
    }

    @GetMapping("/viewAllLecturesAdmin")
    public ResponseEntity<?> viewAllLecturesAdmin(Authentication authentication) {
        List<Timetable> allTimetables = timetableService.getAllTimetables();

        List<TimetableDTO> list = new ArrayList<>();

        for (Timetable timetable : allTimetables) {

            TimetableDTO timetableDTO = new TimetableDTO();

            timetableDTO.setTimetableDate(timetable.getDate().toString());
            timetableDTO.setStartTime(timetable.getStartTime().toString());
            timetableDTO.setEndTime(timetable.getEndTime().toString());
            timetableDTO.setClassroom(timetable.getClassroom().getClassroomID());
            timetableDTO.setModule(timetable.getModule().getModuleName());

            list.add(timetableDTO);
        }

        return ResponseEntity.ok(list);
    }

    @GetMapping("/viewTodayLecturesAdmin")
    public ResponseEntity<?> viewTodayLecturesAdmin(Authentication authentication) {

        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);

        List<Timetable> allTimetables = timetableService.getTodayTimetable(date);
        List<TimetableDTO> list = new ArrayList<>();

        for (Timetable timetable : allTimetables) {

            TimetableDTO timetableDTO = new TimetableDTO();

            timetableDTO.setTimetableDate(timetable.getDate().toString());
            timetableDTO.setStartTime(timetable.getStartTime().toString());
            timetableDTO.setEndTime(timetable.getEndTime().toString());
            timetableDTO.setModule(timetable.getModule().getModuleName());
            timetableDTO.setClassroom(timetable.getClassroom().getClassroomID());

            list.add(timetableDTO);
        }

        return ResponseEntity.ok(list);

    }

    @PostMapping("/addClassroom")
    public ResponseEntity<?> addClassroom(@RequestBody ClassroomDTO classroomDTO) {

        ClassroomDTO dto = new ClassroomDTO();
        dto.setClassroomId(classroomDTO.getClassroomId());
        dto.setNoOfSeats(classroomDTO.getNoOfSeats());
        dto.setFloor(classroomDTO.getFloor());

        classroomService.createClassroom(dto);
        return ResponseEntity.ok(classroomDTO);
    }

    @PostMapping("/addBatch")
    public ResponseEntity<?> addBatch(@RequestBody BatchDTO batchDTO) {

        BatchDTO dto = new BatchDTO();
        System.out.println(batchDTO.getBatchName() + "Hello");

        dto.setBatchName(batchDTO.getBatchName());
        dto.setEndDate(batchDTO.getEndDate());
        System.out.println(batchDTO.getEndDate());
        dto.setStartDate(batchDTO.getStartDate());

        batchService.createBatch(dto);
        return ResponseEntity.ok(batchDTO);
    }

    @PostMapping("/addLecturer")
    public ResponseEntity<?> addLecturer(@RequestBody UserDTO userDTO) {

        UserDTO dto = new UserDTO();
        dto.setFirstName(userDTO.getFirstName());
        dto.setLastName(userDTO.getLastName());
        dto.setEmail(userDTO.getEmail());
        dto.setUserType("Lecturer");
        dto.setContactNumber(userDTO.getContactNumber());

        userService.createUser(dto);
        return ResponseEntity.ok(userDTO);
    }

    @PostMapping("/addStudent")
    public ResponseEntity<?> addStudent(@RequestBody UserDTO userDTO) {

        UserDTO dto = new UserDTO();
        dto.setFirstName(userDTO.getFirstName());
        dto.setLastName(userDTO.getLastName());
        dto.setEmail(userDTO.getEmail());
        dto.setUserType("Student");
        dto.setBatchId(userDTO.getBatchId());
        dto.setContactNumber(userDTO.getContactNumber());
        System.out.println(userDTO.getBatchId());

        userService.createUserMobile(dto);
        return ResponseEntity.ok(userDTO);
    }

    @GetMapping("/getBatchList")
    public ResponseEntity<?> getBatchList() {

        List<Batch> allBatches = batchService.getAllBatches();

        return ResponseEntity.ok(allBatches);
    }

    @GetMapping(path = "/getLecturerList")
    public ResponseEntity<?> getLecturerList() {

        List<User> allUsers = userService.getAllLecturers();

        return ResponseEntity.ok(allUsers);
    }


    @PostMapping("/addModule")
    public ResponseEntity<?> addModule(@RequestBody ModuleDTO moduleDTO) {
        System.out.println("Hello");
        ModuleDTO dto = new ModuleDTO();
        dto.setModuleName(moduleDTO.getModuleName());
        dto.setLecturer(moduleDTO.getLecturer());
        dto.setBatchList(moduleDTO.getBatchList());
        System.out.println(moduleDTO.getModuleName());

        moduleService.createModule(dto);
        return ResponseEntity.ok(moduleDTO);
    }

    @GetMapping(path = "/getClassroomList")
    public ResponseEntity<?> getClassroomList() {

        List<Classroom> allClassrooms = classroomService.getAllClassrooms();

        return ResponseEntity.ok(allClassrooms);
    }

    @PostMapping("/addTimetable")
    public ResponseEntity<?> addTimetable(@RequestBody TimetableDTOMobile timetable) {
        timetableService.scheduleAClassMobile(timetable);
        return ResponseEntity.ok(timetable);
    }

    @GetMapping("/myAccount")
    public ResponseEntity<?> getMyAccount(@RequestBody String email){
        User user = userService.getUserByUserId(email);
        return ResponseEntity.ok(user);
    }

//    @DeleteMapping("/deleteModule")
//    public ResponseEntity<?> deleteTimetable(String moduleId){
//        String s =moduleService.deleteModule(moduleId);
//}

}

