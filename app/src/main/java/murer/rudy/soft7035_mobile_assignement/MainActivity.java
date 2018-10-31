package murer.rudy.soft7035_mobile_assignement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

/**
 * The Main Activity.
 */
public class MainActivity extends AppCompatActivity {
    /**
     * The Extra message that will Hold Intent extra message Intent.
     */
    static String EXTRA_MESSAGE = "MainActivity";

    String TEXT_VIEW_KEY;
    String GAME_STATE_KEY;// some transient state for the activity instance
    String mGameState;// some transient state for the activity instance

    Map<String,String> dictionary = generateMorseDictionnary();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intentgetData = getIntent();
        String message = intentgetData.getStringExtra(EXTRA_MESSAGE);

        /* Find all the views from the layout */

        TextView mTranslateTextView = findViewById(R.id.mTranslation);
        Button mSecondActivityButton =  findViewById(R.id.mSecondActivityButton);
        Button mThirdActivityButton = findViewById(R.id.mThirdActivityButton);
        Button mTranslateButton = findViewById(R.id.mTranslateButton);
        TextView mDataTextView = findViewById(R.id.mData);
        EditText mInputText = findViewById(R.id.mInputText);


        if (savedInstanceState != null) {
            mGameState = savedInstanceState.getString(GAME_STATE_KEY);
        }

        /*
          Translate Button Click Listener
          On click Translate the Text in EditText To Morse In the translate TextView
         */
        mTranslateButton.setOnClickListener((View v) -> {
            String textTranslated = TextToMorse(mInputText.getText().toString());
            mTranslateTextView.setText(textTranslated);
        });

        /*Second Button Click Listener*/
        mSecondActivityButton.setOnClickListener((View v) -> {
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra(EXTRA_MESSAGE, mInputText.getText().toString().toUpperCase());
            startActivity(intent);
        });

        /*Second Button Click Listener*/
        mThirdActivityButton.setOnClickListener((View v) -> {
            Intent intent = new Intent(this, ThirdActivity.class);
            startActivity(intent);
        });
        mDataTextView.setText(message);
    }

    /**
     * @param string The String value in the EditText
     * @return A String of the Translated Text in Morse
     */
    private String TextToMorse(String string) {

        String[] stringArray = string.split("");
        StringBuilder res = new StringBuilder();
        for (int i=1;i<stringArray.length;i++){
            String myletter = charToMorseLetter(stringArray[i]);
            res.append(myletter);
        }
        return res.toString();
    }

    /**
     * @param c The letter eg. "A"
     * @return String Corresponding to that letter eg. A -> ".-"
     */
    private String charToMorseLetter(String c) {
        String letterTOMorse = dictionary.get(c);
        if (letterTOMorse == null){ // if letter is null add space
            letterTOMorse ="/";
        }
        return letterTOMorse;
    }

    /**
     * This callback is called only when there is a saved instance that is previously saved by using
     * onSaveInstanceState(). We restore some state in onCreate(), while we can optionally restore
     * other state here, possibly usable after onStart() has completed.
     * The savedInstanceState Bundle is same as the one used in onCreate().
     *
     * @param savedInstanceState
     */
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        TextView mInputText = findViewById(R.id.mInputText);
        mInputText.setText(savedInstanceState.getString(TEXT_VIEW_KEY));
    }

    /**
     *  Save the Text in the EditText
     *  invoked when the activity may be temporarily destroyed, save the instance state here
     * @param outState
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        TextView mInputText = findViewById(R.id.mInputText);
        String myTextSaved = mInputText.getText().toString();
        outState.putString(GAME_STATE_KEY, mGameState);
        outState.putString(TEXT_VIEW_KEY, myTextSaved);
        super.onSaveInstanceState(outState);
    }

    /**
     *  Generate the corresponding morse Code for Each Letter of the alphabet
     * @return Map<String,String> A map that contains the morse code for each letter
     */
    private Map<String,String> generateMorseDictionnary(){
        Map<String,String> hm = new HashMap<>();
        hm.put("A", ".- ");
        hm.put("B", "-... ");
        hm.put("C", "-.-. ");
        hm.put("D", "-.. ");
        hm.put("E", ". ");
        hm.put("F", "..-. ");
        hm.put("G", "--. ");
        hm.put("H", ".... ");
        hm.put("I", ".. ");
        hm.put("J", ".--- ");
        hm.put("K", "-.- ");
        hm.put("L", ".-.. ");
        hm.put("M", "-- ");
        hm.put("N", "-. ");
        hm.put("O", "--- ");
        hm.put("P", ".--. ");
        hm.put("Q", "--.- ");
        hm.put("R", ".-. ");
        hm.put("S", "... ");
        hm.put("T", "- ");
        hm.put("U", "..- ");
        hm.put("V", "...- ");
        hm.put("W", ".-- ");
        hm.put("X", "-..- ");
        hm.put("Y", "-.-- ");
        hm.put("Z", "--..");
        return hm;
    }


}