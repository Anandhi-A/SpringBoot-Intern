package com.example.springbootfirst.service;


import com.example.springbootfirst.models.RegisterDetails;
import com.example.springbootfirst.repository.RegisterDetailsRepository;
import com.fasterxml.jackson.databind.JsonSerializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.util.Objects;

@Service
public class AuthService {


    @Autowired
    private RegisterDetailsRepository registerDetailsRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public String addNewEmployee(RegisterDetails register){
        RegisterDetails registerDetails = new RegisterDetails();
        registerDetails.setEmpID(register.getEmpID());
        registerDetails.setEmail(register.getEmail());
        registerDetails.setGender(register.getGender());
        registerDetails.setRole(register.getRole());
        System.out.println("Password is "+register.getPassword()+"\n Encrtpted Password is "+passwordEncoder);
        registerDetails.setPassword(passwordEncoder.encode(register.getPassword()
        ));
        registerDetails.setDateOfBirth(register.getDateOfBirth());
        registerDetails.setEmpName(register.getEmpName());
        registerDetailsRepository.save(registerDetails);
        return "Employee Added Successfully";
    }

    public String authenticate(RegisterDetails login){
        RegisterDetails user = registerDetailsRepository.findByEmail(login.getEmail());
        if(user != null){
            if(passwordEncoder.matches(login.getPassword(),user.getPassword())){
                return "Login Successfully";
            }else{
                return "login not successfull";
            }

        }else{
            return "login not successfull";
        }
    }

}


