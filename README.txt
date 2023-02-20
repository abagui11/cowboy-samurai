=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=
This is a game I made for an intro computer science class where you play as a cowboy samurai who needs to protect the desert
by defeating all the crabs. Inspired by Kaarin Gaming.
=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=

![Example 1](exampleimage1.png)
![Example 2](exampleimage2.png)

  entity Package:
    Crabby: Crab enemy object that extends Enemy abstract class
    Enemy: Abstract class that extends Entity and gives all subclasses methods on how to interact w player
    EnemyManager: Provides the draw and update methods for enemies, rendering them to the game and updating them when
    the playing state is active.
    Entity: Abstract class that gives subclasses position and hitbox information.
    Player: Extends Entity and has player behavior.

  gameStates package:
    End: End gamestate that is activated when the timer hits 0 or the player dies. Displays how many crabs killed.
    Gamestate: Enum class that keeps track of gamestates and starts the active state with the menu.
    Menu: Menu gamestate that is activated on default, and is the place to start the actual game, see the rules, or
    quit the application
    Playing: The actual game gamestate that renders the game and its logic
    Rules: Rules gamestate that displays the rules of the game
    State: Generic state that creates the game object that is used in the main package
    Statemethods: Interface that has some commonly used methods across our states like keyboard and mouse inputs and
    draw and render methods

  inputs package:
    KeyboardInputs: Keeps track of keyboard inputs by calling specific keyboard inputs depending on state
    MouseInputs: Keeps track of mouse inputs by calling specific mouse inputs depending on state

  levels package:
    Level: simple class with getter methods that makes handling level data easier
    LevelManager: Turns the 2d array read in from the level_data sprite in LoadSave into an actual map by fetching
    appropriate tiles from the level sprite

  main package:
    Game: Creates the gameloop that updates frames and logic, initializes the state objects depending on the game state
    and runs appropriate logic and renderings based on active state
    GameFrame: Creates the JFrame window to run the game in
    GamePanel: Creates the panel that goes in the JFrame window that runs the game inside it
    MainClass: public static void main method that starts the program by calling game object

  ui package:
    Menu Button:Creates the button behavior on the menu by calculating when mouse is hovering/ clicking a button and
    also providing methods for rendering the buttons

  utils package:
    Constants: Helpful constants that do not change for access throughout the program
    HelpMethods: Helpful static methods that do not require dynamic dispatch also used throughout the program
    LoadSave: Where the File I/O happens, loads in images and does some logic on them to get information about the map
    and enemies
    Stopwatch: Countdown object that is started in the Playing class and ends the playing class when it hits zero

========================
=: External Resources :=
========================

  - crabby sprites from https://pixelfrog-assets.itch.io/
  - menu background here https://pixelfrog-assets.itch.io/ and recolored
  - outside_sprites here https://pixelfrog-assets.itch.io/ and recolored
  - small_clouds here https://pixelfrog-assets.itch.io/


