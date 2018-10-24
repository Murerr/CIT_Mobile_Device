package murer.rudy.soft7035_mobile_assignement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static String EXTRA_MESSAGE = "MainActivity";



    String TEXT_VIEW_KEY;
    String GAME_STATE_KEY;
    TextView mTextView;

    // some transient state for the activity instance
    String mGameState;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intentgetData = getIntent();
        String message = intentgetData.getStringExtra(EXTRA_MESSAGE);


        TextView mTranslateTextView = findViewById(R.id.mTranslation);
        Button mSecondActivityButton =  findViewById(R.id.mSecondActivityButton);
        Button mThirdActivityButton = findViewById(R.id.mThirdActivityButton);
        Button mTranslateButton = findViewById(R.id.mTranslateButton);
        TextView mDataTextView = findViewById(R.id.mData);
        EditText mInputText = findViewById(R.id.mInputText);


        if (savedInstanceState != null) {
            mGameState = savedInstanceState.getString(GAME_STATE_KEY);
        }
        mTranslateButton.setOnClickListener((View v) -> {
            mTranslateTextView.setText(mInputText.getText());
        });


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

    // This callback is called only when there is a saved instance that is previously saved by using
// onSaveInstanceState(). We restore some state in onCreate(), while we can optionally restore
// other state here, possibly usable after onStart() has completed.
// The savedInstanceState Bundle is same as the one used in onCreate().
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        TextView mTranslateTextView = findViewById(R.id.mTranslation);
        mTranslateTextView.setText(savedInstanceState.getString(TEXT_VIEW_KEY));
    }

    // invoked when the activity may be temporarily destroyed, save the instance state here
    @Override
    public void onSaveInstanceState(Bundle outState) {
        TextView mTranslateTextView = findViewById(R.id.mTranslation);
        String myTextSaved = mTranslateTextView.getText().toString();
        outState.putString(GAME_STATE_KEY, mGameState);
        outState.putString(TEXT_VIEW_KEY, myTextSaved);
        super.onSaveInstanceState(outState);
    }
}