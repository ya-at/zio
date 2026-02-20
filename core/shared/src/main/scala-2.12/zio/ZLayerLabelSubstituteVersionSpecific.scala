package zio

object ZLayerLabelSubstituteVersionSpecific {

  def substituteOut[U, A, R, E, Out](layer: ZLayer[R, E, U with A])(
    implicit
     // This evidence is required for `asInstanceOf` below to be safe.
     // Even though `ev` appears unused, it proves that `U with A <:< RIn`,
     // which ensures the cast `later.asInstanceOf[ZLayer[A with U, E, Out]]` is sound.
     // DO NOT REMOVE.
    ev: U with A =:= Out): ZLayer[R, E, Out] =
    layer.asInstanceOf[ZLayer[R, E, Out]]


}
