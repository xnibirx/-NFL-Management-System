A Java application for managing NFL teams, players, coaches, and game schedules with CSV data support.

## Features

- Manage teams, players, and coaches
- Schedule and track games
- Load data from CSV files
- Console-based user interface
- Serializable object support

## Getting Started

### Prerequisites
- Java JDK 17 or later
- Maven (optional)

### Installation
1. Clone the repository:
   git clone https://github.com/yourusername/nfl-management-system.git

2. Navigate to project directory:
    cd nfl-management-system

3. Running the Application

Compile and run the main class:
javac *.java
java NFLManagementSystem

4. File Structure
src/
├── Coach.java           # Coach entity class
├── Game.java            # Game entity class
├── GameManager.java     # Game management logic
├── NFLManagementSystem.java # Main application
├── Player.java          # Player entity class
├── PlayerManager.java   # Player management
├── Team.java            # Team entity class
└── TeamManager.java     # Team management
data/
├── coaches.csv          # Coach data
├── games.csv            # Game schedule
├── players.csv          # Player data
└── teams.csv            # Team data

5. Usage

Follow the console menu to:
View teams/players/games
Add new teams/players
Search for teams

6. Important Note on CSV Files

Before running the application:
Update the file paths in NFLManagementSystem.java (lines loading teams.csv, players.csv, etc.) to match your local system.
Example change:
// Before (example)  
teamManager.loadTeamsFromFile("C:\\path\\to\\teams.csv");  
// After (adjust to your path)  
teamManager.loadTeamsFromFile("./data/teams.csv");  
For portability, place CSV files in a data/ folder within your project directory.

7. License
MIT License. See LICENSE for details.
