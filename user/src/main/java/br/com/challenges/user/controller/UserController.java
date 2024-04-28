package br.com.challenges.user.controller;

import br.com.challenges.user.dto.UserDto;
import br.com.challenges.user.infra.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;
    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody UserDto dto, UriComponentsBuilder uriComponentsBuilder){
        var user = service.saveUser(dto);
        var uri = uriComponentsBuilder.path("user/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).body(user);
    }
}