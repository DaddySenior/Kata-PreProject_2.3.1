package crud.dao;

import crud.config.DataBaseConfig;
import crud.model.User;
import crud.service.UserServiceImp;
import org.hibernate.Session;
import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;


@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
        public List<User> getAllUsers() {
        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
        public void saveUser(User user) {
        em.persist(user);
    }

    @Override
        public void updateUser(User user) {
        em.merge(user);
    }

    @Override
    public void deleteUser(int id) {
        User user = getUserById(id);
        if (user == null) {
            throw new NullPointerException("User not found");
        }
        em.remove(user);
    }

    @Override
    public User getUserById(int id) {
        return em.find(User.class, id);
    }
}
