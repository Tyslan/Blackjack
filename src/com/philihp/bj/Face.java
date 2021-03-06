package com.philihp.bj;

public enum Face {

    _2(2),
    _3(3),
    _4(4),
    _5(5),
    _6(6),
    _7(7),
    _8(8),
    _9(9),
    _T(10),
    _J(10),
    _Q(10),
    _K(10),
    _A(11);

    private int value;

    private Face(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public String toString() {
        return this.name().substring(1);
    }

    public int getTableOrdinal() {
        return this.getValue() - 2;
    }
}
