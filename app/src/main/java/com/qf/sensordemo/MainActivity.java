package com.qf.sensordemo;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SensorManager manager;
    private List<Sensor> sensors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //        logSensor();
        //获得传感器管理对象
        manager = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor sensor = manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        //传感器监听器
        SensorEventListener listener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {

            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
        manager.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_GAME);
    }

    private void logSensor() {
        //获得传感器管理对象
        manager = (SensorManager) getSystemService(SENSOR_SERVICE);
        //获得当前手机的所有传感器
        sensors = manager.getSensorList(Sensor.TYPE_ALL);
        for (Sensor sensor : sensors) {
            //传感器公司名和传感器名字
            String str = sensor.getVendor() + sensor.getName();
            Log.e("TAG", "onCreate: " + sensor);
        }
    }
}
