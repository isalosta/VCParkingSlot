package com.example.vcparkingslot;

public class Pool {
    public static Pool Instance = null;
    public String Data;

    public Pool() {
        if(Instance == null)
            Instance = this;
    }
}
