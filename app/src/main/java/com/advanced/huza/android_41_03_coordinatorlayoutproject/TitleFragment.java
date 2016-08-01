package com.advanced.huza.android_41_03_coordinatorlayoutproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Huza on 2016/8/1.
 */
public class TitleFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout, null);
        TextView title = (TextView) view.findViewById(R.id.title);

        Bundle bundle = getArguments();
        title.setText(bundle.getString("title"));


        return view;
    }
}
