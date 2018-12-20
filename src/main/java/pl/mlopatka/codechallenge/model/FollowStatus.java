package pl.mlopatka.codechallenge.model;

import pl.mlopatka.codechallenge.dto.FollowStatusDto;

import java.util.Objects;

public class FollowStatus {

    private Integer id;
    private String followerNickname;
    private String followedUserNickname;
    private boolean follow;

    public FollowStatus() {
    }

    public FollowStatus(final Integer id, final FollowStatusDto followStatusDto) {
        this.id = id;
        this.followerNickname = followStatusDto.getFollowerNickname();
        this.followedUserNickname = followStatusDto.getFollowedUserNickname();
        this.follow = followStatusDto.isFollow();
    }

    public FollowStatus(final int id, final String followerNickname, final String followedUserNickname, final boolean follow) {
        this.id = id;
        this.followerNickname = followerNickname;
        this.followedUserNickname = followedUserNickname;
        this.follow = follow;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FollowStatus followStatus = (FollowStatus) o;
        return followerNickname.equals(followStatus.followerNickname) &&
                followedUserNickname.equals(followStatus.followedUserNickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(followerNickname, followedUserNickname);
    }

    @Override
    public String toString() {
        return "FollowStatus{" +
                "id=" + id +
                ", followerNickname='" + followerNickname + '\'' +
                ", followedUserNickname='" + followedUserNickname + '\'' +
                ", follow=" + follow +
                '}';
    }
}
