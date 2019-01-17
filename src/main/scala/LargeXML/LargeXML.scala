package LargeXML

import scala.xml.pull.XMLEventReader

object LargeXML {
  def main(args: Array[String]): Unit = {

    val source = scala.io.Source.fromInputStream(inputStream)
    val reader = new XMLEventReader(source)

  }
}
