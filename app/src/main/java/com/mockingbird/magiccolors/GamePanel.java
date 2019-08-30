package com.mockingbird.magiccolors;

import android.app.Activity;
import android.content.Context;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;

import android.view.MotionEvent;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


public class GamePanel  extends View {










    //ASSİNG ARRAYLIST
    private  Boolean[] showpointsarray = new Boolean[4];
    public static InterstitialAd mInterstitialAd1;
    //ASSİNG SOUNDS
    MediaPlayer clickSound=  MediaPlayer.create(getContext(), R.raw.clicksounds);
    MediaPlayer   finishSound=  MediaPlayer.create(getContext(), R.raw.finishsound);
    MediaPlayer   comboSound=  MediaPlayer.create(getContext(), R.raw.normalsound);

    int selectedlanguage= com.mockingbird.magiccolors.Main2Activity.selectedlanguages;

    //ASSİNG SOUNDS
    private  float  bitmapXPosition;
    private float  bitmapYPosition;
    private   int  alpha=252;
    private float  touchedx;
    private float  touchedy;

    // ASSIGN PAINTS
    Paint coverPaint=new Paint();
    Paint  text=new Paint();
    Paint  paint=new Paint();
    Paint  alertPaint =new Paint();
    Paint  topBarTextPaint = new Paint();
    Paint  strokePaint=new Paint();
    Paint  barPaint=new Paint();
    Paint linePaint = new Paint();
    Paint pausePaint = new Paint();

    // ASSIGN BOOLEANS
    Boolean initiated = true;
    Boolean combo = false;
    private boolean  gameover=false;
    Boolean crazy = false;
    Boolean  amazing=false;
    Boolean adClosed = false;
    // ASSIGN SCOREBAR
    private Rect topBar=new Rect(0,0,Contant.SCREEN_WIDHT,Contant.SCREEN_HEIGHT * 7 / 100);
    private  Rect  scoreBar=new Rect(0,0,Contant.SCREEN_WIDHT*3/10,Contant.SCREEN_HEIGHT * 7 / 100);
    private  Rect  speedBar=new Rect(Contant.SCREEN_WIDHT*3/10,0,Contant.SCREEN_WIDHT*8/10,Contant.SCREEN_HEIGHT * 7 / 100);
    private  Rect  stopBar=new Rect(Contant.SCREEN_WIDHT*8/10,0,Contant.SCREEN_WIDHT,Contant.SCREEN_HEIGHT * 7 / 100);
    private  Rect  layoutSpeed=new Rect();
    private  Rect  incSpeed=new Rect();
    private  Rect  Cover=new Rect(0,0,Contant.SCREEN_WIDHT,Contant.SCREEN_HEIGHT );

    // FIND RATIO FOR SCREENS
    private float cap = Contant.SCREEN_HEIGHT*11/100 > Contant.SCREEN_WIDHT*15/100 ? Contant.SCREEN_HEIGHT*11/100 : Contant.SCREEN_WIDHT*15/100;
    private  float radius = cap/2;
    private float k = (Contant.SCREEN_WIDHT - 3*cap)/4;
    private float gap = (4*k-cap)/2;
    private float l = (Contant.SCREEN_HEIGHT - 4*cap)/4;



    // ASSIGN FIRST OVALS
    ArrayList<RectF> ovalBalls = new ArrayList<>();
    int[] ovalColors = new int[4];

    // ASSIGN TOP BALL
    RectF  topBall=new RectF();

    // DASHBOARD
    private double startSpeed = Math.round(((Contant.SCREEN_HEIGHT * ((double)5))/1000)*1000.0)/1000.0;
    private double roundPerSpeedL = ((Contant.SCREEN_HEIGHT * ((double) 1 / 4.5)) / 1000) / (double)4;
    private double perSpeedL =  Math.round(roundPerSpeedL * 1000.0) / 1000.0;


    private int  rusemaalpha=10;
    private double speed;
    private int speedShow = 20;
    private  int Score=0;
    int numCrazy = 0;
    int numAmazing = 0;
    String scoreString;
    private String  plustext;

    // GAME ON CONTROL
    private boolean  stopgame=false;
    private  boolean  showpluspoint=false;
    private  boolean  go=true;
    private int numberofCombo=0;
    private  int  chnagecolor=0;
    private int selectedcolor=11;
    Random r = new Random();
    private int posNumber= (r.nextInt(4) + 1);
    float counter = 1;
    long moves;
    boolean  onetime=true;

    // TOPBAR SIZES
    float topSize = Contant.SCREEN_HEIGHT*7/100;

    // BAR LENGTH
    float barLength;
    float ratio;
    // ASSIGN BITMAPS

    Bitmap resume= getResizedBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.play), (int) cap*3/2,(int) cap*3/2);
    Bitmap speedicon= getResizedBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.speed), (int)(topSize*5/7), (int)(topSize*5/7));
    Bitmap main= getResizedBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.home), (int) cap,(int) cap);
    Bitmap stop= getResizedBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.stop), (int)(topSize*5/6), (int)(topSize*5/6));
    Bitmap replay =  getResizedBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.replay),(int) cap*3/2,(int) cap*3/2);
    Bitmap on= getResizedBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.on), (int) cap,(int) cap);
    Bitmap off= getResizedBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.off), (int) cap,(int) cap);



    GamePanel(Context context){
        super(context);
    }
    @Override
    public void   onDraw(Canvas canvas){

        super.onDraw(canvas);

        if(initiated)
            initial();
        initiated = false;


        alertPaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
        alertPaint.setAlpha(alpha);
        alertPaint.setTextSize(radius/2);

        this.bitmapXPosition= (canvas.getWidth()  -cap*3/2) /2;
        this.bitmapYPosition=(canvas.getHeight()   -cap*3/2) /2;

        if (stopgame && !gameover ) {

            pausePaint.setColor(Color.parseColor("#131107"));
            pausePaint.setTextSize(radius);
            pausePaint.setTextAlign(Paint.Align.CENTER);
            pausePaint.setTypeface(Typeface.create("Arial", Typeface.BOLD));
            canvas.drawColor(Color.parseColor("#FAF1E1"));
            drawElements(canvas,ovalColors);
            coverPaint.setColor(Color.parseColor("#EBEBEB"));
            coverPaint.setAlpha(rusemaalpha);

            drawLayout(canvas);
            canvas.drawRect(Cover,coverPaint);


            canvas.drawText(Main2Activity.languages[selectedlanguage][2],Contant.SCREEN_WIDHT/2,cap*2,pausePaint);
            canvas.drawBitmap(resume,bitmapXPosition,bitmapYPosition-cap,paint);
            canvas.drawBitmap(replay,bitmapXPosition,bitmapYPosition+cap,paint);
            canvas.drawBitmap(main,topSize,Contant.SCREEN_HEIGHT-cap-topSize,paint);

            if (Main2Activity.soundon) {
                canvas.drawBitmap(on, Contant.SCREEN_WIDHT - cap - topSize, Contant.SCREEN_HEIGHT - cap - topSize, paint);
            }else
            {
                canvas.drawBitmap(off, Contant.SCREEN_WIDHT - cap - topSize, Contant.SCREEN_HEIGHT - cap - topSize, paint);
            }

            if (rusemaalpha<200){
                rusemaalpha+=10;

            }

            if (go  &&chnagecolor<150){
                chnagecolor=chnagecolor+ 1;
            }
            else {
                chnagecolor=chnagecolor- 1;
                go = chnagecolor == 50;
            }
            invalidate();
        }
        else if (!gameover ) {

            rusemaalpha=10;
            // CANVAS BACKGROUND
            canvas.drawColor(Color.parseColor("#FAF1E1"));

            // DRAW BALLS
            drawElements(canvas, ovalColors);

            // MOVE BALLS
            moveBall((float)speed);
            drawLayout(canvas);

            // DISPLAY TOPBAR

            for(int i=0;i<4;i++)
                if (ovalBalls.get(i).bottom> Contant.SCREEN_HEIGHT) {
                    if (mInterstitialAd1.isLoaded()) {
                        mInterstitialAd1.show();
                    }
                    gameover = true;
                }

            if (!stopgame) {

                invalidate();
            }

        }  else{ // GAME OVER

            if (Main2Activity.soundon){

                if (onetime){
                    finishSound.start();
                    onetime=false;
                }



            }
            if (Score>Main2Activity.highScore){
                Main2Activity.highScore=Score;

                SharedPreferences savedHighScore= getContext().getSharedPreferences("highScore", 0);

                SharedPreferences.Editor sEditor = savedHighScore.edit();
                sEditor.putInt("highScore", Main2Activity.highScore).apply();


            }

            canvas.drawColor(Color.parseColor("#FAF1E1"));
            text.setTextAlign(Paint.Align.CENTER);
            text.setTextSize(cap/3);
            text.setColor(Color.rgb(chnagecolor,50,50));

            coverPaint.setColor(Color.parseColor("#EBEBEB"));
            coverPaint.setAlpha(rusemaalpha);
            text.setTypeface(Typeface.create("Arial", Typeface.BOLD));

            canvas.drawRect(Cover,coverPaint);
            canvas.drawText(Main2Activity.languages[selectedlanguage][0]+" : "+Score,Contant.SCREEN_WIDHT/2,Contant.SCREEN_HEIGHT/3,text);


            canvas.drawText(Main2Activity.languages[selectedlanguage][3]+" : "+Main2Activity.highScore,Contant.SCREEN_WIDHT/2,Contant.SCREEN_HEIGHT/3-cap,text);

            canvas.drawBitmap(replay,bitmapXPosition,bitmapYPosition,paint);

            canvas.drawBitmap(main,topSize,Contant.SCREEN_HEIGHT-cap-topSize,paint);

            if (Main2Activity.soundon) {
                canvas.drawBitmap(on, Contant.SCREEN_WIDHT - cap - topSize, Contant.SCREEN_HEIGHT - cap - topSize, paint);
            }else
            {
                canvas.drawBitmap(off, Contant.SCREEN_WIDHT - cap - topSize, Contant.SCREEN_HEIGHT - cap - topSize, paint);
            }

            if (go  &&chnagecolor<250){
                chnagecolor=chnagecolor+ 1;
            }
            else {
                chnagecolor=chnagecolor- 1;
                go = chnagecolor ==1;
            }
            invalidate();
        }
    }

    @Override
    public  boolean  onTouchEvent(MotionEvent event){

        int action = event.getAction();
        int x = (int) event.getX(); // or getRawX();
        int y = (int) event.getY();
        this.touchedx=event.getX();
        this.touchedy=event.getY();


        switch (action) {
            case MotionEvent.ACTION_DOWN:

                if (!gameover && !stopgame){

                    toppestball();

                    showpluspoint = false;
                    crazy = false;
                    amazing=false;
                    for(int i=0; i<4;i++) {
                        if (x > ovalBalls.get(i).left && x < ovalBalls.get(i).right && y > ovalBalls.get(i).top && y < ovalBalls.get(i).bottom) {
                            moves++;
                            newPosition(ovalBalls.get(i));

                            alertPaint.setColor(generateColor(ovalColors[i]));
                            if(selectedcolor == 7)
                            {
                                numberofCombo = 1;
                                combo = true;
                            } else {
                                combo = selectedcolor == ovalColors[i];
                            }

                            if (Main2Activity.soundon ) {

                                if (combo) {
                                    if(comboSound.isPlaying()) {
                                        comboSound.reset();
                                        try {
                                            comboSound.setDataSource(getContext(), Uri.parse("android.resource://com.mockingbird.magiccolors/raw/normalsound"));
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                        try {
                                            comboSound.prepare();
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                        comboSound.start();
                                    }
                                    else
                                        comboSound.start();
                                }
                                else {
                                    if(clickSound.isPlaying()) {
                                        clickSound.reset();
                                        try {
                                            clickSound.setDataSource(getContext(), Uri.parse("android.resource://com.mockingbird.magiccolors/raw/clicksounds"));
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                        try {
                                            clickSound.prepare();
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                        clickSound.start();

                                    }
                                    else
                                        clickSound.start();
                                }


                            }

                            newSpeed(combo);

                            showpluspoint = true;
                            showpointsarray[i]=true;
                            alpha = 250;
                            posNumber = (r.nextInt(4) + 1);


                            selectedcolor = ovalColors[i];
                            if(moves % 15 == 0)
                                ovalColors[i] = 7;
                            else {
                                if(speedShow <= 70)
                                    ovalColors[i] = r.nextInt(100) % 7;
                                else
                                    ovalColors[i] = r.nextInt(100) % 6;
                            }
                        }
                        else{
                            plustext="";
                        }
                    }


                    // CLICK ON STOP BITMAP
                    if (x>(int)(Contant.SCREEN_WIDHT-topSize)&&x<(int)(Contant.SCREEN_WIDHT-topSize)+stop.getWidth()&&y>topSize/10&&y<topSize/10+stop.getHeight()){
                        stopgame=true;
                        if (mInterstitialAd1.isLoaded()) {
                            mInterstitialAd1.show();
                            adClosed = false;
                        }
                    }

                }else if (stopgame && !gameover){

                    //CLİCK RESUME
                    if (x>bitmapXPosition &&  x<bitmapXPosition+resume.getWidth()&&y>bitmapYPosition-cap&&y<bitmapYPosition-cap+resume.getHeight()){
                        stopgame=false;
                    }

                    //CLİCK REPLAY
                    else if (x>bitmapXPosition &&  x<bitmapXPosition+replay.getWidth()&&y>bitmapYPosition+cap&&y<bitmapYPosition+cap+replay.getHeight()){
                        initial();

                    }
                    //CLİCK ON MAİN
                    else if (x>topSize &&  x<topSize+main.getWidth()&&y>Contant.SCREEN_HEIGHT-cap-topSize&&y<Contant.SCREEN_HEIGHT-cap-topSize+main.getHeight()){
                        Activity activity=(Activity)  getContext();
                        comboSound.release();
                        clickSound.release();
                        activity.finish();


                    }
                    //CLİCK ON VOLUME
                    else if (x>Contant.SCREEN_WIDHT - cap - topSize &&  x<Contant.SCREEN_WIDHT - cap - topSize+on.getWidth()&&y>Contant.SCREEN_HEIGHT-cap-topSize&&y<Contant.SCREEN_HEIGHT-cap-topSize+on.getHeight()){
                        Main2Activity.soundon=!Main2Activity.soundon;

                        SharedPreferences savesoundsetting= getContext().getSharedPreferences("sound", 0);

                        SharedPreferences.Editor soundEditor = savesoundsetting.edit();
                        soundEditor.putBoolean("sound", Main2Activity.soundon).apply();
                    }


                }

                // IF GAME OVER
                else{

                    if (x > bitmapXPosition && x < bitmapXPosition + replay.getWidth() && y > bitmapYPosition && y < bitmapYPosition + replay.getHeight()) {
                        initial();
                    }
                    //CLİCK ON MAİN
                    else if (x > topSize && x < topSize + main.getWidth() && y > Contant.SCREEN_HEIGHT - cap - topSize && y < Contant.SCREEN_HEIGHT - cap - topSize + main.getHeight()) {
                        Activity activity = (Activity) getContext();
                        activity.finish();
                    }
                    //CLİCK ON VOLUME
                    else if (x > Contant.SCREEN_WIDHT - cap - topSize && x < Contant.SCREEN_WIDHT - cap - topSize + on.getWidth() && y > Contant.SCREEN_HEIGHT - cap - topSize && y < Contant.SCREEN_HEIGHT - cap - topSize + on.getHeight()) {
                        Main2Activity.soundon = !Main2Activity.soundon;

                        SharedPreferences savesoundsetting = getContext().getSharedPreferences("sound", 0);

                        SharedPreferences.Editor soundEditor = savesoundsetting.edit();
                        soundEditor.putBoolean("sound", Main2Activity.soundon).apply();
                    }

                }
        }
        return  false;
    }

    // SPEED UP
    private void newSpeed(Boolean comboCheck){

        if(comboCheck){ // IF COMBO
            numberofCombo++;
            Score=Score+numberofCombo*10;
            speedShow -= 12 - numberofCombo ;
            speedShow += 4;
            speed += perSpeedL * 4;

            speed -= perSpeedL* (12 - numberofCombo);

        }
        else {


            speed += perSpeedL * 4;
            speedShow += 4;

            numberofCombo=1;
            Score=Score+10;
            combo = false;
        }
        if(speedShow<10)
            crazy = true;
        if(speedShow>=250)
            amazing = true;
    }

    // SET NEW POSITION
    private void newPosition(RectF oval){

        oval.bottom = topBall.bottom-l - cap;
        oval.top = topBall.top - l - cap;
        oval.left = gap + (posNumber -1)*cap;
        oval.right = gap + posNumber* cap;
    }

    // SET STROKE COLOR
    private void setStrokePaint(int a){

        strokePaint.setStyle(Paint.Style.STROKE);

        if (a == 6)
            strokePaint.setColor(Color.parseColor("#18A29A"));
        else if (a ==5) // GREEN
            strokePaint.setColor(Color.parseColor("#1AA21A"));
        else if (a == 4) // BLUE
            strokePaint.setColor(Color.parseColor("#1C3FC1"));
        else if (a==3)  // YELLOW
            strokePaint.setColor(Color.parseColor("#CFD127"));
        else if (a==2) // MAGENTA
            strokePaint.setColor(Color.parseColor("#BA19CA"));
        else if (a==1) // RED
            strokePaint.setColor(Color.parseColor("#B61A1A"));
        else // BLACK
            strokePaint.setColor(Color.parseColor("#000000"));

        strokePaint.setStrokeWidth(cap / 10);
        strokePaint.setAntiAlias(true);
    }

    // SET CIRCLE COLOR
    private void  setPaint(int a){

        if (a == 6)
            paint.setColor(Color.parseColor("#25E6DB"));
        else if (a==5)
            paint.setColor(Color.parseColor("#2DFA2D"));
        else if (a==4)
            paint.setColor(Color.parseColor("#4689FF"));
        else if (a==3)
            paint.setColor(Color.parseColor("#FCFF0C"));
        else if (a==2)
            paint.setColor(Color.parseColor("#F16AFF"));
        else if (a==1)
            paint.setColor(Color.parseColor("#FF3232"));
        else
            paint.setColor(Color.parseColor("#5E5E5E"));
    }

    // GENERATE COLOR
    private int generateColor(int a){
        if (a == 6)
            return Color.parseColor("#18A29A");
        else if (a==5)
            return Color.parseColor("#1AA21A");
        else if (a==4)
            return Color.parseColor("#1C3FC1");
        else if (a==3)
            return Color.parseColor("#CFD127");
        else if (a==2)
            return Color.parseColor("#BA19CA");
        else if (a==1)
            return Color.parseColor("#B61A1A");
        else
            return Color.parseColor("#000000");
    }

    // DRAW BALLS
    private void drawElements(Canvas canvas, int[] colors ){

        if (counter == 100)
            counter = 1;

        for(int i=0;i<4;i++) {

            if (colors[i] != 7) {
                setPaint(colors[i]);
                setStrokePaint(colors[i]);
                canvas.drawOval(ovalBalls.get(i), paint);
                canvas.drawOval(ovalBalls.get(i), strokePaint);
            } else {
                setPaint((int) counter % 7);
                setStrokePaint((int) counter % 7);
                canvas.drawOval(ovalBalls.get(i), paint);
                canvas.drawOval(ovalBalls.get(i), strokePaint);
                counter +=  (float)20 / 100;

            }
        }
    }

    // MOVE BALLS
    private void moveBall(float speed){
        for (int i=0; i<4;i++) {
            ovalBalls.get(i).bottom += speed;
            ovalBalls.get(i).top += speed;
        }
    }

    // FIND TOPPEST BALL
    private  void  toppestball(){

        topBall =  ovalBalls.get(0);
        for(int i = 1; i<4;i++)
            if(ovalBalls.get(i).top < topBall.top)
                topBall = ovalBalls.get(i);
    }

    // SET OVAL SIDES
    private void setOvalSide(RectF ovalSide, int sideNumber, int counter){

        ovalSide.left = gap + (sideNumber - 1)*cap;
        ovalSide.right = sideNumber * cap + gap;
        ovalSide.top = -radius  + counter*(- l - cap);

        int bottom = counter>0?-1:1;
        int capN = counter > 1 ? 1:0;

        if(counter > 1)
            ovalSide.bottom = bottom * radius - counter*l  - (counter - capN)*cap;
        else
            ovalSide.bottom = bottom * radius - counter*l;
    }

    // SET LANGUAGES

    // RESTART THE GAME
    private   void  initial(){

        mInterstitialAd1 = new InterstitialAd(getContext());
        mInterstitialAd1.setAdUnitId("ca-app-pub-9155579869436948/3446562910");

        mInterstitialAd1.loadAd(new AdRequest.Builder().build());

        mInterstitialAd1.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd1.loadAd(new AdRequest.Builder().build());
            }

        });

        int initNumber, counter=0;
        for(int i = 0; i< 4; i++)
        {

            showpointsarray[i]=false;
            ovalColors[i] = r.nextInt(100) % 7;
            ovalBalls.add(new RectF());
            initNumber = (r.nextInt(4) + 1);
            setOvalSide(ovalBalls.get(i), initNumber, counter);
            counter++;
        }

        selectedcolor = 11;
        Score=0;

        moves = 1;
        numCrazy = 0;
        onetime=true;
        numAmazing=0;
        amazing=false;
        speed = startSpeed;
        speedShow = 20;
        showpluspoint=false;
        crazy=false;

        numberofCombo=0;
        gameover=false;
        stopgame = false;


    }

    private void drawLayout(Canvas canvas){
        barPaint.setColor(Color.parseColor("#EBEBEB"));
        barPaint.setTextAlign(Paint.Align.CENTER);
        canvas.drawRect(topBar,barPaint);
        canvas.drawRect(scoreBar,barPaint);
        canvas.drawRect(speedBar,barPaint);
        canvas.drawRect(stopBar,barPaint);

        topBarTextPaint.setColor(Color.parseColor("#505050"));
        topBarTextPaint.setTextSize(radius*2/5);
        topBarTextPaint.setTypeface(Typeface.create("Arial", Typeface.BOLD));

        // SCORE
        scoreString = String.format(Main2Activity.languages[selectedlanguage][0]+":%4d", Score);
        topBarTextPaint.getTextBounds(scoreString,0,scoreString.length(), scoreBar);
        canvas.drawText(scoreString,topSize/4 ,topSize/2 - scoreBar.exactCenterY(), topBarTextPaint);

        // SPEED
        //topBarTextPaint.getTextBounds(Main2Activity.languages[selectedlanguage][1]+": ",0,Main2Activity.languages[selectedlanguage][1].length()+": ".length(), speedBar);
        //  canvas.drawText(Main2Activity.languages[selectedlanguage][1]+": ",topSize/2 + Contant.SCREEN_WIDHT * 3/10,topSize/2 - speedBar.exactCenterY(),topBarTextPaint);
        canvas.drawBitmap(speedicon,(int)topSize*2/3 + Contant.SCREEN_WIDHT * 3/10,(int)topSize/10,paint);
        // SPEED BAR LENTGH
        barLength = (int)(cap+radius);

        // SPEED BAR
        layoutSpeed.left = (int)topSize*2/3 + Contant.SCREEN_WIDHT * 3/10+speedicon.getWidth()+(int)topSize/10;
        layoutSpeed.right = (int)(layoutSpeed.left+barLength);
        layoutSpeed.top =(int)(topSize/2-topSize/5);
        layoutSpeed.bottom = (int)(topSize/2+topSize/5);
        paint.setColor(Color.WHITE);
        canvas.drawRect(layoutSpeed,paint);

        // INCEREMENT SPEED BAR
        incSpeed.left = (int)topSize*2/3 + Contant.SCREEN_WIDHT * 3/10+speedicon.getWidth()+(int)topSize/10;
        incSpeed.right =incSpeed.left+(int)(speedShow*barLength/250);
        incSpeed.top =(int)(topSize/2-topSize/5);
        incSpeed.bottom = (int)(topSize/2+topSize/5);
        ratio = (float)speedShow/(float)250;
        paint.setColor(Color.rgb ((int)Math.abs((ratio * 232) + ((1 - ratio) * 245)),(int)Math.abs((ratio * 3) + ((1 - ratio) * 142)),(int)Math.abs((ratio * 1) + ((1 - ratio) * 11))));
        canvas.drawRect(incSpeed,paint);

        // LİNE BENEATH
        linePaint.setColor(Color.parseColor("#D5D5D5"));
        linePaint.setStrokeWidth(radius/20);
        canvas.drawLine(0,Contant.SCREEN_HEIGHT*7/100,Contant.SCREEN_WIDHT,Contant.SCREEN_HEIGHT*7/100,topBarTextPaint);

        // SPEEDSHOW
        topBarTextPaint.setColor(Color.rgb ((int)Math.abs((ratio * 232) + ((1 - ratio) * 245)),(int)Math.abs((ratio * 3) + ((1 - ratio) * 142)),(int)Math.abs((ratio * 1) + ((1 - ratio) * 11))));
        canvas.drawText(Integer.toString(speedShow),layoutSpeed.right+topSize/6,topSize/2 - scoreBar.exactCenterY(),topBarTextPaint);

        //DRAW   STOP
        canvas.drawBitmap(stop,(int)(Contant.SCREEN_WIDHT-topSize),(int)topSize/10,paint);


        // DISPLAY EARNED POINTS

        for (int i=0; i<4;i++) {
            if (showpointsarray[i]) {

                if (speedShow < 10) {
                    numCrazy++;
                    crazy = true;
                    speed = startSpeed + numCrazy * perSpeedL * 4;
                    speedShow = 20 + numCrazy * 4;
                    Score = Score + 100 * (numCrazy + 1);
                }

                if (speedShow >= 250) {
                    numAmazing++;
                    amazing = true;
                    speed = startSpeed + 180 * perSpeedL;
                    speedShow = 200;
                    Score = Score + 400 * (numAmazing + 1);
                }


                if (crazy) {
                    alertPaint.setTextAlign(Paint.Align.CENTER);
                    alertPaint.setTextSize(radius);
                    canvas.drawText("CRAZY!!! +" + (numCrazy + 1) * 100, Contant.SCREEN_WIDHT / 2, Contant.SCREEN_HEIGHT / 3, alertPaint);
                }
                if (amazing) {
                    alertPaint.setTextAlign(Paint.Align.CENTER);
                    alertPaint.setTextSize(radius);
                    canvas.drawText("AMAZING!!! +" + (numAmazing + 1) * 100, Contant.SCREEN_WIDHT / 2, Contant.SCREEN_HEIGHT / 3, alertPaint);
                }
                if (numberofCombo >= 2 && !crazy && !amazing) {
                    //textColor.setColor(Color.BLUE);
                    plustext=numberofCombo + " Comboo +" + numberofCombo * 10;

                } else if (!crazy && numberofCombo < 2 && !amazing) {
                    //textColor.setColor(Color.RED);
                   // canvas.drawText("+" + numberofCombo * 10, touchedx, touchedy, alertPaint);
                    plustext="+" + numberofCombo * 10;
                }
                canvas.drawText(plustext, touchedx, touchedy, alertPaint);

                touchedy = touchedy - (float) speed/5;
                alpha = alpha - 4;

                if (alpha < 1) {
                    showpointsarray[i] = false;
                    crazy = false;
                    amazing = false;
                    plustext="";
                    alpha = 252;
                }
            }

        }
    }

    private Bitmap  getResizedBitmap(Bitmap bitmap,int newwitdh,int newHeight){
        Bitmap  resizedBitmap=Bitmap.createBitmap(newwitdh,newHeight,Bitmap.Config.ARGB_8888);
        float scaleX=newwitdh/(float)bitmap.getWidth();
        float scaleY=newHeight/(float)bitmap.getHeight();

        float pivotX=0;
        float pivotY=0;
        Matrix scaleMatrix=new Matrix();
        scaleMatrix.setScale(scaleX,scaleY,pivotX,pivotY);

        Canvas canvas=new Canvas(resizedBitmap);

        canvas.setMatrix(scaleMatrix);
        canvas.drawBitmap(bitmap,0,0,new Paint(Paint.FILTER_BITMAP_FLAG));

        return  resizedBitmap;
    }



}