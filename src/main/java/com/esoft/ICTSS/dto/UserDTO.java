package com.esoft.ICTSS.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class UserDTO implements Serializable {

    private String username;
    private String password;
    private String email;
    private String userType; // "Driver", "Customer", "Admin"
    private String profileImage; // Image URL or path
    private String contact;
}
