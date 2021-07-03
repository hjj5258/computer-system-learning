package concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.StampedLock;

/**
 * StampedLock（邮票锁） 支持写锁、乐观读（无锁 CAS实现）、悲观读锁
 * 不支持重入，悲观读锁、写锁都不支持条件变量，一定不要调用中断操作
 * 一定使用可中断的 悲观读锁 readLockInterruptibly() 和写锁 writeLockInterruptibly()
 *
 * @author hjj
 * @create 2021/07/03/13:17
 */
@Slf4j
public class StampedLockCase {
    private static int x, y;
    static StampedLock s1 = new StampedLock();
    static Thread thread = new Thread(() -> {
        x = 1;
        y = 2;
        log.debug("======== set x {},y {} ==========", x, y);
    });


    /**
     * 计算到原点距离
     *
     * @return
     */
    static double distanceFromOrigin() {
        // 乐观读
        long stamp = s1.tryOptimisticRead();
        // 读入局部变量，在读的时候有可能被修改
        int curX = x, curY = y;

        // 修改数据
        try {
            thread.start();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.debug("curX {} curY {}", curX, curY);
        // 判断执行读操作期间，是否存在写操作，false为写锁存在，true则不是
        if (!s1.validate(stamp)) {
            // 升级悲观读锁
            stamp = s1.readLock();
            try {
                curX = x;
                curY = y;
            } finally {
                // 释放悲观读
                s1.unlockRead(stamp);
            }
        }

        return Math.sqrt(curX * curX + curY * curY);
    }

    public static void main(String[] args) {
        log.debug("=========== result ============  " + distanceFromOrigin());
    }

    /**
     * 使用模板
     */
    void template() {
        final StampedLock s1 = new StampedLock();
        long stamp = s1.tryOptimisticRead();
        // 读入方法局部变量.....

        // 校验 stamp
        if (!s1.validate(stamp)) {
            // 升级悲观读锁
            stamp = s1.readLock();
            try {
                // 读入方法局部变量...
            } finally {
                // 释放悲观读
                s1.unlockRead(stamp);
            }
        }

        // 使用方法局部变量执行业务操作

    }
}
