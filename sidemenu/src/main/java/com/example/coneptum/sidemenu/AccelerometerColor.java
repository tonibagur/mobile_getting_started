package com.example.coneptum.sidemenu;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by coneptum on 13/01/16.
 */
public class AccelerometerColor extends Activity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mSensor;
    private ImageView img1;
    private ImageView img2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accelerometer_color);

        img1 = (ImageView) findViewById(R.id.image1);
        img2 = (ImageView) findViewById(R.id.image2);

        //getting accelerometer
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }


    //on change data change background color (white to black)
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onSensorChanged(SensorEvent event) {

        float num_x_data = event.values[0];

        /*int rgb_num = (int) ((num_x_data + 4) * 31.875);


        if (rgb_num > 255) {
            img.setBackgroundColor(Color.rgb(255, 255, 255));
        } else if (rgb_num < 0) {
            img.setBackgroundColor(Color.rgb(0, 0, 0));
        } else {
            img.setBackgroundColor(Color.rgb(rgb_num, rgb_num, rgb_num));
        }*/
        float alpha=((num_x_data+4)/8);

       /* if(num_x_data>4){
            img1.setAlpha(1);
            img2.setAlpha(0);
        }else if(num_x_data<-4){
            img1.setAlpha(0);
            img2.setAlpha(1);
        }else{*/
            img1.setAlpha(alpha);
            img2.setAlpha(1-alpha);
        //}

    }

    //coming with interface implemented
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    //setting listener on sensor
    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    //unsetting listener on sensor
    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }
}