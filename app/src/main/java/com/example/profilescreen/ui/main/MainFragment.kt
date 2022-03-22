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

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
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

        val balanceId = view.findViewById<TextView>(R.id.idNumber)
        balanceId.text = "ЛС: 11001010100"
        val balanceNumber = view.findViewById<TextView>(R.id.balanceNumber)
        balanceNumber.text = "100.42 Р"
        val debt = view.findViewById<TextView>(R.id.debtNumber)
        debt.text = "К оплате за сентябрь 0.00 Р"

        val tariffView = view.findViewById<RecyclerView>(R.id.tariffCards)
        val tariffAdapter = TariffAdapter()
        tariffAdapter.submitList(
            mutableListOf(
                TariffInformation(
                    1,
                    "Тариф \"Улыбка\"",
                    "Скорость до 100 Мбит/с",
                    "0 Р/мес"
                ),
                TariffInformation(
                    2,
                    "Тариф \"Улыбка\"",
                    "Скорость до 100 Мбит/с",
                    "0 Р/мес"
                ),
            )
        )
        tariffView.adapter = tariffAdapter

        val userView = view.findViewById<RecyclerView>(R.id.userInfo)
        val userAdapter = UserAdapter()
        userAdapter.submitList(
            mutableListOf(
                UserInformation(
                    1,
                    R.drawable.ic_person,
                    "Иванов Иван Иваныч"
                ),
                UserInformation(
                    2,
                    R.drawable.outline_house_24,
                    "Сахалин, ул. Пушкина, д. Колотушкина"
                ),
                UserInformation(3, R.drawable.outline_list_24, "Доступные услуги")
            )
        )
        userView.adapter = userAdapter
    }
}