package org.example;

import org.example.entity.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    @Test // this test function checks the player's name
    public void testGetName() {
        Player player = new Player("Test", 50, 5, 10);
        assertEquals("Test", player.getName());
    }

    @Test // this test function checks the player's health
    public void testGetHealth() {
        Player player = new Player("Test", 50, 5, 10);
        assertEquals(50, player.getHealth());
    }

    @Test // this test function checks the player's strength
    public void testGetStrength() {
        Player player = new Player("Test", 50, 5, 10);
        assertEquals(5, player.getStrength());
    }

    @Test // this test function checks the player's attack
    public void testGetAttack() {
        Player player = new Player("Test", 50, 5, 10);
        assertEquals(10, player.getAttack());
    }

    @Test // this test func check functioning of reducehealth func
    public void testReduceHealth() {
        Player player = new Player("Test", 50, 5, 10);
        player.reduceHealth(20);
        assertEquals(30, player.getHealth());
        player.reduceHealth(50);
        assertEquals(0, player.getHealth());
    }

    @Test // this test function checks if a player is alive
    public void testIsAlive() {
        Player player = new Player("Test", 50, 5, 10);
        assertTrue(player.isAlive());
        player.reduceHealth(50);
        assertFalse(player.isAlive());
    }
}

