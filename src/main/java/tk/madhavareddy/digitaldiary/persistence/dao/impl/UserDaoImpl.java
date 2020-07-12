package tk.madhavareddy.digitaldiary.persistence.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tk.madhavareddy.digitaldiary.persistence.dao.UserDao;
import tk.madhavareddy.digitaldiary.persistence.entity.User;
import tk.madhavareddy.digitaldiary.persistence.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl  implements UserDao {
    private final UserRepository userRepository;
    @Autowired
    public UserDaoImpl(UserRepository userRepository){
        this.userRepository= userRepository;
    }
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        userRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public void deleteById(long id) {
    }

    @Override
    public User findByName(String name){
        return userRepository.findByUsername(name);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
