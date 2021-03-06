package com.expostore.api

import com.expostore.api.base.BaseListResponse
import com.expostore.api.pojo.addreview.AddReviewRequestData
import com.expostore.api.pojo.addreview.AddReviewResponseData
import com.expostore.api.pojo.addshop.AddShopRequestData
import com.expostore.api.pojo.confirmcode.ConfirmCodeRequestData
import com.expostore.api.pojo.confirmcode.ConfirmCodeResponseData
import com.expostore.api.pojo.confirmnumber.ConfirmNumberRequestData
import com.expostore.api.pojo.confirmnumber.ConfirmNumberResponseData
import com.expostore.api.pojo.createtender.CreateTenderRequestData
import com.expostore.api.pojo.createtender.CreateTenderResponseData
import com.expostore.api.pojo.editprofile.EditProfileRequestData
import com.expostore.api.pojo.editprofile.EditProfileResponseData
import com.expostore.api.pojo.getchats.*
import com.expostore.api.pojo.getcities.CityResponse
import com.expostore.api.pojo.getfavoriteslist.GetFavoritesListResponseData
import com.expostore.api.pojo.getproduct.ProductResponseData
import com.expostore.api.pojo.getprofile.EditProfileRequest
import com.expostore.api.pojo.getprofile.GetProfileResponseData
import com.expostore.api.pojo.getreviews.ReviewsResponseData
import com.expostore.api.pojo.getshop.GetShopResponseData
import com.expostore.api.pojo.gettenderlist.Tender
import com.expostore.api.pojo.gettenderlist.TenderPage
import com.expostore.api.pojo.productcategory.ProductCategory
import com.expostore.api.pojo.saveimage.SaveImageRequestData
import com.expostore.api.pojo.saveimage.SaveImageResponseData
import com.expostore.api.pojo.selectfavorite.SelectFavoriteResponseData
import com.expostore.api.pojo.signin.SignInRequestData
import com.expostore.api.pojo.signin.SignInResponseData
import com.expostore.api.pojo.signup.SignUpRequestData
import com.expostore.api.pojo.signup.SignUpResponseData
import com.expostore.api.request.*
import com.expostore.api.response.*
import com.expostore.api.response.ProductResponse
import com.expostore.model.category.CharacteristicFilterModel
import com.google.gson.annotations.SerializedName
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.json.JSONArray
import retrofit2.Response
import retrofit2.http.*

interface ServerApi {

    @POST("/api/sign-in/")
    suspend fun authorization(@Body request: SignInRequestData): Response<SignInResponseData>

    @POST("/api/token/refresh/")
    suspend fun refresh(@Body refresh: RefreshTokenRequest): Response<SignInResponseData>

    @POST("/api/confirm/create/")
    suspend fun confirmNumber(@Body request: ConfirmNumberRequestData): Response<ConfirmNumberResponseData>

    @POST("/api/confirm/confirmed/")
    suspend fun confirmCode(@Body request: ConfirmCodeRequestData): Response<ConfirmCodeResponseData>

    @POST("/api/sign-up/")
    suspend fun registration(@Body request: SignUpRequestData): Response<SignUpResponseData>

    @POST("/api/shop/create/")
    suspend fun shopCreate(@Body request:AddShopRequestData):Response<ShopResponse>

    @PUT("/api/shop/")
    suspend fun editShop(@Body request:AddShopRequestData):Response<ShopResponse>

    @GET("/api/shop/create/")
    suspend fun getMyShop():Response<ShopResponse>

    @Multipart
    @POST("/api/chat/file/create/")
    suspend fun fileCreate(@Part file: MultipartBody.Part, @Part("filename")name: RequestBody):Response<ResponseFile>

    @POST("/api/chat/item/{id}/message/create/")
    suspend fun messageCreate(@Body request: MessageRequest, @Path("id") id: String):Response<MessageRequest>

    @POST("/api/chat/item/{id}/message/create/")
    suspend fun messageFileOrImage(@Body request: FileOrImageMessage, @Path("id") id: String):Response<MessageRequest>

    @GET("/api/cities/")
    suspend fun getCities(): Response<List<CityResponse>>

    @POST("/api/shop/{id}/product/create/")
    suspend fun createProduct(@Path("id") id: String,@Body request:ProductUpdateRequest):Response<ProductResponseUpdate>

    @PUT("api/product/{id}/update/")
    suspend fun updateProduct(@Path("id") id: String,@Body request:ProductUpdateRequest):Response<ProductResponseUpdate>

    @GET("/api/profile/")
    suspend fun getProfile(): Response<GetProfileResponseData>

    @PUT("/api/profile/")
    suspend fun editProfile(@Body request: EditProfileRequestData): Response<EditProfileResponseData>

    @PATCH("/api/profile/")
    suspend fun patchProfile(@Body request: EditProfileRequest): Response<EditResponseProfile>

    @GET("/api/selection/product/")
    suspend fun getCategories(): Response<List<SelectionResponse>>

    @GET("/api/advertising/selection/")
    suspend fun getCategoryAdvertising(): Response<List<CategoryAdvertisingResponse>>

    @GET("/api/advertising/main/")
    suspend fun getCategoryAdvertisingMain(): Response<List<CategoryAdvertisingResponse>>

    @GET("/api/selection/user/product/")
    suspend fun getUserSelection():Response<List<SelectionResponse>>

    @POST("/api/selection/user/product/create/")
    suspend fun createUserSelection(@Body selectionRequest: SelectionRequest):Response<SelectionResponse>

    @PATCH("/api/selection/user/product/{id}/add_product/")
    suspend fun addProductToUserSelection(@Path("id")id:String, @Body products:ProductsSelection):Response<SelectionResponse>

    @POST("/api/product/{id}/note/create/")
    suspend fun createNote(@Path("id") id: String, @Body request:NoteRequest ) :Response<NoteResponse>

    @POST("/api/product/{id}/note/")
    suspend fun updateNote(@Path("id") id: String,@Body request:NoteRequest) :Response<NoteResponse>

    @GET("/api/search/list/")
    suspend fun getSaveSearchList():Response<List<SaveSearchResponse>>

    @POST("/api/search/save/")
    suspend fun saveSearch(@Body saveSearchRequest: SaveSearchRequest):Response<SaveSearchResponse>

    //TODO ????????????????
    @POST("/api/product/{id}/elected/select/")
    suspend fun selectFavorite(@Path("id") id: String): Response<SelectFavoriteResponseData>

    @GET("/api/product/elected/list/")
    suspend fun getFavoritesList(): Response<List<GetFavoritesListResponseData>>

    //@GET("/api/product/elected/list/")
   // suspend fun getSearchList(): Response<List<GetFavoritesListResponseData>>

    @POST("/api/tender/create/")
    suspend fun createTender(@Body requestData: CreateTenderRequestData): Response<CreateTenderResponseData>

    @POST("/api/image/save/")
    suspend fun saveImage(@Body request: List<SaveImageRequestData>): Response<SaveImageResponseData>

    @GET("/api/product/category/")
    suspend fun getProductCategory(): Response<List<ProductCategory>>

    @GET("/api/product/category/{id}/characteristic/")
    suspend fun getCategoryCharacteristic(@Path("id") id: String): Response<List<CategoryCharacteristicResponse>>

    @GET("/api/tender/")
    suspend fun getTenders(
        @Query("page") page: Int?,
        @Query("q") name: String?,
        @Query("lat") lat: Double?,
        @Query("long") long: Double?,
        @Query("distance") distance: Double?,
        @Query("sort") sort: String?,
        @Query("category") category: String?,
        @Query("price_max") price_max:String?,
        @Query("price_min")  price_min:String?,
        @Query("city")  city:String?,
        @Query("promotion") promotion: Boolean?,

        ): Response<BaseListResponse<Tender>>

    @GET("/api/tender/my")
    suspend fun getMyTenders(): Response<TenderPage>

    @GET("/api/product/{id}/")
    suspend fun getProduct(@Path("id") id: String): Response<ProductResponseData>

    @PATCH("/api/product/{id}/status/draft/")
    suspend fun takeOffProduct(@Path("id") id: String): Response<ProductResponse>

    @PUT("/api/product/{id}/status/draft/")
    suspend fun saveToDraft(@Path("id") id: String,@Body request: ProductUpdateRequest): Response<ProductResponseUpdate>


    @GET("/api/product/{id}/review/")
    suspend fun getReviews(@Path("id") id: String): Response<ReviewsResponseData>

    @POST("/api/product/{id}/review/add/")
    suspend fun addReview(@Path("id") id: String, @Body requestData: AddReviewRequestData): Response<AddReviewResponseData>

    @GET("/api/product/")
    suspend fun getListProduct(
        @Query("page") page: Int?,
        @Query("q") q: String?,
        @Query("lat") lat: Double?,
        @Query("long") long: Double?,
        @Query("city") city: String?,
        @Query("sort") sort: String?,
        @Query("category") category: String?,
        @Query("price_min") price_min: Int?,
        @Query("price_max") price_max: Int?,
        @Query("promotion") promotion: Boolean?


    ): Response<BaseListResponse<ProductResponse>>

    @GET("/api/product/")
    suspend fun getProducts(
        @Query("page") page: Int?,
        @Body filterRequest: FilterRequest
    ): Response<BaseListResponse<ProductResponse>>




    @GET("/api/product/my")
    suspend fun getMyListProduct(@Query("status") status: String?): Response<BaseListResponse<ProductResponse>>

    @GET("/api/shop/{id}/")
    suspend fun getShop(@Path("id") id: String): Response<GetShopResponseData>

    @DELETE("/api/selection/user/product/{id}/")
    suspend fun deleteUserSelection(@Path("id") id:String):Response<SelectionResponse>

    @DELETE("/api/search/{id}/")
    suspend fun deleteSaveSearch(@Path("id") id:String) : Response<SaveSearchResponse>

    @GET("/api/reviews/")
    suspend fun getReviews():Response<ReviewsResponse>






    //chat
    @POST("/api/chat/create/")
    suspend fun chatCreateProduct(@Body chatCreateRequest: ProductChat):Response<ChatResponse>

    @POST("/api/chat/create/")
    suspend fun chatCreateTender(@Body chatCreateRequest: TenderChat):Response<ChatResponse>

    @GET("/api/chat/")
    suspend fun getChats(): Response<List<ChatResponse>>

    @GET("/api/chat/item/{id}/")
    suspend fun getChat(@Path("id") id: String): Response<ItemChatResponse>

    @DELETE("api/chat/{id}")
    suspend fun deleteMainChat(@Path("id") id: String):Response<ChatResponse>

    @DELETE("api/chat/item/{id}")
    suspend fun deleteChat(@Path("id") id: String):Response<ItemChatResponse>



}