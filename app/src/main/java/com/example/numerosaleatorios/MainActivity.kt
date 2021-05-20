package com.example.numerosaleatorios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Random

var contador: Int = 0
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Botón que cuando sea presionado se agreguen los numeros aleatorios a los textView

        btnInicio.setOnClickListener(){

            //Definimos las variables que almacenaran los numeros aleatorios
            var numAleato = Random()
            var n1 = numAleato.nextInt(9) + 1
            var n2 = numAleato.nextInt(9) + 1
            var n3 = numAleato.nextInt(9) + 1

            //Insertamos estos numeros a los textView
            num1.setText("$n1")
            num2.setText("$n2")
            num3.setText("$n3")


            //Verficiamos que cuando los tres numeros sean 7 el usuario gane y cuando sea caso contrario pierde
            if (n1 == 7 && n2 == 7 && n3 == 7){

                tvrespu.setText("¡Felicidades usted ha ganado!")

            }else{

                contador++
                tvrespu.setText("Falló, ha usado $contador intentos")
            }


            //Estructura para evitar que se sigan haciendo intentos cuando estos se hayan terminado
            if (contador == 3){
                tvrespu.setText("Usted ha perdido, se ha quedado sin intentos")
                btnInicio.visibility=View.GONE
            }

        }
    }
}