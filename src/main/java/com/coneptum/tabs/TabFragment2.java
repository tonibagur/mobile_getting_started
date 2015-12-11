package com.coneptum.tabs;

/**
 * Created by coneptum on 9/12/15.
 */


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


public class TabFragment2 extends Fragment {

    /*    @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.tab_fragment_2, container, false);
            ListView lv = (ListView) view.findViewById(R.id.list);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                    android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.contacts));
            lv.setAdapter(adapter);
            return view;

        }*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment_2, container, false);
        ListView lv = (ListView) view.findViewById(R.id.list);

       final Contact contacts_data[] = new Contact[]
                {
                        new Contact(R.drawable.android, "Ben Sparrow", "You on your way?"),
                        new Contact(R.drawable.android, "Max Lynx", "Hey, it's me"),
                        new Contact(R.drawable.android, "Adam Bradleyson", "I should buy a boat"),
                        new Contact(R.drawable.android, "Perry Governor", "Look at my muklukus!"),
                        new Contact(R.drawable.square, "Mike Harrington", "This is wicked good ice cream.")
                };

        ContactAdapter adapter = new ContactAdapter(getActivity(),R.layout.row_layout, contacts_data);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentTransaction trans = getFragmentManager().beginTransaction();
                trans.replace(R.id.pager, new DetailContact(contacts_data[position]));
                trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                trans.addToBackStack(null);
                trans.commit();
            }
        });

        return view;

    }
}
