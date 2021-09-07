package cc.stevenyin.design_pattern

class _01_05_LawofDemeter {
    class Teacher() {
        fun command(leader: Leader) {
            println("共有${leader.count()}名学生")
        }
    }

    class Leader(private val students: List<Student>) {
        fun count() = students.size
    }

    class Student
}

fun main() {
    val students = List(20) { _01_05_LawofDemeter.Student() }
    val teacher = _01_05_LawofDemeter.Teacher()
    val leader = _01_05_LawofDemeter.Leader(students)
    teacher.command(leader)
}