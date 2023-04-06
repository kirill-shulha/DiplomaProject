package by.shulga.diplomaproject.controller;

import by.shulga.diplomaproject.dto.AuthRequest;
import by.shulga.diplomaproject.dto.AuthResponse;
import by.shulga.diplomaproject.entity.User;
import by.shulga.diplomaproject.jvt.JwtTokenUtil;
import by.shulga.diplomaproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class AuthController {
    private final UserService userService;
    private final JwtTokenUtil tokenUtil;


    @PostMapping("registration")
    public void createUser(@RequestBody AuthRequest authRequest){
        userService.save(authRequest);
    }

    @PostMapping("login")
    public AuthResponse login(@RequestBody AuthRequest authRequest){
        User user = userService.getTokenForUserIfExists(authRequest);
        return new AuthResponse(tokenUtil.generateToken(user.getLogin()));
    }
}
