package WebLog

import java.net.URI

import org.apache.hc.core5.net.URLEncodedUtils
import java.nio.charset.Charset

import scala.collection.JavaConversions._
import org.apache.hc.core5.http.NameValuePair

object WebLogParser {
  def output(params: java.util.List[NameValuePair]): Unit = {
    for (param: NameValuePair <- params) {
      println(param.getName + " : " + param.getValue())
    }
  }

  def main(args: Array[String]): Unit = {
    val fullUrl = "http://www.example.com/something.html?one=1&two=2&three=3&three=3a"
    val paramsFullUrl = URLEncodedUtils.parse(new URI(fullUrl), Charset.forName("utf-8"))
    output(paramsFullUrl)

    val queryUrl = "one=1&two=2&three=3&three=3a"
    val paramsQuery = URLEncodedUtils.parse(queryUrl, Charset.forName("utf-8"))
    output(paramsQuery)
  }
}
