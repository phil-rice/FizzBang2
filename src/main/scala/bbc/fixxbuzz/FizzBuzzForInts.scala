package bbc.fixxbuzz

object FizzBuzz {
  implicit def fizzBuzzFromInt(i: Int) = new FizzBuzz(i)
}

class FizzBuzz(i: Int){
  import FizzBuzz._
  def isFizz: Boolean = i % 3 == 0
  def isBuzz: Boolean = i % 5 == 0
  def toFizzBuzz = i match {
    case _ if i.isFizz && i.isBuzz => "fizzbuzz"
    case _ if i.isFizz => "fizz"
    case _ if i.isBuzz => "buzz"
    case _  => i.toString
  }
}
