package bbc.fizzbang

object FizzBang {
  implicit def fizzBangFromInt(i: Int) = new FizzBang(i)
}

class FizzBang(i: Int){
  import FizzBang._
  def isFizz: Boolean = i % 3 == 0
  def isBang: Boolean = i % 5 == 0
  def toFizzBang = i match {
    case _ if i.isFizz && i.isBang => "fizzbang"
    case _ if i.isFizz => "fizz"
    case _ if i.isBang => "bang"
    case _  => i.toString
  }
}
