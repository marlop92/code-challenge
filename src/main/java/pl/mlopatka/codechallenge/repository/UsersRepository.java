package pl.mlopatka.codechallenge.repository;

import pl.mlopatka.codechallenge.model.User;

public interface UsersRepository {

    void save(User user);

    User getUser(String nickname);
}
