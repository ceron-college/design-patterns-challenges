// src/device/Device.java
package device;

import state.SoundState;
import state.sound.NormalState;
import state.EnergyState;
import state.energy.NormalEnergyState;

public class Device {
    private SoundState soundState;
    private EnergyState energyState;
    private int batteryPercentage;
    private int brightness; // New field for brightness

    public Device() {
        this.soundState = new NormalState();
        this.energyState = new NormalEnergyState();
        this.energyState.setDevice(this);
        this.batteryPercentage = 100; // Default battery percentage
        this.brightness = 100; // Default brightness
    }

    public void setSoundState(SoundState state) {
        this.soundState = state;
    }

    public void setEnergyState(EnergyState state) {
        this.energyState = state;
        this.energyState.setDevice(this);
        this.energyState.setMaxBrightness(); // Adjust brightness based on new energy state
    }


    public void setBatteryPercentage(int batteryPercentage) {
        this.batteryPercentage = batteryPercentage;
//        Optionally adjust brightness if needed
//        this.energyState.setMaxBrightness();
    }

    public int getBatteryPercentage() {
        return this.batteryPercentage;
    }

    public int getBrightness() {
        return this.brightness;
    }

    public void setBrightness(int brightness) {
        if (brightness < 0 || brightness > 100) {
            throw new IllegalArgumentException("Brightness must be between 0 and 100");
        }
        this.brightness = brightness;
        // Add logic here to apply brightness to the device hardware if necessary
        System.out.println("Device brightness set to " + brightness + "%");
    }

    public void alertSound() {
        this.soundState.alert();
    }

    public void alertEnergy() {
        this.energyState.lowBatteryAlert();
    }
}
