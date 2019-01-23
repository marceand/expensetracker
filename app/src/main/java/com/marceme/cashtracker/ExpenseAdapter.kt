package com.marceme.cashtracker

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.expense_layout.view.*

class ExpenseAdapter : RecyclerView.Adapter<ExpenseAdapter.ExpenseViewHolder>() {

    private var expenses = mutableListOf<Expense>()

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ExpenseViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.expense_layout, parent, false)

        return ExpenseViewHolder(view)
    }

    override fun getItemCount(): Int = expenses.size

    override fun onBindViewHolder(viewHolder: ExpenseViewHolder, position: Int) {
        viewHolder.bind(expenses[position])
    }

    fun addExpense(expense: Expense) {
        expenses.add(expense)
        notifyDataSetChanged()
    }

    inner class ExpenseViewHolder(val item: View) : RecyclerView.ViewHolder(item){

        fun bind(expense: Expense) {
            item.expense_name.text = expense.name
            item.expense_total.text = expense.total.toString()
        }

    }

}