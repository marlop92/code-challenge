package pl.mlopatka.codechallenge.services.followService;

import pl.mlopatka.codechallenge.model.Following;

import java.util.List;

public interface FollowingService {

    //UC 3
    void updateFollowersList(int followingId, boolean followingUser);

    //UC 4
    List<Following> getFollowedUsersList();
}
