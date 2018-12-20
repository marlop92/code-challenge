package pl.mlopatka.codechallenge.services.userService;

import org.springframework.util.Assert;
import pl.mlopatka.codechallenge.exceptions.UserNotFoundException;
import pl.mlopatka.codechallenge.model.User;
import pl.mlopatka.codechallenge.repository.usersRepository.UsersRepository;

import java.util.Optional;

public class UserServiceImpl implements UserService {

    public static final String USER_NICKNAME_NULL_ERROR_MSG = "User nickname can't be null";
    private final UsersRepository usersRepository;

    public UserServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public void create(User user) {
        usersRepository.save(user);
    }

    @Override
    public boolean userExists(String nickname) {
        Assert.notNull(nickname, USER_NICKNAME_NULL_ERROR_MSG);

        return usersRepository.findUser(nickname);
    }

    @Override
    public void validateUser(String nickname) {
        Assert.notNull(nickname, USER_NICKNAME_NULL_ERROR_MSG);

        if(!usersRepository.findUser(nickname)){
            throw new UserNotFoundException();
        }
    }
}
