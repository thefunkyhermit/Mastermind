package com.aidangordon.mastermind.service;

import com.aidangordon.mastermind.bean.Code;
import com.aidangordon.mastermind.bean.Color;
import com.aidangordon.mastermind.bean.GuessResult;

public class Engine {


    private final Code secretCode;

    public Engine(Code secretCode) {
        this.secretCode = secretCode;
    }

    public GuessResult getResults(Code code) {
        Integer numBlacks = 0;
        Integer numWhites = 0;
        Color firstGuessColumn = code.getColumn1();
        if (firstGuessColumn.equals(secretCode.getColumn1())) {
            numBlacks++;
        } else if (firstGuessColumn.equals(secretCode.getColumn2()) || firstGuessColumn.equals(secretCode.getColumn3()) || firstGuessColumn.equals(secretCode.getColumn4())) {
            numWhites++;
        }
        
        Color secondGuessColumn = code.getColumn2();
        if(secondGuessColumn.equals(secretCode.getColumn2())){
            numBlacks++;
        }else if(secondGuessColumn.equals(secretCode.getColumn1()) || secondGuessColumn.equals(secretCode.getColumn3()) || secondGuessColumn.equals(secretCode.getColumn4())){
            numWhites++;
        }
        
        Color thirdGuessColumn = code.getColumn3();
        if(thirdGuessColumn.equals(secretCode.getColumn3())){
            numBlacks++;
        }else if(thirdGuessColumn.equals(secretCode.getColumn1()) || thirdGuessColumn.equals(secretCode.getColumn2()) || thirdGuessColumn.equals(secretCode.getColumn4())){
            numWhites++;
        }

        Color fourthGuessColumn = code.getColumn4();
        if(fourthGuessColumn.equals(secretCode.getColumn4())){
            numBlacks++;
        }else if(fourthGuessColumn.equals(secretCode.getColumn1())|| fourthGuessColumn.equals(secretCode.getColumn2()) || fourthGuessColumn.equals(secretCode.getColumn3())){
            numWhites++;
        }
        return new GuessResult(numWhites, numBlacks);
    }
}
