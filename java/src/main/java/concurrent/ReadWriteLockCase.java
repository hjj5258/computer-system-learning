package concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * @author hjj
 * @create 2021/07/01/21:15
 */
@Slf4j
/**
 * 读多写少，读操作可多个，写操作独占，写操作的时候禁止读操作
 */
public class ReadWriteLockCase {
    static Cache<String, Integer> cache = new Cache<>();
    public static void main(String[] args) {
//        case1();
        case2();
    }

    /**
     * 观察读写锁
     */
    static void case1(){
        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            int finalI = i;
            new Thread(() -> {
                while (true) {
                    int val = random.nextInt(100);
                    log.debug(Thread.currentThread().getName() + "写操作" + " key = t" + finalI + " val =" + val);
                    cache.put("t" + finalI, val);
                }
            }).start();

        }
        for (int i = 0; i < 10; i++) {
            int nextInt = random.nextInt(2);
            new Thread(() -> {
                while (true) {
                    Integer val = cache.get("t" + nextInt);
                    log.debug(Thread.currentThread().getName() + "读操作： key = t" + nextInt + " val = " + val);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    static void case2(){
        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            int finalI = i;
            new Thread(() -> {
                while (true) {
                    int val = random.nextInt(100);
                    log.debug(Thread.currentThread().getName() + "写操作" + " key = t" + finalI + " val =" + val);
                    cache.put("t" + finalI, val);
                }
            }).start();

        }

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    Integer val = cache.get("t" + 3);
                    log.debug(Thread.currentThread().getName() + "读操作： key = t" + 3 + " val = " + val);
                }
            }).start();
        }
    }
}
