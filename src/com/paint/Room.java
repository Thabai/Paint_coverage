package com.paint;

public class Room {
        private double length;
        private double height;

    public void setLength(double length) {
        this.length = length;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return this.length * this.height;
    }
}


