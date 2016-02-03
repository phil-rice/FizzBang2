package bbc.fizzbang


object FizzBangLike {

  implicit object FizzBangLikeForInt extends FizzBangAble[Int] {
    override def isFizz(t: Int): Boolean = t % 3 == 0
    override def isBang(t: Int): Boolean = t % 5 == 0
  }
  implicit object FizzBangLikeForDouble extends FizzBangAble[Double] {
    override def isFizz(t: Double): Boolean = t % 3 == 0
    override def isBang(t: Double): Boolean = t % 5 == 0
  }

  implicit def toFizzBang[T](t: T)(implicit fizzAble: FizzAble[T], bangAble: BangAble[T]) = new FizzBankLikePimper(t)
}

class FizzBankLikePimper[T](t: T)(implicit fizzAble: FizzAble[T], bangAble: BangAble[T]) {
  def isFizz = fizzAble.isFizz(t)

  def isBang = bangAble.isBang(t)

  def toFizzBang = t match {
    case _ if fizzAble.isFizz(t) && bangAble.isBang(t) => "fizzbang"
    case _ if fizzAble.isFizz(t) => "fizz"
    case _ if bangAble.isBang(t) => "bang"
    case _ => t.toString
  }
}

trait FizzAble[T] {
  def isFizz(t: T): Boolean
}

trait BangAble[T] {
  def isBang(t: T): Boolean
}

trait FizzBangAble[T] extends FizzAble[T] with BangAble[T]

