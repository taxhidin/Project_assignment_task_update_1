/*
package tk.taxhidinkadiri.myapplication;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawp.contactmanager.DetailsActivity;
import com.bawp.contactmanager.R;
import com.bawp.contactmanager.model.Contact;

import java.util.List;
import android.support.v7.widget.RecyclerView;

import tk.taxhidinkadiri.myapplication.other_methods.Main_Screen.adapter.RecylerViewAdapter;
import tk.taxhidinkadiri.myapplication.other_methods.Main_Screen.data.DatabaseHandler;
import tk.taxhidinkadiri.myapplication.other_methods.Main_Screen.model.Contact;

//import tk.taxhidinkadiri.myapplication.other_methods.Main_Screen.data.DatabaseHandler;


public class Main_Screen extends AppCompatActivity {
    private final String TAG = "MainActivity";
    private RecylerViewAdapter recylerView;
    private RecylerViewAdapter recylerViewAdapter;

    private ArrayList<Contact> contactArrayList;
    private ArrayAdapter<String> arrayAdapter;


    public class DownloadTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
            String result = "";
            URL url;
            HttpURLConnection urlConnection = null;

            try {

                url = new URL(urls[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();

                while (data != -1) {
                    char current = (char) data;
                    result += current;
                    data = reader.read();
                }

                return result;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {
                JSONObject jsonObject = new JSONObject(s);

                String results_value = jsonObject.getString("results");

                Log.i(TAG, "result content" + results_value);

                JSONArray arr = new JSONArray(results_value);

                for (int i = 0; i < arr.length(); i++) {
                    JSONObject jsonPart = arr.getJSONObject(i);
                    Log.i(TAG, "onPostExecute: ");

                    Log.i(TAG, "name" + jsonPart.getString("name"));
                    Log.i(TAG, "height" + jsonPart.getString("height"));
                    Log.i(TAG, "onPostExecute: mass" + jsonPart.getString("mass"));

      Intent intent = new Intent(Main_Screen.this, DatabaseHandler.class);
                intent.putExtra("name", jsonPart.getString("name") );
                intent.putExtra("height",  jsonPart.getInt("height") );
                intent.putExtra("mass", jsonPart.getInt("mass"));
                startActivity(intent);


                    Contact contact = new Contact();
                    contact.setName(jsonPart.getString("name"));
                    contact.setMass(jsonPart.getString("mass"));
                    contact.setHeight(jsonPart.getString("height"));


                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        DownloadTask task = new DownloadTask();
        // textView_value = (TextView) findViewById(R.id.test);

        task.execute("https://swapi.dev/api/people/");

        recylerView = findViewById(R.id.recyclerView);
        recylerView.setHasFixedSize(true);
        recylerView.setLayoutManager(new LinearLayoutManager(this));


        contactArrayList = new ArrayList<>();
        DatabaseHandler db = new DatabaseHandler(MainActivity.this);

        List<Contact> contactList = db.getAllContacts();

        for (Contact contact : contactList) {
            Log.d("MainActivity", "onCreate: " + contact.getName());
            contactArrayList.add(contact);
        }

        //setup adapter
        recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, contactArrayList);

        recyclerView.setAdapter(recyclerViewAdapter);


    }
}
*/
