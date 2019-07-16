package ru.skillbranch.devintensive.extensions

import org.junit.Assert.assertEquals
import org.junit.Test
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

class DateKtTest {
    /**Реализуй extension Date.format(pattern) возвращающий отформатированную дату по паттерну передаваемому в качестве аргумента (значение по умолчанию "HH:mm:ss dd.MM.yy" локаль "ru")
    Пример:
    Date().format() //14:00:00 27.06.19
    Date().format("HH:mm") //14:00*/
    @Test
    fun test_formatting() {
        val instant = LocalDateTime.of(2019, 6, 27, 14, 0, 0).atZone(ZoneId.systemDefault()).toInstant()
        assertEquals("14:00:00 27.06.19", Date.from(instant).format())
        assertEquals("14:00", Date.from(instant).format("HH:mm"))
    }

    /**Реализуй extension Date.add(value, TimeUnits) добавляющий или вычитающий значение переданное первым аргументом в единицах измерения второго аргумента (enum TimeUnits [SECOND, MINUTE, HOUR, DAY]) и возвращающий модифицированный экземпляр Date
    Пример:
    Date().add(2, TimeUnits.SECOND) //Thu Jun 27 14:00:02 GST 2019
    Date().add(-4, TimeUnits.DAY) //Thu Jun 23 14:00:00 GST 2019*/
    @Test
    fun test_addition() {
        val instant = LocalDateTime.of(2019, 6, 27, 14, 0, 0).atZone(ZoneId.systemDefault()).toInstant()
        assertEquals("14:00:02 27.06.19", Date.from(instant).add(2, TimeUnits.SECOND).format())
        assertEquals("14:00:00 23.06.19", Date.from(instant).add(-4, TimeUnits.DAY).format())
    }

    /**
     * Реализуй extension Date.humanizeDiff(date) (значение по умолчанию текущий момент времени) для форматирования
     * вывода разницы между датами в человекообразном формате, с учетом склонения числительных.
     * Пример:
     *      Date().add(-2, TimeUnits.HOUR).humanizeDiff() //2 часа назад
     *      Date().add(-5, TimeUnits.DAY).humanizeDiff() //5 дней назад
     *      Date().add(2, TimeUnits.MINUTE).humanizeDiff() //через 2 минуты
     *      Date().add(7, TimeUnits.DAY).humanizeDiff() //через 7 дней
     *      Date().add(-400, TimeUnits.DAY).humanizeDiff() //более года назад
     *      Date().add(400, TimeUnits.DAY).humanizeDiff() //более чем через год
     */
    @Test
    fun test_humanizeDiff() {
        assertEquals("2 часа назад", Date().add(-2, TimeUnits.HOUR).humanizeDiff())
        assertEquals("5 дней назад", Date().add(-5, TimeUnits.DAY).humanizeDiff())
        assertEquals("через 2 минуты", Date().add(2, TimeUnits.MINUTE).humanizeDiff())
        assertEquals("через 7 дней", Date().add(7, TimeUnits.DAY).humanizeDiff())
        assertEquals("более года назад", Date().add(-400, TimeUnits.DAY).humanizeDiff())
        assertEquals("более чем через год", Date().add(400, TimeUnits.DAY).humanizeDiff())
        assertEquals("только что", Date().add(-1, TimeUnits.SECOND).humanizeDiff())
        assertEquals("несколько секунд назад", Date().add(-45, TimeUnits.SECOND).humanizeDiff())
        assertEquals("минуту назад", Date().add(-46, TimeUnits.SECOND).humanizeDiff())
        assertEquals("1 минуту назад", Date().add(-76, TimeUnits.SECOND).humanizeDiff())
        assertEquals("минуту назад", Date().add(-1, TimeUnits.MINUTE).humanizeDiff())
        assertEquals("2 минуты назад", Date().add(-2, TimeUnits.MINUTE).humanizeDiff())
        assertEquals("3 минуты назад", Date().add(-3, TimeUnits.MINUTE).humanizeDiff())
        assertEquals("45 минут назад", Date().add(-45, TimeUnits.MINUTE).humanizeDiff())
        assertEquals("час назад", Date().add(-1, TimeUnits.HOUR).humanizeDiff())
        assertEquals("1 час назад", Date().add(-76, TimeUnits.MINUTE).humanizeDiff())
        assertEquals("2 часа назад", Date().add(-120, TimeUnits.MINUTE).humanizeDiff())
        assertEquals("3 часа назад", Date().add(-3, TimeUnits.HOUR).humanizeDiff())
        assertEquals("4 часа назад", Date().add(-4, TimeUnits.HOUR).humanizeDiff())
        assertEquals("5 часов назад", Date().add(-5, TimeUnits.HOUR).humanizeDiff())
        assertEquals("день назад", Date().add(-26, TimeUnits.HOUR).humanizeDiff())
        assertEquals("1 день назад", Date().add(-27, TimeUnits.HOUR).humanizeDiff())
        assertEquals("4 дня назад", Date().add(-4, TimeUnits.DAY).humanizeDiff())
        assertEquals("5 дней назад", Date().add(-5, TimeUnits.DAY).humanizeDiff())
        assertEquals("360 дней назад", Date().add(-360, TimeUnits.DAY).humanizeDiff())
        assertEquals("более года назад", Date().add(-361, TimeUnits.DAY).humanizeDiff())
    }

    @Test
    fun test_modulo() {
        println(1236L.rem(10))
        assertEquals(42 % 10, 42.rem(10))
    }
}