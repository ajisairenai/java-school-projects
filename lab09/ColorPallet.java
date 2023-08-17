/**
 * ColorPallet class file.
 * Written by Hydreesia.
 */

public class ColorPallet extends Transformation {
    private RGBColor[] pallet;

    public ColorPallet(RGBColor[] pallet) {
        this.pallet = pallet;
    }

    /**
     * Changes the color pallet of the image
     * 
     * @return the new color of the pixel
     */
    @Override
    protected RGBColor do_transform(int x, int y, RGBColor originalColor, RGBImage image) {
        RGBColor newColor = pallet[0];

        for (int i = 0; i < pallet.length; i++) {
            if (RGBColor.distance(pallet[i], originalColor) < RGBColor.distance(newColor, originalColor)) {
                newColor = pallet[i];
            }
        }
        return newColor;
    }
}