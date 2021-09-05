package com.example.eea_part1.Repository;

import com.example.eea_part1.Model.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTypeRepo extends JpaRepository<UserType, String> {

}
