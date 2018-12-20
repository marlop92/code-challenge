package pl.mlopatka.codechallenge.services.followStatusService;

import pl.mlopatka.codechallenge.model.FollowStatus;

import java.util.Set;

public interface FollowStatusService {

    void updateFollowStatus(FollowStatus followStatus);

    Set<String> getFollowedUsersNicknames(String nickname);
}
