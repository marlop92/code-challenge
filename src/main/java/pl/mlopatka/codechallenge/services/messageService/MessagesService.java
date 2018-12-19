package pl.mlopatka.codechallenge.services.messageService;

import pl.mlopatka.codechallenge.model.Message;

import java.util.List;

public interface MessagesService {

    //UC 1
    void create(Message message);

    //UC 2
    List<Message> getMessages(String nickname);

    //UC 4
    List<Message> getMessages(List<String> nicknames);
}
