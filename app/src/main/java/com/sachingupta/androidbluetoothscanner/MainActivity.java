package com.sachingupta.androidbluetoothscanner;

import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DeviceListFragment.OnFragmentInteractionListener{
    private DeviceListFragment deviceListFragment;
    private Context context;
    BluetoothAdapter bluetoothAdapter = null;
    public static int REQUEST_BLUETOOTH_ENABLE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main);

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if(bluetoothAdapter != null){
            bluetoothSupported();
        }
        else{
            /* Bluetooth not supported */
            bluetoothNotSupported();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        deviceListFragment = DeviceListFragment.newInstance(bluetoothAdapter);
        fragmentManager.beginTransaction().replace(R.id.container, deviceListFragment).commit();
    }

    private void bluetoothNotSupported() {
        new AlertDialog.Builder(context)
                .setTitle("Not Compatible")
                .setMessage("Your Devic does not support Bluetooth")
                .setPositiveButton("Exit", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                     System.exit(0);
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    private void bluetoothSupported() {
       if(bluetoothAdapter.isEnabled()){
           bluetoothEnabled();
       }
        else{
            bluetoothDisabled();
       }
    }

    private void bluetoothDisabled() {
        Intent enableBluetooth = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        startActivityForResult(enableBluetooth, REQUEST_BLUETOOTH_ENABLE);
    }

    private void bluetoothEnabled() {
        String status = "";
        String mydeviceAddress = bluetoothAdapter.getAddress();
        String mydeviceName = bluetoothAdapter.getName();
        status = mydeviceName + " : " + mydeviceAddress;
        Toast.makeText(context, status, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFragmentInteraction(String id) {

    }
}
