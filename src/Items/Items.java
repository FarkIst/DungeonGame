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

    public abstract class Items
    {
        public  static String name;
        private  static String description;
    
    
  public  Items(String name, String description)
  {
    
    this.name = name;
    this.description = description;
    
  }
  
  public String getName()
  {
      return name;
  }
  
  public String getDescription()
  {
      return description;
  }

    }