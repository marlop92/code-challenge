package pl.mlopatka.codechallenge.services.messageService;

import pl.mlopatka.codechallenge.model.Message;

import java.util.List;

public interface MessagesService {

    //UC 1
    void create(Message message);

    //UC 2
    List<Message> getCurrentUserMessages();

    //UC 4
    List<Message> getFollowedUsersMessages();
}
