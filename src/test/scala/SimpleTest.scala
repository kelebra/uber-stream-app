import utest.{TestSuite, _}

object SimpleTest extends TestSuite {

  val tests = TestSuite {

    "simple test here" - {
      2 + 2 ==> 4
    }
  }
}
