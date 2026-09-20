# Java Multithreading Demo

A small Java 17 project demonstrating how two jobs execute concurrently on separate threads.

## Concepts demonstrated

- Creating a `Thread` with a `Runnable` lambda
- Starting concurrent work with `start()`
- Naming worker threads
- Waiting for completion with `join()`
- Pausing the current thread with `sleep()`
- Preserving the interruption flag
- Observing nondeterministic execution order

## Run

```bash
mvn compile
java -cp target/classes com.sangeetha.multithreading.SimpleMultithreadingDemo
```

You should see output from `device-worker-1` and `device-worker-2` interleaved. The exact order may differ on every run.

## Important distinction

Calling `start()` creates a new execution path. Calling `run()` directly executes the task synchronously on the calling thread.

## Next steps

1. Extract the task into a dedicated `Runnable`
2. Explore thread states and interruption
3. Demonstrate a race condition with shared data
4. Fix it with `synchronized` and atomic variables
5. Replace manual threads with `ExecutorService`
