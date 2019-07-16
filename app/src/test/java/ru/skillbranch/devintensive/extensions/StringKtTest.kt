package ru.skillbranch.devintensive.extensions

import org.junit.Assert.assertEquals
import org.junit.Test

class StringKtTest {

    /**
     * Реализуй extension усекающий исходную строку до указанного числа символов (по умолчанию 16) и возвращающий усеченную строку с заполнителем
     * "..." (если строка была усечена) если последний символ усеченной строки является пробелом - удалить его и добавить заполнитель
     * Пример:
     * "Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate() //Bender Bending R...
     * "Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate(15) //Bender Bending...
     * "A     ".truncate(3) //A
     */
    @Test
    fun test_truncation() {
        assertEquals("Bender Bending Ro...",
            "Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate()
        )
        assertEquals("Bender Bending R...",
            "Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate(15))
        assertEquals("A",  "A     ".truncate(3))
        assertEquals("  B",  "  B     ".truncate(3))
    }

    /**
     * Реализуй extension позволяющий очистить строку от html тегов и html escape последовательностей ("& < > ' ""),
     * а так же удалить пустые символы (пробелы) между словами если их больше 1.
     * Необходимо вернуть модифицированную строку
     * Пример:
     * "<p class="title">Образовательное IT-сообщество Skill Branch</p>".stripHtml() //Образовательное IT-сообщество Skill Branch
     * "<p>Образовательное       IT-сообщество Skill Branch</p>".stripHtml() //Образовательное IT-сообщество Skill Branch
     */
    @Test
    fun test_stripHtml() {
        assertEquals("Образовательное IT-сообщество Skill Branch",
            "<p class=\"title\">Образовательное IT-сообщество Skill Branch</p>".stripHtml())
        assertEquals("Образовательное IT-сообщество Skill Branch",
            "<p>Образовательное       IT-сообщество Skill Branch</p>".stripHtml())
        assertEquals("Образовательное IT-сообщество Skill Branch",
            "<p class=\"title\">Образовательное IT-сообщество <span style=\"color: #3333\">Skill Branch</span></p>".stripHtml())
        assertEquals("Lorem ipsum blah Ha-ha-ha",
            ("<div>\n" +
                    "Lorem ipsum    blah <span style=\"color: #3333\">Ha-ha-ha</span>\n" +
            "</div>").stripHtml())
        assertEquals("Спецсимволы :“”.\"\"&<>’”'",
            "<pre>Спецсимволы       :&ldquo;&rdquo;.&#34;&quot;&amp;&lt;&#62;&rsquo;&#148;&apos;</pre>".stripHtml())
    }
}
