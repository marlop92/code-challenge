package pl.mlopatka.codechallenge.repository.followsRepository;

import pl.mlopatka.codechallenge.model.Following;

import java.util.List;

public interface FollowsRepository {

    void updateStatus(String followerNickname, String followedNickname, boolean follow);

    List<String> getFollowedUsersNicknames(String nickname);
}
