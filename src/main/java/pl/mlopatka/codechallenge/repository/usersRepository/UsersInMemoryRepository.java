package pl.mlopatka.codechallenge.repository.usersRepository;

import pl.mlopatka.codechallenge.model.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UsersInMemoryRepository implements UsersRepository {

    private Set<User> userList = new HashSet<>();

    @Override
    public void save(final User user) {
        userList.add(user);
    }

    @Override
    public boolean findUser(final String nickname) {
        return userList.contains(nickname);
    }
}
