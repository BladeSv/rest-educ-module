package by.mitr.jmpcloudserviceimpl.service;


import by.mitr.dto.UserRequestDto;
import by.mitr.dto.UserResponseDto;
import by.mitr.jmpcloudserviceimpl.mapper.UserMapper;
import by.mitr.jmpcloudserviceimpl.repository.UserRepository;
import by.mitr.model.User;
import by.mitr.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
@Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    public UserResponseDto getUser(Long id){
    return userMapper.userToUserResponseDto(userRepository.findById(id).get());
    }
    public List<UserResponseDto> getAllUser(){
        return Streamable.of(userRepository.findAll())
                .map(userMapper::userToUserResponseDto)
                .toList();
    }
    public UserResponseDto createUser(UserRequestDto user){

        return userMapper.userToUserResponseDto(userRepository.save(userMapper.UserRequestDtoToUser(user)));
    }
    public UserResponseDto updateUser(UserRequestDto user){
        return userMapper.userToUserResponseDto(userRepository.save(userMapper.UserRequestDtoToUser(user)));
    }
    public void deleteUser(Long id){
    userRepository.deleteById(id);
    }
}
