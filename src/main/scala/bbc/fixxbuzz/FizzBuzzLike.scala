package bbc.fixxbuzz


object FizzBuzzLike {

  implicit object FizzBuzzLikeForInt extends FizzBuzzAble[Int] {
    override def isFizz(t: Int): Boolean = t % 3 == 0
    override def isBuzz(t: Int): Boolean = t % 5 == 0
  }
  implicit object FizzBuzzLikeForDouble extends FizzBuzzAble[Double] {
    override def isFizz(t: Double): Boolean = t % 3 == 0
    override def isBuzz(t: Double): Boolean = t % 5 == 0
  }

  implicit def toFizzBuzz[T](t: T)(implicit fizzAble: FizzAble[T], buzzAble: BuzzAble[T]) = new FizzBankLikePimper(t)
}

class FizzBankLikePimper[T](t: T)(implicit fizzAble: FizzAble[T], buzzAble: BuzzAble[T]) {
  def isFizz = fizzAble.isFizz(t)

  def isBuzz = buzzAble.isBuzz(t)

  def toFizzBuzz = t match {
    case _ if fizzAble.isFizz(t) && buzzAble.isBuzz(t) => "fizzbuzz"
    case _ if fizzAble.isFizz(t) => "fizz"
    case _ if buzzAble.isBuzz(t) => "buzz"
    case _ => t.toString
  }
}

trait FizzAble[T] {
  def isFizz(t: T): Boolean
}

trait BuzzAble[T] {
  def isBuzz(t: T): Boolean
}

trait FizzBuzzAble[T] extends FizzAble[T] with BuzzAble[T]

