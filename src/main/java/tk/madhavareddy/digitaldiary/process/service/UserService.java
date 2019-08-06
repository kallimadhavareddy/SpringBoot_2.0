package tk.madhavareddy.digitaldiary.process.service;



import tk.madhavareddy.digitaldiary.persistence.entity.User;

import java.util.List;


/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-security-oauth2-example
 * User: madhavareddy
 * Email: kalli.madhavareddy@gmail.com
 * Date: 05/08/2019
 * Time: 16.06
 * To change this template use File | Settings | File Templates.
 */

public interface UserService {

    User save(User user);

    List<User> findAll();

    void delete(long id);
}
