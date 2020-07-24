package exercises.ch4modelling.s7extendedExamples.json

// exercise 4.7.0.2

object Part1 {
  /*

This is a simplified version of
https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/JSON

Json = JsonBool | JsonNum | JsonString | JsonList | JsonObject

JsonBool = Boolean

JsonNum = Double

JsonString = String

JsonList = ListEnd | JsonPair(head: Json, tail: JsonList)

JsonObject = ObjectEnd | JsonObjectPair(key: String, value: Json, tail: JsonObject)

*/
}


object Part2 {
  // Translate your representation to Scala code.

  sealed trait Json
  final case class JsonBool(value: Boolean) extends Json
  final case class JsonNum(value: Double) extends Json
  final case class JsonString(value: String) extends Json

  sealed trait JsonList extends Json
  final case class JsonPair(head: Json, tail: JsonList) extends JsonList
  final case object ListEnd extends JsonList

  sealed trait JsonObject extends Json
  final case class JsonObjectPair(key: String, value: Json, tail: JsonObject) extends JsonObject
  final case object ObjectEnd extends JsonObject
}

  // Json.toString

object Part3Step1 {

  // just print the base cases
  sealed trait Json {
    private def quote(string: String): String = s""""$string""""

    override def toString: String =
      this match {
        case JsonString(value) => quote(value)
        case JsonNum(value) => quote(value.toString)
        case JsonBool(value) => quote(value.toString)
      }
  }

  final case class JsonBool(value: Boolean) extends Json

  final case class JsonNum(value: Double) extends Json

  final case class JsonString(value: String) extends Json

  sealed trait JsonList extends Json

  final case class JsonPair(head: Json, tail: JsonList) extends JsonList

  final case object ListEnd extends JsonList

  sealed trait JsonObject extends Json

  final case class JsonObjectPair(key: String, value: Json, tail: JsonObject) extends JsonObject

  final case object ObjectEnd extends JsonObject


  object Tests extends App {

    val jsonTrue = JsonBool(true)
    println(jsonTrue)

    val json1 = JsonNum(1.0)
    println(json1)

    val jsonFoo = JsonString("foo")
    println(jsonFoo)
  }

}

sealed trait Json {
  private def quote(string: String): String = s""""$string""""

  override def toString: String =
    this match {
      case JsonString(value) => quote(value)
      case JsonNum(value) => quote(value.toString)
      case JsonBool(value) => quote(value.toString)

      //case ListEnd => "]"

      case JsonPair(head, tail) => head match {
        case ListEnd => tail match {
          case ListEnd => "[]"
        }
      }

      case JsonObjectPair(key, value, tail) => ???
    }
}

final case class JsonBool(value: Boolean) extends Json
final case class JsonNum(value: Double) extends Json
final case class JsonString(value: String) extends Json

sealed trait JsonList extends Json
final case class JsonPair(head: Json, tail: JsonList) extends JsonList
final case object ListEnd extends JsonList

sealed trait JsonObject extends Json
final case class JsonObjectPair(key: String, value: Json, tail: JsonObject) extends JsonObject
final case object ObjectEnd extends JsonObject


object Tests extends App {

  val jsonTrue = JsonBool(true)
  println(jsonTrue)

  val json1 = JsonNum(1.0)
  println(json1)

  val jsonFoo = JsonString("foo")
  println(jsonFoo)

//  val jsonListEnd = ListEnd
//  println(jsonListEnd)

  val jsonPairEmpty = JsonPair(ListEnd, ListEnd)
  println("jsonPairEmpty: " + jsonPairEmpty)

  /*

  JsonPair (
            HEAD: ListEnd,
            TAIL: ListEnd
           )
  // []

  JsonPair (
            HEAD: JsonString ("a string"),
            TAIL: JsonPair (
                            HEAD: JsonNum (1.0),
                            TAIL: JsonPair (
                                            HEAD: JsonBool (true),
                                            TAIL: ListEnd
                                            )
                            )
            ).toString

  // res0: String = ["a string", 1.0, true]
  JsonObjectPair (
    "a", JsonPair (JsonNum (1.0), JsonPair (JsonNum (2.0), JsonPair (JsonNum
    (3.0), ListEnd) ) ),
    JsonObjectPair (
      "b", JsonPair (JsonString ("a"), JsonPair (JsonString ("b"), JsonPair (
        JsonString ("c"), ListEnd) ) ),
      JsonObjectPair (
        "c", JsonObjectPair ("doh", JsonBool (true),
          JsonObjectPair ("ray", JsonBool (false),
            JsonObjectPair ("me", JsonNum (1.0), ObjectEnd) ) ),
        ObjectEnd
      )
    )
  ).toString
  
// res1: String = {"a": [1.0, 2.0, 3.0], "b":

   */
}