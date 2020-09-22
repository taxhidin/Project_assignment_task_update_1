package tk.taxhidinkadiri.myapplication;

import android.app.ListActivity;
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
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import tk.taxhidinkadiri.myapplication.listview_project.FeedEntry;

public class list_item_main_screen extends ListActivity {
    private static final String TAG = "ParseApplications";
    private ArrayList<FeedEntry> applications_feed_entry;
    //private ArrayList<String> arrayList_string;
    private FeedEntry feedEntry_value;
/*    private ArrayAdapter<FeedEntry> arrayAdapter;
    private List<FeedEntry> feedEntries = new ArrayList<FeedEntry>();*/


//    private JSONObject jsonPart;

    public list_item_main_screen() {
        this.applications_feed_entry = new ArrayList<FeedEntry>();
        //this.arrayList_string = new ArrayList<String>();
        this.feedEntry_value = new FeedEntry();
    }

    public ArrayList<FeedEntry> getApplications_feed_entry() {
        return applications_feed_entry;
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
                    //                  JSONObject jsonPart = arr.getJSONObject(i);
                    JSONObject jsonPart = arr.getJSONObject(i);


                    for (int j = 0; j < applications_feed_entry.size(); j++) {
                        String name_value = jsonPart.getString("name");
                        String height_value = jsonPart.getString("height");
                        String mass_value = jsonPart.getString("mass");

                        // applications_feed_entry.add(name_value);
                        feedEntry_value.setName(name_value);
                        feedEntry_value.setHeight(height_value);
                        feedEntry_value.setMass(mass_value);

                    }

                    //feedEntries.addAll(applications_feed_entry);


                    Log.i(TAG, "Name: " + jsonPart.getString("name"));
                    Log.i(TAG, "Height: " + jsonPart.getString("height"));
                    Log.i(TAG, "Mass: " + jsonPart.getString("mass"));





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


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item_main_screen);
        ListView friendsListView = (ListView) findViewById(R.id.list_view_activity);


        DownloadTask task = new DownloadTask();
        task.execute("https://swapi.dev/api/people/");


        //  final ArrayList<String> myFriends = new ArrayList<String>(asList("John", "Paul", "George", "Ringo"));


        // final List<FeedEntry> myFriends = new ArrayList<FeedEntry>();
  /*      for (FeedEntry entry : myFriends){
            entry.setName("test");
        }*/

        List<FeedEntry> feedEntries = new ArrayList<FeedEntry>();

        setListAdapter(new ArrayAdapter<FeedEntry>(this, android.R.layout.simple_list_item_1, feedEntries));
        //friendsListView.setAdapter(arrayAdapter);
//setListAdapter(new ArrayAdapter<String>(this,
//      android.R.layout.simple_list_item_1,
//      this.directoryEntries));
        friendsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // String value = String.valueOf(setListAdapter().getItem(position));
                Toast.makeText(getApplicationContext(), "Hello " + applications_feed_entry.get(position) , Toast.LENGTH_LONG).show();

            }
        });
    }




}
