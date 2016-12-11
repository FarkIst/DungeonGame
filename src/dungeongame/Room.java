/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeongame;


import  dungeongame.Battle;
import dungeongame.Monster;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author Farkas Piftu
 */
public final class Room {

    private final String description;
    private final Monster monster;
    private final Boolean isBossRoom;
    private final static Random random = new Random();
    private final static Set<Integer> roomsSeen = new HashSet<Integer>();
    private final static int NUM_ROOMS = 7;
    

    private Room(String description, Monster monster, Boolean isBossRoom) {
        this.description = description;
        this.monster = monster;
        this.isBossRoom = isBossRoom;
    }
    
    

    public static Room newRegularInstance() {
        if (roomsSeen.size() == NUM_ROOMS) {
            roomsSeen.clear();
        }
        int i;
        do {
            i = random.nextInt(NUM_ROOMS);
        } while (roomsSeen.contains(i));
        roomsSeen.add(i);

        String roomDescription = null;
        if (i == 0) {
            roomDescription = "an endless mountain range where eagles soar looking for prey ";
        } else if (i == 1) {
            roomDescription = "in a place far away, where you can't find a netto...";
        } else if (i == 2) {
            roomDescription = "in a place where Winter's coming";
        } else if (i == 3) {
            roomDescription = "In Da Forest, where the wolves got the munchies";
        } else if (i == 4) {
            roomDescription =
                    "a thick forest where strange voices call out from the trees high above";
        } else if (i == 5) {
            roomDescription =
                    "ERMAHGERD BERKS BERBER HERPERPERTERMERSE with BERTMERN";
        } else if (i == 6) {
            roomDescription = "In roskilde festival and there's no hot water....";
        } else {
        }
        return new Room(roomDescription, Monster.newRandomInstance(), false);
    }

    public static Room newBossInstance() {
        return new Room("North Korea", Monster.newBossInstance(),
                true);
    }

    
    public boolean isBossRoom() {
        return isBossRoom;
    }
    
    public boolean isComplete() {
        return !monster.isAlive();
    }
    
    

    @Override
    public String toString() {
        return description;
    }

    public void enter(Player player) throws IOException {
        System.out.println("You are in " + description);
        if (monster.isAlive()) {
            new Battle(player, monster);
        }
        
       }
}