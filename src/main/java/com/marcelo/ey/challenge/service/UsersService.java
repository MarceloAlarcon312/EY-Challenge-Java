package com.marcelo.ey.challenge.service;

import com.marcelo.ey.challenge.config.helper.CryptoHelper;
import com.marcelo.ey.challenge.config.helper.JwtHelper;
import com.marcelo.ey.challenge.config.helper.MessageHelper;
import com.marcelo.ey.challenge.dto.UserRegisterDTO;
import com.marcelo.ey.challenge.entity.User;
import com.marcelo.ey.challenge.exception.EyException;
import com.marcelo.ey.challenge.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class UsersService {

    private static final ModelMapper modelMapper = new ModelMapper();
    private final UserRepository userRepository;
    private final CryptoHelper cryptoHelper;
    private final JwtHelper jwtHelper;

    public User save(UserRegisterDTO registerDto) {
        log.info("save | registerDto={}", registerDto);
        registerDto.setPassword(cryptoHelper.encode(registerDto.getPassword()));
        registerDto.setToken(jwtHelper.createToken(registerDto.getEmail()));
        return userRepository.save(modelMapper.map(registerDto, User.class));
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void validNotExistByEmail(String email) throws EyException {
        Optional<User> users = findByEmail(email);
        if (users.isPresent()) {
            throw new EyException(MessageHelper.MESSAGE_EMAIL_EXISTS);
        }
    }
}
