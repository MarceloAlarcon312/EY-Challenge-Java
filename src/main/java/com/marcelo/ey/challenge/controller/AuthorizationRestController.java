package com.marcelo.ey.challenge.controller;

import com.marcelo.ey.challenge.dto.UserRegisterDTO;
import com.marcelo.ey.challenge.service.AuthorizationService;
import com.marcelo.ey.challenge.exception.EyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping(path = "/auth/v1")
public class AuthorizationRestController {

    AuthorizationService authorizationService;

    @Autowired
    public AuthorizationRestController(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> userRegister(@Valid @RequestBody UserRegisterDTO userRegisterDTO) throws EyException {
        log.info("user-register | UserRegisterDto={}", userRegisterDTO.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(authorizationService.register(userRegisterDTO));
    }
}
