package com.example.pluginapp.model

import com.google.gson.annotations.SerializedName

data class RespDialogData(

	@field:SerializedName("duration")
	val duration: Int? = null,

	@field:SerializedName("backgroundColor")
	val backgroundColor: String? = null,

	@field:SerializedName("topMargin")
	val topMargin: Int? = null,

	@field:SerializedName("bottomMargin")
	val bottomMargin: Int? = null,

	@field:SerializedName("gravity")
	val gravity: Int? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("text")
	val text: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("textColor")
	val textColor: String? = null
)
