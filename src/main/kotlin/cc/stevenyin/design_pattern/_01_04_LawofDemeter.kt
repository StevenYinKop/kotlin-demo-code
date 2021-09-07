package cc.stevenyin.design_pattern

class _01_04_LawofDemeter {
    class Teacher(val students: List<Student>) {
        fun command(leader: Leader) {
            println("共有${leader.count(students)}名学生")
        }
    }

    class Leader {
        fun count(students: List<Student>) = students.size
    }

    class Student
}

fun main() {
    val students = List(20) { _01_04_LawofDemeter.Student() }
    val teacher = _01_04_LawofDemeter.Teacher(students)
    val leader = _01_04_LawofDemeter.Leader()
    teacher.command(leader)
}