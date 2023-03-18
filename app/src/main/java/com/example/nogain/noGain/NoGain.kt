package com.example.nogain.noGain

import android.util.Log

class NoGain (var min:Int, var max: Int ){
    var sorteio: Int
    var status: String

    init {
        this.sorteio = ((this.min + 1) .. (this.max -1)).random()
        this.status = Status.CONTINUA.mens
        Log.i("APP_NOGAIN", "O numero sorteado foi ${this.sorteio}")
    }

    fun arrochado(): Boolean{
        return this.min + 1 == this.max - 1
    }

    fun intervalo(chute: Int): Int{
        if(chute < this.sorteio){
            this.min = chute
            return -1
        } else{
            this.max = chute
            return 1
        }
    }

    fun chuteValido(chute: Int): Boolean{
        return chute > this.min && chute < this.max && chute != this.sorteio
    }

    fun jogar(chute: Int): Int{
        if(!this.chuteValido(chute)){
            this.status = Status.PERDEU.mens
            return 0
        }else{
            var valor = this.intervalo(chute)
            if (this.arrochado()){
                this.status = Status.GANHOU.mens
            }
            return valor
        }
    }

}