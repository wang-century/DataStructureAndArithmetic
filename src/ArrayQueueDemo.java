import java.util.Scanner;

/**
 * 队列（数组实现）
 */


public class ArrayQueueDemo{
    public static void main(String[] args) {
        // 测试
        // 创建队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';  // 接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        // 输出菜单
        while(loop){
            System.out.println("s(show):显示队列");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头部数据");
            System.out.println("e(exit):退出程序");
            key = scanner.next().charAt(0); // 接收一个字符
            int data;   // 获取结果
            switch(key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.print("请输入:");
                    int value = scanner.nextInt();
                    arrayQueue.push(value);
                    break;
                case 'g':
                    try{
                        data = arrayQueue.pop();
                        System.out.println("取出数据:"+data);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    data = arrayQueue.queueHead();
                    System.out.println("头部数据:"+data);
                    break;
                case 'e':
                    return;
                default:
                    System.out.println("输入错误");
                    break;
            }
        }
        
    }
}


// 编写一个ArrayQueue类
class ArrayQueue{
    private int maxSize;    // 数组的最大容量
    private int front;       // 队列头
    private int rear;       // 队列尾
    private int[] arr;      // 存放数据，模拟队列


    /**
     * 构造器（创建队列）
     */ 
    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;     // 指向队列头部（前一个位置）
        rear = -1;      // 指向队列尾部
    }

    /**
     * 判断队列是否已满
     */
    public boolean isFull(){
        return rear == maxSize - 1;
    }

    /**
     * 判断队列是否为空
     */
    public boolean isEmpty(){
        return rear == front;
    }

    /**
     * 向队列添加数据
     */
    public boolean push(int n){
        // 判断队列是否已满
        if(isFull()){
            System.out.println("队列已满！无法添加数据");
            return false;
        }
        rear++;     // 指向后移
        arr[rear] = n;
        return true;
    }

    /**
     * 从队列获取数据（出队列）
     */
    public int pop(){
        // 判断队列是否为空
        if(isEmpty()){
            // 抛出异常
            throw new RuntimeException("队列为空，无法获取数据");
        }
        front++;    // 指向后移
        return arr[front];
    }

    /**
     * 显示队列所有数据
     */
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空");
            return;
        }
        for(int i=0;i<arr.length;i++){
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    /**
     * 显示队列头部数据
     */
    public int queueHead(){
        // 判断队列是否为空
        if(isEmpty()){
            // 抛出异常
            throw new RuntimeException("队列为空，无法获取数据");
        }
        return arr[front+1];
    }   

}