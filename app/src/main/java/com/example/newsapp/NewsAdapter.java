package com.example.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class NewsAdapter extends ArrayAdapter<News> {


    public NewsAdapter(Context context, ArrayList<News> news) {
        super(context, 0, news);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listViewItem = convertView;

        if (listViewItem == null) {
            listViewItem = LayoutInflater.from(getContext()).inflate(
                    R.layout.newsitemslist, parent, false);
        }
        News currentNewsItem = getItem(position);

        // Create a new Date object from the time in milliseconds of the earthquake
        assert currentNewsItem != null;
        Date dateObject = new Date(currentNewsItem.getTimeInMilliseconds());

        // Find the TextView with view ID date
        TextView newsDate = listViewItem.findViewById(R.id.date_text_view);
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formattedDate(dateObject);
        // Display the date of the current date in that TextView
        newsDate.setText(formattedDate);


// Find the TextView with view ID title
        TextView newsTitle = listViewItem.findViewById(R.id.title_text_view);
        newsTitle.setText(currentNewsItem.getNewsTitle());
// Find the TextView with view ID for section
        TextView tvType = listViewItem.findViewById(R.id.type_text_view);
        tvType.setText(currentNewsItem.getNewsSection());

        return listViewItem;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formattedDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

}


