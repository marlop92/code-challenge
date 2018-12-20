package pl.mlopatka.codechallenge.repository.followStatusRepository;

import pl.mlopatka.codechallenge.model.FollowStatus;

import java.util.Set;

public interface FollowStatusRepository {

    void updateFollowStatus(FollowStatus followStatus);

    Set<String> getFollowedUsersNicknames(String nickname);
}
