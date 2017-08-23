package com.example.raj.br5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

/**
 * Created by Raj on 6/19/2017.
 */

public class Br extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {

        Bundle b=intent.getExtras();
        Object o=b.get("pdus");
        Object msg[]=(Object[])o;
        for (int i=0;i<msg.length;i++)
        {
            byte by[]=(byte[])msg[i];
            SmsMessage sms=SmsMessage.createFromPdu(by);
            String rnumber=sms.getDisplayOriginatingAddress();
            String msgg=sms.getDisplayMessageBody();
            Intent in=new Intent();
            in.setClassName("com.example.raj.br5","com.example.raj.br5.MainActivity");
            in.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
            in.putExtra("K1",rnumber);
            in.putExtra("K2",msgg);
            context.startActivity(in);
        }

    }
}
