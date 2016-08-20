package com.example

import akka.actor.Actor

class ReceiveActor extends Actor {

  def receive = {
    case "Hello" => sender ! "And Hello to you!"
    case "Tell" => sender ! "Tell me your name!"
  }
}
