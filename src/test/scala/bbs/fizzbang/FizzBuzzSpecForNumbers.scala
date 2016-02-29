package bbc.fixxbuzz

import org.scalatest.{FlatSpec, Matchers}

class FizzBuzzSpecForNumbers extends FlatSpec with Matchers {
  //  import FizzBuzzLike._

  import FizzBuzzTypeClass._

  "A number divisable by three" should "return true to isFizz" in {
    1.isFizz shouldBe false
    3.isFizz shouldBe true
    4.isFizz shouldBe false
    5.isFizz shouldBe false
    6.isFizz shouldBe true
    15.isFizz shouldBe true
  }
  "A number divisable by five" should "return true to isBuzz" in {
    1.isBuzz shouldBe false
    3.isBuzz shouldBe false
    4.isBuzz shouldBe false
    5.isBuzz shouldBe true
    15.isBuzz shouldBe true
  }

  "The toFizzBuzz" should "map to 'fizz' if divisible by 3, 'buzz' if divisible by 5, 'fizzbuzz' if both, or the string of the number if none" in {
    1.toFizzBuzz shouldBe "1"
    2.toFizzBuzz shouldBe "2"
    3.toFizzBuzz shouldBe "fizz"
    4.toFizzBuzz shouldBe "4"
    5.toFizzBuzz shouldBe "buzz"
    6.toFizzBuzz shouldBe "fizz"
    10.toFizzBuzz shouldBe "buzz"
    15.toFizzBuzz shouldBe "fizzbuzz"
    29.toFizzBuzz shouldBe "29"
    30.toFizzBuzz shouldBe "fizzbuzz"
    31.toFizzBuzz shouldBe "31"
  }

  "The toFizzBuzz" should "rules should work on floats" in {
    1.0.toFizzBuzz shouldBe "1.0"
    2.0.toFizzBuzz shouldBe "2.0"
    3.0.toFizzBuzz shouldBe "fizz"
    4.0.toFizzBuzz shouldBe "4.0"
    5.0.toFizzBuzz shouldBe "buzz"
    6.0.toFizzBuzz shouldBe "fizz"
    10.0.toFizzBuzz shouldBe "buzz"
    15.0.toFizzBuzz shouldBe "fizzbuzz"
    29.0.toFizzBuzz shouldBe "29.0"
    30.0.toFizzBuzz shouldBe "fizzbuzz"
    31.0.toFizzBuzz shouldBe "31.0"
  }

  "The toFizzBuzz" should "rules should work on complexNumbers" in {
    implicit object FizzBuzzableForComplex extends FizzBuzzAble[ComplexNumber] {
       def isFizz(t: ComplexNumber): Boolean = t.realPart % 3 == 0.0 && t.imaginaryPart ==0.0
       def isBuzz(t: ComplexNumber): Boolean = t.realPart % 5 == 0.0 && t.imaginaryPart == 0.0

    }
    ComplexNumber(1.0, 0).toFizzBuzz shouldBe "ComplexNumber(1.0,0.0)"
    ComplexNumber(2.0, 0).toFizzBuzz shouldBe "ComplexNumber(2.0,0.0)"
    ComplexNumber(3.0, 0).toFizzBuzz shouldBe "fizz"
    ComplexNumber(4.0, 0).toFizzBuzz shouldBe "ComplexNumber(4.0,0.0)"
    ComplexNumber(5.0, 0).toFizzBuzz shouldBe "buzz"
    ComplexNumber(6.0, 0).toFizzBuzz shouldBe "fizz"
    ComplexNumber(10.0, 0).toFizzBuzz shouldBe "buzz"
    ComplexNumber(15.0, 0).toFizzBuzz shouldBe "fizzbuzz"
    ComplexNumber(29.0, 0).toFizzBuzz shouldBe "ComplexNumber(29.0,0.0)"
    ComplexNumber(30.0, 0).toFizzBuzz shouldBe "fizzbuzz"
    ComplexNumber(31.0, 0).toFizzBuzz shouldBe "ComplexNumber(31.0,0.0)"
  }

}

