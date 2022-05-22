package com.example.profilescreen.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.profilescreen.App
import com.example.profilescreen.R
import com.example.profilescreen.di.MainViewModel
import com.example.profilescreen.domain.models.Balance
import com.example.profilescreen.domain.models.Tariff
import com.example.profilescreen.domain.models.User
import com.example.profilescreen.domain.models.UserCard
import com.example.profilescreen.domain.usecases.getBalance.IGetBalanceUseCase
import javax.inject.Inject


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewGlobal: View

    @Inject
    lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onResume() {
        super.onResume()
        viewModel.getData()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewGlobal = view
        App.appComponent.inject(this)
        viewModel.balance.observe(viewLifecycleOwner) {
            setAccountData(it)
        }
        viewModel.tariffs.observe(viewLifecycleOwner) {
            setTariffs(it)
        }
        viewModel.user.observe(viewLifecycleOwner) {
            setUser(it)
        }
    }

    private fun setUser(user: User) {
        activity?.runOnUiThread {
            val recyclerViewCards = viewGlobal.findViewById<RecyclerView>(R.id.userInfo)
            val adapter = UserCardAdapter()
            adapter.submitList(
                mutableListOf(
                    UserCard(
                        id = 1,
                        icon = R.drawable.ic_person,
                        text = user.firstName.plus(" ").plus(user.lastName)
                    ),
                    UserCard(
                        id = 2,
                        icon = R.drawable.outline_house_24,
                        text = user.address
                    ),
                    UserCard(
                        id = 3,
                        icon = R.drawable.outline_list_24,
                        text = getString(R.string.services_list)
                    )
                )
            )
            recyclerViewCards.adapter = adapter
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

    private fun setAccountData(accountData: Balance) {
        activity?.runOnUiThread {
            viewGlobal.findViewById<TextView>(R.id.idNumber).text =
                accountData.id.toString();
            viewGlobal.findViewById<TextView>(R.id.balanceNumber).text =
                getString(R.string.money_string, accountData.amount)
            viewGlobal.findViewById<TextView>(R.id.debtNumber).text =
                getString(R.string.to_pay, "сентябрь", accountData.toPay)
        }
    }

}