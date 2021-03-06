package twolevelсache;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class LFUAlgorithmTest {
    private TwoLevelCache twoLevelCache = new TwoLevelCacheImpl(1, 1, "LFU");

    @Test
    public void getWeakestKey() {
        twoLevelCache.cacheObject("1", new MyClass1(new MyClass2(1), 2));
        twoLevelCache.cacheObject("2", new MyClass1(new MyClass2(1), 2));
        twoLevelCache.getObject("2");
        twoLevelCache.getObject("2");
        twoLevelCache.getObject("2");
        twoLevelCache.getObject("2");
        assertNotNull(twoLevelCache.getObject("1"));
        twoLevelCache.cacheObject("3", new MyClass1(new MyClass2(1), 2));
        assertNull(twoLevelCache.getObject("1"));
    }
}