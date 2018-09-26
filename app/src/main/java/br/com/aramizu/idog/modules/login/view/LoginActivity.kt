package br.com.aramizu.idog.modules.login.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.aramizu.idog.R
import br.com.aramizu.idog.modules.login.contracts.LoginContract
import br.com.aramizu.idog.modules.login.router.LoginRouter
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginContract.View {

    override lateinit var presenter: LoginContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        LoginRouter.assembleModule(this)

        setUpListeners()
    }

    private fun setUpListeners() {
        buttonLogin.setOnClickListener {
            presenter.login()
        }
    }

}
