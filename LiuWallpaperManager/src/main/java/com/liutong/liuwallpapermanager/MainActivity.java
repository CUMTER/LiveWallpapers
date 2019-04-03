package com.liutong.liuwallpapermanager;


import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.service.wallpaper.WallpaperService;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.wallpaperinfo_listview)
    ListView wallpaperinfoListview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        List<ResolveInfo> list = getPackageManager().queryIntentServices(new Intent(WallpaperService.SERVICE_INTERFACE), PackageManager.GET_META_DATA);
        ArrayList<Map> wallpaperlist = new ArrayList<Map>();
        for (ResolveInfo  info : list ) {
           ApplicationInfo applicationInfo = (ApplicationInfo) getPackageManager().getApplicationLabel(info.serviceInfo.applicationInfo);

            HashMap map = new HashMap<>();

            map.put("name",applicationInfo.name + "");
            map.put("id",applicationInfo.icon);

        }


    }
}
