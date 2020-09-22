package tk.taxhidinkadiri.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Feed_entry_details {

    private String movie_name;
    private String episode_id;

    public Feed_entry_details() {
    }

    public Feed_entry_details(String movie_name, String episode_id) {
        this.movie_name = movie_name;
        this.episode_id = episode_id;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getEpisode_id() {
        return episode_id;
    }

    public void setEpisode_id(String episode_id) {
        this.episode_id = episode_id;
    }
}
