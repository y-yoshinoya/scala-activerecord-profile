package sample

import com.github.aselab.activerecord._
import com.github.aselab.activerecord.dsl._

object Tables extends ActiveRecordTables {
  val users = table[User]
}

case class User(name: String, age: Int) extends ActiveRecord

object User extends ActiveRecordCompanion[User]

object Main extends App {
  Tables.initialize(Map("schema" -> "sample.Tables"))
  User.forceInsertAll((1 to 1000).map(i => User("name" + i, i)))
  println(User.count + " records are inserted")

  inTransaction{
    val start = new java.util.Date()
    val users = User.all.toList
    val end = new java.util.Date()
    println(end.getTime - start.getTime + " ms spent from start to end")
  }
  Tables.cleanup
}
