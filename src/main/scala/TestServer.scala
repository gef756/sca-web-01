import com.twitter.finagle.Http

import scala.util.Properties

/**
 * Created by gabe on 8/21/15.
 */
object TestServer {
  def main(args: Array[String]) = {
    val port: Int = Properties.envOrElse("PORT", "8080").toInt
    println(s"Starting server on $port")
    val server = Http.serve(":" + port, new DumbServer)
  }
}

