package com.lynkersoft.service.ServiceImpl;

import com.lynkersoft.entity.UserAccount;
import com.lynkersoft.repository.UserRepository;
import com.lynkersoft.service.UserService;
import com.lynkersoft.utils.GenericResponse;
import com.lynkersoft.exception.GenericException;
import com.lynkersoft.exception.NotFount;
import io.micronaut.http.HttpStatus;
import jakarta.inject.Singleton;

@Singleton
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public GenericResponse create(UserAccount userAccount) {
        return new GenericResponse(HttpStatus.CREATED, "User create successfully", userRepository.save(userAccount));
    }

    @Override
    public GenericResponse find(String userId) {
        return new GenericResponse(HttpStatus.OK, "", userRepository.findById(userId).orElseThrow(() -> new GenericException(NotFount.USER_ID_NOT_FOUND)));
    }

    @Override
    public GenericResponse findAll() {
        return new GenericResponse(HttpStatus.OK, "", userRepository.findAll());
    }

    @Override
    public GenericResponse delete(String userId) {
        userRepository.findById(userId).ifPresentOrElse(userAccount -> {
            userRepository.deleteById(userId);
        }, () -> {
            throw new GenericException(NotFount.USER_ID_NOT_FOUND);
        });
        return new GenericResponse(HttpStatus.OK, "User delete successfully", null);
    }
}
