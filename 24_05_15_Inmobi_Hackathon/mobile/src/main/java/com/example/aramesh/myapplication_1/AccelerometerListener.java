package com.example.aramesh.myapplication_1;

/**
 * Created by aramesh on 23/05/15.
 */

public interface AccelerometerListener {

    public void onAccelerationChanged(float x, float y, float z);

    public void onShake(float force);

}