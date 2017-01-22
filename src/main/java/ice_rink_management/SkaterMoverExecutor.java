package ice_rink_management;

import java.util.concurrent.*;

/**
 * Created by Maciek on 2017-01-21.
 */
public class SkaterMoverExecutor {

    //private static ExecutorService skaterExecutorService = Executors.newFixedThreadPool(15);
    private static int corePoolSize = 15;
    private static int maxPoolSize = 15;
    private static long keepAliveTime = 15 * 1000;

    private static ExecutorService skaterExecutorService =
            new ThreadPoolExecutor(
                    corePoolSize,
                    maxPoolSize,
                    keepAliveTime,
                    TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<Runnable>()
            );

    public static void submitSkater(Runnable newSkaterRunnable){
        skaterExecutorService.submit(newSkaterRunnable);
    }

}
