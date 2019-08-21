package com.example.cleanarchitectury.users.save

import com.example.cleanarchitectury.users.repository.UserRepositoryAccess
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import org.junit.Test

class UserSaverTest {
    private val userRepository = mock<UserRepositoryAccess>()

    private val subject = UserSaver(userRepository)

    @Test
    fun `test if repository is being called when save usecase is invoked`(){
        subject.save("Peter","Parker")
        verify(userRepository, times(1)).save(any())
    }
}