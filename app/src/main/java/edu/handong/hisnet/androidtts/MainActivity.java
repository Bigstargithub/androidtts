package edu.handong.hisnet.androidtts;

import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextToSpeech tts;
    private Button btnSpeak;
    private EditText txtText;
    public String[] items;
    private String item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button speakButton = (Button) findViewById(R.id.button);
        ListView listview = (ListView)findViewById(R.id.listview);
        TextView textview = (TextView)findViewById(R.id.textView);
        items = getResources().getStringArray(R.array.list);
        textview.setText(items[0]);
        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                tts.setLanguage(Locale.KOREAN);
                tts.setSpeechRate(0.5f);
            }
        });
        item = items[0];
        speakButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                int i = 1;
                tts.speak(items[0], TextToSpeech.QUEUE_FLUSH, null, null);
                for(;i<items.length;i++) {
                    tts.speak(items[i], TextToSpeech.QUEUE_ADD, null, null);
                }
            }
        });
    }


}
