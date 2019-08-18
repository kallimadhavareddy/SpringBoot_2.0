package tk.madhavareddy.digitaldiary.process.service;



import tk.madhavareddy.digitaldiary.persistence.entity.User;

import java.util.List;

public interface UserService {
    User save(User user);
    List<User> findAll();
}
