package pl.mlopatka.codechallenge.repository.followsRepository;

import pl.mlopatka.codechallenge.model.Following;

import java.util.List;

public interface FollowsRepository {

    void save(Following following);

    List<String> getFollowedUsersNicknames(String nickname);
}
