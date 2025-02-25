/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package org.hyacinthbots.allium

import com.google.gson.JsonArray
import com.google.gson.JsonParser
import com.kotlindiscord.kord.extensions.ExtensibleBot
import com.kotlindiscord.kord.extensions.modules.extra.mappings.extMappings
import me.shedaniel.linkie.utils.readText
import org.hyacinthbots.allium.extensions.About
import org.hyacinthbots.allium.extensions.EventHooks
import org.hyacinthbots.allium.extensions.Modrinth
import org.hyacinthbots.allium.extensions.PresenceUpdater
import org.hyacinthbots.allium.utils.TOKEN
import java.util.*

var splashes = JsonArray()

suspend fun main() {
    splashes = JsonParser.parseString({}.javaClass.getResource("/splashes.json")?.readText()).asJsonObject.getAsJsonArray("splashes")
    val bot = ExtensibleBot(TOKEN) {
        extensions {
            add(::EventHooks)
            add(::Modrinth)
            add(::About)
            add(::PresenceUpdater)
            extMappings {  }
        }
        i18n {
            defaultLocale = Locale.ENGLISH
        }
    }
    bot.start()
}
