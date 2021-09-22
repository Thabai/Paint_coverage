package com.paint;

    public class Paint {
        private int id;
        private String name;
        private double price;
        private double coverage;


        public Paint(int id, String name, double price, double coverage) {
            this.id = id;
            this.price = price;
            this.coverage = coverage;
            this.name = name;
        }

        public String printPaint() {
            return this.name + " £" + this.price + " " + this.coverage + "sqm " ;
        }


        public double getPrice() {
            return this.price;
        }

        public String getName() {
            return this.name;
        }

        public double getCoverage() {
            return this.coverage;
        }
    }
