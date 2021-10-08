package ChemistryCalculator.backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Converter {
    private static final HashMap<String, HashMap<String, Double>> FACTOR_MAP
            = new HashMap<>();


    //registering Factor
    static {
        registerFactor("molars", "decimolars", 10);
        registerFactor("molars", "centimolars", 100);
        registerFactor("molars", "millimolars", 1000);
        registerFactor("molars", "micromolars", 1000000);
        registerFactor("molars", "nanomolars", 1000000000);

        registerFactor("liters", "deciliters", 10);
        registerFactor("liters", "centiliters", 100);
        registerFactor("liters", "milliliters", 1000);

        registerFactor("liters", "cubic_decimeters", 1);
        registerFactor("liters", "cubic_millimeters", 1000000);
        registerFactor("liters", "cubic_centimeters", 1000);

        registerFactor("kilogram", "gram", 1000);
        registerFactor("kilogram", "milligram", 1000000);
        registerFactor("kilogram", "pound", 2.205);
    }

    public static double convert(String from, String to, double value) {
        ArrayList<Step> stack = new ArrayList<>();
        HashSet<String> removedItem = new HashSet<>();
        stack.add(new Step(from, value));
        while (!stack.isEmpty()) {
            Step step = stack.remove(0);
            double stepValue = step.value;
            String stepUnit = step.unit;
            removedItem.add(stepUnit);
            if (stepUnit.equals(to)) {
                return stepValue;
            }
            HashMap<String, Double> map = FACTOR_MAP.get(stepUnit);
            if (map != null) {
                map.entrySet().stream().filter(entry -> !removedItem.contains(entry.getKey()))
                        .map(entry -> new Step(entry.getKey(), stepValue * entry.getValue()))
                        .forEach(stack::add);
            }


        }
        //if factors are not registered
        throw new IllegalArgumentException("Cannot not convert from " + from
                + " to " + to);
    }

    public static void registerFactor(String from, String to, double factor) {
        putFactor(from, to, factor);
        putFactor(to, from, 1.0 / factor);
    }

    private static void putFactor(String from, String to, double factor) {
        HashMap<String, Double> map = FACTOR_MAP.computeIfAbsent(from, k -> new HashMap<>());
        map.put(to, factor);
    }

    private static class Step {
        private final String unit;
        private final double value;

        Step(String unit, double value) {
            this.unit = unit;
            this.value = value;
        }
    }

}