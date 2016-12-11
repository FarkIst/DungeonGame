/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Items;

/**
 *
 * @author Farkas
 */
public class Weapon extends Items {
    String Iron;
    public static int attack;
    
    public Weapon(String name, String description, int attack)
    {
        super(name, description);
        this.attack = attack;
        
    }
    
    public static int getAttack()
    {
       return attack;
    }
 
    
    
}
