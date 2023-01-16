import constants.Constants;
import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.colors.Colors;
import de.ur.mi.oop.launcher.GraphicsAppLauncher;

public class AsteroidsApp extends GraphicsApp {

    @Override
    public void initialize() {
        setupCanvas();

    }

    private void setupCanvas() {
        setCanvasSize(Constants.CANVAS_WIDTH, Constants.CANVAS_HEIGHT);
        drawBackground(Colors.WHITE);
        setFrameRate(Constants.FRAMERATE);
    }

    @Override
    public void draw() {

    }

    public static void main(String[] args) {
        GraphicsAppLauncher.launch();
    }
}