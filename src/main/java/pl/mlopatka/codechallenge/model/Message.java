package pl.mlopatka.codechallenge.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Message {

    private int id;
    private LocalDateTime timestamp;
    private String authorNickname;
    private String content;

    public Message() {
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getAuthorNickname() {
        return authorNickname;
    }

    public String getContent() {
        return content;
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
