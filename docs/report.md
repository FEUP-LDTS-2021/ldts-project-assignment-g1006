# ldts-project-assignment-g1006
ldts-project-assignment-g1006 created by GitHub Classroom

[![BCH compliance](https://bettercodehub.com/edge/badge/FEUP-LDTS-2021/ldts-project-assignment-g1006?branch=main&token=6c2912fabeb46d2118283b31263a3e4c40ce67a8)](https://bettercodehub.com/)


## LDTS_<10><1006> - Space Invaders


In this text based game you'll fight the Earth invaders with your own spaceship! The objective will be to take down every single alien ship without running out of lives. If your ship is the last one standing you won the game. Good luck, our future is in your hands.

This project was developed by Alexandre Correia (up202007042@fe.up.pt), Henrique Silva (up202007242fe.up.pt) and Tiago Branquinho (up202005567@fe.up.pt) for LDTS 2021/2022.

### Implemented Features

- **Movement** - Single direction movement. Every spaceship moves horizontally.
- **Aliens** - Represented by character 'A'. They switch direction when they are about to leave the arena. 
- **Ammo** - The player can shoot multiple bullets. If an alien is hit, it will die and dissapear from the screen.

### Planned Features

- **Aliens** - They exist in many shapes and forms. Some will be able to shoot back at the player (only the ones that dont have any others bellow them). They can have armor aswell.
  MOCK OF FUTURE ALIENS

- **Menu** - We will design a Menu for the game, which will be able to redirect the player to the leaderboard or the game.

- **Leaderboard** - Contains the best players' names, and the time that needed to defeat the Aliens.

- **Shields** - They will be deployed between the Player and the Aliens. They can support a limited amount of Ammo, so they will eventually break.

- **Ammo** - The ammo that the player can shoot will be limited. In this way, it can only shoot one or a few bullets at a time.


## DESIGN

### Singleton Pattern

**Problem in Context**

While thinking about the Game itself, we realised that there could be lots of Game class objects created during an execution of the code. That is obviously incorrect, since there can only be ONE object of the Game class.
Link to Game class constructor: https://github.com/FEUP-LDTS-2021/ldts-project-assignment-g1006/blob/68d6da17c528137e35c9dc79a5c4d23cc771390e/src/main/java/Game.java#L28 .

**The Pattern**

We decided to use the Singleton Pattern, which can be classified as a Creational Pattern. This limits the ammount of instances of a class, so it can have only one, which can be called anywhere in the code.

**Implementation**

The following image shows in detail how the pattern was implemented:
<p align="center" justify="center">
  <img src="singletonUML"/>
</p>

**Consequences**

The usage of this pattern had a positive impact in our code, since it completely solved our problem. In fact, it was impossible to achieve what we wanted using a regular constructor for the game class, since constructors always return a new object, by design.

### Command Pattern

**Problem in Context**

We realized that each object of each class that extended Element had to be drawn. The problem regarding that is the code is very fragile in the sense that if we wanted to add way more different things to be drawed, it could have gotten out of hand very easily.


**The Pattern**

We decided to use the Command Pattern, which can be considered a Behavioral Pattern. This can structure a system around high-level operations built on primitive operations. In fact, this design turns a funtion call into an object that contains all the information about the request itself.

**Implementation**

The following image shows in detail how the pattern was implemented:
<p align="center" justify="center">
  <img src="drawcommandUML"/>
</p>

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