package com.example

import akka.actor.{Actor, Props}

import scala.concurrent.duration._
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.ExecutionContext.Implicits.global

class AskActor extends Actor {
  
  val recipient = context.actorOf(Props[ReceiveActor])

  def receive = {
    case "Start" =>
      implicit val timeout = Timeout(3 seconds)
      val replyF = recipient ? "Hello"
      replyF.onSuccess {
        case reply => println(reply)
      }
  }

}
