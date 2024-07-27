package org.example;

import org.example.entity.Dice;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DiceTest {
    @Test
    public void testRoll() {
        Dice dice = new Dice();
        for (int i = 0; i < 1000; i++) {
            int roll = dice.roll();
            assertTrue(roll >= 1 && roll <= 6);
        }
    }
}
