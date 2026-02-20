package zio

import scala.language.implicitConversions

class Label[A, L](val value: A) extends AnyVal

object Label {
  implicit def labelToValue[A, L](lbl: Label[A, L]): A = lbl.value

  type @+[A, L] = Label[A, L]

}
