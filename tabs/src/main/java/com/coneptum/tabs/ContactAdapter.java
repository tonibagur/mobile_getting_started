package com.coneptum.tabs;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;


/**
 * Created by coneptum on 11/12/15.
 */
public class ContactAdapter extends BaseAdapter {

    Context context;
    int layoutResourceId;
    ArrayList<Contact> data;

    public ContactAdapter(Context context, int layoutResourceId, ArrayList<Contact> data) {
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

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
            holder.delete = (Button) row.findViewById(R.id.deleteButton);

            row.setTag(holder);
        } else {
            holder = (ContactHolder) row.getTag();
        }

        Contact contact = data.get(position);
        holder.name.setText(contact.getName());
        holder.status.setText(contact.getStatus());
        holder.imgIcon.setImageResource(contact.getIcon());
        holder.delete.setTag(position);

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.remove((int) v.getTag());
                notifyDataSetChanged();
            }
        });

        return row;
    }

    static class ContactHolder {
        ImageView imgIcon;
        TextView name;
        TextView status;
        Button delete;

    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
