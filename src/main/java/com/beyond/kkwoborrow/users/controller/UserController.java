package com.beyond.kkwoborrow.users.controller;

import com.beyond.kkwoborrow.users.dto.UserRequestDto;
import com.beyond.kkwoborrow.users.dto.UserResponseDto;
import com.beyond.kkwoborrow.users.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Users APIs", description = "회원 관련 API 목록")
public class UserController {
    @Autowired
    UserService userService;

    // 회원 추가(회원 가입)
    @PostMapping("/users")
    public ResponseEntity<UserResponseDto> enroll(@RequestBody UserRequestDto newUser) {
        UserResponseDto userResponseDto = userService.save(newUser);
        if (userResponseDto != null){
            return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    // 회원 정보 불러오기
    @GetMapping("/users/{user-id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable("user-id") Long userId) {
        UserResponseDto userResponseDto = userService.getUser(userId);
        if (userResponseDto != null){
            return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 회원 정보 수정
    @PatchMapping("/users/{user-id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable("user-id") Long userId, @RequestBody UserRequestDto updateUser) {
        UserResponseDto userResponseDto =  userService.updateUser(userId, updateUser);
        if (userResponseDto != null){
            return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    // 회원 삭제
    @DeleteMapping("/users/{user-id}")
    public void deleteUser(@PathVariable("user-id") Long userId) {
        userService.deleteUser(userId);
    }

}