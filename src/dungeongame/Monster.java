/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeongame;

import dungeongame.Player;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import Items.Items;
import Items.Weapon;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Farkas Piftu
 */
public final class Monster {
    
    static String Doge;
    static String Scumbag;
    static String blBrian;
    static String SupremeLeader;
    static String Wood;
    static String Iron;
    static String Flame;
    static boolean CROWN;
    static boolean REAPER;
    public boolean contentDrop;
    private final String name;
    private final String description;
    private int hitPoints;
    private final int minDamage;
    private final int maxDamage;
    private final static Random random = new Random();
    private final static Set<Integer> monstersSeen = new HashSet<Integer>();
    private final static int NUM_MONSTERS = 3;
    private final static int numOfItems = 3;
    private static List<Items> itemList;
    
    
    

    public static Monster newRandomInstance() {
        
        if (monstersSeen.size() == NUM_MONSTERS) {
            monstersSeen.clear();
        }
        int i;
        do {
            i = random.nextInt(NUM_MONSTERS);
        } while (monstersSeen.contains(i));
        monstersSeen.add(i);

        if (i == 0) {
            
            return new Monster("Doge", Doge, 40, 8, 12);
                       
        } else if (i == 1) {
           
            return new Monster("Scumbag Steve", Scumbag, 26, 4, 6);
        } else {
            
            return new Monster("Bad Luck Brian", blBrian, 18, 1, 2);
        }
    }
  
 public  Items drop()
    {       
        
            itemList = new ArrayList<>();
            if(contentDrop){
                
            }
             int i;
             do 
             {
                 i = random.nextInt(numOfItems);
             }
             while (itemList.contains(i));
             
             
             if (i == 0)
             {   
                 
                 return new Weapon("Wooden sword ", Wood, 5);
                 
                 
             }
            else if (i == 1)
             {
                 
                 return new Weapon("Epic sword ", Iron, 10);
             }
            else 
             {
                 return new Weapon ("A reptilian Flame sword XD", Flame, 20);
             }
            
    }

   
    public boolean Content ()
    {
        if(hitPoints > 0)
        {
            contentDrop = true;
        }    
            return false;
    }
    
 
    
     public List<Items> getItemList()
    {
        return itemList;
    }
   

    public static Monster newBossInstance() {
        return new Monster("Kim Jong", SupremeLeader, 60, 10, 20);
    }

    private Monster(String name, String description, int hitPoints, int minDamage, int maxDamage) {
        this.name = name;
        this.description = description;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.hitPoints = hitPoints;
       
        
    }
    
  

    @Override
    public String toString() {
        return name;
    }

    public String getDescription() {
        return " Come at me bro! ";
    }

    public String getStatus() {
        return "Monster HP: " + hitPoints;
    }

    public int attack() {
        return random.nextInt(maxDamage  - minDamage + 1) + minDamage;
    }
    
    

    public void defend(Player player) {
        drop();
        int attackStrength = player.attack();
        hitPoints = (hitPoints > attackStrength) ? hitPoints - attackStrength : 0;
        System.out.printf("  %s wacks %s for %d HP of damage (%s)\n", player, name, attackStrength,
                getStatus());
        if (hitPoints == 0) {
            System.out.println("  " + player + " transforms this dank " + name
                    + " into a smoking pile of human garbage XD  ");
            System.out.println("The monster dropped: " + Items.name + " " );
            
        }
    }

    public boolean isAlive() {
        return hitPoints > 0;
    }

}