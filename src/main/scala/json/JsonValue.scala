package json

sealed trait JsonValue
case class JsonObject(fields: Map[String, JsonValue]) extends JsonValue
case class JsonString(characters: String) extends JsonValue
case class JsonArray(list: List[JsonValue]) extends JsonValue
case class JsonNumber(value: Double) extends JsonValue
case class JsonBoolean(bool: Boolean) extends JsonValue
case object JsonNull extends JsonValue

object JsParser {
  def stringify(jsonValue: JsonValue): String = {
    jsonValue match {
      case JsonObject(fields) => fields.map {
        case (key, value) => s""""$key : ${stringify(value)}"""
      }
      .mkString("{", ",", "}")
      case JsonString(characters) => characters
      case JsonArray(list) => list.map(i => stringify(i)).mkString("[", ",", "]")
      case JsonNumber(value) =>  value.toString
      case JsonBoolean(bool) => bool.toString
      case JsonNull => "null"
    }
  }
}

case class MyThing(r: Double, g: Boolean)

object EncodeStuff {
  def encodeThing(thing: MyThing): JsonObject = {
    JsonObject(Map("r" -> JsonNumber(thing.r), "g" -> JsonBoolean(thing.g)))
  }
}



object Main extends App {

  import JsParser._

  println("Number")
  val jsonNumber = JsonNumber(2.0)
  println(stringify(jsonNumber))

  println("String")
  val jsonString = JsonString("json")
  println(stringify(jsonString))

  println("Array")
  val jsonArray = JsonArray(List(jsonNumber, jsonString))
  println(stringify(jsonArray))

  println("Object")
  val jsonObject = JsonObject(Map("hello" -> jsonNumber))
  println(stringify(jsonObject))

  val thing = MyThing(100.0, g = true)
  val encodeStuff = EncodeStuff.encodeThing(thing)
  println(encodeStuff)

}

