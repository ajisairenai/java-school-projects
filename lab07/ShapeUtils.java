/*
 * CSCI 1913
 * 
 * Written by Hydreesia
 */

import java.lang.Math;
import java.util.Random;

public class ShapeUtils {

    /**
     * Finds the distance between two points
     * @param p1 -- a non-null point
     * @param p2 -- a non-null point
     */
    public static double distance(Point p1, Point p2) {
        double distance = Math.sqrt(Math.pow((p1.getX() - p2.getX()), 2) + Math.pow((p1.getY() - p2.getY()), 2));
        return distance;
    }

    /**
     * Finds the center of a list of points 
     * @param points -- an array of Point objects
     */
    public static Point getCenter(Point[] points) {
        if (points.length == 0) {
            return new Point(0.0, 0.0);
        }
        else {
            double totalX = 0;
            double totalY = 0;

            for  (int i = 0; i < points.length; i++) {
                totalX += points[i].getX();
                totalY += points[i].getY();
            }

            return new Point(totalX / points.length, totalY / points.length);
        }
    }

    /**
     * Get area of a circle 
     * @param c -- a Circle object
     */
    public static double getArea(Circle c) {
        double area = Math.PI * Math.pow(c.getRadius(), 2);
        return area;
    }

    /**
     * Get area of a ring
     * @param c -- a Ring object
     */
    public static double getArea(Ring c) {
        double rad2 = c.getInnerCircle().getRadius();
        double rad1 = c.getThickness() + rad2;

        double area = (Math.PI * Math.pow(rad1, 2)) - (Math.PI * Math.pow(rad2, 2));
        
        return area;
    }

    /**
     * Checks to see if a point is inside a circle
     * @param c -- a Circle object
     * @param p -- a non-null point
     */
    public static boolean isIn(Circle c, Point p) {
        double distance = distance(c.getCenter(), p);
        double radius = c.getRadius(); 

        if (distance <= radius) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Generates a random coordinate on a ring
     * @param c -- a Ring object
     */
    public Point randRingCoord(Ring c) {
        Random rand = new Random();

        double angle = rand.nextDouble() * 2 * Math.PI;
        double randThick = (double)rand.nextInt((int)c.getThickness());

        double x = c.getInnerCircle().getCenter().getX() + ((c.getInnerCircle().getRadius() - randThick)  * Math.cos(angle));
        double y = c.getInnerCircle().getCenter().getY() + ((c.getInnerCircle().getRadius() - randThick) * Math.sin(angle));

        return new Point(x, y);
    }
}
