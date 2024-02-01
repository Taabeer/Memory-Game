# Memorizing Lines Game
## Script Game

The Scriptgame Java program is an interactive game designed for users to practice lines from a script. It offers feedback on the accuracy of the lines entered by the user, providing an engaging method for script rehearsal.

### Classes

#### Linkedlist

- **Description**: Implements a basic linked list data structure.
- **Methods**:
  - insert: Inserts a new node into the linked list.
  - toString: Converts the linked list to a string representation.
  - length: Computes the length of the linked list.
  - isEmpty: Checks if the linked list is empty.
  - positionfinder: Finds the data at a specific position in the linked list.
  - duplicateCheck: Checks for duplicates within the linked list.
  - editinsertion: Edits the data at a specific position in the linked list.

#### Node

- **Description**: Represents a node in the linked list.
- **Fields**:
  - data: Holds the data for the node.
  - next: Points to the next node in the linked list.

#### Scriptgame

- **Description**: Orchestrates the script game, enabling users to interact with the script and receive feedback on their lines.
- **Fields**:
  - characterlines: Linked list to store lines for characters.
  - cuelines: Linked list to store cue lines.
  - fullscript: Linked list to store the entire script.
- **Methods**:
  - script: Reads the script from a file, parses it, and prepares character lines and cue lines.
  - Levenshtein_distance: Computes the Levenshtein distance between two strings.
  - main: Main method to run the script game.
## Script Game

The Scriptgame Java program is an interactive game designed for users to practice lines from a script. It offers feedback on the accuracy of the lines entered by the user, providing an engaging method for script rehearsal.

### Classes

#### Linkedlist

- **Description**: Implements a basic linked list data structure.
- **Methods**:
  - insert: Inserts a new node into the linked list.
  - toString: Converts the linked list to a string representation.
  - length: Computes the length of the linked list.
  - isEmpty: Checks if the linked list is empty.
  - positionfinder: Finds the data at a specific position in the linked list.
  - duplicateCheck: Checks for duplicates within the linked list.
  - editinsertion: Edits the data at a specific position in the linked list.

#### Node

- **Description**: Represents a node in the linked list.
- **Fields**:
  - data: Holds the data for the node.
  - next: Points to the next node in the linked list.

#### Scriptgame

- **Description**: Orchestrates the script game, enabling users to interact with the script and receive feedback on their lines.
- **Fields**:
  - characterlines: Linked list to store lines for characters.
  - cuelines: Linked list to store cue lines.
  - fullscript: Linked list to store the entire script.
- **Methods**:
  - script: Reads the script from a file, parses it, and prepares character lines and cue lines.
  - Levenshtein_distance: Computes the Levenshtein distance between two strings.
  - main: Main method to run the script game.

### Typo Algorithm: Levenshtein Distance

The Levenshtein distance algorithm calculates the minimum number of single-character edits (insertions, deletions, or substitutions) required to change one word into another. It measures the similarity between two strings by counting the minimum number of operations needed to transform one string into the other. The `Levenshtein_distance` method in the Scriptgame calculates the distance between the user-entered line and the correct line, allowing for tolerant feedback on minor typos.

### How to Use

1. **Prepare Your Script**: Copy and paste your script into a file named `script.txt`.
2. **Run the Program**: Execute the main method in the `Scriptgame` class.
3. **Enter Your Character**: Type the character you will be playing when prompted.
4. **Play the Game**: You will be presented with cue lines. Type your character lines accordingly.
5. **Receive Feedback**: The program will provide feedback on the correctness of your lines. Minor typos are tolerated.
6. **Continue or Quit**: You can choose to play another round or quit the game.
7. **Review Incorrect Lines**: If you made mistakes, the program will provide you with a resource named `incorrect.txt` containing the lines you struggled with the most.
