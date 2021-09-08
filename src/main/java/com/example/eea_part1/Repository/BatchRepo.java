package com.example.eea_part1.Repository;
import com.example.eea_part1.Model.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface BatchRepo extends JpaRepository<Batch, Integer> {


    List<Batch> findByBatchName(String batchName);

    Batch findBatchByBatchName(String batchName);


}
