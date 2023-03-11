/*
* Copyright (C) 2021 The Android Open Source Project.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.example.dogglers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglers.R
import com.example.dogglers.data.DataSource
import com.example.dogglers.model.Dog

/**
 * Adapter to inflate the appropriate list item layout and populate the view with information
 * from the appropriate data source
 */
class DogCardAdapter(private val context: Context?,
                     private val layout: Int) :
    RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {


    // TODO: Initialize the data using the List found in data/DataSource
    val kopekler= DataSource.dogs

    /**
     * Initialize view elements
     */
    class DogCardViewHolder(view: View?) : RecyclerView.ViewHolder(view!!) {
        // TODO: Declare and initialize all of the list item UI components
        // dog_image, dog_name, dog_age, and dog_hobbies
        val dogImage: ImageView
        val dogName: TextView
        val dogAge: TextView
        val dogHobby: TextView

        init {
            // Define click listener for the ViewHolder's View.
//            textView = view.findViewById(R.id.textView)
            dogImage = view!!.findViewById(R.id.myBella)
            dogName = view!!.findViewById((R.id.dogsNameText))
            dogAge = view!!.findViewById((R.id.dogsAgeText))
            dogHobby = view!!.findViewById((R.id.dogsHobbyText))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {
        // TODO: Use a conditional to determine the layout type and set it accordingly.
        //  if the layout variable is Layout.GRID the grid list item should be used. Otherwise the
        //  the vertical/horizontal list item should be used.
        val inflater = LayoutInflater.from(parent.context)

        if (layout == 1 || layout == 2) {
            var view = inflater.inflate(R.layout.vertical_horizontal_list_item, parent, false)
            return DogCardViewHolder(view)

        } else {
            var view = inflater.inflate(R.layout.grid_list_item, parent, false)
            return DogCardViewHolder(view)
        }


        // TODO Inflate the layout

        // TODO: Null should not be passed into the view holder. This should be updated to reflect
        //  the inflated layout.
//        return DogCardViewHolder(view)
    }

    override fun getItemCount(): Int {
        println(kopekler.size)
        return kopekler.size

    } // TODO: return the size of the data set instead of 0

    override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {
        // TODO: Get the data at the current position
        // TODO: Set the image resource for the current dog
        // TODO: Set the text for the current dog's name
        // TODO: Set the text for the current dog's age
        val resources = context?.resources
        val item= kopekler[position]
        holder.dogImage?.setImageResource(item.imageResourceId)
        holder.dogName?.text = item.name
        holder.dogAge?.text= resources?.getString(R.string.dog_age,item.age)
        holder.dogHobby?.text=resources?.getString(R.string.dog_hobbies,item.hobbies)

        //bu şekilde sadece yaş ve hobby bilgisi gelirken yukarıdaki şekilde
        //age : yaş şeklinde geliyor
//        holder.dogAge?.text= item.age
//        holder.dogHobby?.text=item.hobbies

        // TODO: Set the text for the current dog's hobbies by passing the hobbies to the
        //  R.string.dog_hobbies string constant.
        //  Passing an argument to the string resource looks like:
        //  resources?.getString(R.string.dog_hobbies, dog.hobbies)
    }
}
