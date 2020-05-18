package com.progressoft.gatling.simulation

import com.intuit.karate.gatling.PreDef._
import io.gatling.core.Predef._
import io.gatling.core.structure.PopulationBuilder

import scala.collection.mutable.ArraySeq

class HelloKarateSimulation extends Simulation {

  val protocol = karateProtocol()
  protocol.nameResolver = (req, ctx) => req.getHeader("com.progressoft.karate-name")

  val numberOfUsers=50
  val duration=5

  var features=FileUtil.listFeatures()
  def scnList() = {
    var scnList = new ArraySeq[PopulationBuilder](features.length)
    var i=0
    for (feature <-  features) {
      var scen = scenario(feature.toString).exec(karateFeature("classpath:"+feature))
          .inject(rampUsers(numberOfUsers) during (duration.toInt))
      scnList(i) = scen
      i=i+1
    }
    scnList
  }

  setUp(scnList: _*).protocols(protocol)
}
