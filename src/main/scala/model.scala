package website

import scalatags.Text.all._

object SiteConfig {
  val contextPath = ""
}

case class Page(name: String, title: String)(val content: Modifier*)

object Html {

  import SiteConfig._

  /**
  *
   *
   * @param page
   * @return
   */
  def render(page: Page) = {
    val title = "flatMap(Oslo) 2020"
    val description = s"$title - functional programming conference"
    html(
      head(
        tag("title")(title + " " + page.title),
        meta(name := "charset", content := "utf-8"),
        meta(name := "X-UA-Compatible", content := "IE=edge"),
        meta(name := "viewport", content := "width=device-width, initial-scale=1.0"),
        meta(name := "og:title", content := title),
        meta(name := "og:image", content := s"$contextPath/images/flatmap_identity.png"),
        meta(name := "og:description", content := description),
        meta(name := "description", content := description),
        meta(name := "twitter:site", content := "@flatmaposlo"),
        meta(name := "twitter:card", content := "summary"),
        meta(name := "author", content := "Arktekk AS"),
        link(href := "https://fonts.googleapis.com/css?family=Roboto|Roboto+Slab|Rock+Salt&display=swap", rel := "stylesheet"),
        link(href := s"$contextPath/css/style.css", rel := "stylesheet"),
        link(href := s"$contextPath/img/favicon.ico", rel := "shortcut icon"),
        script(`type` := "text/javascript")(
          raw(
            """(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
              |(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
              |m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
              |})(window,document,'script','//www.google-analytics.com/analytics.js','ga');
              |
              |ga('create', 'UA-73592123-1', 'auto');
              |ga('send', 'pageview');
            """.stripMargin
          )
        )
      ),
      body(cls := s"page ${page.name}")(page.content)
    )
  }
}