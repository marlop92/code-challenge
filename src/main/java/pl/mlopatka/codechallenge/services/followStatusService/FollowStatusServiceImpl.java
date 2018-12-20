package pl.mlopatka.codechallenge.services.followStatusService;

import pl.mlopatka.codechallenge.model.FollowStatus;
import pl.mlopatka.codechallenge.repository.followStatusRepository.FollowStatusRepository;

import java.util.List;

public class FollowStatusServiceImpl implements FollowStatusService {

    private final FollowStatusRepository followStatusRepository;

    public FollowStatusServiceImpl(final FollowStatusRepository followStatusRepository) {
        this.followStatusRepository = followStatusRepository;
    }

    @Override
    public void updateFollowStatus(final FollowStatus followStatus) {
        followStatusRepository.updateFollowStatus(followStatus);
    }

    @Override
    public List<String> getFollowedUsersNicknames(final String nickname) {
        return followStatusRepository.getFollowedUsersNicknames(nickname);
    }
}
