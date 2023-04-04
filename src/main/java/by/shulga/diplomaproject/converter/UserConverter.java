package by.shulga.diplomaproject.converter;

import by.shulga.diplomaproject.dto.UserDTO;
import by.shulga.diplomaproject.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public User convert(UserDTO userDTO){
        User user = new User();
        user.setLogin(userDTO.getLogin());
        user.setPassword(userDTO.getPassword());
        return user;
    }

    public UserDTO  convert (User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setLogin(user.getLogin());
        userDTO.setPassword(user.getPassword());
        userDTO.setRoleId(user.getRole().getId());
        return userDTO;
    }
}
