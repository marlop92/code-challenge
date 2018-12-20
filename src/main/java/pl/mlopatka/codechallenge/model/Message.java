package pl.mlopatka.codechallenge.model;

import pl.mlopatka.codechallenge.dto.MessageDto;

import java.time.LocalDateTime;
import java.util.Objects;

public class Message {

    private Integer id;
    private LocalDateTime timestamp;
    private String authorNickname;
    private String content;

    public Message(final int id, final MessageDto messageDto) {
        this.id = id;
        this.authorNickname = messageDto.getAuthorNickname();
        this.content = messageDto.getContent();
        timestamp = LocalDateTime.now();
    }

    public Message(final Integer id, final String authorNickname, final String content) {
        this.id = id;
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
