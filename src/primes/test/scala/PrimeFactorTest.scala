package scala

import org.specs2.mutable.SpecificationWithJUnit

class PrimeFactorTest extends SpecificationWithJUnit {

  "Prime Factor" should {

    "one" in {
      Primes.For(1) must_== Seq()
    }

    "two" in {
      Primes.For(2) must_== Seq(2)
    }

    "three" in {
      Primes.For(3) must_== Seq(3)
    }

    "four" in {
      Primes.For(4) must_== Seq(2,2)
    }

    "five" in {
      Primes.For(5) must_== Seq(5)
    }

    "six" in {
      Primes.For(6) must_== Seq(2,3)
    }

    "seven" in {
      Primes.For(7) must_== Seq(7)
    }

    "8" in {
      Primes.For(8) must_== Seq(2,2,2)
    }

    "9" in {
      Primes.For(9) must_== Seq(3,3)
    }

    "10" in {
      Primes.For(10) must_== Seq(2,5)
    }

    "11" in {
      Primes.For(11) must_== Seq(11)
    }

    "max int value" in {
      Primes.For(Int.MaxValue) must_== Seq(Int.MaxValue)
    }

  }

}
