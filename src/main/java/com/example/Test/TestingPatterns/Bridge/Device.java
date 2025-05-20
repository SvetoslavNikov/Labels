package com.example.Test.TestingPatterns.Bridge;
/*
You are designing a remote control system for different devices: TV, Radio, etc.
Devices (TV, Radio...) have common functionality (turn on/off, set volume).
Remotes may have basic or advanced features (like mute).
If you model this with inheritance, you'd need:

BasicRemoteForTV
AdvancedRemoteForTV
BasicRemoteForRadio
AdvancedRemoteForRadio
 */
public interface Device {
    void turnOn();
    void turnOff();
    void setVolume(int percent);
}

class TV implements Device {
    public void turnOn() { System.out.println("TV is ON"); }
    public void turnOff() { System.out.println("TV is OFF"); }
    public void setVolume(int percent) { System.out.println("TV volume set to " + percent + "%"); }
}

class Radio implements Device {
    public void turnOn() { System.out.println("Radio is ON"); }
    public void turnOff() { System.out.println("Radio is OFF"); }
    public void setVolume(int percent) { System.out.println("Radio volume set to " + percent + "%"); }
}

// the Bridge Pattern lets you
// add new RemoteControl types or new Device types without rewriting combinations for each.
class RemoteControl{
    Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    void turnOn(){
        device.turnOn();
    }

    void turnOff(){
        device.turnOn();
    }

    void setVolume(int percent){
        device.setVolume(percent);
    }
}

class AdvancedRemote extends RemoteControl {
    public AdvancedRemote(Device device) {
        super(device);
    }

    //extra func
    void mute(){
        device.setVolume(0);
        System.out.println("Muted");
    }
}

class Main {
    public static void main(String[] args) {
        Device tv = new TV();
        RemoteControl distancionno = new AdvancedRemote(tv);
        distancionno.turnOn();
        distancionno.setVolume(50);
        ((AdvancedRemote) distancionno).mute();
        distancionno.turnOff();
    }
}
