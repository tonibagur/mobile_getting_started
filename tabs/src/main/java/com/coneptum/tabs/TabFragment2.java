package com.coneptum.tabs;

/**
 * Created by coneptum on 9/12/15.
 */


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;


public class TabFragment2 extends Fragment {

    //variables
    private ListView lv;
    private ArrayList<Contact> contacts = new ArrayList<Contact>();

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab_fragment_2, container, false);
        lv = (ListView) view.findViewById(R.id.list);

        //create contacts
        contacts.add(new Contact(R.drawable.avatar_ben, "Ben Sparrow", "You on your way?"));
        contacts.add(new Contact(R.drawable.avatar_max, "Max Lynx", "Hey, it's me"));
        contacts.add(new Contact(R.drawable.avatar_adam, "Adam Bradleyson", "I should buy a boat"));
        contacts.add(new Contact(R.drawable.avatar_perry, "Perry Governor", "Look at my muklukus!"));
        contacts.add(new Contact(R.drawable.avatar_mike, "Mike Harrington", "This is wicked good ice cream."));

        //set adapter for contacts list
        ContactAdapter adapter = new ContactAdapter(getActivity(), R.layout.row_layout, contacts);
        lv.setAdapter(adapter);

        //on click contact shows details
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentTransaction trans = getFragmentManager().beginTransaction();
                trans.replace(R.id.tab2, new DetailContact(contacts.get(position)), "detail");
                trans.addToBackStack(null);
                trans.commit();
            }

        });

        return view;

    }


}
