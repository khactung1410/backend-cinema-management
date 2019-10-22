// @GENERATOR:play-routes-compiler
<<<<<<< HEAD
// @SOURCE:/Users/Tung_DK/Documents/Training/Code/backend-cinema-management/conf/routes
// @DATE:Mon Oct 21 11:01:16 ICT 2019
=======
// @SOURCE:/Volumes/DataTungDK/Documents/Scala/backend-cinema-management/conf/routes
// @DATE:Mon Oct 21 23:47:29 ICT 2019
>>>>>>> f5f41015ae1ebbd5e8ed850463a67064fbffea68


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
