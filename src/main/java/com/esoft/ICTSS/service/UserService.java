package com.esoft.ICTSS.service;

import com.esoft.ICTSS.dto.LoginRequestDto;
import com.esoft.ICTSS.dto.UserDto;
import com.esoft.ICTSS.model.User;
import com.esoft.ICTSS.util.ResponseMessage;

public interface UserService {

    ResponseMessage registerUser(UserDto userDTO);

    ResponseMessage registerUserByOperator(UserDto userDTO);

    ResponseMessage updateUser(Long id, UserDto userDTO);

    ResponseMessage getUserById(Long id);

    ResponseMessage deleteUser(Long id);

    ResponseMessage getAllUsers();

    User findUserByUsername(String username);

    ResponseMessage authenticate(LoginRequestDto userDTO);
}
