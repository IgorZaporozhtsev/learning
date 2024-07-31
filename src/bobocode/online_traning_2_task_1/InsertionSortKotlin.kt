package bobocode.online_traning_2_task_1

fun main() {
    val arrayListOf = arrayOf(6, 1, 7, 4, 2)
    insertionSort(arrayListOf)
    println(arrayListOf.contentToString())
}


fun insertionSort(array: Array<Int>){
    for(i in 1 until array.size){
        val temp = array[i]
        var j = i - 1

        while (j>=0 && array[j] > temp){
            array[j + 1] = array[j]
            j--
        }
        array[j + 1] = temp
    }
}