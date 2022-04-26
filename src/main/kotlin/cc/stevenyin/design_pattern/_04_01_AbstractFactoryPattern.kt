package cc.stevenyin.design_pattern

class _04_01_AbstractFactoryPattern {
    interface IPcFactory {
        fun createKeyboard(): IKeyboard;
        fun createMouse(): IMouse;
        fun createSpeaker(): ISpeaker;
    }

    interface IKeyboard
    class MagicKeyboard : IKeyboard
    class GoogleKeyboard : IKeyboard

    interface IMouse
    class MagicTrackpad : IMouse
    class GoogleTouchpad : IMouse

    interface ISpeaker
    class HomePod : ISpeaker
    class NestAudio : ISpeaker

    class MacbookFactory : IPcFactory {
        override fun createKeyboard() = MagicKeyboard()
        override fun createMouse() = MagicTrackpad()
        override fun createSpeaker() = HomePod()
    }

    class ChromebookFactory : IPcFactory {
        override fun createKeyboard() = GoogleKeyboard()
        override fun createMouse() = GoogleTouchpad()
        override fun createSpeaker() = NestAudio()
    }
}

fun main() {
    val pcFactory01 = _04_01_AbstractFactoryPattern.ChromebookFactory()
    val pcFactory02 = _04_01_AbstractFactoryPattern.MacbookFactory()
    println(pcFactory01.createKeyboard())
    println(pcFactory01.createMouse())
    println(pcFactory01.createSpeaker())
    println(pcFactory02.createKeyboard())
    println(pcFactory02.createMouse())
    println(pcFactory02.createSpeaker())
}