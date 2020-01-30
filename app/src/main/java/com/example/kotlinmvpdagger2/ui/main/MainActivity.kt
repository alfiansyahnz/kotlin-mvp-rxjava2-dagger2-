package com.example.kotlinmvpdagger2.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinmvpdagger2.R
import com.example.kotlinmvpdagger2.di.component.DaggerActivityComponent
import com.example.kotlinmvpdagger2.di.module.ActivityModule
import com.example.kotlinmvpdagger2.ui.about.AboutFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View {

    @Inject
    lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injectDependency()
        presenter.attach(this)
    }

    override fun onResume() {
        super.onResume()

    }

    override fun showAboutFragment() {
        if (supportFragmentManager.findFragmentByTag(AboutFragment.TAG) == null) {
            supportFragmentManager.beginTransaction()
                .addToBackStack(null)
                .replace(R.id.frameLayout, AboutFragment().newInstance(), AboutFragment.TAG)
                .commit()
        } else {

        }

    }

    override fun showListFragment() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun injectDependency() {
        val activityComponent = DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .build()

        activityComponent.inject(this)
    }

    override fun onBackPressed() {
        val fragmentManager = supportFragmentManager
        val fragment = fragmentManager.findFragmentByTag(AboutFragment.TAG)


        if (fragment == null) {
            super.onBackPressed()
        } else {
            supportFragmentManager.popBackStack()
        }
    }
//
//    enum class AnimType() {
//        SLIDE,
//        FADE;
//
//        fun getAnimPair(): Pair<Int, Int> {
//            when(this) {
//                SLIDE -> return Pair(R.anim.slide_left, R.anim.slide_right)
//                FADE -> return Pair(R.anim.fade_in, R.anim.fade_out)
//            }
//
//            return Pair(R.anim.slide_left, R.anim.slide_right)
//        }
//    }

}
