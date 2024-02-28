/**
 * Create by hzh on 2020/4/10.
 */
fun IntArray.swap(i: Int, j: Int) {
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}

fun IntArray.print() {
    this.forEach { print("$it\t") }
    println()
    println()
}

fun CharArray.swap(i: Int, j: Int) {
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}

fun CharArray.print() {
    this.forEach { print("$it\t") }
    println()
}