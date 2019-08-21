package com.example.cleanarchitectury.users.deleteall

import com.example.cleanarchitectury.users.repository.UserRepositoryAccess
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import org.junit.Test

class UserDeleterTest {
    private val userRepository = mock<UserRepositoryAccess>()

    private val subject = UserDeleter(userRepository)

    @Test
    fun `test if repository is being called when delete usecase is invoked`(){
        subject.deleteAll()
        verify(userRepository, times(1)).deleteAll()
    }
}