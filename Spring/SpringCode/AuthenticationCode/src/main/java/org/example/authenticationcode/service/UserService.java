package org.example.authenticationcode.service;

import jakarta.servlet.http.HttpSession;
import org.example.authenticationcode.db.UserRepository;
import org.example.authenticationcode.model.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void login(LoginRequest loginRequest, HttpSession httpSession) {
        var id = loginRequest.getId();
        var pw = loginRequest.getPassword();

        var optionalUser = userRepository.findyByName(id);

        if(optionalUser.isPresent()) {
            var userDto = optionalUser.get();

            if(userDto.getPassword().equals(pw)) {
                //세션에 정보 저장
                httpSession.setAttribute("User", userDto);
            }else {
                throw new RuntimeException("Password doesn't match");
            }

        }else {
            throw new RuntimeException("User Not Found");
        }
    }
}
