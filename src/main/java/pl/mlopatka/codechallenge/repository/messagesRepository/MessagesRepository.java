package pl.mlopatka.codechallenge.repository.messagesRepository;

import pl.mlopatka.codechallenge.model.Message;

import java.util.List;

public interface MessagesRepository {

    void save(Message message);

    List<Message> getUserMessages(String nickname);

    List<Message> getUsersMessages(List<String> usersNicknames);
}
