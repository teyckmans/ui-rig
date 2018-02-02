package eu.rigeldev.uirig.demo.backend

/**
 * @author Tom Eyckmans <teyckmans@gmail.com>
 */
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
 * @author Tom Eyckmans <teyckmans@gmail.com>
 */
@SpringBootApplication
class Application

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}