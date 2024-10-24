// src/state/energy/NormalEnergyState.java
package state.energy;

import device.Device;
import state.EnergyState;

public class NormalEnergyState implements EnergyState {
    private Device device;

    @Override
    public void setDevice(Device device) {
        this.device = device;
    }

    @Override
    public void lowBatteryAlert() {
        int batteryPercentage = device.getBatteryPercentage();
        if (batteryPercentage < 25) {
            System.out.println("Low battery");
        } else {
            System.out.println("(No energy alert)");
        }
    }

    @Override
    public void setMaxBrightness() {
        device.setBrightness(100); // Set brightness to 100%
        System.out.println("Maximum brightness set to 100%");
    }
}
