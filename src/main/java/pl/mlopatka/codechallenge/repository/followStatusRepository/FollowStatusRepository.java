package pl.mlopatka.codechallenge.repository.followStatusRepository;

import pl.mlopatka.codechallenge.model.FollowStatus;

import java.util.List;

public interface FollowStatusRepository {

    void updateFollowStatus(FollowStatus followStatus);

    List<String> getFollowedUsersNicknames(String nickname);
}
