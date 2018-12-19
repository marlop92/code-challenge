package pl.mlopatka.codechallenge.repository.messagesRepository;

import pl.mlopatka.codechallenge.model.Message;

import java.util.*;
import java.util.stream.Collectors;

public class MessagesInMemoryRepository implements MessagesRepository {

    private Map<String, List<Message>> messages = new HashMap<>();

    @Override
    public void save(Message message) {
        messages.computeIfAbsent(message.getAuthorNickname(), (key) -> messages.put(key, new ArrayList<>()));
        messages.computeIfPresent(message.getAuthorNickname(), (key, messageList) -> {
            messageList.add(message);
            return messageList;
        });
    }

    @Override
    public List<Message> getUserMessages(String nickname) {
        return messages.getOrDefault(nickname, Collections.emptyList());
    }

    @Override
    public List<Message> getUsersMessages(List<String> usersNicknames) {
        List<Message> resultList = new ArrayList<>();
        messages.entrySet().stream()
                .filter(entry -> usersNicknames.contains(entry.getKey()))
                .forEach(entry -> resultList.addAll(entry.getValue()));

        return resultList;
    }
}
