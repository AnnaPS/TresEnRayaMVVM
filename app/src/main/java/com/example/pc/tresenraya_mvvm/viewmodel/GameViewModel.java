package com.example.pc.tresenraya_mvvm.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableArrayMap;

import com.example.pc.tresenraya_mvvm.model.Cell;
import com.example.pc.tresenraya_mvvm.model.Game;
import com.example.pc.tresenraya_mvvm.model.Player;

import static com.example.pc.tresenraya_mvvm.utilities.StringUtility.stringFromNumbers;

public class GameViewModel extends ViewModel {
    /**
     * Para poder utilizar ObservableArrayMap, hay que modificar el fichero gradle y añadir
     *   dataBinding {
     *      enabled = true
     *   }
     */
    public ObservableArrayMap<String, String> cells;
    private Game game;

    public void init(String player1, String player2) {
        game = new Game(player1, player2);
        cells = new ObservableArrayMap<>();
    }
    /**
     * Metodo que se vincula al xml para conocer cada vez que se pulsa una celda
     * @param row
     * @param column
     */
    public void onClickedCellAt(int row, int column) {
        if (game.cells[row][column] == null) {
            game.cells[row][column] = new Cell(game.currentPlayer);
            cells.put(stringFromNumbers(row, column), game.currentPlayer.value);
            if (game.hasGameEnded())
                game.reset();
            else
                game.switchPlayer();
        }
    }

    /**
     * Atributo que la vista observara para indicar si hay un ganador y asi
     * la vista pueda reaccionar y actualizarse
     * @return
     */
    public LiveData<Player> getWinner() {
        return game.winner;
    }
}
