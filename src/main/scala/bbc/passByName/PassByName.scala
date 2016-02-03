package bbc.passByName


class PassByFn {

  def logErrors[X](block:  () => X) = try {
    block()
  } catch {
    case e: Exception => e.printStackTrace(); throw e
  }

  def myIf(cond: () => Boolean, ifTrue: () => Unit, ifFalse: () => Unit) = if (cond()) ifTrue() else ifFalse()

  def example(args: Array[String]) {
   logErrors(() =>1 / 0)
    myIf(() => true, () => println("was true"), () => println("was false"))
  }

}

class PassByName {

  def logErrors[X](block: => X) = try {
    block
  } catch {
    case e: Exception => e.printStackTrace(); throw e
  }
  def myIf(cond: => Boolean, ifTrue: => Unit, ifFalse: => Unit) = if (cond) ifTrue else ifFalse

  def example(args: Array[String]) {
   logErrors(1 / 0)
    myIf(true,  println("was true"),  println("was false"))
  }

}