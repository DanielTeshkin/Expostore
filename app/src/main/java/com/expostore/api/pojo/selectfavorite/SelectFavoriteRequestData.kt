package com.expostore.api.pojo.selectfavorite

import com.fasterxml.jackson.annotation.JsonProperty

data class SelectFavoriteRequestData(
    @JsonProperty("notes") val notes: String?
)