package com.example.tic_tac_toe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tic_tac_toe.adapter.StudentsRecyclerAdapter
import com.example.tic_tac_toe.model.Model
import com.example.tic_tac_toe.model.Student

class StudentsListFragment : Fragment() {

    private var students: MutableList<Student>? = null
    private var adapter: StudentsRecyclerAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_students_list, container, false)

        students = Model.shared.students
        val recyclerView: RecyclerView = view.findViewById(R.id.students_list_fragment_recycler_view)
        recyclerView.setHasFixedSize(true)

        val layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager

        adapter = StudentsRecyclerAdapter(students!!)
        recyclerView.adapter = adapter
        return view
    }
}