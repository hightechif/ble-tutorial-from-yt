package com.example.bletutorial.presentation

import android.bluetooth.BluetoothAdapter
import androidx.compose.runtime.Composable
import com.example.bletutorial.presentation.permissions.SystemBroadcastReceiver

@Composable
fun TemperatureHumidityScreen(
    onBluetoothStateChanged: () -> Unit
) {

    SystemBroadcastReceiver(systemAction = BluetoothAdapter.ACTION_STATE_CHANGED) { bluetoothState ->
        val action = bluetoothState?.action ?: return@SystemBroadcastReceiver
        if (action == BluetoothAdapter.ACTION_STATE_CHANGED) {
            onBluetoothStateChanged.invoke()
        }

    }
}