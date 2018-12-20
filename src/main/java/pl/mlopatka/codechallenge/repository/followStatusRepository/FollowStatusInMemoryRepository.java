package pl.mlopatka.codechallenge.repository.followStatusRepository;

import pl.mlopatka.codechallenge.dto.FollowStatusDto;
import pl.mlopatka.codechallenge.model.FollowStatus;

import java.util.HashSet;
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
    public void updateFollowStatus(final FollowStatusDto followStatus) {
        if (followStatus.isFollow()) {
            followStatusesList.add(new FollowStatus(idCounter++, followStatus));
        } else {
            followStatusesList.removeIf(
                    n ->  (n.getFollowedUserNickname().equals(followStatus.getFollowedUserNickname())
                            && (n.getFollowerNickname().equals(followStatus.getFollowerNickname()))
                    ));
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
