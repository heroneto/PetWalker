package com.example.petwalker

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.Navigation
import java.time.DayOfWeek

class PetItemAdapter(context: Context, petlistReceived: MutableList<PetData>): BaseAdapter() {

    private val mContext: Context
    val petlist : MutableList<PetData>


    init {
        mContext = context
        petlist = petlistReceived
    }

    override fun getCount(): Int {
        return petlist.size
    }

    override fun getItem(position: Int): Any {
        return "TEST STRING"
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, converterView: View?, viewGroup: ViewGroup?): View {
        val layoutInflater = LayoutInflater.from(mContext)
        val item = layoutInflater.inflate(R.layout.pet_item, viewGroup, false)

        item.findViewById<TextView>(R.id.petname).text = petlist.get(position).name
        item.findViewById<TextView>(R.id.petowner).text = petlist.get(position).petOwner
        item.findViewById<TextView>(R.id.walkday).text = petlist.get(position).walkDay
        item.findViewById<TextView>(R.id.walkhour).text = petlist.get(position).walkHour

        val petItemView = item.findViewById<LinearLayout>(R.id.item)

        petItemView.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.navigate_to_petdetails_fragment_action)
        }

        return item
    }


}

data class PetData (val name: String, val petOwner: String, val petType: String,  val walkDay: String, val walkHour: String )