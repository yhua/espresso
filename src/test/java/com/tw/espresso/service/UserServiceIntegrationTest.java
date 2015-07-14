package com.tw.espresso.service;

import com.tw.espresso.configuration.CoreContext;
import com.tw.espresso.model.User;
import com.tw.espresso.service.UserService;
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
@ContextConfiguration(classes = CoreContext.class)
@ActiveProfiles("test")
@TransactionConfiguration
@Transactional
@WebAppConfiguration
public class UserServiceIntegrationTest {
    @Autowired
    private UserService service;

    @Test
    public void testCreateForwardRelationShip() throws Exception {
        service.createUser(new User());
    }
}
