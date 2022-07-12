package com.javidan.blog.service;

import com.javidan.blog.dto.UserDTO;
import com.javidan.blog.entity.Role;
import com.javidan.blog.entity.User;
import com.javidan.blog.repository.RoleRepository;
import com.javidan.blog.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public Page<User> getUsers(int page, int size, String sortBy){
        Pageable paging;
        if(sortBy==null){
            paging = PageRequest.of(page,size);
        }
        else{
            paging = PageRequest.of(page,size, Sort.by(sortBy));
        }

        return userRepository.findAll(paging);

    }

    public User createUser(UserDTO userDTO) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] passwordHash = digest.digest(userDTO.getPassword().getBytes(StandardCharsets.UTF_8));
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPassword(Arrays.toString(passwordHash));
        Set<Role> roles = new HashSet<>();
        for(Role role : userDTO.getRoles()){
            if(roleRepository.findRoleByName(role.getName()).isPresent()){
                roles.add(role);
            }
        }
        user.setRoles(roles);
        return userRepository.save(user);
    }

    public Optional<User> getUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }

    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    public Set<Role> addRolesToUser(Long userId, Set<String> rolesSet){
        Optional<User> user = userRepository.findById(userId);
        Set<Role> roles = new HashSet<>();
        for(String s : rolesSet){
            Optional<Role> role = roleRepository.findRoleByName(s);
            role.ifPresent(roles::add);
        }
        user.ifPresent(user1 -> {
            user1.setRoles(roles);
            userRepository.save(user1);
        });

        return roles;
    }
}
