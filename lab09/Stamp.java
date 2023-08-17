/**
 * Stamp class file.
 * Written by Hydreesia.
 */

public class Stamp extends Transformation {
    private RGBImage toStamp;

    public Stamp(RGBImage toStamp) {
        this.toStamp = toStamp;
    }

    /**
     * Changes the colors of the pixel to give an overlay effect on top of the
     * original image.
     * 
     * @return the new color of the pixel
     */
    protected RGBColor do_transform(int x, int y, RGBColor originalColor, RGBImage image) {
        // Scramble the color values up -- it's always a fun transformation!
        if (x < toStamp.getWidth() && y < toStamp.getHeight()) {
            int redColor;
            int blueColor;
            int greenColor;
            RGBColor toStamp = this.toStamp.getColor(x, y);
            redColor = (originalColor.getRed() + toStamp.getRed()) / 2;
            blueColor = (originalColor.getBlue() + toStamp.getBlue()) / 2;
            greenColor = (originalColor.getGreen() + toStamp.getGreen()) / 2;
            return new RGBColor(redColor, greenColor, blueColor);
        }
        return originalColor;
    }
}