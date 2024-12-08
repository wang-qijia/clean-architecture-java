package org.cleanarchitecture.core.usecase.repository;


import java.util.Optional;
import org.cleanarchitecture.core.entity.User;
import org.cleanarchitecture.core.usecase.model.Page;
import org.cleanarchitecture.core.usecase.model.SearchUserInput;

public interface UserRepository {

    Optional<User> findByName(String name);

    Page<User> findAll(SearchUserInput query);

    User save(User User);


}
