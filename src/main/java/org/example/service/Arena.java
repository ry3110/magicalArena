package org.example.service;

import org.example.entity.Dice;
import org.example.entity.Player;

public class Arena {
    private Player player1;
    private Player player2;
    private Dice dice;

    public Arena(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.dice = new Dice();
    }

    public void startFight() {
        while (player1.isAlive() && player2.isAlive()) {
            takeTurn(player1, player2);
            if (player2.isAlive()) {
                takeTurn(player2, player1);
            }
        }
        printWinner();
    }

    private void takeTurn(Player attacker, Player defender) {
        int attackRoll = dice.roll();
        int defenseRoll = dice.roll();

        int attackDamage = attacker.getAttack() * attackRoll;
        int defenseStrength = defender.getStrength() * defenseRoll;
        int damage = Math.max(0, attackDamage - defenseStrength);

        defender.reduceHealth(damage);

        System.out.println(attacker.getName() + " attacks with roll " + attackRoll + " causing " + attackDamage +
                " damage. " + defender.getName() + " defends with roll " + defenseRoll + " blocking " + defenseStrength +
                " damage. " + defender.getName() + " health is now " + defender.getHealth());
    }

    private void printWinner() {
        if (player1.isAlive()) {
            System.out.println(player1.getName() + " wins!");
        } else {
            System.out.println(player2.getName() + " wins!");
        }
    }
}
