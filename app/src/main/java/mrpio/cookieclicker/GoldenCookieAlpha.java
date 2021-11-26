package mrpio.cookieclicker;

/**
 * Created by Valerio on 15/07/2018.
 */

class GoldenCookieAlpha implements android.view.animation.Interpolator {

    public float getInterpolation(float time) {
        if ( time<0.25f )return time*4f;
        else if(time>0.25f &&time<0.75f)return 1f;
        else return -4f*time+4f;

    }
}