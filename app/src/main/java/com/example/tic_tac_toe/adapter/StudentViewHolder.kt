package com.example.tic_tac_toe.adapter

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tic_tac_toe.R
import com.example.tic_tac_toe.model.Student

class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var nameTextView: TextView? = null
    private var idTextView: TextView? = null
    private var checkBox: CheckBox? = null
    private var student: Student? = null

    init {
        nameTextView = itemView.findViewById(R.id.student_row_name_text_view)
        idTextView = itemView.findViewById(R.id.student_row_id_text_view)
        checkBox = itemView.findViewById(R.id.student_row_check_box)
        checkBox?.apply {
            setOnClickListener { view ->
                (tag as? Int)?.let { tag ->
                    student?.isChecked = (view as? CheckBox)?.isChecked ?: false
                }
            }
        }
    }

    fun bind(student: Student?, position: Int) {
        this.student = student
        nameTextView?.text = student?.name
        idTextView?.text = student?.id
        checkBox?.apply {
            isChecked = student?.isChecked ?: false
            tag = position
        }
    }
}