package pl.mlopatka.codechallenge.services.userService;

import pl.mlopatka.codechallenge.model.User;
import pl.mlopatka.codechallenge.repository.usersRepository.UsersRepository;

import java.util.Optional;

public class UserServiceImpl implements UserService {

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
        return usersRepository.findUser(nickname);
    }
}
