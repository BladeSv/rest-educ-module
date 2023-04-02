package by.mitr.jmpcloudserviceimpl;

import by.mitr.dto.SubscriptionRequestDto;
import by.mitr.dto.UserRequestDto;
import by.mitr.service.SubscriptionService;
import by.mitr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EntityScan({"by.mitr.model","by.mitr.jmpcloudserviceimpl"})
public class JmpCloudServiceImplApplication {

    @Autowired
    UserService userService;
    @Autowired
    SubscriptionService subscriptionService;

    public static void main(String[] args) {
        SpringApplication.run(JmpCloudServiceImplApplication.class, args);
    }


    @Bean
    public CommandLineRunner CommandLineRunnerBean() {
        return (args) -> {
            UserRequestDto requestDto1 = new UserRequestDto(null,"Bob", "Markei", "1980-05-11");
            UserRequestDto requestDto2 = new UserRequestDto(null,"Bob2", "Markei2", "1981-05-11");
            UserRequestDto requestDto3 = new UserRequestDto(null,"Bob3", "Markei3", "1982-05-11");
            userService.createUser(requestDto1);
            userService.createUser(requestDto2);
            userService.createUser(requestDto3);

            SubscriptionRequestDto subscriptionRequestDto1 = new SubscriptionRequestDto(null,1L);
            SubscriptionRequestDto subscriptionRequestDto2 = new SubscriptionRequestDto(null,2L);
            subscriptionService.createSubscription(subscriptionRequestDto1);
            subscriptionService.createSubscription(subscriptionRequestDto2);
        };
    }
}

