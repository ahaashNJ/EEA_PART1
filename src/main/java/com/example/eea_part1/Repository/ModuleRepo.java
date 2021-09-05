package com.example.eea_part1.Repository;
import com.example.eea_part1.Model.Batch;
import com.example.eea_part1.Model.Module;
import com.example.eea_part1.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleRepo extends JpaRepository<Module, Integer> {


    List<Module> findModulesByBatchListEquals(Batch batchID);

    List<Module> findModulesByLecturerEmail_Email(String email);

    Module findModuleByModuleName(String moduleName);

//    @Query("FROM Module m where m.moduleName Like%:moduleName%")
//    List<Module> moduleName(String moduleName);

//    @Query("FROM Module m where m.lecturerEmail.firstName LIKE %:lecturerName%")
//    List<Module> lecturerName(String lecturerName);
}
