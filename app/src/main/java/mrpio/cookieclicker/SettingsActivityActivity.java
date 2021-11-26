package mrpio.cookieclicker;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import android.widget.Toast;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class SettingsActivityActivity extends AppCompatActivity {
    public int exit_state=0;
    int scelta=1;
    String listItemArr[] = {"75","100","150","250","500"};
boolean coloured_clicks_bool=false;
boolean effect[]=new boolean[4];
    void save_nickname(String txt){

        try {
            String FILENAME = "nickname";
            FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
            fos.write(txt.getBytes());
            fos.close();
        } catch (IOException ed) {
            Log.e("ERROR", ed.toString());
        }

    }

    String read(){
        String string="";
        try {
            String FILENAME = "nickname";
            byte[] bytes = new byte[1024];
            FileInputStream fis = openFileInput(FILENAME);
            fis.read(bytes);
            fis.close();
            string = new String(bytes);
        } catch (IOException e) {}
        return string;
    }

    void save_settings(String txt){
        //Log.d ("MY","Output - "+txt);
        try {
            String FILENAME = "settings";
            FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
            fos.write(txt.getBytes());
            fos.close();
        } catch (IOException ed) {
            Log.e("ERROR", ed.toString());
        }

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

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.settings_activity);
        /*getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);*/

        final TextView exit =(TextView)findViewById(R.id.exit2);
        final ImageView save_name =(ImageView)findViewById(R.id.save_name);
        final EditText nickname=(EditText)findViewById(R.id.nickname);
        final Switch coloured_clicks=(Switch)findViewById(R.id.coloured_clicks);
        final Button reset =(Button)findViewById(R.id.reset_all);
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



        nickname.setClickable(false);
        nickname.setCursorVisible(false);
        nickname.setFocusable(false);
        nickname.setFocusableInTouchMode(false);

        if (read().trim()!=""){
            nickname.setText(read().trim());
        }

        String leggo="";
        try {
            String FILENAME = "settings";
            byte[] bytes = new byte[1024];
            FileInputStream fis = openFileInput(FILENAME);
            fis.read(bytes);
            fis.close();
            leggo = new String(bytes);
            if(!leggo.trim().equals("")) {
                String[] leggo2 = leggo.trim ().split("-");
                coloured_clicks.setChecked(Boolean.valueOf(leggo2[0]));
                bounce_effect_bar.setProgress(Integer.parseInt(leggo2[1]));
                fancy_text.setChecked(Boolean.valueOf(leggo2[2]));
                graphic_bar.setProgress(Integer.parseInt(leggo2[3]));
                fps_bar.setProgress ((Integer.parseInt (leggo2[4])-10)/5);
                fps_txt.setText("Fps: "+String.valueOf (fps_bar.getProgress ()*5+10)+"fps");
                click_vibration.setChecked (Boolean.valueOf (leggo2[5]));
                scelta=Integer.parseInt (leggo2[6].trim ());
                boolean tmp=false;
                //Log.d ("MY","Input - "+leggo2[7].trim ());
                for (int i=0;i<leggo2[7].trim ().length ();i++){effect[i]= (leggo2[7].charAt (i))!='0';tmp=true;}
                if (!tmp)click_effect.setChecked (false);
                if ( leggo2.length>=9 )original_cookie.setChecked (Boolean.valueOf (leggo2[8]));

            }
        } catch (IOException e) {
            default_settings.performClick ();
        }

        default_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i=0;i<effect.length;i++)effect[i]=true;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                save_settings(String.valueOf(false)+"-"+String.valueOf(1)+"-"+
                        String.valueOf(false)+"-"+String.valueOf(1)+"-"+String.valueOf(20)+
                "-"+String.valueOf (false)+"-100"+
                              "-"+bool_to_string (effect)+"-false");
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*
                Intent intent = getIntent();
                finish();
                startActivity(intent);*/

                coloured_clicks.setChecked (false);
                fancy_text.setChecked (false);
                click_vibration.setChecked (false);
                bounce_effect_bar.setProgress (1);
                graphic_bar.setProgress (1);
                fps_txt.setText("Fps: 20fps");
                fps_bar.setProgress (2);
                scelta=100;

            }
        });




        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                save_settings(String.valueOf(coloured_clicks.isChecked())+"-"+String.valueOf(bounce_effect_bar.getProgress())+"-"+
                String.valueOf(fancy_text.isChecked())+"-"+String.valueOf(graphic_bar.getProgress())+"-"+String.valueOf(fps_bar.getProgress()*5+10)+
                              "-"+String.valueOf (click_vibration.isChecked ())+"-"+String.valueOf (scelta)+
                              "-"+bool_to_string (effect)+"-"+String.valueOf (original_cookie.isChecked ()));
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                Intent i = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage( getBaseContext().getPackageName() );
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finishAffinity ();
                startActivity(i);

            }
        });

        save_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save_nickname(nickname.getText().toString());
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
                try {
                    String txt="save";
                    String FILENAME = "save_or_reset";
                    FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
                    fos.write(txt.getBytes());
                    fos.close();
                    Toast.makeText(getApplicationContext(),"Progresses saved successfully!",Toast.LENGTH_SHORT).show();
                } catch (IOException ed) {
                    Log.e("ERROR", ed.toString());
                }
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




        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*==================================================================
                 Reset All progress and Close
                  ==================================================================*/
            /*    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case DialogInterface.BUTTON_POSITIVE:


                                break;

                            case DialogInterface.BUTTON_NEGATIVE:

                                break;
                        }
                    }
                };

                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setMessage("You wanna reset all your progress?").setPositiveButton("Yes", dialogClickListener)
                        .setNegativeButton("No", dialogClickListener).setTitle("RESET GAME").show();

*/




                final boolean[] reset={true,false,false};

                AlertDialog.Builder builder = new AlertDialog.Builder(SettingsActivityActivity.this);
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
                            if (elem)reset_txt+=1; else reset_txt+=0;
                        }

                        try {
                            String txt="reset";
                            String FILENAME = "save_or_reset";
                            FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
                            fos.write(reset_txt.getBytes());
                            fos.close();
                            Toast.makeText(getApplicationContext(),"Reset done!",Toast.LENGTH_SHORT).show();
                            exit.performClick ();
                        } catch (IOException ed) {
                            Log.e("ERROR", ed.toString());
                        }
                    }
                });

                builder.show();




            }
        });

        reset.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_UP)reset.setTextColor(getResources().getColor(R.color.white));
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN)reset.setTextColor(getResources().getColor(R.color.darkdark_grey));
                return false;
            }
        });



fps_bar.setOnSeekBarChangeListener (new SeekBar.OnSeekBarChangeListener () {
    @Override
    public void onProgressChanged (SeekBar seekBar, int i, boolean b) {
        fps_txt.setText("Fps: "+String.valueOf (fps_bar.getProgress ()*5+10)+"fps");
    }

    @Override
    public void onStartTrackingTouch (SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch (SeekBar seekBar) {

    }
});

        vibration_settings.setOnClickListener (new View.OnClickListener () {
            private String chooseItem;
            @Override
            public void onClick (View view) {


                AlertDialog.Builder builder = new AlertDialog.Builder(SettingsActivityActivity.this);
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setTitle("Set vibration length:");
                int pos=0;
                for(int i=0;i<listItemArr.length;i++){
                    if(Integer.parseInt (listItemArr[i])==scelta)pos=i;
                }

                builder.setSingleChoiceItems(listItemArr, pos, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int itemIndex) {
                        chooseItem = listItemArr[itemIndex];
                        save_settings(String.valueOf(coloured_clicks.isChecked())+"-"+String.valueOf(bounce_effect_bar.getProgress())+"-"+
                                      String.valueOf(fancy_text.isChecked())+"-"+String.valueOf(graphic_bar.getProgress())+"-"+String.valueOf(fps_bar.getProgress()*5+10)+
                                      "-"+String.valueOf (click_vibration.isChecked ())+"-"+chooseItem+
                        "-"+bool_to_string (effect));
                        scelta=Integer.parseInt (chooseItem);
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
final boolean tmp[]=new boolean[4];
        click_effect.setOnCheckedChangeListener (new CompoundButton.OnCheckedChangeListener () {
            @Override
            public void onCheckedChanged (CompoundButton compoundButton, boolean b) {
                if(!click_effect.isChecked ()){
                    effect_settings.setVisibility (View.GONE);
                    for (int i=0;i<effect.length;i++)tmp[i]=effect[i];
                    Arrays.fill (effect,false);
                }
                else {
                    effect_settings.setVisibility (View.VISIBLE);
                    for (int i=0;i<effect.length;i++)effect[i]=tmp[i];
                }
            }
        });

        effect_settings.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SettingsActivityActivity.this);
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


    }

}
