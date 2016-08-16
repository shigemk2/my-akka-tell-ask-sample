package com.example

import akka.actor.{Actor, Props}

class TellActor extends Actor {
  val receipient = context.actorOf(Props[ReceiveActor])

  def receive = {
    case "Start" =>
      receipient ! "Hello"

    case reply => println(reply)
  }
}
