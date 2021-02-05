/**
 * 栈的链表实现
 */

public class LinkedListStackDemo {
    public static void main(String[] args) {
        // 测试栈的链表实现
        LinkedListStack linkedListStack = new LinkedListStack();
        // 入栈
        linkedListStack.push(2);
        linkedListStack.push(1);
        linkedListStack.push(4);
        // 显示数据(按出栈顺序)
        linkedListStack.show();
        // 出栈
        linkedListStack.pop();
        linkedListStack.pop();
        // 显示数据(按出栈顺序)
        System.out.println("出栈后：");
        linkedListStack.show();
    }
}


/**
 * 栈
 */
class LinkedListStack{
    public IntNode head = new IntNode(0);    // 头结点
    public IntNode last = head;              // 尾节点

    /**
     * 显示栈的所有数据
     */
    public void show(){
        if(head.next==null){
            System.out.println("栈为空!");
            return;
        }
        // 定位到最后一个节点
        IntNode cur = last;
        while(cur.pre!=null){
            System.out.println(cur.value);
            cur = cur.pre;
        }
    }

    /**
     * 入栈
     * @param value 值
     */
    public void push(int value){
        last.next = new IntNode(value);
        last.next.pre = last;
        last = last.next;
    }


    /**
     * 出栈
     */
    public int pop(){
        if(last==head){
            throw new RuntimeException("栈为空!");
        }
        int value = last.value;
        last = last.pre;
        last.next = null;
        return value;
    }

}

/**
 * 节点
 */
class IntNode{  
    public int value;       // 节点值
    public IntNode pre;     // 上一个节点
    public IntNode next;    // 下一个节点

    public IntNode(int value){
        this.value = value;
    }

    /** 打印信息 */
    @Override
    public String toString(){
        return "IntNode [value:"+value+"]";
    }

}

