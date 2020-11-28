package com.adam.stan;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StandardDeviationReducer extends Reducer<Text, Text, Text, Text>  {

    public void reduce(Text key, Iterable<Text> values,
                       Context context) throws IOException, InterruptedException {
        List<Double> lengths = new ArrayList<>();
        for (Text val : values) {
            lengths.add(Double.valueOf(val.toString()));
        }
        double std = Calculator.calculateSD(lengths);
        System.out.println(key);
        System.out.println(std);
        context.write(key, new Text(String.valueOf(std)));
    }
}
