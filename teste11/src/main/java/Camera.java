import java.awt.AWTException;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;

/**
 * A Camera class that captures screenshots of the entire screen.
 */
public class Camera {
    private int width;
    private int height;
    private Robot robot; // Create a Robot instance once in the constructor

    /**
     * Creates a new Camera instance with the specified width and height.
     * 
     * @param width  the width of the screenshot
     * @param height the height of the screenshot
     */
    public Camera(int width, int height) {
        this.width = width;
        this.height = height;
        try {
            robot = new Robot(); // Create a Robot instance
        } catch (AWTException e) {
            throw new RuntimeException("Error creating Robot instance", e);
        }
    }

    /**
     * Captures a screenshot of the entire screen and returns it as a BufferedImage.
     * 
     * @return the captured screenshot
     */
    public BufferedImage captureImage() {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        try {
            graphics.drawImage(robot.createScreenCapture(new Rectangle(0, 0, width, height)), 0, 0, null);
        }catch (Exception e) {
            // Handle other exceptions
            System.err.println("Error capturing image: " + e.getMessage());
            return new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); // Return a black image
        }
        // Handle AWTException specifically
        // Return a black image
         finally {
            graphics.dispose();
        }
        return image;
    }

    /**
     * Releases any system resources held by the Robot instance.
     */
    public void close() {
        robot = null; // Release the Robot instance
    }
}