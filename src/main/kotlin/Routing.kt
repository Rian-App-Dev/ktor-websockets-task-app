package com.example

import com.example.model.TaskRepository
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.plugins.cors.routing.CORS
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {

    routing {
        install(CORS) {
            allowMethod(HttpMethod.Options)
            allowMethod(HttpMethod.Put)
            allowMethod(HttpMethod.Delete)
            allowMethod(HttpMethod.Patch)
            allowHeader(HttpHeaders.Authorization)
            allowHeader("MyCustomHeader")
            anyHost()
            allowMethod(HttpMethod.Get)
            allowHeader(HttpHeaders.Accept)
            allowHeader(HttpHeaders.ContentType)
        }
        get("/tasks") {
            call.respond(TaskRepository.allTasks())
        }
        // Static plugin. Try to access `/static/index.html`
        staticResources("/static", "static")
    }
}
