package com.paint;

    public class Paint {
        private String name;
        private double price;
        private double coverage;

        public Paint(String name, double price, double coverage) {
            this.price = price;
            this.coverage = coverage;
            this.name = name;
        }

        public void printPaint() {
            System.out.println(this.name + " £" + this.price + " " + this.coverage + "sqm ");
        }
}
