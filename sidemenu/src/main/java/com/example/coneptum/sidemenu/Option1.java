package com.example.coneptum.sidemenu;


import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;


/**
 * Created by coneptum on 11/01/16.
 */
public class Option1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.option1);
        /*try{
            setSupportActionBar(MainActivity.getToolbar());}
        catch(Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }*/
    }
}
