package com.example.dog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlin.math.floor
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    val Orden = mutableListOf<Int?>();


    fun Nombre_Animal(Nombre: String, Edad: Int, Raza: String, Color: String, Tipo: String){
        lateinit var textoSalida: TextView
        textoSalida = findViewById(R.id.Principal)
        textoSalida.text = "Me llamo ${Nombre}, tengo ${Edad} años,  soy un ${Tipo} \n " +
                " mi raza es ${Raza}, así como mi " +
                " color es ${Color}";
    }

    lateinit var txtmordida: TextView
    lateinit var txtSonido: TextView
    lateinit var txtDisfrute: TextView



    fun mordida(masticado: String){
        txtmordida = findViewById(R.id.Tercero)
        txtmordida.text = "Ingiero: ${masticado}";
    }

    fun Alarido(Salida: String){
        txtSonido = findViewById(R.id.Segundo)
        txtSonido.text = "Y yo digo: ${Salida}";
    }

    fun Logica(eleccion: Int ){

        if(eleccion %2 == 0){
            when{
                eleccion == 0 -> Nombre_Animal("Coqueta",5,"Criollo", "Negro", "Perro");
                eleccion == 2 -> Nombre_Animal("Tauny",12,"Golden", "Cobre", "Perro");
                eleccion == 4 -> Nombre_Animal("Vandido",9,"Pastor Aleman", "Pardo" , "Perro");
                eleccion == 6 -> Nombre_Animal("Duna",5,"Criollo", "Arena", "Perro");
            }
        }else{
            when{
                eleccion == 1 -> Nombre_Animal("Quiqi",5,"Montañoso", "Blanco", "Gato");
                eleccion == 3 -> Nombre_Animal("Niño",7,"Criollo", "Negro", "Gato");
                eleccion == 5 -> Nombre_Animal("Kato",9,"Criollo", "Pardo", "Gato");
                eleccion == 7 -> Nombre_Animal("Vaiper",5,"Miau", "Gris", "Gato");
            }
        }
    }

    fun Disfrute(Cosa: String){
        txtDisfrute = findViewById(R.id.Cuarto)
        txtDisfrute.text = "Y juego con: ${Cosa}";
    }

    fun Sonido(dale: Int){
        if(dale %2 == 0){
            when{
                dale == 0 -> Alarido("Woaf")
                dale == 2 -> Alarido("GRUÑIDO AMABLE")
                dale == 4 -> Alarido("WOAF WOAF ")
                dale == 6 -> Alarido("WUFF")
            }
        }else{
            when{
                dale == 1 -> Alarido("Miau")
                dale == 3 -> Alarido("Mewo")
                dale == 5 -> Alarido("MIAUUUU")
                dale == 7 -> Alarido("Meow elegante")
            }
        }
    }

    fun Comida(mam: Int){
        if(mam %2 == 0){
            when{
                mam == 0 -> mordida("Croqueta")
                mam == 2 -> mordida("Chuleta de caballo")
                mam == 4 -> mordida("Tu tarea")
                mam == 6 -> mordida("Croqueta dieteteica")
            }
        }else{
            when{
                mam == 1 -> mordida("Salmón")
                mam == 3 -> mordida("Tilapia")
                mam == 5 -> mordida("Basa")
                mam == 7 -> mordida("RATA SALVAJE")
            }
        }
    }

    fun Juego(play: Int){
        if(play %2 == 0){
            when{
                play == 0 -> Disfrute("Pelotita")
                play == 2 -> Disfrute("Tu sandalea")
                play == 4 -> Disfrute("Tu tarea")
                play == 6 -> Disfrute("El Gato del vecino")
            }
        }else{
            when{
                play == 1 -> Disfrute("Raton")
                play == 3 -> Disfrute("Pelotita")
                play == 5 -> Disfrute("Caña de azucar")
                play == 7 -> Disfrute("Física cuántica")
            }
        }
    }


    val numeros = mutableListOf<Int>(0,5,6,2,4,7,3,1)

    fun makeSound(view: View) {
      if (txtSonido.text != ""){
          Toast.makeText(this, "Yo DIGO : ${txtSonido.text}", Toast.LENGTH_SHORT).show();
      }else
      {
          Toast.makeText(this, "Aun no hay animal", Toast.LENGTH_SHORT).show();
      }


    }


    fun play(view: View) {
        if(txtDisfrute.text != ""){
            Toast.makeText(this, "Yo JUEGO: ${txtDisfrute.text}", Toast.LENGTH_SHORT).show();
        }else
        {
            Toast.makeText(this, "Aun no hay animal", Toast.LENGTH_SHORT).show();
        }

    }


    fun eat(view: View) {
        if (txtmordida.text.isEmpty()){
            Toast.makeText(this, "Aun no hay animal", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Yo COMO : ${txtmordida.text}", Toast.LENGTH_SHORT).show();
        }

    }




    var atras = 0;

    fun getPreviousPet(view: View) {

        if (atras > 0){
            atras--;
            Orden[atras]?.let { Logica(it) }
            Orden[atras]?.let { Sonido(it) }
            Orden[atras]?.let { Comida(it) }
            Orden[atras]?.let { Juego(it) }
        }else{
            Toast.makeText(this, "Se acabaron los animalitos", Toast.LENGTH_SHORT).show();
        }

    }

    var centi = 0;

    fun createNewPet(view: View) {
        val salida = numeros.randomOrNull()

        if(salida != null || Orden.size > 7){
            if (numeros.remove(salida)){
                Toast.makeText(this, "Agragado : ${Orden.size}", Toast.LENGTH_SHORT).show();
                Orden.add(salida)
                Orden[centi]?.let { Logica(it) }
                Orden[centi]?.let { Sonido(it) }
                Orden[centi]?.let { Comida(it) }
                Orden[centi]?.let { Juego(it) }
                centi++;
                atras = centi;
            }else {
                Toast.makeText(this, "Se acabaron los animalitos", Toast.LENGTH_SHORT).show();
            }
        }
    }


    fun getNextPet(view: View) {
        if (atras < Orden.size){
            Orden[atras]?.let { Logica(it) }
            Orden[atras]?.let { Sonido(it) }
            Orden[atras]?.let { Comida(it) }
            Orden[atras]?.let { Juego(it) }
            atras++;
        }else{
            Toast.makeText(this, "Se acabaron los animalitos", Toast.LENGTH_SHORT).show();
        }

    }
}