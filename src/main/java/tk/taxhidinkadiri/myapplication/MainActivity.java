package tk.taxhidinkadiri.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";
    // private static final int REQUEST_CODE =1000 ;
    SharedPreferences sharedPreferences;
    private EditText editText;
    private Button button_language;
    private Button button_login;
    private Button button_rng;
    private final int REQUEST_CODE = 2;
    private String message;
    private String language;
    private EditText second_activity_edit;

/*    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^(?=.*[0-9])"
                    + "(?=.*[a-z])"
                    + "(?=.*[A-Z])"
                    + "(?=.*[a-zA-Z])"
                    + "(?=.*[@#$%^&+=])"
                    + "(?=\\S+$).{8,20}$");*/


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {

            case R.id.english:
                setLanguage(getString(R.string.English));
                Toast.makeText(this, "Language updated", Toast.LENGTH_SHORT).show();
                return true;


            case R.id.croatia:
                setLanguage(getString(R.string.Croatian));
                Toast.makeText(this, "Language updated", Toast.LENGTH_SHORT).show();
                return true;


            default:
                return false;


        }


    }


    private void setLanguage(String language) {
        sharedPreferences.edit().putString("language", language).apply();
        editText.setText(language);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.edit_text);
        button_login = (Button) findViewById(R.id.login);
        button_rng = (Button) findViewById(R.id.rng);
        button_language = (Button) findViewById(R.id.language);
        second_activity_edit = (EditText) findViewById(R.id.second_activity);


        sharedPreferences = this.getSharedPreferences("tk.taxhidinkadiri.myapplication", Context.MODE_PRIVATE);
        language = sharedPreferences.getString("language", "-");
        Log.i(TAG, "onCreate: The language " + language);

        editText.setText(language);


        button_language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (language.equals("-")) {

                    new AlertDialog.Builder(MainActivity.this)
                            .setIcon(android.R.drawable.ic_btn_speak_now)
                            .setTitle("Choose language")
                            .setMessage("Which language would you like to use")
                            .setPositiveButton("English",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {

                                            setLanguage("English");

                                        }
                                    }

                            )

                            .setNegativeButton("Croatian", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    setLanguage("Croatian");

                                }
                            })


                            .show();


                } else {


                    if (editText.getText().toString().equalsIgnoreCase("Croatian")) {

                        setLanguage("English");

                    } else if (editText.getText().toString().equalsIgnoreCase("English")) {

                        setLanguage("Croatian");
                    }

                }


            }
        });


        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String edit_text_for_login = editText.getText().toString().trim();

                if (edit_text_for_login.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Field can't be empty", Toast.LENGTH_SHORT).show();
                } else {

                    Intent intent = new Intent(MainActivity.this, Login_window.class);
                    intent.putExtra("guess_login", edit_text_for_login);
                    startActivity(intent);
                    // startActivityForResult(intent, REQUEST_CODE);


                }


            }


        });

        button_rng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rng_value = editText.getText().toString().trim();

                if (!rng_value.isEmpty()) {
                    Intent intent_1 =
                            new Intent(MainActivity.this, RNG_Button.class);
                    intent_1.putExtra("rng_send", rng_value);
                    startActivityForResult(intent_1, REQUEST_CODE);
                    //startActivity(intent_1);
                } else {

                    Toast.makeText(MainActivity.this,
                            "Field can't be empty", Toast.LENGTH_SHORT).show();

                }


            }
        });


    }
/*    private boolean validatePassword () {
        String password_Input = editText.getText().toString().trim();
        if (password_Input.isEmpty()) {
            editText.setError("Field can't be empty");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(password_Input).matches()) {
            editText.setError("Password too Weak");
            return false;
        } else {
            editText.setError(null);
            return true;
        }
    }*/


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {

                assert data != null;
                message = data.getStringExtra("message_back");

                Toast.makeText(MainActivity.this, message,
                        Toast.LENGTH_LONG)
                        .show();
                Log.i("test_on_activity", message + " here ");

                second_activity_edit.setText(message);


            } else {
                Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show();
            }

        }


    }


    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sp = getSharedPreferences("Login_Info", 0);
        String data_from = sp.getString("random_value","");
        second_activity_edit.setText(data_from);
        Log.i(TAG, "onResume: " + data_from);


    }

    /*        @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            assert data != null;
            String message = data.getStringExtra("message_back");
            Log.i("test_test_1", "onActivityResult:first " + message + " success");
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            // editText.setText("");
            editText.setText(message);
        }
} */


}