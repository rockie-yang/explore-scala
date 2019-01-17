package ScalaScraper

import net.ruippeixotog.scalascraper.browser.JsoupBrowser
import net.ruippeixotog.scalascraper.dsl.DSL._
import net.ruippeixotog.scalascraper.dsl.DSL.Extract._
import net.ruippeixotog.scalascraper.dsl.DSL.Parse._
import net.ruippeixotog.scalascraper.model._

import scala.collection.mutable


object Scraper {
  def main(args: Array[String]): Unit = {

    val browser = JsoupBrowser()
//    val doc = browser.get("http://www.stateair.net/web/historical/1/1.html")
    val stream = this.getClass.getClassLoader.getResourceAsStream("stateair.html")

    val rootDoc = browser.parseInputStream(stream)
    val hists = historicals(rootDoc)

    val allCSVs = hists.map(url => browser.get(url)).flatMap(doc => csvs(doc))

    println(allCSVs.mkString("\n"))
  }


  val parsedHistoricals = mutable.Set[String]()
  val csvLinks = mutable.Set[String]()

  def csvs(doc: Document): Iterable[String] = {
    val as = doc >> extractor("a", elements)
    val hrefs = as.map(a => a.attr("href"))

    hrefs.filter(href => href.trim.endsWith(".csv"))
  }

  /**
    * sample href : http://www.stateair.net/web/post/1/1.html
    *
    * @param doc
    * @return
    */
  def historicals(doc: Document): Iterable[String] = {
    val as = doc >> extractor("a", elements)
    val hrefs = as.map(a => a.attr("href"))

    hrefs.filter(href => href.contains("post")).map(href => href.replace("post", "historical"))
  }
}
