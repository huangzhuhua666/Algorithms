import java.util.concurrent.locks.ReentrantLock

/**
 * Create by hzh on 2021/03/21.
 */
@Volatile
var i = 0
val lock = ReentrantLock(true)

fun main() {
    val runnable = PrintRunnable()
    Thread(runnable, "thread 1").start()
    Thread(runnable, "thread 2").start()
}

class PrintRunnable : Runnable {

    override fun run() {
        while (i < 30) {
            lock.lock()
            println("${Thread.currentThread().name} -> ${i++}")
            lock.unlock()
        }
    }
}