package tk.taxhidinkadiri.myapplication.listview_project;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import tk.taxhidinkadiri.myapplication.R;

import static java.util.Arrays.asList;


public class ParseApplications extends AppCompatActivity {
    private static final String TAG = "ParseApplications";
    private ArrayList<String> applications;

    public ParseApplications() {
        this.applications = new ArrayList<String>();
    }

    public ArrayList<String> getApplications() {
        return applications;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DownloadTask task = new DownloadTask();
        // textView_value = (TextView) findViewById(R.id.test);

        task.execute("https://swapi.dev/api/people/");

        ListView friendsListView = (ListView) findViewById(R.id.friendsListView);

//        final ArrayList<String> myFriends = new ArrayList<String>(asList("John", "Paul", "George", "Ringo"));
final ArrayList<String> myFriends = getApplications();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myFriends);

        friendsListView.setAdapter(arrayAdapter);

        friendsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(), "Hello " + myFriends.get(position), Toast.LENGTH_LONG).show();

            }
        });


    }

    public class DownloadTask extends AsyncTask<String, Void, String> {

        private static final String TAG = "test_example";

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
                    for (int j = 0; j < 10; j++) {
                        applications.add(j, jsonPart.getString("name"));

                    }

                    for (int a = 0; a < 10; a++) {
                        Log.i("test_test", "onPostExecute: " + applications.get(a));
                    }




                  /*  Contact contact = new Contact();
                    contact.setName(jsonPart.getString("name"));
                    contact.setPhoneNumber( jsonPart.getString("mass"));*/

                  /*  SharedPreferences preferences =
                            getSharedPreferences("Login_Info", 0);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("call_value", String.valueOf(jsonPart.getString("name")));
                    editor.apply();*/
                    //setResult(RESULT_OK,);
                    // finish();

             /*       Intent intent = new Intent(test_download.this, DatabaseHandler.class);
                    intent.putExtra("name", jsonPart.getString("name") );
                    intent.putExtra("height",  jsonPart.getInt("height") );
                    intent.putExtra("mass", jsonPart.getInt("mass"));
                    startActivity(intent);*/


              /*      Contact contact = new Contact();
                    contact.setName(jsonPart.getString("name"));
                    contact.setMass(jsonPart.getString("mass"));
                    contact.setHeight(jsonPart.getString("height"));*/


                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


}


