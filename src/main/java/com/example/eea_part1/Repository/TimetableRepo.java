package com.example.eea_part1.Repository;

import com.example.eea_part1.Model.Batch;
import com.example.eea_part1.Model.Module;
import com.example.eea_part1.Model.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Repository
public interface TimetableRepo extends JpaRepository<Timetable, Integer> {

    List<Timetable> findTimetablesByModule_LecturerEmail_Email(String email);

    List<Timetable> findTimetableByBatchListEquals(Batch batchId);

    List<Timetable> findTimetableByDate(Date date);

    List<Timetable> findTimetablesByModule_LecturerEmail_EmailAndDate(String email, Date date);

    List<Timetable> findTimetableByBatchListEqualsAndDate(Batch batch, Date date);


}
