package pl.mlopatka.codechallenge.services.messageService;

import pl.mlopatka.codechallenge.model.Message;

import java.util.List;

public interface MessagesService {

    void create(Message message);

    List<Message> getMessages(String nickname);

    List<Message> getMessages(List<String> nicknames);
}
