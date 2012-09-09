package com.aidangordon.mastermind.bean;

public class Code {

    @Override
    public String toString() {
        return
                "(" + column1 +
                ", " + column2 +
                ", " + column3 +
                ", " + column4 + ")";
    }

    private final Color column1;
    private final Color column2;
    private final Color column3;
    private final Color column4;

    public Code(Color column1, Color column2, Color column3, Color column4) {
        this.column1 = column1;
        this.column2 = column2;
        this.column3 = column3;
        this.column4 = column4;
    }


    public Color getColumn1() {
        return column1;
    }

    public Color getColumn2() {
        return column2;
    }

    public Color getColumn3() {
        return column3;
    }

    public Color getColumn4() {
        return column4;
    }
}
