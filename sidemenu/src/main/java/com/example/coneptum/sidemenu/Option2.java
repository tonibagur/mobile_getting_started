package com.example.coneptum.sidemenu;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by coneptum on 13/01/16.
 */
public class Option2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.option1);

        TextView op= (TextView) findViewById(R.id.op);
        op.setText("Option 2");
    }

}
