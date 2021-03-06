package client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Timestamp;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {

    private transient User testUser;
    private transient User otherUser;

    @BeforeEach
    void setUp() {
        testUser = new User(1, "john", 100, 1, 2);
        otherUser = new User(testUser.getUserID(),
                testUser.getNickname(), testUser.getPoints(),
                testUser.getNumOfLostGames(), testUser.getNumOfWonGames());
    }

    @Test
    void testEmptyConstructor() {
        User emptyUser = new User();
        assertEquals(0, emptyUser.getUserID());
        assertEquals(0, emptyUser.getPoints());
        assertEquals(0, emptyUser.getNumOfLostGames());
        assertEquals(0, emptyUser.getNumOfWonGames());
        assertEquals("", emptyUser.getNickname());

    }


    @Test
    void getUserID() {
        assertEquals(1,testUser.getUserID());
    }

    @Test
    void setUserID() {
        testUser.setUserId(5);
        assertEquals(5,testUser.getUserID());
    }

    @Test
    void getNickname() {
        assertEquals("john", testUser.getNickname());
    }

    @Test
    void setNickname() {
        testUser.setNickname("robert");
        assertEquals("robert", testUser.getNickname());
    }

    @Test
    void addPoints() {
        testUser.addPoints(100);
        assertEquals(200, testUser.getPoints());
    }

    @Test
    void getNumOfLostGames() {
        testUser.addNumOfLostGames(1);
        assertEquals(2, testUser.getNumOfLostGames());
    }

    @Test
    void getNumOfWonGames() {
        testUser.addNumOfWonGames(2);
        assertEquals(4, testUser.getNumOfWonGames());
    }

    @Test
    void equalsSame() {
        assertTrue(testUser.equals(testUser));
    }

    @Test
    void equalsOther() {
        assertTrue(testUser.equals(otherUser));
    }

    @Test
    void notEqualsOther() {
        User otherUser = new User();
        assertFalse(testUser.equals(otherUser));
    }

    @Test
    @SuppressWarnings("PMD.EqualsNull") // we need to call equals null for the test
    void notEqualsNull() {
        assertFalse(testUser.equals(null));
    }

    @Test
    void notEqualsString() {
        assertFalse(testUser.equals("String"));
    }

    @Test
    void notEqualsNickname() {
        otherUser.setNickname("nickname");
        assertFalse(testUser.equals(otherUser));
    }

    @Test
    void notEqualsId() {
        otherUser.setUserId(2);
        assertFalse(testUser.equals(otherUser));
    }

    @Test
    void notEqualsPoints() {
        otherUser.addPoints(10);
        assertFalse(testUser.equals(otherUser));
    }

    @Test
    void notEqualsGamesWonLost() {
        otherUser.addNumOfWonGames(1);
        assertFalse(testUser.equals(otherUser));
        otherUser.addNumOfLostGames(1);
        assertFalse(testUser.equals(otherUser));
    }


}