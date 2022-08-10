package day4;

class MyHashMap
{   myListNode[] nodes = new myListNode[1000];
    public int get(int key)
    {
        int index = getIndex(key);
        myListNode prev = findElement(index, key);
        return prev.next == null ? -1 : prev.next.val;
    }
    public void put(int key, int value)
    {
        int index = getIndex(key);
        myListNode prev = findElement(index, key);
        if (prev.next == null)
            prev.next = new myListNode(key, value);
        else
            prev.next.val = value;
    }
    public void remove(int key)
    {
        int index = getIndex(key);
        myListNode prev = findElement(index, key);
        if(prev.next != null)
            prev.next = prev.next.next;
    }
    private int getIndex(int key)
    {
        return Integer.hashCode(key) % nodes.length;
    }
    private myListNode findElement(int index, int key)
    {   if(nodes[index] == null)
            return nodes[index] = new myListNode(-1, -1);
        myListNode prev = nodes[index];
        while(prev.next != null && prev.next.key != key)
        {prev = prev.next;}
        return prev;
    }
}
class myListNode
{   int key, val;
    myListNode next;
    myListNode(int key, int val)
    {
        this.key = key;
        this.val = val;
    }
}