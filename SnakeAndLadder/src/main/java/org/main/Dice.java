package org.main;

import java.util.Random;

/**
 *
 */
public class Dice {
    private int maxDiceVal;

    /**
     *
     * @param maxDiceVal Denotes the size of the Dice
     */
    public Dice(int maxDiceVal) {
        this.maxDiceVal = maxDiceVal;
    }

    public int rollDice() {
        return getRandomNumberBetween(1, maxDiceVal);
    }

    private int getRandomNumberBetween(int min, int max) throws IllegalArgumentException {
        if (max < min) {
            throw new IllegalArgumentException("Max value "+max+" should be less than min "+min);
        }
        Random r = new Random();
        return r.nextInt((max-min)+1)+min;
    }
}
