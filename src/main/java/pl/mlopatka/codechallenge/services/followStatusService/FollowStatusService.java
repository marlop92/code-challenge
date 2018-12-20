package pl.mlopatka.codechallenge.services.followStatusService;

import pl.mlopatka.codechallenge.dto.FollowStatusDto;

import java.util.Set;

public interface FollowStatusService {

    void updateFollowStatus(FollowStatusDto followStatus);

    Set<String> getFollowedUsersNicknames(String nickname);
}
