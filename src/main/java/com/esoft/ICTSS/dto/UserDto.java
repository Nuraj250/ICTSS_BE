package com.esoft.ICTSS.dto;

import com.esoft.ICTSS.enums.RoleType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class UserDto implements Serializable {

    private Long id;
    private String username;
    private String password;
    private String email;
    private RoleType role; // Role to be set during registration
    private String profileImage; // Image URL or path
    private String contact;
}
