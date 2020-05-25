## findFirstGreater方法解析
先看方法的3个参数
1. data 要查找的数据
2. @param current 查询的起始节点
3. @param level 要查找的层数
所以该方法的作用是：在第level层，查找第一个大于(不包含等于)data的节点的前一个节点
为什么是前一个节点呢？ 学过单链表插入的同学都知道。。。
```java
Node nextDoor = current.boyNextDoor(level);
// 现在的情况是current在后，nextDoor在前，两个同时往右走
// 只要发现nextDoor比data大，ok，直接返回current，在上一层方法中让current走到下一层
while (nextDoor != null) {
    if (data < nextDoor.data) {
        break;
    }
    // 往前走一个
    current = nextDoor;
    nextDoor = current.boyNextDoor(level); // 或者nextDoor.boyNextDoor(level)
}
// 需要判断current==null吗？ 不需要，当前层没有比data大的，但是下一层可能有
return current;
```
查找过程
我们的起始节点current假设是head，先获取head的下一个节点nextDoor，如果nextDoor<=参数data，
current和nextDoor都往后走一个，只到nextDoor为null，只要循环中发现了比data大的节点，就跳出循环，
当前的current节点就是我们要找的节点：第一个大于(不包含等于)data的节点的前一个节点
这个节点不论在查找，删除，插入中都起到了关键作用

## 插入
跳表的插入分以下几个步骤
1. 查询是否已存在
2. 随机要插入的层数k
3. 从k层开始从上往下插入，直到第0层

### 查询是否已存在
依赖于查询方法，如果查询到了节点，并且节点值等于要插入的值，就不用往下进行了，直接返回

### 随机要插入的层数k
直接从redis源码中复制了一份，随机范围为1到MAX_LEVEL，但是层数从0开始，所以要对结果-1
```java
int randomLevel() {
    // the following implementation is basically as same as Redis ZSET implementation
    // see https://github.com/antirez/redis/blob/4.0/src/t_zset.c
    int newLevel = 1;
    while ((random.nextInt() & 0xFFFF) < (0xFFFF >> 2)) {
        newLevel++;
    }
    return (newLevel < MAX_LEVEL) ? newLevel : MAX_LEVEL;
}
```

### 插入
在每一层一次插入
```java
Node current = head;
while (level >= 0) {
    current = findFirstGreater(data, head, level);
    Node nextDoor = current.boyNextDoor(level);
    newNode.forwards[level] = nextDoor;
    current.forwards[level] = newNode;
    level--;
}
```

## 查找
同样依赖于findFirstGreater方法，加入我们要查找10，那么findFirstGreater返回的节点<=10，
如果小于10好说，按照正常的逻辑往下走，等于10呢？只要不是最后一层，就继续往下一层找，直到找到
第0层的10

## 删除