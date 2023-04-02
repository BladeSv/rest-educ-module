package by.mitr.jmpcloudserviceimpl.controller;

import by.mitr.contoller.UserController;

import by.mitr.dto.UserRequestDto;
import by.mitr.dto.UserResponseDto;
import by.mitr.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    @Override
    public UserResponseDto getUser(@PathVariable Long id) {
        return addHATEOAS(userService.getUser(id));
    }

    @GetMapping
    @Override
    public List<UserResponseDto> getAllUser() {
        return  userService.getAllUser().stream()
                .map(this::addHATEOAS)
                .toList();

    }

    @PostMapping
    @Override
    public UserResponseDto createUser(@RequestBody UserRequestDto user) {
        return addHATEOAS(userService.createUser(user));
    }

    @PutMapping
    @Override
    public UserResponseDto updateUser(@RequestBody UserRequestDto user) {
        return addHATEOAS(userService.updateUser(user));
    }

    @DeleteMapping("/{id}")
    @Override
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }


    private UserResponseDto addHATEOAS(UserResponseDto dto){
        dto.add(linkTo(methodOn(UserControllerImpl.class).getUser(dto.getId())).withSelfRel());
        dto.add(linkTo(methodOn(UserControllerImpl.class).getAllUser()).withRel(IanaLinkRelations.COLLECTION));
        return dto;
    }
}

