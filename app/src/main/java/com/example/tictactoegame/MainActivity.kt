package com.example.tictactoegame

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.graphics.Color
import android.os.Handler
import android.os.Looper
import android.view.WindowManager

class MainActivity : AppCompatActivity() {

    private lateinit var cells: Array<TextView>
    private var currentPlayer = "X"
    private lateinit var textViewCurrentPlayer: TextView
    private lateinit var textViewPlayerX: TextView
    private lateinit var textViewPlayerO: TextView
    private var playerXScore = 0
    private var playerOScore = 0
    private var lastWinner = "X"


    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        cells = arrayOf(
            findViewById(R.id.cell01),
            findViewById(R.id.cell02),
            findViewById(R.id.cell03),
            findViewById(R.id.cell04),
            findViewById(R.id.cell05),
            findViewById(R.id.cell06),
            findViewById(R.id.cell07),
            findViewById(R.id.cell08),
            findViewById(R.id.cell09)
        )

        textViewCurrentPlayer = findViewById<TextView>(R.id.textViewCurrentPlayer)
        textViewPlayerX = findViewById<TextView>(R.id.textViewPlayerX)
        textViewPlayerO = findViewById<TextView>(R.id.textViewPlayerO)
        val resetRound = findViewById<Button>(R.id.btnRoundReset)
        val resetGame = findViewById<Button>(R.id.btnGameReset)

        cells.forEach { cell ->
            cell.setOnClickListener {
                if (cell.text.isEmpty()) {
                    cell.text = currentPlayer
                    animateCell(cell)
                    colorXO(cell)
                    if (checkWinner()) {
                        Toast.makeText(this, "Player $currentPlayer won!", Toast.LENGTH_LONG).show()
                        scoreGame()
                        window.setFlags(
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
                        )
                        Handler(Looper.getMainLooper()).postDelayed({
                            window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                            resetRound()
                        }, 3800)
                    } else if (cells.all { it.text.isNotEmpty() }) {
                        Toast.makeText(this, "Draw!", Toast.LENGTH_LONG).show()
                        resetRound()
                    } else {
                        currentPlayer = if (currentPlayer == "X") "O" else "X"
                    }
                }
            }
        }

        resetRound.setOnClickListener {
            resetRound()
        }

        resetGame.setOnClickListener {
            resetGame()
        }
    }

    private fun colorXO(cell: TextView) {
        if (currentPlayer == "X") {
            cell.setTextColor(Color.parseColor("#42A5F5"))
        } else {
            cell.setTextColor(Color.parseColor("#EF5350"))
        }
    }

    private fun animateCell(cell: TextView) {
        cell.animate().translationZ(16f).setDuration(150).withEndAction {
            cell.animate().translationZ(8f).duration = 150
        }.start()
    }

    private fun checkWinner(): Boolean {
        val winningPositions = arrayOf(
            intArrayOf(0,1,2),
            intArrayOf(3,4,5),
            intArrayOf(6,7,8),
            intArrayOf(0,3,6),
            intArrayOf(1,4,7),
            intArrayOf(2,5,8),
            intArrayOf(0,4,8),
            intArrayOf(2,4,6)
        )

        for (pos in winningPositions) {
            val (a,b,c) = pos
            if (cells[a].text.isNotEmpty() && cells[a].text == cells[b].text && cells[a].text == cells[c].text) {
                cells[a].setBackgroundColor(Color.parseColor("#FAFAFA"))
                cells[b].setBackgroundColor(Color.parseColor("#FAFAFA"))
                cells[c].setBackgroundColor(Color.parseColor("#FAFAFA"))
                return true
            }
        }
        return false
    }

    private fun scoreGame() {
        if (currentPlayer == "X") {
            playerXScore++
            textViewPlayerX.text = "Player X: $playerXScore"
            lastWinner = "X"
        } else {
            playerOScore++
            textViewPlayerO.text = "Player 0: $playerOScore"
            lastWinner = "O"
        }
    }

    private fun resetGame() {
        playerXScore = 0
        playerOScore = 0
        textViewPlayerX.text = "Player X: $playerXScore"
        textViewPlayerO.text = "Player 0: $playerOScore"
        resetRound()
        currentPlayer = "X"
    }

    private fun resetRound() {
        cells.forEach {
            it.text = ""
            it.setBackgroundColor(Color.parseColor("#66444466"))
        }
        currentPlayer = if (lastWinner == "X") "O" else "X"
        textViewCurrentPlayer.text = "Player's Turn: $currentPlayer"
    }
}
