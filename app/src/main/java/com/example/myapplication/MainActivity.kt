package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.adapter.PlaceAdapter
import com.example.myapplication.model.PlaceData
import com.google.android.gms.ads.MobileAds
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var mDataBase:DatabaseReference
    private lateinit var PlaceList:ArrayList<PlaceData>
    private lateinit var mAdapter:PlaceAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MobileAds.initialize(this) {}
         val settingbtn = findViewById<Button>(R.id.set)
        settingbtn.setOnClickListener {
             val intent=Intent(this,SettingsActivity::class.java)
            startActivity(intent)
        }
        PlaceList = ArrayList()
        mAdapter = PlaceAdapter(this,PlaceList)
        rv.layoutManager = LinearLayoutManager(this)
        rv.setHasFixedSize(true)
       // rv.adapter = mAdapter
            // get data from database bellow code
        getData()
    }

    private fun getData() {

        mDataBase = FirebaseDatabase.getInstance().getReference("oromia")
        mDataBase.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                 if (snapshot.exists()){
                     for (placeSnapshot in snapshot.children){
                         val place = placeSnapshot.getValue(PlaceData::class.java)
                         PlaceList.add(place!!)
                     }
                     rv.adapter = mAdapter
                 }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MainActivity, error.message, Toast.LENGTH_SHORT).show()
            }

        })


    }

}