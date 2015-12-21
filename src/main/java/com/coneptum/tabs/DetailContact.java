package com.coneptum.tabs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by coneptum on 11/12/15.
 */
public class DetailContact extends Fragment {

    private Contact contact;

    public DetailContact(Contact contact) {
        this.contact = contact;
    }

    public DetailContact(){};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Log.d("DEBUG", "onCreateView");ContactHolder holder = null;
        View v = inflater.inflate(R.layout.detail_contact, container, false);
        ImageView icon=(ImageView)v.findViewById(R.id.detail_icon);
        TextView status=(TextView)v.findViewById(R.id.detail_status);
        TextView name=(TextView)v.findViewById(R.id.detail_name);
        status.setText(contact.getStatus());
        icon.setImageResource(contact.getIcon());
        name.setText(contact.getName());
        return v;
    }


}
