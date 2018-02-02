package eu.rigeldev.uirig.demo.backend.authentication

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * @author Tom Eyckmans <teyckmans@gmail.com>
 */
data class AuthRequest @JsonCreator constructor(
        /*@JsonProperty("username") */val username : String,
        /*@JsonProperty("password") */val password : String)