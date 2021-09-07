package cc.stevenyin.design_pattern

class _01_02_InterfaceSegregationPrinciple {

}

interface I {
    fun method1();
    fun method2();
    fun method3();
    fun method4();
    fun method5();
}

class A {
    fun depend1(i: I) {
        i.method1();
    }

    fun depend2(i: I) {
        i.method2();
    }

    fun depend3(i: I) {
        i.method3();
    }
}

class B : I {
    override fun method1() {
        println("类B实现接口I的方法1");
    }

    override fun method2() {
        println("类B实现接口I的方法2");
    }

    override fun method3() {
        println("类B实现接口I的方法3");
    }

    //对于类B来说，method4和method5不是必需的，但是由于接口I中有这两个方法，
    //所以在实现过程中即使这两个方法的方法体为空，也要将这两个没有作用的方法进行实现。
    override fun method4() {}
    override fun method5() {}
}

class C {
    fun depend1(i: I) {
        i.method1();
    }

    fun depend2(i: I) {
        i.method4();
    }

    fun depend3(i: I) {
        i.method5();
    }
}

class D : I {
    override fun method1() {
        println("类D实现接口I的方法1");
    }

    //对于类D来说，method2和method3不是必需的，但是由于接口A中有这两个方法，
    //所以在实现过程中即使这两个方法的方法体为空，也要将这两个没有作用的方法进行实现。
    override fun method2() {}
    override fun method3() {}

    override fun method4() {
        println("类D实现接口I的方法4");
    }

    override fun method5() {
        println("类D实现接口I的方法5");
    }
}
