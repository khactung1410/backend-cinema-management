// @GENERATOR:play-routes-compiler
// @SOURCE:/Volumes/DataTungDK/Documents/Scala/backend-cinema-management/conf/routes
// @DATE:Mon Oct 14 21:54:22 ICT 2019


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
