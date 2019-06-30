package com.example.vcparkingslot;

public class VCParkingSlot {
    public VCParkingSlot Instance = null;
    private Activity activity;
    private Boolean instance_activity = false;
    Pool pool = new Pool();

    public VCParkingSlot() {
        if(Instance == null) {
            Instance = this;
        }
    }

    public String Title() {
        return "VC Parking Slot";
    }
    public String ActionTitle() {return "START"; }

    public Activity Activity_() {
        if(instance_activity) {
            return activity;
        } else {
            activity = new Activity();
            instance_activity = true;
            return activity;
        }
    }

}
