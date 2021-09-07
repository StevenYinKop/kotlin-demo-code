package cc.stevenyin.design_pattern

import kotlin.random.Random

class _01_07_LawofDemeter {
    class Wizard {
        val rand: Random = Random(System.currentTimeMillis())

        fun first(): Int {
            println("执行第一步...")
            return rand.nextInt(100)
        }

        fun second(): Int {
            println("执行第二步...")
            return rand.nextInt(100)
        }

        fun third(): Int {
            println("执行第三步...")
            return rand.nextInt(100)
        }

        fun installWizard(wizard: Wizard) {
            val first = wizard.first()
            if (first > 50) {
                val second = wizard.second()
                if (second > 50) {
                    val third = wizard.third()
                    if (third > 50) {
                        wizard.first()
                    }
                }
            }
        }
    }

    class InstallSoftware {
        fun installWizard(wizard: Wizard) = wizard.installWizard(wizard)
    }
}

fun main() {
    val invoker = _01_07_LawofDemeter.InstallSoftware()
    invoker.installWizard(_01_07_LawofDemeter.Wizard())
}