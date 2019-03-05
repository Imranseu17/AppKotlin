package com.example.kotlinapplication

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_recycler.*
import kotlinx.android.synthetic.main.cuntory_child.view.*

class RecyclerActivity : AppCompatActivity() {

    var countries : MutableList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
          loadData()
        //country_list.layoutManager = LinearLayoutManager(this)
        country_list.layoutManager = GridLayoutManager(this,2)
        country_list.adapter = CountryAdapter(countries,this)
    }


    fun loadData(){

        countries.add("Afghanistan")
        countries.add("Albania")
        countries.add("Algeria")
        countries.add("Andorra")
        countries.add("Angola")
        countries.add("Antigua and Barbuda")
        countries.add("Argentina")
        countries.add("Armenia")
        countries.add("Australia")
        countries.add("Austria")
        countries.add("Azerbaijan")
        countries.add("Bahamas")
        countries.add("Bahrain")
        countries.add("Bangladesh")
        countries.add("Barbados")
        countries.add("India")
        countries.add("Pakistan")
        countries.add("Srilanka")
        countries.add("Bhutan")
    }


    class CountryAdapter(items : List<String>,ctx:Context) :
        RecyclerView.Adapter<CountryAdapter.ViewHolder>(){

        var list = items
        var context = ctx
        
        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
            return ViewHolder(LayoutInflater.from(context).inflate(R.layout.cuntory_child,p0,false))
        }

        override fun getItemCount(): Int {
            return list.size
        }

        override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
              p0?.name?.text = list.get(p1)
        }

        class ViewHolder(v:View): RecyclerView.ViewHolder(v) {
            val name = v.country_name

        }



    }


}
