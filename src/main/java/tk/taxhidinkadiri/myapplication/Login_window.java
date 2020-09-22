package tk.taxhidinkadiri.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

//import tk.taxhidinkadiri.myapplication.other_methods.Main_Screen.Main_Screen;

public class Login_window extends AppCompatActivity {
    private EditText login_2_text;
    private Button login_second_button;
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile(
                    // "(?=.*[0-9])"
                    "^(?=.*[0-9])"
                            + "(?=.*[a-z])"
                            + "(?=.*[A-Z])"
                            + "(?=.*[a-zA-Z])"
                            //+ "(?=.*[@#$%^&+=])"
                            + "(?=.*[a|A]).{1,13}"
                            + "(?=.*[7])."
                            // + "(?=.*[^?])"

                            //+ "(?=.*[?(b)^d])"
                            + "(?=\\S+$)"
                            + ".{3,13}$");

    //"^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z])(?=.*[@#$%^&+!?=])(?=\\S+$).{6,}$"
    //- length should be greater than 4 and less than 14
    // - Letter ‘a’ (or ‘A’) should appear at least 2 or more times
    // - Value haves exactly one character (number) ‘7’


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_window);
/*        final Pattern login_text_reg_exp
                = Pattern.compile(
                "^(?=.*[0-9])" +
                        "(?=.*[a-z])" +
                        "(?=.*[A-Z])" +
                        "(?=.*[a-zA-Z])" +
                        "(?=.*[@#$%^&+=])" +
                        "(?=.*[a||A]).{2,14}" +
                        "(?=.*[7]).{1}" +
                        "(?=\\S+$).{4,14}$"
        );*/


        login_2_text = (EditText) findViewById(R.id.login_text);
        login_second_button = (Button) findViewById(R.id.login_button_second);


        Bundle extra = getIntent().getExtras();


        if (extra != null) {
            login_2_text.setText(extra.getString("guess_login"));

            Log.d("name extra", "onCreate: "
                    + extra.getString("guess_login"));
        }

    /*    else {
            Toast.makeText(MainActivity.this, "Field can't be empty", Toast.LENGTH_SHORT).show();
        }*/


        final String transferal_data = login_2_text.getText().toString().trim();


        login_second_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

          /* Intent intent = getIntent();
           intent.putExtra("message_back", login_2_text.getText().toString());
               //intent.putExtra("message_back", transferal_data);
           setResult(RESULT_OK, intent);
           finish();*/

                boolean h = validatePassword();
                if (h) {
                    Toast.makeText(Login_window.this, "You have logged successful", Toast.LENGTH_SHORT).show();
                    Intent intent_1 = new Intent(Login_window.this, list_item_main_screen.class);
                    intent_1.putExtra("login_to_main_screen", transferal_data);
                    startActivity(intent_1);
                } else {
                    Toast.makeText(Login_window.this, "Please try again, failed" +
                                    "It must contain: " +
                                    "length should be greater than 4 and less than 14\n" +
                                    "Letter ‘a’ (or ‘A’) should appear at least 2 or more times\n" +
                                    "Value haves exactly one character (number) ‘7’\n"
                            , Toast.LENGTH_SHORT).show();

                }


            }
        });


/*        if (getIntent().getStringExtra("guess_login") !=null){
            Log.d("stuff", "onCreate: "+getIntent().getStringExtra("guess_login"));
           login_2_text.setText(getIntent().getStringExtra("message_back"));
        }*/

    }


    private boolean validatePassword() {

        String password_Input = login_2_text.getText().toString().trim();

        if (password_Input.isEmpty()) {
            login_2_text.setError("Field can't be empty");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(password_Input).matches()) {
            login_2_text.setError("Password too Weak");
            return false;
        } else {
            login_2_text.setError(null);
            return true;


        }



    }


}