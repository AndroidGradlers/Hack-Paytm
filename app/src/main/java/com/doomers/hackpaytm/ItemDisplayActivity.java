package com.doomers.hackpaytm;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class ItemDisplayActivity extends Activity {

    private int position;
    private ImageView imageView;
    private TextView name,price,details;
    TextToSpeech t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_display);
        imageView = (ImageView)findViewById(R.id.imageview);
        name = (TextView)findViewById(R.id.name);
        price = (TextView)findViewById(R.id.price);
        details = (TextView)findViewById(R.id.further_details);

        details.setText("Promo Code FURN15\n" +
                "Use promocode FURN15 to get 15% cashback* on total order value. (Max cashback Rs.10000). COD option will not be available on applying this promocode");

        position = getIntent().getExtras().getInt("Position");
        switch (position)
        {
            case 0: imageView.setImageResource(R.drawable.bed);  break;
            case 1: imageView.setImageResource(R.drawable.table);  name.setText("Rahul Tuteja"); price.setText("$5");break;
            case 2: imageView.setImageResource(R.drawable.sofa); name.setText("Sourabh Suri"); price.setText("$8");break;
            default: imageView.setImageResource(R.drawable.sofa); break;
        }

        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);
                }
            }
        });

    }

    public void onPause(){
        if(t1 !=null){
            t1.stop();
            t1.shutdown();
        }
        super.onPause();
    }

    public void TextToSpeechCall(View view) {

        String toSpeak = details.getText().toString();
        Toast.makeText(getApplicationContext(), toSpeak, Toast.LENGTH_SHORT).show();
        t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }
}

