package microservicelearning.repository;

import microservicelearning.domain.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {

    @Override
    Users save(Users s);

    Users getUsersByUserName(String userName);
}
