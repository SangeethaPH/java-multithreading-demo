# Java Multithreading Demo

A progressive Java 17 project for learning multithreading, from manually created threads to managed thread pools.

## Example 1: Creating threads manually

`SimpleMultithreadingDemo` demonstrates:

- Creating a `Thread` with a `Runnable` lambda
- Starting concurrent work with `start()`
- Naming worker threads
- Waiting for completion with `join()`
- Pausing the current thread with `sleep()`
- Preserving the interruption flag
- Observing nondeterministic execution order

Run it with:

```bash
mvn compile
java -cp target/classes com.sangeetha.multithreading.SimpleMultithreadingDemo
```

Calling `start()` creates a new execution path. Calling `run()` directly executes the task synchronously on the calling thread.

## Example 2: Fixed thread pool

`ThreadPoolDemo` submits six device jobs to a pool containing only three worker threads.

Run it with:

```bash
mvn compile
java -cp target/classes com.sangeetha.multithreading.ThreadPoolDemo
```

Observe that:

- Only three jobs run at the same time.
- The remaining jobs wait in the executor's queue.
- A worker thread processes another job after finishing its current job.
- Threads are reused instead of creating one thread for every job.
- `shutdown()` rejects new work but lets submitted work finish.
- `awaitTermination()` makes the main thread wait for graceful completion.
- `shutdownNow()` is the timeout fallback and interrupts active workers.

## Manual threads versus a thread pool

| Manual threads | Thread pool |
|---|---|
| One thread is explicitly created per task | Tasks are submitted to an executor |
| Application manages each thread | Executor manages worker lifecycle |
| Too many tasks can create too many threads | Pool size limits concurrency |
| Suitable for learning and rare dedicated workers | Preferred for server-side task processing |

## Next steps

1. Return values using `Callable` and `Future`
2. Demonstrate a race condition with shared data
3. Fix the race using `synchronized` and `AtomicInteger`
4. Explore bounded queues and rejection policies
5. Build the complete device-job executor
