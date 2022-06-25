package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class UserDaoImpl implements UserDAO {

//    private static final List<User> list = new ArrayList<>();
//
//    static {
//        list.add(new User("Kirill", "Blue", (byte)16,"x@mail.ru"));
//        list.add(new User("Paul", "Black", (byte) 22,"y@mail.ru"));
//        list.add(new User("Stan", "White", (byte) 44,"z@mail.ru"));
//        list.add(new User("Britney", "Spears",(byte) 33,"f@mail.ru"));
//    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User getUserById(long id) {
     return entityManager.find(User.class,id);
    }

    @Override
    public void addUser(User user) {
       entityManager.persist(user);
    }

    @Override
    public void removeUser(long id) {
        entityManager.remove(getUserById(id));
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }
}