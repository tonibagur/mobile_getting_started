package com.example.coneptum.sidemenu;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * Created by coneptum on 11/01/16.
 */
public class Option1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.option1, container, false);

        TextView op = (TextView) v.findViewById(R.id.op);
        return v;
    }
}
