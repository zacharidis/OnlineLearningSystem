package com.zacharidis.onlinelearningsystem.utility;

import com.zacharidis.onlinelearningsystem.dao.UserDao;
import com.zacharidis.onlinelearningsystem.entity.User;
import jakarta.persistence.EntityNotFoundException;

public class OperationUtility {


    // CRUD for users
    public static void usersOperations(UserDao userDao){
        createUsers(userDao);
        updateUser(userDao);
        deleteUser(userDao);
        fetchUsers(userDao);


    }

    private static void fetchUsers(UserDao userDao) {

        userDao.findAll().forEach(user-> System.out.println(user.toString()));



    }

    private static void deleteUser(UserDao userDao) {

        User user = userDao.findById(3L).orElseThrow(()-> new EntityNotFoundException("User not found!"));
        userDao.delete(user);




    }

    private static void updateUser(UserDao userDao) {


        User user = userDao.findById(2L).orElseThrow(()-> new EntityNotFoundException("User not found!"));
        user.setEmail("newEmail@gmail.com");
        userDao.save(user);




    }

    private static void createUsers(UserDao userDao) {

        //dummy users for testing

        User user1 = new User("user1@gmail.com","root");
        userDao.save(user1);

        User user2 = new User("user2@gmail.com","root");
        userDao.save(user2);

        User user3 = new User("user3@gmail.com","root");

        userDao.save(user3);

        User user4 = new User("user4@gmail.com","root");

        userDao.save(user4);


    }


}
