import java.util.*
import kotlin.test.assertEquals

fun main(){
    executeTask1()
    executeTask2()
    executeTask3()
    executeTask4()
    executeTask5()
    executeTask6()
}

private fun executeTask1(){
    assertEquals(false, isPalindrome("notPalindromeText"))
    assertEquals(true, isPalindrome("aidroshaahsordia"))
}

private fun executeTask2(){
    assertEquals(4, minSplit(121))
    assertEquals(6, minSplit(87))
    assertEquals(0, minSplit(0))
    assertEquals(3, minSplit(7))
}

private fun executeTask3(){
    assertEquals(1, getMinPositiveIntegerNotPresentInArray(arrayOf(2, 3, 4)))
    assertEquals(4, getMinPositiveIntegerNotPresentInArray(arrayOf(2, 3, 1)))
    assertEquals(1, getMinPositiveIntegerNotPresentInArray(arrayOf(-2, -3, -1)))
}

private fun executeTask4(){
    assertEquals(false, isProperly("(()))"))
    assertEquals(false, isProperly("))))"))
    assertEquals(true, isProperly("(())"))
    assertEquals(false, isProperly("(()))("))
}

private fun executeTask5(){
    assertEquals(3, calculateVariationsCount(3))
    assertEquals(8, calculateVariationsCount(5))
    assertEquals(21, calculateVariationsCount(7))
}

private fun executeTask6(){
    val dataStructure = MyDataStructure()
    dataStructure.add(1);
    dataStructure.add(2);
    dataStructure.add(3);
    dataStructure.remove(20)
}

private fun isPalindrome(str : String): Boolean{
    for(i in 0..str.length/2){
        if (str[i] != str[str.length-1-i]){
            return false
        }
    }

    return true
}

private fun minSplit(_amount : Int): Int{
    var count = 0
    var amount = _amount

    while(amount > 0){
        count++
        if (amount >= 50) {
            amount -= 50
        }
        else if (amount >= 20){
            amount -= 20
        }
        else if (amount >= 10){
            amount -= 10
        }
        else if (amount >= 5){
            amount -= 5
        } else {
            amount -= 1
        }
    }

    return count
}

private fun getMinPositiveIntegerNotPresentInArray(arr: Array<Int>):Int {
    var result = 1

    while (contains(result, arr)){
        result++
    }

    return result;
}

private fun contains(item: Int, arr: Array<Int>): Boolean{
    for (i in arr){
        if (item == i) {
            return true
        }
    }

    return false
}

private fun isProperly(sequence:String):Boolean{
    var result = 0

    for(c in sequence){
        if (result < 0) {
            return false
        }
        if (c == '(') {
            result += 1
        }
        else if(c == ')') {
            result -= 1
        }
    }

    return result == 0
}

private fun calculateVariationsCount(n : Int):Int{
    var count = 0

    for(i in 0..(n+1)/2){
        count += calculateC(i,n - i)
    }

    return count
}

private fun calculateC(m:Int,total:Int):Int{
    return getFactorial(total)/(getFactorial(m)*getFactorial(total-m));
}

private fun getFactorial(num:Int):Int{
    var counter = 1

    for (i in 1..num){
        counter *= i
    }

    return counter
}

internal class MyDataStructure {
    private val arr: ArrayList<Int> = ArrayList()

    private val hashMap: HashMap<Int, Int> = HashMap()

    fun add(x: Int) {
        if (hashMap[x] != null){
            return
        }

        arr.add(x)

        hashMap[x] = arr.size
    }

    fun remove(x: Int) {
        val index = hashMap[x] ?: return

        hashMap.remove(x)

        Collections.swap(arr, index, arr.size - 1)

        arr.removeAt(arr.size - 1)

        hashMap[arr[arr.size - 1]] = index
    }
}