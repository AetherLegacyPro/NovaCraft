package com.NovaCraft;

public final class HardmodeWorldCreationSettings {
    private static boolean pending;
    private static boolean selectedHardmode;

    private HardmodeWorldCreationSettings() {
    }

    public static synchronized void prepare(boolean enabled) {
        selectedHardmode = enabled;
        pending = true;
    }

    public static synchronized void clear() {
        pending = false;
        selectedHardmode = false;
    }

    public static synchronized Boolean consume() {
        if (!pending) {
            return null;
        }

        boolean enabled = selectedHardmode;
        pending = false;
        selectedHardmode = false;

        return Boolean.valueOf(enabled);
    }
}
