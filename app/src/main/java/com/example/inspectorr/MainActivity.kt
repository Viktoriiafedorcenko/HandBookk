package com.example.inspectorr

import android.content.res.TypedArray
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    var adapter: MyAdaptar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var rcView = findViewById<RecyclerView>(R.id.rcView)

        var nav_view = findViewById<NavigationView>(R.id.nav_view)


        nav_view.setNavigationItemSelectedListener(this)
        var list = ArrayList<ListItem>()

        list.addAll(
            fillArras(
                resources.getStringArray(R.array.osmotr),
                resources.getStringArray(R.array.osmotr_content),
                getImageId(R.array.osmotr_image_array)
            )
        )
        rcView.hasFixedSize()
        rcView.layoutManager = LinearLayoutManager(this)
        adapter = MyAdaptar(list, this)
        rcView.adapter = adapter


    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.id_os -> {
                Toast.makeText(this, "Id os", Toast.LENGTH_SHORT).show()
                adapter?.updateAdaptar(
                    fillArras(
                        resources.getStringArray(R.array.osmotr),
                        resources.getStringArray(R.array.osmotr_content),
                        getImageId(R.array.osmotr_image_array)
                    )
                )

            }

            R.id.id_prd -> {
                Toast.makeText(this, "Id ok", Toast.LENGTH_SHORT).show()
                adapter?.updateAdaptar(
                    fillArras(
                        resources.getStringArray(R.array.opred),
                        resources.getStringArray(R.array.opred_content),
                        getImageId(R.array.opred_image_array)
                    )
                )

            }

            R.id.id_oo -> {
                Toast.makeText(this, "Id op", Toast.LENGTH_SHORT).show()
                adapter?.updateAdaptar(
                    fillArras(
                        resources.getStringArray(R.array.program),
                        resources.getStringArray(R.array.program_content),
                        getImageId(R.array.program_image_array)
                    )
                )

            }

            R.id.id_opg -> {
                Toast.makeText(this, "Id cy", Toast.LENGTH_SHORT).show()
                adapter?.updateAdaptar(
                    fillArras(
                        resources.getStringArray(R.array.nako),
                        resources.getStringArray(R.array.nako_content),
                        getImageId(R.array.nako_image_array)
                    )
                )

            }

            R.id.id_cy -> {
                Toast.makeText(this, "Id cp", Toast.LENGTH_SHORT).show()
                adapter?.updateAdaptar(
                    fillArras(
                        resources.getStringArray(R.array.protokol),
                        resources.getStringArray(R.array.protokol_content),
                        getImageId(R.array.protokol_image_array)
                    )
                )

            }

            R.id.id_prr -> {
                Toast.makeText(this, "Id cyh", Toast.LENGTH_SHORT).show()
                adapter?.updateAdaptar(
                    fillArras(
                        resources.getStringArray(R.array.cxema),
                        resources.getStringArray(R.array.cxema_content),
                        getImageId(R.array.cxema_image_array)
                    )
                )

            }

            R.id.id_pr -> {
                Toast.makeText(this, "Id cj", Toast.LENGTH_SHORT).show()
                adapter?.updateAdaptar(
                    fillArras(
                        resources.getStringArray(R.array.prect),
                        resources.getStringArray(R.array.prect_content),
                        getImageId(R.array.prect_image_array)
                    )
                )

            }

            R.id.id_bl -> {
                Toast.makeText(this, "Id co", Toast.LENGTH_SHORT).show()
                adapter?.updateAdaptar(
                    fillArras(
                        resources.getStringArray(R.array.blank),
                        resources.getStringArray(R.array.blank_content),
                        getImageId(R.array.blank_image_array)
                    )
                )

            }

        }
        var drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    fun fillArras(
        titleArray: Array<String>,
        contentArray: Array<String>,
        imageArray: IntArray
    ): List<ListItem> {
        var listItemArray = ArrayList<ListItem>()
        for (n in 0..titleArray.size - 1) {
            var listItem = ListItem(imageArray[n], titleArray[n], contentArray[n])
            listItemArray.add(listItem)
        }
        return listItemArray
    }


    fun getImageId(imageArrayId: Int): IntArray {
        var tArray: TypedArray = resources.obtainTypedArray(imageArrayId)
        val count = tArray.length()
        val ids = IntArray(count)
        for (i in ids.indices) {
            ids[i] = tArray.getResourceId(i, 0)
        }
        tArray.recycle()
        return ids
    }

}