package com.elm.UserPortal.UserPortal.Service;

import com.elm.UserPortal.UserPortal.Models.Privilege;
import com.elm.UserPortal.UserPortal.Models.User;
import com.elm.UserPortal.UserPortal.Repositories.PrivilegeRepository;
import com.elm.UserPortal.UserPortal.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Override
    public User addUser(User user) {
        String pass = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(pass);
        Privilege privilege = new Privilege();
        privilege.setAuthorityName("USER");
        privilege.setUserPrivileges(user);
        privilegeRepository.save(privilege);
        return userRepository.save(user);
    }
}
