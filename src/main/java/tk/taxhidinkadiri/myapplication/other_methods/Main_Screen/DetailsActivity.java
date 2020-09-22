/*
package tk.taxhidinkadiri.myapplication;

import android.os.Bundle;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {
    private TextView dets_Name, movies;
    private TextView episode_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        dets_Name = findViewById(R.id.dets_name);
        movies = findViewById(R.id.movies);
        episode_id = findViewById(R.id.episode);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String name = bundle.getString("name");
            String height = bundle.getString("height");
            String mass = bundle.getString("mass");
            String movie = bundle.getString("movies");
            String episode_id = bundle.getString("episode_id");

            dets_Name.setText(name);
            movies.setText(movies);
            episode_id.setText(episode_id);
        }

    }

}
*/
