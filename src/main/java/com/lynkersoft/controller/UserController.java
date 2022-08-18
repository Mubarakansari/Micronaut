package com.lynkersoft.controller;

import com.lynkersoft.entity.UserAccount;
import com.lynkersoft.service.UserService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;

import javax.validation.Valid;

@Controller("/userController/")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Post(value = "create", processes = MediaType.APPLICATION_JSON)
    public HttpResponse<?> create(@Body @Valid UserAccount userAccount) {
        return HttpResponse.created(userService.create(userAccount));
    }

    @Get(value = "fetch/{userId}", processes = MediaType.APPLICATION_JSON)
    public HttpResponse<?> fetch(@PathVariable String userId) {
        return HttpResponse.status(HttpStatus.OK).body(userService.find(userId));
    }

    @Get(value = "fetchAll", processes = MediaType.APPLICATION_JSON)
    public HttpResponse<?> fetchAll() {
        return HttpResponse.status(HttpStatus.OK).body(userService.findAll());
    }

    @Delete(value = "delete", processes = MediaType.APPLICATION_JSON)
    public HttpResponse<?> delete(@QueryValue(value = "userId") String userId) {
        return HttpResponse.status(HttpStatus.OK).body(userService.delete(userId));
    }
}
