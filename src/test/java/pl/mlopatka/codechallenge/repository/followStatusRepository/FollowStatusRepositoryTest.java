package pl.mlopatka.codechallenge.repository.followStatusRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.mlopatka.codechallenge.model.FollowStatus;

import java.util.HashSet;
import java.util.Set;

public class FollowStatusRepositoryTest {

    private FollowStatusRepository repository;
    private Set<FollowStatus> actualFollowStatusCollection;

    @Before
    public void setUp() {
        actualFollowStatusCollection = new HashSet<>();
        repository = new FollowStatusInMemoryRepository(actualFollowStatusCollection);
    }

    @Test
    public void shouldAddFollowStatusToCollection() {
        //given
        FollowStatus follow = new FollowStatus("User1", "User2", true);
        Set<FollowStatus> expectedCollection = new HashSet<>();
        expectedCollection.add(new FollowStatus("User1", "User2", true));

        //when
        repository.updateFollowStatus(follow);

        //than
        Assert.assertEquals(expectedCollection, actualFollowStatusCollection);
    }

    @Test
    public void shouldRemoveFollowStatusFromCollection() {
        //given
        FollowStatus follow = new FollowStatus("User1", "User2", false);
        Set<FollowStatus> expectedCollection = new HashSet<>();

        //when
        repository.updateFollowStatus(follow);

        //than
        Assert.assertEquals(expectedCollection, actualFollowStatusCollection);
    }

    @Test
    public void shouldReturnValidListOfNicknames() {
        //given
        FollowStatus followUser1 = new FollowStatus("User", "User1", false);
        FollowStatus followUser2 = new FollowStatus("User", "User2", false);
        actualFollowStatusCollection.add(followUser1);
        actualFollowStatusCollection.add(followUser2);

        Set<String> expectedCollection = new HashSet<>();
        expectedCollection.add("User1");
        expectedCollection.add("User2");

        //when
        Set<String> result = repository.getFollowedUsersNicknames("User");

        //than
        Assert.assertEquals(expectedCollection, result);
    }

}