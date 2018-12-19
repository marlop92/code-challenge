package pl.mlopatka.codechallenge.repository.usersRepository;

import pl.mlopatka.codechallenge.model.User;

import java.util.Optional;

public interface UsersRepository {

    void save(User user);

    boolean findUser(String nickname);
}
