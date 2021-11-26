package mrpio.cookieclicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Typeface;
import android.provider.ContactsContract;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

import static mrpio.cookieclicker.MainActivity.root;
import static mrpio.cookieclicker.MainActivity.skill_avaible;

public class skill extends AppCompatActivity {


    BigDecimal cps_backup=new BigDecimal ("0");
    Vector<String> skill_done=new Vector <> ();
    Vector<Integer> skills=new Vector <> ();
    int x_max=0,y_max=0;

    String number_to_formatted_string (BigInteger num) {
        String str = num.toString ();
        int position;
        position = str.length () / 3;
        if ( str.length () - position * 3 != 0 ) ++position;
        if ( position > 2 ) {
            int scart = position - 2;
            str = str.substring (0, str.length () - (3 * scart));
            //str = String.format ("%,d", Integer.parseInt (str)) + " " + root[scart - 1];
            if(!str.substring (str.length ()-3,str.length ()).equals ("")) str=str.substring (0,str.length ()-3)+","+str.substring (str.length ()-3,str.length ());
            str=str+ " " + root[scart - 1];
        } else str = String.format ("%,d", Integer.parseInt (str));

        return str;
    }
    String decimal_to_formatted_string (BigDecimal num) {
        String str = num.toBigInteger ().toString ();
        int position;
        position = str.length () / 3;
        if ( str.length () - position * 3 != 0 ) ++position;
        if ( position > 2 ) {
            int scart = position - 2;
            str = str.substring (0, str.length () - (3 * scart));
            str = String.format ("%,d", Integer.parseInt (str)) + " " + root[scart - 1];
        } else {
            String tmp=num.subtract (new BigDecimal (num.toBigInteger ().toString ())).toString ();
            if(Integer.parseInt (tmp.substring (2,tmp.length ()))==0)tmp="";
            else tmp=","+tmp.substring (2,tmp.length ());

            str = String.format ("%,d", Integer.parseInt (str))+tmp;
        }

        return str;
    }
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
    public void save () {
        String txt = MainActivity.my_cookie.toString ();
        for (int i=0;i<MainActivity.how_many_buildings_i_have;i++)txt+="-"+String.valueOf (MainActivity.my_build[i]);

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

    }


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView (R.layout.activity_skill);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        final LinearLayout skill_menu=findViewById (R.id.skill_menu_upgrade);
        final TextView cps_txt=findViewById (R.id.cps_txt_skill);
        final TextView number_of_my_cookie=findViewById (R.id.number_of_my_cookie_skill);
        final TextView exit=findViewById (R.id.exit_skill);

        MainActivity.skill_menu=findViewById (R.id.skill_menu);

        for(String ed:read_txt ("skill_done").split ("-"))if(! ed.equals(""))skill_done.addElement (ed);   //Fill the Vector with id(s)
        Display display = getWindowManager().getDefaultDisplay();Point size = new Point();display.getSize(size);
        x_max=size.x;y_max=size.y;
        
        LinearLayout.LayoutParams ll = new LinearLayout.LayoutParams (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        for(int i=0;i<skill_avaible.length;i++){
            if ( skill_done.contains (String.valueOf (i+100)) )continue;
            String my_skill[]=skill_avaible[i].split ("-");

            View skill_palette = LayoutInflater.from(this).inflate(R.layout.skill_palette, null);
            final ConstraintLayout new_menu=skill_palette.findViewById (R.id.skill_menu);
            final TextView title=skill_palette.findViewById (R.id.skill_title);
            final TextView cost=skill_palette.findViewById (R.id.skill_cost);
            final TextView description=skill_palette.findViewById (R.id.skill_description);
            final ImageView symbol=skill_palette.findViewById (R.id.skill_symbol);
            final ImageView grey=skill_palette.findViewById (R.id.skill_gray);

            Context context = skill_palette.getContext ();
            int id = context.getResources ().getIdentifier ("skill"+String.valueOf (i)+"00", "drawable", context.getPackageName ());
            symbol.setImageResource (id);

            title.setText (my_skill[0]);    description.setText (my_skill[1]);  cost.setText (number_to_formatted_string (new BigInteger (my_skill[2])));
            new_menu.setId (i+100);
            if(MainActivity.my_cookie.compareTo (new BigInteger (my_skill[2]))<=0){
                grey.setVisibility (View.VISIBLE); new_menu.setId (0);
            }
            new_menu.setOnClickListener (new View.OnClickListener () {
                @Override
                public void onClick (View view) {
                    my_onclick (view);
                }
            });
            ll.setMargins(0, 15, 0, 0);
            new_menu.setLayoutParams (ll);
            skill_menu.addView (skill_palette);
            skills.add (new_menu.getId ());
        }


        exit.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                save ();
                Intent i = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage( getBaseContext().getPackageName() );
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                //trans=false;
                startActivity(i);
                finish();
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left );
            }
        });

        final int fps=Integer.parseInt (getIntent ().getStringExtra ("fps"));
        final int tmp = 1000 / fps;

        MainActivity.cps=new BigDecimal (getIntent ().getStringExtra ("cps"));
        cps_txt.setText (decimal_to_formatted_string (MainActivity.cps)+" cps");
        if (getIntent ().getBooleanExtra ("fancy",false)){
            Typeface type = Typeface.createFromAsset (getAssets (), "font/carter_one.ttf");
            number_of_my_cookie.setTypeface (type);cps_txt.setTypeface (type);
        }

/*===================================
TIMER
====================================*/
        final Thread thread = new Thread () {

            @Override
            public void run () {
                try {
                    while (!isInterrupted ()) {
                        Thread.sleep (tmp);
                        runOnUiThread (new Runnable () {
                            @Override
                            public void run () {

                                if ( MainActivity.cps.divide (new BigDecimal (String.valueOf (fps)), RoundingMode.HALF_UP)
                                             .compareTo (new BigDecimal (MainActivity.cps.divide (new BigDecimal (String.valueOf (fps)),RoundingMode.HALF_UP).toBigInteger ().toString ())) == 0 ) {
                                    MainActivity.my_cookie = MainActivity.my_cookie.add ((MainActivity.cps.divide (new BigDecimal (String.valueOf (fps)),RoundingMode.HALF_UP).toBigInteger ()).add (cps_backup.toBigInteger ()));

                                } else {
                                    cps_backup = cps_backup.add ((MainActivity.cps.divide (new BigDecimal (String.valueOf (fps)),RoundingMode.HALF_UP)).subtract (new BigDecimal (MainActivity.cps.divide (new BigDecimal (String.valueOf (fps)),RoundingMode.HALF_UP).toBigInteger ().toString ())));
                                    MainActivity.my_cookie = MainActivity.my_cookie.add ((MainActivity.cps.divide (new BigDecimal (String.valueOf (fps)),RoundingMode.HALF_UP).toBigInteger ()).add (cps_backup.toBigInteger ()));
                                    cps_backup = cps_backup.subtract (new BigDecimal (cps_backup.toBigInteger ().toString ()));
                                }

                                number_of_my_cookie.setText (number_to_formatted_string (MainActivity.my_cookie) + " Cookies");
                            }
                        });}
                } catch (InterruptedException e) {}    }
        };
        thread.start ();
    }


    public void my_onclick(final View v) {
        if (v.getId()==0){
            Toast.makeText(getApplicationContext(),"You don't have enough cookie!",Toast.LENGTH_SHORT).show();
            return;
        }
        int my_id=Integer.parseInt (String.valueOf (v.getId ()).substring (String.valueOf (v.getId ()).length ()-2));

        skill_done.add (String.valueOf (v.getId ()));
        save_txt ("skill_done",read_txt ("skill_done")+String.valueOf (v.getId ())+"-");
        save_txt ("skill",read_txt ("skill")+String.valueOf (my_id));
        Toast.makeText(getApplicationContext(),read_txt ("skill"),Toast.LENGTH_SHORT).show();
        v.animate ().translationXBy (-x_max).setInterpolator (new PowInterpolator (1.7f)).withEndAction (new Runnable () {
            @Override
            public void run () {
                for (int i=skills.indexOf (v.getId ());i<skills.size ();i++) {
                    View v2 = findViewById (skills.elementAt (i));
                    v2.animate ().translationYBy (-v.getHeight ()).setInterpolator (new PowInterpolator (1.7f)).start ();
                }
            }
        });

    }
}
