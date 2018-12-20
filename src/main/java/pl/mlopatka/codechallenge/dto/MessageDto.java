package pl.mlopatka.codechallenge.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MessageDto {

    @NotNull
    @Size(min = 1)
    private String authorNickname;
    @Size(max = 140)
    private String content;

    public MessageDto() {
    }

    public MessageDto(@NotNull @Size(min = 1) final String authorNickname, @Size(max = 140) final String content) {
        this.authorNickname = authorNickname;
        this.content = content;
    }

    public String getAuthorNickname() {
        return authorNickname;
    }

    public void setAuthorNickname(final String authorNickname) {
        this.authorNickname = authorNickname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(final String content) {
        this.content = content;
    }
}
