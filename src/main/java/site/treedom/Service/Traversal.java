package site.treedom.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import site.treedom.Model.NodeDOM;
import site.treedom.Model.NodeDOM.Node;
import site.treedom.Repository.TreeRepo;
import site.treedom.Utility.DisplayNode;
import site.treedom.Utility.ResponseData;

@Service
public class Traversal {
    @Autowired
    private TreeRepo treeRepo;

    // Imp- Functions called by the Controller

    public Node searchOfTypeNode(String dataKey) {
        NodeDOM treeDOM = treeRepo.findById("DOM").orElse(null);
        Queue<Node> queue = new LinkedList<>();
        queue.add(treeDOM.getHead());
        return bfs(queue, treeDOM, dataKey);
    }

    public Node searchOfTypeNodeParent(String dataKey) {
        NodeDOM treeDOM = treeRepo.findById("DOM").orElse(null);
        Queue<Node> queue = new LinkedList<>();
        queue.add(treeDOM.getHead());
        return bfsParent(queue, treeDOM, dataKey);
    }

    public boolean searchOfTypeBoolean(String dataKey) {
        NodeDOM treeDOM = treeRepo.findById("DOM").orElse(null);
        Queue<Node> queue = new LinkedList<>();
        queue.add(treeDOM.getHead());
        return search(queue, treeDOM, dataKey);
    }

    public boolean searchOfTypeBooleanWithResponseData(ResponseData data) {
        NodeDOM treeDOM = treeRepo.findById("DOM").orElse(null);
        Queue<Node> queue = new LinkedList<>();
        queue.add(treeDOM.getHead());
        return searchByNode(queue, treeDOM, data);
    }

    public String searchOfTypeNodeGetTag(String dataKey) {
        NodeDOM treeDOM = treeRepo.findById("DOM").orElse(null);
        Queue<Node> queue = new LinkedList<>();
        queue.add(treeDOM.getHead());
        Node resultant = bfs(queue, treeDOM, dataKey);
        System.out.println(resultant);
        return resultant != null ? resultant.getStore().getTag() : null;
    }

    // Using Level order traversal to print the nodes
    public List<List<DisplayNode>> levelOrder() {
        NodeDOM treeDOM = treeRepo.findById("DOM").orElse(null);
        Queue<Node> queue = new LinkedList<>();
        queue.add(treeDOM.getHead());
        return treeBfs(queue, treeDOM);
    }

    public ResponseData searchOfTypeNodeGetResponseData(String dataKey) {
        NodeDOM treeDOM = treeRepo.findById("DOM").orElse(null);
        Queue<Node> queue = new LinkedList<>();
        queue.add(treeDOM.getHead());
        Node resultant = bfs(queue, treeDOM, dataKey);
        return resultant != null ? resultant.getStore() : null;
    }

    public boolean searchOfTypeNodeIsPrimary(String dataKey) {
        NodeDOM treeDOM = treeRepo.findById("DOM").orElse(null);
        Queue<Node> queue = new LinkedList<>();
        queue.add(treeDOM.getHead());
        Node resultant = bfs(queue, treeDOM, dataKey);
        return resultant != null ? resultant.isPrimaryNode() : false;
    }

    // Imp- Helper Functions defined

    // Searching a given node in the DOM Tree
    public Node bfs(Queue<Node> queue, NodeDOM treeDOM, String dataKey) {
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node != null) {
                    if (node.getStore().getDataKey().equals(dataKey))
                        return node;
                    queue.offer(node.getPrimaryChild());
                    for (Node secondary : node.getSecondaryChildren())
                        queue.offer(secondary);
                }
            }
        }
        return null;
    }

    // Provider parent of the node, when it is guaranteed that the node exists in the tree
    public Node bfsParent(Queue<Node> queue, NodeDOM treeDOM, String dataKey) {
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node != null) {
                    queue.offer(node.getPrimaryChild());
                    if (node.getPrimaryChild() != null && node.getPrimaryChild().getStore().getDataKey().equals(dataKey))
                        return node;
                    for (Node secondary : node.getSecondaryChildren()) {
                        queue.offer(secondary);
                        if (secondary.getStore().getDataKey().equals(dataKey))
                            return node;
                    }
                }
            }
        }
        return null;
    }

    public List<List<DisplayNode>> treeBfs(Queue<Node> queue, NodeDOM treeDOM) {
        List<List<DisplayNode>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<DisplayNode> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                if (current != null) {
                    level.add(new DisplayNode(current.getStore().getDataKey(), current.getStore().getTag(), current.isPrimaryNode()));
                    queue.add(current.getPrimaryChild());
                    for (Node secondary : current.getSecondaryChildren()) {
                        queue.add(secondary);
                    }
                }
            }
            result.add(level);
        }
        return result;
    }

    // Searching the DOM tree to return the state as either true or false
    public boolean search(Queue<Node> queue, NodeDOM treeDOM, String dataKey) {
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node != null) {
                    if (node.getStore().getDataKey().equals(dataKey))
                        return true;
                    queue.offer(node.getPrimaryChild());
                    for (Node secondary : node.getSecondaryChildren())
                        queue.offer(secondary);
                }
            }
        }
        return false;
    }

    // Searching the DOM tree to return the state as either true or false, the data searched is of type ResponseData
    public boolean searchByNode(Queue<Node> queue, NodeDOM treeDOM, ResponseData dataNode) {
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node != null) {
                    if (node.getStore().equals(dataNode))
                        return true;
                    queue.offer(node.getPrimaryChild());
                    for (Node secondary : node.getSecondaryChildren())
                        queue.offer(secondary);
                }
            }
        }
        return false;
    }
}
