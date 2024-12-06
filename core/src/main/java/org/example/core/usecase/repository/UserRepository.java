package org.example.core.usecase.repository;


import java.util.Optional;
import org.example.core.entity.User;
import org.example.core.usecase.model.Page;
import org.example.core.usecase.model.SearchUserInput;

public interface UserRepository {

    Optional<User> findByName(String name);

    Page<User> findAll(SearchUserInput query);

    User save(User User);


}
