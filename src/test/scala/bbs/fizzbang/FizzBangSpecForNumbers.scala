package bbc.fizzbang

import org.scalatest.{FlatSpec, Matchers}

class FizzBangSpecForNumbers extends FlatSpec with Matchers {
  //  import FizzBangLike._

  import FizzBangTypeClass._

  "A number divisable by three" should "return true to isFizz" in {
    1.isFizz shouldBe false
    3.isFizz shouldBe true
    4.isFizz shouldBe false
    5.isFizz shouldBe false
    6.isFizz shouldBe true
    15.isFizz shouldBe true
  }
  "A number divisable by five" should "return true to isBang" in {
    1.isBang shouldBe false
    3.isBang shouldBe false
    4.isBang shouldBe false
    5.isBang shouldBe true
    15.isBang shouldBe true
  }

  "The toFizzBang" should "map to 'fizz' if divisible by 3, 'bang' if divisible by 5, 'fizzbang' if both, or the string of the number if none" in {
    1.toFizzBang shouldBe "1"
    2.toFizzBang shouldBe "2"
    3.toFizzBang shouldBe "fizz"
    4.toFizzBang shouldBe "4"
    5.toFizzBang shouldBe "bang"
    6.toFizzBang shouldBe "fizz"
    10.toFizzBang shouldBe "bang"
    15.toFizzBang shouldBe "fizzbang"
    29.toFizzBang shouldBe "29"
    30.toFizzBang shouldBe "fizzbang"
    31.toFizzBang shouldBe "31"
  }

  "The toFizzBang" should "rules should work on floats" in {
    1.0.toFizzBang shouldBe "1.0"
    2.0.toFizzBang shouldBe "2.0"
    3.0.toFizzBang shouldBe "fizz"
    4.0.toFizzBang shouldBe "4.0"
    5.0.toFizzBang shouldBe "bang"
    6.0.toFizzBang shouldBe "fizz"
    10.0.toFizzBang shouldBe "bang"
    15.0.toFizzBang shouldBe "fizzbang"
    29.0.toFizzBang shouldBe "29.0"
    30.0.toFizzBang shouldBe "fizzbang"
    31.0.toFizzBang shouldBe "31.0"
  }

  "The toFizzBang" should "rules should work on complexNumbers" in {
    implicit object FizzBangableForComplex extends FizzBangAble[ComplexNumber] {
       def isFizz(t: ComplexNumber): Boolean = t.realPart % 3 == 0.0 && t.imaginaryPart ==0.0
       def isBang(t: ComplexNumber): Boolean = t.realPart % 5 == 0.0 && t.imaginaryPart == 0.0

    }
    ComplexNumber(1.0, 0).toFizzBang shouldBe "ComplexNumber(1.0,0.0)"
    ComplexNumber(2.0, 0).toFizzBang shouldBe "ComplexNumber(2.0,0.0)"
    ComplexNumber(3.0, 0).toFizzBang shouldBe "fizz"
    ComplexNumber(4.0, 0).toFizzBang shouldBe "ComplexNumber(4.0,0.0)"
    ComplexNumber(5.0, 0).toFizzBang shouldBe "bang"
    ComplexNumber(6.0, 0).toFizzBang shouldBe "fizz"
    ComplexNumber(10.0, 0).toFizzBang shouldBe "bang"
    ComplexNumber(15.0, 0).toFizzBang shouldBe "fizzbang"
    ComplexNumber(29.0, 0).toFizzBang shouldBe "ComplexNumber(29.0,0.0)"
    ComplexNumber(30.0, 0).toFizzBang shouldBe "fizzbang"
    ComplexNumber(31.0, 0).toFizzBang shouldBe "ComplexNumber(31.0,0.0)"
  }

}

