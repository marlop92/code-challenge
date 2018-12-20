package pl.mlopatka.codechallenge.repository.messagesRepository;

import pl.mlopatka.codechallenge.model.Message;
import pl.mlopatka.codechallenge.model.User;

import java.util.List;
import java.util.Set;

public interface MessagesRepository {

    void save(Message message);

    List<Message> getUserMessages(User user);

    List<Message> getUsersMessages(Set<String> usersNicknames);
}
