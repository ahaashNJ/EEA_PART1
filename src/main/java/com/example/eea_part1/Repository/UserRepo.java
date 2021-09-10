package com.example.eea_part1.Repository;

import com.example.eea_part1.Model.User;
import com.example.eea_part1.Model.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

    User findUserByEmail(String Email);

    @Query("FROM User p where p.lastName LIKE %:lastName%")
    List<User> lastName(String lastName);

    @Query("FROM User p where p.firstName LIKE %:firstName%")
    List<User> firstName(String firstName);

    @Query("FROM User p where p.userType = 'Student'")
            List<User> StudentView();

    @Query("FROM User p where p.userType = 'Lecturer'")
    List<User> LecturerView();

    @Query("FROM User p where p.firstName LIKE %:firstName% and p.userType = 'Student'")
    List<User> firstNameSearchStudent(String firstName);

    @Query("FROM User p where p.lastName LIKE %:firstName% and p.userType = 'Student'")
    List<User> lastNameSearchStudent(String firstName);

    @Query("FROM User p where p.firstName LIKE %:firstName% and p.userType = 'Lecturer'")
    List<User> firstNameSearchLecturer(String firstName);

    @Query("FROM User p where p.lastName LIKE %:firstName% and p.userType = 'Lecturer'")
    List<User> lastNameSearchLecturer(String firstName);

    User findUsersByUserType(String userType);



//    @Query("FROM User p where p.batchId.batchName LIKE %:batchName%")
//    List<User> batchName(String batchName);


//    List<User> findUsersByBatchIdBatchName(String batchName);
    List<User> findByUserTypeLike(String type);

}
