package pl.mlopatka.codechallenge.repository.followsRepository;

import pl.mlopatka.codechallenge.model.Following;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FollowsInMemoryRepository implements FollowsRepository{

    private Set<Following> followsList = new HashSet<>();
    private int idCounter = 0;

    @Override
    public void updateStatus(String followerNickname, String followedNickname, boolean follow) {
        if(follow){
            followsList.add(new Following(idCounter++, followerNickname, followedNickname));
        } else {
            followsList.remove(new Following(followerNickname, followedNickname));
        }
    }

    @Override
    public List<String> getFollowedUsersNicknames(String nickname) {
        return followsList.stream().map(following -> following.getFollowerNickname())
                .filter(followerNickname -> followerNickname.equals(nickname)).collect(Collectors.toList());
    }
}
