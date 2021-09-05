package com.example.eea_part1.Service;

import com.example.eea_part1.DTO.*;
import com.example.eea_part1.Model.*;
import com.example.eea_part1.Model.Module;
import com.example.eea_part1.Repository.BatchRepo;
import com.example.eea_part1.Repository.ClassroomRepo;
import com.example.eea_part1.Repository.ModuleRepo;
import com.example.eea_part1.Repository.TimetableRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TimetableService {
    @Autowired
    private ModuleRepo modulerepo;

    @Autowired
    TimetableRepo timetableRepo;

    @Autowired
    private ClassroomRepo classroomRepo;

    @Autowired
    private BatchRepo batchRepo;

    private TimetableService timetableService;

    public List<ModuleDTO> getModuleList() {
        List<ModuleDTO> list = new ArrayList<>();

        for (Module module : modulerepo.findAll()) {
            ModuleDTO moduledto = new ModuleDTO();
            moduledto.setModuleId(module.getModuleID());
            moduledto.setModuleName(module.getModuleName());
            list.add(moduledto);
        }
        return list;
    }

    public List<ClassroomDTO> getClassroomList() {
        List<ClassroomDTO> list = new ArrayList<>();

        for (Classroom classroom : classroomRepo.findAll()) {
            ClassroomDTO classroomDTO = new ClassroomDTO();
            classroomDTO.setClassroomId(classroom.getClassroomID());
            classroomDTO.setFloor(classroom.getNumOfSeats());
            classroomDTO.setNoOfSeats(classroom.getNumOfSeats());
            list.add(classroomDTO);
        }
        return list;
    }

    public Timetable scheduleAClass(TimetableDTO timetableDTO) {
        Timetable timetable = new Timetable();
        List<Batch> batchList = new ArrayList<>();

        timetable.setTimetableId(timetableDTO.getTimetableId());

        for(String batch : timetableDTO.getBatchList()){
            Optional<Batch> byId = batchRepo.findById(Integer.parseInt(batch));

            if (byId.isPresent()){
                batchList.add(byId.get());
            }
        }

        timetable.setBatchList(batchList);
        System.out.println(batchList);
        timetable.setClassroom(classroomRepo.getOne(timetableDTO.getClassroom()));
        timetable.setDate(Date.valueOf(timetableDTO.getTimetableDate()));
        timetable.setStartTime(LocalTime.parse(timetableDTO.getStartTime()));
        timetable.setEndTime(LocalTime.parse(timetableDTO.getEndTime()));
        timetable.setModule(modulerepo.getOne(Integer.parseInt(timetableDTO.getModule())));

        return timetableRepo.save(timetable);
    }

    public List<Timetable> getAllTimetables(){ return timetableRepo.findAll(); }

    public Timetable updateTimetable(TimetableDTO updateTimetableDTO){

        Timetable timetable = new Timetable();
        List<Batch> batchList = new ArrayList<>();

        timetable.setTimetableId(updateTimetableDTO.getTimetableId());
        timetable.setModule(modulerepo.getOne(Integer.parseInt(updateTimetableDTO.getModule())));
        timetable.setDate(Date.valueOf(updateTimetableDTO.getTimetableDate()));
        timetable.setStartTime(LocalTime.parse(updateTimetableDTO.getStartTime()));
        timetable.setEndTime(LocalTime.parse(updateTimetableDTO.getEndTime()));
        timetable.setClassroom(classroomRepo.getOne(updateTimetableDTO.getClassroom()));

        Optional<Timetable> timetables = timetableRepo.findById((updateTimetableDTO.getTimetableId()));

        if(timetables.isPresent()){
            batchList = timetables.get().getBatchList();

        }

        timetable.setBatchList(batchList);
        return timetableRepo.save(timetable);
    }

    public Timetable GetTimetableID(String TimetableID) {
        Optional<Timetable> timetableGet = timetableRepo.findById(Integer.parseInt(TimetableID));
        Timetable timetable = new Timetable();
        Timetable timetableGive = null;
        if(timetableGet.isPresent()) {
            timetableGive = timetableGet.get();
            timetable.setTimetableId(timetableGive.getTimetableId());
            timetable.setModule(timetableGive.getModule());
            timetable.setDate(timetableGive.getDate());
            timetable.setStartTime(timetableGive.getStartTime());
            timetable.setEndTime(timetableGive.getEndTime());
            timetable.setBatchList(timetableGive.getBatchList());

        }
        return timetable;
    }

    public List<Timetable> getLectureTimetable(String email){

        return timetableRepo.findTimetablesByModule_LecturerEmail_Email(email);
    }

    public List<Timetable> getStudentTimetable(Batch batchId){

        return timetableRepo.findTimetableByBatchListEquals(batchId);
    }

    public void cancelLecture(Timetable TimetableID) {
        timetableRepo.delete(TimetableID);
    }

    public List<Timetable> getTodayTimetable(Date date){

        return timetableRepo.findTimetableByDate(date);
    }

    public List<Timetable> getTodayTimetableLecturer(User user, Date date){

        return timetableRepo.findTimetablesByModule_LecturerEmail_EmailAndDate(user.getEmail(), date);
    }

    public List<Timetable> getTodayTimetableStudent(Batch batch, Date date){

        return timetableRepo.findTimetableByBatchListEqualsAndDate(batch, date);
    }

    public Timetable scheduleAClassMobile(TimetableDTOMobile timetableDTO) {
        Timetable timetable = new Timetable();
        List<Batch> batchList = new ArrayList<>();

        timetable.setTimetableId(timetableDTO.getTimetableId());

        for(Batch batch : timetableDTO.getBatchList()){
            Optional<Batch> byId = Optional.ofNullable(batchRepo.findBatchByBatchName(batch.getBatchName()));

            if (byId.isPresent()){
                batchList.add(byId.get());
            }
        }

        timetable.setBatchList(batchList);
        System.out.println(batchList);
        timetable.setClassroom(classroomRepo.getOne(timetableDTO.getClassroom()));
        timetable.setDate(Date.valueOf(timetableDTO.getTimetableDate()));
        timetable.setStartTime(LocalTime.parse(timetableDTO.getStartTime()));
        timetable.setEndTime(LocalTime.parse(timetableDTO.getEndTime()));
        timetable.setModule(modulerepo.findModuleByModuleName(timetableDTO.getModule()));

        return timetableRepo.save(timetable);
    }

}
