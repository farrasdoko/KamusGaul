package com.farrasabiyyu12.kamusgaul;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.farrasabiyyu12.kamusgaul.model.EntriesItem;

import java.util.List;

public class KamusAdapter extends ArrayAdapter<EntriesItem> {
    private List<EntriesItem> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        private TextView word, definition, author;
        private View selang;
    }

    public KamusAdapter(List<EntriesItem> data, Context context) {
        super(context, R.layout.rc_bahasa_layout, data);
        this.dataSet = data;
        this.mContext=context;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        EntriesItem entriesItem = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.rc_bahasa_layout, parent, false);
            viewHolder.word = (TextView) convertView.findViewById(R.id.word);
            viewHolder.definition = (TextView) convertView.findViewById(R.id.definition);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        viewHolder.selang = convertView;
        if (position % 2 == 0) {
            viewHolder.selang.setBackgroundColor(Color.WHITE);
        } else if (position % 2 == 1) {
            viewHolder.selang.setBackgroundColor(Color.rgb(235, 235, 242));
        }

        viewHolder.word.setText(entriesItem.getWord());
        viewHolder.definition.setText(entriesItem.getDefinition());
        // Return the completed view to render on screen
        return convertView;
    }
}