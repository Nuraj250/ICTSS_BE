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
public class LoginRequestDto implements Serializable {

    private String username;
    private String password;
}
