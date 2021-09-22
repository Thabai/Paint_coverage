package com.paint;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double paintSqm;
        double paintPrice;
        int wallNumber = 4;
        double myArea = 0;
        double totalArea;

        Scanner PaintWantedCheck = new Scanner(System.in);
        System.out.println("Which paint would you like quoting for? (Choose 1-4)");

        List<Paint> availablePaint = new ArrayList<>();
        availablePaint.add(new Paint(0,"Default", 26.00, 10));
        availablePaint.add(new Paint(1,"Dulux Matt", 26.00, 10));
        availablePaint.add(new Paint(2,"Dulux Silk", 21.00, 18));
        availablePaint.add(new Paint(3,"Farrow & Ball Matt", 28.00, 15));
        availablePaint.add(new Paint(4,"Farrow & Ball Silk", 30.00, 25));

        for (Paint a: availablePaint) {
            System.out.println(a.printPaint());
        }

        Paint chosenPaint = availablePaint.get(PaintWantedCheck.nextInt());
        System.out.println("You have chosen " + chosenPaint.getName());
        paintSqm = chosenPaint.getCoverage();
        paintPrice = chosenPaint.getPrice();

        Scanner roomShapeCheck = new Scanner(System.in);
        System.out.println("Do you want to paint the whole room? (true or false)");

        if (!roomShapeCheck.nextBoolean()) {
            Scanner wallNumberCheck= new Scanner(System.in);
            System.out.println("Enter number of walls");
            wallNumber = wallNumberCheck.nextInt();
            }

            Scanner wallHeight = new Scanner(System.in);
            System.out.println("Enter height of walls");
            myArea = getMyArea(wallNumber, myArea, wallHeight);

        Scanner windowDoorCheck = new Scanner(System.in);
        System.out.println("Does the room have any windows or doors? (true or false)");

        if (windowDoorCheck.nextBoolean()) {
            Scanner windowDoorLength = new Scanner(System.in);
            System.out.println("What is the total length of all windows and doors?");
            Scanner windowDoorWidth = new Scanner(System.in);
            System.out.println("What is the total width of all windows and doors?");
            totalArea = getTotalArea(myArea, windowDoorLength, windowDoorWidth);
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
        System.out.println("Area of room is " + totalArea + "sqm");
        System.out.println("You will need " + paintAreaCheck + " pots of 1L paint");
        System.out.println("It will cost £" + costCheck + " to complete this job");
    }

    private static double getMyArea(int wallNumber, double myArea, Scanner wallHeight) {
        Room room;
        room = new Room();
        room.setHeight(wallHeight.nextDouble());

        for (int i = 1; i <= wallNumber; i++) {
            Scanner wallLengths = new Scanner(System.in);
            System.out.println("Enter length of wall number " + i);
            room.setLength(wallLengths.nextDouble());
            myArea += room.getArea();
        }
        return myArea;
    }

    private static double getTotalArea(double myArea, Scanner windowDoorLength, Scanner windowDoorWidth) {
        double totalArea;
        WindowsDoors space;
        space = new WindowsDoors();
        space.setWDLength(windowDoorLength.nextDouble());
        space.setWDWidth(windowDoorWidth.nextDouble());
        totalArea = myArea - space.getWDArea();
        return totalArea;
    }


}
