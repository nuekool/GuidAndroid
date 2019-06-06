package com.nk.guidandroid.cla;

import java.util.Stack;

public class QueueWithStack {

    private Stack<Object> inStack = new Stack<>();
    private Stack<Object> outStack = new Stack<>();

    //1, 2, 3, 4, 5
    public void in(Object obj){
        inStack.push(obj);
        outStack.clear();
    }

    public Object out(){
        Object obj;
        if (!outStack.isEmpty()){
            obj = outStack.pop();
        }else {
            if (inStack.isEmpty()){
                obj = null;
            }else {
                while (!inStack.isEmpty()){
                    outStack.push(inStack.pop());
                }
                obj = outStack.pop();
            }
        }
        return obj;
    }
}
