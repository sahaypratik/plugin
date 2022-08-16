package com.example.pluginapp.model

import com.google.gson.annotations.SerializedName

data class RespSelector(

	@field:SerializedName("scenario")
	val scenario: String? = null,

	@field:SerializedName("postion")
	val postion: Int? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)
