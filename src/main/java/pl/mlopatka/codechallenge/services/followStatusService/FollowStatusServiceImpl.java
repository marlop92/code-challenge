package pl.mlopatka.codechallenge.services.followStatusService;

import pl.mlopatka.codechallenge.dto.FollowStatusDto;
import pl.mlopatka.codechallenge.repository.followStatusRepository.FollowStatusRepository;

import java.util.Set;

public class FollowStatusServiceImpl implements FollowStatusService {

    private final FollowStatusRepository followStatusRepository;

    public FollowStatusServiceImpl(final FollowStatusRepository followStatusRepository) {
        this.followStatusRepository = followStatusRepository;
    }

    @Override
    public void updateFollowStatus(final FollowStatusDto followStatus) {
        followStatusRepository.updateFollowStatus(followStatus);
    }

    @Override
    public Set<String> getFollowedUsersNicknames(final String nickname) {
        return followStatusRepository.getFollowedUsersNicknames(nickname);
    }
}
