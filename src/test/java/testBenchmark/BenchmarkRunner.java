package testBenchmark;

import org.example.Matrix;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class BenchmarkRunner {
    public static void main(String[] args) throws RunnerException {

        int warmupIterations = 3;
        int measurementIterations = 5;
        int forks = 1;


        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-wi":
                    if (i + 1 < args.length) {
                        warmupIterations = Integer.parseInt(args[++i]);
                    }
                    break;
                case "-i":
                    if (i + 1 < args.length) {
                        measurementIterations = Integer.parseInt(args[++i]);
                    }
                    break;
                case "-f":
                    if (i + 1 < args.length) {
                        forks = Integer.parseInt(args[++i]);
                    }
                    break;
                default:
                    System.out.println("Parámetro desconocido: " + args[i]);
                    break;
            }
        }


        Options options = new OptionsBuilder()
                .include(Matrix.class.getSimpleName())
                .warmupIterations(warmupIterations)
                .measurementIterations(measurementIterations)
                .forks(forks)
                .build();


        new Runner(options).run();
    }
}
