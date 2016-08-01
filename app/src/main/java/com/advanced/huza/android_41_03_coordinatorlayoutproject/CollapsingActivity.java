package com.advanced.huza.android_41_03_coordinatorlayoutproject;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Huza on 2016/8/1.
 */
public class CollapsingActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing_layout);

        Toolbar toolBar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolBar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(v, "我是超级Toast", Snackbar.LENGTH_LONG);
                snackbar.setAction("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(CollapsingActivity.this, "你出来了", Toast.LENGTH_LONG).show();
                    }
                });
                snackbar.show();
            }
        });

        initCollapsingToolbarLayout();
        initContent();

    }

    private void initCollapsingToolbarLayout() {
        CollapsingToolbarLayout ctl = (CollapsingToolbarLayout) findViewById(R.id.ctl);
        //扩张时候的title颜色
        ctl.setExpandedTitleColor(Color.YELLOW);
        //收缩后在Toolbar上显示时的title的颜色：
        ctl.setCollapsedTitleTextColor(Color.BLUE);
    }


    private void initContent() {
        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        list = new ArrayList<String>();
        for (int i = 0; i < 30; i++) {
            list.add("新数据" + i);
        }

        RVAdapter adapter = new RVAdapter();
        recyclerView.setAdapter(adapter);

    }

    private List<String> list;

    class RVAdapter extends RecyclerView.Adapter<RVAdapter.MyViewHolder> {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, null);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            // 绑定数据
            holder.textView.setText(list.get(position));
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            TextView textView;

            public MyViewHolder(View itemView) {
                super(itemView);
                textView = (TextView) itemView.findViewById(R.id.tv);
            }

        }
    }

}
