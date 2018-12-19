package pl.mlopatka.codechallenge.services.userService;

import pl.mlopatka.codechallenge.model.User;

import java.util.Optional;

public interface UserService {

    //UC 1
    void create(User user);

    //UC 1 i 4
    boolean userExists(String nickname);
}
