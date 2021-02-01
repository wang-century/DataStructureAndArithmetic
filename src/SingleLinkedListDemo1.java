/**
 * 带头结点的单链表
 * 案例：水浒传排名（不考虑排名顺序）
 */

public class SingleLinkedListDemo1 {
    public static void main(String[] args) {
        // 测试
        // 创建节点
        HeroNode node1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode node2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode node3 = new HeroNode(3, "吴用", "智多星");
        HeroNode node4 = new HeroNode(4, "林冲", "豹子头");
        // 将节点加入链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(node1);
        singleLinkedList.add(node2);
        singleLinkedList.add(node3);
        singleLinkedList.add(node4);
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

