package com.expostore.api.pojo.getreviews

import com.expostore.api.pojo.getproduct.ProductImage
import com.fasterxml.jackson.annotation.JsonProperty

data class Review(
    @JsonProperty("id") val id: String,
    @JsonProperty("images") val images: ArrayList<ProductImage>,
    @JsonProperty("rating") val rating: String?,
    @JsonProperty("text") val text: String?,
    @JsonProperty("date_created") val dateCreated: String?,
    @JsonProperty("author") val author: String?,
)