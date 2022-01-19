package com.application.basis.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.application.basis.local.data.ResponseModel
import com.application.basis.repo.CardRepo
import com.application.sunstonekotlinassignment.data.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class CardViewModel @Inject constructor(val cardRepo: CardRepo) : ViewModel() {

     fun getData(): LiveData<Resource<ResponseModel>> {
        return liveData(Dispatchers.IO) {
            val response = cardRepo.getData()
            emit(response)
        }
    }
}