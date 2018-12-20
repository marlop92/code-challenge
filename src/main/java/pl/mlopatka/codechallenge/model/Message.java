package pl.mlopatka.codechallenge.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Objects;

public class Message {

    private Integer id;
    private LocalDateTime timestamp;
    @NotNull
    @Size(min = 1)
    private String authorNickname;
    @Size(max = 140)
    private String content;

    public Message() {
        timestamp = LocalDateTime.now();
    }

    public Message(final Integer id, @NotNull @Size(min = 1) final String authorNickname, @Size(max = 140) final String content) {
        this.id = id;
        this.authorNickname = authorNickname;
        this.content = content;
    }

    public Message(@NotNull @Size(min = 1) final String authorNickname, @Size(max = 140) final String content) {
        this.authorNickname = authorNickname;
        this.content = content;
        timestamp = LocalDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getAuthorNickname() {
        return authorNickname;
    }

    public void setAuthorNickname(String authorNickname) {
        this.authorNickname = authorNickname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return id == message.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                '}';
    }
}
