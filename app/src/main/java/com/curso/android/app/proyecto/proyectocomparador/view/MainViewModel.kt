package com.curso.android.app.proyecto.proyectocomparador.view


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.curso.android.app.proyecto.proyectocomparador.model.ResultText



class MainViewModel: ViewModel() {

    val comparer: LiveData<ResultText> get() = _comparer
    private var _comparer= MutableLiveData(ResultText(""))


    fun compare(firstWord: String, secondWord: String){
        var result = ""
        if (firstWord == secondWord)
        {
            result ="¡both words are the same!"
        }
        if(firstWord != secondWord)
        {
            result ="¡both words are unequal!"
        }

        _comparer.value = ResultText(result)
    }
}