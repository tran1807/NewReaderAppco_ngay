package com.example.newsreaderapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {
    public NewsAdapter(@NonNull Context context, int resource, @NonNull List<News> objects) {
        super(context, resource, objects);
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view =  inflater.inflate(R.layout.dong_layout_listview, null);
        }
        News news = getItem(position);
        if (news != null) {
            // Anh xa + Gan gia tri
            TextView txtTitle = (TextView) view.findViewById(R.id.textViewTitle);
            ImageView imgHinhAnh = (ImageView) view.findViewById(R.id.imageViewHinhAnh);
            TextView txtDate = (TextView) view.findViewById(R.id.textViewDate);
            //dua du lieu len
            txtTitle.setText(news.getTitle());
            txtDate.setText(news.getDate());
            //dua hinh anh len
            Picasso.with(getContext()).load(news.getImage()).into(imgHinhAnh);
        }
        return view;
    }
}
