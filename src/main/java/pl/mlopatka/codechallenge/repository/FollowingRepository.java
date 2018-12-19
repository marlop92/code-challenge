package pl.mlopatka.codechallenge.repository;

import pl.mlopatka.codechallenge.model.Following;

import java.util.List;

public interface FollowingRepository {

    void save(Following following);

    List<Following> getFollowedUsers(int userId);
}
