package com.aidangordon.mastermind.service

import com.aidangordon.mastermind.bean.Code
import com.aidangordon.mastermind.bean.GuessResult
import com.aidangordon.mastermind.bean.Color

class Game {
    public static void main(String[] args) {
        Game game = new Game()
        game.play()


    }

    private  play() {
        Code secretCode = generateRandomSecretCode()
        Engine engine = new Engine(secretCode)
        int tries = 0
        System.in.withReader {
            while (true) {
                tries++
                println('Please make a guess; ')
                def column1
                boolean gotANumber = false;
                while (!gotANumber) {
                    print('Column 1: ')
                    try {
                        column1 = getColorFromInt(new Integer(it.readLine()))
                        println column1
                        gotANumber = true
                    } catch (NumberFormatException nfe) {
                        println 'Please ensure you put a real number between 1 and 6.'
                    }
                }

                gotANumber = false
                def column2
                while (!gotANumber) {
                    try {
                        print('Column 2: ')
                        column2 = getColorFromInt(new Integer(it.readLine()))
                        println column2
                        gotANumber = true
                    } catch (NumberFormatException nfe) {
                        println 'Please ensure you put a real number between 1 and 6.'

                    }
                }

                gotANumber = false
                def column3
                while (!gotANumber) {
                    try {
                        print('Column 3: ')
                        column3 = getColorFromInt(new Integer(it.readLine()))
                        println column3
                        gotANumber = true
                    } catch (NumberFormatException nfe) {
                        println 'Please ensure you put a real number between 1 and 6.'

                    }
                }

                gotANumber = false
                def column4
                while (!gotANumber) {
                    try {
                        print('Column 4: ')
                        column4 = getColorFromInt(new Integer(it.readLine()))
                        println column4
                        gotANumber = true
                    } catch (NumberFormatException nfe) {
                        println 'Please ensure you put a real number between 1 and 6.'

                    }
                }


                Code userGuess = new Code(column1, column2, column3, column4)
                GuessResult guessResult = engine.getResults(userGuess)
                if (guessResult.isSolved()) {
                    println 'By george, you got it!'
                    println 'Only took you ' + tries + ' tries!'
                    System.exit(0)
                } else {
                    println 'You guessed '+ userGuess + ' and had ' + guessResult.getNumberOfWhite() + ' whites and  ' + guessResult.getNumberOfBlack() + ' blacks'
                    println 'Try again?'

                    if (it.readLine().equals("N")) {
                        println('The Secret Code was: ' + secretCode)
                        System.exit(0)
                    }
                }

            }
        }
    }

    private  Code generateRandomSecretCode() {
        Code secretCode = new Code(generateRandomColor(), generateRandomColor(), generateRandomColor(), generateRandomColor())
        return secretCode
    }

    private  Color generateRandomColor() {

        int value = new Long(Math.round(Math.random() * 6)).intValue()
        Color randomColor = getColorFromInt(value)
        return randomColor
    }

    private Color getColorFromInt(int value) {
        Color randomColor = null;
        switch (value) {
            case 1:
                randomColor = Color.red;
                break;
            case 2:
                randomColor = Color.black;
                break;
            case 3:
                randomColor = Color.green;;
                break;
            case 4:
                randomColor = Color.blue;
                break;
            case 5:
                randomColor = Color.white;
                break;
            case 6:
                randomColor = Color.yellow;
                break;
        }
        return randomColor;
    }


}
