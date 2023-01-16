package entities;

import constants.Constants;
import de.ur.mi.oop.graphics.Circle;
import de.ur.mi.oop.graphics.Compound;
import de.ur.mi.oop.graphics.GraphicsObject;
import de.ur.mi.oop.graphics.Line;
import util.Util;

public class Entity {

    /**
     * object of class Compound which contains the objects derived of class GraphicsObject which define the shape of this object of class Entity
     */
    private Compound partsCompound;

    /**
     * Contructor for class Entity
     *
     * Please consult the documentation of the GraphicsApp Compound class:
     * https://oop-regensburg.github.io/GraphicsApp-Reborn-Library/html/classde_1_1ur_1_1mi_1_1oop_1_1graphics_1_1_compound.html
     *
     * @param x the x position of the new object of class Entity
     * @param y the y position of the new object of class Entity
     * @param parts the array of objects of class GraphicsObject containing the geometric primitives with which the new Entity is to be drawn
     */
    public Entity(float x, float y, GraphicsObject[] parts) {
        this.partsCompound = new Compound(x, y);
        for (GraphicsObject p : parts) {
            this.partsCompound.add(parts[0] instanceof Line ? (Line) p : (Circle) p);
        }
    }

    /**
     * Draws the object of class Compound which contains the objects derived from class GraphicsObject which describe the geometric primitives of which the Entity consists
     */
    public void draw() {
        partsCompound.draw();
    }


    /**
     * Rotates the object of class Compound of this object of class Entity by a given angle in degrees.
     *
     * @param angleDegrees the angle by which the object of class Compound of this object of class Entity is rotated by.
     *
     * @see Util#rotate(Compound, float) 
     */
    public void rotate(float angleDegrees) {
        Util.rotate(partsCompound, angleDegrees);
    }

    /**
     * Moves the object of class Compound of this object of class Entity by the given delta x (dx) and delta y (dy) coordinates.
     *
     * Please note: YOU have to implement handleEntityBoundsLeave() yourself!!!
     * @see Entity#handleEntityBoundsLeave()
     *
     * @param dx the amount of pixel in x direction by which the object of class compound is to be moved
     * @param dy the amount of pixel in y direction by which the object of class compound is to be moved
     *           
     * @see Util#move(Compound, float, float) 
     */
    public void move(float dx, float dy) {
        Util.move(partsCompound, dx, dy);
        handleEntityBoundsLeave(); // <--- to be added by you
    }

    /**
     * Fetch the object of class Compound of this object of class Entity
     *
     * @return the object of class Compound of this object of class Entity
     *
     * @see Entity#partsCompound
     * @see Entity#Entity(float, float, GraphicsObject[])
     */
    public Compound getPartsCompound() {
        return partsCompound;
    }

    public boolean hitTest(float x, float y) {
        return partsCompound.hitTest(x, y);
    }

    //to be implemented by you and added to move()
    // use Util.move()
    private void handleEntityBoundsLeave() {

    }
}
