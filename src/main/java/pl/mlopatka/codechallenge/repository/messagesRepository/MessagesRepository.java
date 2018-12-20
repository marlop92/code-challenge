package pl.mlopatka.codechallenge.repository.messagesRepository;

import pl.mlopatka.codechallenge.model.Message;
import pl.mlopatka.codechallenge.model.User;

import java.util.List;

public interface MessagesRepository {

    void save(Message message);

    List<Message> getUserMessages(User user);

    List<Message> getUsersMessages(List<String> usersNicknames);
}
