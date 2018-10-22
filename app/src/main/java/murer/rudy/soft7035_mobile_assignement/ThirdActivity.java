package murer.rudy.soft7035_mobile_assignement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static murer.rudy.soft7035_mobile_assignement.MainActivity.EXTRA_MESSAGE;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Intent intent = getIntent();
        String message = intent.getStringExtra(EXTRA_MESSAGE);

        Button mGoBackToMainActivity = findViewById(R.id.mGoBackToMainActivity);
        mGoBackToMainActivity.setOnClickListener((View v) -> {
            Intent mintent = new Intent(this, MainActivity.class);
            mintent.putExtra(EXTRA_MESSAGE, getResources().getString(R.string.Third_Activity));
            startActivity(mintent);
        });
    }

}
