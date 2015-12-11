package com.coneptum.tabs;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by coneptum on 11/12/15.
 */
public class ContactAdapter extends ArrayAdapter<Contact> {

    Context context;
    int layoutResourceId;
    Contact data[] = null;
    /*Contact contact=null;*/

    public ContactAdapter(Context context, int layoutResourceId, Contact[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

/*    public ContactAdapter(FragmentActivity activity, int layoutResourceId, int position,Contact[] data) {
        super(activity, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = activity;
        this.data = data;
        this.contact=data[position];
    }*/

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ContactHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new ContactHolder();
            holder.imgIcon = (ImageView) row.findViewById(R.id.icon);
            holder.name = (TextView) row.findViewById(R.id.name);
            holder.status = (TextView) row.findViewById(R.id.status);

            row.setTag(holder);
        } else {
            holder = (ContactHolder) row.getTag();
        }

        Contact contact = data[position];
        holder.name.setText(contact.getName());
        holder.status.setText(contact.getStatus());
        holder.imgIcon.setImageResource(contact.getIcon());

        return row;
    }

    static class ContactHolder {
        ImageView imgIcon;
        TextView name;
        TextView status;

    }
}
