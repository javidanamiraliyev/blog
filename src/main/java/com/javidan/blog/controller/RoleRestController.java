package com.javidan.blog.controller;

import com.javidan.blog.domain.Role;
import com.javidan.blog.dto.RoleDTO;
import com.javidan.blog.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleRestController {
    private final RoleService roleService;
    private final Logger log = LoggerFactory.getLogger(RoleRestController.class);

    public RoleRestController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody @Validated Role role) {
        if(role.getName()==null ){
            return ResponseEntity.badRequest().build();
        }
        Role role1 = roleService.createRole(role);
        return ResponseEntity.ok(role);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Long id){
        if(roleService.getRoleById(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(roleService.getRoleById(id).get());
    }

    @GetMapping
    public List<Role> getRoles(){
        return roleService.getAllRoles();
    }
}
