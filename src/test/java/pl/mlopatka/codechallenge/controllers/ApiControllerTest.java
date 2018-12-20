package pl.mlopatka.codechallenge.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.mlopatka.codechallenge.services.followStatusService.FollowStatusService;
import pl.mlopatka.codechallenge.services.messageService.MessagesService;
import pl.mlopatka.codechallenge.services.userService.UserService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;;

@RunWith(SpringRunner.class)
public class ApiControllerTest {

    private static final String GET_MESSAGES_URI = "/api/messages?nickname=abc";
    private static final String GET_FOLLOWED_USERS_MESSAGES_URI = "/api/followed-messages?nickname=abc";
    private static final String CREATE_MESSAGE_URI = "/api/message";
    private static final String FOLLOW_USER_URI = "/api/follow";

    private static final String MESSAGE_JSON = "{\n"
            + "\t\"authorNickname\": \"Alan\",\n"
            + "\t\"content\": \"Hello\"\n"
            + "}";

    private static final String FOLLOW_STATUS_JSON = "{\n"
            + "\t\"followerNickname\": \"Alan\",\n"
            + "\t\"followedUserNickname\": \"Herman\",\n"
            + "\t\"follow\": true\n"
            + "}";

    @MockBean
    private UserService userService;
    @MockBean
    private FollowStatusService followStatusService;
    @MockBean
    private MessagesService messagesService;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(new ApiController(userService, messagesService, followStatusService)).build();
    }

    @Test
    public void shouldResolveUriForGettingMessages() throws Exception {
        mockMvc.perform(get(GET_MESSAGES_URI)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldResolveUriForGettingFollowedMessages() throws Exception {
        mockMvc.perform(get(GET_FOLLOWED_USERS_MESSAGES_URI)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldResolveUriForCreatingMessage() throws Exception {
        mockMvc.perform(post(CREATE_MESSAGE_URI)
                .content(MESSAGE_JSON)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldResolveUriForFollowingUsers() throws Exception {
        mockMvc.perform(put(FOLLOW_USER_URI)
                .content(FOLLOW_STATUS_JSON)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isNoContent());
    }
}