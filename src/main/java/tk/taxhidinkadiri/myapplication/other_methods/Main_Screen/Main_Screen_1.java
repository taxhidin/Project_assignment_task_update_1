/*
package tk.taxhidinkadiri.myapplication.other_methods.Main_Screen;

import android.app.DownloadManager;
import android.os.Bundle;
import android.util.Log;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;

import tk.taxhidinkadiri.myapplication.MySingleton;
import tk.taxhidinkadiri.myapplication.R;

public class Main_Screen_1 extends AppCompatActivity {

 // https://swapi.dev/api/people/
    //private RequestQueue requestQueue;
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //requestQueue = Volley.newRequestQueue(this);
        queue = MySingleton.getInstance(this.getApplicationContext())
                .getRequestQueue();


JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,)


        //JSonArrayRequest
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,
                "https://swapi.dev/api/people/", (JSONArray) null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {


                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        Log.d("JSonArray", "onResponse: "
                                + jsonObject.getString("id") +
                                " " + jsonObject.getString("title"));
                        boolean d = jsonObject.getBoolean("completed");

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(jsonArrayRequest);

    */
/*     requestQueue.add(jsonArrayRequest);
        requestQueue.add(jsonObjectRequest);*//*


    }
}
*/
