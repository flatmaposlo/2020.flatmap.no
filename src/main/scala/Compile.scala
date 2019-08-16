package website

import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Path, Paths}

object Compile {
  def main(args: Array[String]): Unit = {
    val output = Paths.get(args.headOption.getOrElse("public"))
    Files.createDirectories(output)

    write(output.resolve("index.html"), Pages.index)
    write(output.resolve("404.html"), Pages.fourohfour)
  }

  private def write(file: Path, page: Page): Unit = {
    Files.write(file, Html.render(page).render.getBytes(StandardCharsets.UTF_8))
  }
}
