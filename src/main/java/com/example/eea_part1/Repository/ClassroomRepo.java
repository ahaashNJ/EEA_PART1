package com.example.eea_part1.Repository;

import com.example.eea_part1.Model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepo extends JpaRepository<Classroom, String>{
}
