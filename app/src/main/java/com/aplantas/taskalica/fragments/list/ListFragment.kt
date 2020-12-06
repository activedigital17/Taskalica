package com.aplantas.taskalica.fragments.list

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.aplantas.taskalica.R
import kotlinx.android.synthetic.main.fragment_list.view.*

class ListFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)


        //stavljamo tipki on click listener  te radimo navigaciju na add fragment
        view.add_button.setOnClickListener{
            findNavController().navigate(R.id.action_listFragment_to_addFragment)

        }

        view.listLayout.setOnClickListener{
            findNavController().navigate(R.id.action_listFragment_to_updateFragment)
        }

        //dodaj menu
        setHasOptionsMenu(true)
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.list_fragment_menu,menu)
    }


}