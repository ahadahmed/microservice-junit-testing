package microservicelearning.bootstrap;

import microservicelearning.domain.Users;
import microservicelearning.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@Profile("dev")
public class UserInitializationRunner implements CommandLineRunner {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    @Profile("dev")
    public void run(String... args) throws Exception {
        Users user = new Users();
        user.setUserName("test1");
        user.setUserMail("test@testmail.com");
        user.setCreateDate(LocalDateTime.now());
        Users user1 = new Users();
        user1.setUserName("test2");
        user1.setUserMail("test2@testmail.com");
        user1.setCreateDate(LocalDateTime.now());

        List<Users> usersList = new ArrayList<>();
        usersList.add(user);
        usersList.add(user1);

//        usersRepository.save(user);
        usersRepository.saveAll(usersList);
    }
}
