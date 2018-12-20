package pl.mlopatka.codechallenge.repository.followStatusRepository;

import pl.mlopatka.codechallenge.model.FollowStatus;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FollowStatusInMemoryRepository implements FollowStatusRepository {

    private final Set<FollowStatus> followStatusesList;
    private int idCounter;

    public FollowStatusInMemoryRepository() {
        followStatusesList = new HashSet<>();
        idCounter = 0;
    }

    public FollowStatusInMemoryRepository(final Set<FollowStatus> followStatusesList) {
        this.followStatusesList = followStatusesList;
        idCounter = 0;
    }

    @Override
    public void updateFollowStatus(final FollowStatus followStatus) {
        if (followStatus.isFollow()) {
            followStatus.setId(idCounter++);
            followStatusesList.add(followStatus);
        } else {
            followStatusesList.remove(followStatus);
        }
    }

    @Override
    public Set<String> getFollowedUsersNicknames(final String nickname) {
        return followStatusesList.stream()
                .filter(following -> following.getFollowerNickname().equals(nickname))
                .map(FollowStatus::getFollowedUserNickname)
                .collect(Collectors.toSet());
    }
}
