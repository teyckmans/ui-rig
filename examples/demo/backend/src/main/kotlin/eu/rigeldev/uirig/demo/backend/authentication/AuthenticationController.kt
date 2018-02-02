package eu.rigeldev.uirig.demo.backend.authentication

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.lang.Thread.sleep

/**
 * @author Tom Eyckmans <teyckmans@gmail.com>
 */
@RestController
@CrossOrigin
class AuthenticationController {

    @PostMapping("/api/authenticate")
    fun authenticate(@RequestBody req : AuthRequest) : AuthResponse {

        println("authenticating " + req.username)

        // simulate something slow
        sleep(1000)

        return if (req.username == "admin" && req.password == "admin") {
            val roles = ArrayList<String>()

            roles.add("ROLE_USER")
            roles.add("ROLE_ADMIN")

            AuthResponse(true, req.username, roles)
        } else {
            AuthResponse(false, req.username, ArrayList())
        }
    }

}