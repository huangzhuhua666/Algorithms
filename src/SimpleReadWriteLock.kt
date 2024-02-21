import kotlin.concurrent.thread

/**
 * Create by hzh on 2024/2/17.
 * ¶ÁÐ´Ëø¼òµ¥ÊµÏÖ
 */
class SimpleReadWriteLock {

    @Volatile
    private var mReadCount = 0

    @Volatile
    private var mIsWriting = false
    private val mLock = Object()

    fun lockRead() {
        synchronized(mLock) {
            while (mIsWriting) {
                println("${Thread.currentThread().name} -> waiting for read!")
                mLock.wait()
            }

            ++mReadCount
        }
    }

    fun unlockRead() {
        synchronized(mLock) {
            --mReadCount
            if (mReadCount == 0) {
                println("no reader")
                mLock.notifyAll()
            }
        }
    }

    fun lockWrite() {
        synchronized(mLock) {
            while (mReadCount > 0 || mIsWriting) {
                println("${Thread.currentThread().name} -> waiting for write!(readCount = $mReadCount, isWriting = $mIsWriting)")
                mLock.wait()
            }

            mIsWriting = true
        }
    }

    fun unlockWrite() {
        synchronized(mLock) {
            println("end write")
            mIsWriting = false
            mLock.notifyAll()
        }
    }
}

fun main() {
    val lock = SimpleReadWriteLock()
    val block = {
        repeat(10) {
            if (Math.random() < 0.5) {
                // write
                lock.lockWrite()
                println("${Thread.currentThread().name} -> is writing!")
                lock.unlockWrite()
            } else {
                // read
                lock.lockRead()
                println("${Thread.currentThread().name} -> is reading!")
                lock.unlockRead()
            }
        }
    }
    thread(start = true, name = "Thread(1)", block = block)
    thread(start = true, name = "Thread(2)", block = block)
    thread(start = true, name = "Thread(3)", block = block)
}