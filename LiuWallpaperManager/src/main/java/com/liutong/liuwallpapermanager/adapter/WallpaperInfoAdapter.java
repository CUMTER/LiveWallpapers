package com.liutong.liuwallpapermanager.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.liutong.liuwallpapermanager.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;

public class WallpaperInfoAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Map> list;
    public WallpaperInfoAdapter(@NonNull Context context, ArrayList<Map> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override         
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.layout,parent,false);
            holder.imageView = convertView.findViewById(R.id.service_icon);
            holder.textView = convertView.findViewById(R.id.service_name);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        HashMap map = (HashMap) getItem(position);

        holder.textView.setText((CharSequence) map.get("name"));
        holder.imageView.setImageDrawable((Drawable) map.get("icon"));

        return convertView;
    }

    public class ViewHolder {
        private ImageView imageView;
        private TextView textView;
    }
}
