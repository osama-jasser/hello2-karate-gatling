package com.progressoft.gatling

import com.progressoft.gatling.simulation.HelloKarateSimulation
import io.gatling.app.Gatling
import io.gatling.core.config.GatlingPropertiesBuilder

object MainApp extends App {
  val props = new GatlingPropertiesBuilder
  props.simulationClass(classOf[HelloKarateSimulation].getName)
  Gatling.fromMap(props.build)
  sys.exit()
}