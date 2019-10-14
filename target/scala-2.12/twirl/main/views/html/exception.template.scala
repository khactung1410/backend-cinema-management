
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

object exception extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(messages: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/main("Exception")/*3.19*/ {_display_(Seq[Any](format.raw/*3.21*/("""
    """),format.raw/*4.5*/("""<h3>"""),_display_(/*4.10*/messages),format.raw/*4.18*/("""</h3>
""")))}))
      }
    }
  }

  def render(messages:String): play.twirl.api.HtmlFormat.Appendable = apply(messages)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (messages) => apply(messages)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2019-10-14T21:54:22.766
                  SOURCE: /Volumes/DataTungDK/Documents/Scala/backend-cinema-management/app/views/exception.scala.html
                  HASH: 25e8f233aa50b0fa710fbbc2c931916649e0a909
                  MATRIX: 733->1|845->20|872->22|897->39|936->41|967->46|998->51|1026->59
                  LINES: 21->1|26->2|27->3|27->3|27->3|28->4|28->4|28->4
                  -- GENERATED --
              */
          