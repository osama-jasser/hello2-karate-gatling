package com.progressoft.gatling.simulation

import com.intuit.karate.gatling.PreDef._
import io.gatling.core.Predef._
import io.gatling.core.structure.PopulationBuilder

import scala.collection.mutable.ArraySeq

class HelloKarateSimulation extends Simulation {

  val protocol = karateProtocol()
  protocol.nameResolver = (req, ctx) => req.getHeader("com.progressoft.karate-name")

  val numberOfUsers=5
  val duration=5



  setUp(scenario("f1").exec(karateFeature("classpath:com/progressoft/karate/hello/hello2.feature"))
    .inject(rampUsers(numberOfUsers) during (duration.toInt))
  ).protocols(protocol)
}
