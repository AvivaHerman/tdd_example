package scala

import org.specs2.mutable.{After, SpecificationWithJUnit}
import org.specs2.specification.Scope

class MyClassTest extends SpecificationWithJUnit {

  trait Context extends Scope {
    val myClass = new MyClass()
  }

  trait ContextWithHelloMessage extends Context {
    val helloMessage = myClass.hello
  }

  trait ContextWithCleanup extends After {
    val userID = 42
    val userEmail = "someone@example.com"

    override def after: Any = {

    }
  }

  trait RichContext extends Scope {
    val address = "HaNamal 40, Tel-Aviv"

    def explode(): Unit = throw new Exception
  }

  "My awesome class" should {

    "do something in" in {
      success
    }

    "do something else" in {
      pending
    }

    "be awesome" in {
      val myClass = new MyClass()
      myClass.isAwesome must beTrue
    }

  }

  "Test with context" should {
    "be awesome again" in new Context {
      myClass.isAwesome must beTrue
    }

    "have hello message" in new ContextWithHelloMessage {
      helloMessage must_== "hello"
    }

  }

  "matchers" should {
    "string check" in new RichContext {
      address must contain("Aviv")
    }

    "not cintain string" in new RichContext {
      address must not(contain("Aviva"))
    }

    "have some size" in new RichContext {
      address must haveSize(20)
    }

    "throw an exception" in new RichContext {
      explode() must throwAn[Exception]
    }
  }

}
