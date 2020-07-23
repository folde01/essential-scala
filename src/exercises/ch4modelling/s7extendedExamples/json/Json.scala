package exercises.ch4modelling.s7extendedExamples.json

/*

This is a simplified version of
https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/JSON


Json = null | true | false | JsonNum | JsonString | JsonObject | JsonArray

JsonNum = DecimalNum | DecimalNum . Digits

DecimalNum = 0 | OneToNine | OneToNine Digits ... e.g. 0 | 2 | 205

Digits = Digit | Digits Digit

Digit = [0-9]

OneToNine = [1-9]

JsonString = "" | "Chars"

Chars = Char | Chars Char

Char = [a-zA-Z0-9]

JsonObject = {} | { Members }

Members = JsonString: Json | Members, JsonString : Json

JsonArray = [] | [ ArrayElems ]

ArrayElems = Json | ArrayElems, Json

*/

object Json {

}
