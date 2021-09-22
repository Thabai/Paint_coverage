package com.paint;

public class WindowsDoors {
    private double length;
    private double width;

    public void setWDLength(double length) {
        this.length = length;
    }

    public void setWDWidth(double width) {
        this.width = width;
    }

    public double getWDArea() {
        return this.length * this.width;
    }
}
