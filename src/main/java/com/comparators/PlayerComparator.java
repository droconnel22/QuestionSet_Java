package com.comparators;

import java.util.Comparator;

public class PlayerComparator implements Comparator<Player> {

    @Override
    public int compare(Player player, Player other) {

        // Returns a positive integer as the first argument greater than
        if(player.score > other.score){
            return  -1;
        }
        // Returns a negative integer the first argument is less than
        else if(player.score < other.score){
            return  1;
        }
        else
        {
            return  player.name.compareTo(other.name);
        }

    }
}
