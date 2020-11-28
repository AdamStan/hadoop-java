package com.adam.stan;

import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.Map;


public class TokenizerMapper extends Mapper<Object, Text, Text, Text>  {
    private final static HandInfoBuilder builder = new HandInfoBuilder();
    private final static JsonParser parser = new JsonParser();

    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        try {
            HandInfo handInfo = builder.createHandInfo(parser.parse(value.toString()));

            for (Map.Entry<String, String> finger : handInfo.fingers.entrySet()) {
                HandKey newKey = new HandKey(handInfo.side, handInfo.series, finger.getKey());
                context.write(new Text(newKey.toString()), new Text(finger.getValue()));
            }
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }

    }
}
