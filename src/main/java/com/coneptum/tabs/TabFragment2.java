package com.coneptum.tabs;

/**
 * Created by coneptum on 9/12/15.
 */


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.swipe.SwipeLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.Inflater;


public class TabFragment2 extends Fragment {

    private static ListView lv;
    ArrayList<Contact> contacts = new ArrayList<Contact>();

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment_2, container, false);
        lv = (ListView) view.findViewById(R.id.list);

       /* Contact contacts_data[] = new Contact[]
                {
                        new Contact(R.drawable.android, "Ben Sparrow", "You on your way?"),
                        new Contact(R.drawable.android, "Max Lynx", "Hey, it's me"),
                        new Contact(R.drawable.android, "Adam Bradleyson", "I should buy a boat"),
                        new Contact(R.drawable.android, "Perry Governor", "Look at my muklukus!"),
                        new Contact(R.drawable.avatar_square, "Mike Harrington", "This is wicked good ice cream.")
                };

        final ArrayList<Contact> contacts=(ArrayList)Arrays.asList(contacts_data);
*/
        contacts.add(new Contact(R.drawable.android, "Ben Sparrow", "You on your way?"));
        contacts.add(new Contact(R.drawable.android, "Max Lynx", "Hey, it's me"));
        contacts.add(new Contact(R.drawable.android, "Adam Bradleyson", "I should buy a boat"));
        contacts.add(new Contact(R.drawable.android, "Perry Governor", "Look at my muklukus!"));
        contacts.add(new Contact(R.drawable.avatar_square, "Mike Harrington", "This is wicked good ice cream."));

        ContactAdapter adapter = new ContactAdapter(getActivity(), R.layout.row_layout, contacts);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                FragmentTransaction trans = getFragmentManager().beginTransaction();
  /*              Toast.makeText(getActivity(), contacts_data[position].getStatus(), Toast.LENGTH_SHORT).show();*/
                //hauria de funcionar amb:
    /*            trans.replace(R.id.pager, new DetailContact(contacts_data[position]));*/
                //pero de moment només funciona sense ajustarse a la tab amb:
                trans.replace(android.R.id.content, new DetailContact(contacts.get(position)));
                trans.addToBackStack(null);
                trans.commit();

            }
        });

        //not working
        /*SwipeLayout swipeLayout = (SwipeLayout) view.findViewById(R.id.sample1);

        Button delete = (Button) getActivity().findViewById(R.id.deleteButton);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lv.removeView(v);
            }
        });*/


        return view;

    }

    public static ListView getLv() {
        return lv;
    }

}
