package by.mitr.contoller;

import by.mitr.dto.UserRequestDto;
import by.mitr.dto.UserResponseDto;

import java.util.List;

public interface UserController {
    public UserResponseDto getUser(Long id);
    public List<UserResponseDto>  getAllUser();
    public UserResponseDto createUser(UserRequestDto user);
    public UserResponseDto updateUser(UserRequestDto user);
    public void deleteUser(Long id);
}
