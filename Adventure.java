import java.util.*;
import java.io.*;
import javax.swing.*;

public class Adventure
{
   private Class player;
   
   // Constructor 
   public Adventure() {}
   
   
  //Collection of User name
   // will default to Alex if no name is entered
  public void playerName()
  {
      String[] choices = {"--- Choose an Option Below ---", "Yes", "No", "Quit"}; // String array of choices to prompt the user
      String name = "";
      String testName = "";
      String inputString = "";
      testName = (String)JOptionPane.showInputDialog(null, "Type your name: ").trim();
      if(testName.trim().equals(""))
      {
         name = "Alex";
      }
      else
      {
         name = testName.trim();
      }
      
      while(!inputString.equals("Quit")) // While loop to check for when user chooses the exit the program option to end the loop
      {         
         Object mainMenuInput = (String)JOptionPane.showInputDialog(null, "Is that correct " + name + "?" , "RPG Game", JOptionPane.PLAIN_MESSAGE, null, choices, choices[0]); // Initial choice
         if(mainMenuInput != null)
         {
            inputString = mainMenuInput.toString();
            switch (inputString) // switch case checking the user selection from drop down
            {
               case "--- Choose an Option Below ---":
                       JOptionPane.showMessageDialog(null,"Please select one of the valid options.");
                       break;
               case "Yes":
                       startAdventure(name);
                       break;
               case "No":
                       name = (String)JOptionPane.showInputDialog(null, "Type your name: ").trim();
                       break;
               case "Quit":                       
                       break;                              
            }
         }
      }
  }
  
  //Adventure begins
  // user character stats/class based on weapon type.
  
  public void startAdventure(String name)
  {            
      String[] choices = {"Sword", "Staff", "Dagger"};
      String[] confirm = {"Yes", "No"};      
      String weapon = "";
      String weaponChoice = (String)JOptionPane.showInputDialog(null, "Pick your weapon" , "First Time Hero!", JOptionPane.PLAIN_MESSAGE, null, choices, choices[0]); // Initial choice
         if(weaponChoice != null)
         {
            weapon = weaponChoice.toString();
            switch(weapon)
            {
               case "Sword":
                  createClass("Sword", name);
                                    
                  initialEvent();
                  break;
               case "Staff":
                  createClass("Staff", name);
                  initialEvent();
                  break;
               case "Dagger":
                  createClass("Dagger", name);
                  initialEvent();
                  break;
            }
         }
  }
  
  //
  
  public void createClass(String weapon, String name)
  {
      if(weapon.equals("Sword"))
      {
         Class knight = new Class("Knight", name);
         this.player = knight;
         knight.setBaseStats("Knight");
         JOptionPane.showMessageDialog(null,"You are a Knight! These are your stats.");
         player.getStats();
      }
      else if(weapon.equals("Staff"))
      {
         Class wizard = new Class("Wizard", name);
         this.player = wizard;
         wizard.setBaseStats("Wizard");
         JOptionPane.showMessageDialog(null,"You are a Wizard! These are your stats.");
         player.getStats();
      }
      else if(weapon.equals("Dagger"))
      {
         Class rogue = new Class("Rogue", name);
         this.player = rogue;
         rogue.setBaseStats("Rogue");
         JOptionPane.showMessageDialog(null,"You are a Rogue! These are your stats.");
         player.getStats();
      }
  }
  
  public Integer[] eventRandomizer()
  {
      Integer[] events = {1, 2, 3, 4, 5};
		List<Integer> eventList = Arrays.asList(events);
		Collections.shuffle(eventList);
		eventList.toArray(events);
      System.out.println(Arrays.toString(events));
      return events;
  }
  
  public boolean event(int eventNum, int count)
  {
	  EventPath paths = new EventPath();
      boolean alive = true;
      switch(eventNum)
      {
          case 1:   
            JOptionPane.showMessageDialog(null, paths.mountainGolem());  
            alive = eventChoice(80.0, 35.0, 2.5, 2.5, "Magic", "Mountain Golem", count);    //120 stat points        
            return alive;                 
          case 2:   
            JOptionPane.showMessageDialog(null, paths.forestElves()); 
            alive = eventChoice(45.0, 10.0, 25.0, 40.0, "Agility", "Forest Elves", count);   // 120 stat points
            return alive;              
          case 3:    
            JOptionPane.showMessageDialog(null, paths.caveGoblins()); 
            alive = eventChoice(35.0, 35.0, 25.0, 10.0, "Strength", "Cave Goblins", count);     // 105 stat points       
            return alive;             
          case 4:   
            JOptionPane.showMessageDialog(null,paths.castleDragon());     
            alive = eventChoice(70.0, 25.0, 17.5, 50.0, "Magic", "Castle Dragon", count);     // 162.5 stat points
            return alive;                      
          case 5:
            JOptionPane.showMessageDialog(null, paths.bridgeTroll());     
            alive = eventChoice(55.0, 40.0, 10.0, 10.0, "Strength", "Bridge Troll", count);     // 115 stat points
            return alive;
      }     
      return alive; 
  }
  
  public boolean eventChoice(double health, double strength, double agility, double magic,  String weakness, String monster, int count)
  {
      String[] choices = {"Fight", "Run"};
      String choice = "";
      boolean alive = true;
      double pHealth = player.getHealth(); double pStrength = player.getStrength(); double pAgility = player.getAgility(); double pMagic = player.getMagic();
      choice = (String)JOptionPane.showInputDialog(null, "What will you do?" , "RPG Game", JOptionPane.PLAIN_MESSAGE, null, choices, choices[0]); // Initial choice
      switch(choice)
      {
          case "Fight":    
            //monster will have a weakness and specific stats  
            // compare stats player stat points start at 110. Most Total stat points will win. 
            double totalMonsterStats = 0.0; double totalPlayerStats = 0.0;
            if(weakness.equals("Magic"))
               pMagic *= 2;
            else if(weakness.equals("Strength"))
               pStrength *= 2;
            else if(weakness.equals("Agility"))
               pAgility *= 2;
            
            totalMonsterStats = (double)((health + strength + agility + magic) * count) / 2;
            totalPlayerStats = pHealth + pStrength + pAgility + pMagic;
            
            if(totalMonsterStats > totalPlayerStats)
            {
               alive = false;
            }
            else
            {
               JOptionPane.showMessageDialog(null,"You have slain the " + monster + " !"); 
               player.levelUp(player.getCharacterClass());
               player.getStats();
            }
            return alive;
          case "Run":   
            if(player.getAgility() < (double)(agility * player.getLevel() / 1.5))
            {
               alive = false;
            }
            else
            {
               JOptionPane.showMessageDialog(null,"You escaped by the skin of your teeth!"); 
               JOptionPane.showMessageDialog(null,"Quick Tip: Remember you don't level up by running but sometimes its worth it."); 
               player.getStats(); 
               return alive;   
            }                           
      }
      return alive;
  }
  
  public void initialEvent()
  {
      String[] choices = {"Fight", "Run"};
      Integer[] events = new Integer[4];
      EventPath path = new EventPath();
      
      JOptionPane.showMessageDialog(null,"Start adventure");
      JOptionPane.showMessageDialog(null, path.townMinotaur()); 

      String choice = "", cont = "";
      choice = (String)JOptionPane.showInputDialog(null, "What will you do?" , "RPG Game", JOptionPane.PLAIN_MESSAGE, null, 
    		  										choices, choices[0]); // Initial choice
      switch(choice)
      {
          case "Fight":    
            player.levelUp(player.getCharacterClass());
            player.getStats();              
            break;
          case "Run": 
            JOptionPane.showMessageDialog(null,"You barely made it out alive. Next time you won't level up doing so...");  
            player.levelUp(player.getCharacterClass());
            player.getStats();                  
            break;
      }
      
      events = eventRandomizer();
      boolean alive = true;
      String[] contOptions = {"Restart", "Quit"};
      int count = 0;
      for(int i = 0; i < events.length; i++)
      {    
           if(alive)
           {
        	   count = i;
               alive = event(events[i], i);
           } 
           else
           {
               cont = (String)JOptionPane.showInputDialog(null, "Tough luck. You are dead. Would you like to restart or quit?" , "RPG Game", JOptionPane.PLAIN_MESSAGE, null, contOptions, contOptions[0]);
               switch(cont)
               {
                  case "Restart":
                     playerName();
                     break;
                  case "Quit":
                     System.exit(0);
                     break;
               }
           }         
      }

    if(count == events.length - 1)
    {
      cont = (String)JOptionPane.showInputDialog(null, "You have won! Congratulations. Would you like to play again?" , "RPG Game", JOptionPane.PLAIN_MESSAGE, null, contOptions, contOptions[0]);
      switch(cont)
      {
          case "Restart":
             playerName();
             break;
          case "Quit":
             System.exit(0);
             break;
      }
    }
  }
}

