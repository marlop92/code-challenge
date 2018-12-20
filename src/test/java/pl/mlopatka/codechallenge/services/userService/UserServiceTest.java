package pl.mlopatka.codechallenge.services.userService;

import org.junit.Before;
import org.junit.Test;
import pl.mlopatka.codechallenge.exceptions.UserNotFoundException;
import pl.mlopatka.codechallenge.model.User;
import pl.mlopatka.codechallenge.repository.usersRepository.UsersRepository;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    private UserService userService;
    private UsersRepository usersRepository;

    @Before
    public void setUp() {
        usersRepository = mock(UsersRepository.class);
        userService = new UserServiceImpl(usersRepository);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenNull() {
        //given
        User user = null;

        //when
        userService.validateUser(user);

        //than expect exception
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenEmpty() {
        //given
        User user = new User("");

        //when
        userService.validateUser(user);

        //than expect exception
    }

    @Test(expected = UserNotFoundException.class)
    public void shouldThrowExceptionWhenUserNotFound() {
        //given
        User user = new User("abc");
        when(usersRepository.exists(new User("abc"))).thenReturn(false);

        //when
        userService.validateUser(user);

        //than expect exception
    }
}