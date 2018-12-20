package pl.mlopatka.codechallenge.services.userService;

import org.springframework.util.Assert;
import org.springframework.web.bind.MethodArgumentNotValidException;
import pl.mlopatka.codechallenge.exceptions.UserNotFoundException;
import pl.mlopatka.codechallenge.model.User;
import pl.mlopatka.codechallenge.repository.usersRepository.UsersRepository;

public class UserServiceImpl implements UserService {

    private static final String USER_NICKNAME_NULL_ERROR_MSG = "User nickname can't be null";
    private static final String NULL_USER_EXCEPTION_MSG = "User can't be null";
    private final UsersRepository usersRepository;

    public UserServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public void create(final User user) {
        usersRepository.save(user);
    }

    @Override
    public boolean userExists(final User nickname) {
        return usersRepository.exists(nickname);
    }

    @Override
    public void validateUser(final User user) {
        Assert.notNull(user, NULL_USER_EXCEPTION_MSG);
        Assert.hasLength(user.getNickname(), USER_NICKNAME_NULL_ERROR_MSG);

        if(!usersRepository.exists(user)){
            throw new UserNotFoundException();
        }
    }
}
