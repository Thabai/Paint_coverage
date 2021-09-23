package com.paint;

public class Room {
        private double length;
        private double height;
        private int wallNumber;

    public Room() {
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWallNumber(int wallNumber) { this.wallNumber = wallNumber; }

    public double getArea() {
        return this.length * this.height;
    }

    public double getAreaForTest() {
        return this.wallNumber * this.length * this.height;
    }
}


