
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /*
 * This template is called from the `index` template. This template
 * handles the rendering of the page header and body tags. It takes
 * two arguments, a `String` for the title of the page and an `Html`
 * object to insert into the body of the page.
 */
  def apply/*7.2*/(title: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*8.1*/("""
"""),format.raw/*9.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        """),format.raw/*12.62*/("""
        """),format.raw/*13.9*/("""<title>"""),_display_(/*13.17*/title),format.raw/*13.22*/("""</title>
"""),format.raw/*14.107*/("""
"""),format.raw/*15.110*/("""
"""),format.raw/*16.108*/("""
    """),format.raw/*17.5*/("""</head>
    <body>
        <h1>Tung's Blog</h1>
        """),format.raw/*21.32*/("""
        """),_display_(/*22.10*/content),format.raw/*22.17*/("""
    """),format.raw/*23.5*/("""</body>
</html>
"""))
      }
    }
  }

  def render(title:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2019-10-14T21:54:22.782
                  SOURCE: /Volumes/DataTungDK/Documents/Scala/backend-cinema-management/app/views/main.scala.html
                  HASH: a5c4ff84ec33a9787045db34abc3a9e6ea94d20b
                  MATRIX: 987->260|1111->291|1138->292|1218->397|1254->406|1289->414|1315->419|1353->534|1383->644|1413->752|1445->757|1529->903|1566->913|1594->920|1626->925
                  LINES: 26->7|31->8|32->9|35->12|36->13|36->13|36->13|37->14|38->15|39->16|40->17|43->21|44->22|44->22|45->23
                  -- GENERATED --
              */
          