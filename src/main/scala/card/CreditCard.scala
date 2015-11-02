package card

import card.tags.{CVV, CardNumber}
import shapeless.tag.@@

object tags {
  sealed trait CardNumber
  sealed trait CVV
}

case class CreditCard(number: String @@ CardNumber, holder: String, cvv: String @@ CVV)
