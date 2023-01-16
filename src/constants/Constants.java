package constants;

import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.colors.Colors;
import de.ur.mi.oop.graphics.Line;

public class Constants {
    public static final int CANVAS_HEIGHT = 800;
    public static final int CANVAS_WIDTH = 800;
    public static final int FRAMERATE = 60;

    public static final int MIN_SPAWN_DISTANCE_ASTEROID = 300; // px
    public static final Color BACKGROUND_COLOR = Colors.BLACK;

    public static final int MAX_NUM_ASTEROIDS = 10;

    public static final int ASTEROID_SPAWN_RATE = Constants.FRAMERATE * 1; // 1 second

    public static final Line[] SHIP_PARTS = new Line[] {
        new Line(0 + CANVAS_WIDTH / 2, 0 + CANVAS_HEIGHT / 2, 12 + CANVAS_WIDTH / 2, 18 + CANVAS_HEIGHT / 2, Colors.WHITE),
        new Line(12 + CANVAS_WIDTH / 2, 18 + CANVAS_HEIGHT / 2, 12 + CANVAS_WIDTH / 2, 8 + CANVAS_HEIGHT / 2, Colors.WHITE),
        new Line(12 + CANVAS_WIDTH / 2, 8 + CANVAS_HEIGHT / 2, 22 + CANVAS_WIDTH / 2, 8 + CANVAS_HEIGHT / 2, Colors.WHITE),
        new Line(22 + CANVAS_WIDTH / 2, 8 + CANVAS_HEIGHT / 2, 0 + CANVAS_WIDTH / 2, 0 + CANVAS_HEIGHT / 2, Colors.WHITE)
    };

    public static final Line[] BIG_ASTEROID_PARTS = new Line[] {
        new Line(66, 1, 57, 4, Colors.WHITE),
        new Line(57, 4, 49, 2, Colors.WHITE),
        new Line(49, 2, 34, 5, Colors.WHITE),
        new Line(34, 5, 26, 11, Colors.WHITE),
        new Line(26, 11, 22, 23, Colors.WHITE),
        new Line(22, 23, 22, 34, Colors.WHITE),
        new Line(22, 34, 11, 36, Colors.WHITE),
        new Line(11, 36, 3, 44, Colors.WHITE),
        new Line(3, 44, 1, 54, Colors.WHITE),
        new Line(1, 54, 4, 64, Colors.WHITE),
        new Line(4, 64, 1, 70, Colors.WHITE),
        new Line(1, 70, 4, 78, Colors.WHITE),
        new Line(4, 78, 12, 79, Colors.WHITE),
        new Line(12, 79, 16, 89, Colors.WHITE),
        new Line(16, 89, 21, 93, Colors.WHITE),
        new Line(21, 93, 22, 103, Colors.WHITE),
        new Line(22, 103, 33, 113, Colors.WHITE),
        new Line(33, 113, 39, 119, Colors.WHITE),
        new Line(39, 119, 52, 126, Colors.WHITE),
        new Line(52, 126, 57, 136, Colors.WHITE),
        new Line(57, 136, 68, 137, Colors.WHITE),
        new Line(68, 137, 73, 150, Colors.WHITE),
        new Line(73, 150, 83, 155, Colors.WHITE),
        new Line(83, 155, 97, 155, Colors.WHITE),
        new Line(97, 155, 104, 150, Colors.WHITE),
        new Line(104, 150, 111, 153, Colors.WHITE),
        new Line(111, 153, 120, 147, Colors.WHITE),
        new Line(120, 147, 120, 139, Colors.WHITE),
        new Line(120, 139, 134, 135, Colors.WHITE),
        new Line(134, 135, 141, 124, Colors.WHITE),
        new Line(141, 124, 140, 108, Colors.WHITE),
        new Line(140, 108, 131, 100, Colors.WHITE),
        new Line(131, 100, 131, 92, Colors.WHITE),
        new Line(131, 92, 125, 86, Colors.WHITE),
        new Line(125, 86, 127, 76, Colors.WHITE),
        new Line(127, 76, 124, 65, Colors.WHITE),
        new Line(124, 65, 128, 53, Colors.WHITE),
        new Line(128, 53, 123, 40, Colors.WHITE),
        new Line(123, 40, 116, 36, Colors.WHITE),
        new Line(116, 36, 113, 30, Colors.WHITE),
        new Line(113, 30, 105, 27, Colors.WHITE),
        new Line(105, 27, 102, 29, Colors.WHITE),
        new Line(102, 29, 94, 18, Colors.WHITE),
        new Line(94, 18, 84, 15, Colors.WHITE),
        new Line(84, 15, 79, 15, Colors.WHITE),
        new Line(79, 15, 75, 4, Colors.WHITE),
        new Line(75, 4, 66, 1, Colors.WHITE)
    };

    public static final Line[] SMALL_ASTERIODS_PARTS = new Line[] {
            new Line(10.f, 0.0f, 5, 2, Colors.WHITE),
            new Line(5, 2, 1, 6, Colors.WHITE),
            new Line(1, 6, 0, 11, Colors.WHITE),
            new Line(0, 11, 3, 16, Colors.WHITE),
            new Line(3, 16, 8, 19, Colors.WHITE),
            new Line(8, 19, 9, 22, Colors.WHITE),
            new Line(9, 22, 11, 24, Colors.WHITE),
            new Line(11, 24, 15, 25, Colors.WHITE),
            new Line(15, 25, 17, 23, Colors.WHITE),
            new Line(17, 23, 20, 26, Colors.WHITE),
            new Line(20, 26, 23, 27, Colors.WHITE),
            new Line(23, 27, 28, 26, Colors.WHITE),
            new Line(28, 26, 30, 23, Colors.WHITE),
            new Line(30, 23, 31, 19, Colors.WHITE),
            new Line(31, 19, 30, 16, Colors.WHITE),
            new Line(30, 16, 32, 14, Colors.WHITE),
            new Line(30, 16, 32, 14, Colors.WHITE),
            new Line(32, 14, 31, 10, Colors.WHITE),
            new Line(31, 10, 29, 8, Colors.WHITE),
            new Line(29, 8, 26, 7, Colors.WHITE),
            new Line(26, 7, 24, 4, Colors.WHITE),
            new Line(24, 4, 21, 2, Colors.WHITE),
            new Line(21, 2, 19, 2, Colors.WHITE),
            new Line(19, 2, 10, 0, Colors.WHITE),
    };
    public static final int AMOUNT_POINTS_BIG_ASTEROID = 50;
    public static final int AMOUNT_POINTS_SMALL_ASTEROID = 150;
}
