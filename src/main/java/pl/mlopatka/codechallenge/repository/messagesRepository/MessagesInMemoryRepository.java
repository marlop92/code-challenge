package pl.mlopatka.codechallenge.repository.messagesRepository;

import pl.mlopatka.codechallenge.model.Message;
import pl.mlopatka.codechallenge.model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessagesInMemoryRepository implements MessagesRepository {

    private final Map<String, List<Message>> messages;
    private int idCounter;

    public MessagesInMemoryRepository() {
        messages = new HashMap<>();
        idCounter = 0;
    }

    public MessagesInMemoryRepository(final Map<String, List<Message>> messages) {
        this.messages = messages;
        idCounter = 0;
    }

    @Override
    public void save(final Message message) {
        messages.computeIfAbsent(message.getAuthorNickname(), (key) -> messages.put(key, new ArrayList<>()));
        messages.computeIfPresent(message.getAuthorNickname(), (key, messageList) -> {
            message.setId(idCounter++);
            messageList.add(message);
            return messageList;
        });
    }

    @Override
    public List<Message> getUserMessages(final User user) {
        return messages.getOrDefault(user.getNickname(), Collections.emptyList());
    }

    @Override
    public List<Message> getUsersMessages(final List<String> usersNicknames) {
        List<Message> resultList = new ArrayList<>();
        messages.entrySet().stream()
                .filter(entry -> usersNicknames.contains(entry.getKey()))
                .forEach(entry -> resultList.addAll(entry.getValue()));

        return resultList;
    }
}
