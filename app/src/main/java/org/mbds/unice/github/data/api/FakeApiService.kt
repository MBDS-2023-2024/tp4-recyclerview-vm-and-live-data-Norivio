package org.mbds.unice.github.data.api

import org.mbds.unice.github.data.api.FakeApiServiceGenerator.FAKE_USERS_RANDOM
import org.mbds.unice.github.data.model.User

class FakeApiService : ApiService {
    private val _users = FakeApiServiceGenerator.FAKE_USERS

    /**
     * Return a list of [User]
     * Those users must be generated by [FakeApiServiceGenerator]
     */
    override fun getUsers(): List<User> {
        //TODO("Should return a list of fake user")
        return  _users;
    }

    /**
     * Generate a random [User] and add it [FakeApiService.users] list.
     * This user must be get from the [FakeApiServiceGenerator.FAKE_USERS_RANDOM] list.
     */
    override fun addRandomUser() {
        //TODO("Add a random user to the list")
        val userFake = FakeApiServiceGenerator.FAKE_USERS_RANDOM.random()
        FakeApiServiceGenerator.FAKE_USERS.add(userFake)
    }

    /**
     * Delete a [User] from the [FakeApiService.users] list.
     */
    override fun deleteUser(username: User) {
        //TODO("Delete a user")
        FakeApiServiceGenerator.FAKE_USERS.remove(username)
    }

    override fun updateUser(user: User){
        val index = FakeApiServiceGenerator.FAKE_USERS.indexOfFirst { it.id == user.id }
        if (index != -1) {
            FakeApiServiceGenerator.FAKE_USERS[index].isActive = !user.isActive
        }
    }
}