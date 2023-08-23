package ags

import edu.gemini.ags.servlet.estimation.AgsServlet;
import edu.gemini.ags.servlet.JsonServlet
import edu.gemini.ags.conf.ProbeLimitsTable
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.server.handler.RequestLogHandler
import org.eclipse.jetty.servlet.ServletHandler
import org.eclipse.jetty.servlet.ErrorPageErrorHandler
import org.eclipse.jetty.servlet.ServletHolder

object Main {

  def main(args: Array[String]): Unit = {

    // Let's not connect to the window server
    System.setProperty("java.awt.headless", "true")

    // Construct a server on `PORT` or 8080 if not provided
    val port    = sys.env.get("PORT").fold(8080)(_.toInt)
    val server  = new Server(port)
    val handler = new ServletHandler()

    val magTable = ProbeLimitsTable.loadOrThrow()
    // Set up our handler
    handler.addServletWithMapping(new ServletHolder(new AgsServlet(magTable)), "/ags")
    handler.addServletWithMapping(new ServletHolder(new JsonServlet(magTable)), "/json-ags")

    // And start our server
    server.setHandler(handler)
    // server.setHandler(new RequestLogHandler())
    try {
      server.start()
      server.join()
    } catch {
      case t: Throwable => t.printStackTrace()
    }

  }

}
