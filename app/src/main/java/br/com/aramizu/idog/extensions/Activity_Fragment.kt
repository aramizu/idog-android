package br.com.aramizu.idog.extensions

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

fun AppCompatActivity.pushFragment(fragment: Fragment, contentFrame: Int) {
    val fragmentManager = this.supportFragmentManager
    val transaction = fragmentManager.beginTransaction()
    transaction.replace(contentFrame, fragment)
    transaction.commit()
}

fun AppCompatActivity.popFragment() {
    val fragmentManager = this.supportFragmentManager
    fragmentManager.popBackStack()
}