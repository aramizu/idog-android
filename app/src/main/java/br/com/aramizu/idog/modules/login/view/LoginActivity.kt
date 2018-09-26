package br.com.aramizu.idog.modules.login.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import br.com.aramizu.idog.R
import br.com.aramizu.idog.commons.BaseActivity
import br.com.aramizu.idog.modules.login.contracts.LoginContract
import br.com.aramizu.idog.modules.login.router.LoginRouter
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity(), LoginContract.View {

    override lateinit var presenter: LoginContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        LoginRouter.assembleModule(this)

        setUpListeners()
    }

    private fun setUpListeners() {
        buttonLogin.setOnClickListener {
            presenter.login(editTextEmail.text.toString())
        }
        editTextEmail.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) { textViewEmailError.text = String() }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })
    }

    override fun showFormMessageError(message: String) {
        textViewEmailError.text = message
    }

}
