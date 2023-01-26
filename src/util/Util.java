package util;

import de.ur.mi.oop.graphics.*;
import entities.Entity;
import entities.Ship;

import static java.lang.Math.min;

public class Util {

    /**
     * Rotates a given object of class Compound which consists of objects of class Line by an angle in degrees
     * Therefore, this method is intended to be used for asteroids and the ship.
     * Therefore, this method is accessible via the method rotate() of Entity class
     * @see entities.Entity#rotate(float) 
     *
     * @param c the Compound object which contains the objects of class Line which define the geometry of the compound
     * @param angle the angle in degrees by which the given compound is to be rotated by.
     */
    public static void rotate(Compound c, float angle) {
        if(c.size() > 0) {
            if(c.get(0) instanceof Line) {
                Line[] lines = new Line[c.size()];

                float minX = 99999999;
                float minY = 99999999;

                float x = 0;
                float y = 0;

                for(int i = 0; i < c.size(); i++) {
                    Line l = (Line) c.get(i);
                    x += l.getXPos();
                    y += l.getYPos();
                }

                x /= c.size();
                y /= c.size();

                Point center = new Point(x, y);

                for (int i = c.size() - 1; i >= 0; i--) {
                    float[] coordinates = computeRotationCoordinates((Line) c.get(i), angle, center);

                    minX = min(minX, coordinates[0]);
                    minX = min(minX, coordinates[2]);
                    minY = min(minY, coordinates[3]);
                    minY = min(minY, coordinates[1]);

                    lines[i] = new Line(coordinates[0], coordinates[1], coordinates[2], coordinates[3], c.get(i).getColor());
                    c.remove(i);
                }
                adjustTargetCompound(c, minX, minY, lines);
            }
        }
    }

    /**
     * Computes the position of a given ship's tip (also known as its gun)
     *
     * @param ship an object of class Ship (which is to be implemented by YOU) of which the gun or the tip of the ship's geometry (somewhat triangular) is to be adjusted based on a given rotation angle in degrees
     * @param angleDegrees the angle in degrees by which the gun or the tip of the ship's geometry (somewhat triangular) is to be rotated by.
     *
     * @return a new object of class Point which represents the x and y coordinates of the ship's tip or gun after the rotation by angleDegrees
     */
    public static Point rotateShipGun(Ship ship, float angleDegrees) {
        Point shipGunPosition = new Point(((Line)ship.getPartsCompound().get(0)).getStartpointX(), ship.getPartsCompound().get(0).getYPos());

        float a = 0;
        float b = 0;

        for(int i = 0; i < ship.getPartsCompound().size(); i++) {
            Line l = (Line) ship.getPartsCompound().get(i);
            a += l.getStartpointX();
            b += l.getStartpointY();
        }

        a /= ship.getPartsCompound().size();
        b /= ship.getPartsCompound().size();

        Point center = new Point(a, b);

        float x = shipGunPosition.getXPos();
        float y =  shipGunPosition.getYPos();

        float newStartX = rotateX(x, center.getXPos(), y, center.getYPos(), angleDegrees);
        float newStartY = rotateY(x, center.getXPos(), y, center.getYPos(), angleDegrees);

        return new Point(newStartX - center.getXPos(), newStartY - center.getYPos());
    }

    /**
     * Moves a given object of class Compound based on given delta x (dy) and delta y (dy) coordinates
     *
     * This class is intended for use with any object of class compound which is required by the description of this Studienleistung.
     * Therefore, it is intended for use with Asteroids (uses Compound with Line), Ship (also uses Compound with Line) and the bullets wich the object of Ship can fire (Compound of a single Circle)
     *
     * Therefore, this method is accessible via a method move() in Entity class.
     * @see entities.Entity#move(float, float)
     *
     * @param c the object of class Compound to be moved by delta x and delta y
     * @param dx the amount of pixel in x direction by which the object of class compound is to be moved
     * @param dy the amount of pixel in y direction by which the object of class compound is to be moved
     */
    public static void move(Compound c, float dx, float dy) {
        if(c.size() > 0) {
            if (c.get(0) instanceof Line) {
                moveLines(c, dx, dy);
            }

            if(c.get(0) instanceof Circle) {
                moveCircles(c, dx, dy);
            }
        }
    }

    /**
     * Computes the distance in pixels between the coordinates of two entities which are present in the game world.
     * The coordinates of each entity are represented as floats.
     * x1, y1 represent the coordinates of one entity.
     * x2, y2 represents the coordinates of the other entity.
     * 
     * This method is overloaded.
     *      
     * @see Util#distance(float, float, Entity)
     * @see Util#distance(Entity, Entity)
     *
     * @param x1 the x-coordinate of one entity of which the distance to another entity is to be computed
     * @param y1 the y-coordinate of one entity of which the distance to another entity is to be computed
     * @param x2 the x-coordinate of the other entity of which the distance to an entity is to be computed
     * @param y2 the y-coordinate of the other entity of which the distance to an entity is to be computed
     *
     * @return the distance in pixels of the coordinate pairs of two entities as a float
     */
    public static float distance(float x1, float y1, float x2, float y2) {
        return (float) Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

    /**
     * Computes the distance in pixels between the given coordinates of an entity and another given entity.
     * Both entities are present in the game world.
     * This method is overloaded.
     *
     * @see Util#distance(float, float, float, float)
     * @see Util#distance(Entity, Entity)
     *
     * @param x1 the x-coordinate of an entity of which the distance to another given entity is to be computed
     * @param y1 the y-coordinate of an entity of which the distance to another given entity is to be computed
     * @param a another entity from which the distance to an entity which is represented by a coordinate pair is to be computed
     *
     * @return the distance in pixels of the coordinate pairs of two entities as a float
     */
    public static float distance(float x1, float y1, Entity a) {
        return distance(x1, y1, a.getPartsCompound().getXPos(), a.getPartsCompound().getYPos());
    }

    /**
     * Computes the distance in pixels between two given entities.
     * This method is overloaded.
     *
     * @see Util#distance(float, float, float, float)
     * @see Util#distance(float, float, Entity) 
     *
     * @param a a given entity from which the distance to another entity "b" is to be computed
     * @param b a given entity from which the distance to another entity "a" is to be computed
     *
     * @return the distance in pixels of the coordinate pairs of two entities as a float
     */
    public static float distance(Entity a, Entity b) {
        return distance(a.getPartsCompound().getXPos(), a.getPartsCompound().getYPos(), b.getPartsCompound().getXPos(), b.getPartsCompound().getYPos());
    }

    private static void moveLines(Compound c, float dx, float dy) {
        float minX = 99999999;
        float minY = 99999999;

        Line[] lines = new Line[c.size()];

        for (int i = c.size() - 1; i >= 0; i--) {
            Line l = (Line) c.get(i);

            minX = min(minX, l.getStartpointX());
            minX = min(minX, l.getEndpointX());
            minY = min(minY, l.getStartpointY());
            minY = min(minY, l.getEndpointY());
            lines[i] = new Line(l.getStartpointX() + dx, l.getStartpointY() + dy, l.getEndpointX() + dx, l.getEndpointY() + dy, l.getColor());
            c.remove(i);
        }

        c.setPosition(minX, minY);

        for (Line l : lines)
            c.add(l);
    }

    private static void moveCircles(Compound c, float dx, float dy) {
        c.move(dx, dy);
    }

    private static void adjustTargetCompound(Compound c, float minX, float minY, Line[] lines) {
        c.setPosition(minX, minY);

        for(Line l: lines)
            c.add(l);
    }

    private static float[] computeRotationCoordinates(Line l, float angle, Point center) {
        float startX = l.getStartpointX();
        float startY = l.getStartpointY();
        float endX = l.getEndpointX();
        float endY = l.getEndpointY();

        float newStartX = rotateX(startX, center.getXPos(), startY, center.getYPos(), angle);
        float newStartY = rotateY(startX, center.getXPos(), startY, center.getYPos(), angle);
        float newEndX = rotateX(endX, center.getXPos(), endY, center.getYPos(), angle);
        float newEndY = rotateY(endX, center.getXPos(), endY, center.getYPos(), angle);

        return new float[] {newStartX, newStartY, newEndX, newEndY};
    }

    private static float rotateX(float x1, float x2, float y1, float y2, float angle) {
        return (float) ((x1 - x2) * Math.cos(angle) + (y1 - y2) * Math.sin(angle)) + x2;
    }

    private static float rotateY(float x1, float x2, float y1, float y2, float angle) {
        return (float) ((-(x1 - x2) * Math.sin(angle) + (y1 - y2) * Math.cos(angle)) + y2);
    }
}
