package scalaexamples.higherorderfunctions

import junit.framework.Assert._
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(classOf[Suite])
class PersonFiltrererTest {
  
  val personFiltrerer = new PersonFiltrerer
  
  val alf = Person("Alf Kristian", "Støyle", 30)
  val fredrik = Person("Fredrik", "Vraalsen", 33)
  val personer = alf :: fredrik :: Nil
  
  val alle = (p: Person) => true
  val ingen = (p: Person) => false
  
  def testTomListe {
    val personer = Nil
    assertEquals(Nil, personFiltrerer.filtrerPersoner(personer, ingen))
    assertEquals(Nil, personFiltrerer.filtrerPersoner(personer, alle))
  }

  def testAlle {
    assertEquals(personer, personFiltrerer.filtrerPersoner(personer, alle))
  }
  
  def testIngen {
    assertEquals(Nil, personFiltrerer.filtrerPersoner(personer, ingen))
  }
  
  def testAlleOver30 {
    assertEquals(fredrik :: Nil, personFiltrerer.filtrerPersoner(personer, _.alder > 30))
  }

  def testAlleUnge {
    assertEquals(alf :: Nil, personFiltrerer.filtrerPersoner(personer, _.alder <= 30))
  }

}
