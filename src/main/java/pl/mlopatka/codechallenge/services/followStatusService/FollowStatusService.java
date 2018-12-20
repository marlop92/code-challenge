package pl.mlopatka.codechallenge.services.followStatusService;

import pl.mlopatka.codechallenge.model.FollowStatus;

import java.util.List;

public interface FollowStatusService {

    void updateFollowStatus(FollowStatus followStatus);

    List<String> getFollowedUsersNicknames(String nickname);
}
