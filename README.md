# FirstGame
Project 1

For this project, you will create a text adventure game entirely in Java, playable in Spring Tool Suite or by running your program in a terminal. 
This game will guide the player through several scenes and take player input via the console or command line — think of classic text adventures like Adventure or Zork. 
You will present the player with several scenes, described to them in text, then allow them to make choices and determine the outcome. 
All feedback to the player should be printed to the console, and their choices should lead them to some sort of endgame 
conclusion — win, lose, live, die...or something in between! 

A scene should include a starting description, then one or more clearly-defined choices that determine the outcome
based at least in part on player properties. For example: 

 

You enter the record executive’s office, and producer DJ KashMunnee sits behind her desk, counting her stacks of Benjamins.
She side-eyes you from behind her $900 sunglasses and drawls with notable disinterest, “Whatcha got for me?” You clear your throat and then: 

Clap back, “The question is, KashMunnee, what do YOU have for ME?” 
Fumble a cassette into her boombox and play your grindcore remix of “Swanee River” 
Run from the office and delete your SoundCloud account 
 

Let’s say the player chooses “a” and your player properties include a “Confidence” value. If the “Confidence” value is high enough, the 
producer might hire you out of respect, but if it’s too low, she might trash you on Instagram. 

The subject and setting of your game are up to you, as long as you fulfill the technical requirements outlined below. Bonus Challenges are not
required or limited to the options listed — feel free to get creative and have fun! 

 

Technical Requirements: 

Application is written in Java 8 
Must be playable entirely in the console or through the command line 
Obtains user input through the Scanner class 
Must incorporate a Player class containing pertinent player properties 
Examples include: 
Health Points (HP) 
Strength 
Wisdom 
Magic 
Player Experience Level 
Upon program start, prompt the user to create their specific player object by choosing their property values or by allowing chance to decide 
Must include a Scene class that includes information and data on the scene  
Scenes should take into account the player’s specific properties during the scene event 
Game must progress through at least 3 unique scenes 
No back-to-back repeating scenes 
Game must include at least 2 distinct game end scenarios 
Code should compile and run 
Code should conform to standard naming conventions and coding best practices 
All necessary files should be present on a public GitHub repository by the due date 
Bonus Challenge Ideas: 

Select the scenes through random chance
Keep a score 
Persist the score to some save file or database 
Keep track of the all-time high scores 
Keep a daily high score 
Allow the same user to play again upon winning 
Build the game so that it can be played via a GUI using JavaFX 
Allow the user to pick whether they want to play using the GUI or CLI upon program start 
Add different game difficulties that the user can select upon program start that effects how the scenes play out 
Create a game walk-thru guide using Markdown and have it present on GitHub 
