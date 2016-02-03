package bbc.fizzbang

object FizzBangTypeClass {

  implicit object FizzBangLikeForInt extends FizzBangAble[Int] {
    override def isFizz(t: Int): Boolean = t % 3 == 0
    override def isBang(t: Int): Boolean = t % 5 == 0
  }
  implicit object FizzBangLikeForDouble extends FizzBangAble[Double] {
    override def isFizz(t: Double): Boolean = t % 3 == 0
    override def isBang(t: Double): Boolean = t % 5 == 0
  }

  implicit def toFizzBang[T:FizzAble:BangAble](t: T)= new FizzBankLikePimper(t)
}

class FizzBangTypeClassPimper[T:FizzAble:BangAble](t: T) {
  implicit val fizzAble = implicitly[FizzAble[T]]
  implicit val bangAble= implicitly[BangAble[T]]

  def isFizz = fizzAble.isFizz(t)

  def isBang = bangAble.isBang(t)

  def toFizzBang = t match {
    case _ if fizzAble.isFizz(t) && bangAble.isBang(t) => "fizzbang"
    case _ if fizzAble.isFizz(t) => "fizz"
    case _ if bangAble.isBang(t) => "bang"
    case _ => t.toString
  }
}