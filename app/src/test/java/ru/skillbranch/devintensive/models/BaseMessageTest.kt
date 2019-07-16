package ru.skillbranch.devintensive.models

import org.junit.Assert.assertEquals
import org.junit.Test
import java.time.Instant
import java.time.temporal.ChronoUnit
import java.util.*

class BaseMessageTest {

    @Test
    fun test_message_factory() {
        val user = User.makeUser("Василий Пупкин")
        val date = Date()
        BaseMessage.makeMessage(user, Chat("0"), date, "any text message", "text") //Василий отправил сообщение "any text message" только что
        BaseMessage.makeMessage(user, Chat("0"), date, "https://anyurl.com", "image") //Василий получил изображение "https://anyurl.com" 2 часа назад
    }

    /**Необходимо создать абстрактный класс BaseMessage содержащий сделующие свойства:
    val id: String,
    val from: User?,
    val chat: Chat,
    val isIncoming: Boolean = false,
    val date: Date = Date()
    и абстрактный метод formatMessage() - возвращает строку содержащюю информацию о id сообщения, имени получателя/отправителя, виде сообщения ("получил/отправил") и типе сообщения ("сообщение"/"изображение")

    Реализуй паттерн AbstractFactory с методом makeMessage(from, chat, date, type, payload, isIncoming = false) принимающий в качесте аргументов пользователя создавшего сообщение, чат к которому относится сообщение, дата сообщения и его тип ("text/image"), полезную нагрузку
    Пример:
    BaseMessage.makeMessage(user, chat, date, "any text message", "text") //Василий отправил сообщение "any text message" только что
    BaseMessage.makeMessage(user, chat, date, "https://anyurl.com", "image",true) //Василий получил изображение "https://anyurl.com" 2 часа назад*/
    @Test
    fun formatMessage() {
        val user = User.makeUser("Василий")
        assertEquals("Василий отправил сообщение \"any text message\" только что",
            BaseMessage.makeMessage(user, Chat("0"), Date(),"text", "any text message").formatMessage())
        
        val twoHoursEarlier = Date.from(Instant.now().minus(2, ChronoUnit.HOURS))
        assertEquals("Василий получил изображение \"https://anyurl.com\" 2 часа назад",
            BaseMessage.makeMessage(user, Chat("0"),
            twoHoursEarlier, "image","https://anyurl.com",true).formatMessage())
    }
}