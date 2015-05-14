import com.sun.jna.{Library, Native, Pointer, Function}

object Main {
    trait TestLib extends Library {
        def doSum(a: Int, b: Int): Int;
        def getSumPtr(): Pointer
    }

    def main(args: Array[String]) {
        var testLib = Native.loadLibrary("testlib", classOf[TestLib]).asInstanceOf[TestLib]

        var result = testLib.doSum(1, 2)
        println("Result: " + result)

        var fptr = testLib.getSumPtr()
        println("Got pointer to function (1): " + fptr)

        var function = Function.getFunction(fptr /*, Function.C_CONVENTION*/)
        println("Got pointer to function (2): " + function)

        var resultFromPtr = function.invoke(classOf[Int], Array[Object](new Integer(1), new Integer(2)))
        println("Result from pointer: " + resultFromPtr)
    }
}
