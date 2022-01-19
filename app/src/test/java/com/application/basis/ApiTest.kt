package com.application.basis

import androidx.lifecycle.LiveData
import com.application.basis.api.ApiClient
import com.application.basis.local.data.ResponseModel
import com.application.basis.repo.CardRepo
import com.application.basis.ui.viewmodel.CardViewModel
import com.application.sunstonekotlinassignment.data.Resource
import com.application.sunstonekotlinassignment.data.ResponseHandler
import com.application.sunstonekotlinassignment.data.Status
import io.reactivex.rxjava3.core.Single
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import java.net.SocketException

class ApiTest {

    @Mock
    lateinit var cardRepo: CardRepo

    @Mock
    lateinit var apiClient: ApiClient

    @Mock
    lateinit var responseHandler: ResponseHandler

    lateinit var viewModel: CardViewModel

    @Mock
    lateinit var responseModel: ResponseModel

    lateinit var success: LiveData<Resource<ResponseModel>>
    lateinit var failure: LiveData<Resource<ResponseModel>>


    @Mock
    lateinit var socketException: SocketException

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = CardViewModel(cardRepo)

        CoroutineScope(Dispatchers.IO).launch {
            data()
        }
    }

    @Test
    fun test1(){
        viewModel.getData()
        assertEquals(success, Status.SUCCESS)
    }

    @Test
    fun test2(){
        viewModel.getData()
        assertEquals(failure, Status.ERROR)
    }



     fun data(){
        failure = cardRepo.mutableLiveData
        success = cardRepo.mutableLiveData

        `when`<Single<String>>(apiClient.getResponse()).thenReturn(Single.just(responseModel.toString()))

        `when`<LiveData<Resource<ResponseModel>>>(cardRepo.mutableLiveData).thenReturn(failure)
        `when`<LiveData<Resource<ResponseModel>>>(cardRepo.mutableLiveData).thenReturn(success)
    }
}