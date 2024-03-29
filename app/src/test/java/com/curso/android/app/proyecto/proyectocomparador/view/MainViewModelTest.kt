package com.curso.android.app.proyecto.proyectocomparador.view

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Rule
import org.junit.Before
import org.junit.Test

@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
internal class MainViewModelTest{

    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()
    @Before
    fun setup(){
        Dispatchers.setMain(dispatcher)
        viewModel  = MainViewModel()
    }
    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }
    @Test
    fun mainViewModel_CheckInitialValue() = runTest {
        val value = viewModel.comparer.value?.result
        assertEquals("",value)
    }
}