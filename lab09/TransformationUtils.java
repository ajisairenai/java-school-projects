/**
 * TransformationUtils class file.
 * Written by Hydreesia.
 */

public class TransformationUtils {
    /**
     * Performs multiple transform functions on an image
     * 
     * @param transformations -- an array of transformations to perform
     * @param inptFle         -- name of the input file
     * @param otpFle          -- name of the output file
     */
    public static void transformMany(Transformation[] transformations, String inptFle, String otpFle) {
        RGBImage img = RGBImageUtil.load(inptFle);

        for (Transformation t : transformations) {
            img = t.transform(img);
        }
        RGBImageUtil.saveImage(img, otpFle);
    }
}
