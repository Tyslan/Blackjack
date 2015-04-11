/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.philihp.bj;

/**
 *
 * @author Lorenz
 */
public class SimulationRunResult {
    private long payout;
    private double houseEdge;
    private int numberOfMistakes;

    public SimulationRunResult(long payout, double houseEdge, int numberOfMistakes) {
        this.payout = payout;
        this.houseEdge = houseEdge;
        this.numberOfMistakes = numberOfMistakes;
    }

    public long getPayout() {
        return payout;
    }

    public double getHouseEdge() {
        return houseEdge;
    }

    public int getNumberOfMistakes() {
        return numberOfMistakes;
    }
}
