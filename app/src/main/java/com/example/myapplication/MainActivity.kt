package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvFilm :RecyclerView
    private val list = ArrayList<Film>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvFilm = findViewById(R.id.rv_film)
        rvFilm.setHasFixedSize(true)

        list.addAll(getListFilm())
        showRecyclerList()
    }

    private fun getListFilm ():ArrayList<Film>{
        val dataJudul  = resources.getStringArray(R.array.data_name)
        val dataDeskripsi = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listFilm = ArrayList<Film>()
        for (i in  dataJudul.indices){
            val film = Film(dataJudul[i],dataDeskripsi[i],dataPhoto.getResourceId(i , -1))
            listFilm.add(film)
        }
        return listFilm
    }

    private fun showRecyclerList() {
        rvFilm.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListFilmAdapter(list)
        rvFilm.adapter = listHeroAdapter

        listHeroAdapter.setOnItemClickCallback(object :ListFilmAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Film) {
                val IntentDetail =Intent(this@MainActivity , MyFilmDetail::class.java)
                IntentDetail.putExtra(MyFilmDetail.DATA_FILM, data)
                startActivity(IntentDetail)
            }
        })
    }

    //menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_icon , menu)
        return super.onCreateOptionsMenu(menu)
    }

    //menu provile di click oncklick
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_provile->{
                val intent  = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}