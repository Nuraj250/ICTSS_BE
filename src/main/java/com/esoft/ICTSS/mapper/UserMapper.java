package com.esoft.ICTSS.mapper;

import com.esoft.ICTSS.dto.UserDto;
import com.esoft.ICTSS.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto userToUserDTO(User user);

    User userDTOToUser(UserDto userDTO);
}
