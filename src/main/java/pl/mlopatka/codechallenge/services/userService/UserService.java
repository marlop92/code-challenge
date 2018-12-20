package pl.mlopatka.codechallenge.services.userService;

import pl.mlopatka.codechallenge.model.User;

public interface UserService {

    void create(User user);

    boolean userExists(User nickname);

    void validateUser(User nickname);
}
