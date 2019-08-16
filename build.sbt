import scala.sys.process._

name := "2020.flatmap.no"
scalaVersion := "2.13.0"
crossPaths := false

libraryDependencies += "com.lihaoyi" %% "scalatags" % "0.7.0"

enablePlugins(SbtWeb)
Assets/excludeFilter := "*.scss" | "utils"

lazy val Site = config("site")

Site/run/fork := true

Site/packageBin := {
  val public = file("public")
  (Compile/run).toTask(" public").value
  IO.write(public / "CNAME", "2020.flatmap.no")
  IO.write(public / ".nojekyll", "")
  IO.copyDirectory((WebKeys.stage in Assets).value, public)
  public
}

Site/Keys.`package` := (Site/packageBin).value

Site/run := {
  (Site/packageBin).value
  "npx serve public".!
}

Site/publish := {
  (Site/packageBin).value
  "npx gh-pages -d public".!
}

clean := {
  clean.value
  IO.delete(file("public"))
}
