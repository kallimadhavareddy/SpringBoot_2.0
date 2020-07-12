package tk.madhavareddy.digitaldiary.persistence.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tk.madhavareddy.digitaldiary.persistence.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-security-oauth2-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 31/12/17
 * Time: 15.48
 * To change this template use File | Settings | File Templates.
 */


@Repository
public interface UserDao  {
    User findByUsername(String username);
    User save(User user);
    List<User> findAll();
    void deleteById(long id);
    User findByName(String name);
}
