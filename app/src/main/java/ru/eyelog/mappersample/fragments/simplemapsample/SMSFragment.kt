package ru.eyelog.mappersample.fragments.simplemapsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_main.btFirst
import kotlinx.android.synthetic.main.fragment_main.rvMainList
import ru.eyelog.mappersample.R
import ru.eyelog.mappersample.adapter.RVAdapter
import ru.eyelog.mappersample.fragments.simplemapsample.di.DaggerSMSComponent
import javax.inject.Inject

class SMSFragment: Fragment() {

    @Inject
    lateinit var viewModel: SMSViewModel

    @Inject
    lateinit var adapter: RVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerSMSComponent
            .builder()
            .withFragment(this)
            .build()
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycle.addObserver(viewModel)

        rvMainList.apply {
            adapter = this@SMSFragment.adapter
            layoutManager = LinearLayoutManager(context)
            itemAnimator = null
        }

        viewModel.sampleLiveData.observe(viewLifecycleOwner, {
            adapter.setData(it)
            adapter.notifyDataSetChanged()
        })

        btFirst.text = resources.getString(R.string.sms_fragment_menu)
        btFirst.setOnClickListener {
            viewModel.cleanList()
            viewModel.startThread()
        }
    }
}