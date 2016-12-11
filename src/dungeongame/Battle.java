/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeongame;

import dungeongame.Monster;
import dungeongame.Player;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Farkas Piftu
 */
public final class Battle {

    public Battle(Player player, Monster monster) throws IOException {
        System.out.println("You encounter " + monster + ": " + monster.getDescription() + "\n");
        System.out.println("Battle with " + monster + " starts (" + player.getStatus() + " / "
                + monster.getStatus() + ")");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (player.isAlive() && monster.isAlive()) {
            System.out.print("Attack (a) or heal (h)? ");
            String action = in.readLine();
            if (action.equals("h")) {
                player.heal();
            } else {
                monster.defend(player);
            }
            if (monster.isAlive()) {
                player.defend(monster);
            }
        }
    }

}