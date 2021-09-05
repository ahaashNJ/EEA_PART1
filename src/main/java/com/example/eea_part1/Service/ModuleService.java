package com.example.eea_part1.Service;

import com.example.eea_part1.DTO.BatchDTO;
import com.example.eea_part1.DTO.ModuleDTO;
import com.example.eea_part1.Model.Batch;
import com.example.eea_part1.Model.Module;
import com.example.eea_part1.Model.Timetable;
import com.example.eea_part1.Repository.BatchRepo;
import com.example.eea_part1.Repository.ModuleRepo;
import com.example.eea_part1.Repository.UserRepo;
import com.example.eea_part1.Repository.UserTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ModuleService {
    @Autowired
    private BatchRepo batchrepo;

    @Autowired
    private ModuleRepo modulerepo;

    @Autowired
    private UserRepo userrepo;

    @Autowired
    private UserTypeRepo usertyperepo;

    public List<Module> getAllModules() {
        return modulerepo.findAll();
    }

    public Module createModule(ModuleDTO moduledto) {
        Module module = new Module();
        List<Batch> batches = new ArrayList<>();
        module.setModuleName(moduledto.getModuleName());
        module.setLecturerEmail(userrepo.getOne(moduledto.getLecturer()));

        for (String batch : moduledto.getBatchList()) {

            Optional<Batch> byId = batchrepo.findById(Integer.parseInt(batch));
            if (byId.isPresent()) {
                batches.add(byId.get());
                System.out.println(batch);
            }
        }

        module.setBatchList(batches);
        return modulerepo.save(module);
    }

    public Module createModuleMobile(ModuleDTO moduledto) {
        Module module = new Module();
        List<Batch> batches = new ArrayList<>();
        module.setModuleName(moduledto.getModuleName());
        module.setLecturerEmail(userrepo.getOne(moduledto.getLecturer()));

        for (String batch : moduledto.getBatchList()) {

            Optional<Batch> byId = batchrepo.findById(Integer.parseInt(batch));
            if (byId.isPresent()) {
                batches.add(byId.get());
                System.out.println(batch);
            }
        }

        module.setBatchList(batches);
        return modulerepo.save(module);
    }

    public List<BatchDTO> getBatchList() {
        List<BatchDTO> list = new ArrayList<>();
        for (Batch batch : batchrepo.findAll()) {
            BatchDTO batchdto = new BatchDTO();
            batchdto.setBatchId(batch.getBatchId());
            batchdto.setBatchName(batch.getBatchName());
            list.add(batchdto);
        }
        return list;
    }

    public Module updateModule(ModuleDTO updatemoduledto){

        Module module = new Module();
        List<Batch> batchList = new ArrayList<>();

        module.setModuleID(updatemoduledto.getModuleId());
        module.setModuleName(updatemoduledto.getModuleName());
        module.setLecturerEmail(userrepo.getOne(updatemoduledto.getLecturer()));

        Optional<Module> update = modulerepo.findById((updatemoduledto.getModuleId()));

        if(update.isPresent()){
            batchList = update.get().getBatchList();

        }
        module.setBatchList(batchList);
        return modulerepo.save(module);
    }

    public Module GetModuleID(String ModuleID) {
        Optional<Module> moduleGet = modulerepo.findById(Integer.parseInt(ModuleID));
        Module module = new Module();
        Module moduleGive = null;
        if (moduleGet.isPresent()) {
            moduleGive = moduleGet.get();
            module.setModuleID(moduleGive.getModuleID());
            module.setModuleName(moduleGive.getModuleName());
            module.setLecturerEmail(moduleGive.getLecturerEmail());
            module.setBatchList(moduleGive.getBatchList());
        }
        return module;
    }

    public void deleteModule(Module ModuleID) {
        modulerepo.delete(ModuleID);
    }

//    public void deleteModuleMobile(String ModuleID) {
//        modulerepo.delete(ModuleID);
//    }

    public List<Module> getLectureModules(String email){
        return modulerepo.findModulesByLecturerEmail_Email(email);
    }

    public List<Module> getStudentModules(Batch batchID){
        return modulerepo.findModulesByBatchListEquals(batchID);
    }



}
