package com.qyh.kotlinweatherapp.ui

import android.app.Activity
import android.content.res.Resources
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import com.qyh.kotlinweatherapp.widget.dialog.LoadingDialog
import com.qyh.kotlinweatherapp.widget.dialog.LoadingDialog.Companion.createProgrssDialog


/**
 * Created by dan.y on 2017/6/21.
 */
open class BaseActivity : AppCompatActivity() {
    protected var progressDialog: LoadingDialog?=null
    protected var mResources :Resources?=null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        mResources = this.resources
    }

    protected  fun getRootContext():Activity = getRootContext(this)

    private fun getRootContext(act: Activity): Activity = if(act.isChild) getRootContext(act.parent) else act

    override fun onCreateOptionsMenu(menu: Menu?): Boolean = true

    /**
     * 显示加载
     * @param showMessage
     */
    fun showWaiting() {
        progressDialog?.dismiss()
        progressDialog = null
        progressDialog = createProgrssDialog(getRootContext())
        progressDialog?.show()
    }

    fun stopWaiting() {
        progressDialog?.dismiss()
        progressDialog = null
    }

}