package org.cleanarchitecture.infrastructure.store;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.cleanarchitecture.core.entity.User;
import org.cleanarchitecture.core.usecase.model.Page;
import org.cleanarchitecture.core.usecase.model.SearchUserInput;
import org.cleanarchitecture.core.usecase.repository.UserRepository;

/**
 * @author : wangqijia create at:  2024/12/5  11:41 AM
 */
public class InMemoryUserRepository implements UserRepository {

    private final ConcurrentMap<String, User> store = new ConcurrentHashMap<>();

    @Override
    public Optional<User> findByName(String name) {
        return Optional.ofNullable(store.get(name));
    }

    @Override
    public Page<User> findAll(SearchUserInput query) {
        List<User> filteredList = new ArrayList<>();
        store.forEach((name, User) -> {
            if (name.contains(query.getName())) {
                filteredList.add(User);
            }
        });

        int fromIndex = query.getPage() * query.getSize();
        int endIndex = fromIndex + query.getSize();
        List<User> Users = filteredList.subList(fromIndex, endIndex);
        return new Page<>(Users, query.getPage(), query.getSize(), filteredList.size());
    }

    @Override
    public User save(User User) {
        User.setId(UUID.randomUUID().toString());
        store.put(User.getName(), User);
        return User;
    }
}
