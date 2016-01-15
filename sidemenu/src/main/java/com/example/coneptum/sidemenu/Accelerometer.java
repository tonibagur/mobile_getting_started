package com.example.coneptum.sidemenu;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by coneptum on 13/01/16.
 */
public class Accelerometer extends Activity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mSensor;
    private TextView x_data;
    private TextView y_data;
    private TextView z_data;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accelerometer);

        x_data = (TextView) findViewById(R.id.x_data);
        y_data = (TextView) findViewById(R.id.y_data);
        z_data = (TextView) findViewById(R.id.z_data);

        //getting accelerometer
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

    }

    //on change data change value
    @Override
    public void onSensorChanged(SensorEvent event) {
        x_data.setText("x=" + event.values[0]);
        y_data.setText("y=" + event.values[1]);
        z_data.setText("z=" + event.values[2]);

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