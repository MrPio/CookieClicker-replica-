package mrpio.cookieclicker;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Arrays;

import static mrpio.cookieclicker.MainActivity.Random_click_color;
import static mrpio.cookieclicker.MainActivity.active_activity;
import static mrpio.cookieclicker.MainActivity.bg_dark;
import static mrpio.cookieclicker.MainActivity.bg_dark2;
import static mrpio.cookieclicker.MainActivity.dpheight;
import static mrpio.cookieclicker.MainActivity.effect_bar;
import static mrpio.cookieclicker.MainActivity.golden_aura;
import static mrpio.cookieclicker.MainActivity.golden_cookie_appear;
import static mrpio.cookieclicker.MainActivity.golden_cookie_time;
import static mrpio.cookieclicker.MainActivity.golden_cookie_velocity;
import static mrpio.cookieclicker.MainActivity.how_many_buildings_i_have;
import static mrpio.cookieclicker.MainActivity.my_build;
import static mrpio.cookieclicker.MainActivity.my_cookie;
import static mrpio.cookieclicker.MainActivity.number_of_golden_cookie;
import static mrpio.cookieclicker.MainActivity.number_to_formatted_string;
import static mrpio.cookieclicker.MainActivity.seven_production;
import static mrpio.cookieclicker.MainActivity.seven_production2;
import static mrpio.cookieclicker.MainActivity.x_max;
import static mrpio.cookieclicker.MainActivity.y_max;
import static mrpio.cookieclicker.MainActivity.cps_txt;
import static mrpio.cookieclicker.MainActivity.number_of_cookie;
import  static mrpio.cookieclicker.MainActivity.multiply_production;
import  static mrpio.cookieclicker.MainActivity.click_multiply_production;
import  static mrpio.cookieclicker.MainActivity.production777;
import  static mrpio.cookieclicker.MainActivity.menu;
import static mrpio.cookieclicker.MainActivity.button;
import static mrpio.cookieclicker.MainActivity.multy_directions;


public class skill_service extends Service {

    public Context context = this;
    public Handler handler = null;
    public static Runnable runnable = null;
    int i=0;
    boolean skill_pressed_tmp[]=new boolean[6];

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    private int my_id = 1;

    skill_service(int id){my_id=id;}

 /*   @Override
    public int onStartCommand (Intent intent, int flags, int startId) {
            my_id = intent.getIntExtra ("id",0);
            // do something with the value here
        return START_NOT_STICKY;
    }
*/
    @Override
    public void onCreate() {
   //     Arrays.fill (skill_pressed_tmp,false);
        //  handler = new Handler();
        //  runnable = new Runnable() {

        //  public void run() {
        // Log.d ("MY2",Arrays.toString (MainActivity.skill_pressed)+"---"+Arrays.toString (skill_pressed_tmp));
/*        String testo="",testo2="";
        boolean skill_pressed[]=new boolean[6];
        for(int j=0;j<skill_pressed_tmp.length;j++){
            skill_pressed[j]=MainActivity.skill_pressed[j];
        }

        for (int j=0;j<skill_pressed_tmp.length;j++){
            testo+=MainActivity.skill_pressed[j];
            testo2+=skill_pressed_tmp[j];
            if (skill_pressed_tmp[j]!=MainActivity.skill_pressed[j]){
                skill_pressed_tmp=Arrays.copyOf (MainActivity.skill_pressed,MainActivity.skill_pressed.length);



        Log.d ("MY3",String.valueOf (my_id));


        final long countdown=Long.parseLong (MainActivity.skill_avaible[my_id].split ("-")[5])*1000L;
        bg_dark2[my_id].animate ().alpha (0f).setDuration (200);
        if ( bg_dark[my_id].getVisibility () == View.VISIBLE){
            Toast.makeText (getApplicationContext (),"Wait other "+String.valueOf (Math.round (bg_dark[my_id].getScaleY ()*countdown/1000))+" seconds",Toast.LENGTH_SHORT).show ();
            return;
        }
        bg_dark[my_id].setVisibility (View.VISIBLE);

        if (MainActivity.skill_pressed[my_id]) {
            MainActivity.skill_pressed[my_id]=false;

            final long time = Long.parseLong (MainActivity.skill_avaible[my_id].split ("-")[4]) * 1000L;
            long power = Long.parseLong (MainActivity.skill_avaible[my_id].split ("-")[3]);
            final long interval;


            if ( my_id == 0 ) {
                interval = time / power;
                multy_directions = true;
            } else interval = 36;//30fps


            switch (my_id) {
                case 1:
                    click_multiply_production *= 15;
                    production777 = true;
                    break;
                case 2:
                    golden_cookie_velocity *= 58;
                    break;
            }





            new CountDownTimer (time, interval) {
                public void onTick (long millisUntilFinished) {
                    switch (my_id) {
                        case 0:
                            button.performClick ();
                            break;
                    }
                    bg_dark[my_id].setScaleY ((float) (time - millisUntilFinished) / (float) time);
                    bg_dark[my_id].setTranslationY (40f / dpheight * y_max - ((((float) (time - millisUntilFinished) / (float) time)) * 80f / dpheight * y_max) / 2f);
                }
                public void onFinish () {
                    switch (my_id) {
                        case 1:
                            click_multiply_production /= 15;
                            production777 = false;
                            break;
                        case 2:
                            golden_cookie_velocity /= 58;
                            break;
                    }
                    multy_directions = false;
                    bg_dark[my_id].animate ().translationY (40f / dpheight * y_max).setInterpolator (null).scaleY (0f).setDuration (countdown).withEndAction (new Runnable () {
                        @Override
                        public void run () {
                            bg_dark[my_id].setVisibility (View.INVISIBLE);
                            bg_dark2[my_id].animate ().alpha (1f).setDuration (200);
                        }
                    }).start ();
                }

            }.start ();







       // }












        //       }
        //     }

        onDestroy ();



        //    handler.postDelayed(runnable, 500);

        //     }
        //  };

        //   handler.postDelayed(runnable, 1000);
    }

    @Override
    public void onDestroy() {
        /* IF YOU WANT THIS SERVICE KILLED WITH THE APP THEN UNCOMMENT THE FOLLOWING LINE */
        // handler.removeCallbacks(runnable);
        Log.e ("MY", "END");
        Toast.makeText (getApplicationContext (),"END",Toast.LENGTH_SHORT).show ();
    }

}



