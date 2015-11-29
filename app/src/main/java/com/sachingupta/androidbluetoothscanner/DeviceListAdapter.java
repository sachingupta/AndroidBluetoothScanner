package com.sachingupta.androidbluetoothscanner;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Sachin Gupta on 11/28/2015.
 */
public class DeviceListAdapter extends ArrayAdapter<DeviceInfo> {

    private Context context;
    private BluetoothAdapter bluetoothAdapter;

    public DeviceListAdapter(Context context, List items, BluetoothAdapter bluetoothAdapter) {
        super(context, android.R.layout.simple_list_item_1, items);
        this.bluetoothAdapter = bluetoothAdapter;
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parentView){
        DeviceInfo item = (DeviceInfo)getItem(position);
        if(convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.device_list_item, parentView, false);
        }
        TextView deviceNameView = (TextView)convertView.findViewById(R.id.deviceNameView);
        deviceNameView.setText(item.getDeviceName());

        TextView deviceAddress = (TextView)convertView.findViewById(R.id.deviceAddress);
        deviceAddress.setText(item.getAddress());
        return convertView;
    }
}
