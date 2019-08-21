package com.example.cleanarchitectury.users.getall

import com.example.cleanarchitectury.users.repository.UserRepositoryAccess
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import org.junit.Test


class UserGetterTest {
    private val userRepository = mock<UserRepositoryAccess>()

    private val subject = UserGetter(userRepository)

    @Test
    fun `test if repository is being called when getall usecase is invoked`(){
        subject.getAll()
        verify(userRepository, times(1)).getAll()
    }
}