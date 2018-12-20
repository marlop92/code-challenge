package pl.mlopatka.codechallenge.repository.followStatusRepository;

import org.junit.Before;
import pl.mlopatka.codechallenge.model.FollowStatus;

import java.util.HashSet;
import java.util.Set;

public class FollowStatusRepositoryTest {

    private FollowStatusRepository repository;
    private Set<FollowStatus> followsList;

    @Before
    public void setUp() {
        followsList = new HashSet<>();
        repository = new FollowStatusInMemoryRepository(followsList);
    }

//    public void updateFollowStatus

}