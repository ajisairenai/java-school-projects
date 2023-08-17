/**
 * Brighten class file.
 * Written by Hydreesia.
 */

public class Brighten extends Transformation {
    private int amount;

    public Brighten(int amount) {
        this.amount = amount;
    }

    /**
     * Changes the image's brightness
     * 
     * @return returns new RGBColor
     */
    @Override
    protected RGBColor do_transform(int x, int y, RGBColor originalColor, RGBImage image) {
        int newRed = RGBColor.clamp(originalColor.getRed() + amount);
        int newGreen = RGBColor.clamp(originalColor.getGreen() + amount);
        int newBlue = RGBColor.clamp(originalColor.getBlue() + amount);
        return new RGBColor(newRed, newGreen, newBlue);
    }
}