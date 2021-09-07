package cc.stevenyin.actioninkotlin.chapter02._02_17

interface Expr

class Num(val value: Int): Expr
class Sum(val left: Expr, val right: Expr): Expr
