package com.smarthome.devices;

public abstract class SmartDevice implements Controllable
{
    protected String deviceId;
    protected boolean isOn;

   SmartDevice(String d, boolean i)
   {
    deviceId=d;
    isOn=i;
   }
   String getNetwork()
   {
     return "Home_WiFi";
   }
   
   abstract double calculatePower();

   void displayDeviceDetails()
   {
    System.out.println("Network: "+getNetwork());
    System.out.println("Device ID: "+deviceId);
    System.out.println("Status: "+getStatus());
    System.out.println("Power: "+calculatePower()+"W");
    
    
   }
}
