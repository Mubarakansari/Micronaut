package com.lynkersoft.service;

import com.lynkersoft.entity.UserAccount;
import com.lynkersoft.utils.GenericResponse;

public interface UserService {

    GenericResponse create(UserAccount userAccount);
    GenericResponse find(String userId);
    GenericResponse findAll();
    GenericResponse delete(String userId);
}
