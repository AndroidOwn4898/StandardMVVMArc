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

    fun CoroutineScope.updateDeviceToken(): LiveData<Resource<CommonResponse<Any>, APIError>> =
        dataApi {
            // get data from network
            fromNetwork {
                ApiClient.service.updateDeviceToken().getResult()
            }
        }


    fun CoroutineScope.getCountryList(): LiveData<Resource<CommonResponse<CountryListModel>, APIError>> =
        dataApi {
            // get data from network
            fromNetwork {
                ApiClientWithOutAuth.service.getCountryList().getResult()
            }
        }

    fun CoroutineScope.getLoginBanner(): LiveData<Resource<CommonResponse<LoginBannerListModel>, APIError>> =
        dataApi {
            // get data from network
            fromNetwork {
                ApiClientWithOutAuth.service.getLoginBanner().getResult()
            }
        }

    fun CoroutineScope.getUserDetails(): LiveData<Resource<CommonResponse<UserDetails>, APIError>> =
        dataApi {
            // get data from network
            fromNetwork {
                ApiClient.service.getUserDetails().getResult()
            }
        }


    fun CoroutineScope.logout(request: ArrayMap<String, String>): LiveData<Resource<CommonResponse<Any>, APIError>> =
        dataApi {
            // get data from network
            fromNetwork {
                ApiClient.service.logout(request).getResult()
            }
        }

    fun CoroutineScope.emailVerification(request: ArrayMap<String, String>): LiveData<Resource<CommonResponse<Any>, APIError>> =
        dataApi {
            // get data from network
            fromNetwork {
                ApiClientWithOutAuth.service.emailVerification(request).getResult()
            }
        }

    fun CoroutineScope.resetPassword(request: ArrayMap<String, String>): LiveData<Resource<CommonResponse<Any>, APIError>> =
        dataApi {
            // get data from network
            fromNetwork {
                ApiClientWithOutAuth.service.resetPassword(request).getResult()
            }
        }

    fun CoroutineScope.getOwnerDateShiftList(date:String): LiveData<Resource<CommonResponse<StaffSlotListModel>, APIError>> =
        dataApi {
            // get data from network
            fromNetwork {
                ApiClient.service.getOwnerDateShiftList(date).getResult()
            }
        }

    fun CoroutineScope.getWeekShiftList(): LiveData<Resource<CommonResponse<HomeWeekListModel>, APIError>> =
        dataApi {
            // get data from network
            fromNetwork {
                ApiClient.service.getWeekShiftList().getResult()
            }
        }

    fun CoroutineScope.getOwnerWeekShiftList(): LiveData<Resource<CommonResponse<HomeWeekListModel>, APIError>> =
        dataApi {
            // get data from network
            fromNetwork {
                ApiClient.service.getOwnerWeekShiftList().getResult()
            }
        }

    fun CoroutineScope.getMonthShiftList(month: String): LiveData<Resource<CommonResponse<HomeWeekListModel>, APIError>> =
        dataApi {
            // get data from network
            fromNetwork {
                ApiClient.service.getMonthShiftList(month).getResult()
            }
        }

    fun CoroutineScope.getOwnerMonthShiftList(month: String): LiveData<Resource<CommonResponse<HomeWeekListModel>, APIError>> =
        dataApi {
            // get data from network
            fromNetwork {
                ApiClient.service.getOwnerMonthShiftList(month).getResult()
            }
        }

    fun CoroutineScope.verificationMobile(request: ArrayMap<String, String>): LiveData<Resource<CommonResponse<VerificationData>, APIError>> =
        dataApi {
            // get data from network
            fromNetwork {
                ApiClient.service.verificationMobile(request).getResult()
            }
        }

    fun CoroutineScope.verificationEmail(request: ArrayMap<String, String>): LiveData<Resource<CommonResponse<Any>, APIError>> =
        dataApi {
            // get data from network
            fromNetwork {
                ApiClient.service.verificationEmail(request).getResult()
            }
        }

    fun CoroutineScope.signup(request: ArrayMap<String, Any>): LiveData<Resource<CommonResponse<UserData>, APIError>> =
        dataApi {
            // get data from network
            fromNetwork {
                ApiClient.service.signup(request).getResult()
            }
        }

    fun CoroutineScope.getProfile(): LiveData<Resource<CommonResponse<ProfileList>, APIError>> =
        dataApi {
            // get data from network
            fromNetwork {
                ApiClient.service.getProfile().getResult()
            }
        }

    fun CoroutineScope.getProvince(countryId: String): LiveData<Resource<CommonResponse<ProvinceListModel>, APIError>> =
        dataApi {
            // get data from network
            fromNetwork {
                ApiClient.service.getProvince(countryId).getResult()
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

    fun CoroutineScope.addOwnerProfile(request: ArrayMap<String, Any>): LiveData<Resource<CommonResponse<Any>, APIError>> =
        dataApi {
            // get data from network
            fromNetwork {
                ApiClient.service.addOwnerProfile(request).getResult()
            }
        }

    fun CoroutineScope.editProfile(request: ArrayMap<String, Any>): LiveData<Resource<CommonResponse<Any>, APIError>> =
        dataApi {
            // get data from network
            fromNetwork {
                ApiClient.service.editProfile(request).getResult()
            }
        }

    fun CoroutineScope.getLanguageList(categoryId: String): LiveData<Resource<CommonResponse<LanguageModel>, APIError>> =
        dataApi {
            // get data from network
            fromNetwork {
                ApiClient.service.getLanguageList(categoryId).getResult()
            }
        }

    fun CoroutineScope.getSoftwareList(categoryId: String): LiveData<Resource<CommonResponse<SoftwareModel>, APIError>> =
        dataApi {
            // get data from network
            fromNetwork {
                ApiClient.service.getSoftwareList(categoryId).getResult()
            }
        }

    fun CoroutineScope.getSkillList(categoryId: String): LiveData<Resource<CommonResponse<SkillModel>, APIError>> =
        dataApi {
            // get data from network
            fromNetwork {
                ApiClient.service.getSkillList(categoryId).getResult()
            }
        }

    fun CoroutineScope.getProfileDocuments(request: ArrayMap<String, Any>): LiveData<Resource<CommonResponse<ProfileDocumentModel>, APIError>> =
        dataApi {
            // get data from network
            fromNetwork {
                ApiClient.service.getDocument(request).getResult()
            }
        }

    fun CoroutineScope.uploadFile(
        request: HashMap<String, RequestBody>?,
        imageFile: MultipartBody.Part?
    ): LiveData<Resource<CommonResponse<UploadDocumentModel>, APIError>> =
        dataApi {
            // get data from network
            fromNetwork {
                ApiClient.service.uploadFile(request, imageFile).getResult()
            }
        }

    fun CoroutineScope.saveFile(request: ArrayMap<String, Any>): LiveData<Resource<CommonResponse<ProfileDocumentModel>, APIError>> =
        dataApi {
            // get data from network
            fromNetwork {
                ApiClient.service.saveFile(request).getResult()
            }
        }

    fun CoroutineScope.getShiftServiceProviderData(shiftYear :String): LiveData<Resource<CommonResponse<StaffSlotListModel>, APIError>> =
        dataApi {
            // get data from network
            fromNetwork {
                ApiClient.service.getShiftServiceProviderData(shiftYear).getResult()
            }
        }

    fun CoroutineScope.helpSupport(request: ArrayMap<String, String>): LiveData<Resource<CommonResponse<Any>, APIError>> =
        dataApi {
            // get data from network
            fromNetwork {
                ApiClientWithOutAuth.service.helpSupport(request).getResult()
            }
        }

    fun CoroutineScope.categoryNotList(request: ArrayMap<String, String>): LiveData<Resource<CommonResponse<Any>, APIError>> =
        dataApi {
            // get data from network
            fromNetwork {
                ApiClient.service.categoryNotList(request).getResult()
            }
        }

    fun CoroutineScope.takeScreenShoot(request: ArrayMap<String, String>): LiveData<Resource<CommonResponse<Any>, APIError>> =
        dataApi {
            // get data from network
            fromNetwork {
                ApiClient.service.takeScreenShoot(request).getResult()
            }
        }

    fun CoroutineScope.getSupportList(): LiveData<Resource<CommonResponse<SupportListModel>, APIError>> =
        dataApi {
            // get data from network
            fromNetwork {
                ApiClient.service.getSupportList().getResult()
            }
        }

    fun CoroutineScope.getSupportHistoryList(request: ArrayMap<String, String>): LiveData<Resource<CommonResponse<SupportHistoryListModel>, APIError>> =
        dataApi {
            // get data from network
            fromNetwork {
                ApiClient.service.getSupportHistoryList(request).getResult()
            }
        }

    fun CoroutineScope.addSupportTicket(request: ArrayMap<String, String>): LiveData<Resource<CommonResponse<Any>, APIError>> =
        dataApi {
            // get data from network
            fromNetwork {
                ApiClient.service.addSupportTicket(request).getResult()
            }
        }

    fun CoroutineScope.addSupportHistory(request: ArrayMap<String, String>): LiveData<Resource<CommonResponse<Any>, APIError>> =
        dataApi {
            // get data from network
            fromNetwork {
                ApiClient.service.addSupportHistory(request).getResult()
            }
        }
}

/*fun CoroutineScope.beforeAuthAppLanguages(): LiveData<Resource<CommonResponse<List<Language>>, APIError>> = dataApi {
    // get data from network
    fromNetwork {
        NursingApiClient.service.beforeAuthAppLanguages().getResult()
    }
}


fun CoroutineScope.beforeAuthAppModules(): LiveData<Resource<CommonResponse<List<AppModule>>, APIError>> = dataApi {
    // get data from network
    fromNetwork {
        NursingApiClient.service.getApplicationModules().getResult()
    }
}

fun CoroutineScope.getApplicationCategory(

     moduleId: String?,
     type: String,
     categoryType: String? = "",
     level: String? = "1"
 ): LiveData<Resource<CommonResponse<List<Category>>, APIError>> =
     dataApi {
         // get data from network
         fromNetwork {
             NursingApiClient.service.getCategories(

                 moduleId,
                 type,
                 categoryType,
                 level
             )
                 .getResult()
         }
     }*/

/*  fun CoroutineScope.getStaticPage(
      pageId: String?,

      moduleId: String?
  ): LiveData<Resource<CommonResponse<StaticPage>, APIError>> =
      dataApi {
          // get data from network
          fromNetwork {
              NursingApiClient.service.getStaticPage(pageId,  moduleId).getResult()
          }
      }*//*    fun CoroutineScope.nursingLogin(request: HashMap<String, String>): LiveData<Resource<CommonResponse<List<StaffUserProfile>>, APIError>> = dataApi {
           // get data from network
           fromNetwork {
               ApiClient.service.nursingLogin(request).getResult()
           }
       }

      fun CoroutineScope.getOtherCertificate(authKey: String?): LiveData<Resource<CommonResponse<List<OtherCertificate>>, APIError>> = dataApi {
           fromNetwork {
               NursingApiClient.service.getOtherCertificate(authKey).getResult()
           }
       }

       fun CoroutineScope.verifyEmailAddress(moduleId: String?, type: String?, email: String?, loginWith: String?, uniqueId: String?, socialId: String?): LiveData<Resource<CommonResponse<List<RegistrationStep>>, APIError>> = dataApi {
           // get data from network
           fromNetwork {
               ApiClient.service.verifyEmailAddress(moduleId, type, email, loginWith, uniqueId, socialId).getResult()
           }
       }*/


/*    fun CoroutineScope.verifyVerificationCode(authkey: String?, emailVerificationCode: String?): LiveData<Resource<CommonResponse<List<RegistrationStep>>, APIError>> = dataApi {
        // get data from network
        fromNetwork {
            ApiClient.service.verifyVerificationCode(authkey, emailVerificationCode).getResult()
        }
    }


    fun CoroutineScope.nursingWorkStepOne(request: HashMap<String, String>): LiveData<Resource<CommonResponse<List<RegistrationStep>>, APIError>> = dataApi {
        // get data from network
        fromNetwork {
            ApiClient.service.nursingWorkStepOne(request).getResult()
        }
    }

    fun CoroutineScope.nursingWorkStepTwo(request: HashMap<String, RequestBody>): LiveData<Resource<CommonResponse<List<RegistrationStep>>, APIError>> = dataApi {
        // get data from network
        fromNetwork {
            ApiClient.service.nursingWorkStepTwo(request).getResult()
        }
    }

    fun CoroutineScope.nursingOwnerStepTwo(request: HashMap<String, String>): LiveData<Resource<CommonResponse<List<NursingRegistrationStep>>, APIError>> = dataApi {
        // get data from network
        fromNetwork {
            NursingApiClient.service.nursingOwnerStepTwo(request).getResult()
        }
    }*//*
    fun CoroutineScope.nursingWorkStepThree(authKey: String?, workExperience: String?): LiveData<Resource<CommonResponse<List<NursingRegistrationStep>>, APIError>> = dataApi {
        // get data from network
        fromNetwork {
            NursingApiClient.service.nursingWorkStepThree(authKey, workExperience).getResult()
        }
    }

    fun CoroutineScope.nursingWorkStepFour(request: HashMap<String, RequestBody>): LiveData<Resource<CommonResponse<List<NursingRegistrationStep>>, APIError>> = dataApi {
        // get data from network
        fromNetwork {
            NursingApiClient.service.nursingWorkStepFour(request).getResult()
        }
    }


    fun CoroutineScope.nursingWorkStepFive(request: HashMap<String, String>): LiveData<Resource<CommonResponse<List<NursingRegistrationStep>>, APIError>> = dataApi {
        // get data from network
        fromNetwork {
            NursingApiClient.service.nursingWorkStepFive(request).getResult()
        }
    }


    fun CoroutineScope.nursingWorkStepSix(authKey: String?, questions: String?): LiveData<Resource<CommonResponse<List<NursingRegistrationStep>>, APIError>> = dataApi {
        // get data from network
        fromNetwork {
            NursingApiClient.service.nursingWorkStepSix(authKey, questions).getResult()
        }
    }


    fun CoroutineScope.nursingWorkStepSeven(authKey: String?, questions: String?, deviceToken: String): LiveData<Resource<CommonResponse<List<NursingRegistrationStep>>, APIError>> = dataApi {
        // get data from network
        fromNetwork {
            NursingApiClient.service.nursingWorkStepSeven(authKey, questions, deviceToken).getResult()
        }
    }

   fun CoroutineScope.getTypeOfEstablishment(authKey: String): LiveData<Resource<CommonResponse<List<NursingEstablishment>>, APIError>> = dataApi {
        // get data from network
        fromNetwork {
            NursingApiClient.service.getTypeOfEstablishment(authKey).getResult()
        }
    }

    fun CoroutineScope.getDepartmentOrSpecialities(authKey: String, categoryId: String): LiveData<Resource<CommonResponse<List<NursingDepartmentSpecialities>>, APIError>> = dataApi {
        // get data from network
        fromNetwork {
            NursingApiClient.service.getDepartmentOrSpecialities(authKey, categoryId).getResult()
        }
    }

    fun CoroutineScope.getDentalStaffSoftwareList(authKey: String?, categoryId: String?): LiveData<Resource<CommonResponse<List<DentalStaffSoftware>>, APIError>> = dataApi {
        fromNetwork {
            NursingApiClient.service.getDentalStaffSoftwareList(authKey, categoryId).getResult()
        }
    }

    fun CoroutineScope.getUserParkingList(authKey: String?, categoryId: String?): LiveData<Resource<CommonResponse<List<UserParking>>, APIError>> = dataApi {
        fromNetwork {
            NursingApiClient.service.getUserParking(authKey, categoryId).getResult()
        }
    }

    fun CoroutineScope.getUserTypeRadioGraphList(authKey: String?, categoryId: String?): LiveData<Resource<CommonResponse<List<UserTypeRadioGraph>>, APIError>> = dataApi {
        fromNetwork {
            NursingApiClient.service.getRadioGraph(authKey, categoryId).getResult()
        }
    }

    fun CoroutineScope.getUserTypeUltraSonicList(authKey: String?, categoryId: String?): LiveData<Resource<CommonResponse<List<UserTypeUltraSonic>>, APIError>> = dataApi {
        fromNetwork {
            NursingApiClient.service.getUltraSonic(authKey, categoryId).getResult()
        }
    }

    fun CoroutineScope.getCharting(authKey: String?, categoryId: String?): LiveData<Resource<CommonResponse<List<UserCharting>>, APIError>> = dataApi {
        fromNetwork {
            NursingApiClient.service.getCharting(authKey, categoryId).getResult()
        }
    }*/

/*    fun CoroutineScope.getDentalStaffExpertise(authKey: String?, categoryId: String?): LiveData<Resource<CommonResponse<List<DentalStaffExpertise>>, APIError>> = dataApi {
        fromNetwork {
            NursingApiClient.service.getDentalStaffExpertiseList(authKey, categoryId).getResult()
        }
    }

    fun CoroutineScope.getAppProvince(authKey: String, type: String): LiveData<Resource<CommonResponse<List<Province>>, APIError>> = dataApi {
        // get data from network
        fromNetwork {
            NursingApiClient.service.getAppProvince(authKey, type).getResult()
        }
    }


    fun CoroutineScope.getUserLanguages(authKey: String, ownerUserId: String?): LiveData<Resource<CommonResponse<List<UserLanguage>>, APIError>> = dataApi {
        // get data from network
        fromNetwork {
            NursingApiClient.service.getUserLanguages(authKey, ownerUserId).getResult()
        }
    }*/


/* fun CoroutineScope.getNursingQuestions(authKey: String, step: String): LiveData<Resource<CommonResponse<List<NursingQuestion>>, APIError>> = dataApi {
     // get data from network
     fromNetwork {
         NursingApiClient.service.getNursingUserQuestions(authKey, step).getResult()
     }
 }*/


/* fun CoroutineScope.nursingLogin(request: HashMap<String, String>): LiveData<Resource<CommonResponse<List<NursingUserProfile>>, APIError>> =
     dataApi {
         // get data from network
         fromNetwork {
             NursingApiClient.service.nursingLogin(request).getResult()
         }
     }
*/

/* fun CoroutineScope.getNursingUserProfile(
     authKey: String?,
     languageId: String?
 ): LiveData<Resource<CommonResponse<NursingUserProfile>, APIError>> =
     dataApi {
         // get data from network
         fromNetwork {
             NursingApiClient.service.getNursingProfile(authKey, languageId).getResult()
         }
     }*/

/*   fun CoroutineScope.updateNursingUserProfile(request: HashMap<String, String>?): LiveData<Resource<CommonResponse<Any>, APIError>> = dataApi {
       fromNetwork {
           ApiClient.service.nursingUpdateProfile(request).getResult()
       }
   }

   fun CoroutineScope.updateNursingUserProfileBody(request: HashMap<String, String>?): LiveData<Resource<CommonResponse<Any>, APIError>> = dataApi {
       fromNetwork {
           ApiClient.service.nursingUpdateProfileBody(request).getResult()
       }
   }*/

/*fun CoroutineScope.updateNursingUserDocument(request: HashMap<String, String>?): LiveData<Resource<CommonResponse<UploadDocuments>, APIError>> = dataApi {
    fromNetwork {
        ApiClient.service.nursingUpdateUserDocument(request).getResult()
    }
}*/

/*
    fun CoroutineScope.updateNursingUserProfileModule(authKey: String?, dataType: String?, dataValue: String?, ownerUserId: String? = ""): LiveData<Resource<CommonResponse<Any>, APIError>> = dataApi {
        fromNetwork {
            ApiClient.service.nursingUpdateProfileModule(authKey, dataType, dataValue, ownerUserId).getResult()
        }
    }*/


/*    fun CoroutineScope.nursingAddOwnerCompany(request: HashMap<String, String>): LiveData<Resource<CommonResponse<List<NursingRegistrationStep>>, APIError>> = dataApi {
        // get data from network
        fromNetwork {
            NursingApiClient.service.nursingAddOwnerCompany(request).getResult()
        }
    }*/


/*    fun CoroutineScope.nursingAddOwnerSlot(request: HashMap<String, RequestBody>): LiveData<Resource<CommonResponse<Any>, APIError>> = dataApi {
        // get data from network
        fromNetwork {
            ApiClient.service.nursingAddSlot(request).getResult()
        }
    }

    fun CoroutineScope.nursingUpdateOwnerSlot(request: HashMap<String, RequestBody>): LiveData<Resource<CommonResponse<Any>, APIError>> = dataApi {
        // get data from network
        fromNetwork {
            ApiClient.service.nursingUpdateSlot(request).getResult()
        }
    }


    fun CoroutineScope.nursingLogout(authKey: String?, deviceToken: String?): LiveData<Resource<Any, APIError>> = dataApi {
        fromNetwork {
            ApiClient.service.nursingLogout(authKey, deviceToken).getResult()
        }
    }
*//*   fun CoroutineScope.nursingForgotPassword(
           email: String?,
           moduleId: String
       ): LiveData<Resource<CommonResponse<Any>, APIError>> =
           dataApi {
               fromNetwork {
                   if (AppPref.nursingType == Helper.OWNER) {
                       NursingApiClient.service.nursingForgotPassword(
                           email,
                           Helper.API_OWNER,
                           moduleId
                       ).getResult()
                   } else {
                       NursingApiClient.service.nursingForgotPassword(
                           email,
                           Helper.API_STAFF,
                           moduleId
                       ).getResult()
                   }

               }
           }*/

/* fun CoroutineScope.nursingCheckVersion(request: HashMap<String, RequestBody>): LiveData<Resource<CommonResponse<SlotReview>, APIError>> =
     dataApi {
         fromNetwork {
             NursingApiClient.service.nursingCheckVersion(request).getResult()
         }
     }*/


/* fun CoroutineScope.nursingChangePassword(authKey: String?, currentPassword: String?, currentPasswordKey: String?, password: String?, passwordKey: String?): LiveData<Resource<CommonResponse<AuthKey>, APIError>> = dataApi {
     fromNetwork {
         NursingApiClient.service.nursingChangePassword(authKey, currentPassword, currentPasswordKey, password, passwordKey).getResult()
     }
 }*/

/*    fun CoroutineScope.nursingStaffAddAvailability(request: HashMap<String, RequestBody>): LiveData<Resource<CommonResponse<Any>, APIError>> = dataApi {
        // get data from network
        fromNetwork {
            ApiClient.service.nursingStaffAddAvailability(request).getResult()
        }
    }

    fun CoroutineScope.nursingStaffUpdateAvailability(request: HashMap<String, RequestBody>): LiveData<Resource<CommonResponse<Any>, APIError>> = dataApi {
        // get data from network
        fromNetwork {
            ApiClient.service.updateNursingStaffAvailability(request).getResult()
        }
    }*/


/*   fun CoroutineScope.getNursingStaffAvailability(authKey: String?): LiveData<Resource<CommonResponse<NursingStaffAvailability>, APIError>> = dataApi {
       // get data from network
       fromNetwork {
           NursingApiClient.service.getNursingStaffAvailability(authKey).getResult()
       }
   }

   fun CoroutineScope.getNursingStaffHomeDetails(request: HashMap<String, RequestBody>): LiveData<Resource<CommonResponse<NursingStaffSlot>, APIError>> = dataApi {
       // get data from network
       fromNetwork {
           NodeApiClient.service.getNursingStaffHomeDetails(request).getResult()
       }
   }
*/


/* fun CoroutineScope.getNursingStaffAvailableSlotList(
     authKey: String?,
     date: String?,
     page: Int?
 ): LiveData<Resource<CommonResponse<NursingSlotData>, APIError>> =
     dataApi {
         // get data from network
         fromNetwork {
             NursingApiClient.service.getNursingStaffAvailableSlotList(
                 authKey, date, page,
                 getDeviceLanguageId()
             )
                 .getResult()
         }
     }*/

/*     fun CoroutineScope.nursingApplyStaffSlot(request: HashMap<String, RequestBody>): LiveData<Resource<CommonResponse<Any>, APIError>> = dataApi {
     // get data from network
     fromNetwork {
         ApiClient.service.nursingStaffApplySlot(request).getResult()
     }
 }

fun CoroutineScope.cancelAppliedStaffSlot(authKey: String?, slotId: String?): LiveData<Resource<CommonResponse<Any>, APIError>> = dataApi {
        // get data from network
        fromNetwork {
            ApiClient.service.cancelAppliedStaffSlot(authKey, slotId).getResult()
        }
    }


    fun CoroutineScope.getNursingOwnerAppliedSlotData(authKey: String?, slotId: String?): LiveData<Resource<CommonResponse<NursingAppliedDetails>, APIError>> = dataApi {
        // get data from network
        fromNetwork {
            NursingApiClient.service.getNursingOwnerAppliedSlotData(authKey, slotId).getResult()
        }
    }


    fun CoroutineScope.confirmNursingOwnerAppliedSlot(authKey: String?, appliedId: String?, accommodationAddress: String?): LiveData<Resource<CommonResponse<Any>, APIError>> = dataApi {
        // get data from network
        fromNetwork {
            ApiClient.service.confirmNursingOwnerAppliedSlot(authKey, appliedId, accommodationAddress).getResult()
        }
    }


 fun CoroutineScope.deleteNursingOwnerSlot(authKey: String?, slotId: String?, list: String?): LiveData<Resource<CommonResponse<Any>, APIError>> = dataApi {
     // get data from network
     fromNetwork {
         ApiClient.service.deleteNursingOwnerSlot(authKey, slotId, list).getResult()
     }
 }

 fun CoroutineScope.cancelNursingOwnerAppliedSlot( appliedId: String): LiveData<Resource<CommonResponse<Any>, APIError>> = dataApi {
     // get data from network
     fromNetwork {
         NodeApiClient.service.ownerRemoveFromAppliedSlot(appliedId).getResult()
     }
 }

fun CoroutineScope.getSingleSlotsDetails(
    authKey: String?,
    slotId: String?
): LiveData<Resource<CommonResponse<StaffSlotDetails>, APIError>> =
    dataApi {
        fromNetwork {
            NursingApiClient.service.getSingleSlotsDetails(authKey, slotId).getResult()
        }
    }
*//*   fun CoroutineScope.getNursingStaffSlotHistory(authKey: String?): LiveData<Resource<CommonResponse<List<StaffSlotHistory>>, APIError>> =
           dataApi {
               fromNetwork {
                   NursingApiClient.service.getNursingStaffSlotHistory(authKey)
                       .getResult()
               }
           }

       fun CoroutineScope.getNursingOwnerSlotHistory(authKey: String?): LiveData<Resource<CommonResponse<List<OwnerSlotHistory>>, APIError>> = dataApi {
           fromNetwork {
               NursingApiClient.service.getNursingOwnerSlotHistory(authKey).getResult()
           }
       }

       fun CoroutineScope.getNursingNotifications(authKey: String?): LiveData<Resource<CommonResponse<NursingNotification>, APIError>> = dataApi {
           fromNetwork {
               NursingApiClient.service.getNursingNotifications(authKey).getResult()
           }
       }*/


/* fun CoroutineScope.readNursingNotifications(authKey: String?, notificationId: String?): LiveData<Resource<CommonResponse<Any>, APIError>> = dataApi {
     fromNetwork {
         NursingApiClient.service.readNursingNotifications(authKey, notificationId).getResult()
     }
 }*/


/*
    fun CoroutineScope.analyticNursingAds(authKey: String?, adId: Int?): LiveData<Resource<CommonResponse<Any>, APIError>> = dataApi {
        fromNetwork {
            NursingApiClient.service.analyticNursingAds(authKey, adId).getResult()
        }
    }
*/

/*fun CoroutineScope.getCardList(authkey: String?): LiveData<Resource<CommonResponse<List<CardData>>, APIError>> = dataApi {
    fromNetwork {
        NursingApiClient.service.ownerGetAllStripeCardList(authkey).getResult()
    }
}

fun CoroutineScope.setDefaultCard(authkey: String?, ownerUserId: String?, cardId: String?): LiveData<Resource<CommonResponse<List<CardData>>, APIError>> = dataApi {
    fromNetwork {
        ApiClient.service.changeDefaultStripeCard(authkey, ownerUserId, cardId).getResult()
    }
}

fun CoroutineScope.deleteCard(authkey: String?, ownerUserId: String?, cardId: String?): LiveData<Resource<CommonResponse<List<CardData>>, APIError>> = dataApi {
    fromNetwork {
        ApiClient.service.ownerDeleteStripeCard(authkey, ownerUserId, cardId).getResult()
    }
}
*//*fun CoroutineScope.savePaymentCard(cvc: String?, authkey: String?, exp_month: String?, exp_year: String?, number: String?, owner_user_id: String?, name: String?): LiveData<Resource<CommonResponse<Any>, APIError>> = dataApi {
        fromNetwork {
            ApiClient.service.ownerAddStripeCard(authkey, owner_user_id, number, exp_month, exp_year, cvc, name).getResult()

        }
    }*/

/*    fun CoroutineScope.nursingDeactiveAccount(authKey: String?): LiveData<Resource<CommonResponse<Any>, APIError>> = dataApi {
        fromNetwork {
            ApiClient.service.deactiveAccount(authKey).getResult()
        }
    }*/

/*  fun CoroutineScope.getNursingFaqList(authKey: String?): LiveData<Resource<CommonResponse<List<FaqData>>, APIError>> = dataApi {
      fromNetwork {
          NursingApiClient.service.getAppFaq(authKey).getResult()
      }
  }
*//*    fun CoroutineScope.nursingGetStaffOwnerList(authKey: String?, page: Int?): LiveData<Resource<CommonResponse<NursingNewChatData>, APIError>> = dataApi {
        fromNetwork {
            NursingApiClient.service.getStaffOwnerList(authKey, page).getResult()
        }
    }*/

/*    fun CoroutineScope.nursingGetRecentListChat(authKey: String?): LiveData<Resource<CommonResponse<NursingRecentChatData>, APIError>> = dataApi {
        fromNetwork {
            NursingApiClient.service.getRecentChatList(authKey).getResult()
        }
    }*/

/*fun CoroutineScope.nursingStaffOwnerChatList(authkey: String?, owner_user_id: String?, staff_user_id: String?, page: String?, quoteChatId: String = ""): LiveData<Resource<CommonResponse<NursingChatList>, APIError>> = dataApi {
    fromNetwork {
        NursingApiClient.service.getStaffOwnerChatList(authkey, owner_user_id, staff_user_id, page, quoteChatId).getResult()
    }
}*/

/*  fun CoroutineScope.nursingGetAdminChatList(request: HashMap<String, RequestBody>): LiveData<Resource<CommonResponse<NursingChatList>, APIError>> = dataApi {
      // get data from network
      fromNetwork {
          NursingApiClient.service.getNursingGetAdminChatlist(request).getResult()
      }
  }*/

/*    fun CoroutineScope.nursingSendMessageChat(request: HashMap<String, String>): LiveData<Resource<CommonResponse<NursingMessageData>, APIError>> = dataApi {
        // get data from network
        fromNetwork {
            NursingApiClient.service.nursingGeneralChatSendMessage(request).getResult()
        }
    }*/


/* fun CoroutineScope.nursingSendMessageToAdmin(request: HashMap<String, String>): LiveData<Resource<CommonResponse<NursingMessageData>, APIError>> = dataApi {
        // get data from network
        fromNetwork {
            NursingApiClient.service.nursingAdminChatSendMessage(request).getResult()
        }
    }
    fun CoroutineScope.nursingSendChatNotification(authKey: String?, type: String?, chat_id: String?, deviceToken: String?, deviceType: String?): LiveData<Resource<CommonResponse<Any>, APIError>> = dataApi {
        fromNetwork {
            NursingApiClient.service.nursingGeneralChatSendNotification(authKey, type, chat_id, deviceToken, deviceType).getResult()
        }
    }*//*
    fun CoroutineScope.nursingChatHelp(authkey: String?, owner_user_id: String?, staff_user_id: String?): LiveData<Resource<CommonResponse<Any>, APIError>> = dataApi {
        fromNetwork {
            ApiClient.service.nursingChatHelp(authkey, owner_user_id, staff_user_id).getResult()
        }
    }


    fun CoroutineScope.adminFeedbackReview(authkey: String?, feedbackId: String?, ratings: String?, comments: String?): LiveData<Resource<CommonResponse<Any>, APIError>> = dataApi {
        fromNetwork {
            ApiClient.service.adminFeedbackReview(authkey, feedbackId, ratings, comments).getResult()
        }
    }


    fun CoroutineScope.nursingSendReaction(request: HashMap<String, RequestBody>): LiveData<Resource<CommonResponse<NursingMessageData>, APIError>> = dataApi {
        // get data from network
        fromNetwork {
            NursingApiClient.service.addReactionsCall(request).getResult()
        }
    }



    fun CoroutineScope.nursingStaffSubmitGoogleReview(authKey: String?, type: String?, submit_type: String?, answer_from: String?): LiveData<Resource<CommonResponse<Any>, APIError>> = dataApi {
        fromNetwork {
            ApiClient.service.nursingStaffSubmitReview(authKey, type, submit_type, answer_from).getResult()
        }
    }*/

/*    fun CoroutineScope.giveNursingStaffSlotReview(authkey: String?, r_skill: Int, r_attire: Int, r_punctuality: Int, slotid: String?, additional_notes: String?): LiveData<Resource<CommonResponse<Any>, APIError>> = dataApi {
        fromNetwork {
            NursingApiClient.service.ownerGiveStaffSlotReview(authkey, r_skill, r_attire, r_punctuality, slotid, additional_notes).getResult()
        }
    }*/

/*    fun CoroutineScope.getOwnerPaymentSlotData(authkey: String?, year: String?): LiveData<Resource<CommonResponse<List<OwnerPaymentModel>>, APIError>> = dataApi {
        fromNetwork {
            NursingApiClient.service.ownerGetPaymentSlotList(authkey, year).getResult()
        }
    }*/

/* fun CoroutineScope.ownerGetFavouriteBlockStaffList(authkey: String?): LiveData<Resource<CommonResponse<List<OwnerFavouriteBlockMetaData>>, APIError>> = dataApi {
     fromNetwork {
         NursingApiClient.service.ownerGetFavouriteBlockStaffList(authkey).getResult()
     }
 }*/

/*    fun CoroutineScope.ownerUnfavStaff(authkey: String?, staffUserId: String?, ownerUserId: String?, type: String?): LiveData<Resource<CommonResponse<Any>, APIError>> = dataApi {
        fromNetwork {
            ApiClient.service.ownerDeleteFavouriteBlockStaff(authkey, staffUserId, ownerUserId, type).getResult()
        }
    }*/

/*    fun CoroutineScope.ownerGetLocumList(authkey: String?, ownerUserId: String?): LiveData<Resource<CommonResponse<List<OwnerLocumList>>, APIError>> = dataApi {
        fromNetwork {
            NursingApiClient.service.ownerGetStaffList(authkey, ownerUserId).getResult()
        }
    }*/

/* fun CoroutineScope.ownerAddToFav(authkey: String?, staffUserId: String?, ownerUserId: String?, type: String?): LiveData<Resource<CommonResponse<Any>, APIError>> = dataApi {
     fromNetwork {
         NursingApiClient.service.ownerAddFavouriteBlockstaff(authkey = authkey, staffUserId = staffUserId, ownerUserId = ownerUserId, type = type).getResult()
     }
 }

 fun CoroutineScope.getGetModifiedSlotDetails(authKey: String?, slotId: String?): LiveData<Resource<CommonResponse<ModificationSlotData>, APIError>> = dataApi {
     fromNetwork {
         NursingApiClient.service.getGetModifiedSlotDetails(authKey, slotId).getResult()
     }
 }

fun CoroutineScope.slotModificationRequestSend(bodyMap: HashMap<String, String>?): LiveData<Resource<CommonResponse<Any>, APIError>> = dataApi {
    fromNetwork {
        ApiClient.service.slotModificationRequestSend(bodyMap).getResult()
    }
}

fun CoroutineScope.staffOwnerAcceptRejectModifiedSlotRequest(authkey: String?, slot_id: String?, changeRequestStatus: String?): LiveData<Resource<CommonResponse<CalendarSync>, APIError>> = dataApi {
    fromNetwork {
        ApiClient.service.staffOwnerAcceptRejectModifiedSlotRequest(authkey, slot_id, changeRequestStatus).getResult()
    }
}
*//*    fun CoroutineScope.staffOwnerCancelModifiedSlotRequest(authkey: String?, slot_id: String?, is_change_request: String?): LiveData<Resource<CommonResponse<Any>, APIError>> = dataApi {
        fromNetwork {
            ApiClient.service.staffOwnerCancelModifiedSlotRequest(authkey, slot_id, is_change_request).getResult()
        }
    }*/


/*fun CoroutineScope.allowSlotModificationPermission(authkey: String?, slot_id: String?): LiveData<Resource<CommonResponse<Any>, APIError>> = dataApi {
    fromNetwork {
        ApiClient.service.allowSlotModificationPermission(authkey, slot_id).getResult()
    }
}
*/

/*fun CoroutineScope.nursingDentalCancelSlotRequest(partMap: HashMap<String, String>?): LiveData<Resource<CommonResponse<Any>, APIError>> = dataApi {
    fromNetwork {
        ApiClient.service.nursingDentalCancelSlotRequest(partMap).getResult()
    }
}*/

/*fun CoroutineScope.changedSlotCancelRequestStatus(bodyMap: HashMap<String, RequestBody>?): LiveData<Resource<CommonResponse<CalendarSync>, APIError>> = dataApi {
    fromNetwork {
        ApiClient.service.nursingDentalChangedSlotCancelRequestStatus(bodyMap).getResult()
    }
}*/

/*fun CoroutineScope.ownerIncreaseHourlyRate(authKey: String?, slotId: String?, ownerHourPrize: String?): LiveData<Resource<CommonResponse<Any>, APIError>> = dataApi {
    fromNetwork {
        ApiClient.service.increaseHourlyRates(authKey, slotId, ownerHourPrize).getResult()
    }
}


fun CoroutineScope.getSlotReview(authKey: String?, slotId: String?): LiveData<Resource<CommonResponse<List<SlotReviewItem>>, APIError>> = dataApi {
    fromNetwork {
        NursingApiClient.service.getSlotReview(authKey, slotId).getResult()
    }
}*/

/*    fun CoroutineScope.setSlotReview(authKey: String?, slot_id: String?, reviewData: String?): LiveData<Resource<CommonResponse<Any>, APIError>> = dataApi {
        fromNetwork {
            ApiClient.service.addSlotReview(authKey, slot_id, reviewData).getResult()
        }
    }*/

/* fun CoroutineScope.getStaffOwnerReview(authKey: String?, staffUserId: String?, ownerUserId: String?): LiveData<Resource<CommonResponse<List<SlotReviewItem>>, APIError>> = dataApi {
     fromNetwork {
         NursingApiClient.service.getStaffOwnerReview(authKey, staffUserId, ownerUserId).getResult()
     }
 }*/

/* fun CoroutineScope.ownerGetAvailableStaff(authkey: String?,
                                           category_id: String?,
                                           owner_user_id: String?,
                                           start_datetime: String?,
                                           end_datetime: String?): LiveData<Resource<CommonResponse<List<OwnerAvailableStaff>>, APIError>> =
         dataApi {
             fromNetwork {
                 NursingApiClient.service.ownerGetAvailableStaff(authkey, category_id, owner_user_id, start_datetime, end_datetime).getResult()
             }
         }*/

/*    fun CoroutineScope.getStaffCalendarEvent(authKey: String?): LiveData<Resource<CommonResponse<List<StaffCalendarEventData>>, APIError>> = dataApi {
        fromNetwork {
            NursingApiClient.service.getStaffCalendarEvent(authKey).getResult()
        }
    }*/

/*   fun CoroutineScope.getSlotHistoryChart(
       authKey: String?
   ): LiveData<Resource<CommonResponse<List<HistoryChart>>, APIError>> =
       dataApi {
           fromNetwork {
               NursingApiClient.service.getSlotHistoryGraph(authKey).getResult()
           }
       }*/

/*    fun CoroutineScope.getSkills(authKey: String, categoryId: String?): LiveData<Resource<CommonResponse<List<AdditionalSkillData>>, APIError>> = dataApi {
        // get data from network
        fromNetwork {
            NursingApiClient.service.getSkills(authKey, categoryId).getResult()
        }
    }*/

/*    fun CoroutineScope.getDataForStaffThree(authKey: String?): LiveData<Resource<CommonResponse<StaffThree>, APIError>> = dataApi {
        fromNetwork {
            NursingApiClient.service.getDataForStaffThree(authKey).getResult()
        }
    }*/

/*    fun CoroutineScope.getProvinceListBeforeAuth(moduleId: String): LiveData<Resource<CommonResponse<List<Province>>, APIError>> = dataApi {
        fromNetwork {

            NursingApiClient.service.getAppProvinceBeforeAuth(moduleId).getResult()
        }
    }*/


/* fun CoroutineScope.getPromoCodeForNursingDental(authKey: String?): LiveData<Resource<CommonResponse<List<NursingDentalDataPromoCodeResponse>>, APIError>> = dataApi {
     fromNetwork {
         NursingApiClient.service.getPromoCodeForNursingDental(authKey).getResult()
     }
 }*/

/*fun CoroutineScope.applyPromoCode(authKey: String?, promoCode: String?): LiveData<Resource<CommonResponse<Any>, APIError>> = dataApi {
    fromNetwork {
        NursingApiClient.service.applyPromoCode(authKey, promoCode).getResult()
    }
}*/

/*fun CoroutineScope.getSlotCancellationQuestionAnswer(authkey: String?, questionType: String?): LiveData<Resource<CommonResponse<List<NursingQuestion>>, APIError>> = dataApi {
    fromNetwork {
        NursingApiClient.service.getSlotCancellationQuestionAnswer(authkey, questionType).getResult()
    }
}

fun CoroutineScope.sendEmailVerify(authKey: String?, email: String?, mode: String?): LiveData<Resource<CommonResponse<EmailVerify>, APIError>> = dataApi {
    fromNetwork {
        ApiClient.service.sendEmailVerify(authKey, email, mode).getResult()
    }
}

fun CoroutineScope.emailVerification(authKey: String?, email_verification_code: String?, email: String?): LiveData<Resource<CommonResponse<Any>, APIError>> = dataApi {
    fromNetwork {
        ApiClient.service.emailVerification(authKey, email_verification_code, email).getResult()
    }
}*/

/* fun CoroutineScope.submitCovidAnswer(authKey: String?, covidAnswer: String?): LiveData<Resource<CommonResponse<Any>, APIError>> = dataApi {
     fromNetwork {
         ApiClient.service.submitAnswer(authKey, covidAnswer).getResult()
     }
 }*/

/* fun CoroutineScope.getCommonReferralData(authkey: String?): LiveData<Resource<CommonResponse<CommonReferralData>, APIError>> = dataApi {
     fromNetwork {
         NursingApiClient.service.getCommonReferralData(authkey).getResult()
     }
 }*/

/*fun CoroutineScope.downloadFile(path: String?): LiveData<Resource<ResponseBody, APIError>> = dataApi {
    fromNetwork {
        ApiClient.service.downloadFile(path).getResult()
    }
}*/

/*    fun CoroutineScope.saveStaffRemainingDetails(authkey: String?, skill: String?, language: String?, institute: String?, graduationYear: String?, experienceYear: String?, diploma: String?): LiveData<Resource<CommonResponse<Any>, APIError>> = dataApi {
        fromNetwork {
            ApiClient.service.saveStaffRemainingDetails(authKey = authkey, skill = skill, language = language, institute = institute, graduationYear = graduationYear, experienceYear = experienceYear, diplomaDegree = diploma).getResult()
        }
    }

    fun CoroutineScope.saveOwnerRemainingDetails(authkey: String?, ownerUserId: String?, language: String?, software: String?, duty: String?, weekdayTraffic: String?, weekendTraffic: String?): LiveData<Resource<CommonResponse<Any>, APIError>> = dataApi {
        fromNetwork {
            ApiClient.service.saveOwnerRemainingDetails(authKey = authkey, ownerUserId = ownerUserId, ownerSoftware = software, language = language, userDuty = duty, weekdayTraffic = weekdayTraffic, weekendTraffic = weekendTraffic).getResult()
        }
    }*/

/*  fun CoroutineScope.getStaffGetSoftwareFilterList(): LiveData<Resource<CommonResponse<List<DentalStaffSoftware>>, APIError>> = dataApi {
      fromNetwork {
          NursingApiClient.service.getStaffSoftwareFilterList().getResult()
      }
  }*/


/*  fun CoroutineScope.sendLateAlert(map: HashMap<String, String>): LiveData<Resource<CommonResponse<Any>, APIError>> = dataApi {
      fromNetwork {
          ApiClient.service.sendLateAlert(map).getResult()
      }
  }*/

/* fun CoroutineScope.getActualDistance(authKey: String?, slotId: String?): LiveData<Resource<CommonResponse<SlotDistance>, APIError>> = dataApi {
     // get data from network
     fromNetwork {
         NursingApiClient.service.getActualDistance(authKey, slotId).getResult()
     }
 }

fun CoroutineScope.confirmSlotEmailSend(authKey: String?, appliedId: String?): LiveData<Resource<CommonResponse<Any>, APIError>> = dataApi {
    // get data from network
    fromNetwork {
        ApiClient.service.confirmSlotEmailSend(authKey, appliedId).getResult()
    }
}
*//* fun CoroutineScope.staffGetFavouriteBlockStaffList(authkey: String?): LiveData<Resource<CommonResponse<StaffFavouriteBlockData>, APIError>> = dataApi {
         fromNetwork {
             NursingApiClient.service.staffGetFavouriteBlockStaffList(authkey).getResult()
         }
     }*/

/*fun CoroutineScope.getStaffPayoutsData(authKey: String?): LiveData<Resource<CommonResponse<List<StaffPayoutHistory>>, APIError>> = dataApi {
   fromNetwork {
       NursingApiClient.service.staffGetPayoutHistory(authKey).getResult()
   }
}

fun CoroutineScope.getStaffT4AData(authKey: String?): LiveData<Resource<CommonResponse<List<StaffT4AHistory>>, APIError>> = dataApi {
    fromNetwork {
        NursingApiClient.service.staffGetT4AHistory(authKey).getResult()
    }
}*/

/* fun CoroutineScope.manageAccessUserList(authKey: String?): LiveData<Resource<CommonResponse<List<ManageAccessListing>>, APIError>> = dataApi {
     fromNetwork {
         NursingApiClient.service.manageAccessUserList(authKey).getResult()
     }
 }*/

/*fun CoroutineScope.userWiseClinicList(authkey: String?, managerId: String?): LiveData<Resource<CommonResponse<List<UserWiseLocationListing>>, APIError>> = dataApi {
    fromNetwork {
        NursingApiClient.service.userWiseClinicList(authkey, managerId).getResult()
    }
}*/

/*    fun CoroutineScope.inviteCollaborator(request: HashMap<String, RequestBody>?): LiveData<Resource<CommonResponse<Any>, APIError>> = dataApi {
       fromNetwork {
           ApiClient.service.inviteCollaborator(request).getResult()
       }
   }

  fun CoroutineScope.revokeAccessManagerLocation(authkey: String?, managerId: String?, clinicId: String?): LiveData<Resource<CommonResponse<Any>, APIError>> = dataApi {
       fromNetwork {
           ApiClient.service.revokeAccessManagerLocation(authkey, managerId, clinicId).getResult()
       }
   }*/

/* fun CoroutineScope.getManagerPermissionList(authkey: String?, managerId: String?, clinicId: String?): LiveData<Resource<CommonResponse<PermissionsData>, APIError>> = dataApi {
     fromNetwork {
         ApiClient.service.getManagerPermissionList(authkey, managerId, clinicId).getResult()
     }
 }*/

/* fun CoroutineScope.uploadFiles(request: HashMap<String, RequestBody>?, @Part imageFile: MultipartBody.Part?): LiveData<Resource<CommonResponse<UploadFiles>, APIError>> = dataApi {
     fromNetwork {
         ApiClient.service.uploadFilesCall(request, imageFile).getResult()
     }
 }*/


/*    fun CoroutineScope.deleteFilesFromS3(request: HashMap<String, String>?): LiveData<Resource<CommonResponse<Any>, APIError>> = dataApi {
        fromNetwork {
            ApiClient.service.deleteFilesFromS3(request).getResult()
        }
    }*/

/* fun CoroutineScope.getSlotInfoInChat(authKey: String?, staffUserId: String?, ownerUserId: String?, slotId: String?): LiveData<Resource<CommonResponse<StaffSlotDetails>, APIError>> = dataApi {
     fromNetwork {
         NursingApiClient.service.getSlotInfoInChat(authKey, staffUserId, ownerUserId, slotId).getResult()
     }
 }*/

/* fun CoroutineScope.uploadPillFile(path: UploadPillImage?): LiveData<Resource<CommonResponse<PillImageData>, APIError>> = dataApi {
     fromNetwork {
         PillScannerApiClient.service.uploadPillFile(path).getResult()
     }
 }

 fun CoroutineScope.uploadPillData(authKey: String?, data: String?, noofPills: String, rawImageName: String): LiveData<Resource<CommonResponse<Any>, APIError>> = dataApi {
     fromNetwork {
         ApiClient.service.uploadPillData(authKey, data, noofPills, rawImageName).getResult()
     }
 }*/

/*    fun CoroutineScope.getRemainingSlotReviewList(authKey: String?): LiveData<Resource<CommonResponse<List<Slotlist>>, APIError>> = dataApi {
        fromNetwork {
            NursingApiClient.service.getRemainingSlotReviewList(authKey).getResult()
        }
    }*/

