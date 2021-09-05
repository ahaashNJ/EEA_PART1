package com.example.eea_part1.Service;

import com.example.eea_part1.Authentication.DirectUser;
import com.example.eea_part1.DTO.*;
import com.example.eea_part1.Model.*;
import com.example.eea_part1.Model.Module;
import com.example.eea_part1.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.eea_part1.Configurtion.WebConfiguration;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;


@Service
public class UserService implements UserDetailsService {

    @Autowired
    private BatchRepo batchrepo;

    @Autowired
    private ModuleRepo modulerepo;

    @Autowired
    private UserRepo userrepo;

    @Autowired
    private UserTypeRepo usertyperepo;

    @Autowired
    private TimetableRepo timetableRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private EmailService emailService;

    public List<User> getAllUsers() {

        return userrepo.findAll();
    }

    public List<User> getAllStudents(){
        return userrepo.StudentView();
    }

    public List<User> getAllLecturers(){
        return userrepo.LecturerView();
    }

    public List<User> getLecturerList(){
        return userrepo.LecturerView();
    }

//    public User getLecturerList(String userType){
//
//        return userrepo.findUsersByUserType(userType);
//    }

    public List<User> getAllUserSearch(String name){

        List<User> userList = new ArrayList<>();

        userList.addAll(userrepo.firstName(name));

        userList.addAll(userrepo.lastName(name));

//        userList.addAll(userrepo.batchName(name));

        return userList;
    }


    public User createUser(UserDTO userdto) {

        User users = new User();
        if(userrepo.findById(userdto.getEmail()).isPresent()){
            return null;
        }
        User user = new User();
        user.setEmail(userdto.getEmail());
        user.setFirstName(userdto.getFirstName());
        user.setLastName(userdto.getLastName());
        user.setContactNumber(userdto.getContactNumber());
        user.setUserType(userdto.getUserType());
        user.setPassword(passwordEncoder.encode("Aa12345"));
        emailService.EmailToUser(userdto.getEmail());
        return userrepo.save(user);
    }



//    public List<UserTypeDTO> getTypeList() {
//        List<UserTypeDTO> list = new ArrayList<>();
//        for (UserType usertype : usertyperepo.findAll()) {
//            UserTypeDTO usertypedto = new UserTypeDTO();
//            usertypedto.setUserType(usertype.getUserType());
//            usertypedto.setUserType(usertype.getUserType());
//            list.add(usertypedto);
//        }
//        return list;
//    }

    public User updateUser(UserDTO updateuserdto){
        Optional<User> update = userrepo.findById(updateuserdto.getEmail());
        User user = update.get();
        user.setEmail(updateuserdto.getEmail());
        user.setFirstName(updateuserdto.getFirstName());
        user.setLastName(updateuserdto.getLastName());
        user.setPassword(passwordEncoder.encode(updateuserdto.getPassword()));
        user.setContactNumber(updateuserdto.getContactNumber());
        user.setBatchId(batchrepo.getOne(Integer.parseInt(updateuserdto.getBatchId())));
        return userrepo.save(user);
    }

    public User GetUserEmail(String UserEmail){
        Optional<User> userGet = userrepo.findById(UserEmail);
        User user = new User();
        User userGive = null;
        if(userGet.isPresent()){
            userGive = userGet.get();
            user.setFirstName(userGive.getFirstName());
            user.setLastName(userGive.getLastName());
            user.setEmail(userGive.getEmail());
            user.setContactNumber(userGive.getContactNumber());
            user.setPassword(userGive.getPassword());
            user.setBatchId(userGive.getBatchId());
        }
        return user;
    }



    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userrepo.findUserByEmail(s);
        if(user==null){
            throw new UsernameNotFoundException(s);
        }
        else{
            ArrayList<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
            grantedAuthorities.add(new SimpleGrantedAuthority(user.getUserType().toUpperCase(Locale.ROOT)));
            DirectUser directUser = new DirectUser(grantedAuthorities, user.getEmail(), user.getPassword(),
                    true, true, true, true);
            return directUser;
        }
    }

    public User directUserType(String email){
        return userrepo.findUserByEmail(email);
    }


    public List<UserDTO> getAllLecturersToList() {
        List<UserDTO> list = new ArrayList<>();
        for (User user : userrepo.findAll()) {
            if(user.getUserType().equals("Lecturer")){
                UserDTO dto = new UserDTO();
                dto.setUserType(user.getUserType());
                dto.setEmail(user.getEmail());
                dto.setFirstName(user.getFirstName());
                dto.setLastName(user.getLastName());
                list.add(dto);
            }
        }
        return list;
    }

    public User getUserByUserId(String userID){
        Optional<User> user = userrepo.findById(userID);
        User users = null;
        if(user.isPresent()){
            users = user.get();
        }

        return users;
    }

    public void deleteUser(User userID) {
        userrepo.delete(userID);
    }

    public User createUserMobile(UserDTO userdto) {

        User users = new User();
        if(userrepo.findById(userdto.getEmail()).isPresent()){
            return null;
        }
        User user = new User();
        Batch batch =  new Batch();

        user.setEmail(userdto.getEmail());
        user.setFirstName(userdto.getFirstName());
        user.setLastName(userdto.getLastName());
        user.setContactNumber(userdto.getContactNumber());
        user.setUserType(userdto.getUserType());
        user.setPassword(passwordEncoder.encode("Aa12345"));
        user.setBatchId(batchrepo.findBatchByBatchName(userdto.getBatchId()));
        emailService.EmailToUser(userdto.getEmail());
        return userrepo.save(user);
    }


}
