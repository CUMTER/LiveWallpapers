package com.liutong.liuwallpapermanager.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

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
        return null;
    }
}
