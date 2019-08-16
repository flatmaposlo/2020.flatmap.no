package website

import scalatags.Text.all._

object Pages {
  val index = Page("index", "")(
    header(cls := "logo")(
      div(cls := "wrap")(img(src := "/img/logo.svg"), h1("flatMap(Oslo) 2020"))
    ),
    tag("main")(
      header(cls := "wrap")(
        h2("14 & 15 May 2020"),
        p(cls := "sub")("Oslo, Norway")
      )
    ),
    footer(
      div(cls := "wrap")(
        div(cls := "contact")(
          div(cls := "mail")(
            a(href := "mailto:flatmap@arktekk.no")("flatmap@arktekk.no")
          ),
          div(cls := "twitter")(
            a(href := "https://twitter.com/flatmaposlo")("@flatmaposlo")
          )
        ),
        div(cls := "previous")(
          div("Previous years"),
          ul(
            li(a(href := "https://web.archive.org/web/20120519235017/http://flatmap.no/")("2012")),
            li(a(href := "https://2013.flatmap.no")("2013")),
            li(a(href := "https://2014.flatmap.no")("2014")),
            li(a(href := "https://2015.flatmap.no")("2015")),
            li(a(href := "https://2016.flatmap.no")("2016")),
            li(a(href := "https://2017.flatmap.no")("2017")),
            li(a(href := "https://2018.flatmap.no")("2018")),
            li(a(href := "https://2019.flatmap.no")("2019")),
          )
        )
      )
    )
  )

  val fourohfour =
    Page("404", "")(div(cls := "wrap")(h1("This page did not exist...")))
}
