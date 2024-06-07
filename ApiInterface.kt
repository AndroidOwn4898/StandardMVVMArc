package com.reliefallapp.network.repository

import LoginBannerListModel
import android.util.ArrayMap
import com.reliefallapp.model.CategoryListModel
import com.reliefallapp.model.CountryListModel
import com.reliefallapp.model.HomeWeekListModel
import com.reliefallapp.model.LanguageModel
import com.reliefallapp.model.ProfileDocumentModel
import com.reliefallapp.model.ProfileList
import com.reliefallapp.model.ProvinceListModel
import com.reliefallapp.model.SkillModel
import com.reliefallapp.model.SoftwareModel
import com.reliefallapp.model.StaffSlotListModel
import com.reliefallapp.model.SupportHistoryListModel
import com.reliefallapp.model.SupportListModel
import com.reliefallapp.model.UploadDocumentModel
import com.reliefallapp.model.UserData
import com.reliefallapp.model.UserDetails
import com.reliefallapp.model.VerificationData
import com.reliefallapp.network.CommonResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.PartMap
import retrofit2.http.Query

interface ApiInterface {

    @FormUrlEncoded
    @POST("beforeauth/login")
    fun userLogin(@FieldMap request: ArrayMap<String, Any>): Call<CommonResponse<UserData>>

    @POST("afterauth/update-device-token")
    fun updateDeviceToken(): Call<CommonResponse<Any>>

    @POST("beforeauth/country-list")
    fun getCountryList(): Call<CommonResponse<CountryListModel>>

    @POST("beforeauth/get-banner")
    fun getLoginBanner(): Call<CommonResponse<LoginBannerListModel>>

    @POST("afterauth/get-user")
    fun getUserDetails(): Call<CommonResponse<UserDetails>>

    @FormUrlEncoded
    @POST("afterauth/logout")
    fun logout(@FieldMap request: ArrayMap<String, String>): Call<CommonResponse<Any>>

    @FormUrlEncoded
    @POST("beforeauth/verification")
    fun emailVerification(@FieldMap request: ArrayMap<String, String>): Call<CommonResponse<Any>>

    @FormUrlEncoded
    @POST("beforeauth/verification")
    fun verificationMobile(@FieldMap request: ArrayMap<String, String>): Call<CommonResponse<VerificationData>>

    @FormUrlEncoded
    @POST("beforeauth/verification")
    fun verificationEmail(@FieldMap request: ArrayMap<String, String>): Call<CommonResponse<Any>>

    @FormUrlEncoded
    @POST("beforeauth/reset-password")
    fun resetPassword(@FieldMap request: ArrayMap<String, String>): Call<CommonResponse<Any>>

    @POST("shiftauth/get-date-shift-publisher")
    fun getOwnerDateShiftList(@Query("shift_date") date: String): Call<CommonResponse<StaffSlotListModel>>


    @POST("shiftauth/get-week-shift-serviceprovider")
    fun getWeekShiftList(): Call<CommonResponse<HomeWeekListModel>>

    @POST("shiftauth/get-week-shift-publisher")
    fun getOwnerWeekShiftList(): Call<CommonResponse<HomeWeekListModel>>

    @POST("shiftauth/get-home-shift-serviceprovider")
    fun getMonthShiftList(@Query("shift_month") month: String): Call<CommonResponse<HomeWeekListModel>>

    @POST("shiftauth/get-home-shift-publisher")
    fun getOwnerMonthShiftList(@Query("shift_month") month: String): Call<CommonResponse<HomeWeekListModel>>

    @FormUrlEncoded
    @POST("beforeauth/signup")
    fun signup(@FieldMap request: ArrayMap<String, Any>): Call<CommonResponse<UserData>>

    @POST("afterauth/get-profile")
    fun getProfile(): Call<CommonResponse<ProfileList>>

    @POST("beforeauth/province-list")
    fun getProvince(@Query("country_id") countryId: String): Call<CommonResponse<ProvinceListModel>>

    @POST("afterauth/category-list")
    fun getCategory(
        @Query("category_type") categoryType: String,
        @Query("province_id") provinceId: String,
        @Query("module_id") moduleId: String
    ): Call<CommonResponse<CategoryListModel>>

    @FormUrlEncoded
    @POST("afterauth/add-profile")
    fun addOwnerProfile(@FieldMap request: ArrayMap<String, Any>): Call<CommonResponse<Any>>

    @FormUrlEncoded
    @POST("afterauth/edit-profile")
    fun editProfile(@FieldMap request: ArrayMap<String, Any>): Call<CommonResponse<Any>>

    @POST("afterauth/language-list")
    fun getLanguageList(@Query("category_id") categoryId: String): Call<CommonResponse<LanguageModel>>

    @POST("afterauth/software-list")
    fun getSoftwareList(@Query("category_id") categoryId: String): Call<CommonResponse<SoftwareModel>>

    @POST("afterauth/skill-list")
    fun getSkillList(@Query("category_id") categoryId: String): Call<CommonResponse<SkillModel>>

    @FormUrlEncoded
    @POST("s3bucketauth/get-document")
    fun getDocument(@FieldMap request: ArrayMap<String, Any>): Call<CommonResponse<ProfileDocumentModel>>

    @Multipart
    @POST("s3bucketauth/upload-file")
    fun uploadFile(
        @PartMap request: HashMap<String, RequestBody>?,
        @Part imageFile: MultipartBody.Part?,
    ): Call<CommonResponse<UploadDocumentModel>>

    @FormUrlEncoded
    @POST("s3bucketauth/save-file")
    fun saveFile(@FieldMap request: ArrayMap<String, Any>): Call<CommonResponse<ProfileDocumentModel>>

    @POST("shiftauth/get-date-shift-serviceprovider")
    fun getShiftServiceProviderData(@Query("shift_year") shiftYear: String): Call<CommonResponse<StaffSlotListModel>>

    @FormUrlEncoded
    @POST("beforeauth/support")
    fun helpSupport(@FieldMap request: ArrayMap<String, String>): Call<CommonResponse<Any>>

    @FormUrlEncoded
    @POST("afterauth/support")
    fun categoryNotList(@FieldMap request: ArrayMap<String, String>): Call<CommonResponse<Any>>

    @FormUrlEncoded
    @POST("afterauth/capture")
    fun takeScreenShoot(@FieldMap request: ArrayMap<String, String>): Call<CommonResponse<Any>>

    @POST("afterauth/get-support-list")
    fun getSupportList(): Call<CommonResponse<SupportListModel>>

    @FormUrlEncoded
    @POST("afterauth/get-support-history")
    fun getSupportHistoryList(@FieldMap request: ArrayMap<String, String>): Call<CommonResponse<SupportHistoryListModel>>

    @FormUrlEncoded
    @POST("afterauth/support")
    fun addSupportTicket(@FieldMap request: ArrayMap<String, String>): Call<CommonResponse<Any>>

    @FormUrlEncoded
    @POST("afterauth/add-support-history")
    fun addSupportHistory(@FieldMap request: ArrayMap<String, String>): Call<CommonResponse<Any>>

}

