package pl.mlopatka.codechallenge.repository.usersRepository;

import pl.mlopatka.codechallenge.model.User;

public interface UsersRepository {

    void save(User user);

    boolean exists(User nickname);
}
