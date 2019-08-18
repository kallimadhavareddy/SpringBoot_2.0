package tk.madhavareddy.digitaldiary.persistence.dao;



import tk.madhavareddy.digitaldiary.persistence.entity.User;

import java.util.List;


/**
 * Created by IntelliJ IDEA.
 * Project : oauth2.0
 * User: madhavareddy
 * Email: kalli.madhavareddy@gmail.com
 * Date: 05/08/2019
 * Time: 16.06
 * To change this template use File | Settings | File Templates.
 */

public interface UserDao {
    User save(User user);
    List<User> findAll();
    void delete(long id);
    User findByName(String name);
}
