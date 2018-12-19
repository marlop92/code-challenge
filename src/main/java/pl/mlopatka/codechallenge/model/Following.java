package pl.mlopatka.codechallenge.model;

import java.util.Objects;

public class Following {

    private int id;
    private String followerNickname;
    private String followingNickname;

    public Following() {
    }

    public Following(int id, String followerNickname, String followingNickname) {
        this.id = id;
        this.followerNickname = followerNickname;
        this.followingNickname = followingNickname;
    }

    public int getId() {
        return id;
    }

    public String getFollowerNickname() {
        return followerNickname;
    }

    public String getFollowingNickname() {
        return followingNickname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Following following = (Following) o;
        return id == following.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Following{" +
                "id=" + id +
                '}';
    }
}
