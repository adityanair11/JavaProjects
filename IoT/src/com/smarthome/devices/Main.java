package com.smarthome.devices;

public class Main 
{
    
    public static void main(String args[])
    {
      SmartDevice objLight=new SmartLight("L-01",true);
      SmartDevice objAC=new SmartThermostat("T-99",false);
      objLight.displayDeviceDetails();
      objAC.displayDeviceDetails();
    }   
}
