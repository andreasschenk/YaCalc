package at.schenk.yacalc.model

import android.util.Log

class Calculator(var op1:Int=0, var op2:Int=0, var op: Operator = Operator.NONE) {
    fun setDigit(digit:Int) : Unit {
        if (op == Operator.NONE)
            op1 = 10*op1+digit;
        else
            op2 = 10*op2+digit;
        Log.d("calc","--++>> $op1 $op2 ${op.str}")

    }
    fun reset(){
        op1 = 0
        op2 = 0
        op = Operator.NONE
    }
    fun getResult() : Int {
        var res:Int = when(op){
            Operator.ADD -> op1+op2
            Operator.SUB -> op1-op2
            Operator.MUL -> op1*op2
            Operator.DIV -> op1/op2
            else -> 0
        };
        op1 = res
        op2 = 0
        op = Operator.NONE
        return res;
    }
}