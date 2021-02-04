/**
 * 单向环形链表
 */

public class JosephDemo {
    public static void main(String[] args) {
        // 测试
        // 构建环形链表
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoys(5);
        // 遍历
        circleSingleLinkedList.showBoys();
        // 测试出圈
        circleSingleLinkedList.countBoy(1, 2, 5);
    }
}


/**
 * 环形单向链表
 */
class CircleSingleLinkedList{
    private Boy first = new Boy(-1);    // 创建first节点
    
    /**
     * 添加节点，构建环形链表
     */
    public void addBoys(int nums){
        // 校验nums
        if(nums<1){
            System.out.println("nums数值错误!");
            return;
        }
        Boy cur = null; // 辅助变量
        // 构建链表
        for(int i=1;i<=nums;i++){
            // 根据编号创建节点
            Boy boy= new Boy(i);
            // 第一个节点指向自己，构成环形
            if(i==1){
                first = boy;
                first.setNext(first);
                cur = first;
            }else{
                cur.setNext(boy);
                boy.setNext(first);
                cur = boy;
            }
        }
    }


    /**
     * 遍历环形链表
     */
    public void showBoys(){
        // 判断是否为空
        if(first==null){
            System.out.println("链表为空!");
            return;
        }
        // 遍历
        Boy cur = first;
        while(true){
            System.out.println("Boy:"+cur.getNo());
            // 当到最后一个节点
            if(cur.getNext()==first){
                break;
            }
            cur = cur.getNext();    // 后移一位
        }
    }

    /**
     * 根据用户输入，计算出圈顺序
     * @param start 从第几个小孩开始数数
     * @param count 数几下
     * @param nums  初始化小孩总数
     */
    public void countBoy(int start,int count,int nums){
        // 校验数据
        if(first == null || start<1 || start>nums){
            System.out.println("参数有误!");
            return;
        }
        // 创建辅助变量
        Boy helper = first;
        // 辅助变量指向链表最后的节点
        while(true){
            if(helper.getNext()==first){
                break;
            }
            helper = helper.getNext();
        }
        // 报数前，先让first和helper移动k-1次，确保从第k个小孩开始数数
        for(int j=0;j<start-1;j++){
            first = first.getNext();
            helper = helper.getNext();
        }
        // 报数时，让first和helper同时移动m-1次，然后出圈
        // 直到只有一个节点时结束
        while(true){
            // 只有一个节点，遍历结束
            if(helper==first){
                break;
            }
            // first和helper移动
            for(int j=0;j<count-1;j++){
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.println("出圈:"+first.getNo());
            // 出圈
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后的节点："+first.getNo());
    }

}



/**
 * 该类代表节点
 */
class Boy{
    private int no;
    private Boy next;
    public Boy(int no){
        this.no = no;
    }

    /* get set 方法 */
    public int getNo(){
        return no;
    }
    public void setNo(int no){
        this.no = no;
    }
    public Boy getNext(){
        return next;
    }
    public void setNext(Boy next){
        this.next = next;
    }




}
