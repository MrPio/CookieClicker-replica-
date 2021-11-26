package mrpio.cookieclicker;

import android.util.Log;

/**
 * Created by Valerio on 15/07/2018.
 */

class SinInterpolator2 implements android.view.animation.Interpolator {

    private float mAmplitude = 10;

    SinInterpolator2 (float amplitude) {
        mAmplitude = amplitude;
    }

    public float getInterpolation(float time) {

        if (time>0.4668f)return (-(float)((Math.sin (time*mAmplitude)/6f)+2*time)+2f);
        else return (float)((Math.sin (time*mAmplitude)/6f)+2*time);

    }
}