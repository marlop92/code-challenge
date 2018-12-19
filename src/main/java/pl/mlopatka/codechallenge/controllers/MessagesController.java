package pl.mlopatka.codechallenge.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mlopatka.codechallenge.model.Message;

import java.util.List;

@RestController
@RequestMapping("/api/message")
public class MessagesController {

    @PostMapping
    public void createMessage() {

    }

    @GetMapping
    public List<Message> getCurrentUserMessages() {
        return null;
    }

    public List<Message> getFollowedUsersMessages() {
        return null;
    }

}
