/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeongame;


import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Farkas Piftu
 */
public class Game {

 

    private final Player player = Player.newInstance();

    public void play() throws IOException {
        System.out.println("You are " + player + " " + player.getDescription());
        Dungeon.newInstance().startQuest(player);
        
        
    }
    
    

    public static void main(String[] args) throws IOException {
        Game game = new Game();
        
        game.play();
    }

}