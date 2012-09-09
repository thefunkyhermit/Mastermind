package com.aidangordon.mastermind.bean;

/**
 * Created by IntelliJ IDEA.
 * User: aidangordon
 * Date: 12-09-09
 * Time: 2:11 PM
 * To change this template use File | Settings | File Templates.
 */
public enum Color {
    red(1),black(2), green(3), blue(4), white(5), yellow(6);
    private final int value;


    Color(int value) {
        this.value = value;
    }



}
