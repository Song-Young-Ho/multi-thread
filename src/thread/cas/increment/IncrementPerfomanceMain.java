package thread.cas.increment;

public class IncrementPerfomanceMain {
    public static final long COUNT = 100_000_000_0;

    public static void main(String[] args) {
        test(new BasicInteger());
        test(new VolatileInteger());
        test(new SyncInteger());
        test(new MyAtomicInteger());
    }

    private static void test(IncrementInteger increment) {
        long startMs = System.currentTimeMillis();

        for (long i = 0; i < COUNT; i++) {
            increment.increment();
        }

        long endMs = System.currentTimeMillis();
        System.out.println(increment.getClass().getSimpleName() + ": ms=" + (endMs - startMs));
    }
}
