package com.example.coneptum.sidemenu;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by coneptum on 13/01/16.
 */
public class Option3 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.option1);

        TextView op= (TextView) findViewById(R.id.op);
        op.setText("Option 3");
    }

}