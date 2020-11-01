package com.example.petwalker

import android.content.Context
import android.os.Bundle
import android.util.JsonReader
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.fragment_petlist.*
import org.json.JSONArray
import org.json.JSONObject
import java.net.URL

class PetsListFragment : Fragment() {

    val listaPets = mutableListOf<PetData>()
    val url = "http://[MyEndpoint]/pets"
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_petlist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val queue = Volley.newRequestQueue(context)
        val JsonArrayRequest = JsonArrayRequest(Request.Method.GET, url, null,
            { response: JSONArray ->

                var responseSize = response.length()-1
                for(i in 0..responseSize){
                    val pet: JSONObject = response.getJSONObject(i)
                    println(pet["name"])
                    listaPets.add(
                        PetData(
                        pet["name"].toString(),
                        pet["owner"].toString(),
                        pet["type"].toString(),
                        pet["walkday"].toString(),
                        pet["walkhour"].toString()
                    )
                    )
                }
                val listView = view.findViewById<ListView>(R.id.pet_listView)
                println(listaPets)
                listView.adapter = PetItemAdapter(view.context, listaPets)
            },
            { error ->
                println(error)
            }
        )
        queue.add(JsonArrayRequest)
        addbutton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.navigate_to_petcreate_fragment_action)
        }
    }
}