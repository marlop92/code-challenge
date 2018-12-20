package pl.mlopatka.codechallenge.services.followService;

import pl.mlopatka.codechallenge.repository.followsRepository.FollowsRepository;

import java.util.List;

public class FollowingServiceImpl implements FollowingService {

    private final FollowsRepository followsRepository;

    public FollowingServiceImpl(FollowsRepository followsRepository) {
        this.followsRepository = followsRepository;
    }

    @Override
    public void updateFollowStatus(String followerNickname, String followedUserNickname, boolean follow) {
        followsRepository.updateStatus(followerNickname, followedUserNickname, follow);
    }

    @Override
    public List<String> getFollowedUsersNicknames(String nickname) {
        return followsRepository.getFollowedUsersNicknames(nickname);
    }
}
