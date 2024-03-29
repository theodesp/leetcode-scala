// build.sc
import mill._, scalalib._, scalafmt._

trait CommonModule extends ScalaModule {
  def scalaVersion = "2.13.0"
}

object Leetcode extends CommonModule with ScalafmtModule {
  def ivyDeps = Agg(ivy"com.lihaoyi::os-lib:0.3.0")

  def compileIvyDeps = Agg(ivy"com.lihaoyi::acyclic:0.2.0")
  def scalacOptions = Seq("-P:acyclic:force")
  def scalacPluginIvyDeps = Agg(ivy"com.lihaoyi::acyclic:0.2.0")

  object Problems extends CommonModule {
    def moduleDeps = Seq(Leetcode)
  }

  object test extends Tests {
    def ivyDeps = Agg(ivy"com.lihaoyi::utest:0.7.1")
    def testFrameworks = Seq("utest.runner.Framework")
  }
}

object Grokking extends CommonModule with ScalafmtModule {
  def ivyDeps = Agg(ivy"com.lihaoyi::os-lib:0.3.0")

  def compileIvyDeps = Agg(ivy"com.lihaoyi::acyclic:0.2.0")
  def scalacOptions = Seq("-P:acyclic:force")
  def scalacPluginIvyDeps = Agg(ivy"com.lihaoyi::acyclic:0.2.0")

  object test extends Tests {
    def ivyDeps = Agg(ivy"com.lihaoyi::utest:0.7.1")
    def testFrameworks = Seq("utest.runner.Framework")
  }
}
