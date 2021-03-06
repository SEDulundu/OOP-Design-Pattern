package algorithm;

import vpt.Image;

/**
 * This algorithm for Edge Detection.
 * MorphoExt
 * Created by safa emre dulundu on 27.10.2016.
 */
public class MorphoInt implements Algorithm {

    /**
     * four algorithms are implemented.
     * @param originalImage original image
     * @return copy image
     */
    @Override
    public Image implementAlgorithm(Image originalImage) {

        Image copyImage = originalImage.newInstance(false);

        for(int i = 0; i < originalImage.getYDim(); i++){
            for(int j = 0; j < originalImage.getXDim(); j++){
                int num = 260;
                for(int k = i - 2; k <= i + 2; k++) {
                    for (int l = j - 2; l <= j + 2; l++) {
                        if (checkCoordinate(l, k, originalImage)) {
                            if (num >= originalImage.getXYByte(l, k))
                                num = originalImage.getXYByte(l, k);
                        }
                    }
                }
                copyImage.setXYByte(j,i, originalImage.getXYByte(j,i) - num);
            }
        }

        return copyImage;
    }

    /**
     * This is a helper function.
     * @param xCoor x axis
     * @param yCoor y axis
     * @param img original image
     * @return if coordinate is available return true, otherwise return false.
     */
    private boolean checkCoordinate(int xCoor, int yCoor, Image img){

        if( (xCoor >= 0 && yCoor >= 0) && (xCoor < img.getXDim() && yCoor < img.getYDim()))
            return true;
        else
            return false;
    }
}
