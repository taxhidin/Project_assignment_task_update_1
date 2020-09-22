package tk.taxhidinkadiri.myapplication.listview_project;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

import tk.taxhidinkadiri.myapplication.Feed_entry_details;
import tk.taxhidinkadiri.myapplication.R;
//public class FeedAdapter<T extends FeedEntry> extends ArrayAdapter {
public class FeedAdapter_detail <T extends Feed_entry_details> extends ArrayAdapter {

    private static final String TAG = "FeedAdapter";
    private final int layoutResource_1;
    private final LayoutInflater layoutInflater_1;
    private List<Feed_entry_details> applications_1;
    //private List<T> applications;

    public FeedAdapter_detail (Context context, int resource, List<Feed_entry_details> applications) {
        super(context, resource);
        this.layoutResource_1 = resource;
        this.layoutInflater_1 = LayoutInflater.from(context);
        this.applications_1 = applications;
    }



    @Override
    public int getCount() {
        return applications_1.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            Log.d(TAG, "getView: getview: called null vonverView");
            convertView = layoutInflater_1.inflate(layoutResource_1, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else {
            Log.d(TAG, "getView: getview: provided convertView");
            viewHolder = (ViewHolder) convertView.getTag();
        }


        //  View view = layoutInflater.inflate(layoutResource, parent, false);
        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView height = (TextView) convertView.findViewById(R.id.height);
        TextView mass = (TextView) convertView.findViewById(R.id.mass);

/*        FeedEntry currentApp = applications.get(position);

        name.setText(currentApp.getName());
        height.setText(currentApp.getHeight());
        mass.setText(currentApp.getMass());*/

   /*     Intent intent_1 = new Intent ();
        intent_1.putExtra("")*/

        Feed_entry_details currentApp = applications_1.get(position);

        viewHolder.movie_name.setText(currentApp.getMovie_name());
        viewHolder.episode_id.setText(currentApp.getEpisode_id());


        return convertView;
    }

    private class ViewHolder {
        final TextView movie_name, episode_id;
        ViewHolder (View view){
            this.movie_name = (TextView) view.findViewById(R.id.movie_name);
            this.episode_id = (TextView) view.findViewById(R.id.episode_id);

        }

    }


}
