package com.example.pluginapp.model

import com.google.gson.annotations.SerializedName

data class RespUiData(

	/*@field:SerializedName("padding")
	val padding: String? = null,*/

	@field:SerializedName("orientation")
	val orientation: Int? = null,

	@field:SerializedName("src")
	val src: String? = null,

	@field:SerializedName("text_size")
	val text_size: Float? = null,

	@field:SerializedName("text_color")
	val text_color: String? = null,

	@field:SerializedName("bg_color")
	val bg_color: String? = null,

	@field:SerializedName("margin_top")
	val marginTop: Int? = null,

	@field:SerializedName("layout_gravity")
	val layoutGravity: Int? = null,

	@field:SerializedName("gravity")
	val gravity: Int? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("margin_right")
	val marginRight: Int? = null,

	@field:SerializedName("margin_left")
	val marginLeft: Int? = null,

	@field:SerializedName("margin_bottom")
	val marginBottom: Int? = null,


	@field:SerializedName("hint")
	val hint: String? = null,

	@field:SerializedName("width")
	val width: Int? = null,

	@field:SerializedName("text")
	val text: String? = null,

	@field:SerializedName("height")
	val height: Int? = null,

	@field:SerializedName("child")
	val child: List<RespUiData> = arrayListOf()
)

data class ChildItem(

	@field:SerializedName("padding")
	val padding: String? = null,

	@field:SerializedName("orientation")
	val orientation: String? = null,

	@field:SerializedName("src")
	val src: String? = null,

	@field:SerializedName("margin_top")
	val marginTop: String? = null,

	@field:SerializedName("layout_gravity")
	val layoutGravity: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("visiblity")
	val visiblity: String? = null,

	@field:SerializedName("margin_right")
	val marginRight: String? = null,

	@field:SerializedName("margin_left")
	val marginLeft: String? = null,

	@field:SerializedName("margin_bottom")
	val marginBottom: String? = null,

	@field:SerializedName("gravity")
	val gravity: String? = null,

	@field:SerializedName("hint")
	val hint: String? = null,

	@field:SerializedName("width")
	val width: String? = null,

	@field:SerializedName("text")
	val text: String? = null,

	@field:SerializedName("height")
	val height: String? = null,

	@field:SerializedName("child")
	val child: List<Any?>? = null
)
