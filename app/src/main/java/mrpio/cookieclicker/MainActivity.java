package mrpio.cookieclicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.constraint.ConstraintLayout;
import android.os.Bundle;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.*;

import android.os.Vibrator;
import java.text.SimpleDateFormat;
import java.util.Date;


import static java.lang.System.currentTimeMillis;
import static java.lang.System.nanoTime;


public class MainActivity extends AppCompatActivity {

    public static long ntime=nanoTime ();
    public static long mtime=currentTimeMillis ();

    /*============================================================================
    ============================================================================
    ============================================================================
                                    <DA FARE>:

        AGGIUSTARE I CPS (FORMATTED E BIG INTEGER)

    ============================================================================
    ============================================================================
    ============================================================================*/



    /*============================================================================
                                    VARIABLES
    ============================================================================*/
    public static BigInteger my_cookie = new BigInteger ("0");
    BigInteger my_cps_cookie = new BigInteger ("0");
    public static BigDecimal cps = new BigDecimal ("0");
    public static int how_many_buildings_i_have=15;
    public static int my_build[]=new int[20];
    public static String skill_avaible[]={
            "Auto Click-Perform 50 clicks in 2 seconds!-12000-50-4-10",
            "Click Boost-Click power x15 for 15 seconds!-65000-15-15-80",
            "Luck+-Golden cookie will appear 8 time more often for 60 seconds!-175000-8-60-250",
            "Golden Bar-How many time for the next Golden Cookie?-115000"
    };
    public static String[] root = {"M", "B", "T", "q", "Q", "s", "S", "O", "N", "d", "U", "D",};
    public static String[]name_upgrades="Cursor-Grandma-Farm-Mine-Factory-Bank-Temple-Wizard Tower-Shipment-Alchemy Lab-Portal-Time Machine-Antimatter Condenser-Prism-Chancemaker".split ("-");
    public static String TAG="MY";
    public static short active_activity=0;
    public static ConstraintLayout skill_menu=null;
    public static ConstraintLayout upgrade_menu=null;
    public static boolean production777=false;
    public static int multiply_production=1;
    public static int click_multiply_production=1;
    public static int click_plus_percent_cps=0;
    public static TextView cps_txt=null,number_of_cookie=null;
    public static ImageView golden_aura=null;
    public static ConstraintLayout menu=null;
    public static ProgressBar effect_bar=null;
    public static int skill_pressed=1;
    public static int critical_click_power=1;//  x/100
    public static BigInteger my_cookie_clicked=new BigInteger ("0");
    public static BigInteger my_offline_cookie=new BigInteger ("0");
    public static BigInteger my_builds_cost=new BigInteger ("0");
    public static BigInteger my_upgrades_cost=new BigInteger ("0");
    ConstraintLayout menu_builds_milk=null;
    ConstraintLayout settings_menu=null;


    boolean skills[]=new boolean[10];
    public static ImageView button=null;
    public static ImageView bg_dark[]=new ImageView[15]; public static ImageView bg_dark2[]=new ImageView[15];
    private boolean trans=true;
    BigDecimal cps_backup = new BigDecimal ("0");
    long buildings_multiply[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    double offline_production_rate = 0.1;
    int offline_production_hours=6;
    short fps=20;
    int graphic=1;
    short window_to_transition=1;
    int vibration_length=100;
    boolean original_cookie=false;
    boolean universal[]=new  boolean[10];
    boolean[] effect={true,true,true,true,true};
    public static int golden_cookie_appear=1;
    public static long number_of_golden_cookie=0;
    public static long number_of_critical_click=0;
                  int  critical_chance=0;
    public static int x_max=0,y_max=0;    public static float dpheight=0f,dpwidth=0f;
    public boolean animation1=false;
    public static boolean seven_production=false;
    public static boolean seven_production2=false;
    TextView buildings[]=new TextView[20];
    TextView buildings2[]=new TextView[20];
    public static int golden_cookie_time_to_wait,im_waiting;
    public static int golden_cookie_velocity=1;
    boolean reinitialize_golden_timer=false;
    public static boolean thread_golden_is_running=false;
    Vector <String>fatti_fast=new Vector<String> ();
    String[]base_cost="100-1000-11000-120000-1300000-14000000-200000000-3300000000-51000000000-750000000000-10000000000000-140000000000000-1700000000000000-21000000000000000-260000000000000000".split ("-");
    String[]cost_multiply="1-5-10-100-100-100-1000-1000-1000-1000-10000".split ("-");
    String[]cost_multiply_cursor="1-5-20-10-100-10-10-10-1000-1000-1000-1000".split ("-");
    String[]required_progress="1-5-25-50-100-150-200-250-300-350-400".split ("-");
    String[]required_progress_cursor="1-1-5-25-50-100-150-200-250-300-350-400".split ("-");
    String[]costi=new String[2500];
    String[]costi2=new String[1000];
    Vector<String>costi_fast=new Vector <> ();
    Vector<String>costi_fast2=new Vector <> ();
    Vector<Integer>upgrade_button=new Vector <> ();
    Vector<String>costi_fast_skill=new Vector <> ();
    String[] costi_skill=new String[99];
    String builds_give[]=new String[15];
    ConstraintLayout menu_upgrade=null;
    ConstraintLayout menu_skill_laterale=null;
    ConstraintLayout menu_statistics=null;
    LinearLayout statistics_list=null;
    public static Vector<String> skill_done=new Vector <> ();
    Vector<Integer> skills2=new Vector <> ();
    Vector<Integer> skills3=new Vector <> ();
    LinearLayout menu_skill[]=new LinearLayout[15];
    LinearLayout menu_skill2=null;
    int skill_max;
    int skill_added=0;
    int passo=0;
    int skill_counting=0;int upgrade_counting=0,upgrade_counting2=0;
    LinearLayout list_upgrade=null;
    LinearLayout list_upgrade2=null;
    MediaPlayer mPlayer=null;
    ImageView loading_bar=null;
    float loading=0f;
    int loading_default_width=0;int loading_default_height=0;
    String cookie_earned_in_pause="";
    int upgrade_tab_count=2;
    int upgrade_current_tab=1;
    int offline_base_rate=10;
    boolean first_toast_shown=false;
    Intent service_gold=null;
    ScrollView last_menu2=null;
    ScrollView last_menu=null;
    Vector stats_values=new Vector ();
    boolean nothing_to_show_box=false;
    boolean nothing_to_show_box2=false;
    float scroll_percent=0.28f;
    int setting_scelta=1;
    String listItemArr[] = {"75","100","150","250","500"};

    //STUFF
    boolean su=false;
    public static boolean multy_directions=false;
    int angolo=0;
    //OPTIONS
    public static Boolean Random_click_color=false,vibrate = false;
    float bounce_effect = 1;
    boolean fancy_font=false;
    public static long golden_cookie_time=4;


    //int my_cursor, my_grandma, my_farm, my_mine;

    BigInteger cookie_click_add = new BigInteger ("1000");
    BigInteger[] initial_cost = {
            new BigInteger ("15"),
            new BigInteger ("100"),
            new BigInteger ("1100"),
            new BigInteger ("12000"),
            new BigInteger ("130000"),
            new BigInteger ("1400000"),
            new BigInteger ("20000000"),
            new BigInteger ("330000000"),
            new BigInteger ("5100000000"),
            new BigInteger ("75000000000"),
            new BigInteger ("1000000000000"),
            new BigInteger ("14000000000000"),
            new BigInteger ("170000000000000"),
            new BigInteger ("2100000000000000"),
            new BigInteger ("26000000000000000")};
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
    String upgrade2[][]= {(
            "1/Offline Prod 6h/1000/5-"
            + "1/Offline Prod 6h/10000/5-"
            + "1/Offline Prod 6h/80000/5-"
            + "1/Offline Prod 12h/500000/10-"
            + "1/Offline Prod 12h/5000000/5-"
            + "1/Offline Prod 12h/50000000/5-"
            + "1/Offline Prod 24h/1000000000/10-"
            + "1/Offline Prod 24h/4000000000/5-"
            + "1/Offline Prod 24h/50000000000/5").split ("-"),

            ("2/Lucky day/7/777778000000-"
             + "2/Serendipity/27/77778000000000-"
             + "2/Get lucky/77/77778000000000000").split ("-"),

            ("3/Plastic mouse/1000-"
             + "3/Iron mouse/100000-"
             + "3/Titanium mouse/10000000-"
             + "3/Adamantium mouse/1000000000-"
             + "3/Unobtainium mouse/100000000000-"
             + "3/Eludium mouse/10000000000000-"
             + "3/Wishalloy mouse/1000000000000000-"
             + "3/Fantasteel mouse/100000000000000000-"
             + "3/Nevercrack mouse/10000000000000000000-"
             + "3/Armythril mouse/1000000000000000000000-"
             + "3/Technobsidian mouse/100000000000000000000000-"
             + "3/Plasmarble mouse/10000000000000000000000000").split ("-"),

            ("4/Very soft click/7/1000/1-"
             + "4/Soft click/18/10000/1-"
             + "4/Firm click/37/80000/1-"
             + "4/Strong click/67/500000/1-"
             + "4/Aggressive click/150/5000000/2-").split ("-")
    };
    BigInteger[] now_cost=new BigInteger[initial_cost.length];
    String[] now_number_of=new String[20];
    Vector<ImageView>upgrade_gray=new Vector <> ();
    Vector<ImageView>upgrade_gray2=new Vector <> ();
    Vector<ImageView>skill_gray=new Vector <> ();
    Vector<Integer>seed_id=new Vector <> ();
    Vector<Integer>seed_id2=new Vector <> ();
    Vector<View>info_bg=new Vector <> ();
    TextView info_bottom1[]=new TextView [15];
    Vector<View>info_bottom2=new Vector <> ();
    Vector<TextView>info_percent=new Vector <> ();
    Vector<ImageView>info_color_bg=new Vector <> ();
    Vector<View>info_title=new Vector <> ();
    Vector<Integer>seed_builds=new Vector <> ();
    String builds_given[]=new String[16];
    int wait_till_upgrade_buy=0;
    int wait_till_build_gave_update=0;
    //stats
    TextView stat_my_cookie=null,
            stat_hand_made=null,
            stat_build_cookie=null,
            stat_offline_cookie=null,
            stat_builds_cost=null,
            stat_upgrades_cost=null,
            stat_click_power=null,
            stat_critical_click=null,
            stat_offline_time=null,
            stat_critical_chance=null,
            stat_game_start=null,
            stat_time_game=null;
    public static TextView stat_golden_click=null;
    int showed_upgrades[]=new int[24];
    boolean stat_update=false;
    String saving_text="";
    int how_many_save_file_i_have=1;
    int current_save_file=1;
    
    

    /*============================================================================
                                    FUNCTIONS
    ============================================================================*/
    public void save () {
        String txt = my_cookie.toString ();
        String builds_given2="";
        for (int i=0;i<how_many_buildings_i_have;i++)txt+="-"+String.valueOf (my_build[i]); //how many builds i have?
        for(int i=0;i<how_many_buildings_i_have;i++)builds_given2+=builds_given[i]+"-";     //builds_given
        long date_now = System.currentTimeMillis ();


        save_txt ("cookie",txt);
        save_txt ("date",String.valueOf (date_now));
        save_txt ("cookie_clicked",my_cookie_clicked.toString ());
        save_txt ("critical_click",String.valueOf (number_of_critical_click));
        save_txt ("offline_cookie",my_offline_cookie.toString ());
        save_txt ("builds_cost",my_builds_cost.toString ());
        save_txt ("upgrades_cost",my_upgrades_cost.toString ());
        save_txt ("builds_given",builds_given2);
        @SuppressLint ("SimpleDateFormat") SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        if(read_txt ("date_start").contentEquals (""))save_txt("date_start",String.valueOf (formatter.format(date)));
        if(read_txt ("game_start").contentEquals (""))save_txt ("game_start",String.valueOf (System.currentTimeMillis ()));
        //UPDATE READING SYSTEM

        /*saving_text=saving_text.substring(0,saving_text.length ()-1);
        Log.e ("MY7","Saving...\t"+"save"+String.valueOf (current_save_file)+"\tValue:  "+saving_text);     //Log.e
        save_txt ("save"+String.valueOf (current_save_file),saving_text);*/
    }
    void reset_progress () {
        try {
            String FILENAME = "cookie";
            String string = ("0");
            for (int i=0;i<how_many_buildings_i_have;i++)string+="-0";

            FileOutputStream fos = openFileOutput (FILENAME, Context.MODE_PRIVATE);
            fos.write (string.getBytes ());
            fos.close ();

        } catch (IOException e) {
            Log.e ("ERROR", e.toString ());
        }
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        save_txt ("date_start",String.valueOf (formatter.format(date)));
        save_txt ("game_start",String.valueOf (System.currentTimeMillis ()));
        save_txt ("my_cps_cookie",my_cps_cookie.toString ());
        save_txt ("cookie_clicked","0");
        save_txt ("critical_click","0");
        save_txt("offline_cookie","0");
        save_txt ("golden_num","0");
        save_txt ("builds_cost","0");
        save_txt ("upgrades_cost","0");
        String builds_given2="";
        for(int i=0;i<how_many_buildings_i_have;i++)builds_given2+="0-";
        save_txt ("builds_given",builds_given2);
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
    void log(Object txt){
        Log.d ("MY",String.valueOf (txt));
    }
    void add_to_save(String name,String value){
        saving_text+=name+"<"+value+">";
    }
    void reset_upgrade () {
        save_txt ("upgrade1","");
        save_txt ("upgrade_done","");
        save_txt ("upgrade_tab2","");
    }
    void toast (String txt) {
        //Just for debug
        Toast.makeText (getApplicationContext (), txt, Toast.LENGTH_SHORT).show ();
    }
    public static String number_to_formatted_string (BigInteger num) {
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
    public static String decimal_to_formatted_string (BigDecimal num) {
        if(num.toString ().equals (num.toBigInteger ().toString ()))return number_to_formatted_string (num.toBigInteger ());
        String str = num.toBigInteger ().toString ();
        int position;
        position = str.length () / 3;
        if ( str.length () - position * 3 != 0 ) ++position;
        if ( position > 2 ) {
            int scart = position - 2;
            str = str.substring (0, str.length () - (3 * scart));
            str = String.format ("%,d", Integer.parseInt (str)) + " " + root[scart - 1];
        } else {
            String tmp=num.subtract (new BigDecimal (num.toBigInteger ().toString ())).toString (); //make it<0
            //Log.d ("MY","num: "+num.toString ()+"\ttmp: "+tmp.toString ());
            if(Integer.parseInt (tmp.substring (2,tmp.length ()))==0)tmp="";
            else tmp=","+tmp.substring (2,tmp.length ());

            str = String.format ("%,d", Integer.parseInt (str))+tmp;
        }

        return str;
    }
    void reset_setting(){
        String txt=String.valueOf(false)+"-"+String.valueOf(1)+"-"+
                   String.valueOf(false)+"-"+String.valueOf(1)+"-"+String.valueOf(20)+
                   "-"+String.valueOf (false)+"-100-1101";
        try {
            String FILENAME = "settings";
            FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
            fos.write(txt.getBytes());
            fos.close();
        } catch (IOException ed) {
            Log.e("ERROR", ed.toString());
        }

    }
    void reset_skill(){
        save_txt ("skill","");
        save_txt ("skill_done","");
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
    void load_progress(float percent){
        loading_bar.setLayoutParams (new ConstraintLayout.LayoutParams((int)(loading_default_width * percent),loading_bar.getHeight ()));
        Log.e("MY8","BarValue:---->\t"+String.valueOf ((int)(loading_default_width * percent)));
    }
    String seconds_to_string(long second_to_earn){
        if ( second_to_earn > 86400 )
            return String.valueOf ((int) (second_to_earn / 86400)) + "g " +
                   String.valueOf ((int) (second_to_earn - ((int) (second_to_earn / 86400) * 86400)) / 3600) + "h " +
                   String.valueOf ((int) (second_to_earn - ((int) (second_to_earn / 3600) * 3600)) / 60) + "m " +
                   String.valueOf ((int) (second_to_earn - ((int) (second_to_earn / 60) * 60))) + "s";
        else if ( second_to_earn > 3600 )
            return String.valueOf ((int) (second_to_earn - ((int) (second_to_earn / 86400) * 86400)) / 3600) + "h " +
                   String.valueOf ((int) (second_to_earn - ((int) (second_to_earn / 3600) * 3600)) / 60) + "m " +
                   String.valueOf ((int) (second_to_earn - ((int) (second_to_earn / 60) * 60))) + "s";
        else if ( second_to_earn > 60 )
            return String.valueOf ((int) (second_to_earn - ((int) (second_to_earn / 3600) * 3600)) / 60) + "m " +
                   String.valueOf ((int) (second_to_earn - ((int) (second_to_earn / 60) * 60))) + "s";
        else
            return String.valueOf ((int) (second_to_earn - ((int) (second_to_earn / 60) * 60))) + "s";
    }
    String bool_to_string(boolean give[]){
        String l="";
        for (int i=0;i<give.length;i++){
            if (give[i]){
                l+="1";
            }
            else l+="0";
        }
        return l;
    }
    /*===========================================================================
                                    START
    ============================================================================*/

    @SuppressLint ("ClickableViewAccessibility")
    @Override
    public void onCreate (final Bundle savedInstanceState) {
        Log.e ("MY6","1---> "+String.valueOf (currentTimeMillis() - mtime     +"---> "+String.valueOf (nanoTime () - ntime)));
        //TODO onCreate
        super.onCreate (savedInstanceState);
        //overridePendingTransition (R.anim.transition_upgrade_exit,R.anim.stop_transition);
        // remove title

        requestWindowFeature (Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow ().setFlags (WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView (R.layout.activity_main);
        getWindow ().getDecorView ().setSystemUiVisibility (
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);


        button = (ImageView) findViewById (R.id.imageView);
        final ImageView sparkle = (ImageView) findViewById (R.id.sparkles);
        final Animation myAnim = AnimationUtils.loadAnimation (this, R.anim.bounce);
        final Animation rotation = AnimationUtils.loadAnimation (this, R.anim.rotation);
        final Animation rotation_small_cookie = AnimationUtils.loadAnimation (this, R.anim.rotation_small_cookie);
        final ImageView bg=findViewById (R.id.bg);
        final ImageView exit = (ImageView) findViewById (R.id.exit);
        cps_txt = (TextView) findViewById (R.id.cps_txt);
        number_of_cookie = (TextView) findViewById (R.id.number_of_my_cookie);
        /*final ImageView Cursor = (ImageView) findViewById (R.id.cursor);
        final TextView number_of_cursor = (TextView) findViewById (R.id.number_cursor);
        final TextView cursor_cost = (TextView) findViewById (R.id.cursor_cost);
        final ImageView Grandma = (ImageView) findViewById (R.id.grandma);
        final TextView number_of_grandma = (TextView) findViewById (R.id.number_grandma);
        final TextView grandma_cost = (TextView) findViewById (R.id.grandma_cost);
        final ImageView Farm = (ImageView) findViewById (R.id.farm);
        final TextView number_of_farm = (TextView) findViewById (R.id.number_farm);
        final TextView farm_cost = (TextView) findViewById (R.id.farm_cost);
        final ImageView Mine = (ImageView) findViewById (R.id.mine);
        final TextView number_of_mine = (TextView) findViewById (R.id.number_mine);
        final TextView mine_cost = (TextView) findViewById (R.id.mine_cost);*/
        menu = (ConstraintLayout) findViewById (R.id.constraint_menu);
        final ConstraintLayout menu_button = (ConstraintLayout) findViewById (R.id.contenitore_button);
        final ScrollView menu_buildings = findViewById (R.id.buildings_menu);
        final ImageView upgrade = findViewById (R.id.upgrade);
        final TextView offline_txt=findViewById (R.id.offline_txt);
        final ImageView exit2=findViewById (R.id.exit2);
        //final ConstraintLayout menu2=findViewById (R.id.menu2);
        final ImageView eye_animation=findViewById (R.id.eye_animation);
        final LinearLayout menu2_buildings=findViewById (R.id.menu_build);
        golden_aura=findViewById (R.id.golden_aura);
        effect_bar=findViewById (R.id.effect_bar);
        final ImageView skill=findViewById (R.id.skill);
        final ScrollView menu_skill_scrollview=findViewById (R.id.menu_skill_scrollview);
        final ImageView upgrade_right_arrow=findViewById (R.id.arrow_right);
        final ImageView upgrade_left_arrow=findViewById (R.id.arrow_left);
        last_menu2=findViewById (R.id.last_menu2);
        last_menu=findViewById (R.id.last_menu);
        menu_statistics=findViewById (R.id.statistics);
        statistics_list=findViewById (R.id.statistics_list_menu);
        menu_skill2=findViewById (R.id.menu_skill2);
        menu_upgrade =findViewById (R.id.menu_upgrade2);
        service_gold=new Intent(getBaseContext(), service.class);
        final TextView exit_upgrade=findViewById(R.id.exit_skill);
        list_upgrade=findViewById(R.id.menu_upgrade);
        list_upgrade2=findViewById(R.id.menu_upgrade2tab);
        final ImageView refresh=findViewById (R.id.refresh);
        final ScrollView upgrade_scroll=findViewById (R.id.last_menu);
        menu_skill_laterale=findViewById (R.id.menu_skill3);
        final LinearLayout menu_skill4=findViewById (R.id.menu_skill4);
        final ConstraintLayout splash=findViewById (R.id.splash_screen);
        loading_bar=findViewById (R.id.progress_bar);
        final ImageView stats_button=findViewById (R.id.statistic);
        final TextView stat_close=findViewById (R.id.stat_close);
        final ImageView milk1=findViewById (R.id.milk1);
        final ImageView milk2=findViewById (R.id.milk2);
        final ConstraintLayout milk=findViewById (R.id.milk);
        menu_builds_milk=findViewById (R.id.menu_builds_milk);
        //Settings menu
        settings_menu=findViewById (R.id.menu_settings);
        final TextView settings_exit =(TextView)findViewById(R.id.settings_exit);
        final ImageView save_name =(ImageView)findViewById(R.id.save_name);
        final EditText nickname=(EditText)findViewById(R.id.nickname);
        final Switch coloured_clicks=(Switch)findViewById(R.id.coloured_clicks);
        final Button reset_pregress_button =(Button)findViewById(R.id.reset_all);
        final Button save_exit =(Button)findViewById(R.id.save_and_exit);
        final SeekBar bounce_effect_bar =(SeekBar)findViewById(R.id.bounce_effect_bar);
        final Switch fancy_text =(Switch)findViewById(R.id.fancy_text) ;
        final Button default_settings =findViewById(R.id.default_setting);
        final SeekBar graphic_bar=findViewById (R.id.graphic_bar);
        final SeekBar fps_bar=findViewById (R.id.fps_bar);
        final TextView fps_txt=findViewById (R.id.fps_txt);
        final Switch click_vibration=findViewById (R.id.click_vibration);
        final ImageView vibration_settings=findViewById (R.id.vibration_settings);
        final Switch click_effect=findViewById (R.id.click_effect);
        final ImageView effect_settings=findViewById (R.id.effect_settings);
        final Switch original_cookie=findViewById (R.id.original_cookie);

        Log.e ("MY6","2---> "+String.valueOf (currentTimeMillis() - mtime     +"---> "+String.valueOf (nanoTime () - ntime)));
        //reset_progress ();
        //reset_upgrade ();

        nickname.setClickable(false);
        nickname.setCursorVisible(false);
        nickname.setFocusable(false);
        nickname.setFocusableInTouchMode(false);

        splash.setVisibility (View.VISIBLE);
        loading_default_width=loading_bar.getLayoutParams ().width;
        loading_default_height=loading_bar.getLayoutParams ().height;
        load_progress (0f);
        menu_upgrade.setVisibility (View.VISIBLE);
        menu_skill_laterale.setVisibility (View.VISIBLE);


        Drawable progressDrawable = effect_bar.getProgressDrawable().mutate();
        progressDrawable.setColorFilter(getResources ().getColor (R.color.gold), android.graphics.PorterDuff.Mode.SRC_IN);
        effect_bar.setProgressDrawable(progressDrawable);
        System.arraycopy (initial_cost,0,now_cost,0,initial_cost.length);

        rotation.setInterpolator (null);
        Arrays.fill(now_number_of,"0");
        Arrays.fill(skills,false);
        thread_golden_is_running=Boolean.valueOf (read_txt ("thread1"));
        Arrays.fill (showed_upgrades,0);

        if(!read_txt ("nickname").equals (""))nickname.setText (read_txt ("nickname"));

        String settings_tmp=read_txt ("settings");
        log ("Settings_tmp"+settings_tmp);
        if(!settings_tmp.equals("")) {
            if (settings_tmp.split("-").length<4)settings_tmp+="-0-0-0-0-0";
            String[] leggo2 = settings_tmp.split("-");
            coloured_clicks.setChecked(Boolean.valueOf(leggo2[0]));
            bounce_effect_bar.setProgress(Integer.parseInt(leggo2[1]));
            fancy_text.setChecked(Boolean.valueOf(leggo2[2]));
            graphic_bar.setProgress(Integer.parseInt(leggo2[3]));
            fps_bar.setProgress ((Integer.parseInt (leggo2[4])-10)/5);
            fps_txt.setText("Fps: "+String.valueOf (fps_bar.getProgress ()*5+10)+"fps");
            click_vibration.setChecked (Boolean.valueOf (leggo2[5]));
            setting_scelta=Integer.parseInt (leggo2[6].trim ());
            boolean tmp=false;
            for (int i=0;i<leggo2[7].trim ().length ();i++){effect[i]= (leggo2[7].charAt (i))!='0';tmp=true;}
            if (!tmp)click_effect.setChecked (false);
            if ( leggo2.length>=9 )original_cookie.setChecked (Boolean.valueOf (leggo2[8]));

        }


        //RESIZE////////////////////////////////////////////
        //TODO Display
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        x_max=size.x;
        y_max=size.y;

        final Display displa1 = getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics ();
        display.getMetrics(outMetrics);

        float density  = getResources().getDisplayMetrics().density;
        dpheight = outMetrics.heightPixels / density;
        dpwidth  = outMetrics.widthPixels / density;

        float scale_factor=dpheight/592f;
        ConstraintLayout.LayoutParams lp = (ConstraintLayout.LayoutParams) button.getLayoutParams();
        lp.height = (int)((float)lp.height * scale_factor);
        lp.width=(int)((float)lp.width * scale_factor);
        button.setLayoutParams(lp);

        lp = (ConstraintLayout.LayoutParams) sparkle.getLayoutParams();
        lp.height = (int)((float)lp.height * scale_factor);
        lp.width=(int)((float)lp.width * scale_factor);
        sparkle.setLayoutParams(lp);
        number_of_cookie.setTextSize (36*scale_factor);

        ///////////////////////////////////////////////////592 360

        menu_upgrade.setTranslationX (x_max);
        menu_skill_laterale.setTranslationX (-x_max);
        menu_statistics.setTranslationY (-y_max-250f);
        menu_statistics.setVisibility (View.VISIBLE);
        //menu_buildings.setTranslationY (y_max+200f);
        milk2.setTranslationX (-x_max);
        settings_menu.setTranslationX (x_max);
        settings_menu.setVisibility (View.VISIBLE);
        last_menu2.setTranslationX (x_max+100);
        last_menu2.setVisibility (View.VISIBLE);

        String er = read_txt ("save_or_reset");
        if (er.length ()>1) {
            if ( er.charAt (0) == '1' ) reset_progress ();
            if ( er.charAt (1) == '1' ) {
                reset_upgrade ();
                reset_skill ();
            }
            if ( er.charAt (2) == '1' ) reset_setting ();
            if ( !er.equals ("000") ) {
                save_txt ("save_or_reset","000");
                Intent intent = getIntent ();
                finish ();
                startActivity (intent);
            }
        }

            //READING UPDATES (OFFLINE AND BUILD UPGRADES)

            String leggo5 = read_txt ("upgrade1");
            Log.d("MY2","Upgrade1: "+leggo5.trim ());
            if ( !leggo5.trim ().equals ("") ) {
                String tmp1[] = leggo5.split ("/");
                for (int i = 0; i < tmp1.length - 1; i++) {

                    if ( tmp1[i].contains ("-") ) {
                        String tmp[] = tmp1[i].split ("-");
                        switch (tmp[0]) {
                            case "1":
                                offline_production_rate = Double.valueOf (tmp[1].trim ()) / 100d;
                                offline_txt.setText("Offline: "+String.valueOf ((int) (offline_production_rate*100d))+"%");
                        }

                    } else {
                        if (Integer.parseInt (tmp1[i].trim ()) - 5>=0)
                        buildings_multiply[Integer.parseInt (tmp1[i].trim ()) - 5] *= 2;
                        if ( Integer.parseInt (tmp1[i].trim ()) == 5 )
                            cookie_click_add = cookie_click_add.multiply (new BigInteger ("2"));

                    }
                }


            }



        try {
            byte[] bytes = new byte[128];
            FileInputStream fis = openFileInput ("golden_num");
            fis.read (bytes);
            fis.close ();
            String leggo2 = new String (bytes);
            number_of_golden_cookie=Long.parseLong (leggo2.trim ());
        }
        catch (IOException e){
            try {
                FileOutputStream fos = openFileOutput ("golden_num", Context.MODE_PRIVATE);
                fos.write ("0".getBytes ());
                fos.close ();
            }
            catch (IOException e1){}
        }


        /*==================================================================
        Import save if it exists else it creates it
         ==================================================================*/

        if(cps.compareTo (new BigDecimal ("0"))==0) {
            try {
                String FILENAME = "cookie";
                byte[] bytes = new byte[1024];
                FileInputStream fis = openFileInput (FILENAME);
                fis.read (bytes);
                fis.close ();
                String string = new String (bytes);

                if ( string.charAt (0) == '-' ) string = string.substring (1, string.length ());
                String[] cookie = string.split ("-");

                Arrays.fill (my_build,0);
                if ( cookie.length >= how_many_buildings_i_have ) {
                    for (int i = 0; i < how_many_buildings_i_have; i++) {
                        my_build[i] = Integer.parseInt (cookie[i + 1].trim ());
                        now_cost[i] = (((new BigDecimal (initial_cost[i].toString ()).multiply (new BigDecimal (String.valueOf ((Math.pow (1.15, my_build[i])))))).toBigInteger ()));

                        now_number_of[i] = String.valueOf (my_build[i]);
                        cps = cps.add (BigDecimal.valueOf (my_build[i]).multiply (initial_give[i]).multiply (BigDecimal.valueOf (buildings_multiply[i])));

                    }

                    //TODO read stat
                    my_cookie = new BigInteger ((cookie[0]));
                    if(!read_txt ("my_cps_cookie").equals (""))my_cps_cookie=new BigInteger (read_txt ("my_cps_cookie"));
                    if(!(read_txt ("cookie_clicked")).equals (""))my_cookie_clicked=new BigInteger (read_txt ("cookie_clicked"));
                    if(!(read_txt ("critical_click")).equals (""))number_of_critical_click=Long.parseLong (read_txt ("critical_click"));
                    if(!(read_txt ("offline_cookie")).equals (""))my_offline_cookie=new BigInteger (read_txt ("offline_cookie"));
                    if(!(read_txt ("builds_cost")).equals (""))my_builds_cost=new BigInteger (read_txt ("builds_cost"));
                    if(!(read_txt ("upgrades_cost")).equals (""))my_upgrades_cost=new BigInteger (read_txt ("upgrades_cost"));

                    number_of_cookie.setText (String.valueOf (my_cookie) + " Cookies");
           /* my_cursor = Integer.parseInt (cookie[1]);
            my_grandma = Integer.parseInt (cookie[2].trim ());
            my_farm = Integer.parseInt (cookie[3].trim ());
            my_mine = Integer.parseInt (cookie[4].trim ());

            now_cost[0]= ( ((new BigDecimal (initial_cost[0].toString ()).multiply (new BigDecimal (String.valueOf ((Math.pow (1.15, my_cursor)))))).toBigInteger ()));
            now_cost[1]= ( ((new BigDecimal (initial_cost[1].toString ()).multiply (new BigDecimal (String.valueOf ((Math.pow (1.15, my_grandma)))))).toBigInteger ()));
            now_cost[2]= ( ((new BigDecimal (initial_cost[2].toString ()).multiply (new BigDecimal (String.valueOf ((Math.pow (1.15, my_farm)))))).toBigInteger ()));
            now_cost[3]= ( ((new BigDecimal (initial_cost[3].toString ()).multiply (new BigDecimal (String.valueOf ((Math.pow (1.15, my_mine)))))).toBigInteger ()));

            now_number_of[0]= (String.valueOf (my_cursor));
            now_number_of[1]= (String.valueOf (my_grandma));
            now_number_of[2]= (String.valueOf (my_farm));
            now_number_of[3]= (String.valueOf (my_mine));

            cps = cps.add (BigDecimal.valueOf (my_cursor).multiply (new BigDecimal ("0.1")).multiply (BigDecimal.valueOf (buildings_multiply[0])));
            cps = cps.add (BigDecimal.valueOf (my_grandma).multiply (new BigDecimal ("1")).multiply (BigDecimal.valueOf (buildings_multiply[1])));
            cps = cps.add (BigDecimal.valueOf (my_farm).multiply (new BigDecimal ("8")).multiply (BigDecimal.valueOf (buildings_multiply[2])));
            cps = cps.add (BigDecimal.valueOf (my_mine).multiply (new BigDecimal ("47")).multiply (BigDecimal.valueOf (buildings_multiply[3])));*/


           /*
           *
           *
           * TROVARE DOVE VENGONO LETTI I +1%CPS   E SALVARE/LEGGERE LA VARIABILE percent_cps
           *
           *
           * */




                    cps_txt.setText ((decimal_to_formatted_string (cps)) + " cps");



                    int percent_to_add=0;
                    int offline_to_add=0;
                    int critical_to_add=0;  //it's useless
                    for(String ed:read_txt ("upgrade_tab2").split ("/")){
                        if (ed.equals ("arrow")){
                            click_plus_percent_cps++;
                            Log.e("MY","click_plus_percent_cps"+String.valueOf (click_plus_percent_cps)+" String ed: "+ed+" String upgrade_tab2: "+read_txt ("upgrade_tab2"));
                        }
                        if(ed.equals ("offline"))offline_to_add++;
                        if(ed.equals ("luck")){
                            golden_cookie_appear*=2;
                            golden_cookie_time*=2;
                        }
                        if(ed.equals ("critical"))critical_chance++;
                    }
                    //cookie_click_add=cookie_click_add.add (cps.multiply (BigDecimal.valueOf (percent_to_add)).divide (new BigDecimal ("100")).toBigInteger ());
                    //Log.d ("MY4","Added with arrows: "+(cps.multiply (BigDecimal.valueOf (percent_to_add)).divide (new BigDecimal ("100")).toBigInteger ()));
                    String offline[]="6-5/6-5/6-5/12-10/12-5/12-5/24-10/24-5/24-5".split ("/");
                    String critical[]="1-1-1-1-2".split ("-");

                    for (int i=0;i<offline_to_add;i++)offline_base_rate+=Integer.parseInt (offline[i].split ("-")[1]);
                    offline_production_rate = (offline_base_rate) / 100d;
                    offline_production_hours=Integer.parseInt (offline[offline_to_add].split ("-")[0]);     //How many time does offline production last?
                    offline_txt.setText("Offline: "+String.valueOf ((int) (offline_production_rate*100d))+"%");
                    Log.d ("MY4","offline_base_rate: "+String.valueOf (offline_base_rate)+"\toffline_production_hours: "+String.valueOf (offline_production_hours));

                    for (int i=0;i<offline_to_add;i++)critical_chance+=Integer.parseInt (critical[i]);

                }
            } catch (IOException e) {
                reset_progress ();
                number_of_cookie.setText ("0 Cookies");
            }
        }
        String leggo;
        try {
            String FILENAME = "settings";
            byte[] bytes = new byte[1024];
            FileInputStream fis = openFileInput (FILENAME);
            fis.read (bytes);
            fis.close ();
            leggo = new String (bytes);
            if ( !leggo.trim ().equals ("") ) {
                if (leggo.trim ().split ("-").length<4)leggo+="-0-0-0-0-0";
                String leggo2[] = leggo.trim ().split ("-");

                if ( Boolean.valueOf (leggo2[0]) ) {
                    Random_click_color = true;
                }
                bounce_effect = Float.valueOf (leggo2[1]) / 2;
                if ( Boolean.valueOf (leggo2[2]) ) {
                    fancy_font=true;
                    Typeface type = Typeface.createFromAsset (getAssets (), "font/carter_one.ttf");
                    number_of_cookie.setTypeface (type);
                    number_of_cookie.setTextSize (32);
                    cps_txt.setTypeface (type);
                }

                graphic=(Integer.parseInt (leggo2[3]));
                fps=(short)(Integer.parseInt (leggo2[4]));
                vibrate=Boolean.valueOf (leggo2[5]);
                vibration_length=Integer.parseInt (leggo2[6]);
                for (int i=0;i<leggo2[7].length ();i++)effect[i]= (leggo2[7].charAt (i))!='0';
                if ( leggo2.length>=9 )if ( Boolean.valueOf (leggo2[8]) )button.setBackground (getResources ().getDrawable (R.drawable.cookie_original_hover));

            }
        } catch (IOException e) {
        }
        Arrays.fill (builds_give,"0");
        for (int j=0;j<how_many_buildings_i_have;j++)builds_give[j]=initial_give[j].multiply (BigDecimal.valueOf (my_build[j])).multiply (BigDecimal.valueOf (buildings_multiply[j])).toString ();

        //Log.d ("MY",Arrays.toString (builds_give));

        sparkle.startAnimation (rotation);


        String string = "";
        try {
            String FILENAME = "date";
            byte[] bytes = new byte[1024];
            FileInputStream fis = openFileInput (FILENAME);
            fis.read (bytes);
            fis.close ();
            string = new String (bytes);
            long second_to_earn = System.currentTimeMillis () - Long.valueOf (string.trim ());
            second_to_earn /= 1000;
            if(offline_production_hours*3600<second_to_earn)second_to_earn=offline_production_hours*3600;
            //_________________________________________________________________________________________________________________
            //OFFLINE PRODUCTION----------------------------------------------------------------------------------------------
            my_cookie = my_cookie.add (cps.multiply (new BigDecimal (String.valueOf (second_to_earn))).multiply (new BigDecimal (offline_production_rate)).toBigInteger ());
            my_offline_cookie=my_offline_cookie.add (cps.multiply (new BigDecimal (String.valueOf (second_to_earn))).multiply (new BigDecimal (offline_production_rate)).toBigInteger ());
            number_of_cookie.setText (number_to_formatted_string (my_cookie) + " Cookies");

            if ( second_to_earn > 120 ) {
                cookie_earned_in_pause="You earned: " + number_to_formatted_string (cps.multiply (new BigDecimal (String.valueOf (second_to_earn)))
                        .multiply (new BigDecimal (offline_production_rate)).toBigInteger ()) + " Cookie" +
                                       "\n In " + seconds_to_string (second_to_earn);


            }
            save ();
        } catch (IOException e) {
        }
        //Initialize and fill builds_given[] variable
        Arrays.fill (builds_given,"0");
        final String builds_given2[]=read_txt ("builds_given").split ("-");
        for(int i=0; i<how_many_buildings_i_have;i++)if(!builds_given2[i].equals ("null"))builds_given[i]=builds_given2[i];
        Log.e ("MY", "READEING builds_given: " + Arrays.toString (builds_given));

        load_progress (0.05f);
        Log.e ("MY6","3---> "+String.valueOf (currentTimeMillis() - mtime     +"---> "+String.valueOf (nanoTime () - ntime)));
//TODO ///////////////////////////////////////////////////
/////////       SKILL  (BOTTOM)     //////////////////////////////////////////////////////////////////////////////////
//TODO Skill (bar)
        int skill_max=(int)((dpwidth+10)/80);
        int space=(int)(dpwidth/(skill_max*80/dpwidth*x_max));

        LinearLayout.LayoutParams ll = new LinearLayout.LayoutParams (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        String my_skill=read_txt ("skill");
        menu_skill[0]=new LinearLayout (getApplicationContext ());
        menu_skill[0].setOrientation (LinearLayout.HORIZONTAL);
        menu_skill2.addView (menu_skill[0]);
        for (int i=0;i<my_skill.length ();i++)skills[Integer.valueOf (String.valueOf (my_skill.charAt (i)))]=true;
        for (int i=0;i<skills.length;i++){
            if(i==3)continue;//don't need to display golden bar skill
            if ( !skills[i] )continue;
            final View skill_frame = LayoutInflater.from(this).inflate(R.layout.skill_frame, null);
            final ConstraintLayout new_menu=skill_frame.findViewById (R.id.frame_menu);
            final ImageView symbol=skill_frame.findViewById (R.id.frame_skill);
            final ImageView bg1=skill_frame.findViewById (R.id.frame_grey_bg);
            final ImageView bg2=skill_frame.findViewById (R.id.frame_grey_skill);
            //final ImageView bg_color=skill_frame.findViewById (R.id.frame_bg);
            final ImageView bg_light=skill_frame.findViewById (R.id.frame_light);
            final ImageView bg_light_gold=skill_frame.findViewById (R.id.frame_bg_gold);


            bg1.setVisibility (View.INVISIBLE);
            bg2.setVisibility (View.INVISIBLE);
            int img = skill_frame.getContext ().getResources ().getIdentifier ("skill"+String.valueOf (i)+"00", "drawable", skill_frame.getContext ().getPackageName ());
            symbol.setImageResource (img);

            ll.setMargins(0, 0, 10, 0);
            //  new_menu.setLayoutParams (ll);
            new_menu.setId (i+2500);
            new_menu.setOnClickListener (new View.OnClickListener () {
                @Override
                public void onClick (View view) {
                    click_my (view);
                }
            });
            bg_dark[i]=bg1;bg_dark2[i]=bg_light_gold;
            new_menu.setOnTouchListener (new View.OnTouchListener () {
                @Override
                public boolean onTouch (View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction ()==MotionEvent.ACTION_DOWN){
                        bg_light.setVisibility (View.VISIBLE);
                        skill_frame.setTranslationY (7f/dpheight*y_max);
                    }
                    if(motionEvent.getAction ()==MotionEvent.ACTION_UP||motionEvent.getAction ()==MotionEvent.ACTION_OUTSIDE){
                        bg_light.setVisibility (View.INVISIBLE);
                        skill_frame.setTranslationY (0);
                    }
                    return false;
                }
            });
            ++skill_added;
            if(skill_added>=skill_max){
                skill_added-=skill_max;
                passo++;
                menu_skill[passo]=new LinearLayout (getApplicationContext ());
                menu_skill[passo].setOrientation (LinearLayout.HORIZONTAL);

                menu_skill2.addView (menu_skill[passo]);
            }
        }
        menu_skill_scrollview.setVisibility (View.GONE);


        final View skill_frame = LayoutInflater.from(this).inflate(R.layout.skill_frame, null);
        final ConstraintLayout new_menu=skill_frame.findViewById (R.id.frame_menu);
        new_menu.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                if (skill_counting!=0) {
                    MediaPlayer.create (getApplicationContext (),R.raw.fx_menu_laterale_in).start ();
                    //window_to_transition=2;
               /* save ();
                save_txt ("skill_su_state",String.valueOf (su));
                Intent i=new Intent (MainActivity.this, skill.class).putExtra ("my_cookie",my_cookie.toString ()).putExtra ("cps",cps.toString ()).putExtra ("fps",String.valueOf (fps))
                        .putExtra ("fancy",fancy_font).putExtra ("golden_num",number_of_golden_cookie).putExtra ("MyBuild",my_build);
                trans=false;
                startActivity (i);
                finish ();*/
                    active_activity = 2;
                    //overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                    menu_skill_laterale.animate ().translationX (-50f / dpwidth * x_max).setDuration (400);
                    // menu_skill_laterale.animate ().translationX (0).setDuration (400);
                }
                else {
                    toast ("Nothing to buy!");
                    MediaPlayer.create (getApplicationContext (),R.raw.fx_no_buy).start ();
                }
            }
        });
        new_menu.setOnTouchListener (new View.OnTouchListener () {
            @Override
            public boolean onTouch (View view, MotionEvent motionEvent) {
                if (motionEvent.getAction ()==MotionEvent.ACTION_DOWN)skill_frame.setTranslationY (7f/dpheight*y_max);
                if(motionEvent.getAction ()==MotionEvent.ACTION_UP||motionEvent.getAction ()==MotionEvent.ACTION_HOVER_EXIT)skill_frame.setTranslationY (0);
                return false;
            }
        });
        final ImageView symbol1=skill_frame.findViewById (R.id.frame_skill);
        final ImageView bg1=skill_frame.findViewById (R.id.frame_grey_bg);
        final ImageView bg2=skill_frame.findViewById (R.id.frame_grey_skill);
        final ImageView bg_gold=skill_frame.findViewById (R.id.frame_bg_gold);
        bg_gold.setImageDrawable (null);
        bg_gold.setBackgroundColor (getResources ().getColor (R.color.green_light));

        bg1.setTranslationY (bg1.getTranslationY ()-(int)(80f/dpheight*y_max));
        bg2.setTranslationY (bg2.getTranslationY ()-(int)(80f/dpheight*y_max));
        symbol1.setImageDrawable (getResources ().getDrawable (R.drawable.plus_hover));
        menu_skill[passo].addView (skill_frame);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////

        Log.e ("MY6","4---> "+String.valueOf (currentTimeMillis() - mtime     +"---> "+String.valueOf (nanoTime () - ntime)));
        load_progress (0.15f);



/////////       UPGRADE  (MENU LATERALE)      ////////////////////////////////////////////////////////////////

        boolean reset=false;
        try {
            string="";
            String FILENAME = "upgrade_done";
            byte[] bytes = new byte[10240];
            FileInputStream fis = openFileInput(FILENAME);
            menu_skill[passo].addView (skill_frame);
            fis.read(bytes);
            fis.close();
            string = new String(bytes);
            if (!string.trim().contains("-"))reset=true;
            else Collections.addAll (fatti_fast,string.trim().split("-"));

        } catch (IOException e) {}

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

        /*for(String ed:fatti_fast){
            int seed=Integer.parseInt (ed.substring (0,ed.length ()-2));
            //showed_upgrades[seed-5]++;  //Aggiungo 1 per ogni upgrade gia comprato
        }*/


//TODO Upgrade (cursor)
        for (int j=0;j<how_many_buildings_i_have;j++) {
            if(my_build[j]==0)continue;
            if ( j == 0 ) {
                for (int i = 0; i < cost_multiply_cursor.length; i++) {
                    String add_id = String.valueOf (i);
                    if ( i < 10 ) add_id = "0" + add_id;

                    if ( fatti_fast.contains ((String.valueOf (j + 5) + add_id)) )
                        continue;

                    final int required = Integer.parseInt (required_progress_cursor[i]);
                    if ( my_build[j] < required )break;
                    ll = new LinearLayout.LayoutParams (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    Typeface font_carter_one = Typeface.createFromAsset (getAssets (), "font/carter_one.ttf");
                    View image2_ = LayoutInflater.from (this).inflate (R.layout.image2, null);
                    final ConstraintLayout new_menu2 = image2_.findViewById (R.id.new_menu_example);
                    final TextView title = image2_.findViewById (R.id.title2);
                    final TextView cost = image2_.findViewById (R.id.cost);
                    final TextView from = image2_.findViewById (R.id.from);
                    final TextView to = image2_.findViewById (R.id.to);
                    //final ImageView cookie_small = image2_.findViewById (R.id.image);
                    final ImageView image2 = image2_.findViewById (R.id.image2);
                    final ImageView gray=image2_.findViewById (R.id.upgrade_gray);
                    final ImageView color_bg=image2_.findViewById (R.id.color_bg);
                    final ImageView up1=image2_.findViewById (R.id.up1);
                    final ImageView up2=image2_.findViewById (R.id.up2);
                    final ImageView up3=image2_.findViewById (R.id.up3);

                    int tmp=1;
                    if ( i>3)tmp++;
                    if(i>6)tmp++;
                    for(int j1=0;j1<=(i-1-(tmp-1)*3);j1++){
                        if (j1==0){
                            if(tmp==1)up1.setImageDrawable (getResources ().getDrawable (R.drawable.skill_arrow_green));
                            if(tmp==2)up1.setImageDrawable (getResources ().getDrawable (R.drawable.skill_arrow_yellow));
                            if(tmp==3)up1.setImageDrawable (getResources ().getDrawable (R.drawable.skill_arrow_red));
                        }
                        if (j1==1){
                            if(tmp==1)up2.setImageDrawable (getResources ().getDrawable (R.drawable.skill_arrow_green));
                            if(tmp==2)up2.setImageDrawable (getResources ().getDrawable (R.drawable.skill_arrow_yellow));
                            if(tmp==3)up2.setImageDrawable (getResources ().getDrawable (R.drawable.skill_arrow_red));
                        }
                        if (j1==2){
                            if(tmp==1)up3.setImageDrawable (getResources ().getDrawable (R.drawable.skill_arrow_green));
                            if(tmp==2)up3.setImageDrawable (getResources ().getDrawable (R.drawable.skill_arrow_yellow));
                            if(tmp==3)up3.setImageDrawable (getResources ().getDrawable (R.drawable.skill_arrow_red));
                        }
                    }

                    String name_image = name_upgrades[j].toLowerCase ().replace (' ', '_');

                    int id2 = color_bg.getContext ().getResources ().getIdentifier (name_image, "color", color_bg.getContext ().getPackageName ());
                    color_bg.setBackgroundColor (id2);
                    color_bg.setAlpha (0.8f);

                    Boolean stop = false;


                    //if (fatti[Integer.valueOf(String.valueOf (j+5)+String.valueOf(i))])continue;



                    BigInteger cost_now = new BigInteger (base_cost[j]);
                    for (int k=0;k<=i;k++)cost_now=cost_now.multiply (new BigInteger (cost_multiply[k]));
                    if ( my_cookie.compareTo (cost_now) <= 0 ) stop = true;

                    Log.d ("MY", "Upgrade cursors: "+(String.valueOf (j + 5) + String.valueOf (i)));

                    new_menu2.setId (Integer.valueOf (String.valueOf (j + 5) + add_id));

                    //if ( stop ) image2_.setId (0-2);
                    //new_menu2.setBackground (getResources ().getDrawable (R.color.dark_background));
                    //if ( stop )
                    //gray.setVisibility (View.VISIBLE);

                    title.setText (name_upgrades[j] );
                    title.setTextSize (20);
                    title.setTypeface (font_carter_one);

                    cost.setText (number_to_formatted_string (cost_now));
                    cost.setTextSize (16);
                    cost.setTypeface (font_carter_one);

                    from.setText ("Lv."+String.valueOf (i));
                    from.setTextSize (20);
                    from.setTypeface (font_carter_one);
                    to.setVisibility (View.INVISIBLE);

                    image2_.setPadding (0, 0, 0, 0);
                    ll.setMargins (0, 15, 0, 0);
                    image2_.setLayoutParams (ll);
                    //image2.setImageDrawable (getResources ().getDrawable (R.drawable.cursor));
                    Context context = image2.getContext ();
                    int id = context.getResources ().getIdentifier (name_image, "drawable", context.getPackageName ());
                    image2.setImageResource (id);

                    list_upgrade.addView (image2_);
                    showed_upgrades[j]++;
                    upgrade_counting++;
                    //skills.addElement (new_menu2.getId ());

                    new_menu2.setOnClickListener (new View.OnClickListener () {
                        @Override
                        public void onClick (View view) {
                            click_my (view);
                        }
                    });
                    if (Integer.valueOf (new_menu2.getId ())>=0){
                        costi[new_menu2.getId ()] = cost_now.toString ();
                        costi_fast.addElement (cost_now.toString ());
                    }
                    else costi_fast.addElement (cost_now.toString ());
                    upgrade_button.addElement (new_menu2.getId ());
                    upgrade_gray.add (gray);
                    seed_id.add (new_menu2.getId ());

                    new_menu2.setOnTouchListener (new View.OnTouchListener () {
                        @Override
                        public boolean onTouch (View view, MotionEvent motionEvent) {
                            if (motionEvent.getAction ()==MotionEvent.ACTION_DOWN){
                                new_menu2.animate ().translationY (12).setDuration (35);
                                new CountDownTimer (500,500)
                                {
                                    @Override
                                    public void onTick (long l) {

                                    }

                                    @Override
                                    public void onFinish () {
                                        new_menu2.animate ().translationY (0).setDuration (40);
                                    }
                                }.start ();
                            }
                            if(motionEvent.getAction ()==MotionEvent.ACTION_UP||motionEvent.getAction ()==MotionEvent.ACTION_HOVER_EXIT)new_menu2.animate ().translationY (0).setDuration (40);
                            return false;
                        }
                    });
                    //break;

                }
            }
            //TODO Upgrade (other)
            else {
                for (int i = 0; i < cost_multiply.length; i++) {
                    String add_id = String.valueOf (i);
                    if ( i < 10 ) add_id = "0" + add_id;
                    if ( fatti_fast.contains ((String.valueOf (j + 5) + add_id)) )continue;

                    final int required = Integer.parseInt (required_progress[i]);
                    if ( my_build[j] < required )break;
                    ll = new LinearLayout.LayoutParams (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    Typeface font_carter_one = Typeface.createFromAsset (getAssets (), "font/carter_one.ttf");
                    View image2_ = LayoutInflater.from (this).inflate (R.layout.image2, null);
                    final ConstraintLayout new_menu2 = image2_.findViewById (R.id.new_menu_example);
                    final TextView title = image2_.findViewById (R.id.title2);
                    final TextView cost = image2_.findViewById (R.id.cost);
                    final TextView from = image2_.findViewById (R.id.from);
                    final TextView to = image2_.findViewById (R.id.to);
                    final ImageView cookie_small = image2_.findViewById (R.id.image);
                    final ImageView image2 = image2_.findViewById (R.id.image2);
                    final ImageView gray=image2_.findViewById (R.id.upgrade_gray);
                    final ImageView color_bg=image2_.findViewById (R.id.color_bg);
                    final ImageView up1=image2_.findViewById (R.id.up1);
                    final ImageView up2=image2_.findViewById (R.id.up2);
                    final ImageView up3=image2_.findViewById (R.id.up3);

                    int tmp=1;
                    if ( i>3)tmp++;
                    if(i>6)tmp++;
                    for(int j1=0;j1<=(i-1-(tmp-1)*3);j1++){
                        if (j1==0){
                            if(tmp==1)up1.setImageDrawable (getResources ().getDrawable (R.drawable.skill_arrow_green));
                            if(tmp==2)up1.setImageDrawable (getResources ().getDrawable (R.drawable.skill_arrow_yellow));
                            if(tmp==3)up1.setImageDrawable (getResources ().getDrawable (R.drawable.skill_arrow_red));
                        }
                        if (j1==1){
                            if(tmp==1)up2.setImageDrawable (getResources ().getDrawable (R.drawable.skill_arrow_green));
                            if(tmp==2)up2.setImageDrawable (getResources ().getDrawable (R.drawable.skill_arrow_yellow));
                            if(tmp==3)up2.setImageDrawable (getResources ().getDrawable (R.drawable.skill_arrow_red));
                        }
                        if (j1==2){
                            if(tmp==1)up3.setImageDrawable (getResources ().getDrawable (R.drawable.skill_arrow_green));
                            if(tmp==2)up3.setImageDrawable (getResources ().getDrawable (R.drawable.skill_arrow_yellow));
                            if(tmp==3)up3.setImageDrawable (getResources ().getDrawable (R.drawable.skill_arrow_red));
                        }
                    }
                    String name_image = name_upgrades[j].toLowerCase ().replace (' ', '_');
                    int id2 = color_bg.getContext ().getResources ().getIdentifier (name_image, "color", color_bg.getContext ().getPackageName ());
                    color_bg.setImageResource (id2);
                    color_bg.setAlpha ((float)(i+1)/10f);
                    Boolean stop = false;
                    if ( name_image.equals ("alchemy_lab") ) name_image = "alchemylab";
                    BigInteger cost_now = new BigInteger (base_cost[j]);
                    for (int k=0;k<=i;k++)cost_now=cost_now.multiply (new BigInteger (cost_multiply[k]));
                    if ( my_cookie.compareTo (cost_now) <= 0 ) stop = true;

                    Log.d ("MY", "Upgrade others: "+(String.valueOf (j + 5) + String.valueOf (i)));
                    new_menu2.setId (Integer.valueOf (String.valueOf (j + 5) + add_id));

                    //if ( stop ) image2_.setId (0-2);
                    //new_menu2.setBackground (getResources ().getDrawable (R.color.dark_background));
                    //if ( stop )
                    //gray.setVisibility (View.VISIBLE);

                    title.setText (name_upgrades[j] );
                    title.setTextSize (20);
                    title.setTypeface (font_carter_one);

                    cost.setText (number_to_formatted_string (cost_now));
                    cost.setTextSize (16);
                    cost.setTypeface (font_carter_one);

                    from.setText ("Lv."+String.valueOf (i));
                    from.setTextSize (20);
                    from.setTypeface (font_carter_one);
                    to.setVisibility (View.INVISIBLE);

                    image2_.setPadding (0, 0, 0, 0);
                    ll.setMargins (0, 15, 0, 0);
                    image2_.setLayoutParams (ll);
                    //image2.setImageDrawable (getResources ().getDrawable (R.drawable.cursor));
                    Context context = image2.getContext ();
                    int id = context.getResources ().getIdentifier (name_image, "drawable", context.getPackageName ());
                    image2.setImageResource (id);

                    list_upgrade.addView (image2_);
                    showed_upgrades[j]++;
                    upgrade_counting++;
                    //skills.addElement (new_menu2.getId ());
                    new_menu2.setOnClickListener (new View.OnClickListener () {
                        @Override
                        public void onClick (View view) {
                            click_my (view);
                        }
                    });
                    if (Integer.valueOf (new_menu2.getId ())>=0){
                        costi[new_menu2.getId ()] = cost_now.toString ();
                        costi_fast.addElement (cost_now.toString ());
                    }
                    else costi_fast.addElement (cost_now.toString ());
                    upgrade_button.addElement (new_menu2.getId ());

                    upgrade_gray.add (gray);
                    seed_id.add (new_menu2.getId ());


                    new_menu2.setOnTouchListener (new View.OnTouchListener () {
                        boolean done=false;
                        @Override
                        public boolean onTouch (View view, MotionEvent motionEvent) {
                            if (motionEvent.getAction ()==MotionEvent.ACTION_DOWN){
                                new_menu2.animate ().translationYBy (12).setDuration (35);
                                new CountDownTimer (500,500)
                                {
                                    @Override
                                    public void onTick (long l) {

                                    }

                                    @Override
                                    public void onFinish () {
                                        if (!done) new_menu2.animate ().translationYBy (-12).setDuration (40);
                                    }
                                }.start ();
                            }
                            if(motionEvent.getAction ()==MotionEvent.ACTION_UP||motionEvent.getAction ()==MotionEvent.ACTION_HOVER_EXIT){
                                done=true;
                                new_menu2.animate ().translationYBy (-12).setDuration (40);
                            }
                            return false;
                        }
                    });

                    //break;
                }
            }

        }

        //////// NOTHING TO SHOW ////////////////////////

        if (true)/*just for conflict with variable image2_*/{
            View image2_ = LayoutInflater.from (this).inflate (R.layout.image2, null);
            TextView title=image2_.findViewById (R.id.title2);

            final ConstraintLayout new_menu2 = image2_.findViewById (R.id.new_menu_example);
            final TextView cost = image2_.findViewById (R.id.cost);
            final TextView from = image2_.findViewById (R.id.from);
            final TextView to = image2_.findViewById (R.id.to);
            final ImageView cookie_small = image2_.findViewById (R.id.image);
            final ImageView image2 = image2_.findViewById (R.id.image2);
            title.setText ("Nothing to show");
            from.setVisibility (View.GONE);
            to.setVisibility (View.GONE);
            image2.setImageDrawable (null);
            cookie_small.setVisibility (View.GONE);
            cost.setVisibility (View.GONE);

            new_menu2.setId (99900+0);
            nothing_to_show_box=upgrade_counting==0;
            if (upgrade_counting!=0)new_menu2.setVisibility (View.GONE);
            list_upgrade.addView (image2_);

        }




        exit_upgrade.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {

                active_activity=0;
                menu_upgrade.animate ().translationX (x_max);
            }
        });

        /////////////////////////////////////////////////////////

        Log.e ("MY6","5---> "+String.valueOf (currentTimeMillis() - mtime     +"---> "+String.valueOf (nanoTime () - ntime)));

        /////// UPGRADE TAB 2 //////////////////////////////////
        //TODO Upgrade 2

        String current="";
        for (int j=0;j<upgrade2.length;j++) {

            for (int i = 0; i < upgrade2[j].length; i++) {
                String add_id = String.valueOf (i);
                if ( i < 10 ) add_id = "0" + add_id;
                if ( fatti_fast.contains ((String.valueOf (j + 30) + add_id)) ) continue;

                BigInteger required = new BigInteger (upgrade2[j][i].split ("/")[2]);
                if (j==1)required = new BigInteger (upgrade2[j][i].split ("/")[3]);
                BigInteger cost_now=null;

                //Costi e condizioni per il break
                String name_image="";
                if(j==0){
                    cost_now = new BigInteger (upgrade2[j][i].split ("/")[2]);
                    if(upgrade2[j][i].split ("/")[0].equals (current))break;
                    current=upgrade2[j][i].split ("/")[0];
                name_image="offline";
            }
                if(j==1){
                    cost_now = new BigInteger (upgrade2[j][i].split ("/")[3]);
                    if (required.compareTo (BigInteger.valueOf (number_of_golden_cookie))>0)break;
                    name_image="quatrefoil_"+String.valueOf (i+1);
                }
                if(j==2){
                    cost_now = new BigInteger (upgrade2[j][i].split ("/")[2]).multiply (new BigInteger ("50"));
                    if (my_cookie_clicked.compareTo (required)<0)break;
                    name_image="arrow_symbol_"+String.valueOf (i+1);
                }
                if(j==3){
                    cost_now = new BigInteger (upgrade2[j][i].split ("/")[3]);
                    if (required.compareTo (BigInteger.valueOf (number_of_critical_click))>0)break;
                    name_image="critical_click_"+String.valueOf (i+1);
                }


                ll = new LinearLayout.LayoutParams (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                Typeface font_carter_one = Typeface.createFromAsset (getAssets (), "font/carter_one.ttf");
                View image2_ = LayoutInflater.from (this).inflate (R.layout.image2, null);
                final ConstraintLayout new_menu2 = image2_.findViewById (R.id.new_menu_example);
                final TextView title = image2_.findViewById (R.id.title2);
                final TextView cost = image2_.findViewById (R.id.cost);
                final TextView from = image2_.findViewById (R.id.from);
                final TextView to = image2_.findViewById (R.id.to);
                final ImageView image2 = image2_.findViewById (R.id.image2);
                final ImageView gray = image2_.findViewById (R.id.upgrade_gray);
                final ImageView color_bg = image2_.findViewById (R.id.color_bg);
                final ImageView up1 = image2_.findViewById (R.id.up1);
                final ImageView up2 = image2_.findViewById (R.id.up2);
                final ImageView up3 = image2_.findViewById (R.id.up3);

                if(i!=0) {
                    int tmp = (i-1) / 3;
                    for (int j1 = 0; j1 <= (i - 1 - tmp * 3); j1++) {
                        if ( j1 == 0 ) {
                            if ( tmp == 0 )
                                up1.setImageDrawable (getResources ().getDrawable (R.drawable.skill_arrow_green));
                            if ( tmp == 1 )
                                up1.setImageDrawable (getResources ().getDrawable (R.drawable.skill_arrow_yellow));
                            if ( tmp == 2 )
                                up1.setImageDrawable (getResources ().getDrawable (R.drawable.skill_arrow_red));
                        }
                        if ( j1 == 1 ) {
                            if ( tmp == 0 )
                                up2.setImageDrawable (getResources ().getDrawable (R.drawable.skill_arrow_green));
                            if ( tmp == 1 )
                                up2.setImageDrawable (getResources ().getDrawable (R.drawable.skill_arrow_yellow));
                            if ( tmp == 2 )
                                up2.setImageDrawable (getResources ().getDrawable (R.drawable.skill_arrow_red));
                        }
                        if ( j1 == 2 ) {
                            if ( tmp == 0 )
                                up3.setImageDrawable (getResources ().getDrawable (R.drawable.skill_arrow_green));
                            if ( tmp == 1 )
                                up3.setImageDrawable (getResources ().getDrawable (R.drawable.skill_arrow_yellow));
                            if ( tmp == 2 )
                                up3.setImageDrawable (getResources ().getDrawable (R.drawable.skill_arrow_red));
                        }
                    }
                }

                color_bg.setBackgroundColor (Color.rgb ((int)(Math.random ()*255),(int)(Math.random ()*255),(int)(Math.random ()*255)));
                color_bg.setAlpha ((float) (i + 1) / 10f);

                new_menu2.setId (Integer.valueOf (String.valueOf (j + 30) + add_id));

                title.setText (upgrade2[j][i].split ("/")[1]);
                title.setTextSize (20);
                title.setTypeface (font_carter_one);

                cost.setText (number_to_formatted_string (cost_now));
                cost.setTextSize (16);
                cost.setTypeface (font_carter_one);

                from.setText ("Lv." + String.valueOf (i));
                from.setTextSize (20);
                from.setTypeface (font_carter_one);
                to.setVisibility (View.INVISIBLE);

                image2_.setPadding (0, 0, 0, 0);
                ll.setMargins (0, 15, 0, 0);
                image2_.setLayoutParams (ll);
                Context context = image2.getContext ();
                int id = context.getResources ().getIdentifier (name_image, "drawable", context.getPackageName ());
                image2.setImageResource (id);


                list_upgrade2.addView (image2_);
                upgrade_counting2++;
                new_menu2.setOnClickListener (new View.OnClickListener () {
                    @Override
                    public void onClick (View view) {
                        click_my (view);
                    }
                });
                if ( Integer.valueOf (new_menu2.getId ()) >= 0 ) {
                    costi2[Integer.valueOf (new_menu2.getId ())-3000] = cost_now.toString ();
                    costi_fast2.addElement (cost_now.toString ());
                } else costi_fast2.addElement (cost_now.toString ());
                upgrade_button.addElement (new_menu2.getId ());

                upgrade_gray2.add (gray);
                seed_id2.add (new_menu2.getId ());


                //LITTLE CLICK-pop
                new_menu2.setOnTouchListener (new View.OnTouchListener () {
                    boolean done = false;

                    @Override
                    public boolean onTouch (View view, MotionEvent motionEvent) {
                        if ( motionEvent.getAction () == MotionEvent.ACTION_DOWN ) {
                            new_menu2.animate ().translationYBy (12).setDuration (35);
                            new CountDownTimer (400, 400) {
                                @Override
                                public void onTick (long l) {

                                }

                                @Override
                                public void onFinish () {
                                    if ( !done )
                                        new_menu2.animate ().translationYBy (-12).setDuration (40);
                                }
                            }.start ();
                        }
                        if ( motionEvent.getAction () == MotionEvent.ACTION_UP || motionEvent.getAction () == MotionEvent.ACTION_HOVER_EXIT ) {
                            done = true;
                            new_menu2.animate ().translationYBy (-12).setDuration (40);
                        }
                        return false;
                    }
                });

            }
        }

        //////// NOTHING TO SHOW 2 ////////////////////////

        if (true)/*just for conflict with variable image2_*/{
            View image2_ = LayoutInflater.from (this).inflate (R.layout.image2, null);
            TextView title=image2_.findViewById (R.id.title2);

            final ConstraintLayout new_menu2 = image2_.findViewById (R.id.new_menu_example);
            final TextView cost = image2_.findViewById (R.id.cost);
            final TextView from = image2_.findViewById (R.id.from);
            final TextView to = image2_.findViewById (R.id.to);
            final ImageView cookie_small = image2_.findViewById (R.id.image);
            final ImageView image2 = image2_.findViewById (R.id.image2);
            title.setText ("Nothing to show");
            from.setVisibility (View.GONE);
            to.setVisibility (View.GONE);
            image2.setImageDrawable (null);
            cookie_small.setVisibility (View.GONE);
            cost.setVisibility (View.GONE);

            new_menu2.setId (99900+1);
            nothing_to_show_box2=upgrade_counting2==0;
            if (upgrade_counting2!=0)new_menu2.setVisibility (View.GONE);
            list_upgrade2.addView (image2_);
        }


/////////////////////////////////////////////////////////

        Log.e ("MY6","6---> "+String.valueOf (currentTimeMillis() - mtime     +"---> "+String.valueOf (nanoTime () - ntime)));



//////////////////////////////////////////////////////////////////////////////////////////////////////////////

        load_progress (0.35f);
////////   SKILL  (MENU LATERALE)  ///////////////////////////////////////////////////////////////////////////
//TODO Skill (laterale)

        for(String ed:read_txt ("skill_done").split ("-"))
            if(! ed.equals(""))
                skill_done.addElement (ed);   //Fill the Vector with id(s)

        if(skill_done.contains (String.valueOf (2603)))effect_bar.setVisibility (View.VISIBLE);

        LinearLayout.LayoutParams ll2 = new LinearLayout.LayoutParams (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        for(int i=0;i<skill_avaible.length;i++){
            if ( skill_done.contains (String.valueOf (i+2600)) )continue;
            String my_skill2[]=skill_avaible[i].split ("-");

            View skill_palette = LayoutInflater.from(this).inflate(R.layout.skill_palette, null);
            final ConstraintLayout new_menu2=skill_palette.findViewById (R.id.skill_menu);
            final TextView title=skill_palette.findViewById (R.id.skill_title);
            final TextView cost=skill_palette.findViewById (R.id.skill_cost);
            final TextView description=skill_palette.findViewById (R.id.skill_description);
            final ImageView symbol=skill_palette.findViewById (R.id.skill_symbol);
            final ImageView grey=skill_palette.findViewById (R.id.skill_gray);
            final ImageView color_bg=skill_palette.findViewById (R.id.color_bg2);

            color_bg.setBackgroundColor (Color.rgb ((int)(Math.random ()*256),(int)(Math.random ()*256),(int)(Math.random ()*256)));
            color_bg.setAlpha (0.4f);

            Context context = skill_palette.getContext ();
            int id = context.getResources ().getIdentifier ("skill"+String.valueOf (i)+"00", "drawable", context.getPackageName ());//prende solo la prima immagine per ogni skill
            symbol.setImageResource (id);

            title.setText (my_skill2[0]);  description.setText (my_skill2[1]);  cost.setText (number_to_formatted_string (new BigInteger (my_skill2[2])));//setText per my_skill2[0,1,2]
            new_menu2.setId (i+2600);
           /* if(MainActivity.my_cookie.compareTo (new BigInteger (my_skill2[2]))<=0){      //se non ho abbastanza cookie/rubini
               // grey.setVisibility (View.VISIBLE); new_menu2.setId (0);
            }*/
            new_menu2.setOnClickListener (new View.OnClickListener () {
                @Override
                public void onClick (View view) {
                    click_my (view);
                }
            });
            ll2.setMargins(0, 15, 0, 0);
            new_menu2.setLayoutParams (ll2);
            menu_skill4.addView (skill_palette);
            skill_counting++;
            skills2.add (new_menu2.getId ());

            costi_fast_skill.add (my_skill2[2]);
            costi_skill[i]=my_skill2[2];
            skill_gray.add (grey);


            new_menu2.setOnTouchListener (new View.OnTouchListener () {
                boolean done=false;
                @Override
                public boolean onTouch (View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction ()==MotionEvent.ACTION_DOWN){
                        new_menu2.animate ().translationYBy (12).setDuration (35);
                        new CountDownTimer (1000,1000)
                        {
                            @Override
                            public void onTick (long l) {

                            }

                            @Override
                            public void onFinish () {
                                if (!done) new_menu2.animate ().translationYBy (-12).setDuration (40);
                            }
                        }.start ();
                    }
                    if(motionEvent.getAction ()==MotionEvent.ACTION_UP||motionEvent.getAction ()==MotionEvent.ACTION_HOVER_EXIT){
                        done=true;
                        new_menu2.animate ().translationYBy (-12).setDuration (40);
                    }
                    return false;
                }
            });
        }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////

        Log.e ("MY6","7---> "+String.valueOf (currentTimeMillis() - mtime     +"---> "+String.valueOf (nanoTime () - ntime)));
        /////////       STATISTICS      //////////////////////////////////////////////////////////////////////////////////////////////
//TODO Statistic

        String statistics[]=(
                "Cookies earned/"
                + "        Hand-made cookies/"
                + "        Builds-made cookies/"
                + "        Offline cookies/"
                + "        Builds cost/"
                + "        Upgrades cost/"
                + "Click power/"
                + "Offline time/"
                + "Critical clicks/"
                + "Critical chance/"
                + "Golden cookie/"
                + "Game started on/"
                + "Time on game"

        ).split ("/");
        for(int i=0;i<statistics.length;i++){
            View stat = LayoutInflater.from(this).inflate(R.layout.stats, null);
            final TextView in=stat.findViewById (R.id.stat_name);
            final TextView out=stat.findViewById (R.id.stat_value);

            if(i==0)stat_my_cookie=out;
            if(i==1)stat_hand_made=out;
            if(i==2)stat_build_cookie=out;
            if(i==3)stat_offline_cookie=out;
            if(i==4)stat_builds_cost=out;
            if(i==5)stat_upgrades_cost=out;
            if(i==6)stat_click_power=out;
            if(i==7)stat_offline_time=out;
            if(i==8)stat_critical_click=out;
            if(i==9)stat_critical_chance=out;
            if(i==10)stat_golden_click=out;
            if(i==11)stat_game_start=out;
            if(i==12)stat_time_game=out;

            final ImageView cookie_image=stat.findViewById (R.id.stat_cookie);

            if(i>=6 && i<=99){
                cookie_image.setVisibility (View.GONE);
                out.setPadding ((int)(4f/dpwidth*x_max),0,0,0);
            }
            in.setText (statistics[i]);
            out.setId (3300+i);
            statistics_list.addView (stat);

        }
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//TODO ///////////////////////////////////////////////////


        Log.e ("MY6","8---> "+String.valueOf (currentTimeMillis() - mtime     +"---> "+String.valueOf (nanoTime () - ntime)));
//TODO Build Generator
        load_progress (0.45f);


        for(int i=0;i<how_many_buildings_i_have;i++){
            View buildings_palette = LayoutInflater.from(this).inflate(R.layout.buildings_palette, null);

            final ConstraintLayout palette_menu=buildings_palette.findViewById (R.id.palette_menu);
            final ImageView symbol=buildings_palette.findViewById (R.id.symbol);
            final ImageView title2=buildings_palette.findViewById (R.id.build_name);
            final TextView cost=buildings_palette.findViewById (R.id.cost_of);
            final ImageView palette=buildings_palette.findViewById (R.id.palette);
            final TextView number=buildings_palette.findViewById (R.id.number_of);
            switch (graphic){
                case 0:   palette.setImageDrawable (getResources ().getDrawable (R.drawable.xml_bar_hoverlow));break;
                case 1:   palette.setImageDrawable (getResources ().getDrawable (R.drawable.xml_bar_hover));break;
                case 2:   palette.setImageDrawable (getResources ().getDrawable (R.drawable.xml_bar_hoverhi));break;
            }
            switch (i)
            {
                case 0:
                    switch (graphic){
                        case 0:   symbol.setImageDrawable (getResources ().getDrawable (R.drawable.cursor_low));break;
                        case 1:   symbol.setImageDrawable (getResources ().getDrawable (R.drawable.cursor));break;
                        case 2:   symbol.setImageDrawable (getResources ().getDrawable (R.drawable.cursor_high));break;
                    }
                    title2.setImageDrawable (getResources ().getDrawable (R.drawable.cursor_text));
                    break;

                case 1:
                    switch (graphic){
                        case 0:   symbol.setImageDrawable (getResources ().getDrawable (R.drawable.grandma_low));break;
                        case 1:   symbol.setImageDrawable (getResources ().getDrawable (R.drawable.grandma));break;
                        case 2:   symbol.setImageDrawable (getResources ().getDrawable (R.drawable.grandma_high));break;
                    }
                    title2.setImageDrawable (getResources ().getDrawable (R.drawable.grandma_text));
                    break;

                case 2:
                    switch (graphic){
                        case 0:   symbol.setImageDrawable (getResources ().getDrawable (R.drawable.farm_low));break;
                        case 1:   symbol.setImageDrawable (getResources ().getDrawable (R.drawable.farm));break;
                        case 2:   symbol.setImageDrawable (getResources ().getDrawable (R.drawable.farm_high));break;
                    }
                    title2.setImageDrawable (getResources ().getDrawable (R.drawable.farm_text));
                    break;

                case 3:
                    switch (graphic){
                        case 0:   symbol.setImageDrawable (getResources ().getDrawable (R.drawable.mine_low));break;
                        case 1:   symbol.setImageDrawable (getResources ().getDrawable (R.drawable.mine));break;
                        case 2:   symbol.setImageDrawable (getResources ().getDrawable (R.drawable.mine_high));break;
                    }
                    title2.setImageDrawable (getResources ().getDrawable (R.drawable.mine_text));
                    break;

                case 4:
                    switch (graphic){
                        case 0:   symbol.setImageDrawable (getResources ().getDrawable (R.drawable.factory_low));break;
                        case 1:   symbol.setImageDrawable (getResources ().getDrawable (R.drawable.factory));break;
                        case 2:   symbol.setImageDrawable (getResources ().getDrawable (R.drawable.factory_high));break;
                    }
                    title2.setImageDrawable (getResources ().getDrawable (R.drawable.factory_text));
                    break;

                case 5:
                    switch (graphic){
                        case 0:   symbol.setImageDrawable (getResources ().getDrawable (R.drawable.bank_low));break;
                        case 1:   symbol.setImageDrawable (getResources ().getDrawable (R.drawable.bank));break;
                        case 2:   symbol.setImageDrawable (getResources ().getDrawable (R.drawable.bank_high));break;
                    }
                    title2.setImageDrawable (getResources ().getDrawable (R.drawable.bank_text));
                    break;

                case 6:
                    switch (graphic){
                        case 0:   symbol.setImageDrawable (getResources ().getDrawable (R.drawable.temple_low));break;
                        case 1:   symbol.setImageDrawable (getResources ().getDrawable (R.drawable.temple));break;
                        case 2:   symbol.setImageDrawable (getResources ().getDrawable (R.drawable.temple_high));break;
                    }
                    title2.setImageDrawable (getResources ().getDrawable (R.drawable.temple_text));
                    break;

                case 7:
                    switch (graphic){
                        case 0:   symbol.setImageDrawable (getResources ().getDrawable (R.drawable.wizard_tower_low));break;
                        case 1:   symbol.setImageDrawable (getResources ().getDrawable (R.drawable.wizard_tower));break;
                        case 2:   symbol.setImageDrawable (getResources ().getDrawable (R.drawable.wizard_tower_high));break;
                    }
                    title2.setImageDrawable (getResources ().getDrawable (R.drawable.wizard_tower_text));
                    break;

                case 8:
                    switch (graphic){
                        case 0:   symbol.setImageDrawable (getResources ().getDrawable (R.drawable.shipment_low));break;
                        case 1:   symbol.setImageDrawable (getResources ().getDrawable (R.drawable.shipment));break;
                        case 2:   symbol.setImageDrawable (getResources ().getDrawable (R.drawable.shipment_high));break;
                    }
                    title2.setImageDrawable (getResources ().getDrawable (R.drawable.shipment_text));
                    break;

                case 9:
                    switch (graphic){
                        case 0:   symbol.setImageDrawable (getResources ().getDrawable (R.drawable.alchemylab_low));break;
                        case 1:   symbol.setImageDrawable (getResources ().getDrawable (R.drawable.alchemylab));break;
                        case 2:   symbol.setImageDrawable (getResources ().getDrawable (R.drawable.alchemylab_high));break;
                    }
                    title2.setImageDrawable (getResources ().getDrawable (R.drawable.alchemylab_text));
                    break;

                case 10:
                    switch (graphic){
                        case 0:   symbol.setImageDrawable (getResources ().getDrawable (R.drawable.portal_low));break;
                        case 1:   symbol.setImageDrawable (getResources ().getDrawable (R.drawable.portal));break;
                        case 2:   symbol.setImageDrawable (getResources ().getDrawable (R.drawable.portal_high));break;
                    }
                    title2.setImageDrawable (getResources ().getDrawable (R.drawable.portal_text));
                    break;

                case 11:
                    switch (graphic){
                        case 0:   symbol.setImageDrawable (getResources ().getDrawable (R.drawable.time_machine_low));break;
                        case 1:   symbol.setImageDrawable (getResources ().getDrawable (R.drawable.time_machine));break;
                        case 2:   symbol.setImageDrawable (getResources ().getDrawable (R.drawable.time_machine_high));break;
                    }
                    title2.setImageDrawable (getResources ().getDrawable (R.drawable.time_machine_text));
                    break;

                case 12:
                    switch (graphic){
                        case 0:   symbol.setImageDrawable (getResources ().getDrawable (R.drawable.antimatter_condenser_low));break;
                        case 1:   symbol.setImageDrawable (getResources ().getDrawable (R.drawable.antimatter_condenser));break;
                        case 2:   symbol.setImageDrawable (getResources ().getDrawable (R.drawable.antimatter_condenser_high));break;
                    }
                    title2.setImageDrawable (getResources ().getDrawable (R.drawable.antimatter_condenser_text));
                    break;

                case 13:
                    switch (graphic){
                        case 0:   symbol.setImageDrawable (getResources ().getDrawable (R.drawable.prism_low));break;
                        case 1:   symbol.setImageDrawable (getResources ().getDrawable (R.drawable.prism));break;
                        case 2:   symbol.setImageDrawable (getResources ().getDrawable (R.drawable.prism_high));break;
                    }
                    title2.setImageDrawable (getResources ().getDrawable (R.drawable.prism_text));
                    break;

                case 14:
                    switch (graphic){
                        case 0:   symbol.setImageDrawable (getResources ().getDrawable (R.drawable.chancemaker_low));break;
                        case 1:   symbol.setImageDrawable (getResources ().getDrawable (R.drawable.chancemaker));break;
                        case 2:   symbol.setImageDrawable (getResources ().getDrawable (R.drawable.chancemaker_high));break;
                    }
                    title2.setImageDrawable (getResources ().getDrawable (R.drawable.chancemaker_text));
                    break;


            }
            info_bg.add (buildings_palette.findViewById (R.id.info_bg));
            info_bottom1[i]=(buildings_palette.findViewById (R.id.info_bottom));
            info_bottom2.add(buildings_palette.findViewById (R.id.info_bottom2));
            info_percent.add ((TextView)buildings_palette.findViewById (R.id.info_right));
            final TextView title3=buildings_palette.findViewById (R.id.info_title);
            info_title.add(title3);
            info_color_bg.add((ImageView) buildings_palette.findViewById (R.id.color_bg));
            //prevent buying in info mode
            info_bg.elementAt (i).setOnClickListener (new View.OnClickListener () {
                @Override
                public void onClick (View view) {

                }
            });

            title3.setText (name_upgrades[i]);
            cost.setText (number_to_formatted_string (now_cost[i]));
            number.setText (now_number_of[i]);
            palette_menu.setId (100+i);
            cost.setId (200+i);
            number.setId (300+i);
            buildings[i]=cost;
            buildings2[i]=number;
            palette_menu.setOnClickListener (new View.OnClickListener () {
                @Override
                public void onClick (View view) {
                    click_my (view);
                }
            });
            menu2_buildings.addView (buildings_palette);


        }

        load_progress (0.90f);



        startService(service_gold);

        Log.e ("MY6","9---> "+String.valueOf (currentTimeMillis() - mtime     +"---> "+String.valueOf (nanoTime () - ntime)));

        //final int tmp = 1000 / fps;
//TODO cps thread
/*=========================================================================
TIMER WITH 100 MILLIS. OF INTERVAL
==========================================================================*/
        final Thread thread = new Thread () {

            @Override
            public void run () {
                try {

                    while (!isInterrupted ()) {
                        if (fps==0) fps=20;
                            Thread.sleep (1000/fps);
                        runOnUiThread (new Runnable () {
                            @Override
                            public void run () {

                                BigDecimal cps1=cps.multiply (BigDecimal.valueOf ((double)multiply_production));

                                if ( cps1.divide (new BigDecimal (String.valueOf (fps)),4,RoundingMode.HALF_UP)
                                             .compareTo (new BigDecimal (cps1.divide (new BigDecimal (String.valueOf (fps)),4,RoundingMode.HALF_UP).toBigInteger ().toString ())) == 0) {
                                    my_cookie = my_cookie.add ((cps1.divide (new BigDecimal (String.valueOf (fps)),4,RoundingMode.HALF_UP).toBigInteger ()).add (cps_backup.toBigInteger ()));
                                    my_cps_cookie=my_cps_cookie.add((cps1.divide (new BigDecimal (String.valueOf (fps)),4,RoundingMode.HALF_UP).toBigInteger ()).add (cps_backup.toBigInteger ()));


                                } else {
                                    cps_backup = cps_backup.add ((cps1.divide (new BigDecimal (String.valueOf (fps)),4,RoundingMode.HALF_UP)).subtract (new BigDecimal (cps1.divide (new BigDecimal (String.valueOf (fps)),4,RoundingMode.HALF_UP).toBigInteger ().toString ())));
                                    my_cookie = my_cookie.add ((cps1.divide (new BigDecimal (String.valueOf (fps)),4,RoundingMode.HALF_UP).toBigInteger ()).add (cps_backup.toBigInteger ()));
                                    my_cps_cookie=my_cps_cookie.add ((cps1.divide (new BigDecimal (String.valueOf (fps)),4,RoundingMode.HALF_UP).toBigInteger ()).add (cps_backup.toBigInteger ()));

                                    cps_backup = cps_backup.subtract (new BigDecimal (cps_backup.toBigInteger ().toString ()));
                                }


                                number_of_cookie.setText (number_to_formatted_string (my_cookie) + " Cookies");
                                // final TextView a=findViewById (3300+0);if (a!=null)a.setText (number_to_formatted_string (my_cookie));
                                // final TextView b=findViewById (3300+2);if (b!=null)a.setText (number_to_formatted_string (my_cps_cookie));
                                cps_txt.setText (decimal_to_formatted_string (cps1)+" cps");



                                for(int i=0;i<how_many_buildings_i_have;i++){
                                    if ( my_cookie.compareTo ((new BigDecimal (initial_cost[i].toString ()).multiply (new BigDecimal (String.valueOf ((Math.pow (1.15, my_build[i])))))).toBigInteger ()) >= 0 ) {
                                        buildings[i].setTextColor (Color.GREEN);
                                    } else buildings[i].setTextColor (Color.GRAY);
                                }

/*
                                if ( my_cookie.compareTo ((new BigDecimal (initial_cost[0].toString ()).multiply (new BigDecimal (String.valueOf ((Math.pow (1.15, my_cursor)))))).toBigInteger ()) >= 0 ) {
                                    buildings[0].setTextColor (Color.GREEN);
                                } else buildings[0].setTextColor (Color.GRAY);

                                if ( my_cookie.compareTo ((new BigDecimal (initial_cost[1].toString ()).multiply (new BigDecimal (String.valueOf ((Math.pow (1.15, my_grandma)))))).toBigInteger ()) >= 0 ) {
                                    buildings[1].setTextColor (Color.GREEN);
                                } else buildings[1].setTextColor (Color.GRAY);

                                if ( my_cookie.compareTo ((new BigDecimal (initial_cost[2].toString ()).multiply (new BigDecimal (String.valueOf ((Math.pow (1.15, my_farm)))))).toBigInteger ()) >= 0 ) {
                                    buildings[2].setTextColor (Color.GREEN);
                                } else buildings[2].setTextColor (Color.GRAY);

                                if ( my_cookie.compareTo ((new BigDecimal (initial_cost[3].toString ()).multiply (new BigDecimal (String.valueOf ((Math.pow (1.15, my_mine)))))).toBigInteger ()) >= 0 ) {
                                    buildings[3].setTextColor (Color.GREEN);
                                } else buildings[3].setTextColor (Color.GRAY);*/

                                wait_till_upgrade_buy+=(1000/fps);
                                wait_till_build_gave_update+=(1000/fps);
                                if (wait_till_upgrade_buy>=600) {

                                    for (final String ed : costi_fast) {

                                        if ( my_cookie.compareTo (new BigInteger (ed)) >= 0 ) {
                                            upgrade_gray.elementAt (costi_fast.indexOf (ed)).animate ().alpha (0f).setDuration (600).withEndAction (new Runnable () {
                                                @Override
                                                public void run () {
                                                    upgrade_gray.elementAt (costi_fast.indexOf (ed)).setVisibility (View.INVISIBLE);
                                                }
                                            });

                                        } else {
                                            upgrade_gray.elementAt (costi_fast.indexOf (ed)).setVisibility (View.VISIBLE);
                                            upgrade_gray.elementAt (costi_fast.indexOf (ed)).animate ().alpha (1f).setDuration (600).start ();
                                        }
                                    }



                                    for (final String ed : costi_fast2) {

                                        if ( my_cookie.compareTo (new BigInteger (ed)) >= 0 ) {
                                            upgrade_gray2.elementAt (costi_fast2.indexOf (ed)).animate ().alpha (0f).setDuration (600).withEndAction (new Runnable () {
                                                @Override
                                                public void run () {
                                                    upgrade_gray2.elementAt (costi_fast2.indexOf (ed)).setVisibility (View.INVISIBLE);
                                                }
                                            });

                                        } else {
                                            upgrade_gray2.elementAt (costi_fast2.indexOf (ed)).setVisibility (View.VISIBLE);
                                            upgrade_gray2.elementAt (costi_fast2.indexOf (ed)).animate ().alpha (1f).setDuration (600).start ();
                                        }
                                    }



                                    for (final String ed : costi_fast_skill) {

                                        if ( my_cookie.compareTo (new BigInteger (ed)) >= 0 ) {
                                            skill_gray.elementAt (costi_fast_skill.indexOf (ed)).animate ().alpha (0f).setDuration (600).withEndAction (new Runnable () {
                                                @Override
                                                public void run () {
                                                    skill_gray.elementAt (costi_fast_skill.indexOf (ed)).setVisibility (View.INVISIBLE);
                                                }
                                            });

                                        } else {
                                            skill_gray.elementAt (costi_fast_skill.indexOf (ed)).setVisibility (View.VISIBLE);
                                            skill_gray.elementAt (costi_fast_skill.indexOf (ed)).animate ().alpha (1f).setDuration (600).start ();
                                        }
                                    }

                                    wait_till_upgrade_buy-=600;
                                }



                                if (wait_till_build_gave_update>=1000) {

                                    wait_till_build_gave_update-=1000;
                                }

                                if (stat_update){
                                    stat_my_cookie.setText (number_to_formatted_string (my_cookie));
                                    stat_hand_made.setText (number_to_formatted_string (my_cookie_clicked));
                                    stat_build_cookie.setText (number_to_formatted_string (my_cps_cookie));
                                    stat_time_game.setText (seconds_to_string ((System.currentTimeMillis ()-Long.parseLong (read_txt ("game_start")))/1000));
                                }


                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };
        thread.start ();
        active_activity=0;
        load_progress (1f);


        exit.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                /*save ();
                save_txt ("skill_su_state",String.valueOf (su));
                startActivity (new Intent (MainActivity.this, SettingsActivityActivity.class));*/
                MediaPlayer.create (getApplicationContext (),R.raw.fx_menu_laterale_in).start ();
                settings_menu.animate ().translationX (0);
                active_activity=6;
            }

        });
        settings_menu.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                //Just to capture clicks on background
            }
        });


        button.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                //Add Cookie

                if (vibrate) {
                    Vibrator v = (Vibrator) getSystemService (Context.VIBRATOR_SERVICE);
                    v.vibrate (vibration_length);
                }

                MyBounceInterpolator interpolator = new MyBounceInterpolator (0.45, 12);
                myAnim.setInterpolator (interpolator);

                button.startAnimation (myAnim);


                if (multy_directions){
                    String testo = "+" + number_to_formatted_string (cookie_click_add
                            .add (cps.divide (new BigDecimal ("100"),RoundingMode.HALF_UP).multiply (BigDecimal.valueOf(click_plus_percent_cps)).toBigInteger ())
                            .multiply (BigInteger.valueOf (click_multiply_production)));
                    final TextView textView = new TextView (getApplicationContext ());
                    textView.setX (x_max/2-140);
                    textView.setY (button.getY ()+menu_button.getY ()+button.getHeight ()/2-60);
                    textView.setText (testo);
                    int size_random = 28;
                    if(production777) size_random = (int) (Math.random () * 11 * bounce_effect) + 33 - (int) (bounce_effect * 4);
                    int duration = (int) (Math.random () * 500) + 1000;
                    textView.setTextSize (size_random);
                    Typeface type = Typeface.createFromAsset (getAssets (), "font/komikax.ttf");
                    textView.setTypeface (type);
                    menu.addView (textView);
                    textView.setTextColor (new Color ().rgb (230, 230, 230));
                    if (production777)textView.setTextColor (getResources ().getColor (R.color.gold));
                    if ( Random_click_color )
                        textView.setTextColor (new Color ().rgb ((int) (Math.random () * 255), (int) (Math.random () * 255), (int) (Math.random () * 255)));

                    float h=(float)Math.cos (Math.toRadians ((double)angolo))*800f;
                    float l=(float)Math.sin (Math.toRadians ((double)angolo))*800f;

                    MyBounceInterpolator interpolator2 = new MyBounceInterpolator (0.55, 20);
                    textView.animate ()
                            .translationYBy (- h)
                            .translationXBy (l)

                            .alpha (0f) //float value
                            .setDuration (1400)
                            .setListener (new AnimatorListenerAdapter () {

                                public void onAnimationEnd (Animator animation) {
                                    menu.removeView (textView);
                                }
                            })
                            .start ();

                /*    textView.animate ()
                            .translationX (textView.getX () - altezza1)
                            .setDuration (duration + 300).setInterpolator (interpolator2)
                            .start ();*/

                    angolo+=12;if(angolo>360)angolo-=360;
                }
            }
        });
        Log.e ("MY6","10---> "+String.valueOf (currentTimeMillis() - mtime     +"---> "+String.valueOf (nanoTime () - ntime)));
//TODO Cookie touch
        button.setOnTouchListener (new View.OnTouchListener () {
            @Override
            public boolean onTouch (View view, MotionEvent motionEvent) {



                if ( motionEvent.getAction () == MotionEvent.ACTION_UP ) {


                    int rand=(int)(Math.random ()*21);
                    switch (rand){
                        case 0:mPlayer = MediaPlayer.create(getApplicationContext (), R.raw.click);break;
                        case 1:mPlayer=MediaPlayer.create (getApplicationContext (),R.raw.click2);break;
                        case 2:mPlayer=MediaPlayer.create (getApplicationContext (),R.raw.food1);break;
                        case 3:mPlayer=MediaPlayer.create (getApplicationContext (),R.raw.food2);break;
                        case 4:mPlayer=MediaPlayer.create (getApplicationContext (),R.raw.food3);break;
                        case 5:mPlayer=MediaPlayer.create (getApplicationContext (),R.raw.fx_click_button);break;
                        case 6:mPlayer=MediaPlayer.create (getApplicationContext (),R.raw.fx_badge);break;
                        case 7:mPlayer=MediaPlayer.create (getApplicationContext (),R.raw.click2_hw);break;
                        case 8:mPlayer=MediaPlayer.create (getApplicationContext (),R.raw.fx_pop_clock);break;
                        case 9:mPlayer=MediaPlayer.create (getApplicationContext (),R.raw.fx_dito);break;
                        case 10:mPlayer=MediaPlayer.create (getApplicationContext (),R.raw.extra_eat2);break;
                        case 11:mPlayer=MediaPlayer.create (getApplicationContext (),R.raw.extra_eat1);break;
                        case 12:mPlayer=MediaPlayer.create (getApplicationContext (),R.raw.minecraft_eat);break;
                        case 13:mPlayer=MediaPlayer.create (getApplicationContext (),R.raw.minecraft_eat2);break;
                        case 14:mPlayer=MediaPlayer.create (getApplicationContext (),R.raw.orteil_clickb1);break;
                        case 15:mPlayer=MediaPlayer.create (getApplicationContext (),R.raw.orteil_clickb2);break;
                        case 16:mPlayer=MediaPlayer.create (getApplicationContext (),R.raw.orteil_clickb3);break;
                        case 17:mPlayer=MediaPlayer.create (getApplicationContext (),R.raw.orteil_clickb4);break;
                        case 18:mPlayer=MediaPlayer.create (getApplicationContext (),R.raw.orteil_clickb5);break;
                        case 19:mPlayer=MediaPlayer.create (getApplicationContext (),R.raw.orteil_clickb6);break;
                        case 20:mPlayer=MediaPlayer.create (getApplicationContext (),R.raw.orteil_clickb7);break;


                    }


                    mPlayer.start ();
                    mPlayer.setOnCompletionListener (new MediaPlayer.OnCompletionListener () {
                        @Override
                        public void onCompletion (MediaPlayer mediaPlayer) {
                            mPlayer.stop ();
                        }
                    });


                    boolean critical=false;
                    int i=(int)(Math.random ()*200);
                    if (i<critical_click_power+(2*critical_chance)&&i>=0){
                        critical=true;
                        number_of_critical_click++;
                        click_multiply_production*=80;
                    }
                    my_cookie_clicked=my_cookie_clicked.add (cookie_click_add
                            .add (cps.divide (new BigDecimal ("100"),RoundingMode.HALF_UP).multiply (BigDecimal.valueOf(click_plus_percent_cps)).toBigInteger ())
                            .multiply (BigInteger.valueOf (click_multiply_production)));
                    Log.e("MY","ADDED: "+(cps.divide (new BigDecimal ("100"),RoundingMode.HALF_UP).multiply (BigDecimal.valueOf(click_plus_percent_cps)).toBigInteger ()).toString ());

                    my_cookie = my_cookie.add (cookie_click_add
                            .add (cps.divide (new BigDecimal ("100"),RoundingMode.HALF_UP).multiply (BigDecimal.valueOf(click_plus_percent_cps)).toBigInteger ())
                            .multiply (BigInteger.valueOf (click_multiply_production)));

                    number_of_cookie.setText (number_to_formatted_string (my_cookie) + " Cookies");

                    int altezza = (int) ((600f / 1920f) * y_max);
                    int altezza1 = (int) ((50f / 1920f) * x_max);
                    if (effect[0]) {
                        //TextView



                        String testo = "+" + number_to_formatted_string (cookie_click_add
                                .add (cps.divide (new BigDecimal ("100"),RoundingMode.HALF_UP).multiply (BigDecimal.valueOf(click_plus_percent_cps)).toBigInteger ())
                                .multiply (BigInteger.valueOf (click_multiply_production)));

                        final TextView textView = new TextView (getApplicationContext ());
                        textView.setX (motionEvent.getX () + button.getX ());
                        textView.setY (motionEvent.getY () + menu_button.getY ());
                        textView.setText (testo);
                        int freq = (int) (Math.random () * 13) + 20;
                        int size_random = (int) (Math.random () * 11 * bounce_effect) + 25 - (int) (bounce_effect * 4);
                        if(production777||critical) size_random = (int) (Math.random () * 11 * bounce_effect) + 33 - (int) (bounce_effect * 4);
                        int duration = (int) (Math.random () * 500) + 1000;
                        if (critical)duration*=2;
                        textView.setTextSize (size_random);
                        Typeface type = Typeface.createFromAsset (getAssets (), "font/komikax.ttf");
                        textView.setTypeface (type);
                        menu.addView (textView);
                        textView.setTextColor (new Color ().rgb (230, 230, 230));
                        if ( Random_click_color )
                            textView.setTextColor (new Color ().rgb ((int) (Math.random () * 255), (int) (Math.random () * 255), (int) (Math.random () * 255)));

                        if (production777)textView.setTextColor (getResources ().getColor (R.color.gold));
                        if (critical)textView.setTextColor (getResources ().getColor (R.color.red_light));




                        MyBounceInterpolator interpolator = new MyBounceInterpolator (0.55, freq);
                        textView.animate ()
                                .translationY (textView.getY () - altezza)

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

                    }
                    final ImageView imageview = new ImageView (getApplicationContext ());
                    if(effect[1]) {
                        //Image View


                        int multi = 1;

                        if ( graphic == 2 ) {
                            imageview.setImageDrawable (getResources ().getDrawable (R.drawable.cookie_small_128));
                            multi = 2;
                        } else imageview.setImageDrawable (getResources ().getDrawable (R.drawable.cookie_small));

                        imageview.setX (motionEvent.getX () + sparkle.getX () - 64);
                        imageview.setY (motionEvent.getY () + menu_button.getY () + sparkle.getY () - 64 + 100);
                        imageview.setScaleType (ImageView.ScaleType.FIT_XY);


                        float scale = ((float) (Math.random () / 6) + 0.25f);
                        imageview.setScaleX (scale * 2 / multi);
                        imageview.setScaleY (scale * 2 / multi);

                        menu.addView (imageview);

                        int rotation = (int) (Math.random () * 300);
                        CurveInterpolator2 interpolator2 = new CurveInterpolator2 ();

                        altezza = (int) ((400f / 1920f) * y_max);


                        imageview.animate ()
                                .rotation (rotation)
                                .translationY (imageview.getY () + altezza)

                                .alpha (0f) //float value
                                .setDuration (500)
                                .setInterpolator (interpolator2)
                                .setListener (new AnimatorListenerAdapter () {

                                    public void onAnimationEnd (Animator animation) {
                                        menu.removeView (imageview);
                                    }
                                })
                                .start ();
                        CurveInterpolator interpolator1 = new CurveInterpolator (14);
                        float transition1 = (float) ((int) (Math.random () * 600) - 300);
                        altezza1 = (int) ((transition1 / 1920f) * y_max);

                        imageview.animate ()
                                .translationX (imageview.getX () + altezza1)
                                .setDuration (600)
                                .setInterpolator (interpolator1)
                                .start ();
                    }

                    if(effect[2]) {


                        //Image View2

                        final ImageView effect = new ImageView (getApplicationContext ());

                        effect.setImageDrawable (getResources ().getDrawable (R.drawable.click_sparkle));
                        final float scale2 = 0.2f;
                        int to_add = (int) (256f * scale2);
                        effect.setX (motionEvent.getX () + sparkle.getX () - to_add);
                        effect.setY (motionEvent.getY () + menu_button.getY () + sparkle.getY () - to_add);
                        effect.setScaleType (ImageView.ScaleType.FIT_XY);

                        float mol = (float) (Math.random () * 2) + 3;

                        effect.setScaleX (scale2);
                        effect.setScaleY (scale2);
                        effect.setAlpha (0.2f);
                        menu.addView (effect);


                        final float opacity = (float) (Math.random () / 3.5) + 0.2f;
                        effect.animate ()
                                .scaleX (scale2 * mol)
                                .scaleY (scale2 * mol)
                                .alpha (opacity) //float value
                                .setDuration (250)
                                //.setInterpolator (interpolator2)
                                .setListener (new AnimatorListenerAdapter () {

                                    public void onAnimationEnd (Animator animation) {
                                        effect.animate ()
                                                .scaleX (scale2 * 4)
                                                .scaleY (scale2 * 4)
                                                .alpha (0f) //float value
                                                .setDuration (200)
                                                .setListener (new AnimatorListenerAdapter () {

                                                    public void onAnimationEnd (Animator animation) {
                                                        menu.removeView (imageview);
                                                    }
                                                })
                                                .start ();

                                    }
                                })
                                .start ();
                    }


                    if(effect[3]) {
                        //Small cookie

                        final ImageView small_cookie = new ImageView (getApplicationContext ());

                        small_cookie.setImageDrawable (getResources ().getDrawable (R.drawable.cookie_small_128));


                        int pos_x = (int) (Math.random () * (x_max - 64)) - 64;

                        int a = (int) (Math.random () * 4) + 8;
                        int b = (int) (Math.random () * 80) + 10;
                        int d = 1300; //(int)(Math.random ()*1800)+1800;
                        float c = (float) (Math.random () / 5) + 0.4f;
                        small_cookie.setScaleX (c);
                        small_cookie.setScaleY (c);
                        small_cookie.setX (pos_x);
                        small_cookie.setY (0 - 128 * 2.5f );
                        small_cookie.setScaleType (ImageView.ScaleType.FIT_XY);

                        menu.addView (small_cookie);
                        PowInterpolator inter = new PowInterpolator (2f);
                        small_cookie.animate ()
                                .translationY (y_max / 2 + 128 * c)
                                .setDuration (d)
                                .alpha (0f)
                                .setInterpolator (inter)
                                .setListener (new AnimatorListenerAdapter () {

                                    public void onAnimationEnd (Animator animation) {
                                        menu.removeView (small_cookie);
                                    }
                                })
                                .start ();


                    }
                    if(critical)click_multiply_production/=80;
                }
                return false;
            }
        });
        Log.e ("MY6","11---> "+String.valueOf (currentTimeMillis() - mtime     +"---> "+String.valueOf (nanoTime () - ntime)));

        default_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i=0;i<effect.length;i++)effect[i]=true;
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                save_txt ("settings",String.valueOf(false)+"-"+String.valueOf(1)+"-"+
                              String.valueOf(false)+"-"+String.valueOf(1)+"-"+String.valueOf(20)+
                              "-"+String.valueOf (false)+"-100"+
                              "-"+bool_to_string (effect)+"-false");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                coloured_clicks.setChecked (false);
                fancy_text.setChecked (false);
                click_vibration.setChecked (false);
                bounce_effect_bar.setProgress (1);
                graphic_bar.setProgress (1);
                fps_txt.setText("Fps: 20fps");
                fps_bar.setProgress (2);
                setting_scelta=100;

            }
        });

        settings_exit.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
                save_txt ("settings",
                        String.valueOf(coloured_clicks.isChecked())+"-"+
                        String.valueOf(bounce_effect_bar.getProgress())+"-"+
                        String.valueOf(fancy_text.isChecked())+"-"+
                        String.valueOf(graphic_bar.getProgress())+"-"+
                        String.valueOf(fps_bar.getProgress()*5+10)+"-"+
                        String.valueOf (click_vibration.isChecked ())+"-"+
                        String.valueOf (setting_scelta)+"-"+bool_to_string (effect)+"-"+
                        String.valueOf (original_cookie.isChecked ()));
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                String leggo=read_txt ("settings");
                String leggo2[] = leggo.trim ().split ("-");

                if ( Boolean.valueOf (leggo2[0]) ) {
                    Random_click_color = true;
                }
                else Random_click_color=false;
                bounce_effect = Float.valueOf (leggo2[1]) / 2;
                if ( Boolean.valueOf (leggo2[2]) ) {
                    fancy_font=true;
                    Typeface type = Typeface.createFromAsset (getAssets (), "font/carter_one.ttf");
                    number_of_cookie.setTypeface (type);
                    number_of_cookie.setTextSize (32);
                    cps_txt.setTypeface (type);
                }
                else{
                    fancy_font=false;
                    Typeface type = Typeface.createFromAsset (getAssets (), "font/dancing_script.ttf");


                    number_of_cookie.setTypeface (type);
                    number_of_cookie.setTextSize (36);
                    cps_txt.setTypeface (type);
                }
                graphic=(Integer.parseInt (leggo2[3]));
                fps=(short)(Integer.parseInt (leggo2[4]));
                vibrate=Boolean.valueOf (leggo2[5]);
                vibration_length=Integer.parseInt (leggo2[6]);
                for (int i=0;i<leggo2[7].length ();i++)effect[i]= (leggo2[7].charAt (i))!='0';
                if ( leggo2.length>=9 ){
                    if ( Boolean.valueOf (leggo2[8]) )button.setBackground (getResources ().getDrawable (R.drawable.cookie_original_hover));
                    else button.setBackground (getResources ().getDrawable (R.drawable.cookie_2_1024_hover));
                }



                settings_menu.animate ().translationX(x_max);
active_activity=0;
MediaPlayer.create (getApplicationContext (),R.raw.fx_menu_laterale_out_2).start ();
            }
        });


        save_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save_txt ("nickname",nickname.getText().toString());
                Toast.makeText(getApplicationContext(),"Nickname saved successfully!",Toast.LENGTH_SHORT).show();
            }
        });

        nickname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nickname.setClickable(true);
                nickname.setCursorVisible(true);
                nickname.setFocusable(true);
                nickname.setFocusableInTouchMode(true);
            }
        });

        save_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save ();
                    Toast.makeText(getApplicationContext(),"Progresses saved successfully!",Toast.LENGTH_SHORT).show();
            }
        });

        save_exit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_UP)save_exit.setTextColor(getResources().getColor(R.color.white));
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN)save_exit.setTextColor(getResources().getColor(R.color.darkdark_grey));
                return false;
            }
        });


        reset_pregress_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                final boolean[] reset={true,false,false};


                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setTitle("What do you want to reset?");


                String[] items={"Progresses","Upgrades","Settings"};
                builder.setMultiChoiceItems (items, reset, new DialogInterface.OnMultiChoiceClickListener () {
                    @Override
                    public void onClick (DialogInterface dialogInterface, int i, boolean b) {
                        reset[i]=b;
                    }
                });

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss ();
                        String reset_txt="";
                        for (boolean elem:reset){
                            if (elem)reset_txt+="1"; else reset_txt+="0";
                        }


                        save_txt ("save_or_reset",reset_txt);
                        if(!read_txt ("save_or_reset").equals ("000")){
                            toast ("Restart app to reset");
                        }
                    }
                });

                builder.show();



            }
        });

        reset_pregress_button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_UP)reset_pregress_button.setTextColor(getResources().getColor(R.color.white));
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN)reset_pregress_button.setTextColor(getResources().getColor(R.color.darkdark_grey));
                return false;
            }
        });


        fps_bar.setOnSeekBarChangeListener (new SeekBar.OnSeekBarChangeListener () {
            @Override
            public void onProgressChanged (SeekBar seekBar, int i, boolean b) {
                fps_txt.setText("Fps: "+String.valueOf (fps_bar.getProgress ()*5+10)+"fps");
                fps=(short)((fps_bar.getProgress ()*5+10));
            }
            @Override
            public void onStartTrackingTouch (SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch (SeekBar seekBar) {}
        });



        vibration_settings.setOnClickListener (new View.OnClickListener () {
            private String chooseItem;
            @Override
            public void onClick (View view) {


                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setTitle("Set vibration length:");
                int pos=0;
                for(int i=0;i<listItemArr.length;i++){
                    if(Integer.parseInt (listItemArr[i])==setting_scelta)pos=i;
                }

                builder.setSingleChoiceItems(listItemArr, pos, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int itemIndex) {
                        chooseItem = listItemArr[itemIndex];
                        save_txt ("settings",String.valueOf(coloured_clicks.isChecked())+"-"+String.valueOf(bounce_effect_bar.getProgress())+"-"+
                                      String.valueOf(fancy_text.isChecked())+"-"+String.valueOf(graphic_bar.getProgress())+"-"+String.valueOf(fps_bar.getProgress()*5+10)+
                                      "-"+String.valueOf (click_vibration.isChecked ())+"-"+chooseItem+
                                      "-"+bool_to_string (effect));
                        setting_scelta=Integer.parseInt (chooseItem);
                        dialogInterface.dismiss ();
                    }
                });

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                builder.show();



            }
        });

        fancy_text.setOnCheckedChangeListener (new CompoundButton.OnCheckedChangeListener () {
            @Override
            public void onCheckedChanged (CompoundButton compoundButton, boolean b) {
                if (b){
                        fancy_font=true;
                        Typeface type = Typeface.createFromAsset (getAssets (), "font/carter_one.ttf");
                        number_of_cookie.setTypeface (type);
                        number_of_cookie.setTextSize (32);
                        cps_txt.setTypeface (type);
                }
                    else{
                        fancy_font=false;
                        Typeface type = Typeface.createFromAsset (getAssets (), "font/dancing_script.ttf");


                        number_of_cookie.setTypeface (type);
                        number_of_cookie.setTextSize (36);
                        cps_txt.setTypeface (type);
                    }

            }
        });


        final boolean tmp12[]=new boolean[5];
        click_effect.setOnCheckedChangeListener (new CompoundButton.OnCheckedChangeListener () {
            @Override
            public void onCheckedChanged (CompoundButton compoundButton, boolean b) {
                if(!click_effect.isChecked ()){
                    effect_settings.setVisibility (View.GONE);
                    for (int i=0;i<effect.length;i++)tmp12[i]=effect[i];
                    Arrays.fill (effect,false);
                }
                else {
                    effect_settings.setVisibility (View.VISIBLE);
                    for (int i=0;i<effect.length;i++)effect[i]=tmp12[i];
                }
            }
        });

original_cookie.setOnCheckedChangeListener (new CompoundButton.OnCheckedChangeListener () {
    @Override
    public void onCheckedChanged (CompoundButton compoundButton, boolean b) {
        if (b)button.setBackground (getResources ().getDrawable (R.drawable.cookie_original_hover));
        else button.setBackground (getResources ().getDrawable (R.drawable.cookie_2_1024_hover));
    }
});

        effect_settings.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setTitle("Set click effects:");


                String[] items={"Click number","Cookie drop","Click hit","Background cookie drop"};
                builder.setMultiChoiceItems (items, effect, new DialogInterface.OnMultiChoiceClickListener () {
                    @Override
                    public void onClick (DialogInterface dialogInterface, int i, boolean b) {
                        effect[i]=b;
                    }
                });

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss ();
                    }
                });

                builder.show();
            }
        });























        upgrade.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                MediaPlayer mm=MediaPlayer.create (getApplicationContext (),R.raw.fx_menu_laterale_in);mm.start ();
                window_to_transition=1;
                active_activity=1;
                save ();
                //save_txt ("skill_su_state",String.valueOf (su));

               /* Intent i=new Intent (MainActivity.this, upgrade_activity.class).putExtra ("cps",cps.toString ()).putExtra ("fps",String.valueOf (fps))
                        .putExtra ("fancy",fancy_font).putExtra ("golden_num",number_of_golden_cookie);


                i.putExtra ("each",builds_give);
                trans = false;

                startActivity (i);
                finish ();*/
                menu_upgrade.animate ().translationX (160).setDuration (400);



                //overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        exit2.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                save();
                finish ();
                System.exit (0);

            }
        });



        eye_animation.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
/*
                AnimatedVectorDrawableCompat avd;

                if (!animation1)avd= AnimatedVectorDrawableCompat.create(getApplicationContext (), R.drawable.eye_animation);
                else            avd= AnimatedVectorDrawableCompat.create(getApplicationContext (), R.drawable.eye_animation_reverse);

                eye_animation.setImageDrawable (avd);

                avd.start ();
*/


                if(!animation1){

                    for (int i=0;i<how_many_buildings_i_have;i++){
                        if(cps.compareTo (new BigDecimal ("0"))!=0) {
                            info_bottom1[i].setText (decimal_to_formatted_string (new BigDecimal (builds_give[i])));
                            BigDecimal percent=new BigDecimal (builds_give[i]).multiply (new BigDecimal ("100")).divide (cps, 2, BigDecimal.ROUND_HALF_UP);
                            info_percent.elementAt (i).setText (percent.toString () + "%");

                            String name_image = name_upgrades[i].toLowerCase ().replace (' ', '_');
                            int id2 = info_color_bg.elementAt (i).getContext ().getResources ().getIdentifier (name_image, "color", info_color_bg.elementAt (i).getContext ().getPackageName ());
                            info_color_bg.elementAt (i).setImageResource (id2);
                            info_color_bg.elementAt (i).setAlpha ((Float.valueOf (percent.toString ()))*0.008f);
                        }
                    }

                    for (int i=0;i<how_many_buildings_i_have;i++){
                        if (my_build[i]>0) {
                            info_bg.elementAt (i).setAlpha (0f);
                            //info_bottom1[i].setAlpha (0f);
                            //info_bottom2.elementAt (i).setAlpha (0f);
                            //info_percent.elementAt (i).setAlpha (0f);
                            //info_title.elementAt (i).setVisibility (View.VISIBLE);
                            //info_bottom1[i].setTranslationX (x_max);
                            //info_bottom2.elementAt (i).setTranslationX (x_max);
                            //info_percent.elementAt (i).setTranslationX (x_max);
                            //info_title.elementAt (i).setTranslationX (x_max);
                            info_bg.elementAt (i).setVisibility (View.VISIBLE);
                            info_bg.elementAt (i).setTranslationX (x_max);
                            //info_bottom1[i].setVisibility (View.VISIBLE);
                            //info_bottom2.elementAt (i).setVisibility (View.VISIBLE);
                            //info_percent.elementAt (i).setVisibility (View.VISIBLE);
                            //info_title.elementAt (i).setVisibility (View.VISIBLE);


                        }

                    }

                    for (int i=0;i<how_many_buildings_i_have;i++) {
                        if ( my_build[i]>0 ) {
                            info_bg.elementAt (i).animate ().alpha (1f);
                            info_bg.elementAt (i).animate ().translationX (0);
                            //info_bottom1[i].animate ().alpha (1f);
                            //info_bottom2.elementAt (i).animate ().alpha (1f);
                            //info_percent.elementAt (i).animate ().alpha (1f);
                            info_title.elementAt (i).animate ().alpha (1f);
                            //info_bottom1[i].animate ().translationX (0);
                            //info_bottom2.elementAt (i).animate ().translationX (0);
                            //info_percent.elementAt (i).animate ().translationX (0);
                            //info_title.elementAt (i).animate ().translationX (0);

                        }
                    }

                }
                else{
                    for (int i=0;i<how_many_buildings_i_have;i++){
                        if (my_build[i]>0) {
                            info_bg.elementAt (i).animate ().alpha (0f);
                            info_bg.elementAt (i).animate ().translationX (x_max);
                            //info_bottom1[i].setAlpha (0f);
                            //info_bottom2.elementAt (i).setAlpha (0f);
                            //info_percent.elementAt (i).setAlpha (0f);
                            //info_title.elementAt (i).animate ().translationX (x_max);
                            //info_bottom1[i].animate ().translationX (x_max);
                            //info_bottom2.elementAt (i).animate ().translationX (x_max);
                            //info_percent.elementAt (i).animate ().translationX (x_max).withEndAction (new Runnable () {
                            //                                @Override
                            //                                public void run () {
                            //                                    for (int i = 0; i < how_many_buildings_i_have; i++) {
                            //                                        info_bg.elementAt (i).setVisibility (View.INVISIBLE);
                            //                                        info_bottom1[i].setVisibility (View.INVISIBLE);
                            //                                        info_bottom2.elementAt (i).setVisibility (View.INVISIBLE);
                            //                                        info_percent.elementAt (i).setVisibility (View.INVISIBLE);
                            //                                        info_title.elementAt (i).setVisibility (View.INVISIBLE);
                            //                                    }
                            //                                }
                            //                            });

                        }
                    }

                }
                if (animation1)animation1=false;
                else animation1=true;
            }
        });

        //ANIMATION FOR EYE ICON may be useful
        /*eye_animation.setOnTouchListener (new View.OnTouchListener () {
            @Override
            public boolean onTouch (View view, MotionEvent motionEvent) {
                if(motionEvent.getAction ()==MotionEvent.ACTION_DOWN){
                    MediaPlayer mm=MediaPlayer.create (getApplicationContext (),R.raw.orteil_clickon);mm.start ();
                }
                else if(motionEvent.getAction ()==MotionEvent.ACTION_UP){
                    MediaPlayer mm=MediaPlayer.create (getApplicationContext (),R.raw.orteil_clickoff);mm.start ();
                }
                return false;
            }
        });*/



        if(!read_txt ("skill_su_state").equals (""))su=Boolean.valueOf (read_txt ("skill_su_state"));
        save_txt ("skill_su_state","false");
        if(su){
            menu_skill_scrollview.setVisibility (View.VISIBLE);
            menu_skill_scrollview.setTranslationY ((int)80f/dpheight*y_max);
            menu_skill_scrollview.animate ().translationY (0).setInterpolator (new PowInterpolator (1.5f));
        }

        skill.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {

                if (!su){
                    menu_buildings.animate ().translationYBy (menu_buildings.getHeight ()).withEndAction (new Runnable () {
                        @Override
                        public void run () {
                            menu_buildings.setVisibility (View.GONE);
                            menu_skill_scrollview.setTranslationX (-x_max);
                            menu_skill_scrollview.setVisibility (View.VISIBLE);
                            menu_skill_scrollview.animate ().translationX (0).setInterpolator (new PowInterpolator (1.5f));
                        }
                    });

                }
                else {
                    menu_skill_scrollview.animate ().translationX (-x_max).setInterpolator (new PowInterpolator (1.5f)).withEndAction (new Runnable () {
                        @Override
                        public void run () {
                            menu_buildings.setVisibility (View.VISIBLE);
                            menu_buildings.animate ().translationY (0);
                        }
                    });

                }
                su=!su;


            }
        });
        skill.setOnTouchListener (new View.OnTouchListener () {
            @Override
            public boolean onTouch (View view, MotionEvent motionEvent) {
                if(motionEvent.getAction ()==MotionEvent.ACTION_DOWN){
                    MediaPlayer mm=MediaPlayer.create (getApplicationContext (),R.raw.orteil_clickon);mm.start ();
                }
                else if(motionEvent.getAction ()==MotionEvent.ACTION_UP){
                    MediaPlayer mm=MediaPlayer.create (getApplicationContext (),R.raw.orteil_clickoff);mm.start ();
                }
                return false;
            }
        });




        upgrade_right_arrow.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                if ( upgrade_current_tab!=upgrade_tab_count ){
                    last_menu.animate ().translationX (-x_max).setInterpolator (new PowInterpolator (1.7f)).withEndAction (new Runnable () {
                        @Override
                        public void run () {
                            last_menu.setVisibility (View.GONE);
                            last_menu2.animate ().translationX (0);
                            upgrade_current_tab++;
                        }
                    });

                    upgrade_right_arrow.setImageDrawable (getResources ().getDrawable (R.drawable.arrow_right_down));
                    upgrade_left_arrow.setImageDrawable (getResources ().getDrawable (R.drawable.arrow_left_blue));
                }
            }
        });

        upgrade_left_arrow.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                if ( upgrade_current_tab!=1 ){
                    last_menu2.animate ().translationX (x_max).setInterpolator (new PowInterpolator (1.7f)).withEndAction (new Runnable () {
                        @Override
                        public void run () {
                            last_menu.setVisibility (View.VISIBLE);
                            last_menu.animate ().translationX (0);
                            upgrade_current_tab--;
                        }
                    });
                    upgrade_right_arrow.setImageDrawable (getResources ().getDrawable (R.drawable.arrow_right_blue));
                    upgrade_left_arrow.setImageDrawable (getResources ().getDrawable (R.drawable.arrow_left_down));
                }
            }
        });

        stats_button.setOnClickListener (new View.OnClickListener () {
            @SuppressLint ("SetTextI18n")
            @Override
            public void onClick (View view) {
                if(active_activity==0){
                    stat_update=true;
                    //FILL FIELDs
                    stat_my_cookie.setText (number_to_formatted_string (my_cookie));
                    stat_hand_made.setText (number_to_formatted_string (my_cookie_clicked));
                    stat_build_cookie.setText (number_to_formatted_string (my_cps_cookie));
                    stat_game_start.setText (read_txt ("date_start"));
                    stat_time_game.setText (seconds_to_string ((System.currentTimeMillis ()-Long.parseLong (read_txt ("game_start")))/1000));
                    stat_critical_click.setText (String.valueOf (number_of_critical_click));
                    stat_golden_click.setText (String.valueOf (number_of_golden_cookie));
                    stat_offline_cookie.setText (number_to_formatted_string (my_offline_cookie));
                    stat_critical_chance.setText (String.valueOf ((critical_click_power+(2f*critical_chance))/200f*100f)+"%");
                    stat_builds_cost.setText (number_to_formatted_string (my_builds_cost));
                    stat_upgrades_cost.setText (number_to_formatted_string (my_upgrades_cost));
                    stat_click_power.setText (click_plus_percent_cps+"% cps");
                    stat_offline_time.setText (offline_production_hours+"h");


                    menu_statistics.animate ().translationY (0);
                    active_activity=3;
                    MediaPlayer tmp=MediaPlayer.create (getApplicationContext (),R.raw.fx_menu_laterale_in);tmp.start ();
                }
            }
        });



        stat_close.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                if(active_activity==3){
                    stat_update=false;
                    menu_statistics.animate ().translationY (-y_max-160f);
                    active_activity=0;
                    MediaPlayer tmp=MediaPlayer.create (getApplicationContext (),R.raw.fx_menu_laterale_out_2);tmp.start ();
                }
            }
        });

        stat_close.setOnTouchListener (new View.OnTouchListener () {
            @Override
            public boolean onTouch (View view, MotionEvent motionEvent) {
                if (motionEvent.getAction ()==MotionEvent.ACTION_DOWN)stat_close.setTextColor (getResources ().getColor (R.color.darkdark_grey));
                if (motionEvent.getAction ()==MotionEvent.ACTION_UP)stat_close.setTextColor (getResources ().getColor (R.color.orange));
                return false;

            }
        });

        menu_statistics.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
            }
        });



//TODO Loading Thread

        final Thread thread2 = new Thread () {

            @Override
            public void run () {
                try {
                    while (!isInterrupted ()) {
                        Thread.sleep (16);


                        runOnUiThread (new Runnable () {
                            @Override
                            public void run () {
                                loading_bar.requestLayout ();
                                loading += 0.008f;
                                loading_bar.setLayoutParams (new ConstraintLayout.LayoutParams ((int) (getResources ().getDrawable (R.drawable.progress_bar).getIntrinsicWidth () * loading), loading_default_height));
                                if(loading>=1f){
                                    splash.animate ().translationY (y_max+600).start ();
                                    if (!first_toast_shown) {
                                        Log.e ("MY7", cookie_earned_in_pause+"\n"+"Message showed after (millis)"+String.valueOf (System.currentTimeMillis ()-mtime));
                                        if ( !cookie_earned_in_pause.equals ("") && !cookie_earned_in_pause.equals ("0") ){
                                            Toast.makeText (getApplicationContext (),cookie_earned_in_pause,Toast.LENGTH_LONG).show ();
                                            first_toast_shown = !first_toast_shown;
                                        }
                                    }

                                }

                            }
                        });
                        if (loading>=1f) return;
                    }
                } catch (InterruptedException e) {
                }
            }
        };
        thread2.start ();




        //MILK ANIMATION

        final int milk_translation_time=15000;


        /*
        milk.animate ().translationXBy (x_max).setDuration (milk_translation_time).setListener (new AnimatorListenerAdapter () {
            @Override
            public void onAnimationEnd (Animator animation) {
                milk.setTranslationX (0);
                milk.animate ().translationXBy (x_max).setDuration (milk_translation_time);
            }
        });*/

        final Thread milk_translation = new Thread () {

            @Override
            public void run () {
                try {
                    while (!isInterrupted ()) {
                        Thread.sleep (milk_translation_time+20);

                        runOnUiThread (new Runnable () {

                            @Override
                            public void run () {
                                /*
                                milk1.animate ().translationXBy (x_max).setDuration (milk_translation_time);
                                milk2.animate ().translationXBy (x_max).setDuration (milk_translation_time).withEndAction (new Runnable () {
                                    @Override
                                    public void run () {
                                        milk1.setTranslationX (0);
                                        milk2.setTranslationX (-x_max);
                                    }
                                });
*/

                                //milk.animate ().translationXBy (x_max).setDuration (milk_translation_time);
                                //toast ("start milk animation");

                                milk2.setTranslationX (-x_max);
                                milk1.setTranslationX (0);
                                milk2.animate ().translationXBy (x_max).setDuration (milk_translation_time);
                                milk1.animate ().translationXBy (x_max).setDuration (milk_translation_time);
                            }
                        });

                    }
                } catch (InterruptedException e) {
                }
            }
        };
        milk_translation.start ();

/*
milk.animate ().translationXBy (x_max).setDuration (milk_translation_time).setListener (new AnimatorListenerAdapter () {
    @Override
    public void onAnimationEnd (Animator animation) {
        milk.setTranslationX (0);
        milk.animate ().translationXBy (x_max).setDuration (milk_translation_time).start ();
        super.onAnimationEnd (animation);
    }
}).start ();
*/
Log.e ("MY6","12---> "+String.valueOf (currentTimeMillis() - mtime     +"---> "+String.valueOf (nanoTime () - ntime)));
    }//End OnCreate()
















    //TODO click_my
    //@Override
    @SuppressLint ("ClickableViewAccessibility")
    public void click_my(final View v) {

        Log.d ("MY4","Clicked Id: "+String.valueOf (v.getId ()));


//TODO click_my (buildings)

        if (Integer.valueOf (v.getId ())<400&&Integer.valueOf (v.getId ())>=0) {
            //final TextView cost = v.findViewById (R.id.cost_of);
            //final TextView num = v.findViewById (R.id.number_of);
            final TextView cps_txt = findViewById (R.id.cps_txt);
            //final TextView cps_txt2 = findViewById (R.id.cps_txt2);
            final ConstraintLayout menu = (ConstraintLayout) findViewById (R.id.constraint_menu);
            BigDecimal cps_tmp = cps;

            int my_id = Integer.parseInt (String.valueOf (v.getId ()).substring (String.valueOf (v.getId ()).length ()-2));
            Log.d ("MY", String.valueOf (initial_cost[my_id]));
            if ( my_cookie.compareTo ((new BigDecimal (initial_cost[my_id].toString ()).multiply (new BigDecimal (String.valueOf ((Math.pow (1.15, my_build[my_id])))))).toBigInteger ()) > 0 ) {
                MediaPlayer mm=null;
                int ran=(int)(Math.random ()*4);
                switch (ran){
                    case 0:mm=MediaPlayer.create (getApplicationContext (),R.raw.orteil_buy1);break;
                    case 1:mm=MediaPlayer.create (getApplicationContext (),R.raw.orteil_buy2);break;
                    case 2:mm=MediaPlayer.create (getApplicationContext (),R.raw.orteil_buy3);break;
                    case 3:mm=MediaPlayer.create (getApplicationContext (),R.raw.orteil_buy4);break;
                }
                mm.start ();
                mm.setOnCompletionListener (new MediaPlayer.OnCompletionListener () {
                    @Override
                    public void onCompletion (MediaPlayer mediaPlayer) {
                        mediaPlayer.stop ();
                    }
                });

                //Update Important variable
                my_build[my_id] += 1;
                builds_give[my_id]=initial_give[my_id].multiply (BigDecimal.valueOf (my_build[my_id])).multiply (BigDecimal.valueOf (buildings_multiply[my_id])).toString ();
                my_cookie = my_cookie.subtract (((new BigDecimal (initial_cost[my_id].toString ()).multiply (new BigDecimal (String.valueOf ((Math.pow (1.15, my_build[my_id] - 1)))))).toBigInteger ()));
                my_builds_cost=my_builds_cost.add (((new BigDecimal (initial_cost[my_id].toString ()).multiply (new BigDecimal (String.valueOf ((Math.pow (1.15, my_build[my_id] - 1)))))).toBigInteger ()));
                buildings[my_id].setText (number_to_formatted_string ((new BigDecimal (initial_cost[my_id].toString ()).multiply (new BigDecimal (String.valueOf ((Math.pow (1.15, my_build[my_id])))))).toBigInteger ()));
                buildings2[my_id].setText (String.valueOf (my_build[my_id]));
                cps = cps.add (initial_give[my_id].multiply (BigDecimal.valueOf (buildings_multiply[my_id])));
                builds_given[my_id]=new BigDecimal(builds_given[my_id]).add ((initial_give[my_id].multiply (BigDecimal.valueOf (buildings_multiply[my_id])))).toString ();
                cps_txt.setText ((decimal_to_formatted_string (cps)) + " cps");
                //cps_txt2.setText ((decimal_to_formatted_string (cps)) + " cps");
            } else {
                MediaPlayer mm=MediaPlayer.create (getApplicationContext (),R.raw.fx_no_buy);mm.start ();
                return;
            }

            save ();

            if ( cps_tmp.compareTo (new BigDecimal ("0")) != 0 ) {

                final ScrollView buildings_menu = findViewById (R.id.buildings_menu);
                final TextView textView = new TextView (getApplicationContext ());
                textView.setX (x_max / 2);

                //toast (String.valueOf (v.getY ())+" "+String.valueOf (menu_builds_milk.getY ())+" "+String.valueOf (buildings_menu.getScrollY ()));

                textView.setY (v.getY () + menu_builds_milk.getY () - buildings_menu.getScrollY ());
                //if(v.getY ()+buildings_menu.getY()>y_max)textView.setY (y_max);
                textView.setText ("+ " + (cps.subtract (cps_tmp)).multiply (new BigDecimal ("100")).divide (cps_tmp, 2, RoundingMode.HALF_UP).toString () + "%");
                textView.setTextSize (28);
                Typeface type = Typeface.createFromAsset (getAssets (), "font/komikax.ttf");
                textView.setTypeface (type);
                menu.addView (textView);
                textView.setTextColor (new Color ().rgb (230, 230, 230));

                MyBounceInterpolator interpolator = new MyBounceInterpolator (0.55, 16 * (textView.getY () * 4) / 1200);
                textView.animate ()
                        .translationY (0)
                        .alpha (0f) //float value
                        .setDuration ((long) textView.getY () * 4L)
                        .setListener (new AnimatorListenerAdapter () {
                            public void onAnimationEnd (Animator animation) {
                                menu.removeView (textView);
                            }
                        })
                        .start ();

                textView.animate ()
                        .translationX (textView.getX () - 50f)
                        .setDuration ((long) textView.getY () * 4L + 300).setInterpolator (interpolator)
                        .start ();
            }

            int add=0;
            int i3=0;
            int required;
            if(my_id==0) {
                for (int i1=0;i1<required_progress_cursor.length;i1++)
                    if ( my_build[my_id] == Integer.parseInt (required_progress_cursor[i1]) ) {
                        required = Integer.parseInt (required_progress_cursor[i1]);
                        i3 = i1;
                        add++;
                    }

            }
            else {
                for (int i1=0;i1<required_progress.length;i1++)
                    if ( my_build[my_id] == Integer.parseInt (required_progress[i1]) ) {
                        required = Integer.parseInt (required_progress[i1]);
                        i3=i1;
                        add++;
                    }
            }
            //Stimating new index position
            String seed=String.valueOf (i3);
            if(i3<10)seed="0"+String.valueOf (i3);
            int new_pos=0;
            for(int h=0;h<=my_id;h++)new_pos+=showed_upgrades[h];

            for(int k=0;k<add;k++) {
                int i=i3;
                if (add>1&&k==0)i--;    //PER IL 1" CURSORE
                if (add>1&&k==1)new_pos++;

                LinearLayout.LayoutParams ll = new LinearLayout.LayoutParams (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                Typeface font_carter_one = Typeface.createFromAsset (getAssets (), "font/carter_one.ttf");
                View image2_ = LayoutInflater.from (this).inflate (R.layout.image2, null);
                final ConstraintLayout new_menu2 = image2_.findViewById (R.id.new_menu_example);
                final TextView title = image2_.findViewById (R.id.title2);
                final TextView cost2 = image2_.findViewById (R.id.cost);
                final TextView from = image2_.findViewById (R.id.from);
                final TextView to = image2_.findViewById (R.id.to);
                //final ImageView cookie_small = image2_.findViewById (R.id.image);
                final ImageView image2 = image2_.findViewById (R.id.image2);
                final ImageView gray = image2_.findViewById (R.id.upgrade_gray);
                final ImageView color_bg = image2_.findViewById (R.id.color_bg);
                final ImageView up1=image2_.findViewById (R.id.up1);
                final ImageView up2=image2_.findViewById (R.id.up2);
                final ImageView up3=image2_.findViewById (R.id.up3);

                int tmp=1;
                if ( i>3)tmp++;
                if(i>6)tmp++;
                //Toast.makeText (getApplicationContext (),"i:"+String.valueOf (i)+"\ttmp:"+String.valueOf (tmp)+"\tj1<="+String.valueOf ((i-1-(tmp-1)*3)),Toast.LENGTH_LONG).show ();
                for(int j1=0;j1<=(i-1-(tmp-1)*3);j1++){
                    if (j1==0){
                        if(tmp==1)up1.setImageDrawable (getResources ().getDrawable (R.drawable.skill_arrow_green));
                        if(tmp==2)up1.setImageDrawable (getResources ().getDrawable (R.drawable.skill_arrow_yellow));
                        if(tmp==3)up1.setImageDrawable (getResources ().getDrawable (R.drawable.skill_arrow_red));
                    }
                    if (j1==1){
                        if(tmp==1)up2.setImageDrawable (getResources ().getDrawable (R.drawable.skill_arrow_green));
                        if(tmp==2)up2.setImageDrawable (getResources ().getDrawable (R.drawable.skill_arrow_yellow));
                        if(tmp==3)up2.setImageDrawable (getResources ().getDrawable (R.drawable.skill_arrow_red));
                    }
                    if (j1==2){
                        if(tmp==1)up3.setImageDrawable (getResources ().getDrawable (R.drawable.skill_arrow_green));
                        if(tmp==2)up3.setImageDrawable (getResources ().getDrawable (R.drawable.skill_arrow_yellow));
                        if(tmp==3)up3.setImageDrawable (getResources ().getDrawable (R.drawable.skill_arrow_red));
                    }
                }
                String name_image = name_upgrades[my_id].toLowerCase ().replace (' ', '_');

                //Log.d ("MY4", String.valueOf (my_id) + " " + name_image);
                int id2 = color_bg.getContext ().getResources ().getIdentifier (name_image, "color", color_bg.getContext ().getPackageName ());
                color_bg.setImageResource (id2);
                color_bg.setAlpha ((float) (i + 1) / 10f);
                String add_id = String.valueOf (i+1);
                if ( i < 10 ) add_id = "0" + add_id;

                Boolean stop = false;

                // Log.d ("MY2", "id: " + ((String.valueOf (my_id + 5) + add_id)) + "---- bool: " + String.valueOf (fatti_fast.contains ((String.valueOf (my_id + 5) + add_id))));

                if ( fatti_fast.contains ((String.valueOf (my_id + 5) + add_id)) ) continue;
                // toast ("2");
                //if (fatti[Integer.valueOf(String.valueOf (my_id+5)+String.valueOf(i))])continue;

                if ( name_image.equals ("alchemy_lab") ) name_image = "alchemylab";

                BigInteger cost_now = new BigInteger (base_cost[my_id]).multiply (new BigInteger (cost_multiply[i]));
                if ( my_cookie.compareTo (cost_now) <= 0 ) stop = true;

                //Log.d ("MY", (String.valueOf (my_id + 5) + String.valueOf (i)));
                new_menu2.setId (Integer.valueOf (String.valueOf (my_id + 5) + add_id));

                //if ( stop ) image2_.setId (0-2);
                //new_menu2.setBackground (getResources ().getDrawable (R.color.dark_background));
                //if ( stop )
                //gray.setVisibility (View.VISIBLE);

                title.setText (name_upgrades[my_id]);
                title.setTextSize (20);
                title.setTypeface (font_carter_one);

                cost2.setText (number_to_formatted_string (cost_now));
                cost2.setTextSize (16);
                cost2.setTypeface (font_carter_one);

                from.setText ("Lv." + String.valueOf (i));
                from.setTextSize (20);
                from.setTypeface (font_carter_one);
                to.setVisibility (View.INVISIBLE);

                image2_.setPadding (0, 0, 0, 0);
                ll.setMargins (0, 15, 0, 0);
                image2_.setLayoutParams (ll);
                //image2.setImageDrawable (getResources ().getDrawable (R.drawable.cursor));
                Context context = image2.getContext ();
                int id = context.getResources ().getIdentifier (name_image, "drawable", context.getPackageName ());
                image2.setImageResource (id);

                if (list_upgrade.getChildCount ()<new_pos)list_upgrade.addView (image2_,list_upgrade.getChildCount());
                else list_upgrade.addView (image2_,new_pos);
                showed_upgrades[my_id]++;

                upgrade_counting++;
                findViewById (99900+0).setVisibility (View.GONE);    //Hide Nothing_to_show_box
                //skills.addElement (new_menu2.getId ());
                new_menu2.setOnClickListener (new View.OnClickListener () {
                    @Override
                    public void onClick (View view) {
                        click_my (view);
                    }
                });
                if ( Integer.valueOf (new_menu2.getId ()) >= 0 ) {
                    costi[new_menu2.getId ()] = cost_now.toString ();
                    costi_fast.addElement (cost_now.toString ());
                } else costi_fast.addElement (cost_now.toString ());
                upgrade_button.addElement (new_menu2.getId ());

                upgrade_gray.add (gray);
                if (!nothing_to_show_box)findViewById (99900+0).setVisibility (View.GONE);       //hide Nothing_to_show_box

                toast (String.valueOf (new_pos));
                //seed_id.add (new_menu2.getId ());
                seed_id.insertElementAt (new_menu2.getId (),new_pos);


                new_menu2.setOnTouchListener (new View.OnTouchListener () {
                    boolean done = false;

                    @Override
                    public boolean onTouch (View view, MotionEvent motionEvent) {
                        if ( motionEvent.getAction () == MotionEvent.ACTION_DOWN ) {
                            new_menu2.animate ().translationYBy (12).setDuration (35);
                            new CountDownTimer (1000, 1000) {
                                @Override
                                public void onTick (long l) {

                                }

                                @Override
                                public void onFinish () {
                                    if ( !done ) new_menu2.animate ().translationYBy (-12).setDuration (40);
                                }
                            }.start ();
                        }
                        if ( motionEvent.getAction () == MotionEvent.ACTION_UP || motionEvent.getAction () == MotionEvent.ACTION_HOVER_EXIT ) {
                            done = true;
                            new_menu2.animate ().translationYBy (-12).setDuration (40);
                        }
                        return false;
                    }
                });
            }
        }












//TODO click_my (Skill bar)

        else if (Integer.valueOf (v.getId ())>=2500&&Integer.valueOf (v.getId ())<2600) {
            final int my_id=Integer.parseInt (String.valueOf (v.getId ()).substring (String.valueOf (v.getId ()).length () - 2));
            //skill_pressed=my_id;
            //Log.d ("MY3","GIveMe "+String.valueOf (my_id));
            //startService (new Intent (getBaseContext (),skill_service.class).putExtra ("id",my_id));
            // skill_service run =new skill_service (my_id);


            final long countdown=Long.parseLong (skill_avaible[my_id].split ("-")[5])*1000L;
            bg_dark2[my_id].animate ().alpha (0f).setDuration (200);

            if (bg_dark[my_id].getVisibility ()==View.VISIBLE){
                MediaPlayer mm=MediaPlayer.create (getApplicationContext (),R.raw.orteil_press);mm.start ();
                toast ("Wait other "+String.valueOf (Math.round (bg_dark[my_id].getScaleY ()*countdown/1000))+" seconds");
                return;
            }
            int ran=(int)(Math.random ()*3);
            MediaPlayer mm=null;
            switch (ran){
                case 0: mm=MediaPlayer.create (getApplicationContext (),R.raw.fx_booster);mm.start ();break;
                case 1: mm=MediaPlayer.create (getApplicationContext (),R.raw.fx_booster_2);mm.start ();break;
                case 2: mm=MediaPlayer.create (getApplicationContext (),R.raw.fx_booster_3);mm.start ();break;
            }
            bg_dark[my_id].setVisibility (View.VISIBLE);
            final long time=Long.parseLong (skill_avaible[my_id].split ("-")[4])*1000L;
            long power=Long.parseLong (skill_avaible[my_id].split ("-")[3]);
            final long interval;
            if (my_id==0){
                interval=time/power; multy_directions=true;
            }
            else interval=36;//30fps
            switch (my_id){
                case 1:
                    click_multiply_production*=15;
                    production777=true;
                    break;
                case 2:
//                    try {thread1.wait (600);} catch (InterruptedException e){}
                    golden_cookie_velocity*=8;

                    break;
            }
            new CountDownTimer (time, interval) {
                public void onTick (long millisUntilFinished) {
                    switch (my_id) {
                        case 0:
                            button.performClick ();
                            break;
                    }
                    bg_dark[my_id].setScaleY ((float) (time-millisUntilFinished)/(float)time);
                    bg_dark[my_id].setTranslationY (40f/dpheight*y_max-((((float) (time-millisUntilFinished)/(float)time))*80f/dpheight*y_max)/2f);

                }

                public void onFinish () {
                    MediaPlayer mm=MediaPlayer.create (getApplicationContext (),R.raw.fx_time_button);mm.start ();
                    switch (my_id){
                        case 1:click_multiply_production/=15;
                            production777=false;
                            break;
                        case 2:
                            golden_cookie_velocity/=8;
                            break;
                    }
                    multy_directions=false;
                    bg_dark[my_id].animate ().translationY (40f/dpheight*y_max).setInterpolator (null).scaleY (0f).setDuration (countdown).withEndAction (new Runnable () {
                        @Override
                        public void run () {
                            bg_dark[my_id].setVisibility (View.INVISIBLE);
                            bg_dark2[my_id].animate ().alpha (1f).setDuration (200);
                        }
                    }).start ();
                }

            }.start ();
        }












//TODO click_my (Upgrade1)

        else if (Integer.valueOf (v.getId ())>=500&&Integer.valueOf (v.getId ())<2500) {

            if(my_cookie.compareTo (new BigInteger (costi[v.getId ()]))<0){
                toast ("You don't have enough cookies!");
                MediaPlayer mm=MediaPlayer.create (getApplicationContext (),R.raw.fx_no_buy);mm.start ();
                return;
            }
            MediaPlayer mm=MediaPlayer.create (getApplicationContext (),R.raw.buy);mm.start ();
            upgrade_counting--;
            if (upgrade_counting==0)findViewById (99900+0).setVisibility (View.VISIBLE);    //Show Nothing_to_show_box

            //tolgo gli ultimi due caratteri dall'id originale
            int my_id=Integer.parseInt(String.valueOf(String.valueOf(v.getId()).substring (0,String.valueOf (v.getId ()).length ()-2)));
            my_cookie=my_cookie.subtract(new BigInteger(costi[v.getId()]));
            my_upgrades_cost=my_upgrades_cost.add (new BigInteger(costi[v.getId()]));

            //SAVE COOKIE
            save ();
            save_upgrade (String.valueOf (my_id));

            fatti_fast.add (String.valueOf (v.getId ()));
            showed_upgrades[my_id-5]--;

            ////////////  SALVO FATTI_FAST  ///////////////////
            String write="";
            for(int j=0;j<fatti_fast.size ();j++){
                write+=fatti_fast.elementAt (j)+"-";
            }
            write=write.substring (0,write.length ()-1);

            try {
                String FILENAME = "upgrade_done";
                FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
                fos.write(write.getBytes());
                fos.close();
            } catch (IOException ed) {Log.e("ERROR", ed.toString());}
            //////////////////////////////////////////////////

            final TextView my_cookie_number=findViewById (R.id.number_of_my_cookie_skill);
            final TextView cps_txt=findViewById (R.id.cps_txt);

            v.animate ().translationXBy (x_max).setDuration (300).withEndAction (new Runnable () {
                @Override
                public void run () {
                    for (int i=seed_id.indexOf (v.getId ());i<seed_id.size ();i++) {
                        final View v2 = findViewById (seed_id.elementAt (i));
                        v2.animate ().translationYBy (-v.getHeight ()).withEndAction (new Runnable () {
                            @Override
                            public void run () {
                       /*    v.setVisibility (View.GONE);
                           v2.setTranslationY (0);*/

                            }
                        }).start ();
                    }
                }
            }).start ();


            final ConstraintLayout menu=findViewById (R.id.menu_upgrade2);
            final LinearLayout menu2=findViewById (R.id.menu_upgrade);
            final ScrollView menu3=findViewById (R.id.last_menu);
            BigDecimal cps_tmp=cps;

            //Log.d ("MY",Arrays.toString (builds_give));
            builds_give[my_id-5]=((new BigDecimal (builds_give[my_id-5])).multiply (new BigDecimal ("2"))).toString ();
            builds_given[my_id-5]=new BigDecimal(builds_given[my_id-5]).multiply (new BigDecimal ("2")).toString ();
            cps=new BigDecimal ("0");
            for(String lol:builds_give)cps=cps.add (new BigDecimal (lol));
            buildings_multiply[my_id-5]*=2;


            BigDecimal difference=cps.subtract (cps_tmp),
                    percent=new BigDecimal ("0");
            cps_txt.setText (decimal_to_formatted_string (cps)+" cps");
            percent=difference.multiply (new BigDecimal ("100")).divide (cps_tmp,2,RoundingMode.HALF_UP);

            Display display = getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            final int x_max=size.x;
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


            int size_random = (int) (Math.random () * 11) + 24;
            size_random=(int)(Float.valueOf (percent.toString ())/8+20);
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
                    .setDuration ((long)textView.getY ()*5L)
                    .setListener (new AnimatorListenerAdapter () {
                        public void onAnimationEnd (Animator animation) {menu.removeView (textView);}
                    })
                    .start ();

            textView.animate ()
                    .translationX (textView.getX ()-50f)
                    .setDuration ((long)textView.getY ()*5L + 300).setInterpolator (interpolator)
                    .start ();
        }












//TODO click_my (skill)

        else if(Integer.valueOf (v.getId ())>=2600&&Integer.valueOf (v.getId ())<2700){
            int my_id=Integer.parseInt (String.valueOf (v.getId ()).substring (String.valueOf (v.getId ()).length ()-2));

            if(my_cookie.compareTo (new BigInteger (costi_skill[my_id]))<0){
                MediaPlayer mm=MediaPlayer.create (getApplicationContext (),R.raw.fx_no_buy);mm.start ();
                toast ("You don't have enough cookies!");
                return;
            }
            MediaPlayer mm=MediaPlayer.create (getApplicationContext (),R.raw.buy);mm.start ();

            skill_counting--;

            skill_done.add (String.valueOf (v.getId ()));
            save_txt ("skill_done",read_txt ("skill_done")+String.valueOf (v.getId ())+"-");
            save_txt ("skill",read_txt ("skill")+String.valueOf (my_id));
            v.animate ().translationXBy (-x_max).setInterpolator (new PowInterpolator (1.7f)).withEndAction (new Runnable () {
                @Override
                public void run () {
                    for (int i=skills2.indexOf (v.getId ());i<skills2.size ();i++) {
                        View v2 = findViewById (skills2.elementAt (i));
                        v2.animate ().translationYBy (-v.getHeight ()).setInterpolator (new PowInterpolator (1.7f)).start ();
                    }
                }
            });

            final View skill_frame = LayoutInflater.from(this).inflate(R.layout.skill_frame, null);
            final ConstraintLayout new_menu=skill_frame.findViewById (R.id.frame_menu);
            final ImageView symbol=skill_frame.findViewById (R.id.frame_skill);
            final ImageView bg1=skill_frame.findViewById (R.id.frame_grey_bg);
            final ImageView bg2=skill_frame.findViewById (R.id.frame_grey_skill);
            final ImageView bg_color=skill_frame.findViewById (R.id.frame_bg);
            final ImageView bg_light=skill_frame.findViewById (R.id.frame_light);
            final ImageView bg_light_gold=skill_frame.findViewById (R.id.frame_bg_gold);


            bg1.setVisibility (View.INVISIBLE);
            bg2.setVisibility (View.INVISIBLE);
            int img = skill_frame.getContext ().getResources ().getIdentifier ("skill"+String.valueOf (my_id)+"00", "drawable", skill_frame.getContext ().getPackageName ());
            symbol.setImageResource (img);

            LinearLayout.LayoutParams ll = new LinearLayout.LayoutParams (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            ll.setMargins(0, 0, 10, 0);
            //  new_menu.setLayoutParams (ll);
            new_menu.setId (my_id+2500);
            new_menu.setOnClickListener (new View.OnClickListener () {
                @Override
                public void onClick (View view) {
                    click_my (view);
                }
            });
            bg_dark[my_id]=bg1;bg_dark2[my_id]=bg_light_gold;
            menu_skill[passo].addView (skill_frame);
            new_menu.setOnTouchListener (new View.OnTouchListener () {
                @Override
                public boolean onTouch (View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction ()==MotionEvent.ACTION_DOWN){
                        bg_light.setVisibility (View.VISIBLE);
                        skill_frame.setTranslationY (7f/dpheight*y_max);
                    }
                    if(motionEvent.getAction ()==MotionEvent.ACTION_UP||motionEvent.getAction ()==MotionEvent.ACTION_OUTSIDE){
                        bg_light.setVisibility (View.INVISIBLE);
                        skill_frame.setTranslationY (0);
                    }
                    return false;
                }
            });
            ++skill_added;
            if(skill_added>=skill_max){
                skill_added-=skill_max;
                passo++;
                menu_skill[passo]=new LinearLayout (getApplicationContext ());
                menu_skill[passo].setOrientation (LinearLayout.HORIZONTAL);

                menu_skill2.addView (menu_skill[passo]);
            }

        }

        else if(Integer.valueOf (v.getId ())==-2){
            toast ("You don't have enough cookies!");
            MediaPlayer mm=MediaPlayer.create (getApplicationContext (),R.raw.fx_no_buy);mm.start ();
        }












//TODO click_my (upgrade2)

        else if (Integer.valueOf (v.getId ())>=3000&&Integer.valueOf (v.getId ())<4000) {

            if(my_cookie.compareTo (new BigInteger (costi2[Integer.valueOf (v.getId ())-3000]))<0){
                toast ("You don't have enough cookies!");
                MediaPlayer mm=MediaPlayer.create (getApplicationContext (),R.raw.fx_no_buy);mm.start ();
                return;
            }
            MediaPlayer mm=MediaPlayer.create (getApplicationContext (),R.raw.buy);mm.start ();
            upgrade_counting2--;
            if (upgrade_counting2==0)findViewById (99900+1).setVisibility (View.VISIBLE);    //Show Nothing_to_show_box

            //tolgo gli ultimi due caratteri dall'id originale
            int my_id=Integer.parseInt(String.valueOf(String.valueOf(v.getId()).substring (0,String.valueOf (v.getId ()).length ()-2)));
            my_cookie=my_cookie.subtract(new BigInteger(costi2[Integer.valueOf (v.getId())-3000]));
            my_upgrades_cost=my_upgrades_cost.add(new BigInteger(costi2[Integer.valueOf (v.getId())-3000]));

            //SAVE COOKIE
            save ();

            String tmp_testo2=null;
            switch (my_id){
                case 30:
                    save_txt ("upgrade_tab2",read_txt ("upgrade_tab2")+"offline/");
                    tmp_testo2="";
                    break;
                case 31:
                    save_txt ("upgrade_tab2",read_txt ("upgrade_tab2")+"luck/");
                    tmp_testo2="Golden cookies appear twice as often";
                    golden_cookie_appear*=2;
                    golden_cookie_time*=2;

                    break;
                case 32:
                    save_txt ("upgrade_tab2",read_txt ("upgrade_tab2")+"arrow/");
                    tmp_testo2="Clicking gains +1% CpS";
                    click_plus_percent_cps++;
                    //cookie_click_add=cookie_click_add.add (cps.divide (new BigDecimal ("100")).toBigInteger ());  //old method
                    break;
                case 33:
                    save_txt ("upgrade_tab2",read_txt ("upgrade_tab2")+"critical/");
                    tmp_testo2="+1% chance of critical click";
                    critical_chance++;

                    break;
            }

            fatti_fast.add (String.valueOf (v.getId ()));

            ////////////  SALVO FATTI_FAST  ///////////////////old code
            String write="";
            for(int j=0;j<fatti_fast.size ();j++){
                write+=fatti_fast.elementAt (j)+"-";
            }
            write=write.substring (0,write.length ()-1);

            try {
                String FILENAME = "upgrade_done";
                FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
                fos.write(write.getBytes());
                fos.close();
            } catch (IOException ed) {Log.e("ERROR", ed.toString());}
            //////////////////////////////////////////



            v.animate ().translationXBy (x_max).setDuration (300).withEndAction (new Runnable () {
                @Override
                public void run () {
                    for (int i=seed_id2.indexOf (v.getId ());i<seed_id2.size ();i++) {
                        final View v2 = findViewById (seed_id2.elementAt (i));
                        v2.animate ().translationYBy (-v.getHeight ()).withEndAction (new Runnable () {
                            @Override
                            public void run () {
                                v.setVisibility (View.GONE);
                                v2.setTranslationY (0);

                            }
                        }).start ();
                    }
                }
            }).start ();


            final ConstraintLayout menu=findViewById (R.id.menu_upgrade2);
            final LinearLayout menu2=findViewById (R.id.menu_upgrade);
            final ScrollView menu3=findViewById (R.id.last_menu);

            Display display = getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            final int x_max=size.x,y_max=size.y;
            final TextView textView = new TextView (getApplicationContext ());
            textView.setX (x_max/4);
            final ScrollView last_menu=findViewById (R.id.last_menu);
            textView.setY (v.getY ()+menu2.getY()+menu3.getY ()-last_menu.getScrollY ());
            int my_id2=Integer.valueOf (String.valueOf (v.getId ()).substring (2));
            String tmp_testo=upgrade2[Integer.valueOf (my_id)-30][my_id2].split ("/")[1];
            if(my_id-30==0)tmp_testo2="+"+upgrade2[Integer.valueOf (my_id)-30][my_id2].split ("/")[3].replace ('-','%');

            //formatting tmp_testo2 for good visualization
            int space=0;
            if (tmp_testo.length ()-tmp_testo2.length ()>0)space=(tmp_testo.length ()-tmp_testo2.length ())/2;
            for(int i=0;i<space;i++){
                tmp_testo2=" "+tmp_testo2;
                tmp_testo2+=" ";
            }
            textView.setText (tmp_testo+"\n"+tmp_testo2);
            textView.setTextSize (16);
            Typeface type = Typeface.createFromAsset (getAssets (), "font/komikax.ttf");
            textView.setTypeface (type);
            menu.addView (textView);
            textView.setTextColor (new Color ().rgb (230, 230, 230));

            MyBounceInterpolator interpolator = new MyBounceInterpolator (0.55, 16*(textView.getY ()*4)/1200);
            textView.animate ()
                    .translationY (0)
                    .alpha (0f) //float value
                    .setDuration ((long)textView.getY ()*5L)
                    .setListener (new AnimatorListenerAdapter () {
                        public void onAnimationEnd (Animator animation) {menu.removeView (textView);}
                    })
                    .start ();

            textView.animate ()
                    .translationX (textView.getX ()-50f)
                    .setDuration ((long)textView.getY ()*5L + 300).setInterpolator (interpolator)
                    .start ();

        }
        Log.e ("MY6","13---> "+String.valueOf (currentTimeMillis() - mtime     +"---> "+String.valueOf (nanoTime () - ntime)));

    }//end  click_my()





















    @Override
    protected void onPause() {
        if (trans) {
            switch (window_to_transition){
                case 1:overridePendingTransition(R.anim.slide_in_right, R.anim.stop_transition);break;
                case 2:overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);break;
            }
        }
        super.onPause();
    }
    @Override
    protected void onResume() {
        super.onResume();
        trans=true;
    }

/*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2
        if(requestCode==2) {
            //toast("2");
            save();
        }
        if(requestCode==1){
            toast("1");
            reset_progress();
            reset_upgrade();
            Intent intent = getIntent();
            finish();
            startActivity(intent);
        }
    }*/

    private VelocityTracker mVelocityTracker = null;
    private float min=0,max=0;
    private float miny=0,maxy=0;
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int index = event.getActionIndex();
        int action = event.getActionMasked();
        int pointerId = event.getPointerId(index);

        switch(action) {
            case MotionEvent.ACTION_DOWN:
                min=event.getX ();
                miny=event.getY ();
                break;
            case MotionEvent.ACTION_MOVE:
                //TODO click_my (track)
                Log.d ("MY3",String.valueOf (active_activity)+"  "+String.valueOf (event.getX ()));
                if(active_activity==1){
                  /*  if(min/x_max>0.85){
                        last_menu2.setTranslationY (-last_menu.getHeight ());
                        last_menu.setTranslationX (-(x_max-event.getX ()));
                        last_menu2.setTranslationX (event.getX ());
                    }*/
                    if(min/x_max<0.15)menu_upgrade.setTranslationX (event.getX ());
                }
                if(active_activity==2)if(event.getX ()/x_max<=0.85&&min/x_max>0.85)menu_skill_laterale.setTranslationX (event.getX ()-x_max);
                if(active_activity==0){
                    if ( upgrade_counting != 0 )if(min/x_max>0.85)menu_upgrade.setTranslationX (event.getX ());
                    if ( skill_counting != 0 )  if(min/x_max<0.15)menu_skill_laterale.setTranslationX (event.getX ()-x_max);
                }
                if(active_activity==3)if(miny/y_max>0.85)menu_statistics.setTranslationY (event.getY ()-y_max);


                break;
            case MotionEvent.ACTION_UP:
                max=event.getX ();
                maxy=event.getY ();

            case MotionEvent.ACTION_CANCEL:
                if (active_activity==0) {

                    if ( upgrade_counting != 0 ) {
                        if ( min / x_max > 0.85f && (Math.abs (max - min) / x_max) > scroll_percent ) {
                            active_activity = 1;
                            menu_upgrade.animate ().translationX (160).setDuration (300);
                            MediaPlayer mm = MediaPlayer.create (getApplicationContext (), R.raw.fx_menu_laterale_in);
                            mm.start ();
                        } else menu_upgrade.animate ().translationX (x_max).setDuration (300);
                    }
                    if ( skill_counting != 0 ) {

                        if ( min / x_max < 0.15f && (Math.abs (max - min) / x_max) > scroll_percent ) {
                            active_activity = 2;
                            menu_skill_laterale.animate ().translationX (-50f / dpwidth * x_max).setDuration (300);
                            MediaPlayer mm = MediaPlayer.create (getApplicationContext (), R.raw.fx_menu_laterale_in);
                            mm.start ();
                        } else
                            menu_skill_laterale.animate ().translationX (-x_max).setDuration (300);
                    }
                    return true;

                }

                if (active_activity==1) {
                    if(min<160f&&(Math.abs (max-min)/x_max)>scroll_percent){
                        active_activity = 0;
                        menu_upgrade.animate ().translationX (x_max).setDuration (300);
                        MediaPlayer mm=MediaPlayer.create (getApplicationContext (),R.raw.fx_menu_laterale_out_2);
                        mm.start ();
                    }
                    else  menu_upgrade.animate ().translationX (160).setDuration (300);

                 /*   if(min/x_max>0.85f&&(Math.abs (max-min)/x_max)>scroll_percent){
                        active_activity = 3;
                        last_menu.animate ().translationX (-x_max).setDuration (300);
                        last_menu2.animate ().translationX (0);
                        MediaPlayer mm=MediaPlayer.create (getApplicationContext (),R.raw.fx_menu_laterale_in);
                        mm.start ();
                    }
                    else{
                        last_menu.animate ().translationX (0).setDuration (300);
                        last_menu2.animate ().translationX (x_max).withEndAction (new Runnable () {
                                                                                      @Override
                                                                                      public void run () {
                                                                                          last_menu2.setTranslationY (0);
                                                                                      }
                                                                                  }
                        );
                    }*/
                    return true;
                }
                if(active_activity==2){
                    if(min/x_max>0.85f&&(Math.abs (max-min)/x_max)>scroll_percent){
                        active_activity = 0;
                        menu_skill_laterale.animate ().translationX (-x_max).setDuration (400);
                        MediaPlayer mm=MediaPlayer.create (getApplicationContext (),R.raw.fx_menu_laterale_out_2);
                        mm.start ();
                    }
                    else  menu_skill_laterale.animate ().translationX (-50f/dpwidth*x_max).setDuration (400);
                    return true;
                }

             /*   if(active_activity==3){
                    if(min/x_max<0.15f&&(Math.abs (max-min)/x_max)>scroll_percent){
                        active_activity = 1;
                        last_menu2.animate ().translationX (-x_max).setDuration (x_max).withEndAction (new Runnable () {
                            @Override
                            public void run () {
                                last_menu2.setTranslationY (0);
                            }
                        });
                        last_menu.animate ().translationX (0);
                        MediaPlayer mm=MediaPlayer.create (getApplicationContext (),R.raw.fx_menu_laterale_out_2);
                        mm.start ();
                    }
                    else  {
                        last_menu.animate ().translationX (-x_max).setDuration (300);
                        last_menu2.animate ().translationX (0);
                    }
                    return true;
                }*/

                if(active_activity==3){
                    if(miny/y_max>0.85f&&Math.abs (maxy-miny)>scroll_percent){
                        menu_statistics.animate ().translationY (-y_max-120f);
                        MediaPlayer mm=MediaPlayer.create (getApplicationContext (),R.raw.fx_menu_laterale_out_2);
                        mm.start ();
                        active_activity=0;
                    }
                }

                if(upgrade_counting==0)menu_upgrade.setTranslationX (x_max);
                if(skill_counting==0)menu_skill_laterale.setTranslationX (-x_max);


                // Return a VelocityTracker object back to be re-used by others.
                //mVelocityTracker.recycle();
                break;

        }
        Log.e ("MY6","14---> "+String.valueOf (currentTimeMillis() - mtime     +"---> "+String.valueOf (nanoTime () - ntime)));
        return true;

    }


    protected void onDestroy (){
        super.onDestroy ();

        stopService (service_gold);
    }


    @Override
    protected void onStart()
    {
        super.onStart();
    }


}//End MainActivity()





/*

    ERRORE: GOLDEN COOKIE ISNT EFFICENT
    SKILL LOSE THE STATE WHEN CHANGE ACTIVITY

 */





/*
24/06/2018 ~ 02/07/2018		Clickable Cookie
				Save stat
				3 buildings
				Cps indicator
				Exit/Reset Button
				Price auto increasing

03/07/2018			optimization scrolling
 */