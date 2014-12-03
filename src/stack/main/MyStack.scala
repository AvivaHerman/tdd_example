class MyStack(capacity: Int) {

  var size = 0
  val values = new Array[Int](capacity)

  def push(i: Int): Unit = {
    if (stackIsFull) throw new OverflowException()
    values.update(size, i)
    size = size + 1
  }

  def pop(): Int = {
    if (stackIsEmpty) throw new UnderflowException()
    size = size - 1
    values.apply(size)
  }

  private def stackIsEmpty: Boolean = size == 0

  private def stackIsFull: Boolean = size == capacity

}
