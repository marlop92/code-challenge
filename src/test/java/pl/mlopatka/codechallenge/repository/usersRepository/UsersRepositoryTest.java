package pl.mlopatka.codechallenge.repository.usersRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.mlopatka.codechallenge.model.User;

import java.util.HashSet;
import java.util.Set;

public class UsersRepositoryTest {

    private UsersRepository repository;
    private Set<User> actualCollection;

    @Before
    public void setUp() {
        actualCollection = new HashSet<>();
        repository = new UsersInMemoryRepository(actualCollection);
    }

    @Test
    public void shouldAddUserToList() {
        //given
        User user = new User("Alan");
        Set<User> expected = new HashSet<>();
        expected.add(new User("Alan"));

        //when
        repository.save(user);

        //than
        Assert.assertEquals(expected, actualCollection);
    }

    @Test
    public void shouldConfirmUserExistence() {
        //given
        User user = new User("Alan");
        actualCollection.add(new User("Alan"));

        //when
        boolean exists = repository.exists(user);

        //than
        Assert.assertTrue(exists);
    }

}