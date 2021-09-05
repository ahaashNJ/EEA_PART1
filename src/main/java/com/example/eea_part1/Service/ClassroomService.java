package com.example.eea_part1.Service;

import com.example.eea_part1.DTO.BatchDTO;
import com.example.eea_part1.DTO.ClassroomDTO;
import com.example.eea_part1.Model.Batch;
import com.example.eea_part1.Model.Classroom;
import com.example.eea_part1.Repository.ClassroomRepo;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ClassroomService {

    private final ClassroomRepo classroomRepo;

    public ClassroomService(ClassroomRepo classroomRepo) {
        this.classroomRepo = classroomRepo;
    }

    public List<Classroom> getAllClassrooms(){
        return classroomRepo.findAll();
    }

    public Classroom createClassroom(ClassroomDTO classroomDTO) {
        try {
            Classroom classroom = new Classroom();
            classroom.setClassroomID(classroomDTO.getClassroomId());
            classroom.setFloorNum(classroomDTO.getFloor());
            classroom.setNumOfSeats(classroomDTO.getNoOfSeats());
            return classroomRepo.save(classroom);
        } catch (Exception ex) {
            throw new RuntimeException("Date parse failed - " + ex.getLocalizedMessage());
        }
    }

    public ClassroomDTO GetClassroomID(String ClassroomId) {
        Optional<Classroom> classroomGet = classroomRepo.findById(ClassroomId);
        ClassroomDTO classroom = new ClassroomDTO();
        Classroom classroomGive = null;
        if (classroomGet.isPresent()) {
            classroomGive = classroomGet.get();
            classroom.setClassroomId(classroomGive.getClassroomID());
            classroom.setFloor(classroomGive.getFloorNum());
            classroom.setNoOfSeats(classroomGive.getNumOfSeats());
        }

        return classroom;
    }

    public Classroom updateClassroom(ClassroomDTO classroomDTO) {
        Optional<Classroom> update = classroomRepo.findById(classroomDTO.getClassroomId());

        Classroom classroom = update.get();
        classroom.setNumOfSeats(classroomDTO.getNoOfSeats());
        classroom.setFloorNum(classroomDTO.getFloor());
        return classroomRepo.save(classroom);
    }

    public void deleteClassroom(Classroom classroomId) {
        classroomRepo.delete(classroomId);
    }

}
