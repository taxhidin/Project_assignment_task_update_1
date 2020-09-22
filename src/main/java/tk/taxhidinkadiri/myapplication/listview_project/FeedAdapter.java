package tk.taxhidinkadiri.myapplication.listview_project;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import tk.taxhidinkadiri.myapplication.R;



public class FeedAdapter<T extends FeedEntry> extends ArrayAdapter {
    private static final String TAG = "FeedAdapter";
    private final int layoutResource;
    private final LayoutInflater layoutInflater;
    private List<FeedEntry> applications;
    //private List<T> applications;

    public FeedAdapter(Context context, int resource, List<FeedEntry> applications) {
        super(context, resource);
        this.layoutResource = resource;
        this.layoutInflater = LayoutInflater.from(context);
        this.applications = applications;
    }

    @Override
    public int getCount() {
        return applications.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            Log.d(TAG, "getView: getview: called null vonverView");
            convertView = layoutInflater.inflate(layoutResource, parent, false);
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

        FeedEntry currentApp = applications.get(position);

   viewHolder.name.setText(currentApp.getName());
   viewHolder.height.setText(currentApp.getHeight());
   viewHolder.mass.setText(currentApp.getMass());

        return convertView;
    }

    private class ViewHolder {
        final TextView name, height, mass;
        ViewHolder (View view){
            this.name = (TextView) view.findViewById(R.id.name);
            this.height = (TextView) view.findViewById(R.id.episode_id);
            this.mass = (TextView) view.findViewById(R.id.mass);
        }

    }


}
