package microservicelearning.repository;


/*
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
*/
import microservicelearning.domain.Users;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.time.LocalDateTime;


@RunWith(SpringRunner.class)
@DataJpaTest
public class UsersRepositoryTest {
    @Autowired
//    @MockBean
    private UsersRepository usersRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Before
    public void setUp() {
        /*Users user = new Users();
        user.setId(1L);
        user.setUserName("test1");
        user.setUserMail("test@testmail.com");
        user.setCreateDate(LocalDateTime.now());
        Mockito.when(usersRepository.getUsersByUserName("test1")).thenReturn(user);
        Mockito.when(usersRepository.save(user)).thenReturn(user);*/
    }

    @Test
    public void injectedComponentsAreNotNull(){
        Assertions.assertThat(usersRepository).isNotNull();
    }

    @Test
    public void getUserByNameTest(){
        Users user = testEntityManager.persistAndFlush(this.getUserObject());
//        System.out.println(usersRepository.getUsersByUserName("test1"));
        Assert.assertTrue(usersRepository.getUsersByUserName("test1").getId() == 1L);
    }

    @Test
    public void saveUserTest(){
        Assert.assertTrue(testEntityManager.persistAndFlush(this.getUserObject()).getId() == 1L);
    }


    private Users getUserObject(){
        Users user = new Users();
//        user.setId(1L);
        user.setUserName("test1");
        user.setUserMail("test@testmail.com");
        user.setCreateDate(LocalDateTime.now());
        return user;
    }


}