import card.CreditCard
import card.format._
import play.api.libs.json.{JsString, Json}

object Main extends App {

  val validCard = Json.obj(
    "number" -> "1111 2222 3333 4444",
    "holder" -> "CARD HOLDER",
    "cvv" -> "666"
  )

  val malformedNumberCard = validCard + ("number" -> JsString("111"))

  val malformedCVVCard = validCard + ("cvv" -> JsString("6 6 6"))

  println(Json.fromJson[CreditCard](validCard))
  println(Json.fromJson[CreditCard](malformedNumberCard))
  println(Json.fromJson[CreditCard](malformedCVVCard))
}
