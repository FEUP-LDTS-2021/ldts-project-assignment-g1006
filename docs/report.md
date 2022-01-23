# ldts-project-assignment-g1006
ldts-project-assignment-g1006 created by GitHub Classroom

[![BCH compliance](https://bettercodehub.com/edge/badge/FEUP-LDTS-2021/ldts-project-assignment-g1006?branch=main&token=6c2912fabeb46d2118283b31263a3e4c40ce67a8)](https://bettercodehub.com/)


## LDTS_<10><1006> - Space Invaders


In this text based game you'll fight the Earth invaders with your own spaceship! The objective will be to take down every single alien ship without running out of lives. If your ship is the last one standing you won the game. Good luck, our future is in your hands.

This project was developed by Alexandre Correia (up202007042@fe.up.pt), Henrique Silva (up202007242fe.up.pt) and Tiago Branquinho (up202005567@fe.up.pt) for LDTS 2021/2022.

### Implemented Features

- **Connected Menus** - The user has the capability of browsing through all the different menus, which are: main menu, won menu, lost menu, leaderboard menu and playing menu, where the game takes place.

- **Buttons** - The user can switch the selected button with the respective ARROW KEYS, according to their relative position. They are activated by pressing ENTER.

- **Leaderboard** - If the player ends up victorious, he can choose to add his name to the current Leaderboard, which is a file that contains information about the winners and their times.

- **Movement** - Single direction movement. Every spaceship, including the player, only moves horizontally. Alien movement is automatic.

- **Aliens** - They switch direction when they are about to leave the arena or in the inevitability of colliding with each other. Some are Armored and others are Normal ones, which are drawn differently.

- **Ammo** - The player can shoot up to 2 bullets shown in the arena. If an alien is hit, there are many possibilities:
  - If the alien is normal, it will die and disappear from the screen, since it has 0 armor;
  - If the alien is armored and the ammo can't kill it, if it didn+t break the alien's armor, the ammo will be reflected;
  - If a bullet kills a certain alien, it will continue through it, with its damage reduced, if it is greater than 0.

- **Walls** - The arena has a few walls with a fixed number of resistance, in order for the player to defend itself.

- **Player** - It has 3 lives.

- **Animations** - When an alien loses its armor it becomes a normal one, changing its form and colour.

- **Graphics** - There are several custom shapes implemented in the game.

- **Collisions detection** - Collisions between ammo and spaceships or walls are taken into consideration. The game will be over if either the player or all aliens die.

- **Randomness** - The player's ammo has a 40% chance of dealing 2 damage. Plus, the armor of the alliens at the start of a game is random, varying from 0 to 3.

### Planned Features

We've managed to add every planned feature and a few more.


## DESIGN

### Singleton Pattern

**Problem in Context**

While thinking about the Game itself, we realised that there could be lots of Game class objects created during an execution of the code. That is obviously incorrect, since there can only be ONE object of the Game class.
Link to Game class constructor: https://github.com/FEUP-LDTS-2021/ldts-project-assignment-g1006/blob/main/src/main/java/com/spaceinvaders/Game.java#L22 .

**The Pattern**

We decided to use the Singleton Pattern, which can be classified as a Creational Pattern. This limits the ammount of instances of a class, so it can have only one, which can be called from anywhere in the code.

**Implementation**

The following image shows in detail how the pattern was implemented:
<p align="center" justify="center">
  <img src="singletonUML"/>
</p>

The code regarding this pattern can be found in the following links:
- Game - Singleton: https://github.com/FEUP-LDTS-2021/ldts-project-assignment-g1006/blob/main/src/main/java/com/spaceinvaders/Game.java#L20
- Game - getInstace: https://github.com/FEUP-LDTS-2021/ldts-project-assignment-g1006/blob/main/src/main/java/com/spaceinvaders/Game.java#L28
- Application: https://github.com/FEUP-LDTS-2021/ldts-project-assignment-g1006/blob/main/src/main/java/com/spaceinvaders/Application.java#L9


**Consequences**

The usage of this pattern had a positive impact in our code, since it completely solved our problem. In fact, it was impossible to achieve what we wanted using a regular constructor for the game class, since constructors always return a new object, by design.

### Command Pattern

**Problem in Context**

We realized that the class Button would have to be extended by many others, since there are naturally buttons with unique functionalities. The problem is that the creation of those several subclasses would eventually become exponencial.


**The Pattern**

We decided to use the Command Pattern, which can be considered a Action Pattern. This can structure a system around high-level operations built on primitive operations. In fact, this design turns a funtion call into an object that contains all the information about the request itself, letting you use various commands with the same request sender.

**Implementation**

The following image shows in detail how the pattern was implemented:
<p align="center" justify="center">
  <img src="drawcommandUML"/>
</p>

These classes can be found in the following files:
- [Button](../src/main/java/com/spaceinvaders/model/menu/Button.java)
- [Command](../src/main/java/com/spaceinvaders/controller/command/ButtonCommand.java)

**Consequences**

The usage of this pattern granted the ability to separate the entity that invokes the operation from the element that knows how to handle and performs it.

#### KNOWN CODE SMELLS AND REFACTORING SUGGESTIONS


**Example of such a subsection**:


#### FEATURE ENVY
https://refactoring.guru/smells/feature-envy

This code smell consists of a method (or in this case, a part of a method) that uses more data from another class that its own. For example, part of the code in Game::run() function, specially the section after the arena.processkey() function call, only uses data from the Arena class, so it should be in that class.
The solution is very simple. The code should be moved to the arena class, using the move method: https://refactoring.guru/move-method.


### SELF-EVALUATION

In our opinion, each individual of the group worked and contributed a lot to this project. While everyone focused on developing and testing new features on an early stage of the project, on a later stage each individual focused more on specific parts of it. For instance:
Alexandre Correia did the UML diagram;
Henrique Silva focused on testing and writing the initial part of the Project's description;
Tiago Branquinho implemented the design patterns and made the Report.

Considering that, we evaluate ourselves equaly:
Alexandre Correia: 33%
Henrique Silva: 34%
Tiago Branquinho: 33%