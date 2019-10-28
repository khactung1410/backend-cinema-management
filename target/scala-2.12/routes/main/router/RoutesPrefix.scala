// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/Tung_DK/Documents/Training/Code/backend-cinema-management/conf/routes
// @DATE:Wed Oct 23 15:33:33 ICT 2019


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
