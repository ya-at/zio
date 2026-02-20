package zio

object ZLayerLabelSubstituteVersionSpecific {

  def substituteOut[U, A, R, E, Out](
    layer: ZLayer[R, E, U with A]
  )(implicit ev: U with A =:= Out): ZLayer[R, E, Out] = {
    type F[+S] = ZLayer[R, E, S]

    ev.liftCo[F](layer)
  }

}
