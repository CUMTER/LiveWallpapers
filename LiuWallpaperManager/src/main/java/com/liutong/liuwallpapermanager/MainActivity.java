package com.liutong.liuwallpapermanager;


import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.service.wallpaper.WallpaperService;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.liutong.liuwallpapermanager.adapter.WallpaperInfoAdapter;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    @BindView(R.id.wallpaperinfo_listview)
    ListView wallpaperinfoListview;

    private BaseAdapter adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        List<ResolveInfo> list = getPackageManager().queryIntentServices(new Intent(WallpaperService.SERVICE_INTERFACE), PackageManager.GET_META_DATA);
        ArrayList<Map> wallpaperlist = new ArrayList<Map>();
        for (ResolveInfo  info : list ) {
            ApplicationInfo applicationInfo = info.serviceInfo.applicationInfo;

            HashMap map = new HashMap<>();
            map.put("name",getPackageManager().getApplicationLabel(applicationInfo) + "");
            Logger.d("name",getPackageManager().getApplicationLabel(applicationInfo));
            map.put("icon",getPackageManager().getApplicationIcon(applicationInfo));

            map.put("className",info.serviceInfo.packageName);
            Logger.d("className",info.serviceInfo.packageName);

            wallpaperlist.add(map);

        }

        adapter = new WallpaperInfoAdapter(this,wallpaperlist);
        wallpaperinfoListview.setAdapter(adapter);
        wallpaperinfoListview.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//        Intent intent = new Intent();
//
//        HashMap map = (HashMap) adapterView.getItemAtPosition(i);
//
//        String appName = (String) map.get("className");
//
//        Logger.d(appName);
//
//        PackageInfo packageInfo;
//
//        try {
//           packageInfo = getPackageManager().getPackageInfo(appName,0);
//        } catch (PackageManager.NameNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        intent = getPackageManager().getLaunchIntentForPackage(appName);

        Intent chooseIntent = new Intent(Intent.ACTION_SET_WALLPAPER);

        Intent intent = new Intent(Intent.ACTION_CHOOSER);
        intent.putExtra(Intent.EXTRA_INTENT, chooseIntent);
        intent.putExtra(Intent.EXTRA_TITLE, "选择壁纸");
        startActivity(intent);


    }
}