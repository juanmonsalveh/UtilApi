package com.utilapi.persistence.dao.impl;

import com.utilapi.core.dto.UserDTO;
import com.utilapi.persistence.dao.facade.IUserDAO;
import com.utilapi.persistence.entity.UserEntity;
import com.utilapi.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDao implements IUserDAO {


    private final UserRepository userRepository;

    @Autowired
    public UserDao(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO createUser(UserDTO bankUser) {
        return buildUserDTO(userRepository.save(buildUserEntity(bankUser)));

    }

    @Override
    public UserDTO getUserByUsername(String username) {
        return buildUserDTO(userRepository.findByUsername(username));
    }

    private UserEntity buildUserEntity(UserDTO userDTO) {
        return new UserEntity(
                userDTO.getIdentity(),
                userDTO.getName(),
                userDTO.getUsername(),
                userDTO.getPassword(),
                userDTO.getEmail(),
                userDTO.isBankEmployee()
        );
    }

    private UserDTO buildUserDTO(UserEntity userEntity) {
        return new UserDTO(
                userEntity.getName(),
                userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.getEmail(),
                userEntity.getIdentity(),
                userEntity.isBankEmployee()
        );
    }
}
