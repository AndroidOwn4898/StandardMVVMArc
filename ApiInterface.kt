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

    @POST("beforeauth/country-list")
    fun getCountryList(): Call<CommonResponse<CountryListModel>>

    @FormUrlEncoded
    @POST("beforeauth/verification")
    fun emailVerification(@FieldMap request: ArrayMap<String, String>): Call<CommonResponse<Any>>


    @POST("afterauth/category-list")
    fun getCategory(
        @Query("category_type") categoryType: String,
        @Query("province_id") provinceId: String,
        @Query("module_id") moduleId: String
    ): Call<CommonResponse<CategoryListModel>>

  
}

