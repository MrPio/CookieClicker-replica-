package mrpio.cookieclicker;

import android.util.Log;

/**
 * Created by Valerio on 15/07/2018.
 */

class SinInterpolator implements android.view.animation.Interpolator {

    private float mAmplitude = 10;

    SinInterpolator(float amplitude) {
        mAmplitude = amplitude;
    }

    public float getInterpolation(float time) {
        //Log.d ("MY","time: "+String.valueOf (time)+"  -  value: "+String.valueOf ((float)((Math.sin (time)))*mAmplitude));
        return (float)((Math.sin (time*mAmplitude)));

    }
}