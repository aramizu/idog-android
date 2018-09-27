package br.com.aramizu.idog.network.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class DogsResponse {

    @JsonProperty("category")
    var category: String? = null

    @JsonProperty("list")
    var list: List<String>? = null

}
