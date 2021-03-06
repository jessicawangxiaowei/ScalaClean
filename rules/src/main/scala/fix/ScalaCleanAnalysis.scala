package fix

import scalaclean.model.{ModelHelper, ScalaCleanModel}
import scalaclean.model.analysis._
import scalafix.v1._

import scala.meta.{Defn, _}

class ScalaCleanAnalysis extends SemanticRule("ScalaCleanAnalysis")  {
  val model = new ScalaCleanModel()

  override def beforeStart(): Unit = {
    println("Analysis BEFORE START")
  }

  override def afterComplete(): Unit = {
    ModelHelper.model = Some(model)
    println("Analysis AFTER COMPLETE")
  }

  override def fix(implicit doc: SemanticDocument): Patch = {
    model.analyse(doc)
    Patch.empty
  }

}
