package com.paint;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Paint[] st = new Paint[4];
        //Populating the array
        st[0] = new Paint("Dulux Matt", 26.00, 10);
        st[1] = new Paint("Dulux Silk", 21.00, 12);
        st[2] = new Paint("Farrow & Ball Matt", 28.00, 9);
        st[3] = new Paint("Farrow & Ball Silk", 30.00, 15);

                //Invoking display method on each object in the array
        for (Paint paint : st) {
            paint.printPaint();
            System.out.println(" ");
        }


        double paintSqm = 10;
        double myArea;

        Scanner roomShapeCheck = new Scanner(System.in);
        System.out.println("Do you have a standard shaped room? (true or false)");

        if (roomShapeCheck.nextBoolean()) {
            Scanner myHeight = new Scanner(System.in);
            System.out.println("Enter height of room in m");
            Scanner myLength = new Scanner(System.in);
            System.out.println("Enter length of room in m");
            Scanner myWidth = new Scanner(System.in);
            System.out.println("Enter width of room in m");
            myArea = getRegularArea(myHeight, myLength, myWidth);
        } else {
            myArea = getIrregularArea();
        }
        Scanner roomPaint = new Scanner(System.in);
        System.out.println("Is this a touch-up job? (true or false)");

        if (!roomPaint.nextBoolean()) {
            myArea *= 2;
        }
        int paintCheck = (int) Math.ceil(myArea / paintSqm);
        int remainPaint = (int) (paintCheck % (myArea / paintSqm) * 1000);
        System.out.println("Area of room is " + myArea + "sqm");
        System.out.println("You will need " + paintCheck + " pots of 1L paint");
        System.out.println("You will have " + remainPaint + " ml left");
    }

    private static double getRegularArea(Scanner myHeight, Scanner myLength, Scanner myWidth) {
        double myArea;
        double roomLength;
        double roomHeight;
        double roomWidth;
        roomHeight = myHeight.nextDouble();
        roomLength = (myLength.nextDouble() * 2) * roomHeight;
        roomWidth = (myWidth.nextDouble() * 2) * roomHeight;
        myArea = roomLength + roomWidth;
        return myArea;
    }

    private static double getIrregularArea() {
        double myArea = 0;
        Scanner wallHeight = new Scanner(System.in);
        System.out.println("Enter height of walls");
        double inputHeight = wallHeight.nextDouble();
        double inputLength;

        for (int i = 1; i <= 4; i++) {
            Scanner wallLengths = new Scanner(System.in);
            System.out.println("Enter length of wall number " + i);
            inputLength = wallLengths.nextDouble();
            myArea += inputLength * inputHeight;
        }
        return myArea;
    }

}


