package com.javidan.blog.service;

import com.javidan.blog.dto.DTOMapper;
import com.javidan.blog.dto.RoleDTO;
import com.javidan.blog.entity.Role;
import com.javidan.blog.entity.User;
import com.javidan.blog.repository.RoleRepository;
import com.javidan.blog.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class RoleService {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    ModelMapper modelMapper = new ModelMapper();

    public RoleService(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    /**
     * Get <code>Role</code> by name
     * @param name role name
     * @return role
     */
    public Optional<Role> getRoleByName(String name){
        return roleRepository.findRoleByName(name);
    }

    /**
     * Get <code>Role</code> by id
     * @param id role id
     * @return <code>Optional&lt;Role&gt;</code>
     */
    public Optional<Role> getRoleById(Long id){
        return roleRepository.findById(id);
    }

    /**
     *
     * @return <code>List&lt;Role&gt;</code>
     */
    public List<Role> getAllRoles(){
        return roleRepository.findAll();
    }

    public Set<Role> getRolesForUser(Long userId){
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()){
            return user.get().getRoles();
        }
        return Set.of();

    }

    public Optional<Role> createRole(RoleDTO roleDTO){
        if(roleRepository.findRoleByName(roleDTO.getName()).isEmpty())
            return Optional.of(roleRepository.save(DTOMapper.mapToEntity(roleDTO)));
        else return Optional.empty();
    }
}
