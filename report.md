# ldts-project-assignment-g1006
ldts-project-assignment-g1006 created by GitHub Classroom
## LDTS_<10><1006> - Space Invaders


In this text based game you'll fight the Earth invaders with your own spaceship! The objective will be to take down every single alien ship without being hit once. If your ship is the last one standing you won the game. Good luck, our future is in your hands.

This project was developed by Alexandre Correia (up202007042@fe.up.pt), Henrique Silva (up202007242fe.up.pt) and Tiago Branquinho (up202005567@fe.up.pt) for LDTS 2021/2022.

### Implemented Features

- **Movement** - Single direction movement. Every spaceship moves horizontally.

- **Aliens** - Represented by character 'A'. They switch direction when they are about to leave the arena. SCREENSHOT OF THE ALIENS
- **Ammo** - The player can shoot multiple bullets. If an alien is hit, it will die and dissapear from the screen.
SCREENSHOT OF THE AMMO BEING SHOT


### DESIGN

> This section should be organized in different subsections, each describing a different design problem that you had to solve during the project. Each subsection should be organized in four different parts:

- **Problem in Context.** The description of the design context and the concrete problem that motivated the instantiation of the pattern. Someone else other than the original developer should be able to read and understand all the motivations for the decisions made. When refering to the implementation before the pattern was applied, don’t forget to [link to the relevant lines of code](https://help.github.com/en/articles/creating-a-permanent-link-to-a-code-snippet) in the appropriate version.
- **The Pattern.** Identify the design pattern to be applied, why it was selected and how it is a good fit considering the existing design context and the problem at hand.
- **Implementation.** Show how the pattern roles, operations and associations were mapped to the concrete design classes. Illustrate it with a UML class diagram, and refer to the corresponding source code with links to the relevant lines (these should be [relative links](https://help.github.com/en/articles/about-readmes#relative-links-and-image-paths-in-readme-files). When doing this, always point to the latest version of the code.
- **Consequences.** Benefits and liabilities of the design after the pattern instantiation, eventually comparing these consequences with those of alternative solutions.

**Example of one of such subsections**:


**Problem in Context**

While thinking about the Game it self, we realised that there could be lots of Game class objects created during an execution of the code. That is obviously incorrect, since there can only be ONE object of the Game class.
SCREENSHOT OF GAME CONSTRUCTOR BEFORE IMPLEMENTATION OF THE PATTERN (using methods explained above)

**The Pattern**

We decided to use the Singleton Pattern, which can be classified as a Creational Pattern. This limits the ammount of instances of a class, so it can have only one, which can be called anywhere in the code.

**Implementation**

The following images show in detail how the pattern was implemented:
SCREENSHOT OF GAME SINGLETON PATTERN AND APPLICATION.JAVA (using methods explained above)
UML DIAGRAM SCREENSHOT

**Consequences**

The usage of this pattern had a positive impact in our code, since it completely solved our problem. In fact, it was impossible to achieve what we wanted using a regular constructor for the game class, since constructors always return a new object, by design.


**Problem in Context**

We realized that each object of each class that extended Element had to be drawn. The problem regarding that is the code is very fragile in the sense that if we wanted to add way more different things to be drawed, it could have gotten out of hand very easily.
SCREENSHOT OF ARENA DRAW (using methods explained above)

**The Pattern**

We decided to use the Command Pattern, which can be considered a Behavioral Pattern. This can structure a system around high-level operations built on primitive operations. In fact, this design turns a funtion call into an object that contains all the information about the request itself.

**Implementation**

The following images show in detail how the pattern was implemented:
SCREENSHOT OF DRAW COMMAND PATTERN AND SOME CLASSES THAT EXTEND ELEMENT (using methods explained above)
UML DIAGRAM SCREENSHOT

**Consequences**

The usage of this pattern granted the ability to separate the entity that invokes the operation from the element that knows how to handle and performs it.

#### KNOWN CODE SMELLS AND REFACTORING SUGGESTIONS


**Example of such a subsection**:


#### FEATURE ENVY
https://refactoring.guru/smells/feature-envy

This code smell consists of a method (or in this case, a part of a method) that uses more data from another class that its own. For example, part of the code in Game::run() function, specially the section after the arena.processkey() function call, only uses data from the Arena class, so it should be in that class.
The solution is very simple. The code should be moved to the arena class, using the move method: https://refactoring.guru/move-method.


### TESTING

Here's an image of the tests' coverage report.
SREENSHOT OF TESTS COVERAGE REPORT

### SELF-EVALUATION

In our opinion, each individual of the group worked and contributed a lot to this project. While everyone focused on developing and testing new features on an early stage of the project, on a later stage each individual focused more on specific parts of it. For instance:
Alexandre Correia did the UML diagram;
Henrique Silva focused on testing and writing the initial part of the Project's description;
Tiago Branquinho implemented the design patterns and made the Report.

Considering that, we evaluate ourselves equaly:
Alexandre Correia: 33%
Henrique Silva: 34%
Tiago Branquinho: 33%