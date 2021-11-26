package mrpio.cookieclicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Vector;

/*
 *
 * CONTROLLARE IL VETTORE FATTI_FAST, NON SALVA.
 *
 * */


public class upgrade_activity extends AppCompatActivity implements View.OnClickListener {

    String builds_give[]=new String[15];
    int how_many_buildings_i_have=15;
    int my_build[]=new int[20];

    BigInteger my_cookie=new BigInteger ("0");
    BigDecimal cps=new BigDecimal ("0");
    String[] root={"M","B","T","q","Q","s","S","O","N","d","U","D",};
    private  boolean trans=true;

    String[]costi=new String[2000];
    Boolean[]fatti=new Boolean[10000];
    String[]percentuale=new String[200];
    long number_of_golden_cookie=0;
    BigDecimal cps_backup=new BigDecimal ("0");
    Vector <String>fatti_fast=new Vector<String> ();
    Vector<Integer> skills=new Vector <> ();


    BigDecimal[] initial_give = {
            new BigDecimal ("0.1"),
            new BigDecimal ("1"),
            new BigDecimal ("8"),
            new BigDecimal ("47"),
            new BigDecimal ("260"),
            new BigDecimal ("1400"),
            new BigDecimal ("7800"),
            new BigDecimal ("44000"),
            new BigDecimal ("260000"),
            new BigDecimal ("1600000"),
            new BigDecimal ("10000000"),
            new BigDecimal ("65000000"),
            new BigDecimal ("430000000"),
            new BigDecimal ("2900000000"),
            new BigDecimal ("21000000000")
    };


    String[]base_cost="100-1000-11000-120000-1300000-14000000-200000000-3300000000-51000000000-750000000000-10000000000000-140000000000000-1700000000000000-21000000000000000-260000000000000000".split ("-");
    String[]cost_multiply="1-5-10-100-100-100-1000-1000-1000-1000-10000".split ("-");
    String[]cost_multiply_cursor="1-5-20-10-100-10-10-10-1000-1000-1000-1000".split ("-");
    String[]required_progress="1-5-25-50-100-150-200-250-300-350-400".split ("-");
    String[]required_progress_cursor="1-1-5-25-50-100-150-200-250-300-350-400".split ("-");
    String[]name_upgrades="Cursor-Grandma-Farm-Mine-Factory-Bank-Temple-Wizard Tower-Shipment-Alchemy Lab-Portal-Time Machine-Antimatter Condenser-Prism-Chancemaker".split ("-");

    //*******************************************************************************************************************************************************************************************
    //*******************************************************************************************************************************************************************************************
    //*******************************************************************************************************************************************************************************************
    //APPLICARE IL METODO AUTOMATICO A TUTTI GLI UPGRADE//
    //*******************************************************************************************************************************************************************************************
    //*******************************************************************************************************************************************************************************************
    //*******************************************************************************************************************************************************************************************


    String[] upgrade_available={
            "Offline Production-10-15-1000",
            "Offline Production-15-20-10000",
            "Offline Production-20-25-100000",
            "Offline Production-25-30-1000000",
            "Offline Production-30-35-10000000",
            "Offline Production-35-40-100000000",

            "Luck-7-777778000000",
            "Luck-27-77778000000000",
            "Luck-77-77778000000000000",

            "Cursor Power-1-100",
            /*"Cursor Power-1-500",
            "Cursor Power-10-10000",
            "Cursor Power-25-100000",
            "Cursor Power-50-10000000",
            "Cursor Power-100-100000000",

            "Grandma Power-1-1000",
            "Grandma Power-5-5000",
            "Grandma Power-25-50000",
            "Grandma Power-50-5000000",
            "Grandma Power-100-500000000",

            "Farm Power-1-11000",
            "Farm Power-5-55000",
            "Farm Power-25-550000",
            "Farm Power-50-55000000",
            "Farm Power-100-5500000000",

            "Mine Power-1-120000",
            "Mine Power-5-600000",
            "Mine Power-25-6000000",
            "Mine Power-50-600000000",
            "Mine Power-100-60000000000",

            "Factory Power-1-1300000",
            "Factory Power-5-6500000",
            "Factory Power-25-65000000",
            "Factory Power-50-6500000000",
            "Factory Power-100-650000000000",

            "Bank Power-1-14000000",
            "Bank Power-5-70000000",
            "Bank Power-25-700000000",
            "Bank Power-50-70000000000",
            "Bank Power-100-7000000000000",

            "Temple Power-1-200000000",
            "Temple Power-5-1000000000",
            "Temple Power-25-10000000000",
            "Temple Power-50-1000000000000",
            "Temple Power-100-100000000000000",

            "Wizard Tower Power-1-3300000000",
            "Wizard Tower Power-5-16500000000",
            "Wizard Tower Power-25-165000000000",
            "Wizard Tower Power-50-16500000000000",
            "Wizard Tower Power-100-1650000000000000",

            "Shipment Power-1-51000",
            "Shipment Power-5-600000",
            "Shipment Power-25-6000000",
            "Shipment Power-50-600000000",
            "Shipment Power-100-60000000000",

            "Alchemy Lab Power-1-120000",
            "Alchemy Lab Power-5-600000",
            "Alchemy Lab Power-25-6000000",
            "Alchemy Lab Power-50-600000000",
            "Alchemy Lab Power-100-60000000000",

            "Portal Power-1-120000",
            "Portal Power-5-600000",
            "Portal Power-25-6000000",
            "Portal Power-50-600000000",
            "Portal Power-100-60000000000",

            "Time Machine Power-1-120000",
            "Time Machine Power-5-600000",
            "Time Machine Power-25-6000000",
            "Time Machine Power-50-600000000",
            "Time Machine Power-100-60000000000",

            "Antimatter Condenser Power-1-120000",
            "Antimatter Condenser Power-5-600000",
            "Antimatter Condenser Power-25-6000000",
            "Antimatter Condenser Power-50-600000000",
            "Antimatter Condenser Power-100-60000000000"*/
    };


    public void save () {
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

    }

    String read_upgrade(){
        String string="";
        try {
            String FILENAME = "upgrade1";
            byte[] bytes = new byte[5024];
            FileInputStream fis = openFileInput(FILENAME);
            fis.read(bytes);
            fis.close();
            string = new String(bytes);
            Log.d ("MY","SAVED: "+string.trim ());
        } catch (IOException e) {}
        return string.trim();
    }

    void save_upgrade(String txt) {

        try {
            String tmp=read_upgrade()+txt+"/";

            String FILENAME = "upgrade1";
            FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
            fos.write(tmp.getBytes());
            fos.close();
        } catch (IOException ed) {
            Log.e("ERROR", ed.toString());


        }

    }



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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //overridePendingTransition (R.anim.transition_upgrade,R.anim.stop_transition);
        //getWindow().getAttributes().windowAnimations = R.style.Fade;
        // remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_upgrade_activity);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        final TextView exit=findViewById(R.id.exit_skill);
        final TextView my_cookie_number=findViewById(R.id.number_of_my_cookie_skill);
        final LinearLayout menu=findViewById(R.id.menu_upgrade);
        final TextView cps_txt=findViewById (R.id.cps_txt2);
        final ImageView refresh=findViewById (R.id.refresh);

        number_of_golden_cookie=getIntent ().getLongExtra ("golden_num",0);
        Boolean reset=false;
        try {
            String string="";
            String FILENAME = "upgrade_done";
            byte[] bytes = new byte[10240];
            FileInputStream fis = openFileInput(FILENAME);
            fis.read(bytes);
            fis.close();
            string = new String(bytes);
            if (!string.trim().contains("-"))reset=true;
            else {
                String leggo[]=string.trim().split("-");
                for(int j=0;j<leggo.length;j++){
                    // fatti[j]=Boolean.valueOf(leggo[j]);
                    fatti_fast.add (leggo[j]);
                }
            }

        } catch (IOException e) {

        }

        if(reset){

            fatti_fast.removeAllElements ();
            try {
                String FILENAME = "upgrade_done";
                FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
                fos.write("".getBytes());
                fos.close();
            } catch (IOException ed) {
                Log.e("ERROR", ed.toString());

            }
        }

        String string;
        try {
            String FILENAME = "cookie";
            byte[] bytes = new byte[1024];
            FileInputStream fis = openFileInput(FILENAME);
            fis.read(bytes);
            fis.close();
            string = new String(bytes);

            String[] cookie=string.split("-");
            my_cookie=new BigInteger(cookie[0]);
            my_cookie_number.setText(number_to_formatted_string(my_cookie)+" Cookies");
            for (int i = 0; i < how_many_buildings_i_have; i++) {
                my_build[i] = Integer.parseInt (cookie[i + 1].trim ());
            }

        } catch (IOException e) {}

        //SE NON ESISTE UPGRADE.TXT ALLORA LO CREO

        try {
            String FILENAME = "upgrade1";
            byte[] bytes = new byte[1024];
            FileInputStream fis = openFileInput(FILENAME);
            fis.read(bytes);
            fis.close();
            string = new String(bytes);
        } catch (IOException e) {
            try {
                String FILENAME = "upgrade1";
                FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
                fos.write(" ".getBytes());
                fos.close();
            } catch (IOException ed) {
                Log.e("ERROR", ed.toString());

            }
        }
        /*final ConstraintLayout new_menu_example=(ConstraintLayout) findViewById(R.id.new_menu_example);
        final TextView title_example=(TextView)findViewById(R.id.title);
        final ImageView small_cookie_example=(ImageView)findViewById(R.id.image);
        final TextView cost_example=(TextView)findViewById(R.id.cost);
        final TextView from_example=(TextView)findViewById(R.id.from);
        final TextView to_example=(TextView)findViewById(R.id.to);
        final ImageView image_example=findViewById (R.id.image2);*/

        //for(String ed:fatti_fast)Log.d ("MY3",ed);



        String current="";
        for(int i=0;i<upgrade_available.length;i++){
            //Toast.makeText (getApplicationContext (),String.valueOf (i),Toast.LENGTH_SHORT).show ();
            if(fatti_fast.contains (String.valueOf(i+100)))                continue;

            String tmp1[]=upgrade_available[i].split("-");




            LinearLayout.LayoutParams ll = new LinearLayout.LayoutParams (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            LinearLayout.LayoutParams ll2 = new LinearLayout.LayoutParams (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            ConstraintLayout.LayoutParams cl=new ConstraintLayout.LayoutParams (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);


            Typeface font_carter_one = Typeface.createFromAsset(getAssets(),"font/carter_one.ttf");
            View image2_ = LayoutInflater.from(this).inflate(R.layout.image2, null);

            final ConstraintLayout new_menu=image2_.findViewById (R.id.new_menu_example);
            final TextView title=image2_.findViewById (R.id.title2);
            final TextView cost=image2_.findViewById (R.id.cost);
            final TextView from=image2_.findViewById (R.id.from);
            final TextView to=image2_.findViewById (R.id.to);
            final ImageView cookie_small=image2_.findViewById (R.id.image);
            final ImageView image2=image2_.findViewById (R.id.image2);

            MainActivity.upgrade_menu=findViewById (R.id.menu_upgrade2);
            int required=0;
            Boolean stop=false;

            //Log.d ("MY",tmp1[0]);

            switch (tmp1[0]){
                case "Offline Production":

                    Log.d ("MY2",(String.valueOf(i+100)));

                    //if (fatti[Integer.valueOf("1"+String.valueOf(i))])break;

                    if (current.equals(tmp1[0]))break;

                    if(my_cookie.compareTo(new BigInteger(tmp1[3]))<=0)stop=true;

                    current=tmp1[0];
                    String add_id=String.valueOf (i);
                    if (i<10)add_id="0"+add_id;
                    image2_.setId(Integer.valueOf("1"+add_id));
                    if(stop)image2_.setId(0);
                    new_menu.setBackground(getResources().getDrawable(R.color.dark_background));
                    if(stop)new_menu.setBackground(getResources().getDrawable(R.color.dark_dark_background));

                    title.setText(tmp1[0]);
                    title.setTextSize(20);
                    title.setTypeface(font_carter_one);
                    if(stop)title.setTextColor(getResources().getColor(R.color.light_grey));

                    cost.setText(number_to_formatted_string(new BigInteger(tmp1[3])));
                    cost.setTextSize(16);
                    cost.setTypeface(font_carter_one);
                    if(stop)cost.setTextColor(getResources().getColor(R.color.light_grey));

                    from.setText("From: "+tmp1[1]+"%");
                    from.setTextSize(18);
                    from.setTypeface(font_carter_one);
                    if(stop)from.setTextColor(getResources().getColor(R.color.light_grey));

                    to.setText("To: "+tmp1[2]+"%");
                    to.setTextSize(18);
                    to.setTypeface(font_carter_one);
                    if(stop)to.setTextColor(getResources().getColor(R.color.light_grey));

                    if(stop)cookie_small.setImageDrawable (getResources ().getDrawable (R.drawable.very_small_cookie_grey));

                    image2_.setPadding(0, 7, 0, 7);
                    ll.setMargins(0, 15, 0, 0);
                    image2_.setLayoutParams(ll);
                    image2.setImageDrawable (getResources ().getDrawable (R.drawable.offline));
                    menu.addView(image2_);


                    new_menu.setOnClickListener(this);
                    costi[new_menu.getId()]=tmp1[3];
                    percentuale[new_menu.getId()]=tmp1[2];

                    break;



/*
                case "Cursor Power":
                    if (fatti[Integer.valueOf("1"+String.valueOf(i))])break;
                    required= Integer.parseInt(tmp1[1]);
                    if (my_build[0]>=required) {

                        //boolean grey=false;//current.equals(tmp1[0]);
                        if(my_cookie.compareTo(new BigInteger(tmp1[2]))<=0)stop=true;

                        current = tmp1[0];
                        new_menu.setId(Integer.valueOf("2"+String.valueOf(i)));

                        if(stop)image2_.setId(0);
                        new_menu.setBackground(getResources().getDrawable(R.color.dark_background));
                        if(stop)new_menu.setBackground(getResources().getDrawable(R.color.dark_dark_background));

                        title.setText(tmp1[0]);
                        title.setTextSize(20);
                        title.setTypeface(font_carter_one);
                        if(stop)title.setTextColor(getResources().getColor(R.color.light_grey));

                        cost.setText(number_to_formatted_string(new BigInteger(tmp1[2])));
                        cost.setTextSize(16);
                        cost.setTypeface(font_carter_one);
                        if(stop)cost.setTextColor(getResources().getColor(R.color.light_grey));

                        from.setText("2x Power");
                        from.setTextSize(20);
                        from.setTypeface(font_carter_one);
                        if(stop)from.setTextColor(getResources().getColor(R.color.light_grey));
                        to.setVisibility (View.INVISIBLE);
                        if(stop)cookie_small.setImageDrawable (getResources ().getDrawable (R.drawable.very_small_cookie_grey));

                        image2_.setPadding(0, 7, 0, 7);
                        ll.setMargins(0, 15, 0, 0);
                        image2_.setLayoutParams(ll);
                        image2.setImageDrawable (getResources ().getDrawable (R.drawable.cursor));
                        menu.addView(image2_);

                        new_menu.setOnClickListener(this);
                        costi[new_menu.getId()]=tmp1[2];


                    }
                    break;

                case "Grandma Power":
                    required= Integer.parseInt(tmp1[1]);
                    if (my_build[1]>=required) {
                        if(my_cookie.compareTo(new BigInteger(tmp1[2]))<=0)stop=true;

                        current = tmp1[0];
                        new_menu.setId(Integer.valueOf("3"+String.valueOf(i)));

                        if(stop)image2_.setId(0);
                        new_menu.setBackground(getResources().getDrawable(R.color.dark_background));
                        if(stop)new_menu.setBackground(getResources().getDrawable(R.color.dark_dark_background));

                        title.setText(tmp1[0]);
                        title.setTextSize(20);
                        title.setTypeface(font_carter_one);
                        if(stop)title.setTextColor(getResources().getColor(R.color.light_grey));

                        cost.setText(number_to_formatted_string(new BigInteger(tmp1[2])));
                        cost.setTextSize(16);
                        cost.setTypeface(font_carter_one);
                        if(stop)cost.setTextColor(getResources().getColor(R.color.light_grey));

                        from.setText("2x Power");
                        from.setTextSize(20);
                        from.setTypeface(font_carter_one);
                        if(stop)from.setTextColor(getResources().getColor(R.color.light_grey));
                        to.setVisibility (View.INVISIBLE);
                        if(stop)cookie_small.setImageDrawable (getResources ().getDrawable (R.drawable.very_small_cookie_grey));

                        image2_.setPadding(0, 7, 0, 7);
                        ll.setMargins(0, 15, 0, 0);
                        image2_.setLayoutParams(ll);
                        image2.setImageDrawable (getResources ().getDrawable (R.drawable.grandma));
                        menu.addView(image2_);

                        new_menu.setOnClickListener(this);
                        costi[new_menu.getId()]=tmp1[2];


                    }
                    break;

                case "Farm Power":
                    required= Integer.parseInt(tmp1[1]);
                    if (my_build[2]>=required) {
                        if(my_cookie.compareTo(new BigInteger(tmp1[2]))<=0)stop=true;

                        current = tmp1[0];
                        new_menu.setId(Integer.valueOf("4"+String.valueOf(i)));

                        if(stop)image2_.setId(0);
                        new_menu.setBackground(getResources().getDrawable(R.color.dark_background));
                        if(stop)new_menu.setBackground(getResources().getDrawable(R.color.dark_dark_background));

                        title.setText(tmp1[0]);
                        title.setTextSize(20);
                        title.setTypeface(font_carter_one);
                        if(stop)title.setTextColor(getResources().getColor(R.color.light_grey));

                        cost.setText(number_to_formatted_string(new BigInteger(tmp1[2])));
                        cost.setTextSize(16);
                        cost.setTypeface(font_carter_one);
                        if(stop)cost.setTextColor(getResources().getColor(R.color.light_grey));

                        from.setText("2x Power");
                        from.setTextSize(20);
                        from.setTypeface(font_carter_one);
                        if(stop)from.setTextColor(getResources().getColor(R.color.light_grey));
                        to.setVisibility (View.INVISIBLE);
                        if(stop)cookie_small.setImageDrawable (getResources ().getDrawable (R.drawable.very_small_cookie_grey));

                        image2_.setPadding(0, 7, 0, 7);
                        ll.setMargins(0, 15, 0, 0);
                        image2_.setLayoutParams(ll);
                        image2.setImageDrawable (getResources ().getDrawable (R.drawable.farm));
                        menu.addView(image2_);

                        new_menu.setOnClickListener(this);
                        costi[new_menu.getId()]=tmp1[2];


                    }
                    break;

                case "Mine Power":
                    required= Integer.parseInt(tmp1[1]);
                    if (my_build[3]>=required) {
                        if(my_cookie.compareTo(new BigInteger(tmp1[2]))<=0)stop=true;

                        current = tmp1[0];
                        new_menu.setId(Integer.valueOf("5"+String.valueOf(i)));

                        if(stop)image2_.setId(0);
                        new_menu.setBackground(getResources().getDrawable(R.color.dark_background));
                        if(stop)new_menu.setBackground(getResources().getDrawable(R.color.dark_dark_background));

                        title.setText(tmp1[0]);
                        title.setTextSize(20);
                        title.setTypeface(font_carter_one);
                        if(stop)title.setTextColor(getResources().getColor(R.color.light_grey));

                        cost.setText(number_to_formatted_string(new BigInteger(tmp1[2])));
                        cost.setTextSize(16);
                        cost.setTypeface(font_carter_one);
                        if(stop)cost.setTextColor(getResources().getColor(R.color.light_grey));

                        from.setText("2x Power");
                        from.setTextSize(20);
                        from.setTypeface(font_carter_one);
                        if(stop)from.setTextColor(getResources().getColor(R.color.light_grey));
                        to.setVisibility (View.INVISIBLE);
                        if(stop)cookie_small.setImageDrawable (getResources ().getDrawable (R.drawable.very_small_cookie_grey));

                        image2_.setPadding(0, 7, 0, 7);
                        ll.setMargins(0, 15, 0, 0);
                        image2_.setLayoutParams(ll);
                        image2.setImageDrawable (getResources ().getDrawable (R.drawable.mine));
                        menu.addView(image2_);

                        new_menu.setOnClickListener(this);
                        costi[new_menu.getId()]=tmp1[2];


                    }
                    break;
                case"Luck":
                    //Log.d ("MY","MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
                    required= Integer.parseInt(tmp1[1]);
                    if (number_of_golden_cookie>=required) {
                        if(my_cookie.compareTo(new BigInteger(tmp1[2]))<=0)stop=true;

                        current = tmp1[0];
                        new_menu.setId(Integer.valueOf("6"+String.valueOf(i)));

                        if(stop)image2_.setId(0);
                        new_menu.setBackground(getResources().getDrawable(R.color.dark_background));
                        if(stop)new_menu.setBackground(getResources().getDrawable(R.color.dark_dark_background));

                        title.setText("Golden Luck");
                        title.setTextSize(22);
                        title.setTypeface(font_carter_one);
                        if(stop)title.setTextColor(getResources().getColor(R.color.light_grey));

                        cost.setText(number_to_formatted_string(new BigInteger(tmp1[2])));
                        cost.setTextSize(16);
                        cost.setTypeface(font_carter_one);
                        if(stop)cost.setTextColor(getResources().getColor(R.color.light_grey));

                        from.setText("2x Frequency");
                        from.setTextSize(20);
                        from.setTypeface(font_carter_one);
                        if(stop)from.setTextColor(getResources().getColor(R.color.light_grey));
                        to.setVisibility (View.INVISIBLE);
                        if(stop)cookie_small.setImageDrawable (getResources ().getDrawable (R.drawable.very_small_cookie_grey));

                        image2_.setPadding(0, 7, 0, 7);
                        ll.setMargins(0, 15, 0, 0);
                        image2_.setLayoutParams(ll);
                        image2.setImageDrawable (getResources ().getDrawable (R.drawable.cookie_golden256));
                        if (stop)                        image2.setImageDrawable (getResources ().getDrawable (R.drawable.cookie_golden256_grey));

                        menu.addView(image2_);

                        new_menu.setOnClickListener(this);
                        costi[new_menu.getId()]=tmp1[2];


                    }
                    break;*/

            }
        }

        for (String ed:fatti_fast) {
            Log.d ("MY2","Fatti_fast"+ed);
        }

        for (int j=0;j<how_many_buildings_i_have;j++) {
            if(my_build[j]==0)continue;
            if ( j == 0 ) {
                for (int i = 0; i < cost_multiply_cursor.length; i++) {
                    final int required = Integer.parseInt (required_progress_cursor[i]);
                    if ( my_build[j] < required )break;
                    LinearLayout.LayoutParams ll = new LinearLayout.LayoutParams (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    Typeface font_carter_one = Typeface.createFromAsset (getAssets (), "font/carter_one.ttf");
                    View image2_ = LayoutInflater.from (this).inflate (R.layout.image2, null);
                    final ConstraintLayout new_menu = image2_.findViewById (R.id.new_menu_example);
                    final TextView title = image2_.findViewById (R.id.title2);
                    final TextView cost = image2_.findViewById (R.id.cost);
                    final TextView from = image2_.findViewById (R.id.from);
                    final TextView to = image2_.findViewById (R.id.to);
                    final ImageView cookie_small = image2_.findViewById (R.id.image);
                    final ImageView image2 = image2_.findViewById (R.id.image2);

                    Boolean stop = false;

                    String add_id = String.valueOf (i);
                    if ( i < 10 ) add_id = "0" + add_id;

                    if ( fatti_fast.contains ((String.valueOf (j + 5) + add_id)) )
                        continue;
                    //if (fatti[Integer.valueOf(String.valueOf (j+5)+String.valueOf(i))])continue;

                    String name_image = name_upgrades[j].toLowerCase ().replace (' ', '_');

                    BigInteger cost_now = new BigInteger (base_cost[j]).multiply (new BigInteger (cost_multiply[i]));
                    if ( my_cookie.compareTo (cost_now) <= 0 ) stop = true;

                    Log.d ("MY", (String.valueOf (j + 5) + String.valueOf (i)));

                    new_menu.setId (Integer.valueOf (String.valueOf (j + 5) + add_id));

                    if ( stop ) image2_.setId (0);
                    new_menu.setBackground (getResources ().getDrawable (R.color.dark_background));
                    if ( stop )
                        new_menu.setBackground (getResources ().getDrawable (R.color.dark_dark_background));

                    title.setText (name_upgrades[j] + " Efficiency");
                    title.setTextSize (20);
                    title.setTypeface (font_carter_one);
                    if ( stop )
                        title.setTextColor (getResources ().getColor (R.color.light_grey));

                    cost.setText (number_to_formatted_string (cost_now));
                    cost.setTextSize (16);
                    cost.setTypeface (font_carter_one);
                    if ( stop )
                        cost.setTextColor (getResources ().getColor (R.color.light_grey));

                    from.setText ("2x Power");
                    from.setTextSize (20);
                    from.setTypeface (font_carter_one);
                    if ( stop )
                        from.setTextColor (getResources ().getColor (R.color.light_grey));
                    to.setVisibility (View.INVISIBLE);
                    if ( stop )
                        cookie_small.setImageDrawable (getResources ().getDrawable (R.drawable.very_small_cookie_grey));

                    image2_.setPadding (0, 7, 0, 7);
                    ll.setMargins (0, 15, 0, 0);
                    image2_.setLayoutParams (ll);
                    //image2.setImageDrawable (getResources ().getDrawable (R.drawable.cursor));
                    Context context = image2.getContext ();
                    int id = context.getResources ().getIdentifier (name_image, "drawable", context.getPackageName ());
                    image2.setImageResource (id);

                    menu.addView (image2_);
                    skills.addElement (new_menu.getId ());

                    new_menu.setOnClickListener (this);
                    costi[new_menu.getId ()] = cost_now.toString ();

                }
            }
            else {
                for (int i = 0; i < cost_multiply.length; i++) {
                    final int required = Integer.parseInt (required_progress_cursor[i]);
                    if ( my_build[j] < required )break;
                    LinearLayout.LayoutParams ll = new LinearLayout.LayoutParams (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    Typeface font_carter_one = Typeface.createFromAsset (getAssets (), "font/carter_one.ttf");
                    View image2_ = LayoutInflater.from (this).inflate (R.layout.image2, null);
                    final ConstraintLayout new_menu = image2_.findViewById (R.id.new_menu_example);
                    final TextView title = image2_.findViewById (R.id.title2);
                    final TextView cost = image2_.findViewById (R.id.cost);
                    final TextView from = image2_.findViewById (R.id.from);
                    final TextView to = image2_.findViewById (R.id.to);
                    final ImageView cookie_small = image2_.findViewById (R.id.image);
                    final ImageView image2 = image2_.findViewById (R.id.image2);

                    String add_id = String.valueOf (i);
                    if ( i < 10 ) add_id = "0" + add_id;

                    Boolean stop = false;

                    Log.d ("MY2", "id: "+((String.valueOf (j + 5) + add_id))+"---- bool: "+String.valueOf (fatti_fast.contains ((String.valueOf (j + 5) + add_id))));
                    if ( fatti_fast.contains ((String.valueOf (j + 5) + add_id)) )continue;
                    //if (fatti[Integer.valueOf(String.valueOf (j+5)+String.valueOf(i))])continue;

                    String name_image = name_upgrades[j].toLowerCase ().replace (' ', '_');
                    if ( name_image.equals ("alchemy_lab") ) name_image = "alchemylab";

                    BigInteger cost_now = new BigInteger (base_cost[j]).multiply (new BigInteger (cost_multiply[i]));
                    if ( my_cookie.compareTo (cost_now) <= 0 ) stop = true;

                    Log.d ("MY", (String.valueOf (j + 5) + String.valueOf (i)));
                    new_menu.setId (Integer.valueOf (String.valueOf (j + 5) + add_id));

                    if ( stop ) image2_.setId (0);
                    new_menu.setBackground (getResources ().getDrawable (R.color.dark_background));
                    if ( stop )
                        new_menu.setBackground (getResources ().getDrawable (R.color.dark_dark_background));

                    title.setText (name_upgrades[j] + " Efficiency");
                    title.setTextSize (20);
                    title.setTypeface (font_carter_one);
                    if ( stop )
                        title.setTextColor (getResources ().getColor (R.color.light_grey));

                    cost.setText (number_to_formatted_string (cost_now));
                    cost.setTextSize (16);
                    cost.setTypeface (font_carter_one);
                    if ( stop )
                        cost.setTextColor (getResources ().getColor (R.color.light_grey));

                    from.setText ("2x Power");
                    from.setTextSize (20);
                    from.setTypeface (font_carter_one);
                    if ( stop )
                        from.setTextColor (getResources ().getColor (R.color.light_grey));
                    to.setVisibility (View.INVISIBLE);
                    if ( stop )
                        cookie_small.setImageDrawable (getResources ().getDrawable (R.drawable.very_small_cookie_grey));

                    image2_.setPadding (0, 7, 0, 7);
                    ll.setMargins (0, 15, 0, 0);
                    image2_.setLayoutParams (ll);
                    //image2.setImageDrawable (getResources ().getDrawable (R.drawable.cursor));
                    Context context = image2.getContext ();
                    int id = context.getResources ().getIdentifier (name_image, "drawable", context.getPackageName ());
                    image2.setImageResource (id);

                    menu.addView (image2_);
                    skills.addElement (new_menu.getId ());
                    new_menu.setOnClickListener (this);
                    costi[new_menu.getId ()] = cost_now.toString ();



                }
            }

        }

        builds_give=getIntent ().getStringArrayExtra ("each");



        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save ();
                Intent i = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage( getBaseContext().getPackageName() );
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                trans=false;
                startActivity(i);
                finish();
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right );

            }
        });

        refresh.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                save ();
                Intent i=getIntent ();
                startActivity (i);
                finish ();
            }
        });

        final int fps=Integer.parseInt (getIntent ().getStringExtra ("fps"));

        final int tmp = 1000 / fps;

        cps=new BigDecimal (getIntent ().getStringExtra ("cps"));
        cps_txt.setText (decimal_to_formatted_string (cps)+" cps");
        if (getIntent ().getBooleanExtra ("fancy",false)){
            Typeface type = Typeface.createFromAsset (getAssets (), "font/carter_one.ttf");
            my_cookie_number.setTypeface (type);cps_txt.setTypeface (type);
        }

        //Log.d ("MY",String.valueOf (cps));
        //Log.d ("MY",(getIntent ().getStringExtra ("fps")));
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

                                if ( cps.divide (new BigDecimal (String.valueOf (fps)), RoundingMode.HALF_UP)
                                             .compareTo (new BigDecimal (cps.divide (new BigDecimal (String.valueOf (fps)),RoundingMode.HALF_UP).toBigInteger ().toString ())) == 0 ) {
                                    my_cookie = my_cookie.add ((cps.divide (new BigDecimal (String.valueOf (fps)),RoundingMode.HALF_UP).toBigInteger ()).add (cps_backup.toBigInteger ()));

                                } else {
                                    cps_backup = cps_backup.add ((cps.divide (new BigDecimal (String.valueOf (fps)),RoundingMode.HALF_UP)).subtract (new BigDecimal (cps.divide (new BigDecimal (String.valueOf (fps)),RoundingMode.HALF_UP).toBigInteger ().toString ())));
                                    my_cookie = my_cookie.add ((cps.divide (new BigDecimal (String.valueOf (fps)),RoundingMode.HALF_UP).toBigInteger ()).add (cps_backup.toBigInteger ()));
                                    cps_backup = cps_backup.subtract (new BigDecimal (cps_backup.toBigInteger ().toString ()));
                                }

                                my_cookie_number.setText (number_to_formatted_string (my_cookie) + " Cookies");

                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };
        thread.start ();


    }


    @Override
    public void onClick(final View v) {

        if (v.getId()==0){
            Toast.makeText(getApplicationContext(),"You don't have enough cookie!",Toast.LENGTH_SHORT).show();
            return;
        }

        //tolgo gli ultimi due caratteri dall'id originale
        int my_id=Integer.parseInt(String.valueOf(String.valueOf(v.getId()).substring (0,String.valueOf (v.getId ()).length ()-2)));
        my_cookie=my_cookie.subtract(new BigInteger(costi[v.getId()]));

        //SAVE COOKIE
        save ();

        boolean offline=false;
        switch (my_id){
            default:
                Toast.makeText (getApplicationContext (),String.valueOf (v.getId ()),Toast.LENGTH_SHORT).show ();
                save_upgrade (String.valueOf (my_id));
                break;
            case 1:
                save_upgrade("1-"+percentuale[v.getId()]);
                offline=true;
                break;
            case 2:
                save_upgrade("2");
                break;
            case 3:
                save_upgrade("3");
                break;
            case 4:
                save_upgrade("4");
                break;


        }



        fatti_fast.add (String.valueOf (v.getId ()));

        for (String ed:fatti_fast) {
            Log.d ("MY2","Fatti_fast"+ed);
        }

        ////////////  SALVO FATTI_FAST  ///////////////////
        String write="";
        for(int j=0;j<fatti_fast.size ();j++){
            write+=fatti_fast.elementAt (j)+"-";
        }
        write=write.substring (0,write.length ()-1);
        //Log.d ("MY3",write);

        try {
            String FILENAME = "upgrade_done";
            FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
            fos.write(write.getBytes());
            fos.close();
        } catch (IOException ed) {Log.e("ERROR", ed.toString());}
        //////////////////////////////////////////////////

        final TextView my_cookie_number=findViewById (R.id.number_of_my_cookie_skill);
        final TextView cps_txt=findViewById (R.id.cps_txt2);

       /* try {
            String FILENAME = "cookie";
            byte[] bytes = new byte[1024];
            FileInputStream fis = openFileInput(FILENAME);
            fis.read(bytes);
            fis.close();
            String string = new String(bytes);
            //Log.d ("MY",string.trim ());
            String[] cookie=string.split("-");
            my_cookie=new BigInteger(cookie[0]);
            my_cookie_number.setText(number_to_formatted_string(my_cookie)+" Cookies");
            for(int i=0;i<how_many_buildings_i_have;i++)my_build[i]=Integer.parseInt (cookie[i+1].trim ());
        } catch (IOException e) {}*/

        v.setVisibility (View.GONE);
        /*
        Intent intent = getIntent();
        finish();
        startActivity(intent);
*/
       /* long buildings_multiply[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        try {
            String FILENAME = "upgrade1";
            byte[] bytes = new byte[1024];
            FileInputStream fis = openFileInput (FILENAME);
            fis.read (bytes);
            fis.close ();
            String leggo = new String (bytes);

            if ( !leggo.trim ().equals ("") ) {
                String tmp1[] = leggo.split ("/");
                for (int i = 0; i < tmp1.length - 1; i++)if ( !tmp1[i].contains ("-") )buildings_multiply[Integer.parseInt (tmp1[i].trim ()) - 5] *= 2;
            }
        } catch (IOException e) { }*/

        final ConstraintLayout menu=findViewById (R.id.menu_upgrade2);
        final LinearLayout menu2=findViewById (R.id.menu_upgrade);
        final ScrollView menu3=findViewById (R.id.last_menu);
        BigDecimal cps_tmp=cps;
        //cps=new BigDecimal ("0");
        //for(int i=0;i<how_many_buildings_i_have;i++)cps = cps.add (BigDecimal.valueOf (my_build[i]).multiply (initial_give[i]).multiply (BigDecimal.valueOf (buildings_multiply[i])));


       /* v.animate ().translationXBy (-x_max).setInterpolator (new PowInterpolator (1.7f)).setDuration (400).withEndAction (new Runnable () {
            @Override
            public void run () {
                for (int i=skills.indexOf (v.getId ());i<skills.size ();i++) {
                    View v2 = findViewById (skills.elementAt (i));
                    v2.animate ().translationYBy (-v.getHeight ()).setInterpolator (new PowInterpolator (1.7f)).start ();
                }
            }
        });*/

        if(!offline)builds_give[my_id-5]=new BigDecimal (builds_give[my_id-5]).multiply (new BigDecimal ("2")).toString ();
        cps=new BigDecimal ("0");
        if(!offline)for(String lol:builds_give)cps=cps.add (new BigDecimal (lol));


        BigDecimal difference=cps.subtract (cps_tmp),
                percent=new BigDecimal ("0");
        cps_txt.setText (decimal_to_formatted_string (cps)+" cps");
        if(!offline)percent=difference.divide (cps_tmp,2,RoundingMode.HALF_UP).multiply (new BigDecimal ("100"));

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        final int x_max=size.x,y_max=size.y;
        final TextView textView = new TextView (getApplicationContext ());
        textView.setX (x_max/2);
        final ScrollView last_menu=findViewById (R.id.last_menu);
        textView.setY (v.getY ()+menu2.getY()+menu3.getY ()-last_menu.getScrollY ());
        String tmp_testo="+" + decimal_to_formatted_string (difference)+" cps";
        String tmp_testo2=percent.toPlainString ()+"%";
        int space=0;
        if (tmp_testo.length ()-tmp_testo2.length ()>0)space=(tmp_testo.length ()-tmp_testo2.length ())/2;
        for(int i=0;i<space;i++){
            tmp_testo2=" "+tmp_testo2;
            tmp_testo2+=" ";
        }
        textView.setText (tmp_testo+"\n"+tmp_testo2);
        if ( offline )textView.setText (String.valueOf (percentuale[v.getId()])+"%");
        int size_random = (int) (Math.random () * 11) + 24;
        if(!offline)size_random=(int)(Float.valueOf (percent.toString ())/4+10);
        if ( size_random>36 )size_random=36;
        textView.setTextSize (size_random);
        Typeface type = Typeface.createFromAsset (getAssets (), "font/komikax.ttf");
        textView.setTypeface (type);
        menu.addView (textView);
        textView.setTextColor (new Color ().rgb (230, 230, 230));

        MyBounceInterpolator interpolator = new MyBounceInterpolator (0.55, 16*(textView.getY ()*4)/1200);
        textView.animate ()
                .translationY (0)
                .alpha (0f) //float value
                .setDuration ((long)textView.getY ()*4L)
                .setListener (new AnimatorListenerAdapter () {
                    public void onAnimationEnd (Animator animation) {menu.removeView (textView);}
                })
                .start ();

        textView.animate ()
                .translationX (textView.getX ()-50f)
                .setDuration ((long)textView.getY ()*4L + 300).setInterpolator (interpolator)
                .start ();

    }







    @Override
    protected void onPause() {
        if (trans) {
            overridePendingTransition(R.anim.stop_transition,R.anim.slide_out_right );
        }
        super.onPause();
    }
    @Override
    protected void onResume() {
        super.onResume();
        trans=true;
    }
}

