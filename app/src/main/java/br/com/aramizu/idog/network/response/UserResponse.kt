package br.com.aramizu.idog.network.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class UserResponse {

    @JsonProperty("user")
    var user: UserSessionResponse? = null

}
