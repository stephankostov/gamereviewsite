package com.fdmgroup.project_gamesdatabase.sqlimporttest;

import com.fdmgroup.project_gamesdatabase.model.Game;
import com.fdmgroup.project_gamesdatabase.model.User;
import com.fdmgroup.project_gamesdatabase.service.GameService;
import com.fdmgroup.project_gamesdatabase.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ImportSqlTest {

    @Autowired
    private UserService userService;
    @Autowired
    private GameService gameService;

    @Test
    void ImportClassWithNoRelationships() {
        User userFromDb = userService.retrieve(1).get();
        assertEquals(userFromDb.getId(), 1);
    }

    @Test
    void ImportClassWithRelationships() {
        Game gameFromDb = gameService.retrieve(1).get();
        assertEquals(gameFromDb.getId(), 1);
    }
}
