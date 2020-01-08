package it.skrape.core

import it.skrape.core.fetcher.UrlBuilder
import it.skrape.skrape
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class RequestTest {

    @Test
    fun `can build url via dsl`() {
        val client = skrape {
            url = urlBuilder {
                protocol = UrlBuilder.Protocol.HTTPS
                port = 12345
                path = "/foo"
                queryParam = mapOf("foo" to "bar", "fizz" to "buzz")
                host = "foo.com"
            }
            this
        }

        expectThat(client.url).isEqualTo("https://foo.com:12345/foo?foo=bar&fizz=buzz")
    }
}
