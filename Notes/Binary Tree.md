
![[BinaryTree.excalidraw]]
# Trees

## A binary tree is either a leaf node or an internal node (the root) and one/two binary trees(left subtree and/ or the right subtree)
#### Non-linear data structure
#### collection of nodes 
#### This is exactly one path between two nodes
#omplete binary tree
####at level i, there are 2^i no of nodes means all has level has 0 ot 2^i nodes

in a omplete binary tree what is the total number of nodes with height h 

total number of leaf nodes =2^h
total number of internal nodes =(2^h) - 1
so total is 2^(h+1)-1
```java
static TreeNode create(){
	int data;
	System.out.println("Enter the data ");
	data=in.nextInt();
	if(data==-1)
	{
		return null;
	}
	
	TreeNode node=new TreeNode(data);
	System.out.println("Enter the left node val");
	node.left=create();
	System.out.println("Enter the right node val");
	node.right=create();

	return node;
}
```

# Binary Tree (DFS)
## **In-order Traversal (left root right)** 
![[Traversal 2026-01-07 03.23.24.excalidraw]]
first go to left most then add root then go to right, so
4,2,8,5,1,6,3,9,7,10

``` java
void inorder(Node root)
{
	if(root==null) 
		return;
		
	inorder(root.left);
	System.out.println(root.data+" ");
	inorder(root.right);
}
```

## **Pre-Order Traversal (Root Left Right)**

![[Traversal 2026-01-07 03.23.24.excalidraw]]

Firstly add the root the go to the left tree and finally add right tree
1,2,4,5,8,3,6,7,9,10

``` java
void preorder(Node root)
{
	if(root==null)
	{
		return;
	}
	
	System.out.print(root.data+" ");
	preorder(root.left);
	preorder(root.right);
}
```
## 🔁 What operations can Deque do?

| Operation       | Meaning           |
| --------------- | ----------------- |
| `addFirst(x)`   | insert at front   |
| `addLast(x)`    | insert at back    |
| `removeFirst()` | remove from front |
| `removeLast()`  | remove from back  |
| `peekFirst()`   | see front         |
| `peekLast()`    | see back          |

``` java
public List<Integer> preorderTraversal(TreeNode root)
{
	List<Integer> ans=new ArrayList<>();
	if(root==null) return ans;
	
	Deque<TreeNode> stack=new ArrayDeque<>();
	stack.push(root);
	
	while(!stack.isEmpty())
	{
		TreeNode curr=stack.pop();
		if(curr.right!=null)
			stack.push(curr.right);
		if(curr.left!=null)
			stack.push(curr.left);
		ans.add(curr.val);
	}
	return ans;
}
```


## **Post Order Traversal (Left Right Root)**

![[Traversal 2026-01-07 03.23.24.excalidraw]]

First go to left tree then add the right tree finally add the root 
4,8,5,2,6,9,10,7,3,1

```java
void postOrder(Node root)
{
	if(root==null)
	{
		return;
	}
	
	postOrder(root.left);
	postOrder(root.right);
	System.out.print(root.data+" ");
}
```



# Binary Tree (BFS)
![[Traversal 2026-01-07 03.23.24.excalidraw]]
LEVEL wise traversal 

1,2,3,4,5,6,7,8,9,10
[1][2,3][4,5,6,7][8,9,10]

**## 🔄 Related Queue Methods (You MUST know)

| Method      | Meaning                     |
| ----------- | --------------------------- |
| `offer(x)`  | Insert element              |
| `poll()`    | Remove & return front       |
| `peek()`    | Return front (don’t remove) |
| `isEmpty()` | Check empty                 |

``` java
public List<List<Integer>> levelOrder(TreeNode root)
{
	List<List<Integer>> result=new ArrayList<>();
	if(root==null) return result;
	
	Queue<TreeNode> queue=new LinkedList<>();
	queue.offer(root);
	
	while(!queue.isEmpty())
	{
		int size=queue.size();
		List<Integer> level=new ArrayList<>();
		
		for(int i=0;i<size;i++)
		{
			TreeNode curr=queue.poll();
			level.add(curr);
			
			if(curr.left!=null)
				queue.offer(curr.left);
			if(curr.right!=null)
				queue.offer(curr.right);
		}
		
		result.add(level);
	}
	return result;
}
```


