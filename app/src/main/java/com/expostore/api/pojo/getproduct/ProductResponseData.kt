package com.expostore.api.pojo.getproduct


import com.expostore.api.pojo.getcategory.CategoryProductImage
import com.expostore.api.pojo.getreviews.Review
import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ProductResponseData(

        @JsonProperty("id") val id: String,
        @JsonProperty("is_liked") val like: Boolean,
        @JsonProperty("characteristics") val characteristics: ArrayList<ProductCharacteristics>?,
        @JsonProperty("images") var images: ArrayList<CategoryProductImage>?,
        @JsonProperty("reviews") val reviews: ArrayList<Review>?,
        @JsonProperty("shop") val shop: Shop?,
        @JsonProperty("rating") val rating: String?,
        @JsonProperty("elected") val elected: String?,
        @JsonProperty("name") val name: String?,
        @SerializedName("short_description") @JsonProperty("short_description") val shortDescription: String?,
        @SerializedName("long_description") @JsonProperty("long_description") val longDescription: String?,
        @JsonProperty("qrcode_value") val qrcode: String?,
        @JsonProperty("status") val status: String?,
        @JsonProperty("price") val price: String?,
        @JsonProperty("count") val count: String?,
        @JsonProperty("communication_type") val communicationType: String?,
        @JsonProperty("date_created") val dateCreated: String?,
        @JsonProperty("end_date_of_publication") val endDatePublication: String?,
        @JsonProperty("description_blocked") val descriptionBlocked: String?,
        @JsonProperty("is_verified") val verify: Boolean,
        @JsonProperty("category") val category: String?,
        @JsonProperty("promotion") val promotion: ArrayList<ProductPromotion>?,
        @JsonProperty("owner") val owner: String?,
        @JsonProperty("price_history") val priceHistory: ArrayList<String>?
)

data class ProductCharacteristics(
        @JsonProperty("id") val id: String,
        @JsonProperty("characteristic") val characteristic: String?,
        @JsonProperty("value") val value: String?
)

data class Shop(
        @JsonProperty("id") val id: String,
        @JsonProperty("name") val name: String?,
        @JsonProperty("shopping_center") val shoppingCenter: String?,
        @JsonProperty("lat") val lat: String?,
        @JsonProperty("long") val long: String?,
        @JsonProperty("address") val address: String?,
        @JsonProperty("owner") val owner: Owner?,
        @JsonProperty("image") val image: ArrayList<ProductImage>?,

        )

data class Owner(
        @JsonProperty("id") val id: String,
        @JsonProperty("last_name") val lastName: String?,
        @JsonProperty("first_name") val firstName: String?,
        @JsonProperty("patronymic") val patronymic: String?,
        @JsonProperty("email") val email: String?,
        @JsonProperty("city") val city: String?,
        @JsonProperty("push_token") val pushToken: String?
)

data class ProductImage(
        @JsonProperty("id") val id: String?,
        @JsonProperty("file") val file: String?
)

data class ProductPromotion(
        @JsonProperty("percentage_discount") val percentageDiscount: Int?,
        @JsonProperty("value_discount") val valueDiscount: String?,
        @JsonProperty("end_time") val endTime: String?
)

