package com.coneptum.tabs;

/**
 * Created by coneptum on 10/12/15.
 */

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Contact {

    private int icon;
    private String name;
    private String status;

    public Contact(int icon, String name, String status){
        this.icon=icon;
        this.name=name;
        this.status=status;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}