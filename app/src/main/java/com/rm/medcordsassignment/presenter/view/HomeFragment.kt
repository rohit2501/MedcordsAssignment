package com.rm.medcordsassignment.presenter.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.rm.medcordsassignment.R
import com.rm.medcordsassignment.presenter.view.adapter.ButtonAdapter
import com.rm.medcordsassignment.presenter.view.adapter.ListAdapter
import com.rm.medcordsassignment.presenter.view.model.ListItem
import com.rm.medcordsassignment.presenter.viewmodel.HomeViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.home_fragment.*


class HomeFragment : Fragment(), ButtonAdapter.IButtonClickListener {


    private lateinit var viewModel: HomeViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(requireActivity())[HomeViewModel::class.java]
        var layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        list_view.layoutManager = layoutManager

        list_view.adapter = ListAdapter(requireContext(), getData())

        var gridLayoutManager = GridLayoutManager(requireContext(), 2)
        button_list_view.layoutManager = gridLayoutManager

        button_list_view.adapter = ButtonAdapter(requireContext(), this)

    }

    private fun getData(): List<ListItem> {

        var list = ArrayList<ListItem>()
        list.add(ListItem("#00ffcc"))
        list.add(ListItem("#ff0000"))
        list.add(ListItem("#ffff00"))

        return list
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    @SuppressLint("CheckResult")
    override fun onButtonClick(text: String) {
        viewModel.getApiData(text)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                { Toast.makeText(requireContext(), it.data!!.rstr, Toast.LENGTH_LONG).show() },
                { Toast.makeText(requireContext(), it.localizedMessage, Toast.LENGTH_LONG).show() }
            )
    }

}
