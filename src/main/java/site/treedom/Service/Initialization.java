package site.treedom.Service;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import site.treedom.Model.NodeDOM;
import site.treedom.Model.NodeDOM.Node;
import site.treedom.Repository.TreeRepo;
import site.treedom.Utility.ResponseData;

@Service
public class Initialization {
    @Autowired
    private TreeRepo treeRepo;
    @Autowired
    private Traversal traversal;

    @PostConstruct
    public void init() {
        Optional<NodeDOM> treeDOM = treeRepo.findById("DOM");
        if (treeDOM.isEmpty()) {
            NodeDOM tree = new NodeDOM();
            tree.setId("DOM");
            treeRepo.save(tree);
        }
    }

    // When current node to be added is primary node
    public String createPrimaryNode(ResponseData node) {
        NodeDOM treeDOM = treeRepo.findById("DOM").orElse(null);
        Node temp = treeDOM.getHead();
        if (temp == null) {
            treeDOM.setHead(new Node(node, true));
            treeRepo.save(treeDOM);
            return node.getDataKey();
        }
        else {
            while (temp.getPrimaryChild() != null)
                temp = temp.getPrimaryChild();
            temp.setPrimaryChild(new Node(node, true));
        }
        treeRepo.save(treeDOM);
        return node.getDataKey();
    }

    // When current node to be added is Secondary node
    public String createSecondaryNode(String dataKey, ResponseData node) {
        NodeDOM treeDOM = treeRepo.findById("DOM").orElse(null);
        Queue<Node> queue = new LinkedList<>();
        queue.add(treeDOM.getHead());
        traversal.bfs(queue, treeDOM, dataKey).getSecondaryChildren().add(new Node(node, false));
        treeRepo.save(treeDOM);
        return node.getDataKey();
    }
}
