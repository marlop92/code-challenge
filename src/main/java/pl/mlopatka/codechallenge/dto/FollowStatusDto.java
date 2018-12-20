package pl.mlopatka.codechallenge.dto;

import javax.validation.constraints.NotNull;

public class FollowStatusDto {

    @NotNull
    private String followerNickname;
    @NotNull
    private String followedUserNickname;
    private boolean follow;

    public FollowStatusDto() {
    }

    public FollowStatusDto(@NotNull final String followerNickname, @NotNull final String followedUserNickname, final boolean follow) {
        this.followerNickname = followerNickname;
        this.followedUserNickname = followedUserNickname;
        this.follow = follow;
    }

    public String getFollowerNickname() {
        return followerNickname;
    }

    public void setFollowerNickname(final String followerNickname) {
        this.followerNickname = followerNickname;
    }

    public String getFollowedUserNickname() {
        return followedUserNickname;
    }

    public void setFollowedUserNickname(final String followedUserNickname) {
        this.followedUserNickname = followedUserNickname;
    }

    public boolean isFollow() {
        return follow;
    }

    public void setFollow(final boolean follow) {
        this.follow = follow;
    }
}
