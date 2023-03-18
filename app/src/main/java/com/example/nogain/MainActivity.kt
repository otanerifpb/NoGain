package com.example.nogain

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.nogain.noGain.NoGain

class MainActivity : AppCompatActivity() {
    private lateinit var tvSorteio: TextView
    private lateinit var tvMin: TextView
    private lateinit var tvMax: TextView
    private lateinit var tvStatus: TextView
    private lateinit var tvIntervalo: TextView
    private lateinit var etChute: EditText
    private lateinit var btReset: Button
    private lateinit var btChute: Button
    private lateinit var arrocha: NoGain


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.tvSorteio = findViewById(R.id.tvSorteio)
        this.tvMin = findViewById(R.id.tvMin)
        this.tvMax = findViewById(R.id.tvMax)
        this.tvStatus = findViewById(R.id.tvStatus)
        this.tvIntervalo = findViewById(R.id.tvIntervalo)
        this.etChute = findViewById(R.id.etChute)
        this.btReset = findViewById(R.id.btReset)
        this.btChute = findViewById(R.id.btChute)

        this.arrocha = NoGain(1, 100)

        this.tvSorteio.text = "" /*this.arrocha.sorteio.toString()*/
        //this.tvMin.text = this.arrocha.min.toString()
        //this.tvMax.text = this.arrocha.max.toString()
        this.tvIntervalo.text = "" /*this.arrocha.intervalo(70).toString()*/
        //this.tvStatus.text = this.arrocha.status.toString()
        this.reset()

        this.btReset.setOnClickListener {
            this.arrocha = NoGain(1, 100)
            reset()
            Toast.makeText(this, "Novo Jogo!", Toast.LENGTH_SHORT).show()
        }

        //        this.btnChutar.setOnClickListener({ this.chutar() })
        this.btChute.setOnClickListener(ClickBotao())

    }

    fun reset(){
        this.tvMin.text = this.arrocha.min.toString()
        this.tvMax.text = this.arrocha.max.toString()
        this.tvStatus.text = this.arrocha.status /*.toString(), necessário quanto não recebe String*/
        this.etChute.text.clear()
    }

    fun chute(){
        var valor = this.etChute.text.toString().toInt()
        var resposta = this.arrocha.jogar(valor)
        if (resposta > 0){
//            this.tvFeedback.text = "Seu chute é maior"
            Toast.makeText(this, "Seu chute é maior!", Toast.LENGTH_SHORT).show()
        }else if (resposta < 0){
//            this.tvFeedback.text = "Seu chute é menor"
            Toast.makeText(this, "Seu chute é menor!", Toast.LENGTH_SHORT).show()
        }else{
//            this.tvFeedback.text = "Coisa feia !!"
        }
        reset()
    }

    inner class ClickBotao: View.OnClickListener {
        override fun onClick(v: View?) {
            var valor = this@MainActivity.etChute.text.toString().toInt()
            var resposta = this@MainActivity.arrocha.jogar(valor)
            if (resposta > 0){
//                this@MainActivity.tvFeedback.text = "Seu chute é maior"
                Toast.makeText(this@MainActivity, "Seu chute é maior!", Toast.LENGTH_SHORT).show()
            }else if (resposta < 0){
//                this@MainActivity.tvFeedback.text = "Seu chute é menor"
                Toast.makeText(this@MainActivity, "Seu chute é menor!", Toast.LENGTH_SHORT).show()
            }else{
//                this@MainActivity.tvFeedback.text = "Coisa feia !!"
            }
            reset()
        }

    }

}

