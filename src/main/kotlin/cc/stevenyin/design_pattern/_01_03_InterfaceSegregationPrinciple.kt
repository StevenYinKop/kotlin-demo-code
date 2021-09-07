package cc.stevenyin.design_pattern

class _01_03_InterfaceSegregationPrinciple {
}


interface I1 {
    fun method1();
}

interface I2 {
    fun method2();
    fun method3();
}

interface I3 {
    fun method4();
    fun method5();
}

class A1 {
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

class B1 : I1, I2 {
    override fun method1() {
        println("类B实现接口I1的方法1");
    }

    override fun method2() {
        println("类B实现接口I2的方法2");
    }

    override fun method3() {
        println("类B实现接口I2的方法3");
    }
}

class C1 {
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

class D1 : I1, I3 {
    override fun method1() {
        println("类D实现接口I1的方法1");
    }

    override fun method4() {
        println("类D实现接口I3的方法4");
    }

    override fun method5() {
        println("类D实现接口I3的方法5");
    }
}