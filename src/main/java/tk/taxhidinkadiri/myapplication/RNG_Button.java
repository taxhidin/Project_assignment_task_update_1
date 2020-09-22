package tk.taxhidinkadiri.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class RNG_Button extends AppCompatActivity {
    private Button first_screen;
    private String TAG = "success";
    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r_n_g__button);


        Bundle extra_1 = getIntent().getExtras();

        TextView text_View = (TextView) findViewById(R.id.rng_text);
        Button random_number = (Button) findViewById(R.id.random);
        first_screen = (Button) findViewById(R.id.first_screen_1);

        if (extra_1 != null) {
            text_View.setText(extra_1.getString("rng_send"));
            Log.d(TAG, "onCreate: " + extra_1.getString("rng_send"));
        }

        Toast.makeText(this, "Please first press RANDOM NUMBER THEN PRESS", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Please first press Random Number then press ", Toast.LENGTH_SHORT).show();

        random_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int random_value = 10 + random.nextInt(90);
                Log.i("test_random", "onClick: " + random_value);



                first_screen.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Random random = new Random();
                        int random_value_1 = 10 + random.nextInt(90);

                        Intent intent_a = getIntent();

                        intent_a.putExtra("message_back", random_value_1);

                        // sharedPreferences.edit().putString("store", String.valueOf(random_value_1)).apply();

                        SharedPreferences preferences =
                                getSharedPreferences("Login_Info", 0);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("random_value", String.valueOf(random_value_1));
                        editor.apply();

                        setResult(RESULT_OK, intent_a);
                        finish();

                    }
                });


            }
        });



















       /* Toast.makeText(this, "First press " +
                "random number then press first screen button", Toast.LENGTH_SHORT).show();
*/

        /*random_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // String guess_1 = text_View.getText().toString().trim();
                Random random = new Random();
               final int random_value = 10 + random.nextInt(90);
                Log.d("random", "onClick: "+random_value);
         *//*      Intent intent_1 = getIntent();
                intent_1.putExtra("message_back", random_value);
                Toast.makeText(RNG_Button.this, "You have created" +
                        "random number "+random_value, Toast.LENGTH_SHORT).show();*//*

                //if (random_value != 0) {
                    first_screen.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent_2 = getIntent();
                            intent_2.putExtra("second_message_2", random_value);
                            setResult(RESULT_OK, intent_2);

                            finish();
                        }
                    });
               // }
            *//*    else {
                    Toast.makeText(RNG_Button.this, "Please generate" +
                            "random value than send to first activity", Toast.LENGTH_SHORT).show();
                }*//*


            }
        });*/

        if (getIntent().getStringExtra("rng_send") != null) {
            text_View.setText(getIntent().getStringExtra("rng_send"));
        }

    }
}
