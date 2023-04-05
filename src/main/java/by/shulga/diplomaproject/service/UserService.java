package by.shulga.diplomaproject.service;

import by.shulga.diplomaproject.converter.UserConverter;
import by.shulga.diplomaproject.dto.AuthRequest;
import by.shulga.diplomaproject.dto.UserDTO;
import by.shulga.diplomaproject.entity.Role;
import by.shulga.diplomaproject.entity.User;
import by.shulga.diplomaproject.repository.RoleRepository;
import by.shulga.diplomaproject.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor

public class UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    private final UserConverter converter;



    public void save(AuthRequest request){
        UserDTO userDTO = new UserDTO();
        userDTO.setRoleId(1L);
        userDTO.setLogin(request.getLogin());
        userDTO.setPassword(request.getPassword());
        save(userDTO);
    }

    @Transactional
    public UserDTO save (UserDTO userDTO){
        long roleId = userDTO.getRoleId();
        Role role = roleRepository
                .findById(roleId)
                .orElseThrow();
        User user = converter.convert(userDTO);
        user.setRole(role);
        //user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return converter.convert(user);
    }

    public Optional<User> findByLogin(String login){
        return userRepository.findByLogin(login);
    }

    public User getTokenForUserIfExists(AuthRequest authRequest){
        return findByLoginAndPassword(authRequest.getLogin(), authRequest.getPassword()).orElseThrow();
    }

    public Optional<User> findByLoginAndPassword(String login, String password){
        User user = findByLogin(login).orElseThrow();
        if(passwordEncoder.matches(password, user.getPassword())){
            return Optional.of(user);
        }
        return Optional.empty();
    }
}
