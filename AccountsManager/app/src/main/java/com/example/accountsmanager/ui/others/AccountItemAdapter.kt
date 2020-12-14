package com.example.accountsmanager.ui.others

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.accountsmanager.R
import com.example.accountsmanager.databinding.AccountItemBinding
import com.example.accountsmanager.ui.db.entity.entity.AccountsItem

class AccountItemAdapter: RecyclerView.Adapter<AccountItemAdapter.AccountViewHolder>() {




    inner class AccountViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val TTY  = itemView.findViewById<TextView>(R.id.ttTyperesult)
        val TB   = itemView.findViewById<TextView>(R.id.ttBranchResult)
        val A1   = itemView.findViewById<TextView>(R.id.ttAmount1Result)
        val A2   = itemView.findViewById<TextView>(R.id.Amount2Result)


    }


    private val differCallback = object : DiffUtil.ItemCallback<AccountsItem>(){
        override fun areItemsTheSame(oldItem: AccountsItem, newItem: AccountsItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: AccountsItem, newItem: AccountsItem): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this,differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.account_item,parent,false)
        return AccountViewHolder(view)

    }



    override fun onBindViewHolder(holder: AccountViewHolder, position: Int) {

        val curentAccountItem = differ.currentList[position]

        holder.TTY.text = curentAccountItem.type
        holder.TB.text = curentAccountItem.branch
        holder.A1.text = curentAccountItem.amount1
        holder.A2.text = curentAccountItem.amount2



    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}

