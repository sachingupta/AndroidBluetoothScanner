package com.sachingupta.androidbluetoothscanner;

/**
 * Created by Sachin Gupta on 11/28/2015.
 */
public class DeviceInfo {
    private String deviceName;
    private String address;
    private boolean connected;

    public String getDeviceName() {
        return deviceName;
    }

    public boolean getConnected() {
        return connected;
    }

    public String getAddress() {
        return address;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public DeviceInfo(String name, String address, String connected) {
        this.deviceName = name;
        this.address = address;
        if (connected == "true") {
            this.connected = true;
        } else {
            this.connected = false;
        }
    }
}
