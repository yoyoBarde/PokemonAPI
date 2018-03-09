package com.example.j.pokeapi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.json.JSONObject
import java.net.URL

class MainActivity : AppCompatActivity() {
private val url = "https://pokeapi.co/api/v2/pokemon/"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        var pokeDataList = ArrayList<PokemonData>()
        var adapter = CustomAdapter(pokeDataList,applicationContext)


        for (i in 1 ..20) {
            doAsync {
                val resultJson = URL(url + i + "/").readText()
                uiThread {
                    val jsonObj = JSONObject(resultJson)
                    val name = jsonObj.getString("name")
                    val sprites= jsonObj.getString("sprites")
                    val jsonObj1=JSONObject(sprites)
                    val image = jsonObj1.getString("front_default")
                    pokeDataList.add(PokemonData(name,image))
                    recyclerView.adapter = adapter
                }

            }
        if(pokeDataList.size==19){
            progressBarPB.visibility=View.GONE
        }


        }



    }
}
