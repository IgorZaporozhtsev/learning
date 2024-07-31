package bobocode.online_traning_1_task_2

fun main() {
    //val findMin = findMin(listOf(1334, 322, 379, 4256, 5461, 356, 756, 815, 973))
    //println(findMin)

    val nums = listOf(1334, 322, 379, 4256, 5461, 356, 756, 815, 973)

    println(nums.min())  // return 322 - працює тільки з типами Int, Long, Boolean ...
    val people = listOf(Person("Alice", 30), Person("Bob", 25), Person("Charlie", 35))

    val personMinBy = people.minBy { it.age } //return Person(name=Bob, age=25)
    println(personMinBy)
    val personMinOf = people.minOf { it.age } //return 25
    println(personMinOf)

}




data class Person(val name: String, val age: Int)


