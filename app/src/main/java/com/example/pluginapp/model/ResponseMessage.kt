package com.example.downloadmanager.model

import com.google.gson.annotations.SerializedName

data class ResponseMessage(

	@field:SerializedName("message")
	val message: String? = null
)
