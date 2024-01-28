package com.wookiepookie.chapie.backend

import io.ktor.application.*
import io.ktor.http.cio.websocket.*
import io.ktor.routing.*
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.websocket.WebSockets
import io.ktor.websocket.webSocket
import kotlinx.coroutines.channels.consumeEach

fun main() {
    embeddedServer(Netty, port = 8080) {
        install(WebSockets)
        routing {
            webSocket("/echo") {
                incoming.consumeEach { frame ->
                    if (frame is Frame.Text) {
                        val receivedText = frame.readText()
                        send(Frame.Text("You sent: $receivedText"))
                    }
                }
            }
        }
        println("server has started")
    }.start(wait = true)
}