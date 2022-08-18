package com.lynkersoft.repository;

import com.lynkersoft.entity.UserAccount;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
@Repository
public interface UserRepository extends CrudRepository<UserAccount, String> {
}
