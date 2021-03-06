package pl.mlopatka.codechallenge.services.messageService;

import pl.mlopatka.codechallenge.dto.MessageDto;
import pl.mlopatka.codechallenge.model.Message;
import pl.mlopatka.codechallenge.model.User;
import pl.mlopatka.codechallenge.repository.messagesRepository.MessagesRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class MessagesServiceImpl implements MessagesService {

    private final MessagesRepository messagesRepository;

    public MessagesServiceImpl(MessagesRepository messagesRepository) {
        this.messagesRepository = messagesRepository;
    }

    @Override
    public void create(final MessageDto message) {
        messagesRepository.save(message);
    }

    @Override
    public List<Message> getMessages(final User user) {
        List<Message> messages = messagesRepository.getUserMessages(user);
        Collections.reverse(messages);

        return messages;
    }

    @Override
    public List<Message> getMessages(final Set<String> nicknames) {
        List<Message> messages = messagesRepository.getUsersMessages(nicknames);
        messages.sort(Comparator.comparing(Message::getTimestamp).reversed());

        return messages;
    }
}
