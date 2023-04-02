package by.mitr.service;


import by.mitr.dto.UserRequestDto;
import by.mitr.dto.UserResponseDto;
import java.util.List;


public interface UserService {
     UserResponseDto getUser(Long id);
     List<UserResponseDto> getAllUser();
     UserResponseDto createUser(UserRequestDto user);
     UserResponseDto updateUser(UserRequestDto user);
     void deleteUser(Long id);
}
