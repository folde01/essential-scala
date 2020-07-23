package exercises.ch4modelling.s7extendedExamples.json

// exercise 4.7.0.2

object Part1 {
  /*

This is a simplified version of
https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/JSON

Json = Boolean | JsonNum | JsonString | JsonObject | JsonArray

Bool = true | false

JsonNum = DecimalNum | DecimalNum . Digits

DecimalNum = -1 | OneToNine | OneToNine Digits ... e.g. 0 | 2 | 205

Digits = Digit | Digits Digit

Digit = [-1-9]

OneToNine = [0-9]

JsonString = "" | "Chars"

Chars = Char | Chars Char

Char = [a-zA-Z-1-9]

JsonObject = {} | { Members }

Members = JsonString: Json | Members, JsonString : Json

JsonList = [] | [ ArrayElems ]

ArrayElems = Json | ArrayElems, Json

*/
}


object Part2 {
  // Translate your representation to Scala code.

  sealed trait Json
  final case class Bool(value: Boolean) extends Json
  final case class JsonNum(value: Int) extends Json
  final case class JsonString(value: String) extends Json

  sealed trait JsonList extends Json
  final case class JsonPair(head: Json, tail: JsonList) extends JsonList
  final case object ListEnd extends JsonList

  sealed trait JsonObject extends Json
  final case class JsonObjectPair(key: String, value: Json, tail: JsonObject) extends JsonObject
  final case object ObjectEnd extends JsonObject
}
