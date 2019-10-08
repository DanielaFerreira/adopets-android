package com.example.adopets.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.widget.Button
import com.example.adopets.R
import com.example.adopets.adapter.AnimalAdapter
import com.example.adopets.adapter.AnimalAdapter2
import com.example.adopets.model.Animal
import com.google.firebase.database.*
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.activity_listagem_todos_animais.*
import kotlinx.android.synthetic.main.list_view_animais.*
import kotlinx.android.synthetic.main.list_view_animais2.*

class ListagemTodosAnimaisActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerViewTodosAnimais: RecyclerView
    private lateinit var btn_ok: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listagem_todos_animais)

//        btn_adotar = adotar
//
//        btn_adotar.setOnClickListener {
//            startActivity(Intent(this, PerfilAnimalActivity::class.java))
//        }

        btn_ok = ok

        btn_ok.setOnClickListener {
            startActivity(Intent(this, PerfilAnimalDoacaoActivity::class.java))
        }

        recyclerView = findViewById(R.id.recyclerViewTodosAnimais)
        recyclerViewTodosAnimais = findViewById(R.id.recyclerViewTodosAnimais)

        recyclerView = recyclerViewTodosAnimais
        recyclerView.adapter = AnimalAdapter2(animais(), this)
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager
    }

    private fun animais(): List<Animal> {

        var query: Query =  FirebaseDatabase.getInstance().reference.child("animais")
        query.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                //Passar os dados para a interface grafica
                for (snapshot in dataSnapshot.getChildren()) {
                    val animal = snapshot.getValue(Animal::class.java!!)
                    println(animal?.nome)
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                //Se ocorrer um erro
            }
        })

        return listOf(
            Animal("Tots", "Macho", "Japiim"),
            Animal("Mel", "Fêmea", "São Jorge"),
            Animal("Ferrer", "Macho", "Alvorada")
        )
    }
}
