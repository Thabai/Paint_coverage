package com.paint;

    public class Paint {
        private String name;
        public double price;
        public double coverage;

        public Paint(String name, double price, double coverage) {
            this.price = price;
            this.coverage = coverage;
            this.name = name;
        }

        public String printPaint() {
            return this.name + " £" + this.price + " " + this.coverage + "sqm " ;

        }
}
