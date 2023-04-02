package by.mitr.jmpcloudserviceimpl.mapper;

import by.mitr.dto.UserRequestDto;
import by.mitr.dto.UserResponseDto;
import by.mitr.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target="birthday", source = "birthday",
            dateFormat = "yyyy-MM-dd")
    UserResponseDto userToUserResponseDto(User user);

    @Mapping(target="birthday", source = "birthday",
            dateFormat = "yyyy-MM-dd")
   User UserRequestDtoToUser(UserRequestDto userRequest);
}
