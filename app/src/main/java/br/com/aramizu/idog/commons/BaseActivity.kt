package br.com.aramizu.idog.commons

import android.content.Context
import android.support.annotation.StringRes
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import br.com.aramizu.idog.components.LoadingDialog
import org.jetbrains.anko.alert
import org.jetbrains.anko.yesButton

abstract class BaseActivity : AppCompatActivity(), BaseContracts.View {

    private var loadingDialog: LoadingDialog? = null

    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
        loadingDialog = LoadingDialog(this)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun getContext(): Context {
        return this
    }

    override fun getBaseActivity(): BaseActivity? {
        return this
    }

    override fun showLoading() {
        loadingDialog?.showDialog()
    }

    override fun hideLoading() {
        loadingDialog?.hideDialog()
    }

    override fun showDialog(@StringRes resTitleId: Int, @StringRes resMessageId: Int) {
        showDialog(getString(resTitleId), getString(resMessageId))
    }

    override fun showDialog(title: String?, message: String) {
        alert(message, title) {
            yesButton {
                it.dismiss()
            }
        }.show()
    }
}
