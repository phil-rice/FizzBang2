package bbc.fixxbuzz

object FizzBuzzTypeClass {

  implicit object FizzBuzzLikeForInt extends FizzBuzzAble[Int] {
    override def isFizz(t: Int): Boolean = t % 3 == 0
    override def isBuzz(t: Int): Boolean = t % 5 == 0
  }
  implicit object FizzBuzzLikeForDouble extends FizzBuzzAble[Double] {
    override def isFizz(t: Double): Boolean = t % 3 == 0
    override def isBuzz(t: Double): Boolean = t % 5 == 0
  }

  implicit def toFizzBuzz[T:FizzAble:BuzzAble](t: T)= new FizzBankLikePimper(t)
}

class FizzBuzzTypeClassPimper[T:FizzAble:BuzzAble](t: T) {
  implicit val fizzAble = implicitly[FizzAble[T]]
  implicit val buzzAble= implicitly[BuzzAble[T]]

  def isFizz = fizzAble.isFizz(t)

  def isBuzz = buzzAble.isBuzz(t)

  def toFizzBuzz = t match {
    case _ if fizzAble.isFizz(t) && buzzAble.isBuzz(t) => "fizzbuzz"
    case _ if fizzAble.isFizz(t) => "fizz"
    case _ if buzzAble.isBuzz(t) => "buzz"
    case _ => t.toString
  }
}