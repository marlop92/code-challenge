package pl.mlopatka.codechallenge.repository;

import pl.mlopatka.codechallenge.model.User;

import java.util.Optional;

public interface UsersRepository {

    void save(User user);

    Optional<User> findUser(String nickname);
}
