import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.CacheConfiguration;

import static org.apache.ignite.cache.CacheAtomicityMode.TRANSACTIONAL;

public class CacheTest {
    public static void main(String args[]){
        Ignite ignite = Ignition.start("src/example-ignite.xml");
        CacheConfiguration cfg = new CacheConfiguration();
        cfg.setName("myCache");
        cfg.setAtomicityMode(TRANSACTIONAL);
        // Create cache with given name, if it does not exist.
        IgniteCache<Integer, String> cache = ignite.getOrCreateCache(cfg);

        for (int i = 0; i < 10; i++)
            cache.put(i, Integer.toString(i));
        for (int i = 0; i < 10; i++)
            System.out.println("Got [key=" + i + ", val=" + cache.get(i) + ']');
    }
}
