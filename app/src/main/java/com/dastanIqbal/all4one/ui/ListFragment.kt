package com.dastanIqbal.all4one.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.dastanIqbal.all4one.R
import com.dastanIqbal.all4one.ui.adapter.ItemAdapter
import com.dastanIqbal.di.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.list_fragment.*
import javax.inject.Inject


class ListFragment : Fragment() {

    companion object {
        fun newInstance() = ListFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    lateinit var viewModel: ListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ListViewModel::class.java)

        recyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )

        with(viewModel) {
            loadingLiveData.observe(viewLifecycleOwner, Observer {
                if (it) progressBar.visibility = View.GONE
                else progressBar.visibility = View.VISIBLE
            })

            errorLiveData.observe(viewLifecycleOwner, Observer {
                if (it) tv_error.visibility = View.GONE
                else tv_error.visibility = View.VISIBLE
            })

            getData().repoLiveData.observe(viewLifecycleOwner, Observer {
                val adapter = ItemAdapter(it)
                recyclerView.adapter = adapter
            })
        }

    }

}
