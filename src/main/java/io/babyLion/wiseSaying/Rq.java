package io.babyLion.wiseSaying;

import java.util.HashMap;
import java.util.Map;

public class Rq {

    private String actionCode;
    private Map<String, String> parameters;

    public Rq(String command) {
        String[] commandBits = command.split("\\?", 2);
        this.actionCode = commandBits[0];
        this.parameters = new HashMap<>();

        if (commandBits.length == 1) {
            return;
        }

        String[] parameterBits = commandBits[1].split("&");

        for (String parameter : parameterBits) {
            String[] parameterBit = parameter.split("=", 2);
            if (parameterBit.length == 1) {
                continue;
            }

            String key = parameterBit[0];
            String value = parameterBit[1];
            parameters.put(key, value);
        }
    }

    public String getActionCode() {
        return actionCode;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public String getParameterValue(String key) {
        return parameters.get(key);
    }

    public int getParameterIntValue(String key, int defaultValue) {
        try {
            return Integer.parseInt(parameters.get(key));
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}
