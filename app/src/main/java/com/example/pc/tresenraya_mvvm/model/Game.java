package com.example.pc.tresenraya_mvvm.model;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import static com.example.pc.tresenraya_mvvm.utilities.StringUtility.isNullOrEmpty;

public class Game {

    /**
     * Representa un juego real de Tres en raya, y por lo tanto tiene 2 jugadores, una lista (matriz 3x3) de 9 celdas.
     * En cada ronda del juego, un jugador realiza un movimiento, de ahí el atributo actualPlayer, y finalmente un ganador.
     */


    private static final String TAG = Game.class.getSimpleName();
    private static final int BOARD_SIZE = 3;

    public Player player1;
    public Player player2;

    public Player currentPlayer = player1;
    public Cell[][] cells;

    public MutableLiveData<Player> winner = new MutableLiveData<>();

    public Game(String playerOne, String playerTwo) {
        cells = new Cell[BOARD_SIZE][BOARD_SIZE];
        player1 = new Player(playerOne, "x");
        player2 = new Player(playerTwo, "o");
        currentPlayer = player1;
    }

    // metodo para cambiar de jugador
    public void switchPlayer() {
        currentPlayer = currentPlayer == player1 ? player2 : player1;
    }

    //metodo para saber si el juego terminó
    public boolean hasGameEnded() {
        if (hasThreeSameHorizontalCells() || hasThreeSameVerticalCells() || hasThreeSameDiagonalCells()) {
            winner.setValue(currentPlayer);
            return true;

        }

        if (isBoardFull()) {
            winner.setValue(null);
            return true;
        }
        return false;
    }


    // saber si hay 3 simbolos iguales horizontales
    private boolean hasThreeSameHorizontalCells() {
        try {
            for (int i = 0; i < BOARD_SIZE; i++) {
                if (areEqual(cells[i][0], cells[i][1], cells[i][2])) {
                    return true;
                }
            }
            return false;
        } catch (NullPointerException e) {
            Log.e(TAG, e.getMessage());
            return false;
        }
    }

    // saber si hay 3 simbolos iguales verticales
    private boolean hasThreeSameVerticalCells() {
        try {
            for (int i = 0; i < BOARD_SIZE; i++) {
                if (areEqual(cells[0][i], cells[1][i], cells[2][i])) {
                    return true;
                }
            }
            return false;
        } catch (NullPointerException e) {
            Log.e(TAG, e.getMessage());
            return false;
        }
    }

    // saber si hay 3 simbolos iguales diagonales
    private boolean hasThreeSameDiagonalCells() {
        try {
            return areEqual(cells[0][0], cells[1][1], cells[2][2]) ||
                    areEqual(cells[0][2], cells[1][1], cells[2][0]);
        } catch (NullPointerException e) {
            Log.e(TAG, e.getMessage());
            return false;
        }
    }

    // comprobar si el tablero está completo
    private boolean isBoardFull() {
        for (Cell[] row : cells)
            for (Cell cell : row)
                if (cell == null || cell.isEmpty())
                    return false;
        return true;
    }

    /**
     * Comprobar si dos celas son iguales. Son iguales si:
     * - Ambas no son null
     * - Ambas no tienen valores nulos
     * - Ambas tienen el mismo valor
     *
     * @return
     */
    private boolean areEqual(Cell... cells) {
        if (cells == null || cells.length == 0)
            return false;

        for (Cell cell : cells)
            if (cell == null || isNullOrEmpty(cell.player.value))
                return false;

        Cell comparacionBase = cells[0];
        for (int i = 0; i < cells.length; i++)
            if (!comparacionBase.player.value.equals(cells[i].player.value))
                return false;
        return true;

    }
    // volver a comenzar la partida
    public void reset(){
        player1 =null;
        player2 = null;
        currentPlayer= null;
        cells = null;
    }
}
