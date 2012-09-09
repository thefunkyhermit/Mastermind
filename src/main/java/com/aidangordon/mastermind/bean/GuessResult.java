package com.aidangordon.mastermind.bean;


public class GuessResult {

    private final Integer numberOfWhite;
    private final Integer numberOfBlack;

    public GuessResult(Integer numberOfWhite, Integer numberOfBlack) {
        this.numberOfWhite = numberOfWhite;
        this.numberOfBlack = numberOfBlack;
    }

    @Override
    public String toString() {
        return "GuessResult{" +
                "numberOfWhite=" + numberOfWhite +
                ", numberOfBlack=" + numberOfBlack +
                '}';
    }

    public Integer getNumberOfBlack() {
        return numberOfBlack;
    }

    public Integer getNumberOfWhite() {
        return numberOfWhite;
    }
    
    public Boolean isSolved(){
        boolean result = false;
        if(numberOfBlack.equals(new Integer(4))){
            result = true;
        }
        return result;
    }
}
