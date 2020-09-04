package com.paulsoia.githubauth.presentation.ui.user

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.paulsoia.githubauth.R
import com.paulsoia.githubauth.domain.repository.PreferencesRepository
import com.paulsoia.githubauth.presentation.di.GithubInjector
import com.paulsoia.githubauth.presentation.ui.user.adapter.RepoAdapter
import kotlinx.android.synthetic.main.activity_user.*
import javax.inject.Inject

class UserActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: UserViewModel
    @Inject
    lateinit var preferencesRepository: PreferencesRepository
    @Inject
    lateinit var adapter: RepoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        GithubInjector.plusUserActivityComponent(this)?.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        initListeners()
        initRecyclerView()
        getRepos()
        getWarning()
    }

    override fun onDestroy() {
        GithubInjector.clearUserActivityComponent()
        super.onDestroy()
    }

    private fun initListeners() {
        btnSearch.setOnClickListener {
            val nameRepo = etSearch.text.toString().trim()
            if (nameRepo.length < 3) Toast.makeText(this, "Write min 3 characters", Toast.LENGTH_SHORT).show()
            else viewModel.searchRepos(nameRepo)
        }
    }

    private fun initRecyclerView() {
        with(rvRepos) {
            layoutManager = LinearLayoutManager(this@UserActivity)
            adapter = this@UserActivity.adapter
        }
    }

    private fun getRepos() {
        viewModel.result.observe(this, {
            adapter.swapData(it)
        })
    }

    private fun getWarning() {
        viewModel.warningResult.observe(this, {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            Log.d("getRepos fail: ", it)
        })
    }

}