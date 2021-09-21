package com.paint;

import java.util.Scanner;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        int paintSqm;
        double myArea;

        Scanner PaintWantedCheck = new Scanner(System.in);
        System.out.println("Which paint would you like quoting for? Choose 1-4");
        Paint[] st = new Paint[4];

        st[0] = new Paint("Dulux Matt", 26.00);
        st[1] = new Paint("Dulux Silk", 21.00);
        st[2] = new Paint("Farrow & Ball Matt", 28.00);
        st[3] = new Paint("Farrow & Ball Silk", 30.00);

        for (Paint paint : st) {
            System.out.println(paint.printPaint());
        }


        switch (PaintWantedCheck.nextInt()) {
            case 1: System.out.println("You have chosen " + st[0].printPaint());
                paintSqm = 10;
                break;
            case 2: System.out.println("You have chosen " + st[1].printPaint());
                paintSqm = 12;
                break;
            case 3: System.out.println("You have chosen " + st[2].printPaint());
                paintSqm = 9;
                break;
            case 4: System.out.println("You have chosen " + st[3].printPaint());
            paintSqm = 15;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + PaintWantedCheck.nextInt());
        }

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
            Scanner wallHeight = new Scanner(System.in);
            System.out.println("Enter height of walls");
            myArea = getIrregularArea(wallHeight);
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

    private static double getIrregularArea(Scanner wallHeight) {
        double myArea = 0;
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


