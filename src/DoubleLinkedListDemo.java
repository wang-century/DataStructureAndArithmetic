/**
 * 带头结点的双向链表
 * 案例：水浒传排名
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        // 测试
        // 创建节点
        HeroNode2 node1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 node2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 node3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 node4 = new HeroNode2(4, "林冲", "豹子头");
        // 将节点加入链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        // doubleLinkedList.add(node1);
        // doubleLinkedList.add(node2);
        // doubleLinkedList.add(node3);
        // doubleLinkedList.add(node4);
        // 方法二：按顺序
        doubleLinkedList.addByOrder(node2);
        doubleLinkedList.addByOrder(node1);
        doubleLinkedList.addByOrder(node4);
        doubleLinkedList.addByOrder(node3);

        // 打印链表
        doubleLinkedList.print();
        // 删除节点
        doubleLinkedList.remove(1);
        doubleLinkedList.print();
        // 逆序打印链表
        System.out.println("逆序打印链表：");
        doubleLinkedList.reversePrint();
        // 查找节点2
        System.out.println("查找节点2结果:"+doubleLinkedList.find(2));
        // 修改节点
        HeroNode2 node5 = new HeroNode2(2, "小", "麒麟");
        doubleLinkedList.update(node5);
        doubleLinkedList.print();
    }
}

/**
 * 双向链表
 */
class DoubleLinkedList{
    HeroNode2 head = new HeroNode2(0,"","");;     // 定义头结点

    /**
     * 添加节点
     */
    public void add(HeroNode2 hero){
        // 遍历链表，找到最后的节点
        HeroNode2 cur = head;
        while(cur.next!=null){
            cur = cur.next;
        }
        // 添加节点到末尾
        cur.next = hero;
        hero.pre = cur;
    }

    /**
     * 添加节点（按顺序）
     */
    public void addByOrder(HeroNode2 heroNode){
        HeroNode2 cur = head;
        while(true){
            if(cur.next == null){
                cur.next = heroNode;
                heroNode.pre = cur; 
                return;
            }
            if(cur.next.no > heroNode.no){
                heroNode.next = cur.next;
                cur.next.pre = heroNode;
                cur.next = heroNode;
                heroNode.pre = cur;
                
                return;
            }
            cur = cur.next;
        }
    }


    /**
     * 删除节点(通过no)
     */
    public void remove(int no){
        // 如果链表为空
        if(head.next==null){
            System.out.println("链表为空，删除失败");
            return ;
        }
        // 遍历链表，查找节点是否存在
        boolean flag = false;   // 用于判断节点是否存在
        HeroNode2 cur = head.next;
        while(cur!=null){
            if(cur.no == no){
                cur.pre.next = cur.next;
                // 如果当前节点是最后一个节点，就不需要执行下面的操作
                if(cur.next!=null){
                    cur.next.pre = cur.pre;
                }
                flag = true;
                System.out.printf("删除节点%d\n",no);
            }
            cur = cur.next;
        }
        if(!flag){
            System.out.printf("未找到节点%d\n",no);
        }
    }

    /**
     * 修改节点（根据no）
     */
    public void update(HeroNode2 hero){
        // 如果链表为空
        if(head.next==null){
            System.out.println("链表为空，删除失败");
            return;
        }
        // 遍历链表，查找节点是否存在
        boolean flag = false;   // 用于判断节点是否存在
        HeroNode2 cur = head.next;
        while(cur!=null){
            if(cur.no == hero.no){
                cur.name = hero.name;
                cur.nickname = hero.nickname;
                flag = true;
                System.out.printf("修改节点%d\n",hero.no);
            }
            cur = cur.next;
        }
        if(!flag){
            System.out.printf("未找到节点%d\n",hero.no);
        }
    }


    /**
     * 查找节点
     */
    public HeroNode2 find(int no){
        // 如果链表为空
        if(head.next==null){
            System.out.println("链表为空，删除失败");
            return null;
        }
        // 遍历链表，查找节点是否存在
        HeroNode2 cur = head.next;
        while(cur!=null){
            if(cur.no == no){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }


    /**
     * 打印链表
     */
    public void print(){
        // 如果链表为空
        if(head.next==null){
            System.out.println("链表为空");
            return ;
        }
        HeroNode2 cur = head.next;
        while(cur!=null){
            System.out.println(cur);
            cur = cur.next;
        }
    }
    /**
     * 逆序打印链表
     */
    public void reversePrint(){
        // 如果链表为空
        if(head.next==null){
            System.out.println("链表为空");
            return ;
        }
        // 先找到最后的节点
        HeroNode2 cur = head;
        while(cur.next!=null){
            cur = cur.next;
        }
        // 从最后的节点开始往前打印
        while(cur.pre!=null){
            System.out.println(cur);
            cur = cur.pre;
        }
    }

}



/**
 * 定义HeroNode类，每个对象就是一个节点
 */
class HeroNode2{
    public int no;          // 排名
    public String name;     // 姓名
    public String nickname; // 称号
    public HeroNode2 next;  // 指向下一个节点
    public HeroNode2 pre;   // 指向前一个节点
    /** 构造器 */
    public HeroNode2(int hNo,String hName,String hNickname){
        no = hNo;
        name = hName;
        nickname = hNickname;
    }


    /** 打印信息 */
    @Override
    public String toString(){
        return "HeroNode2 [no="+no+",name="+name+",nickname="+nickname+"]";
    }
}