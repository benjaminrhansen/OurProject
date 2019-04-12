package com.example.practicewizards;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;

import static org.junit.Assert.assertTrue;

/**
 * Could be a Singleton?
 * Class to perform several merge operations:
 * Converts images into red/blue/green versions and grayscale versions of any or all of those
 * Converts DP <=> PX. Determines which RGB channel would best work for grayscaled merge operation.
 * Most importantly, removes the background of a given selfie bitmap making the background opaque.
 */
public class Merge {
    // Tag
    private static final String TAG = "Merge.java";
    // Primary Color Constants
    private static final byte RED = 1;
    private static final byte BLUE = 2;
    private static final byte GREEN = 3;

    // A good DP fit for the width of the selfie image using avg PX to DP conversion I tested out
    private static final int FACE_WIDTH = 100;


    /**
     * Converts DP to PX given the device's resolution density per pixel.
     * @param context The given context of the device app is running on
     *                Used to get its density.
     * @param dp      The Density Independent Pixel amount to convert
     * @return        Returns dp multiplied by density amount on device
     */
    public static float convertDpToPx(Context context, float dp) {
        // Get the resources from the context containing the display metrics density amount
        return dp * context.getResources().getDisplayMetrics().density;
    }

    /**
     * Converts PX to DP given the device's resolution density per pixel.
     * Does the reverse of dp to px by doing division with the density as its divisor
     * @param context The given context of the device app is running on
     *                Used to get its density.
     * @param px      The Pixel amount to convert
     * @return        Returns px divided by density amount on device
     */
    public static float convertPxtoDp(Context context, float px) {
        // Get the resources from the context containing the display metrics density amount
        return px / context.getResources().getDisplayMetrics().density;
    }

    /**
     * Creates a red grayscale selfie bitmap. Uses the createGrayScale method after the red
     * channeled version of the selfie bitmap is created. We need a gray scaled versions of the red
     * channel of the selfie photo.
     */
    public static Bitmap createRedGrayBitmap(Bitmap source) {
        // Create bitmap to be returned from its width and height and its configuration
        Bitmap bitmap = Bitmap.createBitmap(source.getWidth(), source.getHeight(),
                source.getConfig());

        // Create ARGB variables
        // Disclude G and B, we want Red
        int alpha;
        int red;


        /*
        Loop through all the pixels and retrieve its pixel amount
         */
        for (int y = 0; y < source.getHeight(); y++) {
            for (int x = 0; x < source.getWidth(); x++) {
                // Retrieve pixel amount
                int pixel = source.getPixel(x, y);

                // Retrieves the color channels for alpha and red of the retrieved
                // pixel integer in ARGB form
                alpha = Color.alpha(pixel); // A
                red = Color.red(pixel);     // R

                // sets a pixel (x,y) on output bitmap to ARGB
                bitmap.setPixel(x, y, Color.argb(alpha, red, 0, 0));
            }
        }
        // Return the gray scaled version of the red bitmap
        return createGrayScale(bitmap);
    }

    /**
     * Creates only a red  selfie bitmap. Only retains all the red of the image
     */
    public static Bitmap createRedBitmap(Bitmap source) {
        // Create bitmap to be returned from its width and height and its configuration
        Bitmap bitmap = Bitmap.createBitmap(source.getWidth(), source.getHeight(),
                source.getConfig());

        // Create ARGB variables
        // Disclude G and B, we want Red
        int alpha;
        int red;


        /*
        Loop through all the pixels and retrieve its pixel amount
         */
        for (int y = 0; y < source.getHeight(); y++) {
            for (int x = 0; x < source.getWidth(); x++) {
                // Retrieve pixel amount
                int pixel = source.getPixel(x, y);

                // Retrieves the color channels for alpha and red of the retrieved
                // pixel integer in ARGB form
                alpha = Color.alpha(pixel); // A
                red = Color.red(pixel);     // R

                // sets a pixel (x,y) on output bitmap to ARGB
                bitmap.setPixel(x, y, Color.argb(alpha, red, 0, 0));
            }
        }
        // Return the gray scaled version of the red bitmap
        return bitmap;
    }

    /**
     * Creates a blue grayscale selfie bitmap. Uses the createGrayScale method after the blue
     * channeled version of the selfie bitmap is created. We need a gray scaled versions of the blue
     * channel of the selfie photo.
     */
    public static Bitmap createBlueGrayBitmap(Bitmap source) {
        // Create bitmap to be returned from its width and height and its configuration
        Bitmap bitmap = Bitmap.createBitmap(source.getWidth(), source.getHeight(),
                source.getConfig());

        // Create ARGB variables
        // Disclude G and B, we want Red
        int alpha;
        int blue;


        /*
        Loop through all the pixels and retrieve its pixel amount
         */
        for (int y = 0; y < source.getHeight(); y++) {
            for (int x = 0; x < source.getWidth(); x++) {
                // Retrieve pixel amount
                int pixel = source.getPixel(x, y);

                // Retrieves the color channels for alpha and red of the retrieved
                // pixel integer in ARGB form
                alpha = Color.alpha(pixel); // A
                blue = Color.red(pixel);     // R

                // sets a pixel (x,y) on output bitmap to ARGB
                bitmap.setPixel(x, y, Color.argb(alpha, 0, 0, blue));
            }
        }
        // Return the gray scaled version of the red bitmap
        return createGrayScale(bitmap);
    }

    /**
     * Creates a blue selfie bitmap. Removes all the red and green to leave only blue in the
     * image.
     */
    public static Bitmap createBlueBitmap(Bitmap source) {
        // Create bitmap to be returned from its width and height and its configuration
        Bitmap bitmap = Bitmap.createBitmap(source.getWidth(), source.getHeight(),
                source.getConfig());

        // Create ARGB variables
        // Disclude G and B, we want Red
        int alpha;
        int blue;


        /*
        Loop through all the pixels and retrieve its pixel amount
         */
        for (int y = 0; y < source.getHeight(); y++) {
            for (int x = 0; x < source.getWidth(); x++) {
                // Retrieve pixel amount
                int pixel = source.getPixel(x, y);

                // Retrieves the color channels for alpha and red of the retrieved
                // pixel integer in ARGB form
                alpha = Color.alpha(pixel); // A
                blue = Color.red(pixel);     // R

                // sets a pixel (x,y) on output bitmap to ARGB
                bitmap.setPixel(x, y, Color.argb(alpha, 0, 0, blue));
            }
        }
        // Return the gray scaled version of the red bitmap
        return bitmap;
    }

    /**
     * Creates a green grayscale selfie bitmap. Uses the createGrayScale method after the red
     * channeled version of the selfie bitmap is created. We need a gray scaled versions of the red
     * channel of the selfie photo.
     */
    public static Bitmap createGreenGrayBitmap(Bitmap source) {
        // Create bitmap to be returned from its width and height and its configuration
        Bitmap bitmap = Bitmap.createBitmap(source.getWidth(), source.getHeight(),
                source.getConfig());

        // Create ARGB variables
        // Disclude G and B, we want Red
        int alpha;
        int green;


        /*
        Loop through all the pixels and retrieve its pixel amount
         */
        for (int y = 0; y < source.getHeight(); y++) {
            for (int x = 0; x < source.getWidth(); x++) {
                // Retrieve pixel amount
                int pixel = source.getPixel(x, y);

                // Retrieves the color channels for alpha and red of the retrieved
                // pixel integer in ARGB form
                alpha = Color.alpha(pixel); // A
                green = Color.green(pixel);     // R

                // sets a pixel (x,y) on output bitmap to ARGB
                bitmap.setPixel(x, y, Color.argb(alpha, 0, green, 0));
            }
        }
        // Return the gray scaled version of the red bitmap
        return createGrayScale(bitmap);
    }

    /**
     * Creates a green grayscale selfie bitmap. Uses the createGrayScale method after the red
     * channeled version of the selfie bitmap is created. We need a gray scaled versions of the red
     * channel of the selfie photo.
     */
    public static Bitmap createGreenBitmap(Bitmap source) {
        // Create bitmap to be returned from its width and height and its configuration
        Bitmap bitmap = Bitmap.createBitmap(source.getWidth(), source.getHeight(),
                source.getConfig());

        // Create ARGB variables
        // Disclude G and B, we want Red
        int alpha;
        int green;


        /*
        Loop through all the pixels and retrieve its pixel amount
         */
        for (int y = 0; y < source.getHeight(); y++) {
            for (int x = 0; x < source.getWidth(); x++) {
                // Retrieve pixel amount
                int pixel = source.getPixel(x, y);

                // Retrieves the color channels for alpha and red of the retrieved
                // pixel integer in ARGB form
                alpha = Color.alpha(pixel); // A
                green = Color.green(pixel);     // R

                // sets a pixel (x,y) on output bitmap to ARGB
                bitmap.setPixel(x, y, Color.argb(alpha, 0, green, 0));
            }
        }
        // Return the gray scaled version of the red bitmap
        return bitmap;
    }

    /**
     * Creates an alpha grayscale selfie bitmap. Uses the createGrayScale method after the alpha
     * channeled version of the selfie bitmap is created. We need a gray scaled versions of the alpha
     * channel of the selfie photo.
     */
    public static Bitmap createAlphaGrayBitmap(Bitmap source) {
        // Create bitmap to be returned from its width and height and its configuration
        Bitmap bitmap = Bitmap.createBitmap(source.getWidth(), source.getHeight(),
                source.getConfig());

        // Create ARGB variables
        // Disclude G and B, we want Red
        int alpha;


        /*
        Loop through all the pixels and retrieve its pixel amount
         */
        for (int y = 0; y < source.getHeight(); y++) {
            for (int x = 0; x < source.getWidth(); x++) {
                // Retrieve pixel amount
                int pixel = source.getPixel(x, y);

                // Retrieves the color channels for alpha and red of the retrieved
                // pixel integer in ARGB form
                alpha = Color.alpha(pixel); // A

                // sets a pixel (x,y) on output bitmap to ARGB
                bitmap.setPixel(x, y, Color.argb(alpha, 0, 0, 0));
            }
        }
        // Return the gray scaled version of the red bitmap
        return createGrayScale(bitmap);
    }

    /**
     * Creates a grayscaled image based on the input source bitmap.
     * Uses ARGB implementation of Android's pixel storing. A = Alpha, R = Red, B = Blue, G = Green
     * Src: https://xjaphx.wordpress.com/2011/06/21/image-processing-grayscale-image-on-the-fly/
     */
    public static Bitmap createGrayScale(Bitmap source) {
        // constant factors for our algorithm. These are the correct percentages for a
        // valid grayscale
        final double PERCENT_RED   = 0.299; // 30%
        final double PERCENT_BLUE  = 0.587; // 59%
        final double PERCENT_GREEN = 0.114; // 11%

        // Create bitmap to be returned from its width and height and its configuration
        Bitmap bitmap = Bitmap.createBitmap(source.getWidth(), source.getHeight(),
                source.getConfig());

        // Create ARGB variables
        int alpha;
        int red;
        int blue;
        int green;

        // Integer representing the current pixel ARGB (actually in hex, AARRGGBB)
        // Example. Pure red is #FFFF0000. Green is #FF00FF00. Blue is #FF0000FF with always
        // #FF for the alpha because we want completely opaque color, not transparent as int
        // #00.
        int pixel; // One given pixel of the source bitmap

        /*
         * Loop through all the pixels of the source bitmap and scale their pixels to grayscale
         * Loops through all X (width) and Y (height) pixels up to the actual width and height
         * Do pre-increment for speed
         */
        for (int x = 0; x < source.getWidth(); ++x)
            for (int y = 0; y < source.getHeight(); ++y) {
                // Get current pixel
                pixel = source.getPixel(x, y); // retrieves the (x, y) pixel from the bitmap

                // Retrieves the color channels for alpha, red, green, and blue of the retrieved
                // pixel integer in ARGB form
                alpha = Color.alpha(pixel); // A maintain alpha pixel
                red = Color.red(pixel);     // R
                blue = Color.blue(pixel);   // B
                green = Color.green(pixel); // G

                // Ramp up conversion to single value
                // Making red blue and green parts all the same number creates
                // a shade of gray, instead of leaning to a particular hue
                red = blue = green = (int)(PERCENT_RED * red +
                        PERCENT_BLUE * blue +
                        PERCENT_GREEN + green);

                // sets a pixel (x,y) on output bitmap to ARGB
                bitmap.setPixel(x, y, Color.argb(alpha, red, green, blue));

            }
        return bitmap;
    }

    /**
     * Determines the most appropriate primary color gray scale to choose from so
     * remove background function is more accurate. If a blue gray scaled image is
     * the lightest of them all, then we will return BLUE.
     * @param source is the bitmap to be compared and find the lightest gray scale for it
     * @return we return a byte, -128 to 127 values, to simply return what primary color is best:
     * 1 - Red, 2 - Blue, 3 - Green
     */
    byte determineBestGrayScale(Bitmap source) {
        return 1;
    }

    /**
     * Computes the sum of the GRAY SCALE pixel amount of the 4 points near the image corners
     * and general face area 50 points of the bitmap and returns the sum.
     * Total Pixels Compared: 54.
     * Max Possible Sum Total: 13770
     * Important: this function relies on the use of the 4 points and 50 points near the face.
     * @param RGB_CHANNEL the byte number (1,2,3) representing what gray scale sum to compute
     * @param bitmap the bitmap to compute the 54 pixel points from
     * @return an integer sum representing the amount of a given RGB channel found at the 4 points
     * and line through face
     */
    int computeGrayScaleSum(final byte RGB_CHANNEL, final Bitmap bitmap) {
        // Constant factors for our algorithm. These are the correct percentages for a
        // valid grayscale. To be defined below...
        assertTrue(RGB_CHANNEL > 0 && RGB_CHANNEL <= 3); // Make sure not given bad num

        // Sum of Pixel Points Found at 54 points given the bitmap
        int sum = 0;

        // Switch the RGB Channel to determine which operation to do
        switch (RGB_CHANNEL) {
            // RED
            case 1: {
                // How much red we need to take out (or will remain left)
                // to get grayscale version of red
                final double PERCENT_RED   = 0.299; // 30%


            }
            // BLUE
            case 2: {
                // How much blue we need to take out (or will remain left)
                // to get grayscale version of blue
                final double PERCENT_BLUE  = 0.587; // 59%

            }
            // GREEN
            case 3: {
                // How much green we need to take out (or will remain left)
                // to get grayscale version of green
                final double PERCENT_GREEN = 0.114; // 11%

            }
        }
        return sum;
    }



}
