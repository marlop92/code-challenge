package pl.mlopatka.codechallenge.services.messageService;

import pl.mlopatka.codechallenge.model.Message;
import pl.mlopatka.codechallenge.model.User;
import pl.mlopatka.codechallenge.repository.messagesRepository.MessagesRepository;

import java.util.List;
import java.util.Set;

public class MessagesServiceImpl implements MessagesService {

    private final MessagesRepository messagesRepository;

    public MessagesServiceImpl(MessagesRepository messagesRepository) {
        this.messagesRepository = messagesRepository;
    }

    @Override
    public void create(final Message message) {
        messagesRepository.save(message);
    }

    @Override
    public List<Message> getMessages(final User user) {
        return messagesRepository.getUserMessages(user);
    }

    @Override
    public List<Message> getMessages(final Set<String> nicknames) {
        return messagesRepository.getUsersMessages(nicknames);
    }
}
