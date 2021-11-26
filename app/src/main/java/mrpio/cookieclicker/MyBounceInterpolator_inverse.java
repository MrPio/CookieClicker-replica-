package mrpio.cookieclicker;

import android.util.Log;

/**
 * Created by Valerio on 15/07/2018.
 */

class MyBounceInterpolator_inverse implements android.view.animation.Interpolator {
    private double mAmplitude = 1;
    private double mFrequency = 10;

    MyBounceInterpolator_inverse (double amplitude, double frequency) {
        mAmplitude = amplitude;
        mFrequency = frequency;
    }

    public float getInterpolation(float time) {

        return (float) (-1 * Math.pow(Math.E, -((-time+1)/ mAmplitude)) *
                        Math.cos(mFrequency * time) );
    }
}