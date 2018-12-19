package pl.mlopatka.codechallenge.services.followService;

import pl.mlopatka.codechallenge.model.Following;

import java.util.List;

public interface FollowingService {

    //UC 3
    void updateFollowStatus(String followerNickname, String followedUserNickname, boolean follow);

    //UC 4
    List<String> getFollowedUsersNicknames();
}
