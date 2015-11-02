package card

import card.tags.{CardNumber, CVV}
import play.api.data.validation.ValidationError
import play.api.libs.json._
import shapeless.tag
import shapeless.tag._

object format {

  implicit lazy val readsCardNumber: Reads[String @@ CardNumber] =
    __.read[String]
      .map(_.replaceAll("\\s", ""))
      .collect(ValidationError("Invalid card number")) {
        case num if (16 to 19).contains(num.length) =>
          tag[CardNumber](num)
      }

  implicit lazy val readsCVV: Reads[String @@ CVV] =
    __.read[String](
    Reads.pattern("\\d{3,5}".r, "Invalid CVV")
  ).map(tag[CVV](_))

  implicit lazy val readsCard = Json.format[CreditCard]
}
