package com.adam.stan;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class HandInfoBuilder {

    public HandInfo createHandInfo(JsonElement element) {
        HandInfo info = new HandInfo();
        JsonObject object = element.getAsJsonObject();
        info.series = element.getAsJsonObject().get("series").getAsInt();
        info.sample = element.getAsJsonObject().get("sample").getAsInt();
        info.side = element.getAsJsonObject().get("side").getAsString();

        JsonObject arrayWithFingers = object.getAsJsonObject("features2D");

        info.fingers.put("fifth", arrayWithFingers.getAsJsonPrimitive("fifth").getAsString());
        info.fingers.put("fourth", arrayWithFingers.getAsJsonPrimitive("fourth").getAsString());
        info.fingers.put("third", arrayWithFingers.getAsJsonPrimitive("third").getAsString());
        info.fingers.put("second", arrayWithFingers.getAsJsonPrimitive("second").getAsString());
        info.fingers.put("first", arrayWithFingers.getAsJsonPrimitive("first").getAsString());

        return info;
    }
}
