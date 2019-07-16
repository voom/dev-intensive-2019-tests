package ru.skillbranch.devintensive.models

import org.hamcrest.CoreMatchers.instanceOf
import org.junit.Assert.assertThat
import org.junit.Test

class UserTest {

    @Test
    fun test_user_instance() {
        val user = User("1", "John", "Doe")
        println("instantiated: $user")
    }

    @Test
    fun test_user_factory() {
        val user = User.makeUser("John Doe")
        println("made with factory: $user")
    }

    /**
     * Реализуй паттерн Builder для класса User.
     * User.Builder()
     *      .id(s)
     *      .firstName(s)
     *      .lastName(s)
     *      .avatar(s)
     *      .rating(n)
     *      .respect(n)
     *      .lastVisit(d)
     *      .isOnline(b)
     *      .build()
     *  должен вернуть объект User
     */
    @Test
    fun test_builder() {
        val user = User.Builder()
            .id("123")
            .firstName("Vasya")
            .lastName("Пупкин")
            .avatar(null)
            .rating(1)
            .respect(1)
            .lastVisit(null)
            .isOnline(false)
            .build()
        println(user)
        val user2 = User.Builder()
            .firstName("Vasya")
            .lastName("Пупкин")
            .avatar(null)
            .rating(1)
            .respect(1)
            .lastVisit(null)
            .isOnline(false)
            .build()
        println(user2)
        val user3 = User.Builder()
            .firstName("Vasya")
            .lastName("Пупкин")
            .avatar(null)
            .rating(1)
            .respect(1)
            .lastVisit(null)
            .isOnline(false)
            .build()
        println(user3)
        assertThat(user, instanceOf(User::class.java))
    }
}