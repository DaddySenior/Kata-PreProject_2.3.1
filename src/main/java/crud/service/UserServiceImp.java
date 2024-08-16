package crud.service;

import crud.dao.UserDao;
import crud.dao.UserDaoImp;
import crud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService{

    public static void main(String[] args) {

            UserServiceImp userServiceImp = new UserServiceImp();
        userServiceImp.saveUser(new User("John", "Johnson", 53));
        userServiceImp.saveUser(new User("Ted", "Bowley", 28));
        userServiceImp.saveUser(new User("Alex", "Thomson", 36));

        }


    @Autowired
    private UserDao userDao;


    @Transactional
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
    @Transactional
    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }
    @Transactional
    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
    @Transactional
    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }
    @Transactional
    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }
}
