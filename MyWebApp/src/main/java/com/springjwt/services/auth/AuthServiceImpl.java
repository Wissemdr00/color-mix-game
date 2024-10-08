package com.springjwt.services.auth;

import com.springjwt.dto.SignupDTO;
import com.springjwt.dto.UserDTO;
import com.springjwt.entities.Matrix;
import com.springjwt.entities.User;
import com.springjwt.repositories.MatrixRepository;
import com.springjwt.repositories.UserRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MatrixRepository matrixRepository;

    @Override
    public UserDTO createUser(SignupDTO signupDTO) {
        User user = new User();
        user.setName(signupDTO.getName());
        user.setEmail(signupDTO.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(signupDTO.getPassword()));
        User createdUser = userRepository.save(user);
        UserDTO userDTO = new UserDTO();
        userDTO.setId(createdUser.getId());
        userDTO.setEmail(createdUser.getEmail());
        userDTO.setName(createdUser.getName());
        //------------------------------------------
        Matrix initialmatrix = new Matrix();
        
        initialmatrix.setData(new String[][]{{"white"}});
        System.err.println(initialmatrix.getData());
        initialmatrix.setUserid(createdUser.getId().intValue());
        
        matrixRepository.save(initialmatrix);
        
        //--------------------------------
        return userDTO;
    }

}
