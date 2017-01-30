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
    static String none;
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
    private final static int numOfItems = 4;
    private static List<Items> itemList;
    static boolean wood = false;
    static boolean iron = false;
    static boolean flame = false;
    
    static boolean dog = false;
    static boolean steve = false;
    static boolean brian = false;
    static boolean kim = false;
    
    
    

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
            dog = true;
            return new Monster("Doge", Doge, 40, 8, 12);
             
                       
        } else if (i == 1) {
           steve = true;
            return new Monster("Scumbag Steve", Scumbag, 26, 4, 6);
        } else {
            brian = true;
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
                 wood = true;
                 return new Weapon("Wooden sword ", Wood, 5);
                 
                 
             }
            else if (i == 1)
             {
                 iron = true;
                 return new Weapon("Epic sword ", Iron, 10);
             }
            
            else if (i == 2)
             {
                 
                 return new Weapon("Nothing ", none, 0);
             }
            else 
             {  
                 flame = true;
                 return new Weapon ("A reptilian Flame sword XD", Flame, 20);
             }
            
    }

   
   
    
    
    
     public List<Items> getItemList()
    {
        return itemList;
    }
   

    public static Monster newBossInstance() {
        kim = true;
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
        
        int attackStrength = player.attack();
        hitPoints = (hitPoints > attackStrength) ? hitPoints - attackStrength : 0;
        System.out.printf("  %s wacks %s for %d HP of damage (%s)\n", player, name, attackStrength,
                getStatus());
        if (hitPoints == 0) {
            System.out.println("  " + player + " transforms this dank " + name
                    + " into a smoking pile of poop");
            
            
        }
    }

    
    public boolean isAlive() {
        return hitPoints > 0;
    }

}