package pl.mlopatka.codechallenge.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.mlopatka.codechallenge.dto.FollowStatusDto;
import pl.mlopatka.codechallenge.dto.MessageDto;
import pl.mlopatka.codechallenge.model.Message;
import pl.mlopatka.codechallenge.model.User;
import pl.mlopatka.codechallenge.services.followStatusService.FollowStatusService;
import pl.mlopatka.codechallenge.services.messageService.MessagesService;
import pl.mlopatka.codechallenge.services.userService.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RequestMapping("/api")
@ResponseBody
public class ApiController {

    private static final String INVALID_PARAMETER_EXCEPTION_MSG = "One of parameters was invalid";
    private static final String ILLEGAL_PARAMETER_EXCEPTION_MSG = "One of parameter was illegal";

    private final UserService userService;
    private final MessagesService messagesService;
    private final FollowStatusService followStatusService;

    public ApiController(final UserService userService, final MessagesService messagesService,
                         final FollowStatusService followStatusService) {
        this.userService = userService;
        this.messagesService = messagesService;
        this.followStatusService = followStatusService;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = ILLEGAL_PARAMETER_EXCEPTION_MSG)
    public void wrongArgument(){
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = INVALID_PARAMETER_EXCEPTION_MSG)
    public void validationFailed(){
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/message", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createMessage(@Valid @RequestBody MessageDto message) {
        User user = new User(message.getAuthorNickname());
        if (!userService.userExists(user)) {
            userService.create(user);
        }

        messagesService.create(message);
    }

    @GetMapping(value = "/messages", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Message> getCurrentUserMessages(@RequestParam("nickname") String nickname) {
        User user = new User(nickname);
        userService.validateUser(user);
        return messagesService.getMessages(user);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/follow")
    public void updateFollowStatus(@Valid @RequestBody FollowStatusDto followStatus) {
        User followedUser = new User(followStatus.getFollowedUserNickname());
        userService.validateUser(followedUser);
        followStatusService.updateFollowStatus(followStatus);
    }

    @GetMapping(value = "/followed-messages", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Message> getFollowedUsersMessages(@RequestParam("nickname") String nickname) {
        User user = new User(nickname);
        userService.validateUser(user);
        Set<String> followedUsersNicknames = followStatusService.getFollowedUsersNicknames(nickname);
        return messagesService.getMessages(followedUsersNicknames);
    }

}
