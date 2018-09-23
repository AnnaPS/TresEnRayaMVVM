package com.example.pc.tresenraya_mvvm.model;

import com.example.pc.tresenraya_mvvm.utilities.StringUtility;

public class Cell {

    // objeto jugador
    public Player player;

    // constructor
    public Cell (Player player){
        this.player = player;
    }

    // comprueba si no hay jugador
    public boolean isEmpty(){
        return player == null || StringUtility.isNullOrEmpty(player.value);
    }
}
