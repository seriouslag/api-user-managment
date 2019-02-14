package com.nullspace.apiusermanagement.bootstrap;

import com.nullspace.apiusermanagement.model.Authority;
import com.nullspace.apiusermanagement.model.User;
import com.nullspace.apiusermanagement.model.UserRoleName;
import com.nullspace.apiusermanagement.service.interfaces.IUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StartUpData implements CommandLineRunner {

    private final IUserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public StartUpData(IUserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void run(String... args) {
        loadData();
    }

    private void loadData() {

        // Roles
        Authority adminAuth = new Authority(10L, UserRoleName.ROLE_ADMIN);
        Authority userAuth = new Authority(11L, UserRoleName.ROLE_USER);
        List<Authority> adminAuthorities = new ArrayList<>();
        List<Authority> userAuthorities = new ArrayList<>();
        adminAuthorities.add(adminAuth);
        userAuthorities.add(userAuth);
        // End Roles

        User user1 = new User(1L, "Ryan", "Walker", "ryanwalker@example.com", bCryptPasswordEncoder.encode("test"), "rwalker");
        user1.setAuthorities(adminAuthorities);

        User user2 = new User(2L, "Alicia", "Walker", "Aliciawalker@example.com", bCryptPasswordEncoder.encode("test1"), "awalker");
        user2.setAuthorities(userAuthorities);

        User user3 = new User(3L, "Landon", "Gavin", "Landongavin@example.com", bCryptPasswordEncoder.encode("test3"), "lgavin");
        user3.setAuthorities(adminAuthorities);

//        User user1 = User.builder().id(1L).firstName("Ryan").lastName("Walker")
//                .emailAddress("ryanwalker@example.com")
//                .password(bCryptPasswordEncoder.encode("test"))
//                .roles(roles).build();
//        User user2 = User.builder().id(2L).firstName("Alicia").lastName("Walker")
//                .emailAddress("aliciawalker@example.com").build();
//        User user3 = User.builder().id(3L).firstName("Landon").lastName("Gavin")
//                .emailAddress("landongavin@example.com")
//                .password(bCryptPasswordEncoder.encode("test")).build();
//        User user4 = User.builder().id(4L).firstName("Nick").lastName("Schlenk")
//                .emailAddress("nickschlenk@example.com").build();
//        User user5 = User.builder().id(5L).firstName("Luke").lastName("Walker")
//                .emailAddress("lukewalker@example.com").build();
//        User user6 = User.builder().id(6L).firstName("Barbara").lastName("Gavin")
//                .emailAddress("barbaragavin@example.com").build();
//        User user7 = User.builder().id(7L).firstName("Vince").lastName("Stratful")
//                .emailAddress("vstrat@gmail.com").build();

        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
//        userService.save(user4);
//        userService.save(user5);
//        userService.save(user6);
//        userService.save(user7);

    }
}
