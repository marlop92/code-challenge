package pl.mlopatka.codechallenge.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.mlopatka.codechallenge.controllers.ApiController;
import pl.mlopatka.codechallenge.repository.followsRepository.FollowsInMemoryRepository;
import pl.mlopatka.codechallenge.repository.followsRepository.FollowsRepository;
import pl.mlopatka.codechallenge.repository.messagesRepository.MessagesInMemoryRepository;
import pl.mlopatka.codechallenge.repository.messagesRepository.MessagesRepository;
import pl.mlopatka.codechallenge.repository.usersRepository.UsersInMemoryRepository;
import pl.mlopatka.codechallenge.repository.usersRepository.UsersRepository;
import pl.mlopatka.codechallenge.services.followService.FollowingService;
import pl.mlopatka.codechallenge.services.followService.FollowingServiceImpl;
import pl.mlopatka.codechallenge.services.messageService.MessagesService;
import pl.mlopatka.codechallenge.services.messageService.MessagesServiceImpl;
import pl.mlopatka.codechallenge.services.userService.UserService;
import pl.mlopatka.codechallenge.services.userService.UserServiceImpl;

@Configuration
public class GlobalConfiguration {

    private UsersRepository usersRepository;
    private FollowsRepository followsRepository;
    private MessagesRepository messagesRepository;

    private UserService userService;
    private FollowingService followingService;
    private MessagesService messagesService;

    private ApiController apiController;


    @Bean
    public UsersRepository usersRepository() {
        return new UsersInMemoryRepository();
    }

    @Bean
    public FollowsRepository followsRepository() {
        return new FollowsInMemoryRepository();
    }

    @Bean
    public MessagesRepository messagesRepository() {
        return new MessagesInMemoryRepository();
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl(usersRepository);
    }

    @Bean
    public FollowingService followingService() {
        return new FollowingServiceImpl(followsRepository);
    }

    @Bean
    public MessagesService messagesService() {
        return new MessagesServiceImpl(messagesRepository);
    }

    @Bean
    public ApiController apiController() {
        return new ApiController(userService, messagesService, followingService);
    }

}
