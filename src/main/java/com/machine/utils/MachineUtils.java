package com.machine.utils;

public class MachineUtils {

    public static boolean isNullOrEmpty(String str)
    {
        if(str != null && !str.trim().isEmpty())
            return false;
        return true;
    }

}
