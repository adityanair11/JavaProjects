package com.smarthome.devices;

public class SmartLight extends SmartDevice
{
    SmartLight(String did, boolean ison)
    {
      super(did,ison); 
    }

    public String getStatus()
    {
        if(isOn==true)
            return "Light is ON";
        else
            return "Light is OFF";
    }

    double calculatePower()
    {
       if(isOn==true)
            return 15.0;
        else
            return 0.0; 
    }
}
