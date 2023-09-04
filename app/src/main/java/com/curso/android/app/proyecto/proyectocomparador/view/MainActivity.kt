package com.curso.android.app.proyecto.proyectocomparador.view
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.curso.android.app.proyecto.proyectocomparador.R
import com.curso.android.app.proyecto.proyectocomparador.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        mainViewModel.comparer.observe(this){
            binding.resultText.text = it.result
        }
        binding.buttonComparator.setOnClickListener {
            mainViewModel.compare(binding.firstword.text.toString(), binding.secondword.text.toString())
        }
        binding.buttonHelp.setOnClickListener{
            toas()
        }

    }
    private fun toas(){
        Toast.makeText(this, "¡Hello! this is a comparator app." +
                "\n¡Just enter words and lets see!", Toast.LENGTH_LONG).show()
    }

}


