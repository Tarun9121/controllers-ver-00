package com.learning.cntrls.service;

import com.learning.cntrls.dto.RegisterDTO;
import com.learning.cntrls.entity.Register;
import com.learning.cntrls.repository.RegisterRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisterService {
    @Autowired
    private RegisterRepo registerRepo;

    @Autowired
    private ModelMapper mapper;

    public void addUser(RegisterDTO data) {
        Register entityData = mapper.map(data, Register.class);
        Optional<Register> dbData = registerRepo.findByEmail(entityData.getEmail());

        if(!dbData.isPresent()) {
            registerRepo.save(entityData);
            System.out.println("data saved");
        }
        else {
            System.out.println("the user already exists");
        }
    }

    public Optional<RegisterDTO> findById(int id) {
        Optional<Register> userData = registerRepo.findById(id);

        if(userData.isPresent()) {
            RegisterDTO userDataDto = mapper.map(userData, RegisterDTO.class);
            return Optional.ofNullable(userDataDto);
        }

        return null;
    }

//    public void validateLoginDetails(String email, String password) {
//
//    }
}