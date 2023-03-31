import java.io.*;
import java.util.*;
import javax.swing.*;

public abstract class Stats
{
   private double health;
   private double strength;
   private double magic;
   private double agility;
   private int level = 1;
   
   
   public Stats(double health, double strength, double magic, double agility, int level) 
   {
      this.health = health;
      this.strength = strength;
      this.magic = magic;
      this.agility = agility;
      this.level = level;
   }
   
   public void setHealth(double hp) 
   {
      this.health = hp;
   }
   public void setStrength(double strength) 
   {
      this.strength = strength;
   }
   public void setMagic(double magic) 
   {
      this.magic = magic;
   }
   public void setAgility(double agility)
   {
      this.agility = agility;
   }
   
   public void setLevel(int level)
   {
      this.level = level;
   }
   
   public double getHealth() 
   {
      return health;
   }
   public double getStrength() 
   {
      return strength;
   }   
   public double getMagic()
   {
      return magic;
   }
   public double getAgility()
   {
      return agility;
   }
   
   public double getLevel()
   {
      return level;
   }  
   
   
   public void getStats()
   {
      JOptionPane.showMessageDialog(null, "Health: " + getHealth() + "\nStrength: " + getStrength() 
      								    + "\nMagic: " + getMagic() + "\nAgility: " + getAgility() + "\nLevel: " + getLevel());
   }
}