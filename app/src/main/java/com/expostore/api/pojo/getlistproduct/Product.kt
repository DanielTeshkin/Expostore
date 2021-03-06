package com.expostore.api.pojo.getlistproduct

import com.expostore.api.pojo.getcategory.ImageResponseData
import com.fasterxml.jackson.annotation.JsonProperty

data class Product(
    @JsonProperty("id") val id: String?,
    @JsonProperty("name") val name: String?,
    @JsonProperty("images") val images: List<ImageResponseData>?,
    @JsonProperty("price") val price: String?,
    @JsonProperty("rating") val rating: String?,
    @JsonProperty("promotion") val promotion: String?,
    @JsonProperty("is_liked") val like: Boolean?
)

