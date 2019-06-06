package com.nk.guidandroid.cla;

import java.util.HashSet;
import java.util.Stack;

public class Node {
    int data;
    Node next;

    public Node(int data){
        this.data = data;
    }

    public boolean hasNext(){
        if (next != null){
            return true;
        }
        return false;
    }

    public void print(){
        int i = 0;
        Node currentNode = this;
        while (currentNode != null){
            StringBuffer sb = new StringBuffer("node");
            sb.append(i);
            sb.append("：");
            sb.append("data = ");
            sb.append(currentNode.data);
            System.out.println(sb.toString());

            currentNode = currentNode.next;
            i++;
        }
    }

    public static void initNode(){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(1);
        n2.next = n3;
        n1.next = n2;

        Node n21 = new Node(2);
        Node n22 = new Node(4);
        Node n23 = new Node(8);
        n22.next = n23;
        n21.next = n22;

       /* Node cn = deleteNodeByValue(n1, 2);
        cn.print();*/
//       remove(n1);
//        Node cn = add(n1, n21);
//        cn.print();
        System.out.println(isPaild(n1));
    }

    /**
     * 删除链表的指定节点
     * @param head
     * @param node
     * @return
     */
    public static Node deleteNodeByNode(Node head, Node node){
        Node n = head;
        //头节点
        if (head == node){
            n = node.next;
        }else
            //尾节点
            if (!node.hasNext()){
                while (head.next != node){
                    head = head.next;
                }
                head.next = null;
            } else {
                //普通节点
                Node q = node.next;
                node.data = q.data;
                node.next = q.next;
            }
        return n;
    }

    /**
     * 删除链表指定数值的节点
     * @param head
     * @param value
     * @return
     */
    public static Node deleteNodeByValue(Node head, int value){
        Node n = head;
        //头节点
        if (head.data == value){
            n = head.next;
        }else{
            while (head.next.data != value){
                head = head.next;
            }
            //尾节点
            if (head.next.next == null){
                head.next = null;
            }else {
                //普通节点
                Node q = head.next.next;
                head.next = q;
            }
        }
        return n;
    }

    /**
     * 通过栈删除链表指定数值的节点
     * @param head
     * @param value
     * @return
     */
    public static Node deleteNodeByValue2(Node head, int value){
        Stack<Node> stack = new Stack<>();
        while (head != null){
            if (head.data != value){
                stack.push(head);
            }
            head = head.next;
        }
        while (!stack.empty()){
            stack.peek().next = head;
            head = stack.pop();
        }
        return head;
    }

    /**
     * 删除重复节点
     * @param node
     */
    public static void remove(Node node){
        if (node == null){
            return;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        Node pre = node;
        Node cur = node.next;
        hashSet.add(node.data);
        while(cur != null){
            if (hashSet.contains(cur.data)){
                pre.next = cur.next;
            }else {
                hashSet.add(cur.data);
                pre = cur;
            }
            cur = cur.next;
        }
    }

    /**
     * 链表相加
     * @param node1
     * @param node2
     * @return
     */
    private static Node add(Node node1, Node node2){
        Node node = new Node(0);
        Node pNode = node;
        int sum = 0;
        while(node1 != null || node2 != null || sum != 0){
            if (node1 != null){
                sum += node1.data;
                node1 = node1.next;
            }
            if (node2 != null){
                sum += node2.data;
                node2 = node2.next;
            }
            pNode.next = new Node(sum % 10);
            sum = sum/ 10;
            pNode = pNode.next;
        }
        return node.next;
    }

    /**
     * 链表是否为回文结构
     * @param head
     * @return
     */
    public static boolean isPaild(Node head){
        boolean b = true;
        Node node = head;
        Stack<Node> stack = new Stack<>();
        while (node != null){
            stack.push(node);
            node = node.next;
        }
        while (!stack.isEmpty()){
            Node n = stack.pop();
            if (n.data != head.data){
                return false;
            }
            head = head.next;
        }
        return b;
    }

    /**
     * 删除链表的倒数第N个节点
     * @param head
     * @param index
     * @return
     */
    public Node deleteByBackIndex(Node head, int index){
        if (index <= 0 || head == null){
            return head;
        }
        Node node = head;
        for (int i=0; i<index;  i++){
            if (node.next != null){
                node = node.next;
            }else {
                return head;
            }
        }
        Node cn = head;
        while (node.next != null){
            node = node.next;
            cn = cn.next;
        }
        cn.next = cn.next.next;
        return head;
    }
}
