package pl.mlopatka.codechallenge.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.mlopatka.codechallenge.controllers.ApiController;
import pl.mlopatka.codechallenge.repository.followStatusRepository.FollowStatusInMemoryRepository;
import pl.mlopatka.codechallenge.repository.followStatusRepository.FollowStatusRepository;
import pl.mlopatka.codechallenge.repository.messagesRepository.MessagesInMemoryRepository;
import pl.mlopatka.codechallenge.repository.messagesRepository.MessagesRepository;
import pl.mlopatka.codechallenge.repository.usersRepository.UsersInMemoryRepository;
import pl.mlopatka.codechallenge.repository.usersRepository.UsersRepository;
import pl.mlopatka.codechallenge.services.followStatusService.FollowStatusService;
import pl.mlopatka.codechallenge.services.followStatusService.FollowStatusServiceImpl;
import pl.mlopatka.codechallenge.services.messageService.MessagesService;
import pl.mlopatka.codechallenge.services.messageService.MessagesServiceImpl;
import pl.mlopatka.codechallenge.services.userService.UserService;
import pl.mlopatka.codechallenge.services.userService.UserServiceImpl;

@Configuration
public class GlobalConfiguration {

    @Bean
    public UsersRepository usersRepository() {
        return new UsersInMemoryRepository();
    }

    @Bean
    public FollowStatusRepository followStatusRepository() {
        return new FollowStatusInMemoryRepository();
    }

    @Bean
    public MessagesRepository messagesRepository() {
        return new MessagesInMemoryRepository();
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl(usersRepository());
    }

    @Bean
    public FollowStatusService followStatusService() {
        return new FollowStatusServiceImpl(followStatusRepository());
    }

    @Bean
    public MessagesService messagesService() {
        return new MessagesServiceImpl(messagesRepository());
    }

    @Bean
    public ApiController apiController() {
        return new ApiController(userService(), messagesService(), followStatusService());
    }

}
