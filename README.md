# Tic Tac Toe Game 🎮❌⭕  

[![Kotlin](https://img.shields.io/badge/Language-Kotlin-orange?logo=kotlin)](https://kotlinlang.org/)  
[![Android Studio](https://img.shields.io/badge/IDE-Android_Studio-brightgreen?logo=android-studio)](https://developer.android.com/studio)  
[![License](https://img.shields.io/badge/License-MIT-blue)](LICENSE)  

---

## Project 🎯
This Android app is a **Tic Tac Toe game** implemented in **Kotlin** with a **modern and responsive UI**.  
It features **player score tracking**, **turn-based gameplay**, **winner detection**, **round reset**, and **game reset**.  

---

## App Layout 🎨

### Main Screen
- **GridLayout 3x3** for the game board.  
- **Player score display** at the top:
  - Player X: Blue (#42A5F5)  
  - Player O: Red (#EF5350)  
- **Current player indicator** at the top center.  
- **Round Reset button**: Yellow (#FFEB3B)  
- **Game Reset button**: Amber (#FFC107)

### Game Board
- Each cell is a **TextView**, 80x80dp, bold 36sp.  
- Background: semi-transparent gray (#66444466).  
- Click animation: elevation and translationZ.  

### Winner / Draw Handling
- Highlights winning cells in white (#FAFAFA).  
- Draws reset board automatically.  
- Next round starts with the previous loser.  
- Temporarily disables input after a win for 3.8 seconds.

### Print's of Main Screen

  <p align="center" >
   <img width="300" height="600" alt="Main Screen 1" src="https://github.com/user-attachments/assets/d9877a0a-6042-405d-85eb-001674ca3d7e"" />
   <img width="300" height="600" alt="Main Screen 2" src="https://github.com/user-attachments/assets/d31bba18-6c2a-431c-b91b-a3996b18013c" />
</p>

---

---

## Features ✨
| Feature | Description |
|---------|-------------|
| Player Score Tracking | Updates scores for X and O |
| Turn Management | Alternates between X and O |
| Winner Detection | Checks all 8 winning combinations |
| Round Reset | Clears board, keeps scores |
| Game Reset | Clears board and scores |
| UI Feedback | Animations, color-coded players, highlights |
| Draw Detection | Resets board automatically |
| Touch Blocking | Disables input after win |
| Modern Design | Edge-to-edge layout, responsive |

---

## Technologies Used 🤖
- **Programming Language:** Kotlin  
- **Development Environment:** Android Studio  
- **UI Components:** ConstraintLayout, GridLayout, LinearLayout, TextView, Button  
- **Colors:**  
  - Player X: Blue (#42A5F5)  
  - Player O: Red (#EF5350)  
  - Round Reset: Yellow (#FFEB3B)  
  - Game Reset: Amber (#FFC107)  
  - Default cells: Gray (#66444466)  
  - Winner highlight: White (#FAFAFA)  
- **Animation:** Cell elevation translation  
- **Platform:** Android Mobile Devices  

---

## Gameplay Logic 💡
1. Player X starts by default.  
2. Player clicks an empty cell to place their mark.  
3. Check for winner: highlight winning cells, increment score, block input 3.8s.  
4. Next round: loser starts.  
5. Round Reset: clears board, keeps scores.  
6. Game Reset: clears board and scores.  
7. Draw: resets board without changing scores.  

---

## Author 💻
**Lucas Samuel Dias**  
- Kotlin Android Developer  
- Focused on mobile game UI/UX and logic
