package com.example.eea_part1.Service;

import java.util.ArrayList;

import com.example.eea_part1.Authentication.DirectUser;
import com.example.eea_part1.Model.User;
import com.example.eea_part1.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {


    @Autowired
    private UserRepo userrepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userrepo.findUserByEmail(email);
        if(user==null){
            throw new UsernameNotFoundException(email);
        }
        else{
            ArrayList<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
            grantedAuthorities.add(new SimpleGrantedAuthority(user.getUserType()));
            DirectUser directUser = new DirectUser(grantedAuthorities, user.getEmail(), user.getPassword(),
                    true, true, true, true);
            return directUser;
        }
    }
}
