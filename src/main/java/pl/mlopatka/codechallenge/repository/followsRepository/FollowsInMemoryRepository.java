package pl.mlopatka.codechallenge.repository.followsRepository;

import pl.mlopatka.codechallenge.model.Following;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FollowsInMemoryRepository implements FollowsRepository{

    private List<Following> followsList = new ArrayList<>();

    @Override
    public void save(Following following) {
        followsList.add(following);
    }

    @Override
    public List<String> getFollowedUsersNicknames(String nickname) {
        return followsList.stream().map(following -> following.getFollowerNickname())
                .filter(followerNickname -> followerNickname.equals(nickname)).collect(Collectors.toList());
    }
}
