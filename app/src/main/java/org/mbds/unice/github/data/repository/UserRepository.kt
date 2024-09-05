package org.mbds.unice.github.data.repository

import android.icu.lang.UCharacter.GraphemeClusterBreak.L
import org.mbds.unice.github.data.api.ApiService
import org.mbds.unice.github.data.api.FakeApiServiceGenerator.FAKE_USERS
import org.mbds.unice.github.data.api.FakeApiServiceGenerator.FAKE_USERS_RANDOM
import org.mbds.unice.github.data.model.User

class UserRepository(private val apiService: ApiService) {

    fun getUsers(): List<User> {
        //return FAKE_USERS
        return apiService.getUsers()
    }

    fun addRandomUser() {
        apiService.addRandomUser()
    }

    fun deleteUser(user: User) {
        apiService.deleteUser(user)
    }

    fun updateUser(user: User) {
        apiService.updateUser(user)
    }
}