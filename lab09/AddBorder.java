/**
 * AddBorder class file.
 * Written by Hydreesia.
 */
public class AddBorder extends Transformation {
    private int width;
    private RGBColor borderColor;

    public AddBorder(int width, RGBColor borderColor) {
        this.width = width;
        this.borderColor = borderColor;
    }

    /**
     * Adds a border to the inner edge of the photo
     * 
     * @return the color of the border or original color
     */
    protected RGBColor do_transform(int x, int y, RGBColor originalColor, RGBImage image) {
        if (x < width || y < width || x >= image.getWidth() - width || y >= image.getHeight() - width) {
            return borderColor;
        }
        return originalColor;
    }
}