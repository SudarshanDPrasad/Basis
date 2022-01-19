package com.application.basis

import com.application.basis.api.ApiClient
import com.application.basis.local.data.ResponseModel
import com.application.basis.repo.CardRepo
import com.application.basis.viewmodel.CardViewModel
import com.application.sunstonekotlinassignment.data.Resource
import com.application.sunstonekotlinassignment.data.ResponseHandler
import com.application.sunstonekotlinassignment.data.Status
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.junit.Before
import org.junit.Test
import org.junit.runner.notification.Failure
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

    lateinit var success: Resource<ResponseModel>
    lateinit var failure: Resource<ResponseModel>

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
        assertEquals(success.status, Status.SUCCESS)
    }

    @Test
    fun test2(){
        viewModel.getData()
        assertEquals(failure.status, Status.ERROR)
    }



    suspend fun data(){
        failure = responseHandler.handleException(socketException)
        success = responseHandler.handleSuccess(responseModel)

        `when`<String>(apiClient.getResponse()).thenReturn(responseModel.toString())

        `when`<Resource<ResponseModel>>(cardRepo.getData()).thenReturn(failure)
        `when`<Resource<ResponseModel>>(cardRepo.getData()).thenReturn(success)
    }
}