package com.paint;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double paintSqm;
        double paintPrice;
        double myArea = 0;
        double inputLength;
        double totalArea;

//        HashMap<String, String, String> capitalCities = new HashMap<String, String>();
//        capitalCities.put("England", "Ln", "Bo");
//        capitalCities.put("Germany", "Berlin", "Boo");
//        capitalCities.put("Norway", "Oslo", "Boo");
//        capitalCities.put("USA", "Washington DC", "Boo");
//        System.out.println(capitalCities.get("England"));

        Scanner PaintWantedCheck = new Scanner(System.in);
        System.out.println("Which paint would you like quoting for? (Choose 1-4)");
        Paint[] st = new Paint[4];

        st[0] = new Paint("Dulux Matt", 26.00, 10);
        st[1] = new Paint("Dulux Silk", 21.00, 18);
        st[2] = new Paint("Farrow & Ball Matt", 28.00, 15);
        st[3] = new Paint("Farrow & Ball Silk", 30.00, 25);

        for (Paint paint : st) {
            System.out.println(paint.printPaint());
        }


        switch (PaintWantedCheck.nextInt()) {
            case 1: System.out.println("You have chosen " + st[0].printPaint());
                paintSqm = st[0].coverage;
                paintPrice = st[0].price;
                break;
            case 2: System.out.println("You have chosen " + st[1].printPaint());
                paintSqm = st[1].coverage;
                paintPrice = st[1].price;
                break;
            case 3: System.out.println("You have chosen " + st[2].printPaint());
                paintSqm = st[2].coverage;
                paintPrice = st[2].price;
                break;
            case 4: System.out.println("You have chosen " + st[3].printPaint());
                paintSqm = st[3].coverage;
                paintPrice = st[3].price;
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
            double inputHeight = wallHeight.nextDouble();

            for (int i = 1; i <= 4; i++) {
                Scanner wallLengths = new Scanner(System.in);
                System.out.println("Enter length of wall number " + i);
                inputLength = wallLengths.nextDouble();
                myArea += inputLength * inputHeight;
            }
        }

        Scanner windowDoorCheck = new Scanner(System.in);
        System.out.println("Does the room have any windows or doors? (true or false)");

        if (windowDoorCheck.nextBoolean()) {
            Scanner windowDoorLength = new Scanner(System.in);
            System.out.println("What is the total length of all windows and doors?");
            Scanner windowDoorWidth = new Scanner(System.in);
            System.out.println("What is the total height of all windows and doors?");
            totalArea = windowDoorArea(myArea, windowDoorLength, windowDoorWidth);
        } else {
            totalArea = myArea;
        }

        Scanner roomPaint = new Scanner(System.in);
        System.out.println("Is this a touch-up job? (true or false)");

        if (!roomPaint.nextBoolean()) {
            totalArea *= 2;
        }

        double paintCheck= (totalArea/paintSqm);
        int paintAreaCheck = (int) Math.ceil(paintCheck);
        double costCheck = paintAreaCheck * paintPrice;
//        double usedPaint = (paintCheck % (paintSqm/ myArea));
        System.out.println("Area of room is " + totalArea + "sqm");
        System.out.println("You will need " + paintAreaCheck + " pots of 1L paint");
        System.out.println("It will cost £" + costCheck + " to complete this job");
//        System.out.println("You will use " + usedPaint + " L of paint");
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

    private static double windowDoorArea(double myArea, Scanner windowDoorLength, Scanner windowDoorWidth) {
        double totalArea;
        double emptyLength = windowDoorLength.nextDouble();
        double emptyWidth = windowDoorWidth.nextDouble();
        double emptyArea = emptyLength * emptyWidth;
        totalArea = myArea - emptyArea;
        return totalArea;
    }

}
