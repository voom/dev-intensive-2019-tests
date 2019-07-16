package ru.skillbranch.devintensive.models

import org.junit.Test
import ru.skillbranch.devintensive.extensions.toUserView

class UserViewTest {
    @Test
    fun test_data_maping() {
        val user = User.makeUser("Вася Пупкин")
        println(user)
        val userView = user.toUserView()
        userView.printMe()
    }
}
