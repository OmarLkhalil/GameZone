package com.mobilebreakero.dto

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class Games(

	@field:SerializedName("number_of_total_results")
	val numberOfTotalResults: Int ,

	@field:SerializedName("status_code")
	val statusCode: Int? = null,

	@field:SerializedName("offset")
	val offset: Int? = null,

	@field:SerializedName("number_of_page_results")
	val numberOfPageResults: Int ,

	@field:SerializedName("limit")
	val limit: Int? = null,

	@field:SerializedName("error")
	val error: String? = null,

	val page : Long,

	@field:SerializedName("results")
	val results: List<GamesItemDto>,

	@field:SerializedName("version")
	val version: String? = null
) : Parcelable

@Parcelize
data class Image(

	@field:SerializedName("icon_url")
	val iconUrl: String? = null,

	@field:SerializedName("screen_large_url")
	val screenLargeUrl: String? = null,

	@field:SerializedName("thumb_url")
	val thumbUrl: String? = null,

	@field:SerializedName("tiny_url")
	val tinyUrl: String? = null,

	@field:SerializedName("small_url")
	val smallUrl: String? = null,

	@field:SerializedName("super_url")
	val superUrl: String? = null,

	@field:SerializedName("original_url")
	val originalUrl: String? = null,

	@field:SerializedName("screen_url")
	val screenUrl: String? = null,

	@field:SerializedName("medium_url")
	val mediumUrl: String? = null,

	@field:SerializedName("image_tags")
	val imageTags: String? = null
) : Parcelable

@Parcelize
data class OriginalGameRatingItem(

	@field:SerializedName("api_detail_url")
	val apiDetailUrl: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
) : Parcelable

@Parcelize
data class ImageTagsItem(

	@field:SerializedName("api_detail_url")
	val apiDetailUrl: String? = null,

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("name")
	val name: String? = null
) : Parcelable

@Parcelize
data class GamesItemDto(

	@field:SerializedName("image")
	val image: Image? = null,

	@field:SerializedName("aliases")
	val aliases: String? = null,

	@field:SerializedName("site_detail_url")
	val siteDetailUrl: String? = null,

	@field:SerializedName("deck")
	val deck: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("number_of_user_reviews")
	val numberOfUserReviews: Int? = null,

	@field:SerializedName("platforms")
	val platforms: List<PlatformsItem?>? = null,

	@field:SerializedName("api_detail_url")
	val apiDetailUrl: String? = null,

	@field:SerializedName("date_added")
	val dateAdded: String? = null,

	@field:SerializedName("original_game_rating")
	val originalGameRating: List<OriginalGameRatingItem?>? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("guid")
	val guid: String? = null,

	@field:SerializedName("expected_release_year")
	val expectedReleaseYear: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("image_tags")
	val imageTags: List<ImageTagsItem?>? = null,

	@field:SerializedName("date_last_updated")
	val dateLastUpdated: String? = null
) : Parcelable

@Parcelize
data class PlatformsItem(

	@field:SerializedName("api_detail_url")
	val apiDetailUrl: String? = null,

	@field:SerializedName("site_detail_url")
	val siteDetailUrl: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("abbreviation")
	val abbreviation: String? = null
) : Parcelable
