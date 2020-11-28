import com.adam.stan.StandardDeviationReducer;
import com.adam.stan.TokenizerMapper;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * Run jar with command:
 * java -jar hd-jar-name input_path output_path
 *
 * output_path - last directory don't exist!
 *
 * java -jar Hadoop-Example-1.0-SNAPSHOT-jar-with-dependencies.jar /home/adam/input /home/adam/output
 */
public class FingersCounter {

    public static void main(String[] args) throws Exception {
        // "/home/adam/input"
        String input = args[0];
        // "/home/adam/output"
        String output = args[1];
        Configuration conf = new Configuration();

//        conf.set("fs.hdfs.impl",
//                org.apache.hadoop.hdfs.DistributedFileSystem.class.getName()
//        );
//        conf.set("fs.file.impl",
//                org.apache.hadoop.fs.LocalFileSystem.class.getName()
//        );

        Job job = Job.getInstance(conf, "count fingers std");
        job.setJarByClass(FingersCounter.class);
        job.setMapperClass(TokenizerMapper.class);
        job.setReducerClass(StandardDeviationReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        FileInputFormat.addInputPath(job, new Path(input));
        FileOutputFormat.setOutputPath(job, new Path(output));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
