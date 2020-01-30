package com.example.kotlinmvpdagger2.ui.about


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kotlinmvpdagger2.R
import com.example.kotlinmvpdagger2.di.component.DaggerFragmentComponent
import com.example.kotlinmvpdagger2.di.module.FragmentModule
import kotlinx.android.synthetic.main.fragment_about.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class AboutFragment : Fragment(), AboutContract.View {

    @Inject
    lateinit var presenter: AboutContract.Presenter

    private lateinit var rootView: View

    fun newInstance(): AboutFragment {
        return AboutFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDepedency()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attach(this)
        presenter.subscribe()
        initView()

    }

    override fun showProgress(show: Boolean) {
        if (show) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }

    override fun loadMessageSucces(message: String) {
        aboutText.text =
            ("Nama Alfiansyah Nur Zufa , Nama Alfiansyah Nur Zufa , Nama Alfiansyah Nur Zufa, Nama " +
                    "Alfiansyah Nur Zufa, Nama Alfiansyah Nur Zufa, Nama Alfiansyah Nur Zufa, Nama " +
                    "Alfiansyah Nur Zufa, Nama Alfiansyah Nur Zufa")
        aboutText.visibility = View.VISIBLE
    }

    override fun loadMessageError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun injectDepedency() {
        val aboutFragment = DaggerFragmentComponent.builder()
            .fragmentModule(FragmentModule())
            .build()

        aboutFragment.inject(this)
    }

    private fun initView() {
        presenter.loadMessage()
    }

    companion object {
        const val TAG: String = "AboutFragment"
    }


}
