package com.NovaCraft;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

final class CoremodConfig {
    private static final String CONFIG_DIRECTORY = "config/NovaCraft";
    private static final String CONFIG_FILE_NAME = "NovaCraft_Base.cfg";

    private static final boolean DEFAULT_ENABLE_BOOKSHELF_POWER_TRANSFORMER = true;
    private static final int DEFAULT_BOOKSHELF_POWER_DIVISOR = 2;
    private static final boolean DEFAULT_ENABLE_SPIDER_SPEED_TRANSFORMER = true;
    private static final double DEFAULT_SPIDER_MOVEMENT_SPEED_MULTIPLIER = 2.0D;

    static boolean enableBookshelfPowerTransformer = DEFAULT_ENABLE_BOOKSHELF_POWER_TRANSFORMER;
    static int bookshelfPowerDivisor = DEFAULT_BOOKSHELF_POWER_DIVISOR;
    static boolean enableSpiderSpeedTransformer = DEFAULT_ENABLE_SPIDER_SPEED_TRANSFORMER;
    static double spiderMovementSpeedMultiplier = DEFAULT_SPIDER_MOVEMENT_SPEED_MULTIPLIER;

    private static boolean loaded;

    private CoremodConfig() {
    }

    static synchronized void ensureLoaded() {
        if (!loaded) {
            load();
        }
    }

    private static void load() {
        enableBookshelfPowerTransformer = DEFAULT_ENABLE_BOOKSHELF_POWER_TRANSFORMER;
        bookshelfPowerDivisor = DEFAULT_BOOKSHELF_POWER_DIVISOR;
        enableSpiderSpeedTransformer = DEFAULT_ENABLE_SPIDER_SPEED_TRANSFORMER;
        spiderMovementSpeedMultiplier = DEFAULT_SPIDER_MOVEMENT_SPEED_MULTIPLIER;

        File configFile = new File(CONFIG_DIRECTORY, CONFIG_FILE_NAME);
        if (!configFile.exists()) {
            loaded = true;
            return;
        }

        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(configFile));
            String line;

            while ((line = reader.readLine()) != null) {
                parseLine(line.trim());
            }
        } catch (IOException e) {
            log("Failed to load ASM config from NovaCraft_Base.cfg, using defaults. " + e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ignored) {
                }
            }
        }

        loaded = true;
    }

    private static void parseLine(String line) {
        if (line.length() < 4 || line.startsWith("#")) {
            return;
        }

        if (line.charAt(1) != ':') {
            return;
        }

        int equalsIndex = line.indexOf('=');
        if (equalsIndex <= 2) {
            return;
        }

        String key = line.substring(2, equalsIndex).trim();
        String rawValue = line.substring(equalsIndex + 1).trim();

        if ("enableBookshelfPowerTransformer".equals(key)) {
            enableBookshelfPowerTransformer = parseBoolean(key, rawValue, DEFAULT_ENABLE_BOOKSHELF_POWER_TRANSFORMER);
        } else if ("bookshelfPowerDivisor".equals(key)) {
            bookshelfPowerDivisor = parseInt(key, rawValue, DEFAULT_BOOKSHELF_POWER_DIVISOR, 1);
        } else if ("enableSpiderSpeedTransformer".equals(key)) {
            enableSpiderSpeedTransformer = parseBoolean(key, rawValue, DEFAULT_ENABLE_SPIDER_SPEED_TRANSFORMER);
        } else if ("spiderMovementSpeedMultiplier".equals(key)) {
            spiderMovementSpeedMultiplier = parseDouble(key, rawValue, DEFAULT_SPIDER_MOVEMENT_SPEED_MULTIPLIER, 0.0D);
        }
    }

    private static boolean parseBoolean(String key, String rawValue, boolean defaultValue) {
        if ("true".equalsIgnoreCase(rawValue) || "false".equalsIgnoreCase(rawValue)) {
            return Boolean.parseBoolean(rawValue);
        }

        log("Invalid boolean for " + key + ": " + rawValue + ". Using default " + defaultValue + ".");
        return defaultValue;
    }

    private static int parseInt(String key, String rawValue, int defaultValue, int minValue) {
        try {
            int value = Integer.parseInt(rawValue.trim());

            if (value < minValue) {
                log("Value for " + key + " must be at least " + minValue + ". Using default " + defaultValue + ".");
                return defaultValue;
            }

            return value;
        } catch (NumberFormatException e) {
            log("Invalid integer for " + key + ": " + rawValue + ". Using default " + defaultValue + ".");
            return defaultValue;
        }
    }

    private static double parseDouble(String key, String rawValue, double defaultValue, double minValue) {
        try {
            double value = Double.parseDouble(rawValue.trim());

            if (Double.isNaN(value) || Double.isInfinite(value) || value < minValue) {
                log("Value for " + key + " must be a finite number greater than or equal to " + minValue + ". Using default " + defaultValue + ".");
                return defaultValue;
            }

            return value;
        } catch (NumberFormatException e) {
            log("Invalid decimal for " + key + ": " + rawValue + ". Using default " + defaultValue + ".");
            return defaultValue;
        }
    }

    private static void log(String message) {
        System.out.println("[NovaCraft][ASM Config] " + message);
    }
}
