package com.example.profilescreen.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.profilescreen.R
import com.example.profilescreen.api.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewGlobal: View
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewGlobal = view

        CoroutineScope(Dispatchers.IO).launch {
            setAccountData(RetrofitClient.retrofitService.getBalanceList());
        }

        CoroutineScope(Dispatchers.IO).launch {
            setTariffs(RetrofitClient.retrofitService.getTariffsList());
        }

        CoroutineScope(Dispatchers.IO).launch {
            setUser(RetrofitClient.retrofitService.getUserList());
        }
    }

    private fun setUser(userList: List<User>) {
        activity?.runOnUiThread {
            val recyclerViewButtons = viewGlobal.findViewById<RecyclerView>(R.id.userInfo)
            val adapter = UserCardAdapter()
            adapter.submitList(mutableListOf(
                UserCard(
                    id = 1,
                    icon = R.drawable.ic_person,
                    text = userList[0].firstName.plus(" ").plus(userList[0].lastName)
                ),
                UserCard(
                    id = 2,
                    icon = R.drawable.outline_house_24,
                    text = userList[0].address
                ),
                UserCard(
                    id = 3,
                    icon = R.drawable.outline_list_24,
                    text = getString(R.string.services_list)
                )
            ))
            recyclerViewButtons.adapter = adapter
        }
    }

    private fun setTariffs(tariffsList: List<Tariff>) {
        activity?.runOnUiThread {
            val recyclerViewTariff = viewGlobal.findViewById<RecyclerView>(R.id.tariffCards)
            val tariffAdapter = TariffAdapter()
            tariffAdapter.submitList(tariffsList)
            recyclerViewTariff.adapter = tariffAdapter
        }
    }

    private fun setAccountData(accountData: List<Balance>) {
        activity?.runOnUiThread {
            viewGlobal.findViewById<TextView>(R.id.idNumber).text =
                accountData[0].id.toString();
            viewGlobal.findViewById<TextView>(R.id.balanceNumber).text =
                getString(R.string.money_string, accountData[0].amount)
            viewGlobal.findViewById<TextView>(R.id.debtNumber).text =
                getString(R.string.to_pay, "сентябрь", accountData[0].toPay)
        }
    }

}