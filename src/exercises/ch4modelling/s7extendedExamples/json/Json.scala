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

sealed trait Json {
  override def toString: String = "foo"
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

object Tests {

  JsonPair (JsonString ("a string"), JsonPair (JsonNum (1.0), JsonPair (JsonBool
  (true), ListEnd) ) ).toString
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
  
}

// res1: String = {"a": [1.0, 2.0, 3.0], "b":