package com.example.dashboarduidesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Muhammad Azwar Bahar on 24/11/19.
 */

public class MainActivity extends AppCompatActivity {

    private String[] title;
    private TypedArray poster;
    private TypedArray background;
    ArrayList<DashboardItem> dashboardItems;

    Toolbar toolbar;

    private Switch switch1;
    private TextView tv_title;
    private LinearLayout ll_buttom;
    private RelativeLayout rl_main;
    private RelativeLayout line_butt;
    DashboardAdapter dashboardAdapter;

    RecyclerView rv_dashboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dashboardItems = tambahItem();

        rv_dashboard = findViewById(R.id.rv_dashboard);
        dashboardAdapter = new DashboardAdapter(this, dashboardItems);
        rv_dashboard.setLayoutManager(new GridLayoutManager(this, 2));
        rv_dashboard.setAdapter(dashboardAdapter);

        rl_main = findViewById(R.id.rl_main);
        tv_title = findViewById(R.id.tv_title);
        line_butt = findViewById(R.id.line_butt);
        toolbar = findViewById(R.id.toolbar);
        ll_buttom = findViewById(R.id.ll_buttom);



        final Resources resources = this.getResources();
        switch1 = findViewById(R.id.switch1);
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){

                    //ubah background
                    int transit_bg = resources.getColor(R.color.hitam);
                    rl_main.setBackgroundColor(transit_bg);

                    //ubah tv_title
                    int transit_tv_title = resources.getColor(R.color.putih);
                    tv_title.setTextColor(transit_tv_title);

                    //ubah line_butt
                    int transit_line_butt = resources.getColor(R.color.putih);
                    line_butt.setBackgroundColor(transit_line_butt);

                    //ubah toolbar
                    Drawable transit_toolbar = resources.getDrawable(R.drawable.bg_toolbar_black);
                    toolbar.setBackground(transit_toolbar);

                    //ubah bar bawah
                    Drawable transit_bar_buttom = resources.getDrawable(R.drawable.bg_naf_buttom_black);
                    ll_buttom.setBackground(transit_bar_buttom);

                } else {

                    //ubah background
                    int transit_bg = resources.getColor(R.color.putih);
                    rl_main.setBackgroundColor(transit_bg);


                    //ubah tv_title
                    int transit_tv_title = resources.getColor(R.color.hitam);
                    tv_title.setTextColor(transit_tv_title);


                    //ubah line_butt
                    int transit_line_butt = resources.getColor(R.color.hitam);
                    line_butt.setBackgroundColor(transit_line_butt);

                    //ubah toolbar
                    Drawable transit_toolbar = resources.getDrawable(R.drawable.bg_toolbar);
                    toolbar.setBackground(transit_toolbar);

                    //ubah bar bawah
                    Drawable transit_bar_buttom = resources.getDrawable(R.drawable.bg_naf_buttom_white);
                    ll_buttom.setBackground(transit_bar_buttom);

                }
            }
        });


    }

    private ArrayList<DashboardItem> tambahItem(){

        title = getResources().getStringArray(R.array.title);
        poster = getResources().obtainTypedArray(R.array.poster);
        background = getResources().obtainTypedArray(R.array.background);

        ArrayList<DashboardItem> listnya = new ArrayList<>();
        for (int a = 0; a < title.length; a++){
            DashboardItem dashboardItem = new DashboardItem();
            dashboardItem.setTitle(title[a]);
            dashboardItem.setPoster(poster.getResourceId(a, -1));
            dashboardItem.setBackground(background.getResourceId(a, -1));
            listnya.add(dashboardItem);
        }
        return listnya;
    }
}

