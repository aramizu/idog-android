package br.com.aramizu.idog.commons

import android.content.Context
import android.support.annotation.StringRes

interface BaseContracts {

    interface View {
        fun showDialog(@StringRes resTitleId: Int, @StringRes resMessageId: Int)
        fun showDialog(title: String?, message: String)
        fun getContext(): Context
        fun getBaseActivity(): BaseActivity?
        fun showLoading()
        fun hideLoading()
    }
}
