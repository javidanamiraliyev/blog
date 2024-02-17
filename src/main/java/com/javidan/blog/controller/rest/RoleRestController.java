package com.javidan.blog.controller.rest;

import com.javidan.blog.dto.RoleDTO;
import com.javidan.blog.entity.Role;
import com.javidan.blog.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
public class RoleRestController {
    private final RoleService roleService;
    private final Logger log = LoggerFactory.getLogger(RoleRestController.class);

    public RoleRestController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody @Validated RoleDTO roleDTO) {
        if(roleDTO.getName()==null ){
            return ResponseEntity.badRequest().build();
        }
        Optional<Role> role = roleService.createRole(roleDTO);
        return role.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
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
