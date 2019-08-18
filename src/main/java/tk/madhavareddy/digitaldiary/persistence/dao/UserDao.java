package tk.madhavareddy.digitaldiary.persistence.dao;

import tk.madhavareddy.digitaldiary.persistence.entity.User;

import java.util.List;

public interface UserDao {
    User save(User user);
    List<User> findAll();
    void delete(long id);
    User findByName(String name);
}
