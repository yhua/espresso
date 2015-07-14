package com.tw.espresso.dao;

import com.tw.espresso.configuration.CoreContext;
import com.tw.espresso.dao.UserDao;
import com.tw.espresso.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CoreContext.class})
@ActiveProfiles("test")
@TransactionConfiguration
@Transactional
@WebAppConfiguration
public class UserDaoIntegrationTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testCreateUser() throws Exception {
        userDao.createUser(new User());
    }

}