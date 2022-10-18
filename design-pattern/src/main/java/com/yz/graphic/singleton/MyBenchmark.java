package com.yz.graphic.singleton;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author hjj
 * @create 2022/10/17/22:27
 */
@Warmup(iterations = 0, time = 3, timeUnit = TimeUnit.SECONDS) // 预热
@Measurement(iterations = 3, time = 3, timeUnit = TimeUnit.SECONDS)// 真正测试
@Fork(3) // JVM进程数
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
//@State(Scope.Thread)
public class MyBenchmark {
    @Benchmark
    public void testHungrySingleton() {
        HungrySingleton instance = HungrySingleton.getInstance();
    }

    @Benchmark
    public void testLazyDCLSingleton() {
        LazySingleton instance = LazyDCLSingleton.getInstance();
    }

    @Benchmark
    public void testLazyHolderSingleton() {
        LazyHolderSingleton instance = LazyHolderSingleton.getInstance();
    }

    @Benchmark
    public void testLazySingleton() {
        LazySingleton instance = LazySingleton.getInstance();
    }

    @Benchmark
    public void testEnumSingleton() {
        EnumSingleton instance = EnumSingleton.INSTANCE;
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(MyBenchmark.class.getSimpleName())
                .threads(8)
                .build();
        new Runner(opt).run();
    }
}
