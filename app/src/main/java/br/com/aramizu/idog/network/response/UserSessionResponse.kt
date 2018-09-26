package br.com.aramizu.idog.network.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class UserSessionResponse {

    @JsonProperty("_id")
    var id: String? = null

    @JsonProperty("email")
    var email: String? = null

    @JsonProperty("token")
    var token: String? = null

}
