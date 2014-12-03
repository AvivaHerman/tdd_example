import java.util.concurrent.atomic.AtomicInteger

class MyStack(capacity: Int) {
  val size = new AtomicInteger(0)
  val values = new Array[Int](capacity)

  def push(i: Int): Unit = {
    if (stackIsFull) throw new OverflowException()
    values.update(size.getAndIncrement, i)
  }

  def pop(): Int = {
    if (stackIsEmpty) throw new UnderflowException()
    values.apply(size.decrementAndGet)
  }

  private def stackIsEmpty: Boolean = size.get == 0

  private def stackIsFull: Boolean = size.get == capacity

}
