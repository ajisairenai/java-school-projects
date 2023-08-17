/**
 * Greyscale class file.
 * Written by Hydreesia.
 */

public class Greyscale extends Transformation {
    /**
     * Changes the colored picture to black, grey and white
     * 
     * @return the new color of the pixel
     */
    protected RGBColor do_transform(int x, int y, RGBColor originalColor, RGBImage image) {
        int newGrey;

        newGrey = originalColor.getGreen() + originalColor.getBlue() + originalColor.getRed();
        newGrey /= 3;

        return new RGBColor(newGrey, newGrey, newGrey);
    }

}