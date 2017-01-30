/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeongame;

import dungeongame.Monster;
import java.util.Random;
import java.util.Scanner;
import Items.Items;
import Items.Weapon;
import static dungeongame.Monster.Doge;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Farkas Piftu
 */
public final class Player {

    static String newPlayer() {
        return playerName;
    }
    static String playerName;
    private final String name;
    private final String description;
    private final int maxHitPoints;
    private int hitPoints;
    int numPotions;
    private final int minDamage;
    private final int maxDamage;
    static List<Items> inventory;
    int playerGold = 0;
    
    
    private final Random random = new Random();
    

    private Player(String name, String description, int maxHitPoints, int minDamage, int maxDamage,
            int numPotions, int gold) {
        Scanner in = new Scanner(System.in);
       System.out.println(" Welcome to the dungeon, Lel\n"
                + " Enter your name: ");
        this.name = in.next();
        name = playerName;
        this.description = description;
        this.maxHitPoints = maxHitPoints;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.numPotions = numPotions;
        this.hitPoints = maxHitPoints;
        this.inventory = new ArrayList<>();
        this.playerGold = gold;
       
        
    }

   

    public int attack() {
        return random.nextInt((maxDamage + Weapon.getAttack()) - minDamage + 1) + minDamage;
    }

    public void defend(Monster monster) {
        int attackStrength = monster.attack();
        hitPoints = (hitPoints > attackStrength) ? hitPoints - attackStrength : 0;
        System.out.printf("  " + name + " is hit for %d HP of damage (%s)\n", attackStrength,
                getStatus());
              
        if (hitPoints == 0) {
            System.out.println("  " + name + " Damn son, you deadead");
        }
    }
    
     public int getGold()
    {
        return playerGold;
    }

     public void addGold()
     {
        if(Monster.dog = true)
        {
            playerGold = playerGold + 50;
        }
         if(Monster.steve = true)
        {
            playerGold = playerGold + 25;
        }
          if(Monster.brian = true)
        {
            playerGold = playerGold + 10;
        }
           if(Monster.kim = true)
        {
            playerGold = playerGold + 100;
        }
           else
           {
               playerGold = playerGold;
           }
     }
     
    public void heal() {
        if (numPotions > 0) {
            hitPoints = Math.min(maxHitPoints, hitPoints + 20);
            System.out.printf("  %s drinks healing potion (%s, %d potions left)\n", name,
                    getStatus(), --numPotions);
        } else {
            System.out.println("  You've exhausted your potion supply!");
        }
    }
    
    public void stats()
    {
        
        System.out.println("Attack: " + attack());
    }
    

    
    public boolean isAlive() {
        return hitPoints > 0;
    }

    public String getName() {
        return name;
    }
    
    public String getStatus() {
        return "Player HP: " + hitPoints;
    }
    
public List<Items> getInventory()
    {
        return inventory;
        
    }
        
   

    @Override
    public String toString() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    public static Player newInstance() {
        return new Player(" ",
                "A mighty warrior, on a quest to find his long lost midget twin brother", 50, 6, 20, 10, 0);
    }
   
}