import com.twitter.finagle.Service
import com.twitter.finagle.http.Response
import com.twitter.util.Future
import org.jboss.netty.handler.codec.http.{HttpRequest, HttpResponse}

/**
 * Created by gabe on 8/21/15.
 */
class DumbServer extends Service[HttpRequest, HttpResponse] {
  def apply(httpRequest: HttpRequest): Future[HttpResponse] = {
    if (httpRequest.getUri.endsWith("/hi")) {
      showHi(httpRequest)
    } else {
      showHome(httpRequest)
    }
  }

  def showHome(httpRequest: HttpRequest): Future[HttpResponse] = {
    val response: Response = Response()
    response.setStatusCode(200)
    response.setContentString("Welcome to the home page!")
    Future(response)
  }

  def showHi(httpRequest: HttpRequest): Future[HttpResponse] = {
    val response: Response = Response()
    response.setStatusCode(200)
    response.setContentString("Hello hello!")
    Future(response)
  }
}
