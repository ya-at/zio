package zio

object ZLayerLabelVersionSpecific  {

  final class RequireLabeled[RIn, E, ROut, A, L](private val self: ZLayer[RIn, E, ROut]) extends AnyVal {
    def require[U](implicit
      ev: U with A =:= RIn,
      trace: Trace,
      tagged1: Tag[A],
      tagged2: Tag[L]
    ): ZLayer[U with Label[A, L], E, ROut] = {
      val layer = ZLayer
        .environment[U]
        .zipWith(ZLayer.environment[Label[A, L]].map(env => ZEnvironment(env.get.value)))(_.union[A](_))

      ZLayerLabelSubstituteVersionSpecific.substituteOut[U, A, U with Label[A, L], E, RIn](layer).to(self)

    }

  }
}
