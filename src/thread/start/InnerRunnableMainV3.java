package thread.start;

import static util.MyLogger.log;

public class InnerRunnableMainV3 {
    public static void main(String[] args) {
        log("main() start");

        Runnable runnable = () -> log("run()");

        Thread thread = new Thread(runnable);
        thread.start();

        log("main() end");
    }
}
