package br.com.aramizu.idog.commons

import android.content.Context
import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.annotation.Nullable

abstract class BaseFragment : Fragment(), BaseContracts.View {

    private var activity: BaseActivity? = null

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is BaseActivity) {
            val activity = context as BaseActivity?
            this.activity = activity
        }
    }

    override fun showLoading() {
        activity?.showLoading()
    }

    override fun hideLoading() {
        activity?.hideLoading()
    }

    override fun showDialog(resTitleId: Int, resMessageId: Int) {
        activity?.showDialog(resTitleId, resMessageId)
    }

    override fun showDialog(title: String?, message: String) {
        activity?.showDialog(title, message)
    }

    override fun getBaseActivity(): BaseActivity? {
        return activity
    }

}
