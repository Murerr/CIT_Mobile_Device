package murer.rudy.soft7035_mobile_assignement;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import static murer.rudy.soft7035_mobile_assignement.MainActivity.EXTRA_MESSAGE;

public class ThirdActivity extends AppCompatActivity {

    private String CHANNEL_ID = "MY_CHANNEL_ID";
    private int notificationId = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Intent intentMessage = getIntent();
        String message = intentMessage.getStringExtra(EXTRA_MESSAGE);

        Button mGoBackToMainActivity = findViewById(R.id.mGoBackToMainActivity);
        Button mSendNotificationButton = findViewById(R.id.mSendNotificationButton);
        mGoBackToMainActivity.setOnClickListener((View v) -> {
            Intent mintent = new Intent(this, MainActivity.class);
            mintent.putExtra(EXTRA_MESSAGE, getResources().getString(R.string.Third_Activity));
            startActivity(mintent);
        });

        mSendNotificationButton.setOnClickListener((View v) -> {

            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:021 0000001"));
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_baseline_perm_phone_msg_24px)
                    .setContentTitle("My notification")
                    .setContentText("Hello World!")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    // Set the intent that will fire when the user taps the notification
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);
            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

// notificationId is a unique int for each notification that you must define
            notificationManager.notify(notificationId, mBuilder.build());
        });

    }

}
