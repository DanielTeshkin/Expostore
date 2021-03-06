package com.expostore.db.enities.chat

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.expostore.api.response.ImageResponse
import com.expostore.model.ImageModel

@Entity
data class MessageImageDao(@PrimaryKey
                               @ColumnInfo(name = "id") val id: String,
                           @ColumnInfo(name = "file")val file: String )
val ImageResponse.toDaoMessageImage : MessageImageDao
    get() = MessageImageDao(id,file)
