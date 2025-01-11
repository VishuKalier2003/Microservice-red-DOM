package site.treedom.Service;

import java.util.LinkedList;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import site.treedom.Model.NodeDOM;
import site.treedom.Model.NodeDOM.Node;
import site.treedom.Repository.TreeRepo;

@Service
public class Deletion {
    @Autowired
    private TreeRepo treeRepo;

    public String deleteNode(String dataKey) {
        NodeDOM treeNodeDOM = treeRepo.findById("DOM").orElse(null);
        Queue<Node> queue = new LinkedList<>();
        queue.add(treeNodeDOM.getHead());
        return deleteBfsOneNode(queue, treeNodeDOM, dataKey);
    }

    public String clearAllNodes() {
        NodeDOM treeNodeDOM = treeRepo.findById("DOM").orElse(null);
        Queue<Node> queue = new LinkedList<>();
        queue.add(treeNodeDOM.getHead());
        deleteBfs(queue, treeNodeDOM);
        treeNodeDOM.setHead(null);
        treeRepo.save(treeNodeDOM);
        return "All cleared";
    }

    // Imp- Helper Functions

    public void deleteBfs(Queue<Node> queue, NodeDOM treeNodeDOM) {
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node != null) {
                    queue.add(node.getPrimaryChild());
                    node.setStore(null);
                    for (Node secondary : node.getSecondaryChildren())
                        queue.add(secondary);
                    node = null;
                }
            }
        }
    }

    public String deleteBfsOneNode(Queue<Node> queue, NodeDOM treeNodeDOM, String dataKey) {
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node != null) {
                    System.out.println("Node found : "+node.getStore().getDataKey());
                    if (node.getPrimaryChild() != null
                            && node.getPrimaryChild().getStore().getDataKey().equals(dataKey)) {
                        node.setPrimaryChild(node.getPrimaryChild().getPrimaryChild());
                        treeRepo.save(treeNodeDOM);
                        return "Node Deleted";
                    } else if (node.getPrimaryChild() == null && node.getStore().getDataKey().equals(dataKey)) {
                        node.setPrimaryChild(null);
                        treeRepo.save(treeNodeDOM);
                        return "Node Deleted from leaf";
                    }
                    queue.add(node.getPrimaryChild());
                    for (Node secondary : node.getSecondaryChildren())
                        queue.add(secondary);
                }
            }
        }
        return "Node was not found as Primary Node";
    }
}
