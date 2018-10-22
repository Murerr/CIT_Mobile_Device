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
    static String EXTRA_MESSAGE = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intentgetData = getIntent();
        String message = intentgetData.getStringExtra(EXTRA_MESSAGE);



        Button mSecondActivityButton = (Button) findViewById(R.id.mSecondActivityButton);
        Button mThirdActivityButton = (Button) findViewById(R.id.mThirdActivityButton);
        Button mTranslateButton = (Button) findViewById(R.id.mTranslateButton);
        TextView mTranslateTextView = (TextView) findViewById(R.id.mTranslation);
        TextView mDataTextView = (TextView) findViewById(R.id.mData);
        EditText mInputText = (EditText) findViewById(R.id.mInputText);

        mSecondActivityButton.setOnClickListener((View v) -> {
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra(EXTRA_MESSAGE, mInputText.getText());
            startActivity(intent);
        });

        mThirdActivityButton.setOnClickListener((View v) -> {
            Intent intent = new Intent(this, ThirdActivity.class);
            intent.putExtra(EXTRA_MESSAGE, mInputText.getText());
            startActivity(intent);
        });
        mDataTextView.setText(message);
    }

}