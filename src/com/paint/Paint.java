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

        public String printPaint() {
            return this.name + " £" + this.price + " " + this.coverage + "sqm " ;
        }

        public double setCoverage() {
            return this.coverage;
        }

        public double setPrice() {
            return this.price;
        }
}
