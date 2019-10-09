package microservicelearning.controller;

import microservicelearning.domain.Users;
import microservicelearning.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @Autowired
    UsersRepository usersRepository;

    @GetMapping("/test")
    public Users testRest(){
        Map<String, String> response = new HashMap<>();
        response.put("data", "test");
        response.put("data2", "test2");
        return usersRepository.getUsersByUserName("test1");
    }
}
