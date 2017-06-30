package com.example.mind.notification_simpledemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button _notification,_cnecelnotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _notification=(Button)findViewById(R.id._notification);
        _cnecelnotification=(Button)findViewById(R.id._cencel_notification);

        _notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  Intent intent1 = new Intent(MainActivity.this, NotificationReceiverActivity.class);

              /*  Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.journaldev.com/"));*/

                 Intent intent1=new Intent(MainActivity.this,MainActivity.class);

                PendingIntent pIntent = PendingIntent.getActivity(MainActivity.this, (int) System.currentTimeMillis(), intent1, 0);

                // Build notification
                // Actions are just fake
                Notification noti = new Notification.Builder(MainActivity.this)

                        .setContentTitle("New mail from " + "test@gmail.com")
                        .setContentText("Subject").setSmallIcon(R.mipmap.ic_launcher)
                        .setContentIntent(pIntent)
                        .addAction(R.mipmap.ic_launcher, "Call", pIntent)
                        .addAction(R.mipmap.ic_launcher, "More", pIntent)
                        .addAction(R.mipmap.ic_launcher, "And more", pIntent).build();
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                // hide the notification after its selected



                noti.flags |= Notification.FLAG_AUTO_CANCEL;

                notificationManager.notify(0, noti);

            }
        });

        _cnecelnotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ns = Context.NOTIFICATION_SERVICE;
                NotificationManager nMgr = (NotificationManager) getApplicationContext().getSystemService(ns);
                nMgr.cancel(0);
            }
        });
    }
}
