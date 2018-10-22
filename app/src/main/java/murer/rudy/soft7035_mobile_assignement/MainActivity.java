package murer.rudy.soft7035_mobile_assignement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mSecondActivityButton = (Button) findViewById(R.id.mSecondActivityButton);
        Button mTranslateButton = (Button) findViewById(R.id.mTranslateButton);
        TextView mTranslateTextView = (TextView) findViewById(R.id.mTranslation);

        mSecondActivityButton.setOnClickListener((View v) -> {
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
        });
    }

}