package com.mockingbird.magiccolors;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class View extends Activity {


    int counter = 0;

    public static TextView howcanıplay;
    public static TextView gametext;
    public static TextView gameview;
    public static TextView combotext;
    public static TextView comboview;
    public static TextView bonustext;
    public static TextView bonusview;


    public static ImageView differimage;
    public static ImageView sameimage;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);


        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        sameimage = (ImageView) findViewById(R.id.comboimage);
        sameimage.setImageResource(R.mipmap.same);
        differimage = (ImageView) findViewById(R.id.gameimage);
        differimage.setImageResource(R.mipmap.differ);

        switch (Main2Activity.selectedlanguages) {
            case 0:

                howcanıplay = (TextView) findViewById(R.id.howcanıplay);
                howcanıplay.setText(Main2Activity.languages[0][6]);

                gametext = (TextView) findViewById(R.id.gametext);
                gametext.setText(getString(R.string.gametext_ing));

                gameview = (TextView) findViewById(R.id.gametextview);
                gameview.setText(getString(R.string.gameviewtext_ing));

                combotext = (TextView) findViewById(R.id.combotext);
                combotext.setText(getString(R.string.combotext_ing));

                comboview = (TextView) findViewById(R.id.combotextview);
                comboview.setText(getString(R.string.comboviewtext_ing));

                bonustext = (TextView) findViewById(R.id.bonustext);
                bonustext.setText(getString(R.string.bonustext_ing));

                bonusview = (TextView) findViewById(R.id.bonustextview);
                bonusview.setText(getString(R.string.bonustextview_ing));
                break;
            case 1:
                howcanıplay = (TextView) findViewById(R.id.howcanıplay);
                howcanıplay.setText(Main2Activity.languages[1][6]);

                gametext = (TextView) findViewById(R.id.gametext);
                gametext.setText(getString(R.string.gametext_tr));

                gameview = (TextView) findViewById(R.id.gametextview);
                gameview.setText(getString(R.string.gameviewtext_tr));

                combotext = (TextView) findViewById(R.id.combotext);
                combotext.setText(getString(R.string.combotext_tr));

                comboview = (TextView) findViewById(R.id.combotextview);
                comboview.setText(getString(R.string.comboviewtext_tr));

                bonustext = (TextView) findViewById(R.id.bonustext);
                bonustext.setText(getString(R.string.bonustext_tr));

                bonusview = (TextView) findViewById(R.id.bonustextview);
                bonusview.setText(getString(R.string.bonustextview_tr));
                break;
            case 2:
                howcanıplay = (TextView) findViewById(R.id.howcanıplay);
                howcanıplay.setText(Main2Activity.languages[2][6]);

                gametext = (TextView) findViewById(R.id.gametext);
                gametext.setText(getString(R.string.gametext_ch));

                gameview = (TextView) findViewById(R.id.gametextview);
                gameview.setText(getString(R.string.gameviewtext_ch));

                combotext = (TextView) findViewById(R.id.combotext);
                combotext.setText(getString(R.string.combotext_ch));

                comboview = (TextView) findViewById(R.id.combotextview);
                comboview.setText(getString(R.string.comboviewtext_ch));

                bonustext = (TextView) findViewById(R.id.bonustext);
                bonustext.setText(getString(R.string.bonustext_ch));

                bonusview = (TextView) findViewById(R.id.bonustextview);
                bonusview.setText(getString(R.string.bonustextview_ch));
                break;
            case 3:
                howcanıplay = (TextView) findViewById(R.id.howcanıplay);
                howcanıplay.setText(Main2Activity.languages[3][6]);

                gametext = (TextView) findViewById(R.id.gametext);
                gametext.setText(getString(R.string.gametext_al));

                gameview = (TextView) findViewById(R.id.gametextview);
                gameview.setText(getString(R.string.gameviewtext_al));

                combotext = (TextView) findViewById(R.id.combotext);
                combotext.setText(getString(R.string.combotext_al));

                comboview = (TextView) findViewById(R.id.combotextview);
                comboview.setText(getString(R.string.comboviewtext_al));

                bonustext = (TextView) findViewById(R.id.bonustext);
                bonustext.setText(getString(R.string.bonustext_al));

                bonusview = (TextView) findViewById(R.id.bonustextview);
                bonusview.setText(getString(R.string.bonustextview_al));
                break;
            case 4:
                howcanıplay = (TextView) findViewById(R.id.howcanıplay);
                howcanıplay.setText(Main2Activity.languages[4][6]);

                gametext = (TextView) findViewById(R.id.gametext);
                gametext.setText(getString(R.string.gametext_ıs));

                gameview = (TextView) findViewById(R.id.gametextview);
                gameview.setText(getString(R.string.gameviewtext_ıs));

                combotext = (TextView) findViewById(R.id.combotext);
                combotext.setText(getString(R.string.combotext_ıs));

                comboview = (TextView) findViewById(R.id.combotextview);
                comboview.setText(getString(R.string.comboviewtext_ıs));

                bonustext = (TextView) findViewById(R.id.bonustext);
                bonustext.setText(getString(R.string.bonustext_ıs));

                bonusview = (TextView) findViewById(R.id.bonustextview);
                bonusview.setText(getString(R.string.bonustextview_ıs));
                break;
            case 5:
                howcanıplay = (TextView) findViewById(R.id.howcanıplay);
                howcanıplay.setText(Main2Activity.languages[5][6]);

                gametext = (TextView) findViewById(R.id.gametext);
                gametext.setText(getString(R.string.gametext_jp));

                gameview = (TextView) findViewById(R.id.gametextview);
                gameview.setText(getString(R.string.gameviewtext_jp));

                combotext = (TextView) findViewById(R.id.combotext);
                combotext.setText(getString(R.string.combotext_jp));

                comboview = (TextView) findViewById(R.id.combotextview);
                comboview.setText(getString(R.string.comboviewtext_jp));

                bonustext = (TextView) findViewById(R.id.bonustext);
                bonustext.setText(getString(R.string.bonustext_jp));

                bonusview = (TextView) findViewById(R.id.bonustextview);
                bonusview.setText(getString(R.string.bonustextview_jp));
                break;
            case 6:
                howcanıplay = (TextView) findViewById(R.id.howcanıplay);
                howcanıplay.setText(Main2Activity.languages[6][6]);

                gametext = (TextView) findViewById(R.id.gametext);
                gametext.setText(getString(R.string.gametext_rs));

                gameview = (TextView) findViewById(R.id.gametextview);
                gameview.setText(getString(R.string.gameviewtext_rs));

                combotext = (TextView) findViewById(R.id.combotext);
                combotext.setText(getString(R.string.combotext_rs));

                comboview = (TextView) findViewById(R.id.combotextview);
                comboview.setText(getString(R.string.comboviewtext_rs));

                bonustext = (TextView) findViewById(R.id.bonustext);
                bonustext.setText(getString(R.string.bonustext_rs));

                bonusview = (TextView) findViewById(R.id.bonustextview);
                bonusview.setText(getString(R.string.bonustextview_rs));
                break;
            case 7:
                howcanıplay = (TextView) findViewById(R.id.howcanıplay);
                howcanıplay.setText(Main2Activity.languages[7][6]);

                gametext = (TextView) findViewById(R.id.gametext);
                gametext.setText(getString(R.string.gametext_kr));

                gameview = (TextView) findViewById(R.id.gametextview);
                gameview.setText(getString(R.string.gameviewtext_kr));

                combotext = (TextView) findViewById(R.id.combotext);
                combotext.setText(getString(R.string.combotext_kr));

                comboview = (TextView) findViewById(R.id.combotextview);
                comboview.setText(getString(R.string.comboviewtext_kr));

                bonustext = (TextView) findViewById(R.id.bonustext);
                bonustext.setText(getString(R.string.bonustext_kr));

                bonusview = (TextView) findViewById(R.id.bonustextview);
                bonusview.setText(getString(R.string.bonustextview_kr));
                break;
            case 8:
                howcanıplay = (TextView) findViewById(R.id.howcanıplay);
                howcanıplay.setText(Main2Activity.languages[8][6]);

                gametext = (TextView) findViewById(R.id.gametext);
                gametext.setText(getString(R.string.gametext_ar));

                gameview = (TextView) findViewById(R.id.gametextview);
                gameview.setText(getString(R.string.gameviewtext_ar));

                combotext = (TextView) findViewById(R.id.combotext);
                combotext.setText(getString(R.string.combotext_ar));

                comboview = (TextView) findViewById(R.id.combotextview);
                comboview.setText(getString(R.string.comboviewtext_ar));

                bonustext = (TextView) findViewById(R.id.bonustext);
                bonustext.setText(getString(R.string.bonustext_ar));

                bonusview = (TextView) findViewById(R.id.bonustextview);
                bonusview.setText(getString(R.string.bonustextview_ar));
                break;


        }


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("View Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
