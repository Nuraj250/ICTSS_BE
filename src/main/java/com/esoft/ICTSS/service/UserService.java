package com.esoft.ICTSS.service;

import com.esoft.ICTSS.dto.UserDTO;
import com.esoft.ICTSS.model.User;
import com.esoft.ICTSS.util.ResponseMessage;

public interface UserService {

    ResponseMessage registerUser(UserDTO userDTO);

    ResponseMessage registerUserByOperator(UserDTO userDTO);

    ResponseMessage updateUser(Long id, UserDTO userDTO);

    ResponseMessage getUserById(Long id);

    ResponseMessage deleteUser(Long id);

    ResponseMessage getAllUsers();

    User findUserByUsername(String username);

    ResponseMessage authenticate(UserDTO userDTO);
}
