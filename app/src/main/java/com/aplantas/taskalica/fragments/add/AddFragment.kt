package com.aplantas.taskalica.fragments.add

import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.aplantas.taskalica.R
import com.aplantas.taskalica.data.models.Priority
import com.aplantas.taskalica.data.models.TodoData
import com.aplantas.taskalica.data.viewmodel.ToDoViewModel
import com.aplantas.taskalica.fragments.SharedViewModel
import kotlinx.android.synthetic.main.fragment_add.*


class AddFragment : Fragment() {


    private val mToDoViewModel:ToDoViewModel by viewModels()
    private val mSharedViewModel:SharedViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        val view = inflater.inflate(R.layout.fragment_add, container, false)
        setHasOptionsMenu(true)


        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.add_fragment_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_add){

            insertDataToDb()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun insertDataToDb() {
        val mTitle = title_et.text.toString()
        val mPriority = priorities_spinner.selectedItem.toString()
        val mDescription = descriptions_et.text.toString()

        val validation = mSharedViewModel.verifyDataFromUser(mTitle,mDescription)

        if (validation){

            //insertiramo podatke
            val newData = TodoData(
                    id = 0,
                    mTitle,
                    mSharedViewModel.parsePriority(mPriority),
                    mDescription

            )

            mToDoViewModel.insertData(newData)
            Toast.makeText(requireContext(), "Task added", Toast.LENGTH_SHORT).show()

            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else {
            Toast.makeText(requireContext(),"Please fill out all fields.", Toast.LENGTH_SHORT).show()
        }

    }



}