package com.example.raj.br5;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    TextView tv1,tv2;
  // MediaPlayer mp=new MediaPlayer();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=(TextView)findViewById(R.id.tv1);
        tv2=(TextView)findViewById(R.id.tv2);
        AudioManager am=(AudioManager)getSystemService(AUDIO_SERVICE);
        Intent i=getIntent();
        Bundle b=i.getExtras();
        if(b!=null)
        {
            String cno=b.getString("K1");
            String message=b.getString("K2");
            tv1.setText(cno);
            tv2.setText(message);
            if (message.equals("NORMAL"))
            {
                am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
            }
            else
            if(message.equals("SILENT"))
            {
                am.setRingerMode(AudioManager.RINGER_MODE_SILENT);
            }
            else
            if (message.equals("VIBRATE"))
            {
                am.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);

            }

        }

    }
}
