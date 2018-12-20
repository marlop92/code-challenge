package pl.mlopatka.codechallenge.repository.followStatusRepository;

import pl.mlopatka.codechallenge.dto.FollowStatusDto;

import java.util.Set;

public interface FollowStatusRepository {

    void updateFollowStatus(FollowStatusDto followStatus);

    Set<String> getFollowedUsersNicknames(String nickname);
}
