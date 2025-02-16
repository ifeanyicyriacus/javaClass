package enums;

public class NigeriaStateGeoPoliticalZonesFunctions {
    public static NigeriaStateGeoPoliticalZones getGeoPoliticalZoneByState(String stateName) {
        for (NigeriaStateGeoPoliticalZones states : NigeriaStateGeoPoliticalZones.values()) {
            for (String state : states.getStates()) {
                if (state.equalsIgnoreCase(stateName)) {
                    return states;
                }
            }
        }
        throw new IllegalArgumentException("'" + stateName + "' is not a valid state name");
    }
}
