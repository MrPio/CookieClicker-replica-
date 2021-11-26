package mrpio.cookieclicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;

import static mrpio.cookieclicker.MainActivity.Random_click_color;
import static mrpio.cookieclicker.MainActivity.active_activity;
import static mrpio.cookieclicker.MainActivity.effect_bar;
import static mrpio.cookieclicker.MainActivity.golden_aura;
import static mrpio.cookieclicker.MainActivity.golden_cookie_appear;
import static mrpio.cookieclicker.MainActivity.golden_cookie_time;
import static mrpio.cookieclicker.MainActivity.golden_cookie_velocity;
import static mrpio.cookieclicker.MainActivity.how_many_buildings_i_have;
import static mrpio.cookieclicker.MainActivity.my_build;
import static mrpio.cookieclicker.MainActivity.my_cookie;
import static mrpio.cookieclicker.MainActivity.number_of_critical_click;
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

/*
public class service extends Service {

    @Override
    public IBinder onBind (Intent intent) {
        return null;
    }


    @Override
    public int onStartCommand (Intent intent, int flags, int startId) {
        Log.d ("MY", "Service Started");
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy () {
        super.onDestroy ();
        Log.d ("MY", "Service Destroyed");
    }

    @Override
    public void onTaskRemoved (Intent rootIntent) {
        Log.e ("MY", "END");

        String txt = my_cookie.toString ();
        for (int i=0;i<how_many_buildings_i_have;i++)txt+="-"+String.valueOf (my_build[i]);
        try {
            String FILENAME = "cookie";
            FileOutputStream fos = openFileOutput (FILENAME, Context.MODE_PRIVATE);
            fos.write (txt.getBytes ());
            fos.close ();
        } catch (IOException ed) {
            Log.e ("ERROR", ed.toString ());
        }

        long date_now = System.currentTimeMillis ();
        try {
            String FILENAME = "date";
            FileOutputStream fos = openFileOutput (FILENAME, Context.MODE_PRIVATE);
            fos.write (String.valueOf (date_now).getBytes ());
            fos.close ();
        } catch (IOException ed) {
            Log.e ("ERROR", ed.toString ());
        }


        try {
            String FILENAME = "thread1";
            FileOutputStream fos = openFileOutput (FILENAME, Context.MODE_PRIVATE);
            fos.write ("false".getBytes ());
            fos.close ();
        } catch (IOException ed) {
            Log.e ("ERROR", ed.toString ());
        }
        stopSelf ();
    }

}
*/


public class service extends Service {

    boolean bar_is_busy=false;
    boolean universal[]=new  boolean[10];

    public void save_txt (String filename,String text) {
        try {
            FileOutputStream fos = openFileOutput (filename, Context.MODE_PRIVATE);
            fos.write (text.getBytes ());
            fos.close ();
        } catch (IOException ed) {
            Log.e ("ERROR", ed.toString ());
        }
    }
    String read_txt (String filename){
        String to_return="";
        try {
            byte[] bytes = new byte[1024*2];
            FileInputStream fis = openFileInput (filename);
            fis.read (bytes);
            fis.close ();
            to_return=new String (bytes).trim ();
        } catch (IOException e) {
            save_txt (filename,"");
        }
        return to_return;
    }

    public Context context = this;
    public Handler handler = null;
    public static Runnable runnable = null;
    int i=0;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

   /* @Override
    public int onStartCommand (Intent intent, int flags, int startId) {
        return START_NOT_STICKY;
    }*/
   @Override
   public int onStartCommand(Intent intent, int flags, int startId) {
       return START_NOT_STICKY;
   }


    @Override
    public void onCreate() {

        Log.e ("MY", "Start");

        handler = new Handler();
        runnable = new Runnable() {

            int im_waiting=0;
            final int interval=500;
            long golden_cookie_time_to_wait=(int)(((Math.random ()*60)+10*60)/golden_cookie_appear*(1000f/(float)interval));


            public void run() {
                //effect_bar.setMax ((int)golden_cookie_time_to_wait);


                /*
                                switch (active_activity){
                                    case 0:     menu33=menu;
                                        break;
                                    case 1:     menu33=upgrade_menu;
                                        break;
                                    case 2:     menu33=skill_menu;
                                        break;
                                }
*/
                im_waiting+=golden_cookie_velocity;
                if(!bar_is_busy)effect_bar.setProgress ((int) (1080f * ((float) im_waiting / (float) golden_cookie_time_to_wait)));
                                   /* if(reinitialize_golden_timer){
                                        int tmp=golden_cookie_time_to_wait;
                                        golden_cookie_time_to_wait=(int)(((Math.random ()*60)+5*60)/golden_cookie_appear*(1000f/(float)interval));
                                        if(tmp>golden_cookie_time_to_wait) {
                                            if(tmp-im_waiting<golden_cookie_time_to_wait) im_waiting-=(tmp-golden_cookie_time_to_wait);
                                            else im_waiting=0;
                                        }
                                        //else im_waiting=0;
                                        reinitialize_golden_timer=false;
                                    }*/
               // Log.d ("MY",String.valueOf (active_activity)+"      "+String.valueOf (im_waiting)+"/"+String.valueOf(golden_cookie_time_to_wait)
               //      +"   +"+String.valueOf (golden_cookie_velocity));
                if (im_waiting>=golden_cookie_time_to_wait) {

                    final ImageView golden_cookie = new ImageView (getApplicationContext ());

                    golden_cookie.setImageDrawable (getResources ().getDrawable (R.drawable.cookie_golden256));
                    int pos_x = (int) (Math.random () * (x_max - 1)) - 64;

                    float c = (float) (Math.random () / 5) + 0.7f;
                    golden_cookie.setScaleX (0.4f);
                    golden_cookie.setScaleY (0.4f);
                    golden_cookie.setScaleType (ImageView.ScaleType.FIT_XY);
                    golden_cookie.setX ((float) (Math.random () * (x_max - 128)) - 64f);
                    golden_cookie.setY ((float) (Math.random () * (y_max - 128)) - 64f);
                    golden_cookie.setAlpha (0f);

                    menu.addView (golden_cookie);

                    final MyBounceInterpolator_inverse bounce = new MyBounceInterpolator_inverse (0.2, 41);
                    long rotation1 = 200 / 12 * golden_cookie_time;
                    final SinInterpolator rotation = new SinInterpolator (rotation1);
                    final SinInterpolator2 sin = new SinInterpolator2 (60);
                    final GoldenCookieAlpha alpha_interpolator = new GoldenCookieAlpha ();

                    golden_cookie.setOnClickListener (new View.OnClickListener () {
                        @Override
                        public void onClick (View view) {
                            MediaPlayer mm=MediaPlayer.create (getApplicationContext (),R.raw.orteil_shimmerclick);mm.start ();
                            int tmp = (int) ((float) (getResources ().getDrawable (R.drawable.cookie_golden256).getIntrinsicHeight ()) * golden_cookie.getScaleX () / 2);
                            ImageView anim = new ImageView (getApplicationContext ());
                            anim.setScaleX (golden_cookie.getScaleX () * 2f);
                            anim.setScaleY (golden_cookie.getScaleX () * 2f);
                            anim.setScaleType (ImageView.ScaleType.FIT_XY);
                            anim.setBackground (getResources ().getDrawable (R.drawable.anim));
                            anim.setX (golden_cookie.getX () + tmp);
                            anim.setY (golden_cookie.getY () + tmp);
                            menu.addView (anim);
                            AnimationDrawable anim_animation = (AnimationDrawable) anim.getBackground ();

                            anim_animation.start ();
                            number_of_golden_cookie++;
                            MainActivity.stat_golden_click.setText (String.valueOf (number_of_golden_cookie));
                            try {
                                FileOutputStream fos = openFileOutput ("golden_num", Context.MODE_PRIVATE);
                                fos.write (String.valueOf (number_of_golden_cookie).getBytes ());
                                fos.close ();
                            } catch (IOException e1) {
                            }



                            Integer effect = (int) (Math.random () * 100) + 1;
                            if ( seven_production ||seven_production2)effect=1;
                            String testo = "";

                            if ( effect >= 1 && effect <= 40 ) {
                                BigDecimal add = new BigDecimal (my_cookie.toString ()).multiply (BigDecimal.valueOf (Math.random () * 0.08d + 0.1d));
                                my_cookie = my_cookie.add (add.toBigInteger ());
                                number_of_cookie.setText (number_to_formatted_string (my_cookie) + " Cookies");
                                testo = "+" + number_to_formatted_string (add.toBigInteger ()) + " C";
                            } else if ( effect >= 41 && effect <= 80 ) {
                                if ( !seven_production ) {
                                    seven_production = true;
                                    testo = "Cookie production x7\nfor 77s!";
                                    multiply_production = 7;
                                    click_multiply_production = 7;
                                    cps_txt.setTextSize (26f);
                                    cps_txt.setTextColor (getResources ().getColor (R.color.gold));
                                    final int tempo = 77000;
                                    final int duration = 2000;
                                    effect_bar.setVisibility (View.VISIBLE);
                                    bar_is_busy=true;
                                    new CountDownTimer (tempo, 20) {

                                        public void onTick (long millisUntilFinished) {
                                            effect_bar.setProgress ((int) (1080f * ((float) millisUntilFinished / (float) tempo)));
                                        }

                                        public void onFinish () {
                                            multiply_production = 1;
                                            click_multiply_production = 1;
                                            if (!MainActivity.skill_done.contains (String.valueOf (2603)))effect_bar.setVisibility (View.INVISIBLE);
                                            bar_is_busy=false;
                                            cps_txt.setTextSize (18f);
                                            cps_txt.setTextColor (getResources ().getColor (R.color.white));
                                            seven_production = false;
                                        }

                                    }.start ();
                                    golden_aura.setAlpha (0f);
                                    golden_aura.setVisibility (View.VISIBLE);
                                    golden_aura.animate ().alpha (1f).setInterpolator (null).setDuration (duration).start ();


                                    new CountDownTimer (tempo - duration, 1000) {

                                        public void onTick (long millisUntilFinished) {
                                            // Log.d ("MY",String.valueOf (millisUntilFinished));
                                        }

                                        public void onFinish () {
                                            universal[0] = true;
                                            golden_aura.animate ().alpha (0f).setInterpolator (null).setDuration (duration)
                                                    .setListener (new AnimatorListenerAdapter () {
                                                        @Override
                                                        public void onAnimationEnd (Animator animation) {
                                                            if ( universal[0] ) {
                                                                golden_aura.setVisibility (View.INVISIBLE);
                                                                universal[0] = false;
                                                            }

                                                        }
                                                    }).start ();
                                        }

                                    }.start ();
                                }

                            } else {
                                if ( !seven_production2 ) {
                                    seven_production2 = true;
                                    testo = "Click power x777\nfor 13s!";
                                    click_multiply_production *= 777;
                                    production777 = true;
                                    final int tempo1 = 13000;
                                    effect_bar.setVisibility (View.VISIBLE);
                                    bar_is_busy=true;
                                    new CountDownTimer (tempo1, 20) {

                                        public void onTick (long millisUntilFinished) {
                                            effect_bar.setProgress ((int) (1080f * ((float) millisUntilFinished / (float) tempo1)));
                                        }

                                        public void onFinish () {
                                            multiply_production = 1;
                                            click_multiply_production /= 777;
                                            if (!MainActivity.skill_done.contains (String.valueOf (2603)))effect_bar.setVisibility (View.INVISIBLE);
                                            bar_is_busy=false;
                                            seven_production2 = false;
                                            production777 = false;
                                        }

                                    }.start ();
                                }
                            }


                            int altezza = (int) ((600f / 1920f) * y_max);
                            int altezza1 = (int) ((50f / 1920f) * x_max);
                            final TextView textView = new TextView (getApplicationContext ());
                            textView.setX (golden_cookie.getX ());
                            textView.setY (golden_cookie.getY ());
                            textView.setText (testo);
                            int freq = (int) (Math.random () * 13) + 20;
                            int size_random = 22;
                            int duration = 3000;
                            textView.setTextSize (size_random);
                            Typeface type = Typeface.createFromAsset (getAssets (), "font/komikax.ttf");
                            textView.setTypeface (type);
                            menu.addView (textView);
                            textView.setTextColor (new Color ().rgb (230, 230, 230));
                            if ( Random_click_color )
                                textView.setTextColor (new Color ().rgb ((int) (Math.random () * 255), (int) (Math.random () * 255), (int) (Math.random () * 255)));


                            MyBounceInterpolator interpolator = new MyBounceInterpolator (0.55, freq);
                            textView.animate ()
                                    .translationY (-100)

                                    .alpha (0f) //float value
                                    .setDuration (duration)
                                    .setListener (new AnimatorListenerAdapter () {

                                        public void onAnimationEnd (Animator animation) {
                                            menu.removeView (textView);
                                        }
                                    })
                                    .start ();

                            textView.animate ()
                                    .translationX (textView.getX () - altezza1)
                                    .setDuration (duration + 300).setInterpolator (interpolator)
                                    .start ();
                            menu.removeView (golden_cookie);
                            //menu.removeView (anim);

                        }
                    });

                    //ANIMATION

                    //golden_cookie.animate ().setStartDelay (golden_cookie_time/4*1000).alpha (0f).setDuration (golden_cookie_time*3/4*1000).setInterpolator (null).start ();

                    golden_cookie.animate ()
                            .scaleY (1f).scaleX (1f)
                            .setInterpolator (sin)
                            .setDuration (golden_cookie_time * 1000)
                            .start ();

                    //golden_cookie.animate ().scaleX (1f).scaleY (1f).setInterpolator (null).setDuration (golden_cookie_time/2*1000).start ();

                    golden_cookie.animate ().alpha (1f).setDuration (golden_cookie_time * 1000).setInterpolator (alpha_interpolator).start ();

                    golden_cookie.animate ().rotation (10).setDuration (golden_cookie_time * 1000).setInterpolator (rotation).setListener (new AnimatorListenerAdapter () {
                        @Override
                        public void onAnimationEnd (Animator animation) {
                            menu.removeView (golden_cookie);
                        }
                    }).start ();

                    golden_cookie_time_to_wait=(int)(((Math.random ()*60)+10*60)/golden_cookie_appear*(1000f/(float)interval));
                    im_waiting-=golden_cookie_time_to_wait;
                }



                handler.postDelayed(runnable, 500);
            }
        };

        handler.postDelayed(runnable, 1500);
    }

    @Override
    public void onDestroy() {
        /* IF YOU WANT THIS SERVICE KILLED WITH THE APP THEN UNCOMMENT THE FOLLOWING LINE */
        handler.removeCallbacks(runnable);

        super.onDestroy();
        if(read_txt ("save_or_reset").length ()>0) Log.e ("MY", "END"+" read: "+read_txt ("save_or_reset")+" If result: "+String.valueOf ((read_txt ("save_or_reset").charAt (0)!='1')));
        else Log.e ("MY", "END");

        if(read_txt ("save_or_reset").length ()>0) if (read_txt ("save_or_reset").charAt (0)!='1') {
            Toast.makeText (getApplicationContext (),"Saving...",Toast.LENGTH_SHORT).show ();
            String txt = my_cookie.toString ();
            for (int i = 0; i < how_many_buildings_i_have; i++)
                txt += "-" + String.valueOf (my_build[i]);
            try {
                String FILENAME = "cookie";
                FileOutputStream fos = openFileOutput (FILENAME, Context.MODE_PRIVATE);
                fos.write (txt.getBytes ());
                fos.close ();
            } catch (IOException ed) {
                Log.e ("ERROR", ed.toString ());
            }


            try {
                String FILENAME = "cookie_clicked";
                FileOutputStream fos = openFileOutput (FILENAME, Context.MODE_PRIVATE);
                fos.write (MainActivity.my_cookie_clicked.toString ().getBytes ());
                fos.close ();
            } catch (IOException ed) {
                Log.e ("ERROR", ed.toString ());
            }
            long date_now = System.currentTimeMillis ();
            try {
                String FILENAME = "date";
                FileOutputStream fos = openFileOutput (FILENAME, Context.MODE_PRIVATE);
                fos.write (String.valueOf (date_now).getBytes ());
                fos.close ();
            } catch (IOException ed) {
                Log.e ("ERROR", ed.toString ());
            }


            try {
                String FILENAME = "thread1";
                FileOutputStream fos = openFileOutput (FILENAME, Context.MODE_PRIVATE);
                fos.write ("false".getBytes ());
                fos.close ();
            } catch (IOException ed) {
                Log.e ("ERROR", ed.toString ());
            }

            //Other save settings

            save_txt ("cookie_clicked", MainActivity.my_cookie_clicked.toString ());
            save_txt ("critical_click", String.valueOf (MainActivity.number_of_critical_click));
            save_txt ("offline_cookie", MainActivity.my_offline_cookie.toString ());
            save_txt ("builds_cost", MainActivity.my_builds_cost.toString ());
            save_txt ("upgrades_cost", MainActivity.my_upgrades_cost.toString ());
        }

    }

}



