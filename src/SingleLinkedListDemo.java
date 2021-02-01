/**
 * 带头结点的单链表
 * 案例：水浒传排名（不考虑排名顺序）
 */

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        // 测试
        // 创建节点
        HeroNode node1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode node2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode node3 = new HeroNode(3, "吴用", "智多星");
        HeroNode node4 = new HeroNode(4, "林冲", "豹子头");
        // 将节点加入链表 方式一
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        // singleLinkedList.add(node1);
        // singleLinkedList.add(node2);
        // singleLinkedList.add(node3);
        // singleLinkedList.add(node4);
        // 将节点加入链表 方式二
        singleLinkedList.addByOrder(node1);
        singleLinkedList.addByOrder(node4);
        singleLinkedList.addByOrder(node2);
        singleLinkedList.addByOrder(node3);
        singleLinkedList.addByOrder(node3);
        // 打印链表
        singleLinkedList.list();
    }
}

/**
 * 定义单链表，管理HeroNode
 */
class SingleLinkedList{
    // 初始化头结点
    private HeroNode head = new HeroNode(0,"","");
    /**
     * 添加节点
     * 思路：
     * 1.找到当前链表的最后一个节点
     * 2.将该节点指向新的节点
     * @param heroNode 新节点
     */
    public void add(HeroNode heroNode){
        // 创建辅助节点，初始指向头结点
        HeroNode temp = head;   // 
        // 遍历链表，找到最后的节点
        while (true) {
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        // 退出循环后，temp指向为链表的最后节点，将其指向新节点
        temp.next = heroNode;
    }

    /**
     * 第二种添加方式：根据排名将其插入合适位置
     * 如果添加失败则提示失败
     *  */ 
    public void addByOrder(HeroNode heroNode){
        HeroNode temp = head;
        boolean flag = false;   // 标识添加的编号是否存在
        while(true){
            // temp到达链表尾部
            if(temp.next == null){
                break;
            }
            // 找到位置，在temp后插入
            if(temp.next.no>heroNode.no){
                break;
            }else if(temp.next.no == heroNode.no){
                // 编号已存在
                flag = true;
                break;
            }
            temp = temp.next;   // 向后移动
        }
        if(flag){
            System.out.printf("插入失败，编号%d已存在\n",heroNode.no);
        }else{
            // 插入节点
            heroNode.next = temp.next;
            temp.next = heroNode;
        }

    }

    /**
     * 打印链表（遍历）
     */
    public void list(){
        // 判断链表是否为空
        if(head.next == null){
            System.out.println("警告：链表为空");
        }
        // 创建辅助节点
        HeroNode temp = head.next;
        // 遍历
        while (true) {
            System.out.println(temp);
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
    }
}


/**
 * 定义HeroNode类，每个对象就是一个节点
 */
class HeroNode{
    public int no;          // 排名
    public String name;     // 姓名
    public String nickname; // 称号
    public HeroNode next;   // 指向下一个节点
    /** 构造器 */
    public HeroNode(int hNo,String hName,String hNickname){
        no = hNo;
        name = hName;
        nickname = hNickname;
    }


    /** 打印信息 */
    @Override
    public String toString(){
        return "HeroNode [no="+no+",name="+name+",nickname="+nickname+"]";
    }

    
}
