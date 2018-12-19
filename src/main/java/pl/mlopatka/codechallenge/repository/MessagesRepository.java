package pl.mlopatka.codechallenge.repository;

import pl.mlopatka.codechallenge.model.Message;

import java.util.List;

public interface MessagesRepository {

    void save(Message message);

    List<Message> getUserMessages(int userId);

    List<Message> getUsersMessages(List<Integer> userIds);
}
