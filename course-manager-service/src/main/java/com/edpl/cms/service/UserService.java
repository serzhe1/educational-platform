package com.edpl.cms.service;

import com.edpl.cms.persistence.model.UserEntity;
import com.edpl.cms.persistence.repository.UserRepository;
import com.edpl.cms.web.dto.UserDto;
import com.edpl.cms.web.exhandler.exceptions.ApplicationBadRequest;
import com.edpl.cms.web.exhandler.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    @Transactional
    public  UserEntity getUserEntity() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User is not found with name: " + username));

    }

    @Transactional
    public UserDto save(UserDto userDto) {
        if (userDto.getId() != null) {
            throw new ApplicationBadRequest("id should be null");
        }

        UserEntity entity = new UserEntity();
        entity.setUsername(userDto.getUsername());
        entity.setFullName(userDto.getFullName());

        entity = userRepository.save(entity);

        return modelMapper.map(entity, UserDto.class);
    }

    @Transactional
    public UserDto update(UserDto userDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        UserEntity entity = userRepository
                .findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User is not found with name: " + username));

        entity.setFullName(userDto.getFullName());

        entity = userRepository.save(entity);
        return modelMapper.map(entity, UserDto.class);
    }

    @Transactional
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public UserDto getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        UserEntity entity = userRepository
                .findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User is not found with name: " + username));

        return modelMapper.map(entity, UserDto.class);
    }

    @Transactional(readOnly = true)
    public List<UserDto> getAll() {
        List<UserEntity> users =  userRepository.findAll();

        return users.stream().map(u -> modelMapper.map(u, UserDto.class)).toList();
    }

}


