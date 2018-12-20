package pl.mlopatka.codechallenge.services.userService;

import pl.mlopatka.codechallenge.model.User;

import java.util.Optional;

public interface UserService {

    void create(User user);

    boolean userExists(String nickname);

    void validateUser(String nickname);
}
