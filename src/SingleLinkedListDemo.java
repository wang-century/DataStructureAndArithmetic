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
        // 修改节点
        HeroNode newHeroNode = new HeroNode(2, "小卢", "麒麟");
        singleLinkedList.update(newHeroNode);
        // 删除节点
        singleLinkedList.delete(3);
        // 查找节点
        HeroNode findNode = singleLinkedList.find(2);
        System.out.println("找到节点:"+findNode);
        // 打印链表
        singleLinkedList.list();
        // 链表长度
        System.out.println("链表长度:"+singleLinkedList.getLength());
        // 获取链表的倒数第index个节点
        System.out.println("倒数第二个节点是:"+singleLinkedList.findLastIndexNode(2));
        // 链表逆转
        singleLinkedList.reverse();
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
     * 链表逆转
     * 思路：
     * 1.创建一个节点作为逆转后节点的节点头
     * 2.遍历当前节点，每次都将节点放到逆转节点节点头的后面
     * 3.将逆转后节点的节点头赋给当前节点的节点头
     */
    public void reverse(){
        // 判断是否为空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        // 创建逆转节点头
        HeroNode reverseHead = new HeroNode(0,"","");
        HeroNode temp = head.next;
        HeroNode data;
        reverseHead.next = temp;    // 第一个节点
        temp = temp.next;
        int count = 0;
        // 遍历当前节点
        while(true){
            data = temp;
            temp = temp.next;
            System.out.println(count++);
            data.next = reverseHead.next;
            reverseHead.next = data;
            if(temp.next==null){
                break;
            }
        }
        head = reverseHead;

    }

    /**
     * 查找节点
     */
    public HeroNode find(int no){
        // 判断是否为空
        if(head.next == null){
            System.out.println("链表为空");
            return null;
        }
        // 找到要修改的节点（根据no）
        HeroNode temp = head.next;
        while(true){
            if(temp == null){
                return null;  // 到达链表尾部
            }
            if(temp.no == no){
                return temp;
            }
            temp = temp.next;
        }
    }


    /**
     * 修改节点
     */
    public void update(HeroNode newHeroNode){
        // 判断是否为空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        // 找到要修改的节点（根据no）
        HeroNode temp = head.next;
        boolean flag = false;
        while(true){
            if(temp == null){
                break;  // 到达链表尾部
            }
            if(temp.no == newHeroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }else{
            System.out.printf("未找到节点%d\n",newHeroNode.no);
        }
    }

    /**
     * 删除节点（根据no）
     */
    public void delete(int no){
        // 判断是否为空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        // 创建辅助节点
        HeroNode temp = head;
        boolean flag = false;
        // 找到要删除的节点并删除
        while(true){
            if(temp == null){
                break;  // 到达链表尾部
            }
            if(temp.next.no == no){
                temp.next = temp.next.next;     // 要删除的节点的前一个节点指向要删除节点的后一个节点，要删除的节点会自动被垃圾回收
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            System.out.printf("删除节点%d成功\n",no);
        }else{
            System.out.printf("未找到节点%d\n",no);
        }
    }

    /**
     * 获取链表长度（忽略头结点）
     * @return 链表长度
     */
    public int getLength(){
        // 链表为空
        if(head.next == null){
            return 0;
        }
        int length = 0;
        HeroNode temp = head.next;
        while(temp!=null){
            length++;
            temp = temp.next;
        }
        return length;
    }

    /**
     * 获取链表中倒数第index个节点
     * 思路：
     * 1.先把链表从头到尾遍历，得到总长度
     * 2.再从头开始遍历，到(总长度-index)为止
     */
    public HeroNode findLastIndexNode(int index){
        // 判断链表是否为空
        if(head.next == null){
            System.out.println("警告：链表为空");
            return null;
        }
        int size = getLength();
        if(index>size || index<=0){
            System.out.println("警告：索引错误");
            return null;
        }
        HeroNode temp = head.next;
        for(int i=0;i<getLength()-index;i++){
            temp = temp.next;
        }
        return temp;
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

