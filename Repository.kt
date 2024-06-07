package com.reliefallapp.network.repository

import LoginBannerListModel
import android.util.ArrayMap
import androidx.lifecycle.LiveData
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
import com.reliefallapp.network.APIError
import com.reliefallapp.network.ApiClient
import com.reliefallapp.network.ApiClientWithOutAuth
import com.reliefallapp.network.CommonResponse
import com.reliefallapp.network.Resource
import com.reliefallapp.network.dataApi
import com.reliefallapp.network.getResult
import kotlinx.coroutines.CoroutineScope
import okhttp3.MultipartBody
import okhttp3.RequestBody

object Repository {

    fun CoroutineScope.nursingLogin(request: ArrayMap<String, Any>): LiveData<Resource<CommonResponse<UserData>, APIError>> =
        dataApi {
            // get data from network
            fromNetwork {
                ApiClientWithOutAuth.service.userLogin(request).getResult()
            }
        }


    fun CoroutineScope.getCountryList(): LiveData<Resource<CommonResponse<CountryListModel>, APIError>> =
        dataApi {
            // get data from network
            fromNetwork {
                ApiClientWithOutAuth.service.getCountryList().getResult()
            }
        }


    fun CoroutineScope.emailVerification(request: ArrayMap<String, String>): LiveData<Resource<CommonResponse<Any>, APIError>> =
        dataApi {
            // get data from network
            fromNetwork {
                ApiClientWithOutAuth.service.emailVerification(request).getResult()
            }
        }


    fun CoroutineScope.getCategory(
        categoryType: String,
        provinceId: String,
        moduleId: String
    ): LiveData<Resource<CommonResponse<CategoryListModel>, APIError>> =
        dataApi {
            // get data from network
            fromNetwork {
                ApiClient.service.getCategory(categoryType, provinceId, moduleId).getResult()
            }
        }
        
   /*

     fun getCategoryList(categoryType : String, provinceId : String, moduleId : String) = with(Repository) {
        getCategory(categoryType,provinceId,moduleId)
    }

    fun addOwner(request: ArrayMap<String, Any>) = with(Repository) {
        addOwnerProfile(request)
    }

    */

}

