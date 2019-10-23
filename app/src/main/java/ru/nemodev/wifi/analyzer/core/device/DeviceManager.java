package ru.nemodev.wifi.analyzer.core.device;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.format.Formatter;

public class DeviceManager
{
    public static DeviceInfo getDeviceInfo(Context context) {

        WifiManager manager = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = manager.getConnectionInfo();

        return new DeviceInfo(
                Build.DEVICE,
                Build.MODEL,
                Build.VERSION.SDK,
                Build.VERSION.RELEASE,
                info.getMacAddress(),
                Formatter.formatIpAddress(info.getIpAddress())
        );
    }
}