package org.mbds.unice.github.ui.users

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.mbds.unice.github.R
import org.mbds.unice.github.data.model.User

class ListUserActivity : AppCompatActivity(), UserListAdapter.Listener {
    // TODO : Utiliser viewBinding
    lateinit var recyclerView: RecyclerView
    lateinit var fab: FloatingActionButton

    // By lazy permet de faire du chargement parresseux,
    // L'adapteur sera crée au premier appel
    private val adapter: UserListAdapter by lazy {
        UserListAdapter(this)
    }

    private val viewModel: UserViewModel by lazy {
        ViewModelProvider(this)[UserViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_user)
        configureFab()
        configureRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        viewModel.users.observe(this) {
            adapter.updateList(it)
        }
    }

    private fun configureRecyclerView() {
        recyclerView = findViewById(R.id.activity_list_user_rv)
        recyclerView.adapter = adapter
    }

    private fun configureFab() {
        fab = findViewById(R.id.activity_list_user_fab)
        fab.setOnClickListener {
            //TODO("Ajouter un utilisateur aléatoire")
            viewModel.generateRandomUser()
            configureRecyclerView()
        }
    }

    override fun onClickDelete(user: User) {
        //TODO("Ajouter des logs pour tracer les actions de l'utilisateur")
        //TODO("Ajouter une boite de dialogue pour confirmer la suppression et supprimer l'utilisateur si l'utilisateur confirme")
        viewModel.deleteUser(user)
        configureRecyclerView()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_sort_users, menu)

        // Get the SearchView and set the searchable configuration
        val searchItem = menu?.findItem(R.id.action_search)
        val searchView = searchItem?.actionView as? SearchView

        // Set a query hint for the user
        searchView?.queryHint = "Search by name"

        // Set up the listener for search query changes
        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false // We don't use the submit action
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // Call the method to filter the list of users based on the query
                filterUsersByName(newText)
                return true
            }
        })

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_sort_asc -> {
                sortUsersAlphabetically(true)
                true
            }
            R.id.menu_sort_desc -> {
                sortUsersAlphabetically(false)
                true
            }
            R.id.menu_sort_date_asc -> {
                sortUsersByDate(true)
                true
            }
            R.id.menu_sort_date_desc -> {
                sortUsersByDate(false)
                true
            }
            R.id.sort_by_status -> {
                sortUsersByStatus()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun sortUsersAlphabetically(ascending: Boolean) {
        val sortedList = if (ascending) {
            viewModel.users.value?.sortedBy { it.login }
        } else {
            viewModel.users.value?.sortedByDescending { it.login }
        }
        sortedList?.let { adapter.updateList(it) }
    }

    private fun sortUsersByDate(ascending: Boolean) {
        val sortedList = if (ascending) {
            viewModel.users.value?.sortedBy { it.creationDate }
        } else {
            viewModel.users.value?.sortedByDescending { it.creationDate }
        }
        sortedList?.let { adapter.updateList(it) }
    }

    private fun sortUsersByStatus() {
        val sortedList = viewModel.users.value?.sortedBy { it.isActive }
        sortedList?.let { adapter.updateList(it) }
    }

    private fun filterUsersByName(query: String?) {
        query?.let {
            val filteredList = viewModel.users.value?.filter { user ->
                user.login.contains(query, ignoreCase = true)
            }
            adapter.updateList(filteredList ?: listOf())
        }
    }
}