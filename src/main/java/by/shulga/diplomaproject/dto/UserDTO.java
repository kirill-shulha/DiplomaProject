package by.shulga.diplomaproject.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String login;
    private String password;
    private Long roleId;
}
