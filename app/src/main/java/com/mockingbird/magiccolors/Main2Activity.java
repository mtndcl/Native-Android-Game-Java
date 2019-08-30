package com.mockingbird.magiccolors;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.Locale;

public class Main2Activity extends   Activity{

    public static InterstitialAd mInterstitialAd;

    public static  int  selectedlanguages;

    public static Boolean  soundon;
    public  static  int highScore=0;

    public static TextView   play;
    public static TextView   howtoplay;
    public static TextView   share;
    public static TextView   languageview;
    public  static String[][]  languages=new String[9][8];


    // sign in flow, to know you should not attempt
    // to connect in onStart()


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);






        MobileAds.initialize(this, "ca-app-pub-9155579869436948~9632697312");

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        play=(TextView)findViewById(R.id.play);
        howtoplay=(TextView)findViewById(R.id.howtoplay);
        share=(TextView)findViewById(R.id.share);
        languageview=(TextView)findViewById(R.id.langu);


        SharedPreferences savedDatas= getSharedPreferences("selectedLanguage", 0);

        selectedlanguages = savedDatas.getInt("selectedLanguage", 9);

        SharedPreferences saveHighScore= getSharedPreferences("highScore", 0);
        highScore = saveHighScore.getInt("highScore", 0);

        SharedPreferences saveSound= getSharedPreferences("sound", 0);
        soundon = saveSound.getBoolean("sound", true);


        ImageView mainpic=(ImageView)findViewById(R.id.mainpic);
        mainpic.setImageResource(R.drawable.icon);


        if(selectedlanguages == 9) {
            String lan = Locale.getDefault().getLanguage();
            switch (lan) {
                case "en":
                    selectedlanguages = 0;
                    break;
                case "tr":
                    selectedlanguages = 1;
                    break;
                case "zh":
                    selectedlanguages = 2;
                    break;
                case "de":
                    selectedlanguages = 3;
                    break;
                case "es":
                    selectedlanguages = 4;
                    break;
                case "ja":
                    selectedlanguages = 5;
                case "ru":
                    selectedlanguages = 6;
                    break;
                case "ko":
                    selectedlanguages = 7;
                    break;

                case "ar":
                    selectedlanguages = 8;
                    break;
                default:
                    selectedlanguages = 0;
            }
        }

        setLanguages();

        setmainbuttonlanguages();
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-9155579869436948/3446562910");

        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });


    }





    public void click(View view) {

        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }

        Intent intent= new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        startActivity(intent);
    }
    public void langu(View view) {
        Intent intent= new Intent(this, languages.class);
        startActivity(intent);

    }
    public void shareitis(View view) {

        shareit();
    }

    public void viewit(View view) {
        Intent intent = new Intent(this, com.mockingbird.magiccolors.View.class);
        startActivity(intent);
    }

    private void  shareit(){

        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = "http://play.google.com/store/apps/details?id=com.mockingbird.magiccolors";
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));

    }
    private void setLanguages(){
        languages[0][0]="SCORE";
        languages[0][1] = "SPEED";
        languages[0][2] = "PAUSED";
        languages[0][3] = "HIGHEST SCORE";
        languages[0][4] = "LANGUAGE";
        languages[0][5] = "PLAY";
        languages[0][6] = "HOW TO PLAY?";
        languages[0][7] = "SHARE";


        languages[1][0]="PUAN";
        languages[1][1] = "HIZ";
        languages[1][2] = "DURDURULDU";
        languages[1][3] = "YÜKSEK PUAN";
        languages[1][4] = "DİL";
        languages[1][5] = "OYNA";
        languages[1][6] = "NASIL OYNANIR?";
        languages[1][7] = "PAYLAŞ";


        languages[2][0]="得分了";
        languages[2][1] = "速度";
        languages[2][2] ="暂停";
        languages[2][3] = "最高分数";
        languages[2][4] = "语言";
        languages[2][5] = "玩";
        languages[2][6] ="怎么玩？";
        languages[2][7] = "分享";

        languages[3][0]="PUNKTZAHL";
        languages[3][1] ="SPEED";
        languages[3][2] ="PAUSİEREN";
        languages[3][3] ="HÖCHSTE PUNKTZAHL";
        languages[3][4] = "SPRACHE";
        languages[3][5] = "SPIELEN";
        languages[3][6] = "SPIELANLEITUNG?";
        languages[3][7] = "AKTIE";

        languages[4][0]="PUNTAJE";
        languages[4][1] = "VELOCIDAD";
        languages[4][2] ="PAUSA";
        languages[4][3] =" MEJOR PUNTUACIÓN";
        languages[4][4] = "IDIOMA";
        languages[4][5] = "JUGAR";
        languages[4][6] = "INSTRUCCIONES";
        languages[4][7] = "COMPARTIR";

        languages[5][0]="スコア";
        languages[5][1] ="速度";
        languages[5][2] ="途切れる";
        languages[5][3] ="ハイスコ​​ア";
        languages[5][4] = "言語";
        languages[5][5] = "遊びます";
        languages[5][6] ="遊び方？";
        languages[5][7] = "シェア";

        languages[6][0]= "БАЛЛОВ";
        languages[6][1] ="СКОРОСТЬ";
        languages[6][2] ="ПАУЗА";
        languages[6][3] ="НАИВЫСШИЙ БАЛЛ";
        languages[6][4] = "ЯЗЫК";
        languages[6][5] = "ИГРАТЬ";
        languages[6][6] ="КАК ИГРАТЬ?";
        languages[6][7] = "ПОДЕЛИТЬСЯ";


        languages[7][0]= "점수";
        languages[7][1] ="속도";
        languages[7][2] ="일시 중지 된";
        languages[7][3] ="가장 거친 점수";
        languages[7][4] = "언어";
        languages[7][5] = "놀이";
        languages[7][6] ="게임 방법?";
        languages[7][7] = "몫";

        languages[8][0]= "المستوى";
        languages[8][1] ="سرعة";
        languages[8][2] ="توقف";
        languages[8][3] ="المستوى الاعلى";
        languages[8][4] = "لغة";
        languages[8][5] = "لعب";
        languages[8][6] ="كيف ألعب؟";
        languages[8][7] = "شارك";


    }
    private void setmainbuttonlanguages(){

        play.setText(languages[selectedlanguages][5]);
        howtoplay.setText(languages[selectedlanguages][6]);
        languageview.setText(languages[selectedlanguages][4]);
        share.setText(languages[selectedlanguages][7]);

    }








}
