package com.example

import akka.actor.{ActorSystem, Props}

object Hello extends App {
  override def main(args: Array[String]): Unit = {
    implicit val system = ActorSystem.apply("HelloApp")
      val ask = system.actorOf(Props[AskActor])
      ask ! "Start"
      Thread.sleep(1000)
      system.shutdown()
  }
}
