package com.mockingbird.magiccolors;


import android.app.Activity;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.TextView;





public class languages extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_languages);


        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        TextView   textView=(TextView)findViewById(R.id.languages);
        textView.setText(Main2Activity.languages[Main2Activity.selectedlanguages][4]);




    }

    public void english(android.view.View view) {

        Main2Activity.selectedlanguages=0;

        SharedPreferences savedLang = getSharedPreferences("selectedLanguage",0);

        SharedPreferences.Editor lEditor = savedLang.edit();
        lEditor.putInt("selectedLanguage", 0).apply();
        setmaimbutton(0);
        finish();


    }
    public void turkce(android.view.View view) {
        Main2Activity.selectedlanguages=1;

        SharedPreferences savedLang = getSharedPreferences("selectedLanguage",0);

        SharedPreferences.Editor lEditor = savedLang.edit();
        lEditor.putInt("selectedLanguage", 1).apply();
        setmaimbutton(1);
        finish();

    }
    public void china(android.view.View view) {

        Main2Activity.selectedlanguages=2;
        SharedPreferences savedLang = getSharedPreferences("selectedLanguage",0);
        SharedPreferences.Editor lEditor = savedLang.edit();
        lEditor.putInt("selectedLanguage", 2).apply();
        setmaimbutton(2);

        finish();


    }
    public void deutsch(android.view.View view) {
        Main2Activity.selectedlanguages=3;

        SharedPreferences savedLang = getSharedPreferences("selectedLanguage",0);
        SharedPreferences.Editor lEditor = savedLang.edit();
        lEditor.putInt("selectedLanguage", 3).apply();


        setmaimbutton(3);

        finish();


    }
    public void spain(android.view.View view) {

        Main2Activity.selectedlanguages=4;
        SharedPreferences savedLang = getSharedPreferences("selectedLanguage",0);
        SharedPreferences.Editor lEditor = savedLang.edit();
        lEditor.putInt("selectedLanguage", 4).apply();

        setmaimbutton(4);
        finish();

    }
    public void japan(android.view.View view) {

        Main2Activity.selectedlanguages=5;
        SharedPreferences savedLang = getSharedPreferences("selectedLanguage",0);
        SharedPreferences.Editor lEditor = savedLang.edit();
        lEditor.putInt("selectedLanguage", 5).apply();
        setmaimbutton(5);
        finish();


    }

    public void russian(android.view.View view) {
        Main2Activity.selectedlanguages=6;

        SharedPreferences savedLang = getSharedPreferences("selectedLanguage",0);
        SharedPreferences.Editor lEditor = savedLang.edit();
        lEditor.putInt("selectedLanguage", 6).apply();
        setmaimbutton(6);
        finish();

    }
    public void korean(android.view.View view) {
        Main2Activity.selectedlanguages=7;
        SharedPreferences savedLang = getSharedPreferences("selectedLanguage",0);
        SharedPreferences.Editor lEditor = savedLang.edit();
        lEditor.putInt("selectedLanguage", 7).apply();
        setmaimbutton(7);
        finish();


    }
    public void arabic(android.view.View view) {

        Main2Activity.selectedlanguages=8;
        SharedPreferences savedLang = getSharedPreferences("selectedLanguage",0);
        SharedPreferences.Editor lEditor = savedLang.edit();
        lEditor.putInt("selectedLanguage", 8).apply();
        setmaimbutton(8);

        finish();


    }
    private void   setmaimbutton(int selectedlangu){

        Main2Activity.play.setText(Main2Activity.languages[selectedlangu][5]);
        Main2Activity.howtoplay.setText(Main2Activity.languages[selectedlangu][6]);
        Main2Activity.languageview.setText(Main2Activity.languages[selectedlangu][4]);
        Main2Activity.share.setText(Main2Activity.languages[selectedlangu][7]);

    }



}
