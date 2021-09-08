package com.example.eea_part1.Service;

import com.example.eea_part1.DTO.BatchDTO;
import com.example.eea_part1.DTO.ModuleDTO;
import com.example.eea_part1.Model.Batch;
import com.example.eea_part1.Model.Module;
import com.example.eea_part1.Repository.BatchRepo;
import com.example.eea_part1.Repository.ModuleRepo;
import com.example.eea_part1.Repository.UserRepo;
import com.example.eea_part1.Repository.UserTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service("theBatchService")
public class BatchService {

    private final BatchRepo batchrepo;

    private final ModuleRepo modulerepo;

    private final UserRepo userrepo;

    @Autowired
    public BatchService(BatchRepo batchrepo, ModuleRepo modulerepo, UserRepo userrepo, UserTypeRepo usertyperepo) {
        this.batchrepo = batchrepo;
        this.modulerepo = modulerepo;
        this.userrepo = userrepo;
        this.usertyperepo = usertyperepo;
    }

    private final UserTypeRepo usertyperepo;

    public List<Batch> getAllBatches() {

        return batchrepo.findAll();
    }

    public List<Batch> getBatchSearch(String name){
        return batchrepo.findByBatchName(name);
    }

    public Batch createBatch(BatchDTO batchdto) {
        try {
            Batch batch = new Batch();
            batch.setBatchName(batchdto.getBatchName());
            System.out.println(batchdto.getBatchName()+"Serviceeeeeeee");
            batch.setStartDate(Date.valueOf(batchdto.getStartDate()));
            System.out.println(batchdto.getStartDate()+"jjjjjjjjjjjjjjjjjj");
            batch.setEndDate(Date.valueOf(batchdto.getEndDate()));
            return batchrepo.save(batch);
        } catch (Exception ex) {
            throw new RuntimeException("Date parse failed - " + ex.getLocalizedMessage());
        }
    }

    public BatchDTO GetBatchID(int batchId) {
        Optional<Batch> batchGet = batchrepo.findById(batchId);
        BatchDTO batch = new BatchDTO();
        Batch batchGive = null;
        if (batchGet.isPresent()) {
            batchGive = batchGet.get();
            batch.setBatchId(batchGive.getBatchId());
            batch.setBatchName(batchGive.getBatchName());
            batch.setStartDate(String.valueOf(batchGive.getStartDate()));
            batch.setEndDate(String.valueOf(batchGive.getEndDate()));
        }

        return batch;
    }

    public Batch updateBatch(BatchDTO updatebatchedto) {
        Optional<Batch> update = batchrepo.findById(updatebatchedto.getBatchId());

        Batch batch = update.get();
        batch.setBatchName(updatebatchedto.getBatchName());
        batch.setStartDate(Date.valueOf(updatebatchedto.getStartDate()));
        batch.setEndDate(Date.valueOf(updatebatchedto.getEndDate()));
        return batchrepo.save(batch);
    }

    public void deleteBatch(Batch batchID) {
        batchrepo.delete(batchID);
    }

    public void deleteBatchMobile(Batch batchID,String BatchName) {

        batchrepo.delete(batchID);
    }


}
