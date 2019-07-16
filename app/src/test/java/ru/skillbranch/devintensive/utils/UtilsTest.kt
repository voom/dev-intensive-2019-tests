package ru.skillbranch.devintensive.utils

import org.junit.Assert.assertEquals
import org.junit.Test

class UtilsTest {

    /**Реализуй метод Utils.parseFullName(fullName) принимающий в качестве аргумента полное имя пользователя (null, пустую строку) и возвращающий пару значений Pair(firstName, lastName) при невозможности распарсить полное имя или его часть вернуть null null/"firstName" null
    Пример:
    Utils.parseFullName(null) //null null
    Utils.parseFullName("") //null null
    Utils.parseFullName(" ") //null null
    Utils.parseFullName("John") //John null*/
    @Test
    fun test_parseFullName() {
        assertEquals(null to null, Utils.parseFullName(null))
        assertEquals(null to null, Utils.parseFullName(""))
        assertEquals(null to null, Utils.parseFullName(" "))
        assertEquals("John" to null, Utils.parseFullName("John "))
        assertEquals(null to "Wick", Utils.parseFullName(" Wick"))
        assertEquals("John" to "Wick", Utils.parseFullName("John  Wick"))
    }

    /**Реализуй метод Utils.toInitials(firstName lastName) принимающий в качестве аргументов имя и фамилию пользователя (null, пустую строку) и возвращающий строку с первыми буквами имени и фамилии в верхнем регистре (если один из аргументов null то вернуть один инициал, если оба аргумента null вернуть null)
    Пример:
    Utils.toInitials("john" ,"doe") //JD
    Utils.toInitials("John", null) //J
    Utils.toInitials(null, null) //null
    Utils.toInitials(" ", "") //null*/
    @Test
    fun test_toInitials() {
        assertEquals("JD", Utils.toInitials("john", "doe"))
        assertEquals("J", Utils.toInitials("John", null))
        assertEquals(null, Utils.toInitials(null, null))
        assertEquals(null, Utils.toInitials(" ", ""))
    }

    /**Реализуй метод Utils.transliteration(payload divider) принимающий в качестве аргумента строку (divider по умолчанию " ") и возвращающий преобразованную строку из латинских символов, словарь символов соответствия алфовитов доступен в ресурсах к заданию
    Пример:
    Utils.transliteration("Женя Стереотипов") //Zhenya Stereotipov
    Utils.transliteration("Amazing Петр","_") //Amazing_Petr*/
    @Test
    fun test_transliteration() {
        assertEquals("Ivan Stereotipov", Utils.transliteration("Иван Стереотипов"))
        assertEquals("Amazing_Petr", Utils.transliteration("Amazing Петр", "_"))
        assertEquals("Zh Zh", Utils.transliteration("Ж Ж"))
        assertEquals("ZhZh", Utils.transliteration("ЖЖ"))
        assertEquals("AbrAKadabra", Utils.transliteration("AbrAKadabra"))
        assertEquals("StraNNIi NikVash'e", Utils.transliteration("СтраННЫй НикВаще"))
        assertEquals("Privet mir", Utils.transliteration("Привет мир"))
        assertEquals("    Privet    mir   ", Utils.transliteration("    Привет    мир   "))
        assertEquals("pRIvet mir", Utils.transliteration("pRIвет мир"))
        assertEquals("PRIvet Mir", Utils.transliteration("PRIвет Mир"))
        assertEquals("PRIvet1345 Mir", Utils.transliteration("PRIвет1345 Mир"))
        assertEquals("[]{}PRIvet Mir/", Utils.transliteration("[]{}PRIвет Mир/"))
        assertEquals("[]{}PRIvet____Mir/", Utils.transliteration("[]{}PRIвет    Mир/", "_"))
        assertEquals("[_444__444__444__444_]{}PRIvet_444__444_Mir/", Utils.transliteration("[    ]{}PRIвет  Mир/", "_444_"))
    }
}