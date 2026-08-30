package com.smarthome.devices;

public class SmartThermostat extends SmartDevice
{
    SmartThermostat(String did, boolean ison)
    {
      super(did,ison); 
    }

    public String getStatus()
    {
        if(isOn==true)
            return "AC is Running";
        else
            return "AC is Idle";
    }

    double calculatePower()
    {
       if(isOn==true)
            return 1500.0;
        else
            return 0.0; 
    }
}
