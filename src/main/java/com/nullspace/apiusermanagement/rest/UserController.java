package com.nullspace.apiusermanagement.rest;

import com.nullspace.apiusermanagement.model.User;
import com.nullspace.apiusermanagement.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping( value = "/api", produces = MediaType.APPLICATION_JSON_VALUE )
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping( method = GET, value = "/user/{userId}" )
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public User loadById(@PathVariable Long userId ) {
        return this.userService.findById( userId );
    }

    @RequestMapping( method = GET, value= "/user/all")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<User> loadAll() {
        return this.userService.findAll();
    }


    /*
     *  We are not using userService.findByUsername here(we could),
     *  so it is good that we are making sure that the user has role "ROLE_USER"
     *  to access this endpoint.
     */
    @RequestMapping("/whoami")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public User user(Principal user) {
        return this.userService.findByUsername(user.getName());
    }
}
