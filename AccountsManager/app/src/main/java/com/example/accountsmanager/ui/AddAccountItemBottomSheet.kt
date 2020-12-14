package com.example.accountsmanager.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.accountsmanager.R
import com.example.accountsmanager.databinding.BottomDialogueAccountItemBinding
import com.example.accountsmanager.ui.db.entity.entity.AccountsDatabase
import com.example.accountsmanager.ui.db.entity.entity.AccountsItem
import com.example.accountsmanager.ui.db.entity.entity.repository.AccountsRepository
import com.example.accountsmanager.ui.viewmodel.AccountsViewModel
import com.example.accountsmanager.ui.viewmodel.AccountsViewModelFactory
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.database.FirebaseDatabase


class AddAccountItemBottomSheet(context: Context, var addBottomDialogListener: AddBottomDialogueListener) : BottomSheetDialogFragment() {


    lateinit var binding : BottomDialogueAccountItemBinding
    lateinit var trb : String
    lateinit var tb : String

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_dialogue_account_item,container,false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = BottomDialogueAccountItemBinding.bind(view)





        val branches = arrayOf("KRR","TRY","PKT","TNJ","KUM","KRL","PDO","CMD","SPT","PAR","VPN","VLR","TML","BLR","HOS","SLM","NKL","ERD","VKL","TPR","CBE",
        "POL","DGL","MDU","SVK","TVL")
        val arrAdapter = ArrayAdapter(this.requireActivity(),android.R.layout.simple_spinner_dropdown_item,branches)
        binding.spTargetBranch.adapter = arrAdapter
        binding.spTargetBranch.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(adapterview: AdapterView<*>?, view: View?, position: Int, id: Long) {
                trb =  adapterview?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        val transtype = arrayOf("MT Out","MT In","BT In","BT Out","Loan IN","Loan Out","Share In","Share Out","Bank In","Bank Out")
        val arrAdapter1 = ArrayAdapter(this.requireActivity(),android.R.layout.simple_spinner_dropdown_item,transtype)
        binding.spTransactionType.adapter = arrAdapter1
        binding.spTransactionType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(adapterview: AdapterView<*>?, view: View?, position: Int, id: Long) {
                tb =  adapterview?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }


        binding.btnSubmit
        .setOnClickListener {

            val ttType = tb
            val tBranch = trb
            val amount1 = binding.etamount1.text.toString()
            val amount2 = binding.etAmount2.text.toString()




            if (ttType.isEmpty() || tBranch.isEmpty()||amount1.isEmpty()||amount2.isEmpty()){
                Toast.makeText(context,"Please fill all Details", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else if(amount1.contains(".") && amount2.contains(".")){
                val item = AccountsItem(ttType,tBranch,amount1,amount2)
                addBottomDialogListener.onAddButtonClicked(item)
                senddata()
                dismiss()
            }else{
                Toast.makeText(context,"Please enter in decimal", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

        }

        binding.cancel.setOnClickListener {
            dismiss()
        }


    }
    private fun senddata(){
        val ttType = tb
        val tBranch = trb
        val amount1 = binding.etamount1.text.toString()
        val amount2 = binding.etAmount2.text.toString()


        val ref = FirebaseDatabase.getInstance().getReference("Transaction Details")

        val id = ref.push().key
        val userdata = id.let { AccountsItem(ttType,tBranch,amount1,amount2) }


            ref.child(id.toString()).setValue(userdata).addOnCompleteListener{
                //Toast.makeText(requireContext(),"data saved",Toast.LENGTH_SHORT).show()

        }
    }
}
