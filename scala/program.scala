import scala.actors._
import scala.actors.Actor._


case class Message(nom:String, nb : Int = 0)
case object Pong

String mavaleur = if(i===4) {
  "4"
} else {
  "Inconnu"
}

object Program extends App {
  def time[A](f: => A) = {
    val s = System.nanoTime
    val ret = f
    println("time: "+(System.nanoTime-s)/1e6+"ms")
    ret
  }

  time{
    def traiteur = new Traiteur().start
    val f1 = (traiteur !! new Message("Allez!",10000000))
    val f2 = traiteur !! new Message("Allez!",10000000)
    val f3 = traiteur !! new Message("Allez!",10000000)
    val f4 = traiteur !! new Message("Allez!",10000000)
    traiteur ! new Message("Stop!")
    println(f1().asInstanceOf[Int]+f2().asInstanceOf[Int]+f3().asInstanceOf[Int]+f4().asInstanceOf[Int])
  }
}
