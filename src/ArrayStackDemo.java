

public class ArrayStackDemo{
    public static void main(String[] args) {
        // 测试栈
        // 创建栈
        ArrayStack arrayStack = new ArrayStack(4);
        // 显示栈
        arrayStack.show();
        // 入栈
        arrayStack.push(3);
        arrayStack.push(4);
        arrayStack.push(6);
        arrayStack.push(1);
        arrayStack.push(2);
        // 显示栈
        arrayStack.show();
        // 出栈
        System.out.println("出栈数据：");
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        // 显示栈
        System.out.println("出栈后的栈：");
        arrayStack.show();

    }

}


/**
 * 栈
 */
class ArrayStack{
    private int maxSize;    // 栈的大小
    private int[] stack;    // 模拟栈，用于存放数据
    private int top = -1;   // 栈顶，-1表示没有数据

    /**
     * 构造器
     * @param maxSize 栈的大小
     */
    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }


    /**
     * 判断栈是否已满
     * @return 布尔值
     */
    public boolean isFull(){
        return top == maxSize-1;
    }

    /**
     * 判断栈是否为空
     * @return 布尔值
     */
    public boolean isEmpty(){
        return top == -1;
    }

    /**
     * 入栈
     * @param value 值
     */
    public void push(int value){
        if(isFull()){
            System.out.println("栈已满! 数据: "+value+" 入栈失败.");
            return;
        }
        top++;
        stack[top] = value;
    }

    /**
     * 出栈
     * @return 值
     */
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈为空!");
        }
        return stack[top--];
    }

    /**
     * 显示栈的所有数据
     */
    public void show(){
        if(isEmpty()){
            System.out.println("栈为空!");
            return;
        }
        int cur = top;
        while(cur!=-1){
            System.out.println(stack[cur--]);
        }
    }

}