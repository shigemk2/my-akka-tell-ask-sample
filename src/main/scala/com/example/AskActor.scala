package com.example

import akka.actor.{Actor, Props}
import scala.concurrent.duration._
import akka.pattern.ask

class AskActor extends Actor {
  
  val recipient = context.actorOf(Props[ReceiveActor])

  def receive = {
    case "Start" =>
      implicit val timeout = 3 seconds
      val replyF = recipient ? "Hello"
      replyF.onSuccess {
        case reply => println(reply)
      }
  }

}
