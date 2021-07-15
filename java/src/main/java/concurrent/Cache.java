package concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author hjj
 * @create 2021/07/01/21:52
 */
@Slf4j
public class Cache<K, V extends Number> {
    final Map<K, V> data = new HashMap<K, V>();
    final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    // case3
    volatile boolean cacheValid;
    final Lock rLock = readWriteLock.readLock();
    final Lock wLock = readWriteLock.writeLock();

    /**
     * case2 案例
     *
     * @param key
     * @return
     */
    V get(K key) {
        V val = null;
        log.debug("=============获取读锁===========");
        rLock.lock();
        try {
            val = data.get(key);
        } finally {
            rLock.unlock();
        }

        // 缓存命中
        if (val != null) {
            return val;
        }

        // 如果缓存未命中
        // ①注释是模拟多个线程进入后，多次读取数据库的情况，case2 案例
        //①
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //①
        // ReadWriteLock 写锁之前，必须释放读锁。不然就会照成锁的升级，导致写锁永久等待，最终导致相关线程都被阻塞，永远也没有机会被唤醒。
        // ReentrantReadWriteLock 允许锁的降级，写锁降级为读锁
        wLock.lock();
        try {
            log.debug(Thread.currentThread().getName() + " =============未命中缓存========== " + key + " val =" + val);
            // ②再次验证，有可能其他线程已经查询过数据库了,避免查询多次数据库
            val = data.get(key);
            if (val == null) {
                // 模拟从数据库读取值
                Random random = new Random();
                Number dbVal = random.nextInt(100);
                log.debug("=============从数据库中读取值key = " + key + " val =" + dbVal);
                data.put(key, (V) dbVal);
                val = (V) dbVal;
            }
            // ②


            // ①模拟从数据库读取值
//            Random random = new Random();
//            Number dbVal = random.nextInt(100);
//            log.debug("=============从数据库中读取值key = " + key + " val =" + dbVal);
//            data.put(key, (V) dbVal);
//            val = (V) dbVal;
            // ①
        } finally {
            wLock.unlock();
        }
        return val;
    }

    V put(K key, V val) {
        wLock.lock();
        try {
            return data.put(key, val);
        } finally {
            try {
                log.debug("=============控制写锁3s后释放===========");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            wLock.unlock();
        }
    }
}
