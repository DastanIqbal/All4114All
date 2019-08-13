package com.dastanIqbal.all4one.feature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import com.dastanIqbal.all4one.R
import com.dastanIqbal.all4one.feature.adapter.ItemAdapter
import com.dastanIqbal.di.Injectable
import kotlinx.android.synthetic.main.list_fragment.*
import javax.inject.Inject


class ListFragment : Fragment(), Injectable {

    companion object {
        fun newInstance() = ListFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    val viewModel: ListViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(ListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )

        with(viewModel) {
            loadingLiveData.observe(viewLifecycleOwner, Observer {
                if (it) progressBar.visibility = View.VISIBLE
                else progressBar.visibility = View.GONE
            })

            errorLiveData.observe(viewLifecycleOwner, Observer {
                if (it) {
                    progressBar.visibility = View.GONE
                    tv_error.visibility = View.VISIBLE
                }
            })

            getData().repoLiveData.observe(viewLifecycleOwner, Observer {
                val adapter = ItemAdapter()
                recyclerView.adapter = adapter
                adapter.submitList(it)
            })
        }

    }

}
