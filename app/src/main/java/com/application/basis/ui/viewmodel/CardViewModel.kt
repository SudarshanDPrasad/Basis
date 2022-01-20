package com.application.basis.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.application.basis.local.data.ResponseModel
import com.application.basis.repo.CardRepo
import com.application.sunstonekotlinassignment.data.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * ViewModel class where we send the data to Activity Class which received from the Repo class through Live Data
 */
@HiltViewModel
open class CardViewModel @Inject constructor(private val cardRepo: CardRepo) : ViewModel() {

     fun getData(): LiveData<Resource<ResponseModel>> {
        return cardRepo.getDataFromAPI()

        }
}