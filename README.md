# GeoMaster

**How well do you *really* know the world?**

GeoMaster is a JavaFX geography trivia game that puts your knowledge of flags, borders, capitals, and country stats to the test across five different game modes.

---

## Game Modes

### Guess the Flag
A flag appears on screen along with four country names to choose from. Pick the right one and move on — the game continues until your first wrong guess.

### Guess the Silhouette
Only the outline of a country is shown, with four country names as options. Can you recognize a nation by its shape alone? Survives until the first mistake ends the run.

### Higher or Lower
You're given a statistic — GDP, population, area, and more — along with two countries. Pick the one you think scores higher on that stat to earn a point. Keep going until you guess wrong.

### Four Facts, One Country
Sixteen facts are scattered across the screen. Your job: find and click the four facts that all belong to the same country, back to back. Click a fact that doesn't match mid-sequence and you lose a life — then it's back to square one for that round. Match all four correctly and they vanish from the board. Clear every fact from the screen to win.

### Guess the Capital
A capital city is shown, and you pick the matching country from four options. One wrong answer and the round is over.

---

## Tech Stack

- **Language:** Java
- **JDK:** Azul Zulu 24
- **UI Framework:** JavaFX
- **Database:** Embedded SQLite (zero external dependencies — no separate database server required)
- **Packaging:** `jpackage` / `jlink` — bundled as a native Windows installer

---

## Installation

1. Head over to [**the latest GeoMaster release**](https://github.com/29veljace/GeoMaster/releases/tag/v1.0.0).
2. Download the latest release.
3. Run the installer and follow the on-screen steps.
4. Launch GeoMaster from your Start Menu and start playing.
