import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.specification.Scope

class MyStackTest extends SpecificationWithJUnit {

  trait Context extends Scope {
    val stack = new MyStack(5)
  }

  "MyStack" should {

    "have size 0 in the beginning" in new Context {
      stack.size must_== 0
    }

    "increase size after pushing" in new Context {
      stack.push(1)
      stack.size must_== 1
    }

    "decrease size after popping" in new Context {
      stack.push(1)
      stack.pop()
      stack.size must_== 0
    }

    "throw exception when popping from empty stack" in new Context {
      stack.pop() must throwAn[UnderflowException]
    }

    "throw exception when pushing beyond capacity" in new Context {
      for(i <- 1 to stack.values.length) {
        stack.push(i)
      }

      stack.push(10) must throwAn[OverflowException]
    }

    "return the pushed item" in new Context {
      stack.push(1)
      stack.pop() must_== 1
    }

    "return the last pushed item" in new Context {
      stack.push(1)
      stack.push(2)
      stack.pop() must_== 2
    }

    "return the pushed items in reverse order" in new Context {
      stack.push(1)
      stack.push(2)

      stack.pop() must_== 2
      stack.pop() must_== 1
    }
  }

}
