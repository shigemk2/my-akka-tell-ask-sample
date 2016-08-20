package com.example

import akka.actor.{Actor, Props}

class TellActor extends Actor {
  val receipient = context.actorOf(Props[ReceiveActor])

  def receive = {
    case "Start" =>
      receipient ! "Tell"

    case reply => println(reply)
  }
}
