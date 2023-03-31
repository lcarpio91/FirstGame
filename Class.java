/*********************************************************************
* LeeRoy Carpio
* SkillStorm Project 1
* 03/31/2023
*********************************************************************/

import java.io.*;
import java.util.*;
import javax.swing.*;

public class Class extends Stats
{
   private String characterClass;
   private String name;
   final private double defaultLevelUpRate = 1.2;
   final private double specificLevelUpRate = 1.5;
   
   public Class(String characterClass, String name) 
   {
      super(10.0, 10.0, 10.0, 10.0, 1);
      this.characterClass = characterClass;
      this.name = name;
   }
   
   public void setCharacterClass(String characterClass) 
   {
      this.characterClass = characterClass;
   }
   
   public void setName(String name)
   {
      this.name = name;
   }
   
   public String getCharacterClass() 
   {
      return characterClass;
   }   
   
   public String getName()
   {
      return name;
   }
   
   public void setBaseStats(String characterClass)
   {
      setLevel(1);
      if(characterClass.equals("Knight"))
      {         
         setHealth(50.0);
         setStrength(40.0);
         setMagic(5.0);
         setAgility(15.0);         
      }
      else if(characterClass.equals("Wizard"))
      {
         setHealth(25.0);
         setStrength(10.0);
         setMagic(50.0);
         setAgility(25.0);
      }
      else if(characterClass.equals("Rogue"))
      {
         setHealth(25.0);
         setStrength(30.0);
         setMagic(15.0);
         setAgility(40.0);
      }
   }
   
   public void levelUp(String characterClass)
   {
      setLevel((int)(getLevel() + 1));
      JOptionPane.showMessageDialog(null, name + "You have leveled up to level " + getLevel());
      if(characterClass.equals("Knight"))
      {        
         setHealth((double)Math.round((getHealth() * specificLevelUpRate)));
         setStrength((double)Math.round((getStrength() * specificLevelUpRate)));
         setMagic((double)Math.round((getMagic() * defaultLevelUpRate)));
         setAgility((double)Math.round((getAgility() * defaultLevelUpRate)));         
      }
      else if(characterClass.equals("Wizard"))
      {
         setHealth((double)Math.round((getHealth() * defaultLevelUpRate)));
         setStrength((double)Math.round((getStrength() * defaultLevelUpRate)));
         setMagic((double)Math.round((getMagic() * specificLevelUpRate)));
         setAgility((double)Math.round((getAgility() * specificLevelUpRate)));  
      }
      else if(characterClass.equals("Rogue"))
      {
         setHealth((double)Math.round((getHealth() * defaultLevelUpRate)));
         setStrength((double)Math.round((getStrength() * specificLevelUpRate)));
         setMagic((double)Math.round((getMagic() * defaultLevelUpRate)));
         setAgility((double)Math.round((getAgility() * specificLevelUpRate)));  
      }     
   }
}