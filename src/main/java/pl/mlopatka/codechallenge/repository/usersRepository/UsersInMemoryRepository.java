package pl.mlopatka.codechallenge.repository.usersRepository;

import pl.mlopatka.codechallenge.model.User;

import java.util.HashSet;
import java.util.Set;

public class UsersInMemoryRepository implements UsersRepository {

    private final Set<User> userList;

    public UsersInMemoryRepository() {
        userList = new HashSet<>();
    }

    public UsersInMemoryRepository(final Set<User> userList) {
        this.userList = userList;
    }

    @Override
    public void save(final User user) {
        userList.add(user);
    }

    @Override
    public boolean exists(final User user) {
        return userList.contains(user);
    }
}
