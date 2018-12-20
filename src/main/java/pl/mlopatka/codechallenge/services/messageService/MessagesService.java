package pl.mlopatka.codechallenge.services.messageService;

import pl.mlopatka.codechallenge.model.Message;
import pl.mlopatka.codechallenge.model.User;

import java.util.List;

public interface MessagesService {

    void create(Message message);

    List<Message> getMessages(User nickname);

    List<Message> getMessages(List<String> nicknames);
}
