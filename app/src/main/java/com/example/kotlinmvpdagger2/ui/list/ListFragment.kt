package com.example.kotlinmvpdagger2.ui.list


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinmvpdagger2.R
import com.example.kotlinmvpdagger2.di.component.DaggerFragmentComponent
import com.example.kotlinmvpdagger2.di.module.FragmentModule
import com.example.kotlinmvpdagger2.models.DetailViewModel
import com.example.kotlinmvpdagger2.models.Post
import com.example.kotlinmvpdagger2.util.SwipeToDelete
import kotlinx.android.synthetic.main.fragment_list2.*
import javax.inject.Inject

class ListFragment : Fragment(), ListContract.View, ListAdapter.onItemClickListener {

    @Inject
    lateinit var presenter: ListContract.Presenter

    private lateinit var rootView: View

    fun newInstance(): ListFragment {
        return ListFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependency()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_list2, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attach(this)
        presenter.subscribe()
        initView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.unsubscribe()
    }

    override fun showProgress(show: Boolean) {
        if (show) {
            progressBarList.visibility = View.VISIBLE
        } else {
            progressBarList.visibility = View.GONE
        }
    }

    override fun showErrorProgress(error: String) {
        Log.e("Error", error)
    }

    override fun loadDataSuccess(list: List<Post>) {
        val adapter = ListAdapter(this.activity!!, list.toMutableList(), this)
        recyclerView!!.layoutManager = LinearLayoutManager(activity)
        recyclerView!!.adapter = adapter

        val swipeHandler = object : SwipeToDelete(this.activity!!) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val adapterRv = recyclerView.adapter as ListAdapter
                adapterRv.removeAt(viewHolder.adapterPosition)
            }
        }

        val itemTouchHelper = ItemTouchHelper(swipeHandler)
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }

    override fun loadDataAllSuccess(model: DetailViewModel) {
        print(model.toJson())
    }

    override fun itemRemoveClick(post: Post) {

    }


    override fun itemDetail(postId: String) {

    }

    private fun injectDependency() {
        val listComponent = DaggerFragmentComponent.builder()
            .fragmentModule(FragmentModule())
            .build()

        listComponent.inject(this)
    }

    private fun initView() {
        presenter.loadData()
    }

    companion object {
        const val TAG: String = "ListFragment"
    }
}
