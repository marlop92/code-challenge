package pl.mlopatka.codechallenge.services.followService;

import pl.mlopatka.codechallenge.model.Following;

import java.util.List;

public interface FollowingService {

    void updateFollowStatus(String followerNickname, String followedUserNickname, boolean follow);

    List<String> getFollowedUsersNicknames(String nickname);
}
