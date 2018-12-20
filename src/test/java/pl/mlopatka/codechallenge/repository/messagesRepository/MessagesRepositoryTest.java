package pl.mlopatka.codechallenge.repository.messagesRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.mlopatka.codechallenge.model.Message;
import pl.mlopatka.codechallenge.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MessagesRepositoryTest {

    private MessagesRepository repository;
    private Map<String, List<Message>> actualCollection;

    @Before
    public void setUp() {
        actualCollection = new HashMap<>();
        repository = new MessagesInMemoryRepository(actualCollection);
    }

    @Test
    public void shouldAddMessagesToList() {
        //given
        Message message = new Message("Alan", "My_Message");

        Map<String, List<Message>> expectedCollection = new HashMap<>();
        Message expectedMessage = new Message(0,"Alan", "My_Message");
        List<Message> expectedValues = new ArrayList<>();

        expectedValues.add(expectedMessage);
        expectedCollection.put("Alan", expectedValues);

        //when
        repository.save(message);
        Message resultMessage = actualCollection.get("Alan").get(0);

        //than
        Assert.assertEquals(expectedCollection, actualCollection);
        Assert.assertEquals(expectedMessage.getAuthorNickname(), resultMessage.getAuthorNickname());
        Assert.assertEquals(expectedMessage.getContent(), resultMessage.getContent());
    }

    @Test
    public void shouldReturnUserMessages() {
        //given
        Message message = new Message(0, "Alan", "My_Message");
        List<Message> actualValues = new ArrayList<>();
        actualValues.add(message);
        actualCollection.put("Alan", actualValues);

        Message expectedMessage = new Message(0, "Alan", "My_Message") ;

        //when
        List<Message> result = repository.getUserMessages(new User("Alan"));
        Message resultMessage = result.get(0);

        //than
        Assert.assertEquals(actualCollection.get("Alan"), result);
        Assert.assertEquals(expectedMessage.getAuthorNickname(), resultMessage.getAuthorNickname());
        Assert.assertEquals(expectedMessage.getContent(), resultMessage.getContent());
    }

    @Test
    public void shouldReturnUsersMessages() {
        //given
        Message userMessage = new Message(0, "User", "User_Message");
        Message alanMessage = new Message(1, "Alan", "Alan_Message");
        List<Message> userMessages = new ArrayList<>();
        List<Message> alanMessages = new ArrayList<>();
        userMessages.add(userMessage);
        alanMessages.add(alanMessage);
        actualCollection.put("User", userMessages);
        actualCollection.put("Alan", alanMessages);

        Set<String> usersNicknames = new HashSet<>();
        usersNicknames.add("User");
        usersNicknames.add("Alan");

        List<Message> expected = new ArrayList<>();
        expected.add(new Message(0, "User", "User_Message"));
        expected.add(new Message(1, "Alan", "Alan_Message"));

        //when
        List<Message> result = repository.getUsersMessages(usersNicknames);

        //than
        Assert.assertEquals(expected, result);
    }



}