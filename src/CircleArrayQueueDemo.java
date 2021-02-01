import java.util.Scanner;

/**
 * 环形队列 思路： 1.front变量指向队列第一个元素(arr[front]就是队列第一个元素, front的初始值为0)
 * 2.rear变量指向队列的最后一个元素的后一个位置(空出一个空间作为约定, rear初始值为0) 3.队列满的条件: (rear+1) % maxSize
 * == front 4.队列空的条件: rear == front 5.队列有效数据个数: (rear+maxSize-front)%maxSize
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        // 测试
        // 测试
        // 创建队列
        CircleArrayQueue arrayQueue = new CircleArrayQueue(4);  // 有效数据为3，留空做约定
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

// 编写一个CircleArrayQueue类
class CircleArrayQueue{
    private int maxSize;    // 数组的最大容量
    private int front;       // 指向队列第一个元素
    private int rear;       // 指向队列的最后一个元素的后一个位置
    private int[] arr;      // 存放数据，模拟队列


    /**
     * 构造器（创建队列）
     */ 
    public CircleArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0; 
        rear = 0;      
    }

    /**
     * 判断队列是否已满
     */
    public boolean isFull(){
        return (rear+1)%maxSize == front;
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
        arr[rear] = n;
        // 指向后移
        rear = (rear+1) % maxSize;
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
        // 1.先把front对应的值保留到临时变量
        int data = arr[front];
        // 2.将front后移
        front = (front+1) % maxSize;
        // 3.将临时变量的值返回
        return data;
    }

    /**
     * 显示队列所有数据
     */
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空");
            return;
        }
        // 从front开始遍历，遍历几个元素

        for(int i=front;i<front+size();i++){
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
        }
    }


    /**
     * 当前队列有效数据量
     */
    public int size(){
        return (rear+maxSize-front)%maxSize;
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
        return arr[front];
    }   

}