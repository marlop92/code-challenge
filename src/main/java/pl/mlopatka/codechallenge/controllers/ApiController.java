package pl.mlopatka.codechallenge.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import pl.mlopatka.codechallenge.model.Message;
import pl.mlopatka.codechallenge.model.User;
import pl.mlopatka.codechallenge.services.followService.FollowingService;
import pl.mlopatka.codechallenge.services.messageService.MessagesService;
import pl.mlopatka.codechallenge.services.userService.UserService;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api")
@ResponseBody
public class ApiController {

    private final UserService userService;
    private final MessagesService messagesService;
    private final FollowingService followingService;

    public ApiController(UserService userService, MessagesService messagesService, FollowingService followingService) {
        this.userService = userService;
        this.messagesService = messagesService;
        this.followingService = followingService;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RuntimeException wrongArgument(IllegalArgumentException exception){
        throw new RuntimeException(exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RuntimeException validationFailed(MethodArgumentNotValidException exception){
        throw new RuntimeException(exception.getMessage());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/messages", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createMessage(@RequestParam("username") String username, @Valid @RequestBody Message message) {
        if (!userService.userExists(username)) {
            userService.create(new User(username));
        }

        messagesService.create(message);
    }

    @GetMapping(value = "/messages", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Message> getCurrentUserMessages(@RequestParam("username") String username) {
        userService.validateUser(username);
        return messagesService.getMessages(username);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/follow")
    public void updateFollowStatus(@RequestParam("username") String username,
                                   @RequestParam("followedUser") String followedUser,
                                   @RequestParam("follow") boolean follow) {
        userService.validateUser(followedUser);
        followingService.updateFollowStatus(username, followedUser, follow);
    }

    @GetMapping(value = "/watched-messages", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Message> getFollowedUsersMessages(@RequestParam("username") String username) {
        userService.validateUser(username);
        List<String> followedUsersNames = followingService.getFollowedUsersNicknames(username);
        return messagesService.getMessages(followedUsersNames);
    }

}
