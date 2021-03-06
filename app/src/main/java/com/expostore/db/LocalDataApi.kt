package com.expostore.db

import androidx.room.*
import com.expostore.db.enities.AdvertisingDao
import com.expostore.db.enities.ProfileDao

import com.expostore.db.enities.TokenDao
import com.expostore.db.enities.chat.ChatDao
import com.expostore.db.enities.selection.SelectionDao
import com.expostore.model.chats.DataMapping.MainChat

@Dao
interface LocalDataApi {
    @Query("Select * from token")
     fun getToken():TokenDao?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun saveToken(tokenDao: TokenDao)

    @Query("DELETE FROM token")
    suspend fun removeToken()

    @Query("Select * from chats")
    suspend fun getChats():List<ChatDao>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveChats(chats:List<ChatDao>)

    @Query("DELETE FROM chats")
    suspend fun removeChats()

    @Query("Select * from profile")
    suspend fun getProfile(): ProfileDao

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveProfile(model: ProfileDao)

    @Query("DELETE FROM profile")
    fun deleteProfile()

    @Query("Select * from selection")
    suspend fun getSelection():List<SelectionDao>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveSelections(selections:List<SelectionDao>)

    @Query("DELETE FROM selection")
    suspend fun removeSelections()

    @Query("Select * from advertising")
    suspend fun getAdvertising():List<AdvertisingDao>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAdvertising(advertising:List<AdvertisingDao>)

    @Query("DELETE FROM selection")
    suspend fun removeAdvertising()








}