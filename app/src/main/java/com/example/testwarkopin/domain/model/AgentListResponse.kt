package com.example.testwarkopin.domain.model

import com.google.gson.annotations.SerializedName

// NOTE TO MUCH I LEAVE IT RAW
data class AgentListResponse(

	@field:SerializedName("matching_rows")
	val matchingRows: Int? = null,

	@field:SerializedName("agents")
	val agents: List<AgentsItem?>? = null
)

data class PhoneList(

	@field:SerializedName("phone_1")
	val phone1: Phone1? = null
)

data class AgentTeamDetails(

	@field:SerializedName("is_team_member")
	val isTeamMember: Boolean? = null
)

data class Unsubscribe(

	@field:SerializedName("account_notify")
	val accountNotify: Boolean? = null,

	@field:SerializedName("autorecs")
	val autorecs: Boolean? = null,

	@field:SerializedName("recapprove")
	val recapprove: Boolean? = null
)

data class RecentlySold(

	@field:SerializedName("min")
	val min: Int? = null,

	@field:SerializedName("max")
	val max: Int? = null,

	@field:SerializedName("last_sold_date")
	val lastSoldDate: String? = null,

	@field:SerializedName("count")
	val count: Int? = null
)

data class ProfileWizard(

	@field:SerializedName("realsatisfied_opt_out")
	val realsatisfiedOptOut: Boolean? = null,

	@field:SerializedName("tt_opt_out")
	val ttOptOut: Boolean? = null
)

data class Address(

	@field:SerializedName("country")
	val country: String? = null,

	@field:SerializedName("city")
	val city: String? = null,

	@field:SerializedName("line")
	val line: String? = null,

	@field:SerializedName("state")
	val state: String? = null,

	@field:SerializedName("postal_code")
	val postalCode: String? = null,

	@field:SerializedName("state_code")
	val stateCode: String? = null,

	@field:SerializedName("line2")
	val line2: String? = null
)

data class ServedAreasItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("state_code")
	val stateCode: String? = null
)

data class Office(

	@field:SerializedName("website")
	val website: String? = null,

	@field:SerializedName("address")
	val address: Address? = null,

	@field:SerializedName("phones")
	val phones: List<PhonesItem?>? = null,

	@field:SerializedName("feed_licenses")
	val feedLicenses: Any? = null,

	@field:SerializedName("photo")
	val photo: Photo? = null,

	@field:SerializedName("phone_list")
	val phoneList: PhoneList? = null,

	@field:SerializedName("video")
	val video: Any? = null,

	@field:SerializedName("nrds_id")
	val nrdsId: Any? = null,

	@field:SerializedName("fulfillment_id")
	val fulfillmentId: Int? = null,

	@field:SerializedName("licenses")
	val licenses: Any? = null,

	@field:SerializedName("mls")
	val mls: List<MlsItem?>? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("slogan")
	val slogan: String? = null,

	@field:SerializedName("email")
	val email: String? = null
)

data class PhonesItem(

	@field:SerializedName("ext")
	val ext: String? = null,

	@field:SerializedName("number")
	val number: String? = null,

	@field:SerializedName("type")
	val type: String? = null
)

data class Phone1(

	@field:SerializedName("ext")
	val ext: String? = null,

	@field:SerializedName("number")
	val number: String? = null,

	@field:SerializedName("type")
	val type: String? = null
)

data class NewFeaturePopupClosed(

	@field:SerializedName("agent_left_nav_avatar_to_profile")
	val agentLeftNavAvatarToProfile: Boolean? = null,

	@field:SerializedName("listingmanager-movephoto")
	val listingmanagerMovephoto: Boolean? = null,

	@field:SerializedName("listingmanager-shared-dismissed")
	val listingmanagerSharedDismissed: Boolean? = null
)

data class SpecializationsItem(

	@field:SerializedName("name")
	val name: String? = null
)

data class Settings(

	@field:SerializedName("display_ratings")
	val displayRatings: Boolean? = null,

	@field:SerializedName("broker_data_feed_opt_out")
	val brokerDataFeedOptOut: Boolean? = null,

	@field:SerializedName("terms_of_use")
	val termsOfUse: Boolean? = null,

	@field:SerializedName("has_dotrealtor")
	val hasDotrealtor: Boolean? = null,

	@field:SerializedName("display_price_range")
	val displayPriceRange: Boolean? = null,

	@field:SerializedName("display_listings")
	val displayListings: Boolean? = null,

	@field:SerializedName("show_stream")
	val showStream: Boolean? = null,

	@field:SerializedName("full_access")
	val fullAccess: Boolean? = null,

	@field:SerializedName("far_override")
	val farOverride: Boolean? = null,

	@field:SerializedName("loaded_from_sb")
	val loadedFromSb: Boolean? = null,

	@field:SerializedName("unsubscribe")
	val unsubscribe: Unsubscribe? = null,

	@field:SerializedName("new_feature_popup_closed")
	val newFeaturePopupClosed: NewFeaturePopupClosed? = null,

	@field:SerializedName("share_contacts")
	val shareContacts: Boolean? = null,

	@field:SerializedName("display_sold_listings")
	val displaySoldListings: Boolean? = null,

	@field:SerializedName("profile_wizard")
	val profileWizard: ProfileWizard? = null,

	@field:SerializedName("use_dot_realtor_for_search_engines")
	val useDotRealtorForSearchEngines: Boolean? = null
)

data class BackgroundPhoto(

	@field:SerializedName("href")
	val href: String? = null
)

data class MlsHistoryItem(

	@field:SerializedName("member")
	val member: Member? = null,

	@field:SerializedName("inactivation_date")
	val inactivationDate: String? = null,

	@field:SerializedName("abbreviation")
	val abbreviation: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("primary")
	val primary: Boolean? = null,

	@field:SerializedName("license_number")
	val licenseNumber: String? = null
)

data class Member(

	@field:SerializedName("id")
	val id: String? = null
)

data class Broker(

	@field:SerializedName("accent_color")
	val accentColor: String? = null,

	@field:SerializedName("designations")
	val designations: List<Any?>? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("photo")
	val photo: Photo? = null,

	@field:SerializedName("video")
	val video: String? = null,

	@field:SerializedName("fulfillment_id")
	val fulfillmentId: Int? = null
)

data class ForSalePrice(

	@field:SerializedName("last_listing_date")
	val lastListingDate: String? = null,

	@field:SerializedName("min")
	val min: Int? = null,

	@field:SerializedName("max")
	val max: Int? = null,

	@field:SerializedName("count")
	val count: Int? = null
)

data class MarketingAreaCitiesItem(

	@field:SerializedName("city_state")
	val cityState: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("state_code")
	val stateCode: String? = null
)

data class Photo(

	@field:SerializedName("href")
	val href: String? = null,

	@field:SerializedName("is_zoomed")
	val isZoomed: Boolean? = null
)

data class MlsItem(

	@field:SerializedName("member")
	val member: Member? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("abbreviation")
	val abbreviation: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("primary")
	val primary: Boolean? = null,

	@field:SerializedName("license_number")
	val licenseNumber: String? = null
)

data class DesignationsItem(

	@field:SerializedName("name")
	val name: String? = null
)

data class AgentsItem(

	@field:SerializedName("first_year")
	val firstYear: Int? = null,

	@field:SerializedName("user_languages")
	val userLanguages: List<String?>? = null,

	@field:SerializedName("marketing_area_cities")
	val marketingAreaCities: List<MarketingAreaCitiesItem?>? = null,

	@field:SerializedName("role")
	val role: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("phones")
	val phones: List<PhonesItem?>? = null,

	@field:SerializedName("review_count")
	val reviewCount: Int? = null,

	@field:SerializedName("served_areas")
	val servedAreas: List<ServedAreasItem?>? = null,

	@field:SerializedName("office")
	val office: Office? = null,

	@field:SerializedName("zips")
	val zips: List<String?>? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("has_photo")
	val hasPhoto: Boolean? = null,

	@field:SerializedName("advertiser_id")
	val advertiserId: Int? = null,

	@field:SerializedName("designations")
	val designations: List<DesignationsItem?>? = null,

	@field:SerializedName("agent_rating")
	val agentRating: Int? = null,

	@field:SerializedName("href")
	val href: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("recently_sold")
	val recentlySold: RecentlySold? = null,

	@field:SerializedName("settings")
	val settings: Settings? = null,

	@field:SerializedName("last_updated")
	val lastUpdated: String? = null,

	@field:SerializedName("types")
	val types: String? = null,

	@field:SerializedName("address")
	val address: Address? = null,

	@field:SerializedName("specializations")
	val specializations: List<SpecializationsItem?>? = null,

	@field:SerializedName("for_sale_price")
	val forSalePrice: ForSalePrice? = null,

	@field:SerializedName("languages")
	val languages: List<Any?>? = null,

	@field:SerializedName("photo")
	val photo: Photo? = null,

	@field:SerializedName("feed_licenses")
	val feedLicenses: List<Any?>? = null,

	@field:SerializedName("person_name")
	val personName: String? = null,

	@field:SerializedName("nrds_id")
	val nrdsId: String? = null,

	@field:SerializedName("broker")
	val broker: Broker? = null,

	@field:SerializedName("recommendations_count")
	val recommendationsCount: Int? = null,

	@field:SerializedName("agent_type")
	val agentType: List<String?>? = null,

	@field:SerializedName("agent_team_details")
	val agentTeamDetails: AgentTeamDetails? = null,

	@field:SerializedName("is_realtor")
	val isRealtor: Boolean? = null,

	@field:SerializedName("first_month")
	val firstMonth: Int? = null,

	@field:SerializedName("full_name")
	val fullName: String? = null,

	@field:SerializedName("web_url")
	val webUrl: String? = null,

	@field:SerializedName("mls")
	val mls: List<MlsItem?>? = null,

	@field:SerializedName("nick_name")
	val nickName: String? = null,

	@field:SerializedName("party_id")
	val partyId: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("nar_only")
	val narOnly: Int? = null,

	@field:SerializedName("background_photo")
	val backgroundPhoto: BackgroundPhoto? = null,

	@field:SerializedName("slogan")
	val slogan: String? = null,

	@field:SerializedName("video")
	val video: String? = null,

	@field:SerializedName("mls_history")
	val mlsHistory: List<Any?>? = null,

	@field:SerializedName("first_name")
	val firstName: String? = null,

	@field:SerializedName("last_name")
	val lastName: String? = null
)
