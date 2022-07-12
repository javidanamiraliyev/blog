package com.javidan.blog.controller.rest;

import com.javidan.blog.entity.Role;
import com.javidan.blog.entity.User;
import com.javidan.blog.dto.UserDTO;
import com.javidan.blog.exceptions.EmailAlreadyUsedException;
import com.javidan.blog.exceptions.UserNotFoundException;
import com.javidan.blog.service.RoleService;
import com.javidan.blog.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;
import java.util.Set;


@RestController
@RequestMapping("/api/users")
public class UserRestController {
    private final UserService userService;
    private final RoleService roleService;

    public UserRestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public Page<User> getUsers(@RequestParam int page, @RequestParam int size, @RequestParam(required = false) String sortBy){
        return userService.getUsers(page,size,sortBy);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        if(userService.getUserById(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userService.getUserById(id).get());
    }

    @GetMapping("/{id}/roles")
    public Set<Role> getUserRoles(@PathVariable Long id){
        return roleService.getRolesForUser(id);
    }

    @PostMapping("/{id}/roles")
    public ResponseEntity<Set<Role>> addUserRoles(@PathVariable Long id, @RequestBody Set<String> roles) throws UserNotFoundException{
        Optional<User> user = userService.getUserById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException();
        }
        Set<Role> newRoles = userService.addRolesToUser(id,roles);
        return ResponseEntity.ok(newRoles);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody @Validated UserDTO userDTO) throws EmailAlreadyUsedException, NoSuchAlgorithmException {
        if(userService.getUserByEmail(userDTO.getEmail()).isPresent()){
            throw new EmailAlreadyUsedException("Email is already used.");
        }

        return ResponseEntity.ok(userService.createUser(userDTO));
    }
}
